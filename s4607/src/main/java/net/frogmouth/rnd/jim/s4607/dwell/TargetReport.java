package net.frogmouth.rnd.jim.s4607.dwell;

/**
 * GMTI Target Report.
 *
 * <p>Each Dwell Segment report can contain zero or more radar "hits", which are called targets. The
 * information about a single target is called a Target Report is represented by an instance of this
 * class.
 *
 * <p>One Target Report shall be transmitted for each target observed within the dwell. Targets
 * detected within a dwell may be split among multiple Dwell Segments. Targets detected within a
 * dwell but detected by different radar modes or radar processors shall be reported in separate
 * Dwell Segments (e.g., Endo-Clutter, Exo-Clutter, targets associated with HRR, etc.).
 *
 * <p>Target in this context is from the name Ground Moving Target Indicator, and does not
 * necessarily represent a valid target in a targeting sense.
 */
public class TargetReport {
    private Integer mtiReportIndex;
    private Double targetLocationLatitude;
    private Double targetLocationLongitude;
    private Integer targetLocationDeltaLatitude;
    private Integer targetLocationDeltaLongitude;
    private Integer targetLocationGeodeticHeight;
    private Integer targetVelocityLineOfSightComponent;
    private Integer targetWrapVelocity;
    private Integer targetSNR;
    private Integer targetClassification;
    private Integer targetClassificationProbability;
    private Integer targetMeasurementUncertaintySlantRange;
    private Integer targetMeasurementUncertaintyCrossRange;
    private Integer targetMeasurementUncertaintyHeight;
    private Integer targetMeasurementUncertaintyRadialVelocity;
    private Integer truthTagApplication;
    private Long truthTagEntity;
    private Integer targetRadarCrossSection;

    /**
     * Constructor.
     *
     * <p>This will leave all fields null. Set as required.
     */
    public TargetReport() {}

    /**
     * Copy Constructor.
     *
     * @param other the source object to copy from.
     */
    public TargetReport(TargetReport other) {
        this.mtiReportIndex = other.mtiReportIndex;
        this.targetLocationLatitude = other.targetLocationLatitude;
        this.targetLocationLongitude = other.targetLocationLongitude;
        this.targetLocationDeltaLatitude = other.targetLocationDeltaLatitude;
        this.targetLocationDeltaLongitude = other.targetLocationDeltaLongitude;
        this.targetLocationGeodeticHeight = other.targetLocationGeodeticHeight;
        this.targetVelocityLineOfSightComponent = other.targetVelocityLineOfSightComponent;
        this.targetWrapVelocity = other.targetWrapVelocity;
        this.targetSNR = other.targetSNR;
        this.targetClassification = other.targetClassification;
        this.targetClassificationProbability = other.targetClassificationProbability;
        this.targetMeasurementUncertaintySlantRange = other.targetMeasurementUncertaintySlantRange;
        this.targetMeasurementUncertaintyCrossRange = other.targetMeasurementUncertaintyCrossRange;
        this.targetMeasurementUncertaintyHeight = other.targetMeasurementUncertaintyHeight;
        this.targetMeasurementUncertaintyRadialVelocity =
                other.targetMeasurementUncertaintyRadialVelocity;
        this.truthTagApplication = other.truthTagApplication;
        this.truthTagEntity = other.truthTagEntity;
        this.targetRadarCrossSection = other.targetRadarCrossSection;
    }

    /**
     * MTI Report Index (D32.1).
     *
     * <p>The sequential count of this MTI report within the dwell.
     *
     * <p>Field D32.1 is Conditional and must be sent if an HRR report is provided for targets in
     * this dwell.
     *
     * @return the MTI report index, or null if not set.
     */
    public Integer getMtiReportIndex() {
        return mtiReportIndex;
    }

    /**
     * Set the MTI Report Index (D32.1).
     *
     * <p>The sequential count of this MTI report within the dwell.
     *
     * <p>Field D32.1 is Conditional and must be sent if an HRR report is provided for targets in
     * this dwell.
     *
     * @param mtiReportIndex the MTI report index as an integer count in the range 0 to 65535.
     */
    public void setMtiReportIndex(int mtiReportIndex) {
        this.mtiReportIndex = mtiReportIndex;
    }

    /**
     * Target Location – High-Resolution Latitude (D32.2).
     *
     * <p>The North-South position of the reported detection, expressed as degrees North (positive)
     * or South (negative) of the Equator.
     *
     * <p>Field D32.2 is Conditional and is always sent with field D32.3. They are sent only when
     * the transmission bandwidth permits the use of 4 bytes each for target latitude and longitude.
     * If fields D32.2 and D32.3 are sent, then fields D32.4 and D32.5 are not sent.
     *
     * @return the latitude value as a floating point number, or null if not set
     */
    public Double getTargetLocationLatitude() {
        return targetLocationLatitude;
    }

