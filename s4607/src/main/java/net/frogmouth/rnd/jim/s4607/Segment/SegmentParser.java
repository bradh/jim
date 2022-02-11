package net.frogmouth.rnd.jim.s4607.Segment;

import net.frogmouth.rnd.jim.s4607.ParseContext;

/**
 * Abstract parser for a given kind of Segment.
 *
 * <p>The segment parser is responsible for extracting a full segment from the provided
 * ParseContext.
 *
 * <p>This will need to be sub-classed and implemented if a new Segment type is added. Instances of
 * concrete sub-classes are usually created by the parsing code, and it should not be necessary to
 * instantiate these from user code.
 */
public abstract class SegmentParser {

    /** The parse context to operate on. */
    protected ParseContext context;

    /**
     * Set the parse context for the parser.
     *
     * @param context the context.
     */
    public final void setParseContext(ParseContext context) {
        this.context = context;
    }

    /**
     * Get the segment type supported by the parser.
     *
     * @return the segment type (enumeration value).
     */
    public abstract SegmentType getSegmentType();

    /**
     * Parse the segment from the previously set context.
     *
     * <p>The parser needs to consume all of the Segment data (consistent with the provided length).
     *
     * @param segmentHeader the header that was parsed.
     * @return a Segment instance that has been parsed from the context.
     */
    public abstract Segment parse(SegmentHeader segmentHeader);
}
