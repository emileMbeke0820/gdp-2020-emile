package ueb08;

import java.util.Scanner;

/**
 * Kommunikation mit dem Benutzer zur Untersuchung unterschiedlicher Wahlen.
 * @author Emile Mbeke
 */

public class Ueb08 {
    /**
     * Der Benutzer wird wiederholt nach Eingabe einer ID für die zu
     * untersuchende Wahl gefragt und die Ergebnisse dieser Wahl werden auf
     * stdout ausgegeben.
     *
     * @param args Nicht genutzt.
     */
    public static void main(String[] args) {
        int electionID;
        do{
            electionID = chooseElection();
            if(Data.isValidElectionId(electionID))
            {
                System.out.println("Ergebnis nach Mehrheitswahlrecht:");
                printElectionResults(Election.orderFirstPassThePost(Data.getVotes(electionID)));
                System.out.println("Ergebnis nach Rangfolgewahl:");
                printElectionResults(Election.orderInstantRunoff(Data.getVotes(electionID)));
            }
        }while(electionID != -1);

    }

    public static void printElectionResults(int[][] result)
    {
        for(int i = 0; i < result.length; i++)
        {
            String candidateName = Data.getCandidateNameById(result[i][0]);
            int voteCount = result[i][1];
            System.out.format("%2d) %-14s: %d%n", i, candidateName, voteCount);
        }
    }

    public static int chooseElection()
    {

        System.out.println("Die Daten von " + Data.getNumberOfElections() + " Wahlen sind vorhanden.");
        System.out.println("Geben Sie die Nummer einer Wahl (0 - " + (Data.getNumberOfElections()-1) +") ein oder -1 zum Beenden.");
        String input = new Scanner(System.in).nextLine();
        if(input.matches("-?\\d+"))
        {
            return Integer.parseInt(input);
        }
        else return -2;
    }

    public static boolean isNumber(String a)
    {
        byte[] arr = a.getBytes();
        int counter = 0;
        int length = arr.length;
        for(byte b : arr)
        {
            if(b >= 48 && b <= 57) counter++;
        }
        if(counter == length && counter != 0) return true;
        else return false;
    }

}