    /**
     * Set the Target Location – High-Resolution Latitude (D32.2).
     *
     * <p>The North-South position of the reported detection, expressed as degrees North (positive)
     * or South (negative) of the Equator.
     *
     * <p>Field D32.2 is Conditional and is always sent with field D32.3. They are sent only when
     * the transmission bandwidth permits the use of 4 bytes each for target latitude and longitude.
     * If fields D32.2 and D32.3 are sent, then fields D32.4 and D32.5 are not sent.
     *
     * @param targetLocationLatitude the latitude value as a floating point number
     */
    public void setTargetLocationLatitude(double targetLocationLatitude) {
        this.targetLocationLatitude = targetLocationLatitude;
    }

    /**
     * Target Location – High-Resolution Longitude (D32.3).
     *
     * <p>The East-West position of the reported detection, expressed as degrees East (positive)
     * from the Prime Meridian.
     *
     * <p>Field D32.3 is Conditional and is always sent with field D32.2. They are sent only when
     * the transmission bandwidth permits the use of 4 bytes each for target latitude and longitude.
     * If fields D32.2 and D32.3 are sent, then fields D32.4 and D32.5 are not sent.
     *
     * @return the longitude as a floating point number, or null if not set
     */
    public Double getTargetLocationLongitude() {
        return targetLocationLongitude;
    }

    /**
     * Set the Target Location – High-Resolution Longitude (D32.3).
     *
     * <p>The East-West position of the reported detection, expressed as degrees East (positive)
     * from the Prime Meridian.
     *
     * <p>Field D32.3 is Conditional and is always sent with field D32.2. They are sent only when
     * the transmission bandwidth permits the use of 4 bytes each for target latitude and longitude.
     * If fields D32.2 and D32.3 are sent, then fields D32.4 and D32.5 are not sent.
     *
     * @param targetLocationLongitude the longitude as a floating point number, or null if not set
     */
    public void setTargetLocationLongitude(double targetLocationLongitude) {
        this.targetLocationLongitude = targetLocationLongitude;
    }

    /**
     * Target Location – Delta Latitude (D32.4).
     *
     * <p>The North-South position of the reported detection, expressed as degrees North (positive)
     * or South (negative) from the Dwell Area Centre Latitude (the Reference Point) sent in Field
     * D24. This field shall be sent when it is necessary to send the reduced bandwidth version of
     * the Target Report. Delta Latitude is used in conjunction with the Latitude Scale factor
     * (field D10) and the Dwell Area Centre Latitude (field D24) to recover the target latitude as
     * follows:
     *
     * <p>Latitude = [(Delta Lat) x (Lat Scale)] + (Centre Lat)
     *
     * <p>Field D32.4 is Conditional and is always sent with fields D32.5, D10, and D11. They shall
     * be used when the transmission bandwidth and the number of targets do not permit the use of 4
     * bytes each for target latitude and longitude. If fields D32.4, D32.5, D10, and D11 are sent,
     * then fields D32.2 and D32.3 are not sent.
     *
     * @return the delta latitude value, or null if not set.
     */
    public Integer getTargetLocationDeltaLatitude() {
        return targetLocationDeltaLatitude;
    }

    /**
     * Set the Target Location – Delta Latitude (D32.4).
     *
     * <p>The North-South position of the reported detection, expressed as degrees North (positive)
     * or South (negative) from the Dwell Area Centre Latitude (the Reference Point) sent in Field
     * D24. This field shall be sent when it is necessary to send the reduced bandwidth version of
     * the Target Report. Delta Latitude is used in conjunction with the Latitude Scale factor
     * (field D10) and the Dwell Area Centre Latitude (field D24) to recover the target latitude as
     * follows:
     *
     * <p>Latitude = [(Delta Lat) x (Lat Scale)] + (Centre Lat)
     *
     * <p>Field D32.4 is Conditional and is always sent with fields D32.5, D10, and D11. They shall
     * be used when the transmission bandwidth and the number of targets do not permit the use of 4
     * bytes each for target latitude and longitude. If fields D32.4, D32.5, D10, and D11 are sent,
     * then fields D32.2 and D32.3 are not sent.
     *
     * @param targetLocationDeltaLatitude the delta latitude value, in the range -32768 to +32767.
     */
    public void setTargetLocationDeltaLatitude(int targetLocationDeltaLatitude) {
        this.targetLocationDeltaLatitude = targetLocationDeltaLatitude;
    }

