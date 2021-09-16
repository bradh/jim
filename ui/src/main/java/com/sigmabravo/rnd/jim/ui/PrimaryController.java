package com.sigmabravo.rnd.jim.ui;

import com.sigmabravo.rnd.jim.nitf.Reader;
import com.sigmabravo.rnd.jim.nitf.image.ImageBlockInfo;
import com.sigmabravo.rnd.jim.nitf.image.ImageSegmentHeader;
import com.sigmabravo.rnd.jim.nitf.image.ImageSegmentInfo;
import com.sigmabravo.rnd.jim.nitf.text.TextSegmentHeader;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import org.freedesktop.gstreamer.Buffer;
import org.freedesktop.gstreamer.Bus;
import org.freedesktop.gstreamer.Element;
import org.freedesktop.gstreamer.ElementFactory;
import org.freedesktop.gstreamer.Gst;
import org.freedesktop.gstreamer.GstObject;
import org.freedesktop.gstreamer.Pad;
import org.freedesktop.gstreamer.Pipeline;
import org.freedesktop.gstreamer.Version;
import org.freedesktop.gstreamer.elements.AppSrc;
import org.freedesktop.gstreamer.fx.FXImageSink;

public class PrimaryController {

    @FXML
    private MenuBar menuBar;
    @FXML
    private TreeView<String> treeView;
    @FXML
    private TextArea textArea;
    @FXML
    private BorderPane viewPane;
    
    private Pipeline pipeline;

    public PrimaryController() {
        Gst.init(new Version(1, 18), "FXPlayer");
    }

    /**
     * Handle action related to "File->Open Manifest" menu item.
     *
     * @param event Event on "Open" menu item.
     */
    @FXML
    private void openManifest(final ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Manifest");
        File file = chooser.showOpenDialog(menuBar.getScene().getWindow());
        if (file != null) {
            Reader reader = new Reader(file.getAbsolutePath());
            treeView.setRoot(null);
            TreeItem<String> fileRoot = addFileToTreeView(file, reader);
            fileRoot.setExpanded(true);
        }
    }

    /**
     * Handle action related to "File->Open Single File" menu item.
     *
     * @param event Event on "Open" menu item.
     */
    @FXML
    private void openSingleFile(final ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Single File");
        File file = chooser.showOpenDialog(menuBar.getScene().getWindow());
        if (file != null) {
            Reader reader = new Reader(file.getAbsolutePath());
            System.out.println(reader.getNumberOfImageSegments());
            System.out.println(reader.getNumberOfTextSegments());
            treeView.setRoot(null);
            TreeItem<String> fileRoot = addFileToTreeView(file, reader);
            fileRoot.setExpanded(true);
        }
    }

