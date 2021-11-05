module STANAG7023TableExtractorValidatorAndEditorSTEVE {
    exports net.frogmouth.rnd.jim.npif;

    requires java.desktop;

    uses net.frogmouth.rnd.jim.npif.tables.DataTableParser;

    provides net.frogmouth.rnd.jim.npif.tables.DataTableParser with
            net.frogmouth.rnd.jim.npif.tables.formatdescription.FormatTimeTagDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.missiondata
                    .GeneralAdministrativeReferenceDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.missiondata.MissionSecurityDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.missiondata.AirTaskingOrderDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.missiondata
                    .CollectionPlatformIdentificationDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.missiondata.RequesterDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.missiondata.RequesterRemarksDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.targetinfo.GeneralTargetInformationDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.targetinfo.GeneralTargetLocationDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.targetinfo.GeneralTargetEEIDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.targetinfo.GeneralTargetRemarksDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.platform.MinimumDynamicPlatformDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.platform.ComprehensiveDynamicPlatformDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.platform.SensorGroupingDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.segmentevent.EndOfRecordMarkerDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.segmentevent.EndOfSegmentMarkerDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.segmentevent.EventMarkerDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.segmentevent.SegmentIndexDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.segmentevent.EventIndexDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.SensorIdentificationDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.SensorCalibrationDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .SyncHierarchyAndImageBuildDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.SensorOperatingStatusDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.SensorPositionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.MinimumSensorAttitudeDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .ComprehensiveSensorAttitudeDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.GimbalsPositionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .MinimumGimbalsAttitudeDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .ComprehensiveGimbalsAttitudeDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.SensorIndexDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .SensorSampleCoordinateDescriptionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .SensorSampleTimingDescriptionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.SensorCompressionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .JPEGSensorQuantisationDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.JPEGSensorHuffmanDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.JPEG2000DescriptionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.JPEG2000IndexDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .PassiveSensorDescriptionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.PassiveSensorElementDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .RadarSensorDescriptionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .RadarCollectionPlaneImageGeometryDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.ReferenceTrackDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .RectifiedImageGeometryDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric
                    .VirtualSensorDefinitionDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.SensorDataTimingDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.RadarParametersDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.RadarElementDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensorparametric.ISARTrackDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.SensorDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.SensorSampleXCoordinateDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.SensorSampleYCoordinateDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.SensorSampleZCoordinateDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.SensorSampleTimingDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.S4607GMTIDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.S4609MotionImageryDataTableParser,
            net.frogmouth.rnd.jim.npif.tables.sensordata.RangeFinderDataTableParser;
}
