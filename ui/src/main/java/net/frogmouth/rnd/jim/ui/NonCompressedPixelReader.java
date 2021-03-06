package net.frogmouth.rnd.jim.ui;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;
import net.frogmouth.rnd.jim.nitf.Reader;
import net.frogmouth.rnd.jim.nitf.image.ImageSegmentHeader;
import net.frogmouth.rnd.jim.nitf.image.ImageSegmentInfo;

public class NonCompressedPixelReader implements PixelReader {

    private static final int NUM_BYTES_PER_BGRA_PIXEL = 4;

    private final ImageSegmentHeader header;
    private final ImageSegmentInfo imageSegmentInfo;
    private final Reader reader;

    public NonCompressedPixelReader(Reader reader, int segmentNumber) {
        this.header = reader.getImageSegmentHeader(segmentNumber);
        this.imageSegmentInfo = reader.getImageSegmentInfo(segmentNumber);
        this.reader = reader;
    }

    @Override
    public int getArgb(int arg0, int arg1) {
        throw new UnsupportedOperationException(
                "Not supported yet."); // To change body of generated methods, choose Tools |
        // Templates.
    }

    @Override
    public Color getColor(int arg0, int arg1) {
        throw new UnsupportedOperationException(
                "Not supported yet."); // To change body of generated methods, choose Tools |
        // Templates.
    }

    @Override
    public <T extends Buffer> void getPixels(
            int x,
            int y,
            int w,
            int h,
            WritablePixelFormat<T> pixelformat,
            T buffer,
            int scanlineStride) {
        if (buffer instanceof ByteBuffer) {
            ByteBuffer bb = (ByteBuffer) buffer;
            String irep = header.getIrep().trim();
            if (irep.equals("MONO")) {
                processMono(bb, x, y, w, h);
            } else if (irep.equals("RGB") || irep.equals("MULTI")) {
                processRgb(bb, x, y, w, h);
            } else {
                throw new UnsupportedOperationException("No support for IREP: " + irep);
            }
        }
    }

    private void processMono(ByteBuffer bb, int x, int y, int w, int h) {
        int numBytesPerPixel = (header.getNbpp() + 7) / 8;
        int samplesPerInputBlock = header.getNppbh() * header.getNppbv();
        int numBytesPerInputBlock = numBytesPerPixel * samplesPerInputBlock;
        int pixelsPerRow = header.getNbpr() * header.getNppbh();
        // for (int Y = 0; Y < header.getNbpr(); Y++) {
        for (int Y = 0; Y < header.getNbpr(); Y++) {
            int pixelIndexForStartOfLeftMostBlock = samplesPerInputBlock * Y * header.getNbpr();
            // for (int X = 0; X < 1; X++) {
            for (int X = 0; X < header.getNbpc(); X++) {
                int pixelIndexHorizontalOffset = X * header.getNppbh();
                byte[] blockBytes =
                        reader.getBytesAt(
                                imageSegmentInfo.getSegmentFileOffset()
                                        + imageSegmentInfo.getSubheaderLength()
                                        + imageSegmentInfo.getImageDataOffset()
                                        + numBytesPerInputBlock * (X + Y * header.getNbpr()),
                                numBytesPerInputBlock);
                for (int r = y; r < header.getNppbv(); r++) {
                    int pixelIndexVerticalOffset = r * pixelsPerRow;
                    int pixelIndexForStartOfRow =
                            pixelIndexForStartOfLeftMostBlock
                                    + pixelIndexVerticalOffset
                                    + pixelIndexHorizontalOffset;
                    int byteOffsetForRow = NUM_BYTES_PER_BGRA_PIXEL * pixelIndexForStartOfRow;
                    bb.position(byteOffsetForRow);
                    for (int c = x; c < header.getNppbh(); c++) {
                        byte b = blockBytes[r * header.getNppbh() + c];
                        if (header.getAbpp() != 8) {
                            b = (byte) (b << (8 - header.getAbpp()));
                        }
                        // BGRA format
                        bb.put(b);
                        bb.put(b);
                        bb.put(b);
                        bb.put((byte) 0xFF);
                    }
                }
            }
        }
    }

