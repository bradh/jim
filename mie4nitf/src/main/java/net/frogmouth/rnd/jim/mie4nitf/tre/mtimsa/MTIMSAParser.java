package net.frogmouth.rnd.jim.mie4nitf.tre.mtimsa;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser;
import net.frogmouth.rnd.jim.nitf.tre.TRE;
import java.nio.ByteBuffer;

/** MTIMSA TRE Parser. */
public class MTIMSAParser extends AbstractTREParser {

    private static final int IMAGE_SEG_INDEX_LEN = 3;
    private static final int GEOCOORDS_STATIC_LEN = 2;
    private static final int LAYER_ID_LEN = 36;
    private static final int CAMERA_SET_INDEX_LEN = 3;
    private static final int TIME_INTERVAL_INDEX_LEN = 6;
    private static final int TEMP_BLOCK_INDEX_LEN = 3;
    private static final int REFERENCE_FRAME_NUM_LEN = 9;
    private static final int DT_MULTIPLIER_LEN = 8;
    private static final int DT_SIZE_LEN = 1;
    private static final int NUMBER_FRAMES_LEN = 4;
    private static final int NUMBER_DT_LEN = 4;

    @Override
    public String getTag() {
        return "MTIMSA";
    }

    @Override
    public TRE parse(String tag, byte[] bytes) {
        MTIMSA tre = new MTIMSA();
        int offset = 0;
        tre.setImage_seg_index(readBCSNPI(bytes, offset, IMAGE_SEG_INDEX_LEN));
        offset += IMAGE_SEG_INDEX_LEN;
        tre.setGeocoords_static(readBCSNPI(bytes, offset, GEOCOORDS_STATIC_LEN));
        offset += GEOCOORDS_STATIC_LEN;
        tre.setLayer_id(readBCSA(bytes, offset, LAYER_ID_LEN));
        offset += LAYER_ID_LEN;
        tre.setCamera_set_index(readBCSNPI(bytes, offset, CAMERA_SET_INDEX_LEN));
        offset += CAMERA_SET_INDEX_LEN;
        tre.setCamera_id(readUUIDAsString(bytes, offset));
        offset += UUID_LEN;
        tre.setTime_interval_index(readBCSNPI(bytes, offset, TIME_INTERVAL_INDEX_LEN));
        offset += TIME_INTERVAL_INDEX_LEN;
        tre.setTemp_block_index(readBCSNPI(bytes, offset, TEMP_BLOCK_INDEX_LEN));
        offset += TEMP_BLOCK_INDEX_LEN;
        tre.setNominal_frame_rate(readUE13(bytes, offset));
        offset += UE13_LEN;
        tre.setReference_frame_number(readBCSA(bytes, offset, REFERENCE_FRAME_NUM_LEN));
        offset += REFERENCE_FRAME_NUM_LEN;
        tre.setBase_timestamp(this.readTimeStampAsString(bytes, offset));
        offset += TIMESTAMP_LEN;
        tre.setDt_multiplier(this.readUINT64(bytes, offset));
        offset += DT_MULTIPLIER_LEN;
        int dt_size = this.readUINT8(bytes, offset);
        offset += DT_SIZE_LEN;
        tre.setNumber_frames(this.readUINT32(bytes, offset));
        offset += NUMBER_FRAMES_LEN;
        long number_dt = this.readUINT32(bytes, offset);
        offset += NUMBER_DT_LEN;
        for (int n = 0; n < number_dt; n++) {
            DeltaTime deltaTime = new DeltaTime();
            long dt = 0;
            for (int idx = offset; idx < offset + dt_size; idx++) {
                int i = bytes[idx] & 0xFF;
                dt = (dt << 8) + i;
            }
            offset += dt_size;
            deltaTime.setDt(dt);
            tre.addDt(deltaTime);
        }
        return tre;
    }

    private long readUINT64(byte[] bytes, int offset) {
        return ByteBuffer.wrap(bytes, offset, Long.BYTES).getLong();
    }

    private int readUINT8(byte[] bytes, int offset) {
        return bytes[offset] & 0xFF;
    }

    private long readUINT32(byte[] bytes, int offset) {
        return ByteBuffer.wrap(bytes, offset, Integer.BYTES).getInt();
    }
}
