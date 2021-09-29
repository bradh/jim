package com.sigmabravo.rnd.jim.npif.tables;

public class Header {
    private static final int AMBLE_FLAG = 0x08;
    private static final int CRC_FLAG = 0x04;
    private static final int COMPRESSION_FLAG = 0x02;
    private byte editionNumber;
    private boolean compressionFlag;
    private boolean crcFlag;
    private boolean ambleFlag;
    private short segmentNumber;
    private short sourceAddress;
    private int dataFileAddress;
    private int dataFileSize;
    private int dataFileNumber;
    private long timeTag;
    private byte syncType;

    public Header() {}

    public Header(Header that) {
        setEditionNumber(that.getEditionNumber());
        setCompressionFlag(that.isCompressionFlag());
        setCrcFlag(that.isCrcFlag());
        setAmbleFlag(that.isAmbleFlag());
        setSegmentNumber(that.getSegmentNumber());
        setSourceAddress(that.getSourceAddress());
        setDataFileAddress(that.getDataFileAddress());
        setDataFileSize(that.getDataFileSize());
        setDataFileNumber(that.getDataFileNumber());
        setTimeTag(that.getTimeTag());
        setSyncType(that.getSyncType());
    }

    public byte getEditionNumber() {
        return editionNumber;
    }

    public final void setEditionNumber(byte editionNumber) {
        this.editionNumber = editionNumber;
    }

    public boolean isCompressionFlag() {
        return compressionFlag;
    }

    public final void setCompressionFlag(boolean compressionFlag) {
        this.compressionFlag = compressionFlag;
    }

    public boolean isCrcFlag() {
        return crcFlag;
    }

    public final void setCrcFlag(boolean crcFlag) {
        this.crcFlag = crcFlag;
    }

    public boolean isAmbleFlag() {
        return ambleFlag;
    }

    public final void setAmbleFlag(boolean ambleFlag) {
        this.ambleFlag = ambleFlag;
    }

    public final void setFlags(byte flags) {
        this.ambleFlag = (flags & AMBLE_FLAG) == AMBLE_FLAG;
        this.crcFlag = (flags & CRC_FLAG) == CRC_FLAG;
        this.compressionFlag = (flags & COMPRESSION_FLAG) == COMPRESSION_FLAG;
    }

    public short getSegmentNumber() {
        return segmentNumber;
    }

    public final void setSegmentNumber(short segmentNumber) {
        this.segmentNumber = segmentNumber;
    }

    public short getSourceAddress() {
        return sourceAddress;
    }

    public final void setSourceAddress(short sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public int getDataFileAddress() {
        return dataFileAddress;
    }

    public final void setDataFileAddress(int dataFileAddress) {
        this.dataFileAddress = dataFileAddress;
    }

    public int getDataFileSize() {
        return dataFileSize;
    }

    public final void setDataFileSize(int dataFileSize) {
        this.dataFileSize = dataFileSize;
    }

    public int getDataFileNumber() {
        return dataFileNumber;
    }

    public final void setDataFileNumber(int dataFileNumber) {
        this.dataFileNumber = dataFileNumber;
    }

    public long getTimeTag() {
        return timeTag;
    }

    public final void setTimeTag(long timeTag) {
        this.timeTag = timeTag;
    }

    public byte getSyncType() {
        return syncType;
    }

    public final void setSyncType(byte syncType) {
        this.syncType = syncType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.editionNumber;
        hash = 47 * hash + (this.compressionFlag ? 1 : 0);
        hash = 47 * hash + (this.crcFlag ? 1 : 0);
        hash = 47 * hash + (this.ambleFlag ? 1 : 0);
        hash = 47 * hash + this.segmentNumber;
        hash = 47 * hash + this.sourceAddress;
        hash = 47 * hash + this.dataFileAddress;
        hash = 47 * hash + this.dataFileSize;
        hash = 47 * hash + this.dataFileNumber;
        hash = 47 * hash + (int) (this.timeTag ^ (this.timeTag >>> 32));
        hash = 47 * hash + this.syncType;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Header other = (Header) obj;
        if (this.editionNumber != other.editionNumber) {
            return false;
        }
        if (this.compressionFlag != other.compressionFlag) {
            return false;
        }
        if (this.crcFlag != other.crcFlag) {
            return false;
        }
        if (this.ambleFlag != other.ambleFlag) {
            return false;
        }
        if (this.segmentNumber != other.segmentNumber) {
            return false;
        }
        if (this.sourceAddress != other.sourceAddress) {
            return false;
        }
        if (this.dataFileAddress != other.dataFileAddress) {
            return false;
        }
        if (this.dataFileSize != other.dataFileSize) {
            return false;
        }
        if (this.dataFileNumber != other.dataFileNumber) {
            return false;
        }
        if (this.timeTag != other.timeTag) {
            return false;
        }
        if (this.syncType != other.syncType) {
            return false;
        }
        return true;
    }
}
