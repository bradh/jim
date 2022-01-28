package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	CUMULATIVE represents the time relative to the Header
	Time Tag.
	DIFFERENTIAL represents the change in time from one
	sampling to the next.
	$FF = UNUSED
	$00 = CUMULATIVE
	$01 = DIFFERENTIAL
	4       (*)                                                                                        If Timing model is equal to $00 = Sample by sample,
	repeat Field 3 for each element.
	Maximum number of elements = 64k. Order of elements is
	according to sensor element ID.
	‡   Refer to the figure in section A-13.5 for an example of Cumulative and Differential timing methods
	This table is used in conjunction with the Sensor Element Data Table and the Sensor Sample Timing Data Table.
	Timing may be accomplished on a sample by sample or on a pixel by pixel basis, as indicated by the field “Timing Model”.
	In general there is a one-to-one relationship between a sample and its timing, i.e. Sensor Sample Timing Data Table and corresponding Sensor Data Table are
	identically structured (Image size, Tile Size, Data ordering), though they may be different in overall number of bytes.
	If timing is on a pixel by pixel basis:
	   the timing of each sample of the same pixel is assumed to be identical and shall not be repeated for each sample, i.e. the Sensor Sample Timing Data Table is
	treated alike to single element sensor data.
*/
@SuppressFBWarnings
public class SensorSampleTimingDescriptionDataTable extends DataTable {
    private int timingModel;
    private int timingAccuracy;
    private int timingMethod;
}
