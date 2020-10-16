package ueb01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb01bFullTest {
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

    @Test
    public void onlyOneDay() throws Exception {
        systemInMock.provideLines("1");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }

    @Test
    public void onlyOneWeek() throws Exception {
        systemInMock.provideLines("7");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("7 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void onlyOneMonth() throws Exception {
        systemInMock.provideLines("28");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("28 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void onlyOneYear() throws Exception {
        systemInMock.provideLines("336");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("336 Kerben entsprechen"));
        assertThat(output, containsString("1 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void oneDayWeekMonthYear() throws Exception {
        systemInMock.provideLines("372");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("372 Kerben entsprechen"));
        assertThat(output, containsString("1 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }

    @Test
    public void twoDaysWeeksMonthsYears() throws Exception {
        systemInMock.provideLines("744");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("744 Kerben entsprechen"));
        assertThat(output, containsString("2 Jahren"));
        assertThat(output, containsString("2 Monaten"));
        assertThat(output, containsString("2 Wochen und"));
        assertThat(output, containsString("2 Tagen"));
    }

    @Test
    public void oneDayAndWeek() throws Exception {
        systemInMock.provideLines("8");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("8 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("0 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("1 Tagen"));
    }

    @Test
    public void oneWeekAndMonth() throws Exception {
        systemInMock.provideLines("35");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("35 Kerben entsprechen"));
        assertThat(output, containsString("0 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("1 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }

    @Test
    public void oneMonthAndYear() throws Exception {
        systemInMock.provideLines("364");
        Ueb01b.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("364 Kerben entsprechen"));
        assertThat(output, containsString("1 Jahren"));
        assertThat(output, containsString("1 Monaten"));
        assertThat(output, containsString("0 Wochen und"));
        assertThat(output, containsString("0 Tagen"));
    }
}