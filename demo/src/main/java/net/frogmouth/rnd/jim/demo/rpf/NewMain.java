package net.frogmouth.rnd.jim.demo.rpf;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.Reader;
import net.frogmouth.rnd.jim.nitf.image.ImageSegmentInfo;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

/** RPF parsing example. */
public class NewMain {

    /**
     * Entry point.
     *
     * @param args the command line arguments
     * @throws java.io.IOException if file parsing fails
     */
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(getRPFPath());
        boolean nitf = reader.isNITF();
        boolean nsif = reader.isNSIF();
        byte[] x = reader.getExtendedHeaderData();
        byte[] y = reader.getUserDefinedHeaderData();
        for (TaggedRecordExtension fileTRE : reader.getFileTREs()) {
            System.out.println(fileTRE);
        }
        ImageSegmentInfo im0 = reader.getImageSegmentInfo(0);
        byte[] xhd = im0.getImageSegmentHeader().getExtendedHeaderData();
        byte[] ishd = im0.getImageSegmentHeader().getUserDefinedHeaderData();
        List<TaggedRecordExtension> tres = im0.getImageSegmentHeader().getTREs();
        for (TaggedRecordExtension tre : tres) {
            System.out.println(tre.toString());
        }
    }

    private static Path getRPFPath() {
        return Paths.get("/home/bradh/Downloads/0000f716.i16");
    }
}