    @Override
    public void getPixels(
            int arg0,
            int arg1,
            int arg2,
            int arg3,
            WritablePixelFormat<ByteBuffer> arg4,
            byte[] arg5,
            int arg6,
            int arg7) {
        throw new UnsupportedOperationException(
                "Not supported yet."); // To change body of generated methods, choose Tools |
        // Templates.
    }

    @Override
    public void getPixels(
            int arg0,
            int arg1,
            int arg2,
            int arg3,
            WritablePixelFormat<IntBuffer> arg4,
            int[] arg5,
            int arg6,
            int arg7) {
        throw new UnsupportedOperationException(
                "Not supported yet."); // To change body of generated methods, choose Tools |
        // Templates.
    }

    @Override
    public PixelFormat getPixelFormat() {
        throw new UnsupportedOperationException(
                "Not supported yet."); // To change body of generated methods, choose Tools |
        // Templates.
    }

    private void processRgb(ByteBuffer bb, int x, int y, int w, int h) {
        int numBytesPerPixel = header.getBandInfo().size() * ((header.getNbpp() + 7) / 8);
        int redBandIndex = header.getBandIndex("R");
        int greenBandIndex = header.getBandIndex("G");
        int blueBandIndex = header.getBandIndex("B");
        int samplesPerInputBlock = header.getNppbh() * header.getNppbv();
        int pixelsPerRow = header.getNbpr() * header.getNppbh();
        // TODO: this needs to handle masking.
        int numBytesPerSample = (header.getNbpp() + 7) / 8;
        int numBlocksPerBand = header.getNbpc() * header.getNbpr();
        int bytesPerInputBlock = samplesPerInputBlock * numBytesPerSample;
        int bandLengthInBytes = bytesPerInputBlock * numBlocksPerBand;

        if (header.getImode().equals("S")) {
            for (int Y = 0; Y < header.getNbpc(); Y++) {
                int pixelIndexForStartOfLeftMostBlock = samplesPerInputBlock * Y * header.getNbpc();
                for (int X = 0; X < header.getNbpr(); X++) {
                    int pixelIndexHorizontalOffset = X * header.getNppbh();
                    byte[] blueBlockBytes =
                            reader.getBytesAt(
                                    imageSegmentInfo.getSegmentFileOffset()
                                            + imageSegmentInfo.getSubheaderLength()
                                            + imageSegmentInfo.getImageDataOffset()
                                            + bandLengthInBytes * blueBandIndex
                                            + bytesPerInputBlock * (X + Y * header.getNbpc()),
                                    bytesPerInputBlock);
                    byte[] greenBlockBytes =
                            reader.getBytesAt(
                                    imageSegmentInfo.getSegmentFileOffset()
                                            + imageSegmentInfo.getSubheaderLength()
                                            + imageSegmentInfo.getImageDataOffset()
                                            + bandLengthInBytes * greenBandIndex
                                            + bytesPerInputBlock * (X + Y * header.getNbpc()),
                                    bytesPerInputBlock);
                    byte[] redBlockBytes =
                            reader.getBytesAt(
                                    imageSegmentInfo.getSegmentFileOffset()
                                            + imageSegmentInfo.getSubheaderLength()
                                            + imageSegmentInfo.getImageDataOffset()
                                            + bandLengthInBytes * redBandIndex
                                            + bytesPerInputBlock * (X + Y * header.getNbpc()),
                                    bytesPerInputBlock);
                    for (int r = 0; r < header.getNppbv(); r++) {
                        int pixelIndexVerticalOffset = r * pixelsPerRow;
                        int pixelIndexForStartOfRow =
                                pixelIndexForStartOfLeftMostBlock
                                        + pixelIndexVerticalOffset
                                        + pixelIndexHorizontalOffset;
                        int byteOffsetForRow = NUM_BYTES_PER_BGRA_PIXEL * pixelIndexForStartOfRow;
                        bb.position(byteOffsetForRow);
                        for (int c = x; c < header.getNppbh(); c++) {
                            // BGRA format
                            bb.put(blueBlockBytes[(r * header.getNppbh() + c)]);
                            bb.put(greenBlockBytes[(r * header.getNppbh() + c)]);
                            bb.put(redBlockBytes[(r * header.getNppbh() + c)]);
                            bb.put((byte) 0xFF);
                        }
                    }
                }
            }
        } else if (header.getImode().equals("B")
                || header.getImode().equals("P")
                || header.getImode().equals("R")) {
            int numBytesPerInputBlock = numBytesPerPixel * header.getNppbh() * header.getNppbv();
            for (int Y = 0; Y < header.getNbpc(); Y++) {
                int pixelIndexForStartOfLeftMostBlock = samplesPerInputBlock * Y * header.getNbpc();
                for (int X = 0; X < header.getNbpr(); X++) {
                    int pixelIndexHorizontalOffset = X * header.getNppbh();
                    byte[] blockBytes =
                            reader.getBytesAt(
                                    imageSegmentInfo.getSegmentFileOffset()
                                            + imageSegmentInfo.getSubheaderLength()
                                            + imageSegmentInfo.getImageDataOffset()
                                            + numBytesPerInputBlock * (X + Y * header.getNbpc()),
                                    numBytesPerInputBlock);
                    for (int r = 0; r < header.getNppbv(); r++) {
                        int pixelIndexVerticalOffset = r * pixelsPerRow;
                        int pixelIndexForStartOfRow =
                                pixelIndexForStartOfLeftMostBlock
                                        + pixelIndexVerticalOffset
                                        + pixelIndexHorizontalOffset;
                        int byteOffsetForRow = NUM_BYTES_PER_BGRA_PIXEL * pixelIndexForStartOfRow;
                        bb.position(byteOffsetForRow);
                        for (int c = x; c < header.getNppbh(); c++) {
                            // BGRA format
                            switch (header.getImode()) {
                                case "P":
                                    bb.put(
                                            blockBytes[
                                                    (r * header.getNppbh() + c) * numBytesPerPixel
                                                            + blueBandIndex]);
                                    bb.put(
                                            blockBytes[
                                                    (r * header.getNppbh() + c) * numBytesPerPixel
                                                            + greenBandIndex]);
                                    bb.put(
                                            blockBytes[
                                                    (r * header.getNppbh() + c) * numBytesPerPixel
                                                            + redBandIndex]);
                                    break;
                                case "R":
                                    bb.put(
                                            blockBytes[
                                                    ((r * numBytesPerPixel + blueBandIndex)
                                                                    * header.getNppbh()
                                                            + c)]);
                                    bb.put(
                                            blockBytes[
                                                    ((r * numBytesPerPixel + greenBandIndex)
                                                                    * header.getNppbh()
                                                            + c)]);
                                    bb.put(
                                            blockBytes[
                                                    ((r * numBytesPerPixel + redBandIndex)
                                                                    * header.getNppbh()
                                                            + c)]);
                                    break;
                                case "B":
                                    bb.put(
                                            blockBytes[
                                                    ((blueBandIndex * header.getNppbh() + r)
                                                                    * header.getNppbh()
                                                            + c)]);
                                    bb.put(
                                            blockBytes[
                                                    ((greenBandIndex * header.getNppbh() + r)
                                                                    * header.getNppbh()
                                                            + c)]);
                                    bb.put(
                                            blockBytes[
                                                    ((redBandIndex * header.getNppbh() + r)
                                                                    * header.getNppbh()
                                                            + c)]);
                                    break;
                                default:
                                    throw new UnsupportedOperationException(
                                            "Unexpected Blocked RGB IMODE " + header.getImode());
                            }
                            bb.put((byte) 0xFF);
                        }
                    }
                }
            }
        } else {
            throw new UnsupportedOperationException(
                    "Unsupported Blocked RGB / MS IMODE " + header.getImode());
        }
    }
}
