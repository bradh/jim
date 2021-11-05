package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

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

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getTransmitPhaseDifference() {
        return transmitPhaseDifference;
    }

    public void setTransmitPhaseDifference(double transmitPhaseDifference) {
        this.transmitPhaseDifference = transmitPhaseDifference;
    }

    public double getReceivePhaseDifference() {
        return receivePhaseDifference;
    }

    public void setReceivePhaseDifference(double receivePhaseDifference) {
        this.receivePhaseDifference = receivePhaseDifference;
    }

    public int getTransmitAntenna1SensorNumber() {
        return transmitAntenna1SensorNumber;
    }

    public String getTransmitAntenna1SensorNumberAsText() {
        return formatAntennaSensorNumber(getTransmitAntenna1SensorNumber());
    }

    private String formatAntennaSensorNumber(int number) {
        if ((number & 0xFFFF) == 0xFFFF) {
            return "Not in use";
        }
        return String.format("%d", number);
    }

    public void setTransmitAntenna1SensorNumber(int transmitAntenna1SensorNumber) {
        this.transmitAntenna1SensorNumber = transmitAntenna1SensorNumber;
    }

    public int getTransmitAntenna2SensorNumber() {
        return transmitAntenna2SensorNumber;
    }

    public String getTransmitAntenna2SensorNumberAsText() {
        return formatAntennaSensorNumber(getTransmitAntenna2SensorNumber());
    }

    public void setTransmitAntenna2SensorNumber(int transmitAntenna2SensorNumber) {
        this.transmitAntenna2SensorNumber = transmitAntenna2SensorNumber;
    }

    public int getReceiveAntenna1SensorNumber() {
        return receiveAntenna1SensorNumber;
    }

    public String getReceiveAntenna1SensorNumberAsText() {
        return formatAntennaSensorNumber(getReceiveAntenna1SensorNumber());
    }

    public void setReceiveAntenna1SensorNumber(int receiveAntenna1SensorNumber) {
        this.receiveAntenna1SensorNumber = receiveAntenna1SensorNumber;
    }

    public int getReceiveAntenna2SensorNumber() {
        return receiveAntenna2SensorNumber;
    }

    public String getReceiveAntenna2SensorNumberAsText() {
        return formatAntennaSensorNumber(getReceiveAntenna2SensorNumber());
    }

    public void setReceiveAntenna2SensorNumber(int receiveAntenna2SensorNumber) {
        this.receiveAntenna2SensorNumber = receiveAntenna2SensorNumber;
    }

    public int getCombinationOperation() {
        return combinationOperation;
    }

    public String getCombinationOperationAsText() {
        switch (this.getCombinationOperation()) {
            case 0x00:
                return "Addition";
            case 0x01:
                return "Subtraction";
            default:
                return "Unknown combination operation (" + getCombinationOperation() + ")";
        }
    }

    public void setCombinationOperation(int combinationOperation) {
        this.combinationOperation = combinationOperation;
    }
}
