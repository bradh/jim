package net.frogmouth.rnd.jim.npif;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.DataTableParserManager;
import net.frogmouth.rnd.jim.npif.tables.Header;

public final class Reader {

    private static final int HEADER_EDITION_NUMBER_LEN = 1;
    private static final int HEADER_FLAGS_LEN = 1;
    private static final int HEADER_SEGMENT_NUMBER_LEN = 1;
    private static final int HEADER_SOURCE_ADDRESS_LEN = 1;
    private static final int HEADER_DATA_FILE_ADDRESS_LEN = 4;
    private static final int HEADER_DATA_FILE_SIZE_LEN = 4;
    private static final int HEADER_DATA_FILE_NUMBER_LEN = 4;
    private static final int HEADER_TIME_TAG_LEN = 8;
    private static final int HEADER_SYNC_TYPE_LEN = 1;
    private static final int HEADER_RESERVED_LEN = 5;
    private static final int HEADER_CYCLIC_REDUNDANCY_CHECK_LEN = 2;
    private static final int HEADER_LEN =
            HEADER_EDITION_NUMBER_LEN
                    + HEADER_FLAGS_LEN
                    + HEADER_SEGMENT_NUMBER_LEN
                    + HEADER_SOURCE_ADDRESS_LEN
                    + HEADER_DATA_FILE_ADDRESS_LEN
                    + HEADER_DATA_FILE_SIZE_LEN
                    + HEADER_DATA_FILE_NUMBER_LEN
                    + HEADER_TIME_TAG_LEN
                    + HEADER_SYNC_TYPE_LEN
                    + HEADER_RESERVED_LEN
                    + HEADER_CYCLIC_REDUNDANCY_CHECK_LEN;
    private MappedByteBuffer mappedByteBuffer;
    private final byte[] SYNC_BYTES =
            new byte[] {
                (byte) 0x0D,
                (byte) 0x79,
                (byte) 0xAB,
                (byte) 0x21,
                (byte) 0x6F,
                (byte) 0x34,
                (byte) 0x1A,
                (byte) 0x72,
                (byte) 0xB9,
                (byte) 0x1C
            };
    private final List<DataTable> dataTables = new ArrayList<>();

    public Reader(String filename) throws IOException {
        this(Paths.get(filename));
    }

    public Reader(Path nitfToRead) throws IOException {
        try (FileChannel fileChannel =
                (FileChannel)
                        Files.newByteChannel(nitfToRead, EnumSet.of(StandardOpenOption.READ))) {
            mappedByteBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        }
        int offset = 0;
        while (offset < mappedByteBuffer.limit()) {
            byte[] maybeSyncBytes = new byte[SYNC_BYTES.length];
            boolean syncFound = false;
            while (!syncFound && offset < mappedByteBuffer.limit() - SYNC_BYTES.length) {
                mappedByteBuffer.position(offset);
                mappedByteBuffer.get(maybeSyncBytes);
                if (Arrays.equals(SYNC_BYTES, maybeSyncBytes)) {
                    syncFound = true;
                    offset += SYNC_BYTES.length;
                } else {
                    offset += 1;
                }
            }
            if (!syncFound) {
                throw new IOException("Does not appear to be a valid NPIF file.");
            }
            Header header = parseHeader(offset);
            offset += HEADER_LEN;
            DataTableParser dtParser = getDataTableParser(header);
            if (dtParser != null) {
                DataTable dataTable = dtParser.parse(mappedByteBuffer, offset, header);
                dataTable.setHeader(header);
                dataTables.add(dataTable);
                System.out.println(dataTable.getName());
            }
            offset += header.getDataFileSize();
        }
    }

    private Header parseHeader(int offset) {
        Header header = new Header();
        header.setEditionNumber(mappedByteBuffer.get(offset));
        offset += HEADER_EDITION_NUMBER_LEN;
        header.setFlags(mappedByteBuffer.get(offset));
        offset += HEADER_FLAGS_LEN;
        header.setSegmentNumber(mappedByteBuffer.get(offset));
        offset += HEADER_SEGMENT_NUMBER_LEN;
        header.setSourceAddress(getUnsignedByte(offset));
        offset += HEADER_SOURCE_ADDRESS_LEN;
        header.setDataFileAddress(getUnsignedInteger(offset));
        offset += HEADER_DATA_FILE_ADDRESS_LEN;
        header.setDataFileSize(getUnsignedInteger(offset));
        offset += HEADER_DATA_FILE_SIZE_LEN;
        header.setDataFileNumber(getUnsignedInteger(offset));
        offset += HEADER_DATA_FILE_NUMBER_LEN;
        header.setTimeTag(getUnsignedLong(offset));
        offset += HEADER_TIME_TAG_LEN;
        header.setSyncType(mappedByteBuffer.get(offset));
        offset += HEADER_SYNC_TYPE_LEN;
        offset += HEADER_RESERVED_LEN;
        // TODO: validate CRC
        offset += HEADER_CYCLIC_REDUNDANCY_CHECK_LEN;
        return header;
    }

    private short getUnsignedByte(final int offset) {
        short value = (short) (mappedByteBuffer.get(offset) & 0xFF);
        return value;
    }

    private int getUnsignedInteger(final int offset) {
        return mappedByteBuffer.getInt(offset);
    }

    private long getUnsignedLong(final int offset) {
        return mappedByteBuffer.getLong(offset);
    }

    private DataTableParser getDataTableParser(Header header) {
        DataTableParser dtParser =
                DataTableParserManager.getInstance()
                        .getParser(header.getSourceAddress(), header.getDataFileAddress());
        if (dtParser == null) {
            System.out.println(
                    String.format(
                            "Need to handle: 0x%02x, 0x%08x",
                            header.getSourceAddress(), header.getDataFileAddress()));
            return null;
        } else {
            return dtParser;
        }
    }

    public List<DataTable> getTableTables() {
        return new ArrayList<>(dataTables);
    }
}
