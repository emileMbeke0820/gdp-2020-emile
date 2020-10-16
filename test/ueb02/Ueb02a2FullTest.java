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
public class Ueb02a2FullTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "j", "j", "Viel Spaß in Hagenbecks Tierpark!"},
                { "j", "J", "Viel Spaß in Hagenbecks Tierpark!"},
                { "J", "j", "Viel Spaß in Hagenbecks Tierpark!"},
                { "J", "J", "Viel Spaß in Hagenbecks Tierpark!"},
                { "j", "n", "Viel Spaß im Wildpark Schwarze Berge!"},
                { "j", "N", "Viel Spaß im Wildpark Schwarze Berge!"},
                { "J", "n", "Viel Spaß im Wildpark Schwarze Berge!"},
                { "J", "N", "Viel Spaß im Wildpark Schwarze Berge!"},
                { "n", "j", "Viel Spaß auf dem Dom!"},
                { "n", "J", "Viel Spaß auf dem Dom!"},
                { "N", "j", "Viel Spaß auf dem Dom!"},
                { "N", "J", "Viel Spaß auf dem Dom!"},
                { "n", "n", "Viel Spaß auf der Kieler Woche!"},
                { "n", "N", "Viel Spaß auf der Kieler Woche!"},
                { "N", "n", "Viel Spaß auf der Kieler Woche!"},
                { "N", "N", "Viel Spaß auf der Kieler Woche!"},
        });
    }

    private final String animals;
    private final String hamburg;
    private final String result;

    public Ueb02a2FullTest(String animals, String hamburg, String result) {
        this.animals = animals;
        this.hamburg = hamburg;
        this.result = result;
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void shouldCalculateCorrectResult() throws Exception {
        systemInMock.provideLines(animals, hamburg);
        Ueb02a2.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString(result));
    }
}