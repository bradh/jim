package net.frogmouth.rnd.jim.demo.gmticonverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import net.frogmouth.rnd.jim.s4607.Reader;
import net.frogmouth.rnd.jim.s4607.dwell.DwellSegment;
import net.frogmouth.rnd.jim.s4607.freetext.FreeTextSegment;
import net.frogmouth.rnd.jim.s4607.jobdefinition.JobDefinitionSegment;
import net.frogmouth.rnd.jim.s4607.mission.MissionSegment;
import net.frogmouth.rnd.jim.s4607.packet.Packet;
import net.frogmouth.rnd.jim.s4607.packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import net.frogmouth.rnd.jim.s4676.NitsRoot;
import net.frogmouth.rnd.jim.s4676.Parser;

class Converter {
    private final Reader reader;

    public Converter(String source) throws IOException {
        Path sourcePath = Paths.get(source);
        reader = new Reader(sourcePath);
    }

    String convertToNITS() throws JsonProcessingException {
        NitsRoot root = new NitsRoot();
        // TODO: set this from the packet header
        root.getOriginatorConfidentialityLabel()
                .getConfidentialityInformation()
                .setPolicyIdentifier("US DoDM 5200.01 Volume 2");
        root.getOriginatorConfidentialityLabel()
                .getConfidentialityInformation()
                .setClassification("UNCLASSIFIED");
        root.getOriginatorConfidentialityLabel()
                .setCreationDateTime(
                        ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
        for (Packet packet : reader.getPackets()) {
            PacketHeader packetHeader = packet.getPacketHeader();
            for (Segment segment : packet.getSegments()) {
                SegmentType segmentType = segment.getSegmentType();
                if (null != segmentType)
                    switch (segmentType) {
                        case MissionSegment:
                            processMissionSegment(root, (MissionSegment) segment);
                            break;
                        case FreeTextSegment:
                            processFreeTextSegment(root, (FreeTextSegment) segment);
                            break;
                        case JobDefinitionSegment:
                            processJobDefinitionSegment(root, (JobDefinitionSegment) segment);
                            break;
                        case DwellSegment:
                            processDwellSegment(root, (DwellSegment) segment);
                            break;
                        default:
                            System.out.println("add support for " + segmentType.getDisplayLabel());
                    }
            }
        }
        String serialisedXml = new Parser().serialise(root);
        return serialisedXml;
    }

    private void processFreeTextSegment(NitsRoot root, FreeTextSegment freeTextSegment) {
        // Nothing yet
    }

    private void processMissionSegment(NitsRoot root, MissionSegment missionSegment) {
        // Nothing yet
    }

    private void processJobDefinitionSegment(
            NitsRoot root, JobDefinitionSegment jobDefinitionSegment) {
        // Nothing yet
    }

    private void processDwellSegment(NitsRoot root, DwellSegment dwellSegment) {
        // Nothing yet
    }
}
