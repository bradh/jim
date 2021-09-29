module STANAG7023TableExtractorValidatorAndEditorSTEVE {
    exports com.sigmabravo.rnd.jim.npif;

    uses com.sigmabravo.rnd.jim.npif.tables.DataTableParser;

    provides com.sigmabravo.rnd.jim.npif.tables.DataTableParser with
            com.sigmabravo.rnd.jim.npif.tables.missiondata
                    .GeneralAdministrativeReferenceDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.missiondata.MissionSecurityDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.missiondata.AirTaskingOrderDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.missiondata
                    .CollectionPlatformIdentificationDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.missiondata.RequesterDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.missiondata.RequesterRemarksDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.targetinfo.GeneralTargetInformationDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.targetinfo.GeneralTargetLocationDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.targetinfo.GeneralTargetEEIDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.targetinfo.GeneralTargetRemarksDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.platform.MinimumDynamicPlatformDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.platform.ComprehensiveDynamicPlatformDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.platform.SensorGroupingDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.segmentevent.EndOfRecordMarkerDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.segmentevent.EndOfSegmentMarkerDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.segmentevent.EventMarkerDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.segmentevent.SegmentIndexDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.segmentevent.EventIndexDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.SensorIdentificationDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.SensorCalibrationDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .SyncHierarchyAndImageBuildDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .SensorOperatingStatusDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.SensorPositionDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .MinimumSensorAttitudeDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .ComprehensiveSensorAttitudeDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.SensorIndexDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .SensorSampleCoordinateDescriptionDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .SensorSampleTimingDescriptionDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.SensorCompressionDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .JPEGSensorQuantisationDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.JPEGSensorHuffmanDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.JPEG2000DescriptionDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.JPEG2000IndexDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.PassiveSensorDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.PassiveSensorElementDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .RadarSensorDescriptionDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .RadarCollectionPlaneImageGeometryDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.ReferenceTrackDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .RectifiedImageGeometryDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric
                    .VirtualSensorDefinitionDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.RadarParametersDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensorparametric.ISARTrackDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensordata.SensorDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensordata.SensorSampleXCoordinateDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensordata.SensorSampleYCoordinateDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensordata.SensorSampleZCoordinateDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensordata.SensorSampleTimingDataTableParser,
            com.sigmabravo.rnd.jim.npif.tables.sensordata.S4607GMTIDataTableParser;
}
