package com.sigmabravo.rnd.jim.ui;

import com.sigmabravo.rnd.jim.nitf.Reader;
import com.sigmabravo.rnd.jim.nitf.image.ImageSegmentHeader;
import com.sigmabravo.rnd.jim.nitf.text.TextSegmentHeader;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML
    private MenuBar menuBar;
    @FXML
    private TreeView<String> treeView;
    @FXML
    private TextArea textArea;

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

    private TreeItem<String> addFileToTreeView(File file, Reader reader) {
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
                addImageSegmentToTreeView(header, imageSegments);
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
        TreeItem<String> segmentTreeItem = new TreeItem<>(header.getIid1());
        TreeItem<String> headerRoot = new TreeItem<>("Header");
        segmentTreeItem.getChildren().add(headerRoot);
        TreeItem<String> treRoot = new TreeItem<>("TREs");
        segmentTreeItem.getChildren().add(treRoot);
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
}
