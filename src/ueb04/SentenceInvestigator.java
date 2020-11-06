package ueb04;

public class SentenceInvestigator {

    public static int countWhiteSpaces(String testSentence1) {
        int counter = 0;
        for (int i = 0; i < testSentence1.length(); i++) {
            if (testSentence1.charAt(i) == ' ') {
                counter++;
            }
        }
        return counter;
    }

    public static String switchFirstAndLastWord(String testSentence ) {

        testSentence = testSentence.trim();
        String first = testSentence.substring(0, testSentence.indexOf(" "));
        String last = testSentence.substring(testSentence.lastIndexOf(" "));
        String temp;
        temp = first;
        first = last;
        last = temp;
        String result = first + testSentence.substring(testSentence.indexOf(" "), testSentence.lastIndexOf(" ") + 1) + last;
        System.out.println(result.trim());
        return first;
    }
    public static String removeVowels(String s){
        s = s.toLowerCase();
        System.out.println(s.replace('a', '\000').replace('e', '\000').replace('i', '\000').replace('o', '\000').replace('u', '\000'));
        return s;
    }
    public void shouldReturnMessageForSentencesWithLessThanOneWord(String testSentence5){
        if(testSentence5.length() < 2){
            System.out.println("Der Satz muss mindestens 2 Wörter aufweisen und an erster und letzter Stelle darf kein Leerzeichen vorkommen!");
        }

    }
}
