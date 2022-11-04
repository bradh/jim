/**
 * ECS-A Charset support.
 *
 * <p>Charset support for the ECS-A encoding specified in STANAG 4607 (GMTI) and the Joint BIIF
 * Profile (JBP, also known as National Imagery Transfer File Standard, NITF, STANAG 4545, NATO
 * Secondary Imagery Format and NSIF)
 */
module net.frogmouth.rnd.jim.charsets {
    provides java.nio.charset.spi.CharsetProvider with
            net.frogmouth.rnd.jim.charsets.ECS_A_Provider;

    exports net.frogmouth.rnd.jim.charsets;
}
