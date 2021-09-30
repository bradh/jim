package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	Depression Angle for     Depression Angle for
	Near Range Point         Far Range Point
	h
	Pat
	gh t
	Fli
	Swath
	Flat Plane
	Figure A-16 – Diagram of Depression Angle.
	Projection datum
	All projections are done relative to the WGS84.
	Each kind of projection has its own set of parameters. The STANAG uses projection types and datum commonly used in geography, except for the Cartesian plane
	projection designed for basic corrections of raw images.
	$01 = Cartesian plane projection
	This is not a standard projection used for cartography. The plane is described by a point, centre of the cartographic referential, and its normal vector.
	Data 1 : Latitude of a point of the projection plane (radian)
	Data 2 : Longitude of a point of the projection plane (radian)
	Data 3 : Elevation of a point of the projection plane (usually zero metre)
	Data 4 : the geodesic azimuth (radian, usually zero so that Yc is North and Xc is East, π/2 means Yc is East and Xc South)
	Data 5 : angle of sight (usually π/2, so that the plane is tangent to the ellipsoid)
	Data 6 : azimuth of the normal vector of the projection plane (not of use if Data 5 = π/2)
	Origin of the resulting cartographic referential is the point used to define the plane.
	$02 = Stereographic (oblique on a sphere)
	The plane is described by the point of tangency. It shall be assumed that the tangent plane lies at zero elevation.
	Data 1 : Latitude of the point of tangency of the tangent projection plane (radian)
	Data 2 : Longitude of the point of tangency of the tangent projection plane (radian)
	Data 3 : sphere radius (metre)
	Data 4 : Xc origin (metre, usually zero)
	Data 5 : Yc origin (metre, usually zero)
	Origin of the resulting cartographic referential is the point of tangency, with the specified offsets.
	$03 = Transverse Mercator
	Projection onto a cylinder whose axis is in the equatorial plane. General description is preferred, even if the only true parameter is the meridian of tangency, all other
	parameters being conventionally set :
	Data 1 : the meridian (longitude) of tangency (radian)
	Data 2 : the latitude of tangency (radian; it is usually the equator, zero)
	Data 3 : Xc origin (it is usually an offset of 500,000 metre from the meridian of tangency)
	Data 4 : Yc origin (it is usually on the equator, i. e. zero metre, but often fits the latitude, like 4,500,000 in Europe)
	Data 5 : scale (usually 1 or 0.9996)
	Origin of the resulting cartographic referential is described with an offset in metre from the crossing of this meridian and the equator.
	UTM projections are Transverse Mercator projections, numbered UTM 1 to UTM 60, used to that cover 6 degree lunes. If F refers to the UTM number, then UTM F
	is typically used to cover longitude [6(F-31), 6(F-30)] and Data 1 is 6(F-31)+ 3 (to convert in radian).
	$04 = Mercator
	Projection onto a cylinder whose axis is in the equatorial plane. General description is preferred, even if the only true parameter is the meridian of tangency, all other
	parameters being conventionally set :
	Data 1 : the meridian (longitude) of tangency (radian)
	Data 2 : the latitude of tangency (radian)
	Data 3 : the geodesic azimuth (radian)
	Data 4 : angle of rotation of the Xc, Yc axes (radian, usually zero)
	Data 5 : sphere radius (metre)
	Data 6 : Xc origin (metre)
	Data 7 : Yc origin (metre)
	Image referential
	The rectified image does not need to be rotated to fit the cartographic axes defined by the projection. The coordinates of an y pixel of the rectified image into the
	cartographic referential (defined by the projection) is described by the function :
	 Xc  Axx      Axy   X  Cx 
	 Yc    Ayx                 
	Ayy   Y  Cy 
	  
	where :
	(X, Y) are the coordinates of the pixel in the rectified image referential,
	(Xc, Yc) are the coordinates in the cartographic referential (usually Xc axis is heading East and Yc axis is heading North),
	[C] holds the translation (such that (- Cx,- Cy) are the cartographic coordinates in metres of the pixel (0,0))
	[A] matrix holds the rotation of the image in the cartographic referential, it scales and when necessary flips coefficients.
	Y
	Yc
	North
	X
	Xc
	East
	Figure A-17 – Coordinates.
	Image bounding box
	Even in a non-rotated rectified image referential, there may be some undefined pixels. It is up to the producing system to define invalid data pixels (defined in the
	RADAR Element Data Table) to determine the exact boundary of the valid pixels.
*/
public class RectifiedImageGeometryDataTable extends DataTable {
    private double axx;
    private double axy;
    private double ayx;
    private double ayy;
    private double cx;
    private double cy;
    private double data1;
}