    /**
     * Target Location – Delta Longitude (D32.5).
     *
     * <p>The East-West position of the reported detection, expressed as degrees East (positive)
     * from the Dwell Area Centre Longitude (the Reference Point) sent in Field D25. This field is
     * sent when it is necessary to send the reduced bandwidth version of the Target Report. Delta
     * Longitude is used in conjunction with the Longitude Scale factor (field D11) and the Dwell
     * Area Centre Longitude (field D25) to recover the target latitude as follows:
     *
     * <p>Longitude = [(Delta Long) x (Long Scale)] + (Centre Long)
     *
     * <p>Field D32.5 is Conditional and is always sent with fields D32.4, D10, and D11. They shall
     * be used when the transmission bandwidth and the number of targets do not permit the use of 4
     * bytes each for target latitude and longitude. If fields D32.4, D32.5, D10, and D11 are sent,
     * then fields D32.2 and D32.3 are not sent.
     *
     * @return the delta longitude value, or null if not set.
     */
    public Integer getTargetLocationDeltaLongitude() {
        return targetLocationDeltaLongitude;
    }

    /**
     * Set the Target Location – Delta Longitude (D32.5).
     *
     * <p>The East-West position of the reported detection, expressed as degrees East (positive)
     * from the Dwell Area Centre Longitude (the Reference Point) sent in Field D25. This field is
     * sent when it is necessary to send the reduced bandwidth version of the Target Report. Delta
     * Longitude is used in conjunction with the Longitude Scale factor (field D11) and the Dwell
     * Area Centre Longitude (field D25) to recover the target latitude as follows:
     *
     * <p>Longitude = [(Delta Long) x (Long Scale)] + (Centre Long)
     *
     * <p>Field D32.5 is Conditional and is always sent with fields D32.4, D10, and D11. They shall
     * be used when the transmission bandwidth and the number of targets do not permit the use of 4
     * bytes each for target latitude and longitude. If fields D32.4, D32.5, D10, and D11 are sent,
     * then fields D32.2 and D32.3 are not sent.
     *
     * @param targetLocationDeltaLongitude the delta longitude value, in the range -32768 to +32767.
     */
    public void setTargetLocationDeltaLongitude(int targetLocationDeltaLongitude) {
        this.targetLocationDeltaLongitude = targetLocationDeltaLongitude;
    }

    /**
     * Target Location – Geodetic Height (D32.6).
     *
     * <p>The height of the reported detection, referenced to its position above the WGS 84
     * ellipsoid, expressed in meters. This field reports the geodetic height used within the
     * translation from the target’s radar coordinates to the target’s geodetic coordinates.
     *
     * <p>If this field is not sent, the target height shall be interpreted as being on the earth
     * model described in the Job Definition Segment, fields J27 and J28.
     *
     * <p>Field D32.6 (this field) is Optional.
     *
     * @return the target location above the ellipsoid in metres, or null if not set.
     */
    public Integer getTargetLocationGeodeticHeight() {
        return targetLocationGeodeticHeight;
    }

    /**
     * Set the Target Location – Geodetic Height (D32.6).
     *
     * <p>The height of the reported detection, referenced to its position above the WGS 84
     * ellipsoid, expressed in meters. This field reports the geodetic height used within the
     * translation from the target’s radar coordinates to the target’s geodetic coordinates.
     *
     * <p>If this field is not sent, the target height shall be interpreted as being on the earth
     * model described in the Job Definition Segment, fields J27 and J28.
     *
     * <p>Field D32.6 (this field) is Optional.
     *
     * @param targetLocationGeodeticHeight the target location above the ellipsoid in metres, in the
     *     range -1000 to + 32767.
     */
    public void setTargetLocationGeodeticHeight(int targetLocationGeodeticHeight) {
        this.targetLocationGeodeticHeight = targetLocationGeodeticHeight;
    }

    /**
     * Target Velocity Line-Of-Sight Component (D32.7).
     *
     * <p>The component of velocity for the reported detection, expressed in centimetres per second,
     * corrected for platform motion, along the line of sight between the sensor and the reported
     * detection, where the positive direction is away from the sensor.
     *
     * <p>NOTE: Target Velocity Line-Of-Sight Component may also be known as Radial Velocity.
     *
     * <p>Field D32.7 (this field) is optional. If field D32.7 is sent, then field D32.8 shall also
     * be sent.
     *
     * @return target velocity line of sight component, in centimetres per second, or null if not
     *     set.
     */
    public Integer getTargetVelocityLineOfSightComponent() {
        return targetVelocityLineOfSightComponent;
    }

