/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sigmabravo.rnd.jim.s4607;

public class SegmentHeader {
    private final SegmentType segmentType;
    private final long segmentSize;

    public SegmentHeader(SegmentType segmentType, long segmentSize) {
        this.segmentType = segmentType;
        this.segmentSize = segmentSize;
    }

    public SegmentType getSegmentType() {
        return segmentType;
    }

    public long getSegmentSize() {
        return segmentSize;
    }
}
