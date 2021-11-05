package net.frogmouth.rnd.jim.npif.tables.platform;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class ComprehensiveDynamicPlatformDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFF00FFFF;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00000001;

    public ComprehensiveDynamicPlatformDataTableParser() {}

    @Override
    public ComprehensiveDynamicPlatformDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        ComprehensiveDynamicPlatformDataTable dataTable =
                new ComprehensiveDynamicPlatformDataTable();
        dataTable.setName("Comprehensive Dynamic Platform");
        dataTable.setSourceFile("Platform");
        dataTable.setPlatformTime(this.readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformGeoLocation(this.readPosition(mappedByteBuffer, offset));
        offset += 16;
        dataTable.setMslAltitude(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAglAltitude(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setGpsAltitude(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformTrueAirspeed(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformGroundSpeed(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformTrueCourse(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformTrueHeading(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformPitch(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformRoll(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformYaw(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformVelocityNorth(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformVelocityEast(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformVelocityDown(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformAccelerationNorth(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformAccelerationEast(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformAccelerationDown(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformHeadingRate(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformPitchRate(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformRollRate(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformYawRate(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformHeadingAngularAcceleration(
                this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformPitchAngularAcceleration(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformRollAngularAcceleration(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPlatformYawAngularAcceleration(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setVelocityToHeightRatio(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        // TODO: confidence map
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.PLATFORM_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
