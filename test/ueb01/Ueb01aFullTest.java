package ueb01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb01aFullTest {
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

    @Test
    public void exactlyOneDish() throws Exception {
        systemInMock.provideLines("1", "4", "10");
        Ueb01a.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es können 1 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 0 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void exactlyTenDishes() throws Exception {
        systemInMock.provideLines("10", "40", "100");
        Ueb01a.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es können 10 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 0 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void oneMeatLeft() {
        systemInMock.provideLines("5", "16", "40");
        Ueb01a.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 1 Stück(e) Fleisch, 0 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void onePotatoeLeft() {
        systemInMock.provideLines("4", "17", "40");
        Ueb01a.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 1 Kartoffel(n) und 0 Bohne(n)"));
    }

    @Test
    public void oneBeanLeft() {
        systemInMock.provideLines("4", "16", "41");
        Ueb01a.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Es können 4 Gerichte hergestellt werden."));
        assertThat(output, containsString("Es bleiben über: 0 Stück(e) Fleisch, 0 Kartoffel(n) und 1 Bohne(n)"));
    }
}