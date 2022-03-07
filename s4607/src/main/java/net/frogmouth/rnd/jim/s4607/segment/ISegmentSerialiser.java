package net.frogmouth.rnd.jim.s4607.segment;

import net.frogmouth.rnd.jim.s4607.SerialisationContext;

/**
 * Serialiser for a given kind of Segment.
 *
 * <p>The segment serialiser is responsible for converting the segment into a byte array.
 *
 * <p>This will need to be implemented if a new Segment type is added. Instances of concrete
 * sub-classes are usually created by the serialisation code, and it should not be necessary to
 * instantiate these from user code.
 */
public interface ISegmentSerialiser {

    /**
     * Get the segment type supported by the serialiser.
     *
     * @return the segment type (enumeration value).
     */
    SegmentType getSegmentType();

    /**
     * Serialise the segment to a byte array using default context.
     *
     * @param segment the segment to serialise
     * @return byte array corresponding the body of the segment (not the header).
     */
    byte[] serialise(Segment segment);

    /**
     * Serialise the segment to a byte array.
     *
     * @param segment the segment to serialise
     * @param serialisationContext the context providing configuration information.
     * @return byte array corresponding the body of the segment (not the header).
     */
    byte[] serialise(Segment segment, SerialisationContext serialisationContext);
}
