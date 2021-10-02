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
        int numBytesPerPixel = (header.getNbpp() + 7) / 8;
        byte[] blockBytes
                = reader.getBytesAt(
                        imageSegmentInfo.getSegmentFileOffset()
                        + imageSegmentInfo.getSubheaderLength()
                        + imageSegmentInfo.getImageDataOffset(),
                         w * h * numBytesPerPixel);
        if (buffer instanceof ByteBuffer) {
            ByteBuffer bb = (ByteBuffer) buffer;
            for (int r = y; r < y + h; r++) {
                for (int c = x; c < x + w; c++) {
                    byte b = blockBytes[r * w + c];
                    if (header.getAbpp() != 8) {
                        b = (byte)(b << (8 - header.getAbpp()));
                    }
                    bb.put(b);
                    bb.put(b);
                    bb.put(b);
                    bb.put((byte) 0xFF);
                }
            }
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
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

}
