package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.serde.ListIntegerArrayDeserialiser;
import net.frogmouth.rnd.jim.s4676.serde.ListIntegerArraySerialiser;
import net.frogmouth.rnd.jim.s4676.serde.SupplementalDeserialisationInfo;

/**
 * Pixel run.
 *
 * <p>A list of pixel runs that specify a collection of pixels (for example, a detection in image
 * space). The pixel runs can be specified as runs in the row direction (rs) and/or in the column
 * direction (cs). If the runs are specified in both directions, they can overlap. The top-left
 * pixel of the image corresponds to row 0, column 0.
 *
 * <p>A simple example is shown in the figure below. In this case, the runs that describe the
 * light-blue pixels are:
 *
 * <ul>
 *   <li>cs: 2, 3, 5
 *   <li>rs: 3, 1, 6
 *   <li>rs: 4, 3, 3
 * </ul>
 *
 * <p><img src="../../../../../../../../resources/pixelmask.png" alt="">
 *
 * <p>NOTE: If converting data from a ST0903 data source into STANAG 4676, pixel coordinates must be
 * translated from 1-based to 0-based coordinates.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"rs", "cs"})
public class PixelRun {
    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "rs")
    @JsonSerialize(using = ListIntegerArraySerialiser.class)
    @JsonDeserialize(using = ListIntegerArrayDeserialiser.class)
    @SupplementalDeserialisationInfo(elementName = "rs")
    private List<Integer[]> rowSequences;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "cs")
    @JsonSerialize(using = ListIntegerArraySerialiser.class)
    @JsonDeserialize(using = ListIntegerArrayDeserialiser.class)
    @SupplementalDeserialisationInfo(elementName = "cs")
    private List<Integer[]> columnSequences;

    /** Constructor. */
    public PixelRun() {}

    /**
     * Row sequences.
     *
     * <p>Each instance of “rs” is a sequence of three values: A starting row value, a starting
     * column value, and a run length across column values. The first row and column are both 0.
     *
     * @return the list of sequences.
     */
    public List<Integer[]> getRowSequences() {
        return rowSequences;
    }

    /**
     * Add a row sequence.
     *
     * <p>Each instance of “rs” is a sequence of three values: A starting row value, a starting
     * column value, and a run length across column values. The first row and column are both 0.
     *
     * @param rs the row sequence to add. *
     */
    public void addRowSequence(Integer[] rs) {
        if (this.rowSequences == null) {
            this.rowSequences = new ArrayList<>();
        }
        this.rowSequences.add(rs);
    }

    /**
     * Column sequences.
     *
     * <p>Each instance of “cs” is a sequence of three values: A starting row value, a starting
     * column value, and a run length across row values. The first row and column are both 0.
     *
     * @return the list of sequences.
     */
    public List<Integer[]> getColumnSequences() {
        return columnSequences;
    }

    /**
     * Add a column sequence.
     *
     * <p>Each instance of “cs” is a sequence of three values: A starting row value, a starting
     * column value, and a run length across row values. The first row and column are both 0.
     *
     * @param cs the column sequence to add. *
     */
    public void addColumnSequence(Integer[] cs) {
        if (this.columnSequences == null) {
            this.columnSequences = new ArrayList<>();
        }
        this.columnSequences.add(cs);
    }
}
