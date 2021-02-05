package ueb11;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

    private Color color;

    @Test
    public void testArrayConstructor() {
        Color color = new Color(0xFF, 0, 0);
        assertArrayEquals(new int[]{0xFF, 0, 0}, color.getRGB());
    }

    @Test
    public void testRgbConstructor() {
        color = new Color(10, 128, 255);
        assertArrayEquals(new int[]{10, 128, 255}, color.getRGB());
    }

    @Test
    public void testColorNameConstructor() {
        color = new Color(Color.ColorNames.WHITE);
        assertArrayEquals(new int[]{0xFF, 0xFF, 0xFF}, color.getRGB());
    }

    @Test
    public void testNewColor() {
        assertNull(Color.newColor("unbekannt"));
        assertNotNull(Color.newColor("RED"));
    }

    @Test
    public void testIsKnownColorName() {
        assertFalse(Color.isKnownColorName("unbekannt"));
        assertTrue(Color.isKnownColorName("RED"));
    }

    @Test
    public void testGetRGB() {
        Color color = new Color(10, 128, 255);
        assertArrayEquals(new int[]{0x0A, 0x80, 0xFF}, color.getRGB());
    }

    @Test
    public void testGetRGBByChannel() {
        Color color = new Color(10, 128, 255);
        assertEquals(10, color.getRGB(0));
        assertEquals(128, color.getRGB(1));
        assertEquals(255, color.getRGB(2));
    }

    @Test
    public void testGetPackedRGB() {
        Color color = new Color(Color.ColorNames.WHITE);
        assertEquals("ffffff", Integer.toHexString(color.getPackedRGB()));
    }

    @Test
    public void testToString() {
        Color color = new Color(Color.ColorNames.WHITE);
        assertEquals("WHITE", color.toString());
        color = new Color(1, 2, 3);
        assertEquals("#010203", color.toString());
    }
}