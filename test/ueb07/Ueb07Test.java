package ueb07;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import ueb06.Ueb06;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb07Test {
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
        Ueb07.main(args);
    }

    @Test
    public void invalidArg() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
        String[] args = {"a"};
        Ueb07.main(args);
    }

    @Test
    public void arrayWithZeroElements() {
        exit.expectSystemExitWithStatus(1);
        exit.checkAssertionAfterwards(() -> {
            String output = systemOutRule.getLogWithNormalizedLineSeparator();
            assertThat(output, containsString("Es wurde keine gueltige Array-Laenge uebergeben!"));
        });
        String[] args = {"0"};
        Ueb07.main(args);
    }

    @Test
    public void example() {
        systemInMock.provideLines("1349", "Liebe Gaeste!", "klein erna");
        String[] args = {"3"};
        Ueb07.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Ziffern erhöhen: 1349 --> 2450"));
        assertThat(output, containsString("2 Groß-/Kleinschreibung vertauschen: Liebe Gaeste! --> lIEBE gAESTE! (11 Vertauschungen)"));
        assertThat(output, containsString("3 Spiegeln: klein erna --> anre nielk"));
    }

    @Test
    public void increaseNumbersWithExactlyFittingArrayLength() {
        systemInMock.provideLines("1", "0", "9", "1234567890");
        String[] args = {"4"};
        Ueb07.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Ziffern erhöhen: 1 --> 2"));
        assertThat(output, containsString("2 Ziffern erhöhen: 0 --> 1"));
        assertThat(output, containsString("3 Ziffern erhöhen: 9 --> 0"));
        assertThat(output, containsString("4 Ziffern erhöhen: 1234567890 --> 2345678901"));
    }

    @Test
    public void tryToEnterMoreSentences() {
        systemInMock.provideLines("abc", "def");
        String[] args = {"1"};
        Ueb07.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Spiegeln: abc --> cba"));
    }

    @Test
    public void flip() {
        systemInMock.provideLines("abcedf", "a", "z", "X");
        String[] args = {"10"};
        Ueb07.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Spiegeln: abcedf --> fdecba"));
        assertThat(output, containsString("2 Spiegeln: a --> a"));
        assertThat(output, containsString("3 Spiegeln: z --> z"));
    }

    @Test
    public void swap() {
        systemInMock.provideLines("ABCDEF", "AaBbCcDdEeFf", "A,.-Z", "azAZ", "x");
        String[] args = {"10"};
        Ueb07.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Groß-/Kleinschreibung vertauschen: ABCDEF --> abcdef (6 Vertauschungen)"));
        assertThat(output, containsString("2 Groß-/Kleinschreibung vertauschen: AaBbCcDdEeFf --> aAbBcCdDeEfF (12 Vertauschungen)"));
        assertThat(output, containsString("3 Groß-/Kleinschreibung vertauschen: A,.-Z --> a,.-z (2 Vertauschungen)"));
        assertThat(output, containsString("4 Groß-/Kleinschreibung vertauschen: azAZ --> AZaz (4 Vertauschungen)"));
    }

    @Test
    public void emptyString() {
        systemInMock.provideLines("");
        String[] args = {"1"};
        Ueb07.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Spiegeln:  --> "));
    }
}