    private TreeItem<String> addFileToTreeView(File file, Reader reader) throws IOException {
        TreeItem<String> fileRoot = new TreeItem<>(file.getName());
        treeView.setRoot(fileRoot);
        // TODO: file header info here?
        List<TRE> tres = reader.getFileTREs();
        TreeItem<String> treRoot = new TreeItem<>("File TREs");
        fileRoot.getChildren().add(treRoot);
        for (TRE tre : tres) {
            treRoot.getChildren().add(tre.toTreeItem());
        }
        if (reader.getNumberOfImageSegments() > 0) {
            TreeItem<String> imageSegments = new TreeItem<>("Image Segments");
            fileRoot.getChildren().add(imageSegments);
            for (int i = 0; i < reader.getNumberOfImageSegments(); i++) {
                ImageSegmentHeader header = reader.getImageSegmentHeader(i);
                final ImageSegmentInfo isi = reader.getImageSegmentInfo(i);
                addImageSegmentToTreeView(header, imageSegments);
                // Pipeline pipeline = new Pipeline();
                // Element compositor = ElementFactory.make("compositor", "converter");
                StringBuilder sb = new StringBuilder();
                sb.append("compositor name=converter");
                for (ImageBlockInfo ibi : isi.getImageBlocks()) {
                    int blockIndex = ibi.getColumnIndex() + ibi.getRowIndex() * header.getNbpr();
                    sb.append(" sink_");
                    sb.append(blockIndex);
                    sb.append("::xpos=");
                    sb.append(header.getNppbv() * ibi.getColumnIndex());
                    sb.append(" sink_");
                    sb.append(blockIndex);
                    sb.append("::ypos=");
                    sb.append(header.getNppbv() * ibi.getRowIndex());
                }
                sb.append(" ! queue name=queue");
                String launchString = sb.toString();
                pipeline = (Pipeline) Gst.parseLaunch(launchString);
                FXImageSink imageSink = new FXImageSink();
                Element sink = imageSink.getSinkElement();
                Element compositor = pipeline.getElementByName("converter");
                Element queue = pipeline.getElementByName("queue");
                pipeline.add(sink);
                queue.link(sink);
                ImageView view = new ImageView();
                viewPane.setCenter(view);
                view.imageProperty().bind(imageSink.imageProperty());
                view.fitWidthProperty().bind(viewPane.widthProperty());
                view.fitHeightProperty().bind(viewPane.heightProperty());
                view.setPreserveRatio(true);

                pipeline.stop();
                for (ImageBlockInfo ibi : isi.getImageBlocks()) {
                    int blockIndex = ibi.getColumnIndex() + ibi.getRowIndex() * header.getNbpr();
                    AppSrc source = (AppSrc) ElementFactory.make("appsrc", "source" + blockIndex);
                    source.connect(new AppSrc.NEED_DATA() {
                        byte[] blockBytes
                                = reader.getBytesAt(
                                        isi.getSegmentFileOffset()
                                        + isi.getSubheaderLength()
                                        + isi.getImageDataOffset()
                                        + ibi.getBlockOffset(),
                                        ibi.getBlockLength());
                        private final ByteBuffer bb = ByteBuffer.wrap(blockBytes);

                        @Override
                        public void needData(AppSrc elem, int size) {
                            if (bb.hasRemaining()) {
                                // System.out.println("needData: size = " + size);
                                byte[] tempBuffer;
                                Buffer buf;
                                int copyLength = (bb.remaining() >= size) ? size : bb.remaining();
                                tempBuffer = new byte[copyLength];
                                buf = new Buffer(copyLength);
                                bb.get(tempBuffer);
                                // System.out.println("Temp Buffer remaining bytes: " + bb.remaining());
                                buf.map(true).put(ByteBuffer.wrap(tempBuffer));
                                elem.pushBuffer(buf);
                            } else {
                                elem.endOfStream();
                            }
                        }
                    });
                    Element parser = ElementFactory.make("h264parse", "parser" + blockIndex);
                    Element decoder = ElementFactory.make("avdec_h264", "decoder" + blockIndex);
                    pipeline.addMany(source, parser, decoder);
                    source.link(parser);
                    parser.link(decoder);
                    decoder.link(compositor);
                }
                Bus bus = pipeline.getBus();
                bus.connect((Bus.EOS) (GstObject source) -> {
                    System.out.println("Reached end of stream");
                });

                pipeline.play();
            }
        }
        if (reader.getNumberOfTextSegments() > 0) {
            TreeItem<String> textSegments = new TreeItem<>("Text Segments");
            fileRoot.getChildren().add(textSegments);
            for (int i = 0; i < reader.getNumberOfTextSegments(); i++) {
                TextSegmentHeader header = reader.getTextSegmentHeader(i);
                addTextSegmentToTreeView(header, textSegments);
            }
        }
        return fileRoot;
    }