    /**
     * Set the Target Velocity Line-Of-Sight Component (D32.7).
     *
     * <p>The component of velocity for the reported detection, expressed in centimetres per second,
     * corrected for platform motion, along the line of sight between the sensor and the reported
     * detection, where the positive direction is away from the sensor.
     *
     * <p>NOTE: Target Velocity Line-Of-Sight Component may also be known as Radial Velocity.
     *
     * <p>Field D32.7 (this field) is optional. If field D32.7 is sent, then field D32.8 shall also
     * be sent.
     *
     * @param targetVelocityLineOfSightComponent target velocity line of sight component, in
     *     centimetres per second, in the range -32768 to +32767.
     */
    public void setTargetVelocityLineOfSightComponent(int targetVelocityLineOfSightComponent) {
        this.targetVelocityLineOfSightComponent = targetVelocityLineOfSightComponent;
    }

    /**
     * Target Wrap Velocity (D32.8).
     *
     * <p>For most radars this is calculable as the effective Pulse Repetition Frequency (PRF)
     * (i.e., the product of PRF's on Coherent Processing Intervals (CPI's) for which the target was
     * detected) multiplied by the effective sensor wavelength divided by four. The target wrap
     * velocity permits trackers to un-wrap velocities for targets with line-of-sight components
     * large enough to exceed the first velocity period. When the target's wrap velocity is low
     * compared to the target's expected line-of-sight velocity, the tracker may consider adding
     * multiples of twice the target wrap velocity to field D32.7.
     *
     * <p>Field D32.8 (this field) is optional. If field D32.8 is sent, then field D32.7 shall also
     * be sent.
     *
     * @return the target wrap velocity in centimetres per second, or null if not set.
     */
    public Integer getTargetWrapVelocity() {
        return targetWrapVelocity;
    }

    /**
     * Set the Target Wrap Velocity (D32.8).
     *
     * <p>For most radars this is calculable as the effective Pulse Repetition Frequency (PRF)
     * (i.e., the product of PRF's on Coherent Processing Intervals (CPI's) for which the target was
     * detected) multiplied by the effective sensor wavelength divided by four. The target wrap
     * velocity permits trackers to un-wrap velocities for targets with line-of-sight components
     * large enough to exceed the first velocity period. When the target's wrap velocity is low
     * compared to the target's expected line-of-sight velocity, the tracker may consider adding
     * multiples of twice the target wrap velocity to field D32.7.
     *
     * <p>Field D32.8 (this field) is optional. If field D32.8 is sent, then field D32.7 shall also
     * be sent.
     *
     * @param targetWrapVelocity the target wrap velocity in centimetres per second in the range 0
     *     to 65535.
     */
    public void setTargetWrapVelocity(int targetWrapVelocity) {
        this.targetWrapVelocity = targetWrapVelocity;
    }

    /**
     * Target SNR (D32.9).
     *
     * <p>Estimated signal-to-noise ratio (SNR) of the target return, expressed in decibels.
     *
     * <p>Field D32.9 (this field) is Optional.
     *
     * @return the signal to noise ratio (SNR) in decibels, or null if not set.
     */
    public Integer getTargetSNR() {
        return targetSNR;
    }

    /**
     * Set the Target SNR (D32.9).
     *
     * <p>Estimated signal-to-noise ratio (SNR) of the target return, expressed in decibels.
     *
     * <p>Field D32.9 (this field) is Optional.
     *
     * @param targetSNR the signal to noise ratio (SNR) in decibels, in the range -128 to +127.
     */
    public void setTargetSNR(int targetSNR) {
        this.targetSNR = targetSNR;
    }

