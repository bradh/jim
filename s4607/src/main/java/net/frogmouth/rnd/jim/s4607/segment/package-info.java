/**
 * Segment Handling.
 *
 * <p>Data transmission in accordance with STANAG 4607 is by means of packets. Each packet,
 * consisting of a Packet Header and a number of Message Segments, will contain GMTI data pertinent
 * to (at most) one radar job.
 *
 * <p>A Segment Header, which defines the type of message and the length (in bytes) of the following
 * segment, precedes each Message Segment. Message Segments include Mission, Dwell, HRR, Job
 * Definition, Free Text, Test/Status, Processing History, and Platform Location.
 *
 * <p>This package provides general support for Segment handling, including the common Segment
 * Header. Implementations of the various segment types are provided in separate packages.
 */
package net.frogmouth.rnd.jim.s4607.segment;
