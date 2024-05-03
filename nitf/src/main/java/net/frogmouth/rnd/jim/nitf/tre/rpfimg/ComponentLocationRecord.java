package net.frogmouth.rnd.jim.nitf.tre.rpfimg;

public class ComponentLocationRecord {
    private final SectionComponentCode componentCode;
    private final int componentLength;
    private final int componentLocation;

    public ComponentLocationRecord(
            SectionComponentCode componentCode, int componentLength, int componentLocation) {
        this.componentCode = componentCode;
        this.componentLength = componentLength;
        this.componentLocation = componentLocation;
    }

    public SectionComponentCode getComponentCode() {
        return componentCode;
    }

    public int getComponentLength() {
        return componentLength;
    }

    public int getComponentLocation() {
        return componentLocation;
    }

    @Override
    public String toString() {
        return "ComponentLocationRecord{"
                + "componentCode="
                + componentCode
                + ", componentLength="
                + componentLength
                + ", componentLocation="
                + componentLocation
                + '}';
    }
}