    /**
     * Target Classification (D32.10).
     *
     * <p>An enumeration field denoting the classification of the target. Classification types shall
     * include wheeled, non-wheeled (i.e., tracked), helicopter, low-slow flyer, rotating antenna,
     * maritime, beacon, and unknown, for both live and simulated targets. If a target can not be
     * classified, it shall be marked as “unknown”.
     *
     * <table border="1">
     * <caption>Target Classification</caption>
     * <thead>
     * <tr><td>VALUE</td><td>TARGET CLASSIFICATION</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>0</td><td>No Information, Live Target</td></tr>
     * <tr><td>1</td><td>Tracked Vehicle, Live Target</td></tr>
     * <tr><td>2</td><td>Wheeled Vehicle, Live Target</td></tr>
     * <tr><td>3</td><td>Rotary Wing Aircraft, Live Target</td></tr>
     * <tr><td>4</td><td>Fixed Wing Aircraft, Live Target</td></tr>
     * <tr><td>5</td><td>Stationary Rotator, Live Target</td></tr>
     * <tr><td>6</td><td>Maritime, Live Target</td></tr>
     * <tr><td>7</td><td>Beacon, Live Target</td></tr>
     * <tr><td>8</td><td>Amphibious, Live Target</td></tr>
     * <tr><td>9</td><td>Person, Live Target</td></tr>
     * <tr><td>10</td><td>Vehicle, Live Target</td></tr>
     * <tr><td>11</td><td>Animal, Live Target</td></tr>
     * <tr><td>12</td><td>Large Multiple-Return, Live Land Target</td></tr>
     * <tr><td>13</td><td>Large Multiple-Return, Live Maritime Target</td></tr>
     * <tr><td>14</td><td>Clutter, Live Target</td></tr>
     * <tr><td>15</td><td>Phantom Live</td></tr>
     * <tr><td>16</td><td>Ground Rotator Live</td></tr>
     * <tr><td>17</td><td>Small Vehicle, Live Target</td></tr>
     * <tr><td>18</td><td>Low-slow Flyer, Live Target</td></tr>
     * <tr><td>19-125</td><td>Reserved</td></tr>
     * <tr><td>126</td><td>Other, Live Target</td></tr>
     * <tr><td>127</td><td>Unknown, Live Target</td></tr>
     * <tr><td>128</td><td>No Information, Simulated Target</td></tr>
     * <tr><td>129</td><td>Tracked Vehicle, Simulated Target</td></tr>
     * <tr><td>130</td><td>Wheeled Vehicle, Simulated Target</td></tr>
     * <tr><td>131</td><td>Rotary Wing Aircraft, Simulated Target</td></tr>
     * <tr><td>132</td><td>Fixed Wing Aircraft, Simulated Target</td></tr>
     * <tr><td>133</td><td>Stationary Rotator, Simulated Target</td></tr>
     * <tr><td>134</td><td>Maritime, Simulated Target</td></tr>
     * <tr><td>135</td><td>Beacon, Simulated Target</td></tr>
     * <tr><td>136</td><td>Amphibious, Simulated Target</td></tr>
     * <tr><td>137</td><td>Person, Simulated Target</td></tr>
     * <tr><td>138</td><td>Vehicle, Simulated Target</td></tr>
     * <tr><td>139</td><td>Animal, Simulated Target</td></tr>
     * <tr><td>140</td><td>Large Multiple-Return, Simulated Land Target</td></tr>
     * <tr><td>141</td><td>Large Multiple-Return, Simulated Maritime Target</td></tr>
     * <tr><td>142</td><td>Tagging Device</td></tr>
     * <tr><td>143</td><td>Reserved</td></tr>
     * <tr><td>144</td><td>Clutter, Simulated Target</td></tr>
     * <tr><td>145</td><td>Phantom Simulated</td></tr>
     * <tr><td>146</td><td>Ground Rotator Simulated</td></tr>
     * <tr><td>147</td><td>Small Vehicle, Simulated Target</td></tr>
     * <tr><td>148</td><td>Low-slow Flyer, Simulated Target</td></tr>
     * <tr><td>149-253</td><td>Reserved</td></tr>
     * <tr><td>254</td><td>Other, Simulated Target</td></tr>
     * <tr><td>255</td><td>Unknown, Simulated Target</td></tr>
     * </tbody>
     * </table>
     *
     * <p>Field D32.10 is Optional.
     *
     * @return target classification as an enumeration value, or null if not set
     */
    public Integer getTargetClassification() {
        return targetClassification;
    }

    /**
     * Get text representation of target classification (D32.10).
     *
     * @return string representing the target classification.
     */
    public String getTargetClassificationAsText() {
        return TargetClassificationLookupTable.getValue(targetClassification);
    }

