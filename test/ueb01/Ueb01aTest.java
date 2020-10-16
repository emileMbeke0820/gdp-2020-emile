package ueb01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb01aTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void exampleIngredients() throws Exception {
        systemInMock.provideLines("5", "18", "57");
        Ueb01a.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 1 Stück(e) Fleisch, 2 Kartoffel(n) und 17 Bohne(n)"));
    }
}