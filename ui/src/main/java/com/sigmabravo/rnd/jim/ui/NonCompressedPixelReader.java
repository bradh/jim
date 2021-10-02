package com.sigmabravo.rnd.jim.ui;

import com.sigmabravo.rnd.jim.nitf.Reader;
import com.sigmabravo.rnd.jim.nitf.image.ImageSegmentHeader;
import com.sigmabravo.rnd.jim.nitf.image.ImageSegmentInfo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;

public class NonCompressedPixelReader implements PixelReader {

    private ImageSegmentHeader header;
    private ImageSegmentInfo imageSegmentInfo;
    private Reader reader;

    public NonCompressedPixelReader(Reader reader, int segmentNumber) {
        this.header = reader.getImageSegmentHeader(segmentNumber);
        this.imageSegmentInfo = reader.getImageSegmentInfo(segmentNumber);
        this.reader = reader;
    }

    @Override
    public int getArgb(int arg0, int arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor(int arg0, int arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T extends Buffer> void getPixels(int x, int y, int w, int h, WritablePixelFormat<T> pixelformat, T buffer, int scanlineStride) {
        // TODO: handle blocking

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
        int numBytesPerPixel = header.getNbpp() * (header.getNbpp() + 7) / 8;
        byte[] blockBytes
                = reader.getBytesAt(
                        imageSegmentInfo.getSegmentFileOffset()
                        + imageSegmentInfo.getSubheaderLength()
                        + imageSegmentInfo.getImageDataOffset(),
                        w * h * numBytesPerPixel);
        for (int r = y; r < y + h; r++) {
            for (int c = x; c < x + w; c++) {
                byte b = blockBytes[r * w + c];
                if (header.getAbpp() != 8) {
                    b = (byte) (b << (8 - header.getAbpp()));
                }
                bb.put(b);
                bb.put(b);
                bb.put(b);
                bb.put((byte) 0xFF);
            }
        }
    }

    @Override
    public void getPixels(int arg0, int arg1, int arg2, int arg3, WritablePixelFormat<ByteBuffer> arg4, byte[] arg5, int arg6, int arg7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPixels(int arg0, int arg1, int arg2, int arg3, WritablePixelFormat<IntBuffer> arg4, int[] arg5, int arg6, int arg7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PixelFormat getPixelFormat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void processRgb(ByteBuffer bb, int x, int y, int w, int h) {
        int numBytesPerPixel = header.getBandInfo().size() * ((header.getNbpp() + 7) / 8);
        int redBandIndex = header.getBandIndex("R");
        int greenBandIndex = header.getBandIndex("G");
        int blueBandIndex = header.getBandIndex("B");
        // TODO: this needs to handle blocking.
        byte[] blockBytes
                = reader.getBytesAt(
                        imageSegmentInfo.getSegmentFileOffset()
                        + imageSegmentInfo.getSubheaderLength()
                        + imageSegmentInfo.getImageDataOffset(),
                        w * h * numBytesPerPixel);
        if (header.getImode().equals("P")) {
            for (int r = y; r < y + h; r++) {
                for (int c = x; c < x + w; c++) {
                    // BGRA format
                    bb.put(blockBytes[(r * w + c) * numBytesPerPixel + blueBandIndex]);
                    bb.put(blockBytes[(r * w + c) * numBytesPerPixel + greenBandIndex]);
                    bb.put(blockBytes[(r * w + c) * numBytesPerPixel + redBandIndex]);
                    bb.put((byte) 0xFF);
                }
            }
        } else if (header.getImode().equals("R")) {
            for (int r = y; r < y + h; r++) {
                for (int c = x; c < x + w; c++) {
                    // BGRA format
                    bb.put(blockBytes[(r * 3 + blueBandIndex) * w + c]);
                    bb.put(blockBytes[(r * 3 + greenBandIndex) * w + c]);
                    bb.put(blockBytes[(r * 3 + redBandIndex) * w + c]);
                    bb.put((byte) 0xFF);
                }
            }
        } else if (header.getImode().equals("B")) {
            for (int r = y; r < y + h; r++) {
                for (int c = x; c < x + w; c++) {
                    // BGRA format
                    bb.put(blockBytes[(blueBandIndex * h * w) + r * w + c]);
                    bb.put(blockBytes[(greenBandIndex * h * w) + r * w + c]);
                    bb.put(blockBytes[(redBandIndex * h * w) + r * w + c]);
                    bb.put((byte) 0xFF);
                }
            }
        } else {
            throw new UnsupportedOperationException("Unsupported RGB IMODE " + header.getImode());
        }
    }
}
