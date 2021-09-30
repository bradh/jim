package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.util.Arrays;

/*
	This table is used to transmit the sensor data.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 10xxxxxx, where xxxxxx is the sensor number.
	The data file size must be a multiple of whole bytes. Any padding will be in the last byte and from the LSB towards the MSB. Examples 1 and 2 show how the bits
	are packed into the data file for a RGB band interleaved by pixel (BIP) representation for a 3 byte data file containing 3 elements, i.e. one sample. (In reality the data
	file size would be much bigger containing many samples).
	Example 1
	3 8-bit RGB elements making a single BIP sample.
	Red = 11210                                    Green = 8610                        Blue = 5010
	0     1     1     1      0   0     0     0        0   1   0   1   0      1    1   0   0   0   1    1   0    0   1       0
	Byte 1                                         Byte 2                             Byte 3
	MSB                                                                                                              LSB
	Example 2
	3 6-bit RGB elements making a single BIP sample. The least significant bits are padded with xxxxxx.
	Red = 4510                           Green = 3710                       Blue = 1810
	1      0     1     1      0     1     1     0     0      1     0     1     0      1     0     0      1     0     X     X     X      X     X      X
	Byte 1                                              Byte 2                                          Byte 3
	MSB                                                                                                                                         LSB
	If in example 2 there were 750 6-bit RGB elements (250 BIP samples) to make 250 pixels, then:
	Total no. of bits in table = 750 x 6 = 4500 bits, and 4500 bits = 562 bytes and 4 bits, the padding is xxxx. The data file size for the 750 6-bit elements would be 563
	bytes.
*/
public class SensorDataTable extends DataTable {
    private byte[] sensorData;

    public byte[] getSensorData() {
        return Arrays.copyOf(sensorData, sensorData.length);
    }

    public void setSensorData(byte[] sensorData) {
        this.sensorData = Arrays.copyOf(sensorData, sensorData.length);
    }
}
