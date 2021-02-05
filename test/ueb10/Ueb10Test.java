package ueb10;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb10Test {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void example() throws Exception {
        String[] args = {"5", "2", "4", "3", "1", "/", "2", "6", "1"};
        Ueb10.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Argumente            : [5, 2, 4, 3, 1, /, 2, 6, 1]"));
        assertThat(output, containsString("Menge A              : {1 2 3 4 5}"));
        assertThat(output, containsString("Menge B              : {1 2 6}"));
        assertThat(output, containsString("Vereinigung     A ∪ B: {1 2 3 4 5 6}"));
        assertThat(output, containsString("Schnittmenge    A ∩ B: {1 2}"));
        assertThat(output, containsString("Differenzmenge  A \\ B: {3 4 5}"));
        assertThat(output, containsString("echte Teilmenge A ⊂ B: false"));
    }

    @Test
    public void secondSetEmpty() throws Exception {
        String[] args = {"5", "2", "4", "3", "1"};
        Ueb10.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Argumente            : [5, 2, 4, 3, 1]"));
        assertThat(output, containsString("Menge A              : {1 2 3 4 5}"));
        assertThat(output, containsString("Menge B              : {}"));
        assertThat(output, containsString("Vereinigung     A ∪ B: {1 2 3 4 5}"));
        assertThat(output, containsString("Schnittmenge    A ∩ B: {}"));
        assertThat(output, containsString("Differenzmenge  A \\ B: {1 2 3 4 5}"));
        assertThat(output, containsString("echte Teilmenge A ⊂ B: false"));
    }

    @Test
    public void firstSetEmpty() throws Exception {
        String[] args = {"/", "2", "6", "1"};
        Ueb10.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Argumente            : [/, 2, 6, 1]"));
        assertThat(output, containsString("Menge A              : {}"));
        assertThat(output, containsString("Menge B              : {1 2 6}"));
        assertThat(output, containsString("Vereinigung     A ∪ B: {1 2 6}"));
        assertThat(output, containsString("Schnittmenge    A ∩ B: {}"));
        assertThat(output, containsString("Differenzmenge  A \\ B: {}"));
        assertThat(output, containsString("echte Teilmenge A ⊂ B: true"));
    }

    @Test
    public void equalSets() throws Exception {
        String[] args = {"1", "2", "6", "/", "2", "6", "1"};
        Ueb10.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Argumente            : [1, 2, 6, /, 2, 6, 1]"));
        assertThat(output, containsString("Menge A              : {1 2 6}"));
        assertThat(output, containsString("Menge B              : {1 2 6}"));
        assertThat(output, containsString("Vereinigung     A ∪ B: {1 2 6}"));
        assertThat(output, containsString("Schnittmenge    A ∩ B: {1 2 6}"));
        assertThat(output, containsString("Differenzmenge  A \\ B: {}"));
        assertThat(output, containsString("echte Teilmenge A ⊂ B: false"));
    }

    @Test
    public void emptySet() throws Exception {
        String[] args = {};
        Ueb10.main(args);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Argumente            : []"));
        assertThat(output, containsString("Menge A              : {}"));
        assertThat(output, containsString("Menge B              : {}"));
        assertThat(output, containsString("Vereinigung     A ∪ B: {}"));
        assertThat(output, containsString("Schnittmenge    A ∩ B: {}"));
        assertThat(output, containsString("Differenzmenge  A \\ B: {}"));
        assertThat(output, containsString("echte Teilmenge A ⊂ B: false"));
    }
}