package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	Virtual Sensor Definition Example
	Suppose there is a system with 1 transmit antenna, and 2 receive antennas. These are real, physical things, and therefore their positions, attitudes etc. are
	described as usual. Let the transmit antenna have sensor number #1, the first receive antenna have sensor number #2, and the second receive antenna have
	sensor number #3.
	The system takes the data from the first receive antenna, and uses this to produce an image stream. The system takes data from the first and second receivers,
	subtracts the second signal from the first, and uses the resultant data to produce an image stream.
	The first image stream comes from a virtual sensor. It needs to be given a sensor number – let it be called sensor number #4.
	Let the second image stream be virtual sensor #33.
	There will be two virtual sensor definition tables:
	Field                              Field name                                   Value
	1        Transmit phase difference                                              0
	2        Receive phase difference                                               0
	3        Transmit antenna 1 Sensor number                                       1
	4        Transmit antenna 2 Sensor number                                     FFFF
	5        Receive antenna 1 Sensor number                                        2
	6        Receive antenna 2 Sensor number                                      FFFF
	7        Combination operation                                                 00
	Field                               Field name                                     Value
	1         Transmit phase difference                                                0
	2         Receive phase difference                                                 0
	3         Transmit antenna 1 Sensor number                                         1
	4         Transmit antenna 2 Sensor number                                       FFFF
	5         Receive antenna 1 Sensor number                                          2
	6         Receive antenna 2 Sensor number                                          3
	7         Combination operation                                                   01
	Suppose, now, that the data used to form image streams 1 and 2 is added together, with the data from image stream 2 having a /2 phase shift applied before the
	addition.
	Let this be virtual sensor number #34. Then the virtual sensor definition table would be:
	Field                               Field name                                     Value
	1         Transmit phase difference                                                0
	2         Receive phase difference                                                /2
	3         Transmit antenna 1 Sensor number                                       FFFF
	4         Transmit antenna 2 Sensor number                                       FFFF
	5         Receive antenna 1 Sensor number                                          4
	6         Receive antenna 2 Sensor number                                         33
	7         Combination operation                                                   00
	The fact that fields 5 and 6 correspond to virtual sensor numbers means that the virtual sensor definition tables need to be interrogated further to find the definitions
	of the these virtual sensors, to trace back to real antennas.
*/
public class VirtualSensorDefinitionDataTable extends DataTable {
    private double transmitPhaseDifference;
    private double receivePhaseDifference;
    private int transmitAntenna1SensorNumber;
    private int transmitAntenna2SensorNumber;
    private int receiveAntenna1SensorNumber;
    private int receiveAntenna2SensorNumber;
    private int combinationOperation;
}
