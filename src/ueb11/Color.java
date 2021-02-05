package ueb11;

import java.util.Arrays;

/**
 * created by EESSAMMB on 01.02.2021
 */
public class Color {
    enum ColorNames {
        BLACK(new int[]{0x00, 0x00, 0x00}),
        NAVY(new int[]{0x00, 0x00, 0x80}),
        BLUE(new int[]{0x00, 0x00, 0xFF}),
        GREEN(new int[]{0x00, 0x80, 0x00}),
        LIME(new int[]{0x00, 0xFF, 0x00}),
        AQUA(new int[]{0x00, 0xFF, 0xFF}),
        PURPLE(new int[]{0x80, 0x00, 0x80}),
        SILVER(new int[]{0xC0, 0xC0, 0xC0}),
        RED(new int[]{0xFF, 0x00, 0x00}),
        FUCHSIA(new int[]{0xFF, 0x00, 0xFF}),
        YELLOW(new int[]{0xFF, 0xFF, 0x00}),
        WHITE(new int[]{0xFF, 0xFF, 0xFF});

        private final int[] code;

        ColorNames(int[] code) {
            this.code = code;
        }

        public int[] getCode() {
            return this.code;
        }
    }

    int[] color;

    public Color(int[] colorValues) {
        this.color = colorValues;
    }

    public Color(int red, int green, int blue) {
        this(new int[]{red, green, blue});
    }

    public Color(ColorNames colorName) {
        this(colorName.getCode());
    }

    public static Color newColor(String color) { // warum als statische Methode und nicht normaler konstruktor?
        color = color.toUpperCase();
        return isKnownColorName(color) ? new Color(ColorNames.valueOf(color)) : null;
    }

    private String getName() {
        for (ColorNames color : ColorNames.values()) {
            if (Arrays.equals(color.getCode(), this.color)) {
                return color.name();
            }
        }
        return null;
    }

    public static boolean isKnownColorName(String colorName) {
        for (ColorNames color : ColorNames.values()) {
            if (color.name().equals(colorName)) {
                return true;
            }
        }
        return false;
    }

    public int[] getRGB() {
        return this.color.clone();
    }

    public int getRGB(int channel) {
        return this.color[channel];
    }

    public int getPackedRGB() {
        int rgb = this.color[0] << 16; //  0000 0000 0000 0000 0000 0000
        rgb = rgb | (this.color[1] << 8);
        rgb = rgb | this.color[2];
        return rgb;
    }

    public String toString() {
        String name = this.getName();
        if (name != null) {
            return name;
        }

        int mask = 15;                          // = 0000 0000 0000 0000 0000 1111 --> gibt uns immer die ersten 4 bit, denn ein hex-Zeichen sind 4 Bit.
        char[] hexes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int rgb = getPackedRGB();
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int rgbSnippet = rgb & mask;        //maskieren über & löscht alle bit außer die 4, die gerade dran sind.
            hexString.append(hexes[rgbSnippet]);
            rgb = rgb >> 4;                     //Shiften, sodass die nächsten 4 Bit dran sind.
        }
        hexString.append("#");
        hexString.reverse();
        return hexString.toString();
    }



}
