/**
 * Packet Handling.
 *
 * <p>Data transmission in accordance with STANAG 4607 is by means of packets. Each packet,
 * consisting of a Packet Header and a number of Message Segments, will contain GMTI data pertinent
 * to (at most) one radar job. If the amount of data exceeds the size limit of a GMTIF packet or if
 * it is necessary to send the data in support of time-critical missions, the format allows a
 * portion of the data to be sent in one GMTIF packet and the remainder of the data to be sent in
 * subsequent GMTIF packets.
 *
 * <p>The Packet Header is sent at the beginning of each packet. It identifies the format version of
 * the data contained in the packet, the size of the packet, and information pertaining to the
 * platform, security, and the mission.
 *
 * <p>This package provides handling for the top level packet structure, and the packet header.
 */
package net.frogmouth.rnd.jim.s4607.packet;
