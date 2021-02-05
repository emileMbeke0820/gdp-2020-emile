package ueb11;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class Ueb11Test {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();



    @Test
    public void example() {
        Ueb11.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("" +
                "Füge folgende Figuren zu: \n" +
                " 1. unknown    Dreieck  mit Kantenlängen (  7,00,   8,00,   4,00), Umfang:  19,00, Fläche:  14,00\n" +
                " 2. WHITE      Dreieck  mit Kantenlängen (  3,50,   4,00,   2,00), Umfang:   9,50, Fläche:   3,50\n" +
                " 3. GREEN      Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07\n" +
                " 4. GREEN      Kreis    mit Durchmesser  (  1,50),                 Umfang:   4,71, Fläche:   1,77\n" +
                " 5. RED        Rechteck mit Kantenlängen (  7,00,   8,00),         Umfang:  30,00, Fläche:  56,00\n" +
                " 6. RED        Rechteck mit Kantenlängen (  3,50,   4,00),         Umfang:  15,00, Fläche:  14,00\n" +
                " 7. YELLOW     Quadrat  mit Kantenlänge  (  2,50),                 Umfang:  10,00, Fläche:   6,25\n" +
                " 8. #0A80FF    Quadrat  mit Kantenlänge  (  1,25),                 Umfang:   5,00, Fläche:   1,56\n" +
                " 9. RED        Rechteck mit Kantenlängen ( 14,00,  16,00),         Umfang:  60,00, Fläche: 224,00\n" +
                "10. GREEN      Kreis    mit Durchmesser  (  6,00),                 Umfang:  18,85, Fläche:  28,27\n" +
                "11. YELLOW     Quadrat  mit Kantenlänge  (  5,00),                 Umfang:  20,00, Fläche:  25,00\n" +
                "12. unknown    Dreieck  mit Kantenlängen ( 14,00,  16,00,   8,00), Umfang:  38,00, Fläche:  55,99\n" +
                "13. WHITE      Dreieck  mit Kantenlängen ( 15,00,  17,00,   8,00), Umfang:  40,00, Fläche:  60,00\n" +
                "14. RED        Dreieck  mit Kantenlängen ( 16,00,  18,00,   8,00), Umfang:  42,00, Fläche:  63,99\n" +
                "15. RED        Dreieck  mit Kantenlängen ( 17,00,  19,00,   8,00), Umfang:  44,00, Fläche:  67,97\n" +
                "16. unknown    Dreieck  mit Kantenlängen ( 18,00,  20,00,   8,00), Umfang:  46,00, Fläche:  71,94\n" +
                "17. unknown    Dreieck  mit Kantenlängen ( 19,00,  21,00,   8,00), Umfang:  48,00, Fläche:  75,89\n" +
                "18. GREEN      Kreis    mit Durchmesser  ( 23,50),                 Umfang:  73,83, Fläche: 433,74\n" +
                "19. #010203    Rechteck mit Kantenlängen (  3,50,  46,00),         Umfang:  99,00, Fläche: 161,00\n" +
                "20. RED        Rechteck mit Kantenlängen (104,00,   8,00),         Umfang: 224,00, Fläche: 832,00\n" +
                "21. BLACK      Dreieck  mit Kantenlängen (  0,10,   0,20,   0,30), Umfang:   0,60, Fläche:   0,00\n" +
                "22. AQUA       Kreis    mit Durchmesser  (  0,40),                 Umfang:   1,26, Fläche:   0,13\n" +
                "23. BLUE       Kreis    mit Durchmesser  (  0,50),                 Umfang:   1,57, Fläche:   0,20\n" +
                "24. FUCHSIA    Rechteck mit Kantenlängen (  0,60,   0,70),         Umfang:   2,60, Fläche:   0,42\n" +
                "25. LIME       Rechteck mit Kantenlängen (  0,80,   0,90),         Umfang:   3,40, Fläche:   0,72\n" +
                "26. NAVY       Quadrat  mit Kantenlänge  (  1,00),                 Umfang:   4,00, Fläche:   1,00\n" +
                "27. BLUE       Kreis    mit Durchmesser  (  1,10),                 Umfang:   3,46, Fläche:   0,95\n" +
                "28. FUCHSIA    Rechteck mit Kantenlängen (  1,20,   1,30),         Umfang:   5,00, Fläche:   1,56\n" +
                "29. LIME       Rechteck mit Kantenlängen (  1,40,   1,50),         Umfang:   5,80, Fläche:   2,10\n" +
                "30. NAVY       Quadrat  mit Kantenlänge  (  1,60),                 Umfang:   6,40, Fläche:   2,56\n" +
                "Liste neu erzeugt mit 30 Elementen.\n" +
                "------------------------------\n" +
                " 1. RED        Rechteck mit Kantenlängen (104,00,   8,00),         Umfang: 224,00, Fläche: 832,00\n" +
                " 2. GREEN      Kreis    mit Durchmesser  ( 23,50),                 Umfang:  73,83, Fläche: 433,74\n" +
                " 3. RED        Rechteck mit Kantenlängen ( 14,00,  16,00),         Umfang:  60,00, Fläche: 224,00\n" +
                " 4. #010203    Rechteck mit Kantenlängen (  3,50,  46,00),         Umfang:  99,00, Fläche: 161,00\n" +
                " 5. unknown    Dreieck  mit Kantenlängen ( 19,00,  21,00,   8,00), Umfang:  48,00, Fläche:  75,89\n" +
                " 6. unknown    Dreieck  mit Kantenlängen ( 18,00,  20,00,   8,00), Umfang:  46,00, Fläche:  71,94\n" +
                " 7. RED        Dreieck  mit Kantenlängen ( 17,00,  19,00,   8,00), Umfang:  44,00, Fläche:  67,97\n" +
                " 8. RED        Dreieck  mit Kantenlängen ( 16,00,  18,00,   8,00), Umfang:  42,00, Fläche:  63,99\n" +
                " 9. WHITE      Dreieck  mit Kantenlängen ( 15,00,  17,00,   8,00), Umfang:  40,00, Fläche:  60,00\n" +
                "10. RED        Rechteck mit Kantenlängen (  7,00,   8,00),         Umfang:  30,00, Fläche:  56,00\n" +
                "11. unknown    Dreieck  mit Kantenlängen ( 14,00,  16,00,   8,00), Umfang:  38,00, Fläche:  55,99\n" +
                "12. GREEN      Kreis    mit Durchmesser  (  6,00),                 Umfang:  18,85, Fläche:  28,27\n" +
                "13. YELLOW     Quadrat  mit Kantenlänge  (  5,00),                 Umfang:  20,00, Fläche:  25,00\n" +
                "14. unknown    Dreieck  mit Kantenlängen (  7,00,   8,00,   4,00), Umfang:  19,00, Fläche:  14,00\n" +
                "15. RED        Rechteck mit Kantenlängen (  3,50,   4,00),         Umfang:  15,00, Fläche:  14,00\n" +
                "16. GREEN      Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07\n" +
                "17. YELLOW     Quadrat  mit Kantenlänge  (  2,50),                 Umfang:  10,00, Fläche:   6,25\n" +
                "18. WHITE      Dreieck  mit Kantenlängen (  3,50,   4,00,   2,00), Umfang:   9,50, Fläche:   3,50\n" +
                "19. NAVY       Quadrat  mit Kantenlänge  (  1,60),                 Umfang:   6,40, Fläche:   2,56\n" +
                "20. LIME       Rechteck mit Kantenlängen (  1,40,   1,50),         Umfang:   5,80, Fläche:   2,10\n" +
                "21. GREEN      Kreis    mit Durchmesser  (  1,50),                 Umfang:   4,71, Fläche:   1,77\n" +
                "22. #0A80FF    Quadrat  mit Kantenlänge  (  1,25),                 Umfang:   5,00, Fläche:   1,56\n" +
                "23. FUCHSIA    Rechteck mit Kantenlängen (  1,20,   1,30),         Umfang:   5,00, Fläche:   1,56\n" +
                "24. NAVY       Quadrat  mit Kantenlänge  (  1,00),                 Umfang:   4,00, Fläche:   1,00\n" +
                "25. BLUE       Kreis    mit Durchmesser  (  1,10),                 Umfang:   3,46, Fläche:   0,95\n" +
                "26. LIME       Rechteck mit Kantenlängen (  0,80,   0,90),         Umfang:   3,40, Fläche:   0,72\n" +
                "27. FUCHSIA    Rechteck mit Kantenlängen (  0,60,   0,70),         Umfang:   2,60, Fläche:   0,42\n" +
                "28. BLUE       Kreis    mit Durchmesser  (  0,50),                 Umfang:   1,57, Fläche:   0,20\n" +
                "29. AQUA       Kreis    mit Durchmesser  (  0,40),                 Umfang:   1,26, Fläche:   0,13\n" +
                "30. BLACK      Dreieck  mit Kantenlängen (  0,10,   0,20,   0,30), Umfang:   0,60, Fläche:   0,00\n" +
                "------------------------------"));
    }
}