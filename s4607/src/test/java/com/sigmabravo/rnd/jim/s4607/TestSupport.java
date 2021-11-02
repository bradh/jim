package com.sigmabravo.rnd.jim.s4607;

import java.nio.file.Path;
import java.nio.file.Paths;

/** Shared test support code. */
public class TestSupport {

    public TestSupport() {}

    Path getList1() {
        String fileName = "list1.4607";
        return getPathFromResourceName(fileName);
    }

    protected Path getPathFromResourceName(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName).getPath());
    }
}
