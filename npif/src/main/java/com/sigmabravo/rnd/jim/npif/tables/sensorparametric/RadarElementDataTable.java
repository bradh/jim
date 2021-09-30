package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	$00 = Radar measurement
	$01 = Height
	$02 = Velocity
	(image referenced (x, y))
	$03 = Velocity
	(ground referenced (N, E))
	If an element is used for pixel validation, an element
	sample value of zero indicates valid imagery. Any non-
	zero value is used for invalid data.
	6      RF Centre frequency      Opt      8     Immed            RN        The RF centre frequency of the radar. (Hertz)
	7      RF Bandwidth             Opt      8     Immed            RN        The RF bandwidth of the radar. (Hertz)
	(e.g. the RF bandwidth of the Range Chirp).Normally the
	RF bandwidth is symmetrically around the RF centre
	frequency.
	8      Mean Doppler Frequency   Opt      8     Immed            RN        The mean doppler frequency used for processing. (Hertz)
	9      Look Centre Frequency    Opt      8     Immed            RN        The base (centre) doppler frequency used for processing
	this look.
	10     Look Bandwidth           Opt      8     Immed            RN        The doppler bandwidth used for processing this look.
	(Hertz)
	Normally for Radar measurement but also used for
	forming MTI overlay (Radar Measurement MTI). Normally
	the RF bandwidth is symmetrically around the base
	(centre) doppler frequency.
	11     Minimum Element Value    Mand     8     Immed            RN        Used with the Transfer Function Type to scale the element
	value from the physical value.
	12     Maximum Element Value    Mand     8     Immed            RN        Used with the Transfer Function Type to scale the element
	value from the physical value.
	13     Minimum Physical Value   Mand     8     Immed            RN        Used with the Transfer Function Type to scale the element
	value from the physical value.
	14     Maximum Physical Value   Mand     8     Immed            RN        Used with the Transfer Function Type to scale the element
	value from the physical value.
	15     Polarisation             Opt      1     Encode   Unsigned Binary   $00 = HH
	It should be noted, that the term element is expanded beyond the scope of Editon 2. The term element shall be associated with one layer of information for a certain
	sensor image, which fits well to passive sensors as well. The following sketch may support clarification of terms.
	CVLD or Y
	Element ID =0
	1st Sample
	Element ID =1                                  VLD or X
	1st Sample
	Element ID =2
	1st Sample
	Element ID =3
	1st Sample
	1st Pixel
	(0, 0)
	A-13        Sensor Data Tables
	The Sensor Data Tables are five tables with their own Data File Address. These tables are used to describe the sensor data and its pixel registration (x, y, z) within
	the image. The sensor sample timing describes the time relationship between adjacent pixels.
	The Data File Addresses of the Sensor Data Tables are as follows.
	Data File                                           Data File Address
	Sensor Data Table                                                      $0000 0000
	Sensor Sample “x” Coordinate Table                                     $0000 0010
	Sensor Sample “y” Coordinate Table                                     $0000 0020
	Sensor Sample “z” Coordinate Table                                     $0000 0030
	Sensor Sample Timing Table                                             $0000 0050
	4607 GMTI Data Table                                                   $0000 0060
	4609 Motion Imagery                                                    $0000 0070
	Range Finder                                                           $0000 0080
*/
public class RadarElementDataTable extends DataTable {
    private int elementSize;
    private int elementBitOffset;
    private int sensorElementID;
    private int typeOfElement;
    private int physicalCharacteristic;
}
