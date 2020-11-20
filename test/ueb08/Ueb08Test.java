package ueb08;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb08Test {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void handleWrongIdAndExit() {
        systemInMock.provideLines("1337", "-1");
        Ueb08.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(2, output.split("Die Daten von 7 Wahlen sind vorhanden.").length - 1);
        assertEquals(2, output.split("Geben Sie die Nummer einer Wahl \\(0 - 6\\) ein").length - 1);
    }

    @Test
    public void showIdZeroAndExit() {
        systemInMock.provideLines("0", "-1");
        Ueb08.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 0) E. Herms      : 0\n" +
                " 1) A. Gebäudchen : 0\n" +
                " 2) G. Kayak      : 0\n" +
                " 3) E. Cola       : 0\n" +
                " 4) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 0) E. Herms      : 0\n" +
                " 1) A. Gebäudchen : 0\n" +
                " 2) G. Kayak      : 0\n" +
                " 3) E. Cola       : 0\n" +
                " 4) M. Riema      : 0"));
    }

    @Test
    public void showIdOneAndExit() {
        systemInMock.provideLines("1", "-1");
        Ueb08.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 0) E. Herms      : 3\n" +
                " 1) A. Gebäudchen : 0\n" +
                " 2) G. Kayak      : 0\n" +
                " 3) E. Cola       : 0\n" +
                " 4) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 0) E. Herms      : 3\n" +
                " 1) A. Gebäudchen : 0\n" +
                " 2) G. Kayak      : 0\n" +
                " 3) E. Cola       : 0\n" +
                " 4) M. Riema      : 0"));
    }

    @Test
    public void showIdTwoAndThreeAndExit() {
        systemInMock.provideLines("2", "3", "-1");
        Ueb08.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 0) E. Cola       : 3\n" +
                " 1) E. Herms      : 0\n" +
                " 2) A. Gebäudchen : 0\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 0) E. Cola       : 3\n" +
                " 1) E. Herms      : 0\n" +
                " 2) A. Gebäudchen : 0\n" +
                " 3) G. Kayak      : 0\n" +
                " 4) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 0) E. Herms      : 4\n" +
                " 1) A. Gebäudchen : 1\n" +
                " 2) G. Kayak      : 0\n" +
                " 3) E. Cola       : 0\n" +
                " 4) M. Riema      : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 0) E. Herms      : 4\n" +
                " 1) A. Gebäudchen : 1\n" +
                " 2) G. Kayak      : 0\n" +
                " 3) E. Cola       : 0\n" +
                " 4) M. Riema      : 0"));
    }

    @Test
    public void showIdFourAndExit() {
        systemInMock.provideLines("4", "-1");
        Ueb08.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 0) E. Cola       : 5\n" +
                " 1) M. Riema      : 5\n" +
                " 2) G. Kayak      : 2\n" +
                " 3) E. Herms      : 0\n" +
                " 4) A. Gebäudchen : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 0) M. Riema      : 7\n" +
                " 1) E. Cola       : 5\n" +
                " 2) E. Herms      : 0\n" +
                " 3) A. Gebäudchen : 0\n" +
                " 4) G. Kayak      : 0"));
    }

    @Test
    public void showIdFiveAndExit() {
        systemInMock.provideLines("5", "-1");
        Ueb08.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 0) M. Riema      : 4\n" +
                " 1) E. Cola       : 3\n" +
                " 2) G. Kayak      : 2\n" +
                " 3) E. Herms      : 1\n" +
                " 4) A. Gebäudchen : 0"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 0) M. Riema      : 4\n" +
                " 1) E. Cola       : 3\n" +
                " 2) E. Herms      : 0\n" +
                " 3) A. Gebäudchen : 0\n" +
                " 4) G. Kayak      : 0"));
    }

    @Test
    public void showIdSixAndExit() {
        systemInMock.provideLines("6", "-1");
        Ueb08.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Ergebnis nach Mehrheitswahlrecht:\n" +
                " 0) E. Herms      : 7\n" +
                " 1) A. Gebäudchen : 6\n" +
                " 2) G. Kayak      : 6\n" +
                " 3) M. Riema      : 6\n" +
                " 4) E. Cola       : 3"));
        assertThat(output, containsString("Ergebnis nach Rangfolgewahl:\n" +
                " 0) G. Kayak      : 12\n" +
                " 1) A. Gebäudchen : 9\n" +
                " 2) E. Herms      : 0\n" +
                " 3) E. Cola       : 0\n" +
                " 4) M. Riema      : 0"));
    }
}