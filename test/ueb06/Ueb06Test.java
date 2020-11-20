package ueb06;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb06Test {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void emptyArgs() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
        String[] args = {};
        Ueb06.main(args);
    }

    @Test
    public void invalidArg() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
        String[] args = {"a"};
        Ueb06.main(args);
    }

    @Test
    public void arrayWithZeroElements() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
        String[] args = {"0"};
        Ueb06.main(args);
    }

    @Test
    public void checkBrandInputWithExit() {
        systemInMock.provideLines("", "x");
        String[] args = {"1"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es wurde eine ungueltige Marke eingegeben!"));
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void checkPlzWithExit() {
        systemInMock.provideLines("Shell", "", "1", "9999", "100000", "ABCDE", "X");
        String[] args = {"1"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(5, output.split("Es wurde eine ungueltige PLZ eingegeben!").length - 1);
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void checkCityWithExit() {
        systemInMock.provideLines("Shell", "10000", "", "a", "abc", "X");
        String[] args = {"10"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(3, output.split("Es wurde ein ungueltiger Ort eingegeben!").length - 1);
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void checkPriceWithExit() {
        systemInMock.provideLines("Shell", "10000", "Wedel", "0000", "0.0", "0.99", "2.01", "1.000", "2.000", "X");
        String[] args = {"5"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(6, output.split("Es wurde ein ungueltiger Preis eingegeben!").length - 1);
        assertThat(output, containsString("Die Eingabe wurde abgebrochen!"));
    }

    @Test
    public void oneGasStationAndArrayWithOneElement() {
        systemInMock.provideLines(
                "Shell", "22880", "Wedel", "1.40",
                "10000",
                "99999"
        );
        String[] args = {"1"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
    }

    @Test
    public void twoGasStationsAndArrayWithTwoElements() {
        systemInMock.provideLines(
                "Shell", "22880", "Wedel", "1.40",
                "Esso", "22105", "Hamburg", "1.85",
                "10000",
                "99999"
        );
        String[] args = {"2"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output.toString(), containsString("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
        assertThat(output.toString(), containsString("2. eingegebene Adresse:\nEsso\n22105 Hamburg\n1.85 Euro"));
    }

    @Test
    public void twoGasStationsAndArrayWithThreeElements() {
        systemInMock.provideLines(
                "Shell", "22880", "Wedel", "1.40",
                "Esso", "22105", "Hamburg", "1.85",
                "x",
                "22104",
                "22105"
        );
        String[] args = {"3"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("2. eingegebene Adresse:\nEsso\n22105 Hamburg\n1.85 Euro"));
    }

    @Test
    public void checkInvalidRange() {
        systemInMock.provideLines(
                "Shell", "22880", "Wedel", "1.40",
                "Esso", "22105", "Hamburg", "1.85",
                "x",
                "9999",
                "100000",
                "22880",
                "9999",
                "100000",
                "22880",
                "22881"
        );
        String[] args = {"3"};
        Ueb06.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(5, output.split("Es wurde eine ungueltige PLZ eingegeben!").length - 1);
        assertThat(output, containsString("1. eingegebene Adresse:\nShell\n22880 Wedel\n1.40 Euro"));
    }
}