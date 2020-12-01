package ueb08;

/**
 * Kann für die Ermittlung der Ergebnisse von Wahlen verwendet werden.
 * <p>
 * Jede Methode, deren Name mit "order" beginnt, hat die selbe Signatur:
 * Der einzige Parameter ist ein Array von erhobenen Abstimmungen, 
 * das Ergebnis ist ein 2D-Array, das mehrere Wertpaare enthält, die
 * als ersten Wert die ID des Kandidaten und als zweiten Wert seine erhaltenen 
 * Stimmen beinhalten.
 */
public class Election {

    /**
     * Kombiniert die ID eines Kandidaten mit der Anzahl der erhaltenen Stimmen.
     * Dies ist nützlich, um ein Array in dem Format zu erstellen, das in 
     * allen Methoden, deren Name mit "order" beginnt, benötigt wird.
     *
     * @param counts Die Anzahl der Stimmen, die jeder Kandidat bekommen hat.
     *               Der Index eines Wertes entspricht der ID des zugehörigen
     *               Kandidaten, jeder Wert entspricht also der Anzahl der Stimmen,
     *               die der zugehörige Kandidat erhalten hat.
     * @return Ein Array, das gemäß der Stimmen, die ein Kandidat erhalten hat,
     *         absteigend sortiert ist; jedes Element ist ein Array mit zwei Werten.
     *         Der Wert am ersten Index ist die ID des Kandidaten, der zweite
     *         Wert seine erhaltenen Stimmen. 
     *
     * @todo implementieren
     */
    static public int[][] zipCandidatesAndCounts(int[] counts) {
        int[] candidateIDs = ArrayUtils.buildOrderIndex(counts);
        int[][] zipped = new int[candidateIDs.length][2];
        for(int i = 0; i < zipped.length; i++)
        {
            zipped[i][0] = candidateIDs[i];
            zipped[i][1] = counts[candidateIDs[i]];
        }
        return zipped;
    }

    /**
     * Berechnet die Ergebnisse einer Wahl mit Mehrheitswahlrecht.
     * Dieses System beachtet ausschließlich die Erststimmen und missachtet
     * alle anderen Stimmabgaben.
     * <p>
     * Wenn zwei Kandidaten die selbe Anzahl an Stimmen haben, wird der Kandidat
     * mit der kleineren ID vor den anderen sortiert (und somit die Wahl gewinnen).
     *
     * @param votes Die Abstimmungsergebnisse einer Wahl.
     * @return Siehe die Beschreibung im Kommentar der Klasse.
     *
     * @todo implementieren
     */
    static public int[][] orderFirstPassThePost(int[][] votes) {
        int[] candidateVotes = new int[Data.getNumberOfCandidates()];
        for(int[] element : votes)
        {
            if(element.length > 0 && Data.isValidCandidateId(element[0]))
            {
                candidateVotes[element[0]]++;
            }
        }
        return zipCandidatesAndCounts(candidateVotes);
    }

    /**
     * Berechnet die Ergebnisse einer Wahl durch Rangfolgewahl
     * (Wahl mit sofortiger Stichwahl).
     * Eine Rangfolgewahl besteht aus mehreren Wahlrunden, die in sich ähnlich
     * der Mehrheitswahl sind. Wenn aber nach einer Runde kein Kandidat die
     * Mehrheit (> 50%) an Stimmen erhalten hat, werden alle Stimmen für den
     * Kandidaten, der die wenigsten Stimmen erhalten hat, entfernt und
     * dann erneut das Erreichen einer Mehrheit geprüft.
     *
     * @param votes Die Abstimmungsergebnisse einer Wahl.
     * @return Siehe die Beschreibung im Kommentar der Klasse.
     *
     * @todo implementieren
     */
    static public int[][] orderInstantRunoff(int[][] votes) {
        boolean done = false;
        int[][] erg;
        do{
            erg = orderFirstPassThePost(votes);
            int counter = 0;
            for (int[] vote : votes) {
                if (vote.length > 0) counter++;
            }
            if(erg[0][1] >= counter/2.0)
            {
                done = true;
            }
            else if(erg[0][1] == erg[1][1] && erg[2][1] == 0)
            {
                done = true;
            }

            int eleminatedCandidate = -1;
            for(int i = erg.length-1;eleminatedCandidate == -1 && i > 0; i--)
            {
                if(erg[i][1] > 0)
                {
                    eleminatedCandidate = erg[i][0];
                }
            }

            //System.out.println("HALLO ICH BIN EIN OUTPRINT: " + eleminatedCandidate);
            for(int i = 0; i < votes.length; i++)
            {
                votes[i] = ArrayUtils.filterValue(votes[i], eleminatedCandidate);
            }

        }while(!done);

        return erg;
    }
}
