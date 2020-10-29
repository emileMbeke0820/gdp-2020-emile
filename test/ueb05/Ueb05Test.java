package ueb05;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb05Test {
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
        Ueb05.main(args);
    }

    @Test
    public void invalidArg() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
        String[] args = {"a"};
        Ueb05.main(args);
    }

    @Test
    public void arrayWithZeroElements() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
        String[] args = {"0"};
        Ueb05.main(args);
    }

    @Test
    public void onePriceAndArrayWithOneElement() {
        systemInMock.provideLines("1.00");
        String[] args = {"1"};
        Ueb05.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Anzahl Preise:   1"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 1.00"));
        assertThat(output, containsString("Mittelwert:      1.00"));
        assertThat(output, containsString("Spanne:          0.00"));
    }

    @Test
    public void onePriceAndArrayWithTwoElements() {
        systemInMock.provideLines("1.00", "X");
        String[] args = {"2"};
        Ueb05.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Anzahl Preise:   1"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 1.00"));
        assertThat(output, containsString("Mittelwert:      1.00"));
        assertThat(output, containsString("Spanne:          0.00"));
    }

    @Test
    public void threePricesAndArrayWithTenElements() {
        systemInMock.provideLines("1.0", "1.20", "1.8", "X");
        String[] args = {"10"};
        Ueb05.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Anzahl Preise:   3"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 1.80"));
        assertThat(output, containsString("Mittelwert:      1.33"));
        assertThat(output, containsString("Spanne:          0.80"));
    }

    @Test
    public void zeroPricesAndArrayWithFiveElements() {
        systemInMock.provideLines("X");
        String[] args = {"5"};
        Ueb05.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es wurde kein Preis eingegeben!"));
    }

    @Test
    public void fivePricesAndArrayWithFiveElements() {
        systemInMock.provideLines("1.0", "1.11", "1.5", "1.99", "2");
        String[] args = {"5"};
        Ueb05.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Anzahl Preise:   5"));
        assertThat(output, containsString("Kleinster Preis: 1.00"));
        assertThat(output, containsString("Groesster Preis: 2.00"));
        assertThat(output, containsString("Mittelwert:      1.52"));
        assertThat(output, containsString("Spanne:          1.00"));
    }

    @Test
    public void invalidPricesAndArrayWithFiveElements() {
        systemInMock.provideLines("a", "abcde", "11111", "1.000", "2.0000", "2.1", "3", "x");
        String[] args = {"5"};
        Ueb05.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(7, output.split("Es wurde ein ungueltiger Preis eingegeben!").length - 1);
        assertThat(output, containsString("Es wurde kein Preis eingegeben!"));
    }
}