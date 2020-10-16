package ueb01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb01bTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void exampleNotchesCount() throws Exception {
        systemInMock.provideLines("12321");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("12321 Kerben entsprechen"));
        assertThat(output, containsString("36 Jahren"));
        assertThat(output, containsString("8 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }
}