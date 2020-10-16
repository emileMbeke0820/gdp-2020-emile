package ueb02;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

@RunWith(Parameterized.class)
public class Ueb02bFullTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "j", "46", "U1"},
                { "n", "U1", "46"},
                { "J", "46", "U1"},
                { "N", "U1", "46"},
                { "j", "25", "U2"},
                { "n", "U2", "25"},
                { "J", "25", "U2"},
                { "N", "U2", "25"},
                { "j", "26", "U3"},
                { "n", "U3", "26"},
                { "J", "26", "U3"},
                { "N", "U3", "26"},
                { "j", "11", "U4"},
                { "n", "U4", "11"},
                { "J", "11", "U4"},
                { "N", "U4", "11"},
                { "j", "10", "Keine Linie gefunden."},
                { "n", "U5", "Keine Linie gefunden."},
                { "J", "10", "Keine Linie gefunden."},
                { "N", "U5", "Keine Linie gefunden."},
        });
    }

    private final String inverse;
    private final String input;
    private final String result;

    public Ueb02bFullTest(String inverse, String input, String result) {
        this.inverse = inverse;
        this.input = input;
        this.result = result;
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void shouldCalculateCorrectResult() throws Exception {
        systemInMock.provideLines(inverse, input);
        Ueb02b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString(result));
    }
}