    /**
     * Set the Target Classification (D32.10).
     *
     * <p>An enumeration field denoting the classification of the target. Classification types shall
     * include wheeled, non-wheeled (i.e., tracked), helicopter, low-slow flyer, rotating antenna,
     * maritime, beacon, and unknown, for both live and simulated targets. If a target can not be
     * classified, it shall be marked as “unknown”.
     *
     * <table border="1">
     * <caption>Target Classification</caption>
     * <thead>
     * <tr><td>VALUE</td><td>TARGET CLASSIFICATION</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>0</td><td>No Information, Live Target</td></tr>
     * <tr><td>1</td><td>Tracked Vehicle, Live Target</td></tr>
     * <tr><td>2</td><td>Wheeled Vehicle, Live Target</td></tr>
     * <tr><td>3</td><td>Rotary Wing Aircraft, Live Target</td></tr>
     * <tr><td>4</td><td>Fixed Wing Aircraft, Live Target</td></tr>
     * <tr><td>5</td><td>Stationary Rotator, Live Target</td></tr>
     * <tr><td>6</td><td>Maritime, Live Target</td></tr>
     * <tr><td>7</td><td>Beacon, Live Target</td></tr>
     * <tr><td>8</td><td>Amphibious, Live Target</td></tr>
     * <tr><td>9</td><td>Person, Live Target</td></tr>
     * <tr><td>10</td><td>Vehicle, Live Target</td></tr>
     * <tr><td>11</td><td>Animal, Live Target</td></tr>
     * <tr><td>12</td><td>Large Multiple-Return, Live Land Target</td></tr>
     * <tr><td>13</td><td>Large Multiple-Return, Live Maritime Target</td></tr>
     * <tr><td>14</td><td>Clutter, Live Target</td></tr>
     * <tr><td>15</td><td>Phantom Live</td></tr>
     * <tr><td>16</td><td>Ground Rotator Live</td></tr>
     * <tr><td>17</td><td>Small Vehicle, Live Target</td></tr>
     * <tr><td>18</td><td>Low-slow Flyer, Live Target</td></tr>
     * <tr><td>19-125</td><td>Reserved</td></tr>
     * <tr><td>126</td><td>Other, Live Target</td></tr>
     * <tr><td>127</td><td>Unknown, Live Target</td></tr>
     * <tr><td>128</td><td>No Information, Simulated Target</td></tr>
     * <tr><td>129</td><td>Tracked Vehicle, Simulated Target</td></tr>
     * <tr><td>130</td><td>Wheeled Vehicle, Simulated Target</td></tr>
     * <tr><td>131</td><td>Rotary Wing Aircraft, Simulated Target</td></tr>
     * <tr><td>132</td><td>Fixed Wing Aircraft, Simulated Target</td></tr>
     * <tr><td>133</td><td>Stationary Rotator, Simulated Target</td></tr>
     * <tr><td>134</td><td>Maritime, Simulated Target</td></tr>
     * <tr><td>135</td><td>Beacon, Simulated Target</td></tr>
     * <tr><td>136</td><td>Amphibious, Simulated Target</td></tr>
     * <tr><td>137</td><td>Person, Simulated Target</td></tr>
     * <tr><td>138</td><td>Vehicle, Simulated Target</td></tr>
     * <tr><td>139</td><td>Animal, Simulated Target</td></tr>
     * <tr><td>140</td><td>Large Multiple-Return, Simulated Land Target</td></tr>
     * <tr><td>141</td><td>Large Multiple-Return, Simulated Maritime Target</td></tr>
     * <tr><td>142</td><td>Tagging Device</td></tr>
     * <tr><td>143</td><td>Reserved</td></tr>
     * <tr><td>144</td><td>Clutter, Simulated Target</td></tr>
     * <tr><td>145</td><td>Phantom Simulated</td></tr>
     * <tr><td>146</td><td>Ground Rotator Simulated</td></tr>
     * <tr><td>147</td><td>Small Vehicle, Simulated Target</td></tr>
     * <tr><td>148</td><td>Low-slow Flyer, Simulated Target</td></tr>
     * <tr><td>149-253</td><td>Reserved</td></tr>
     * <tr><td>254</td><td>Other, Simulated Target</td></tr>
     * <tr><td>255</td><td>Unknown, Simulated Target</td></tr>
     * </tbody>
     * </table>
     *
     * <p>Field D32.10 is Optional.
     *
     * @param targetClassification target classification as an enumeration value
     */
    public void setTargetClassification(int targetClassification) {
        this.targetClassification = targetClassification;
    }

    /**
     * Target Classification Probability (D32.11).
     *
     * <p>The estimated probability that the target classification appearing in field D32.10 is
     * correctly classified.
     *
     * <p>Field D32.11 (this field) is Optional.
     *
     * @return the probability as a percentage, or null if not set.
     */
    public Integer getTargetClassificationProbability() {
        return targetClassificationProbability;
    }

    /**
     * Set the Target Classification Probability (D32.11).
     *
     * <p>The estimated probability that the target classification appearing in field D32.10 is
     * correctly classified.
     *
     * <p>Field D32.11 (this field) is Optional.
     *
     * @param targetClassificationProbability the probability as a percentage in the range 0 to 100.
     */
    public void setTargetClassificationProbability(int targetClassificationProbability) {
        this.targetClassificationProbability = targetClassificationProbability;
    }

    /**
     * Target Measurement Uncertainty – Slant Range (D32.12).
     *
     * <p>The standard deviation of the estimated slant range of the reported detection, expressed
     * in centimetres.
     *
     * <p>Field D32.12 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment are sent, and shall be sent with fields D32.13, D32.14, and D32.15, if they
     * are available.
     *
     * @return the target slant range measurement uncertainty in centimetres, or null if not set.
     */
    public Integer getTargetMeasurementUncertaintySlantRange() {
        return targetMeasurementUncertaintySlantRange;
    }

