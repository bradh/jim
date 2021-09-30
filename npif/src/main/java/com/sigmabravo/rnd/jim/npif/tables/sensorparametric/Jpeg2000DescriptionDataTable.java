package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	Even if the JPEG 2000 description contained into the stream is self-sufficient, it can be helpful to get information on the compressed data structure prior to receiving
	it, in order to optimise the exploitation capability.
	Therefore, the JPEG 2000 Description Table contains information already included in the stream inside SIZ and COD markers.
	In JPEG 2000, the number of layers, decomposition levels, and precincts can change for every component. This feature is not supported in STANAG 7023.
	2           Progression order            Mand    1      Encode      Unsigned       The progression order type. Possible values are:
	Binary        $00 Layer-Resolution-Component-Position
	$01 Resolution-Layer-Component-Position
	$02 Resolution-Position-Component-Layer
	$03 Position-Component-Resolution-Layer
	$04 Component-Position-Resolution-Layer
	3           Number of decomposition      Mand    1      Immed    Unsigned Binary   The number of wavelet transformations applied. N decomposition
	levels                                                                 levels lead to N+1 resolution levels (from the coarsest to the
	finest resolution).
	Range of values: 0-32.
	4           Number of layers             Mand    2      Immed       Unsigned       The number of layers (quality increment).
	Binary        Range of values: 0-65535.
	5           Number of components         Mand    2      Immed       Unsigned       The number of components (bands) of the sensor data.
	Binary        Range of values: 1-16384.
	6           JPEG 2000 Tiling performed   Mand    1      Encode   Unsigned Binary   Possible values are:
	$00 No JPEG 2000 Tiling has been used
	$01 JPEG 2000 Tiling has been used
*/
public class Jpeg2000DescriptionDataTable extends DataTable {
    private int codestreamCapability;
}