    private void addImageSegmentToTreeView(ImageSegmentHeader header, TreeItem<String> parentItem) {
        TreeItem<String> segmentTreeItem = new TreeItem<>("[Image Segment]");
        if (!header.getIid1().isBlank()) {
            segmentTreeItem.setValue(header.getIid1());
        } else if (!header.getIid2().isBlank()) {
            segmentTreeItem.setValue(header.getIid2());
        }
        TreeItem<String> headerRoot = new TreeItem<>("Header");
        addTreeItem(headerRoot, "IID1", header.getIid1());
        addTreeItem(headerRoot, "IDATIM", header.getImageDateTime());
        addTreeItem(headerRoot, "TGTID", header.getTgtid());
        addTreeItem(headerRoot, "IID2", header.getIid2());
        addTreeItem(headerRoot, "ISORCE", header.getIsource());
        addTreeItem(headerRoot, "NROWS", header.getNrows());
        addTreeItem(headerRoot, "NCOLS", header.getNcols());
        addTreeItem(headerRoot, "PVTYPE", header.getPvtype());
        addTreeItem(headerRoot, "IREP", header.getIrep());
        addTreeItem(headerRoot, "ICAT", header.getIcat());
        addTreeItem(headerRoot, "ABPP", header.getAbpp());
        addTreeItem(headerRoot, "PJUST", header.getPjust());
        addTreeItem(headerRoot, "ICORDS", header.getIcords());
        addTreeItem(headerRoot, "IGEOLO", header.getIgeolo());
        for (int i = 0; i < header.getImageComments().size(); ++i) {
            addTreeItem(headerRoot, "ICOM" + i, header.getImageComments().get(i));
        }
        addTreeItem(headerRoot, "IC", header.getIc());
        addTreeItem(headerRoot, "COMRAT", header.getComrat());
        addTreeItem(headerRoot, "ISYNC", header.getIsync());
        addTreeItem(headerRoot, "IMODE", header.getImode());
        addTreeItem(headerRoot, "NBPR", header.getNbpr());
        addTreeItem(headerRoot, "NBPC", header.getNbpc());
        addTreeItem(headerRoot, "NPPBH", header.getNppbh());
        addTreeItem(headerRoot, "NPPBV", header.getNppbv());
        addTreeItem(headerRoot, "NBPP", header.getNbpp());
        addTreeItem(headerRoot, "IDLVL", header.getIdlvl());
        addTreeItem(headerRoot, "IALVL", header.getIalvl());
        addTreeItem(headerRoot, "ILOC", header.getIloc());
        addTreeItemAsDouble(headerRoot, "IMAG", header.getImag());
        segmentTreeItem.getChildren().add(headerRoot);
        TreeItem<String> treRoot = new TreeItem<>("TREs");
        segmentTreeItem.getChildren().add(treRoot);
        for (TRE tre : header.getTREs()) {
            treRoot.getChildren().add(tre.toTreeItem());
        }
        parentItem.getChildren().add(segmentTreeItem);

    }

    private void addTextSegmentToTreeView(TextSegmentHeader header, TreeItem<String> parentItem) {
        TreeItem<String> segmentTreeItem = new TreeItem<>(header.getId());
        if (header.getTitle().trim().length() > 0) {
            segmentTreeItem.setValue(header.getTitle().trim());
        }
        TreeItem<String> headerRoot = new TreeItem<>("Header");
        segmentTreeItem.getChildren().add(headerRoot);
        TreeItem<String> treRoot = new TreeItem<>("TREs");
        segmentTreeItem.getChildren().add(treRoot);
        parentItem.getChildren().add(segmentTreeItem);
    }

    /**
     * Handle action related to "File->Exit" menu item.
     *
     * @param event Event on "Exit" menu item.
     */
    @FXML
    private void applicationExit(final ActionEvent event) throws IOException {
        Platform.exit();
    }

    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void handleAboutAction(final ActionEvent event) {
        provideAboutFunctionality();
    }

    /**
     * Handle action related to input (in this case specifically only responds
     * to keyboard event CTRL-A).
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A) {
                provideAboutFunctionality();
            }
        }
    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality() {
        System.out.println("You clicked on About!");
    }

    @FXML
    public void initialize() {
        menuBar.setFocusTraversable(true);
    }

    private TreeItem<String> addTreeItem(TreeItem<String> parent, String label, String value) {
        TreeItem<String> treeItem = new TreeItem<>(label + ": " + value);
        parent.getChildren().add(treeItem);
        return treeItem;
    }

    private TreeItem<String> addTreeItem(TreeItem<String> parent, String label, int value) {
        TreeItem<String> treeItem = new TreeItem<>(label + ": " + value);
        parent.getChildren().add(treeItem);
        return treeItem;
    }

    private TreeItem<String> addTreeItemAsDouble(TreeItem<String> parent, String label, double value) {
        TreeItem<String> treeItem = new TreeItem<>(String.format("%s: %04f", label, value));
        parent.getChildren().add(treeItem);
        return treeItem;
    }
}
