package ueb04;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class Ueb04Test {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void countSpaces() throws Exception {
        systemInMock.provideLines("A", "Tutorium Grundlagen der Programmierung", "B", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("3 Leerzeichen im Satz gefunden"));
    }

    @Test
    public void swapFirstAndLastWord() throws Exception {
        systemInMock.provideLines("A", "Nachts ist kaelter als draussen", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("draussen ist kaelter als Nachts"));
    }

    @Test
    public void swapFirstAndLastWordWithErroneousSentence() throws Exception {
        systemInMock.provideLines("A", "  ", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void swapFirstAndLastWordWithErroneousSentence2() throws Exception {
        systemInMock.provideLines("A", "Hallo", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void swapFirstAndLastWordWithErroneousSentence3() throws Exception {
        systemInMock.provideLines("A", "Hallo Leute ", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void removeVowels() throws Exception {
        systemInMock.provideLines("A", "Hallo Opa, ich habe Emil angerufen", "D", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("Hll p, ch hb ml ngrfn"));
    }

    @Test
    public void showErrorMessageIfNoSentenceProvided() throws Exception {
        systemInMock.provideLines("B", "C", "D", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(output.split("Es wurde noch kein Satz eingegeben!").length - 1, 3);
    }

    @Test
    public void oneWhitespace() throws Exception {
        systemInMock.provideLines("A", " ", "B", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void twoWhitespaces() throws Exception {
        systemInMock.provideLines("A", "  ", "B", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("2 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void startAndEndWithWhitespace() throws Exception {
        systemInMock.provideLines("A", " a ", "B", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("2 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void oneLetter() throws Exception {
        systemInMock.provideLines("A", "#a#", "B", "C", "D", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("##"));
    }

    @Test
    public void twoLetters() throws Exception {
        systemInMock.provideLines("A", "#aa#", "B", "C", "D", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("##"));
    }

    @Test
    public void twoDifferentLetters() throws Exception {
        systemInMock.provideLines("A", "ab", "B", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
    }

    @Test
    public void twoSingleLetterWords() throws Exception {
        systemInMock.provideLines("A", "a b", "B", "C", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("1 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("b a"));
    }

    @Test
    public void oneWord() throws Exception {
        systemInMock.provideLines("A", "OTTO", "B", "C", "D", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("TT"));
    }

    @Test
    public void sentence() throws Exception {
        systemInMock.provideLines("A", "OTTO ist toll", "B", "C", "D", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("2 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("toll ist OTTO"));
        assertThat(output, containsString("TT st tll"));
    }

    @Test
    public void vowels() throws Exception {
        systemInMock.provideLines("A", "#aeiouAEIOU#", "B", "C", "D", "X");
        Ueb04.main(null);
        String output = systemOutRule.getLogWithNormalizedLineSeparator();
        assertThat(output, containsString("0 Leerzeichen im Satz gefunden"));
        assertThat(output, containsString("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!"));
        assertThat(output, containsString("##"));
    }
}