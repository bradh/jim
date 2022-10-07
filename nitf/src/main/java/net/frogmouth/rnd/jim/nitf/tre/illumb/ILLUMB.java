package net.frogmouth.rnd.jim.nitf.tre.illumb;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class ILLUMB extends TaggedRecordExtension {

    private static final String TRE_TAG = "ILLUMB";
    private String band_unit;
    private final List<Band> bands = new ArrayList<>();
    private final List<OtherIllumSource> others = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private String geo_datum;
    private String geo_datum_code;
    private String ellipsoid_name;
    private String ellipsoid_code;
    private String vertical_datum_ref;
    private String vertical_ref_code;
    private String rad_quantity;
    private String radq_unit;
    private final List<IllumCondition> illumConditions = new ArrayList<>();

    public ILLUMB() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "BAND_UNIT")
    public String getBand_Unit() {
        return band_unit;
    }

    public void setBand_unit(String bandUnit) {
        this.band_unit = bandUnit;
    }

    @TREOrder(order = 2)
    @TREGroup
    public List<Band> getBands() {
        return new ArrayList<>(bands);
    }

    public void addBand(final Band band) {
        bands.add(band);
    }

    @TREOrder(order = 3)
    @TREGroup
    public List<OtherIllumSource> getOther() {
        return new ArrayList<>(others);
    }

    public void addOther(final OtherIllumSource other) {
        others.add(other);
    }

    @TREOrder(order = 4)
    @TREGroup
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void addComment(final Comment comment) {
        comments.add(comment);
    }

    @TREOrder(order = 5)
    @TREField(label = "GEO_DATUM")
    public String getGeo_datum() {
        return geo_datum;
    }

    public void setGeo_datum(String geo_datum) {
        this.geo_datum = geo_datum;
    }

    @TREOrder(order = 6)
    @TREField(label = "GEO_DATUM_CODE")
    public String getGeo_datum_code() {
        return geo_datum_code;
    }

    public void setGeo_datum_code(String geo_datum_code) {
        this.geo_datum_code = geo_datum_code;
    }

    @TREOrder(order = 7)
    @TREField(label = "ELLIPSOID_NAME")
    public String getEllipsoid_name() {
        return ellipsoid_name;
    }

    public void setEllipsoid_name(String ellipsoid_name) {
        this.ellipsoid_name = ellipsoid_name;
    }

    @TREOrder(order = 8)
    @TREField(label = "ELLIPSOID_CODE")
    public String getEllipsoid_code() {
        return ellipsoid_code;
    }

    public void setEllipsoid_code(String ellipsoid_code) {
        this.ellipsoid_code = ellipsoid_code;
    }

    @TREOrder(order = 9)
    @TREField(label = "VERTICAL_DATUM_REF")
    public String getVertical_datum_ref() {
        return vertical_datum_ref;
    }

    public void setVertical_datum_ref(String vertical_datum_ref) {
        this.vertical_datum_ref = vertical_datum_ref;
    }

    @TREOrder(order = 10)
    @TREField(label = "VERTICAL_REF_CODE")
    public String getVertical_ref_code() {
        return vertical_ref_code;
    }

    public void setVertical_ref_code(String vertical_ref_code) {
        this.vertical_ref_code = vertical_ref_code;
    }

    @TREOrder(order = 11)
    @TREField(label = "RAD_QUANTITY")
    public String getRad_quantity() {
        return rad_quantity;
    }

    public void setRad_quantity(String rad_quantity) {
        this.rad_quantity = rad_quantity;
    }

    @TREOrder(order = 12)
    @TREField(label = "RADQ_UNIT")
    public String getRadq_unit() {
        return radq_unit;
    }

    public void setRadq_unit(String radq_unit) {
        this.radq_unit = radq_unit;
    }

    @TREOrder(order = 13)
    @TREGroup
    public List<IllumCondition> getIllumConditions() {
        return new ArrayList<>(illumConditions);
    }

    public void addIllumCondition(final IllumCondition cond) {
        illumConditions.add(cond);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
