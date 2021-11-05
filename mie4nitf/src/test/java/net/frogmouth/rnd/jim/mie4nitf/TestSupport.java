package net.frogmouth.rnd.jim.mie4nitf;

import java.nio.file.Path;
import java.nio.file.Paths;

/** Shared test support code. */
public class TestSupport {

    public TestSupport() {}

    public Path getMIE4NITFManifestTestData() {
        String fileName = "wpr-h264.r0t0q0c0i0.NTF";
        return getPathFromResourceName(fileName);
    }

    protected Path getPathFromResourceName(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName).getPath());
    }
}
