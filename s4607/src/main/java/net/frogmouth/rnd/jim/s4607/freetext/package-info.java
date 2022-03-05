/**
 * Free Text Segment.
 *
 * <p>The Free Text Segment provides a means of sending Basic Character Set (BCS) alphanumeric text
 * messages. The Free Text Segment shall be sent as required.
 *
 * <p>The free text segment can be used as a means by which amplifying information is added to
 * information already contained within an existing GMTIF message. It is not intended to be a means
 * by which developers are able to circumvent the segments provided within STANAG 4607. The
 * free-text capability provides a long-term flexibility for capturing information, comments, and
 * additional data pertaining to STANAG 4607 messages, and provides the capability for
 * bandwidth-challenged users, or users without collaboration opportunities, to include information
 * relevant to the data files. It enables the recording of situational data relevant to future use
 * of the information, including multi-platform collection scenario information. Free-text also
 * allows the capability for the independent search of parameters with keywords, unstructured text
 * searches, etc. as applications are web-enabled. An additional use of free- text is to provide
 * annotation information on MTI products. There is currently no standard format for “exploited”
 * MTI, and the Free Text Segment provides an interim means for passing exploitation and annotation
 * information with the data files for further use.
 *
 * <p>The data model is provided by {@link FreeTextSegment}. Parsing and serialisation of that data
 * model into the AEDP-7 binary format is provided by {@link FreeTextSegmentParser} and {@link
 * FreeTextSegmentSerialiser}, however this is normally handled indirectly via {@link
 * net.frogmouth.rnd.jim.s4607.Reader} and {@link net.frogmouth.rnd.jim.s4607.Writer}. That is, the
 * Free Text Segment is handled as for any other Segment within the Packet structure.
 */
package net.frogmouth.rnd.jim.s4607.freetext;