    /**
     * Set the Target Measurement Uncertainty – Slant Range (D32.12).
     *
     * <p>The standard deviation of the estimated slant range of the reported detection, expressed
     * in centimetres.
     *
     * <p>Field D32.12 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment are sent, and shall be sent with fields D32.13, D32.14, and D32.15, if they
     * are available.
     *
     * @param uncertainty the target slant range measurement uncertainty in centimetres, in the
     *     range 0 to 65535.
     */
    public void setTargetMeasurementUncertaintySlantRange(int uncertainty) {
        this.targetMeasurementUncertaintySlantRange = uncertainty;
    }

    /**
     * Target Measurement Uncertainty – Cross Range (D32.13).
     *
     * <p>The standard deviation of the position estimate, in the cross-range direction, of the
     * reported detection, expressed in decimetres.
     *
     * <p>Field D32.13 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment are sent, and shall be sent with fields D32.12, D32.14, and D32.15, if they
     * are available.
     *
     * @return the target cross range measurement uncertainty in decimetres, or null if not set.
     */
    public Integer getTargetMeasurementUncertaintyCrossRange() {
        return targetMeasurementUncertaintyCrossRange;
    }

    /**
     * Set the Target Measurement Uncertainty – Cross Range (D32.13).
     *
     * <p>The standard deviation of the position estimate, in the cross-range direction, of the
     * reported detection, expressed in decimetres.
     *
     * <p>Field D32.13 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment are sent, and shall be sent with fields D32.12, D32.14, and D32.15, if they
     * are available.
     *
     * @param uncertainty the target cross range measurement uncertainty in decimetres, in the range
     *     0 to 65535.
     */
    public void setTargetMeasurementUncertaintyCrossRange(int uncertainty) {
        this.targetMeasurementUncertaintyCrossRange = uncertainty;
    }

    /**
     * Target Measurement Uncertainty – Height (D32.14).
     *
     * <p>The standard deviation of the estimated geodetic height reported in field D32.6, expressed
     * in meters.
     *
     * <p>Field D34.14 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment and D32.6 of the Target Report are sent, and shall be sent with fields
     * D32.12, D32.13, and D32.15, if they are available.
     *
     * @return the target height measurement uncertainty in metres, or null if not set
     */
    public Integer getTargetMeasurementUncertaintyHeight() {
        return targetMeasurementUncertaintyHeight;
    }

    /**
     * Set the Target Measurement Uncertainty – Height (D32.14).
     *
     * <p>The standard deviation of the estimated geodetic height reported in field D32.6, expressed
     * in meters.
     *
     * <p>Field D34.14 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment and D32.6 of the Target Report are sent, and shall be sent with fields
     * D32.12, D32.13, and D32.15, if they are available.
     *
     * @param targetMeasurementUncertaintyHeight the target height measurement uncertainty in
     *     metres, in the range 0 to 255.
     */
    public void setTargetMeasurementUncertaintyHeight(int targetMeasurementUncertaintyHeight) {
        this.targetMeasurementUncertaintyHeight = targetMeasurementUncertaintyHeight;
    }

    /**
     * Target Measurement Uncertainty – Target Radial Velocity (D32.15).
     *
     * <p>The standard deviation of the measured line-of-sight velocity component reported in field
     * D32.7, expressed in centimetres per second.
     *
     * <p>Field D32.15 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment and D32.7 of the Target Report are sent, and shall be sent with fields
     * D32.12, D32.13, and D32.14, if they are available.
     *
     * @return the target radial velocity uncertainty, in centimetres per second, or null if not set
     */
    public Integer getTargetMeasurementUncertaintyRadialVelocity() {
        return targetMeasurementUncertaintyRadialVelocity;
    }

    /**
     * Set the Target Measurement Uncertainty – Target Radial Velocity (D32.15).
     *
     * <p>The standard deviation of the measured line-of-sight velocity component reported in field
     * D32.7, expressed in centimetres per second.
     *
     * <p>Field D32.15 (this field) is Conditional. It is sent only if fields D12, D13, and D14 of
     * the Dwell Segment and D32.7 of the Target Report are sent, and shall be sent with fields
     * D32.12, D32.13, and D32.14, if they are available.
     *
     * @param uncertainty the target radial velocity uncertainty, in centimetres per second, in the
     *     range 0 to 5000
     */
    public void setTargetMeasurementUncertaintyRadialVelocity(int uncertainty) {
        this.targetMeasurementUncertaintyRadialVelocity = uncertainty;
    }

