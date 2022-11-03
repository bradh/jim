package net.frogmouth.rnd.jim.charsets;

import static org.testng.Assert.*;

import java.nio.charset.StandardCharsets;
import org.testng.annotations.Test;

/** Unit tests for ECS-A character set. */
public class ECS_A_Test {

    public ECS_A_Test() {}

    @Test
    public void checkContains() {
        ECS_A uut = new ECS_A();
        assertFalse(uut.contains(StandardCharsets.UTF_8));
    }

    @Test
    public void simpleEncode() {
        String uut = "0123AZaz";
        byte[] bytes = uut.getBytes(new ECS_A());
        assertEquals(bytes, new byte[] {0x30, 0x31, 0x32, 0x33, 0x41, 0x5a, 0x61, 0x7a});
    }

    @Test
    public void simpleDecode() {
        byte[] bytes = new byte[] {0x30, 0x31, 0x32, 0x33, 0x41, 0x5a, 0x61, 0x7a};
        String s = new String(bytes, new ECS_A());
        assertEquals(s, "0123AZaz");
    }

    @Test
    public void spaceEncode() {
        assertEquals(" ".getBytes(new ECS_A()), new byte[] {0x20});
    }

    @Test
    public void spaceDecode() {
        assertEquals(new String(new byte[] {0x20}, new ECS_A()), " ");
    }

    @Test
    public void punctuationEncode() {
        assertEquals(
                "!\"#$%&'()*+,-./".getBytes(new ECS_A()),
                new byte[] {
                    0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, 0x2A, 0x2B, 0x2C, 0x2D,
                    0x2E, 0x2F
                });
    }

    @Test
    public void punctuationDecode() {
        assertEquals(
                new String(
                        new byte[] {
                            0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, 0x2A, 0x2B, 0x2C,
                            0x2D, 0x2E, 0x2F
                        },
                        new ECS_A()),
                "!\"#$%&'()*+,-./");
    }

    @Test
    public void morePunctuationEncode() {
        assertEquals(
                ":;<=>?@{|}~[\\]^_`".getBytes(new ECS_A()),
                new byte[] {
                    0x3A, 0x3B, 0x3C, 0x3D, 0x3E, 0x3F, 0x40, 0x7B, 0x7C, 0x7D, 0x7E, 0x5B, 0x5C,
                    0x5D, 0x5E, 0x5F, 0x60
                });
    }

    @Test
    public void morePunctuationDecode() {
        assertEquals(
                new String(
                        new byte[] {
                            0x3A, 0x3B, 0x3C, 0x3D, 0x3E, 0x3F, 0x40, 0x7B, 0x7C, 0x7D, 0x7E, 0x5B,
                            0x5C, 0x5D, 0x5E, 0x5F, 0x60
                        },
                        new ECS_A()),
                ":;<=>?@{|}~[\\]^_`");
    }

    @Test
    public void invertedExclamationDecode() {
        assertEquals(new String(new byte[] {(byte) 0xA1}, new ECS_A()), "¡");
    }

    @Test
    public void invertedExclamationEncode() {
        assertEquals("¡".getBytes(new ECS_A()), new byte[] {(byte) 0xA1});
    }

    @Test
    public void nonBreakingSpaceDecode() {
        assertEquals(new String(new byte[] {(byte) 0xA0}, new ECS_A()), "\u00A0");
    }

    @Test
    public void nonBreakingSpaceEncode() {
        assertEquals("\u00A0".getBytes(new ECS_A()), new byte[] {(byte) 0xA0});
    }

    @Test
    public void currencyDecode() {
        assertEquals(
                new String(
                        new byte[] {
                            (byte) 0xA2,
                            (byte) 0xA3,
                            (byte) 0xA4,
                            (byte) 0xA5,
                            (byte) 0xA6,
                            (byte) 0xA7,
                            (byte) 0xA8,
                            (byte) 0xA9,
                            (byte) 0xAA,
                            (byte) 0xAB,
                            (byte) 0xAC
                        },
                        new ECS_A()),
                "¢£¤¥¦§¨©ª«¬");
    }

    @Test
    public void currencyEncode() {
        assertEquals(
                "¢£¤¥¦§¨©ª«¬".getBytes(new ECS_A()),
                new byte[] {
                    (byte) 0xA2,
                    (byte) 0xA3,
                    (byte) 0xA4,
                    (byte) 0xA5,
                    (byte) 0xA6,
                    (byte) 0xA7,
                    (byte) 0xA8,
                    (byte) 0xA9,
                    (byte) 0xAA,
                    (byte) 0xAB,
                    (byte) 0xAC
                });
    }

    @Test
    public void smallLettersDecode() {
        assertEquals(
                new String(
                        new byte[] {
                            (byte) 0xDF,
                            (byte) 0xE0,
                            (byte) 0xE1,
                            (byte) 0xE2,
                            (byte) 0xE3,
                            (byte) 0xE4,
                            (byte) 0xE5,
                            (byte) 0xE6,
                            (byte) 0xE7,
                            (byte) 0xE8,
                            (byte) 0xE9,
                            (byte) 0xEA,
                            (byte) 0xEB,
                            (byte) 0xEC,
                            (byte) 0xED,
                            (byte) 0xEE,
                            (byte) 0xEF,
                            (byte) 0xF0,
                            (byte) 0xF1,
                            (byte) 0xF2,
                            (byte) 0xF3,
                            (byte) 0xF4,
                            (byte) 0xF5,
                            (byte) 0xF6,
                            (byte) 0xF7,
                            (byte) 0xF8,
                            (byte) 0xF9,
                            (byte) 0xFA,
                            (byte) 0xFB,
                            (byte) 0xFC,
                            (byte) 0xFD,
                            (byte) 0xFE,
                            (byte) 0xFF
                        },
                        new ECS_A()),
                "ßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ");
    }

    @Test
    public void smallLettersEncode() {
        assertEquals(
                "ßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ".getBytes(new ECS_A()),
                new byte[] {
                    (byte) 0xDF,
                    (byte) 0xE0,
                    (byte) 0xE1,
                    (byte) 0xE2,
                    (byte) 0xE3,
                    (byte) 0xE4,
                    (byte) 0xE5,
                    (byte) 0xE6,
                    (byte) 0xE7,
                    (byte) 0xE8,
                    (byte) 0xE9,
                    (byte) 0xEA,
                    (byte) 0xEB,
                    (byte) 0xEC,
                    (byte) 0xED,
                    (byte) 0xEE,
                    (byte) 0xEF,
                    (byte) 0xF0,
                    (byte) 0xF1,
                    (byte) 0xF2,
                    (byte) 0xF3,
                    (byte) 0xF4,
                    (byte) 0xF5,
                    (byte) 0xF6,
                    (byte) 0xF7,
                    (byte) 0xF8,
                    (byte) 0xF9,
                    (byte) 0xFA,
                    (byte) 0xFB,
                    (byte) 0xFC,
                    (byte) 0xFD,
                    (byte) 0xFE,
                    (byte) 0xFF
                });
    }

    @Test
    public void unsupportedEncode() {
        assertEquals("Ή".getBytes(new ECS_A()), "?".getBytes(StandardCharsets.US_ASCII));
    }
}
