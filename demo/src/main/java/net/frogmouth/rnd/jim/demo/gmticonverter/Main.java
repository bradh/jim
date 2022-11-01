package net.frogmouth.rnd.jim.demo.gmticonverter;

import java.io.IOException;

/** GMTI (STANAG 4607) converter. */
public class Main {

    /** @param args the command line arguments */
    public static void main(String[] args) throws IOException {
        Converter converter =
                new Converter(
                        "/home/bradh/coding/jim/jim/s4607/src/test/resources/pr_scenario_10tgts_situationAwarenessMask_cleaned.4607");
        String nits = converter.convertToNITS();
        System.out.println(nits);
    }
}
