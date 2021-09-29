package com.sigmabravo.rnd.jim.npif;

import static org.testng.Assert.*;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import org.testng.annotations.Test;

public class ReaderTest extends TestSupport {

    public ReaderTest() {}

    @Test
    public void withSync() throws IOException {
        Reader reader = new Reader(getValidFile());
        assertNotNull(reader);
    }

    @Test(expectedExceptions = IOException.class)
    public void noSync() throws IOException {
        new Reader(getFileNoSync());
    }

    @Test
    public void withSyncOffset() throws IOException {
        Reader reader = new Reader(getValidFileSyncOffset());
        assertNotNull(reader);
    }

    @Test
    public void single() throws IOException {
        Reader reader = new Reader(getValidFileSingle());
        assertNotNull(reader);
        assertEquals(reader.getTableTables().size(), 1);
        DataTable dataTable = reader.getTableTables().get(0);
        assertEquals(dataTable.getHeader().getEditionNumber(), 3);
        assertEquals(dataTable.getHeader().isAmbleFlag(), false);
        assertEquals(dataTable.getHeader().isCompressionFlag(), false);
        assertEquals(dataTable.getHeader().isCrcFlag(), false);
        assertEquals(dataTable.getHeader().getSegmentNumber(), 1);
        assertEquals(dataTable.getHeader().getSourceAddress(), 32);
        assertEquals(dataTable.getHeader().getDataFileAddress(), 1);
        assertEquals(dataTable.getHeader().getDataFileSize(), 231);
        assertEquals(dataTable.getHeader().getDataFileNumber(), 0);
        assertEquals(dataTable.getHeader().getTimeTag(), 1);
        assertEquals(dataTable.getHeader().getSyncType(), 0);
    }
}
