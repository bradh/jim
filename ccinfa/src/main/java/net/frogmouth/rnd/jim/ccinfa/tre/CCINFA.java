package net.frogmouth.rnd.jim.ccinfa.tre;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TRE;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;

/**
 * Country Code Information (CCINFA) TRE.
 *
 * <p>This class is used for Country Code (e.g. ISO 3166, and national equivalents such as the US
 * GENC) lookup and translation.
 *
 * <p>Several fields defined in MIL-STD-2500C (e.g., FSREL, Image Subheader (IS).TGTID) and in
 * Tagged Record Extensions (TRE) and Data Extension Segments (DES) (e.g., COUNTRY in STDIDC TRE)
 * contain a two or three-character code representing a country or other geopolitical or geographic
 * entity. In these legacy data fields, the encoding and codespace of those codes was specified a
 * priori through MIL- STD-2500C and the TRE/DES definition documentation, setting those values to
 * be with respect to the now withdrawn Federal Information Processing Standard (FIPS) Publication
 * 10-4 (FIPS PUB 10-4). An update to MIL-STD-2500C changes that reference to point to the
 * Geopolitical Entities and Codes (GEC) codespace as defined in the Geopolitical Entities, Names
 * and Codes (GENC) standard (NGA.STND.0033). If desired geopolitical or geographic entity is not
 * defined in the GEC codespace, the data provider must define an ad hoc code for that entity, which
 * can create downstream interoperability issues.
 *
 * <p>With the enterprise transition to the GENC standard, and more specifically, to the GENC
 * codespace in the US, making that simple reference change is not sufficient to enable NITF files
 * to support a fully- GENC-enabled data flow. The Country Code Information TRE (CCINFA) provides
 * the additional detail necessary; for every a priori and ad hoc code included within the NITF file
 * in these legacy fields, the data provider should document the translation of that code to a Short
 * URN-based individual item identifier (e.g., "ge:GENC:3:3-4:USA").
 *
 * <p>The CCINFA TRE is defined in STDI-0002 Volume 1 Appendix AG: CCINFA.
 */
public class CCINFA extends TRE {

    private static final String TRE_TAG = "CCINFA";
    private final List<Code> codes = new ArrayList<>();;

    /** Constructor. */
    public CCINFA() {
        super(TRE_TAG);
    }

    /**
     * Get the codes defined in this TRE instance.
     *
     * @return a copy of the list of codes.
     */
    @TREOrder(order = 1)
    @TREGroup
    public List<Code> getCodes() {
        return new ArrayList<>(codes);
    }

    /**
     * Add a code entry to this TRE instance.
     *
     * @param code the code to add.
     */
    public void addCode(final Code code) {
        codes.add(code);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
