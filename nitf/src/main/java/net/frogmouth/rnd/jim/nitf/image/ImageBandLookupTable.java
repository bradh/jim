package net.frogmouth.rnd.jim.nitf.image;

import java.util.Arrays;

public class ImageBandLookupTable {

    private final byte[] entries;

    public ImageBandLookupTable(byte[] lutEntries) {
        this.entries = Arrays.copyOf(lutEntries, lutEntries.length);
    }

    public ImageBandLookupTable(ImageBandLookupTable other) {
        this.entries = Arrays.copyOf(other.entries, other.entries.length);
    }
}
