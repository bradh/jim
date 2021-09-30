package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.util.ArrayList;
import java.util.List;

/*
	The JPEG 2000 Index Tables is used in conjunction with the JPEG 2000 Description Table.
	This table is only used if no JPEG 2000 Tiling has been performed.
	This table lists the byte offsets (from start of codestream) of the end of the bitstream’s portions corresponding to the successive levels of the highest order of
	progression (e.g: resolution in case of RLCP progression).
	Therefore the indexes contained in this table represent the partition of the codestream. The number of indexes depends on the depth of the highest order of
	progression. For example, if the stream has been encoded following a Layer-Resolution-Component-Position progression scheme, one should expect to find N
	indexes where N is the number of quality layers. Knowing these indexes will allow a direct progressive decoding by quality.
	JPEG 2000 Index Data Table will allow a progressive decoding by resolution in case of a RLCP progression, a progressive decoding by quality in case of a LRCP
	progression order and a progressive decoding by component in case of a CPRL progression.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is:
	10xxxxxx, where xxxxxx is the sensor number.
	2       (*)                                                                                    Repeat for each successive step of progression.
	In the following figures, a JPEG 2000 codestream with 3 levels of resolution has been encoded following a) an RLCP progression scheme, b) an LRCP progression
	scheme and c) a CPRL progression scheme. Therefore three indexes are defined in each case. The offset 0 is the beginning of the codestream (main header
	included).
	Main     Tile-part
	header     header                                                                                                            EOC
	Index
	Resolution 1                           Resolution 2                       Resolution 3
	Offset 0                                       Index 1                               Index 2                            Index 3
	Offset 16480 (bytes)                  Offset 57820 (bytes)               Offset 106392
	from offset 0                         from offset 0                      (bytes) from
	offset 0
	Figure A-8 - JPEG 2000 Codestream with its indexes corresponding to the highest order
	of progression in a RLCP progression order
	Main     Tile-part
	header     header                                                                                                          EOC
	Index
	Layer 1                             Layer 2                               Layer 3
	Offset 0                                                                            Index 2                           Index 3
	Index 1 Offset 19220                     Offset 49820 (bytes)              Offset 106392
	From offset 0                            from offset 0                     (bytes) from
	offset 0
	Figure A-9 - JPEG 2000 Codestream with its indexes corresponding to the highest order of progression
	in a LRCP progression order
	Main     Tile-part
	header     header                                                                                                           EOC
	Index
	Component1                          Component 2                           Component 3
	Offset 0                                                                               Index 2                          Index 3
	Index 1 Offset 17420
	Offset 50400 (bytes)             Offset 106392
	from offset 0
	from offset 0                    (bytes) from
	offset 0
	Figure A-10 - JPEG 2000 Codestream with its indexes corresponding to the highest order
	of progression in a CPRL progression order
	A-11     PASSIVE SENSOR Data Tables
*/
public class Jpeg2000IndexDataTable extends DataTable {
    private List<Integer> indexes = new ArrayList<>();

    public List<Integer> getIndices() {
        return new ArrayList<>(indexes);
    }

    public void addIndex(final Integer index) {
        indexes.add(index);
    }
}
