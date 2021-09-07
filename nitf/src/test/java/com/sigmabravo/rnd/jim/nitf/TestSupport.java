package com.sigmabravo.rnd.jim.nitf;

import java.nio.file.Path;
import java.nio.file.Paths;

/** Shared test support code. */
public class TestSupport {

    public TestSupport() {}

    Path getHyperionBIBTestData() {
        String fileName = "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS.ntf";
        return getPathFromResourceName(fileName);
    }

    Path getMIE4NITFManifestTestData() {
        String fileName = "wpr-h264.r0t0q0c0i0.NTF";
        return getPathFromResourceName(fileName);
    }

    protected Path getPathFromResourceName(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName).getPath());
    }
}