    /**
     * Truth Tag – Application (D32.16).
     *
     * <p>The Truth Tag- Application is the Application Field truncated to 8 bits, from the Entity
     * State Protocol Data Unit (PDU) used to generate the MTI Target. If the MTI Target is the
     * result of more than one Entity State PDU, then the value of the target with the highest
     * instantaneous radar return is passed in this field. A value of all zeros indicates that no
     * information is available regarding the entity state PDU that was used to generate the MTI
     * Target being passed. For simulated data, the truth tag relates targets back to the truth
     * data, which is represented using Distributed Interactive Simulation (DIS) Entity State PDUs.
     * If the target classification field is classified as 140 then the truth tag application field
     * will indicate the battery strength of the tagging device. The battery strength will be
     * represented as a percentage of charge from 1-100. A value of 0 will mean that the tagging
     * device does not have the ability to monitor its battery strength.
     *
     * <p>Field D32.16 (this field) is Conditional and is sent only if the MTI Target in the Report
     * is simulated or a tagging device is detected. It is always sent with field D32.17.
     *
     * @return the truth tag application value, or null if not set.
     */
    public Integer getTruthTagApplication() {
        return truthTagApplication;
    }

    /**
     * Set the Truth Tag – Application (D32.16).
     *
     * <p>The Truth Tag- Application is the Application Field truncated to 8 bits, from the Entity
     * State Protocol Data Unit (PDU) used to generate the MTI Target. If the MTI Target is the
     * result of more than one Entity State PDU, then the value of the target with the highest
     * instantaneous radar return is passed in this field. A value of all zeros indicates that no
     * information is available regarding the entity state PDU that was used to generate the MTI
     * Target being passed. For simulated data, the truth tag relates targets back to the truth
     * data, which is represented using Distributed Interactive Simulation (DIS) Entity State PDUs.
     * If the target classification field is classified as 140 then the truth tag application field
     * will indicate the battery strength of the tagging device. The battery strength will be
     * represented as a percentage of charge from 1-100. A value of 0 will mean that the tagging
     * device does not have the ability to monitor its battery strength.
     *
     * <p>Field D32.16 (this field) is Conditional and is sent only if the MTI Target in the Report
     * is simulated or a tagging device is detected. It is always sent with field D32.17.
     *
     * @param truthTagApplication the truth tag application value in the range 0 to 255.
     */
    public void setTruthTagApplication(int truthTagApplication) {
        this.truthTagApplication = truthTagApplication;
    }

    /**
     * Truth Tag – Entity (D32.17).
     *
     * <p>The Truth Tag - Entity is the Entity Field from the Entity State PDU used to generate the
     * MTI Target. It is passed as a 32 bit value, in the same format as the Entity State PDU
     * Identity value. A value of all zeros indicates that no information is available regarding the
     * Entity State PDU that was used to generate the MTI Target being passed. For simulated data,
     * the Truth Tag relates targets back to the truth data, which is represented using DIS Entity
     * State PDUs. If the target classification field is 140 then the truth tag entity field will be
     * the tag identification number transmitted by a tagging device.
     *
     * <p>Field D32.17 (this field) is conditional and is sent only if the MTI Target in this report
     * is simulated or a tagging device is detected. It is always sent with field D32.16.
     *
     * @return the truth tag entity value, or null if not set.
     */
    public Long getTruthTagEntity() {
        return truthTagEntity;
    }

    /**
     * Set the Truth Tag – Entity (D32.17).
     *
     * <p>The Truth Tag - Entity is the Entity Field from the Entity State PDU used to generate the
     * MTI Target. It is passed as a 32 bit value, in the same format as the Entity State PDU
     * Identity value. A value of all zeros indicates that no information is available regarding the
     * Entity State PDU that was used to generate the MTI Target being passed. For simulated data,
     * the Truth Tag relates targets back to the truth data, which is represented using DIS Entity
     * State PDUs. If the target classification field is 140 then the truth tag entity field will be
     * the tag identification number transmitted by a tagging device.
     *
     * <p>Field D32.17 (this field) is conditional and is sent only if the MTI Target in this report
     * is simulated or a tagging device is detected. It is always sent with field D32.16.
     *
     * @param truthTagEntity the truth tag entity value in the range 0 to 4294967295.
     */
    public void setTruthTagEntity(long truthTagEntity) {
        this.truthTagEntity = truthTagEntity;
    }

    /**
     * Radar Cross Section (D32.18).
     *
     * <p>Estimated radar cross section (RCS) of the target return, expressed in half decibels.
     * (dB/2).
     *
     * <p>Field D32.18 is Optional.
     *
     * @return the RCS in half decibels, or null if not set
     */
    public Integer getTargetRadarCrossSection() {
        return targetRadarCrossSection;
    }

    /**
     * Radar Cross Section (D32.18).
     *
     * <p>Estimated radar cross section (RCS) of the target return, expressed in half decibels.
     * (dB/2).
     *
     * <p>Field D32.18 is Optional.
     *
     * @param targetRadarCrossSection the RCS in half decibels, in the range -128 to 127.
     */
    public void setTargetRadarCrossSection(int targetRadarCrossSection) {
        this.targetRadarCrossSection = targetRadarCrossSection;
    }
}
