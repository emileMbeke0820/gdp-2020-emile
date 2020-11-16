# Aufgabe 7

## Thema: Strings zeichenweise und Funktionen

Bei mehreren in ein Array einzulesenden Strings sollen zeichenweise einfache Veränderungen vorgenommen werden. 

## Anforderungen

* In ein Array vom Typ `String` sollen Strings vom Benutzer eingelesen werden können. Wie viele Datensätze dabei maximal in das Array passen, soll über einen Kommandozeilenparameter geregelt werden.
* Wird ein Wert kleiner 1, kein oder ein nicht numerischer Wert als Kommandozeilenparameter übergeben, soll die Fehlermeldung `Es wurde keine gueltige Array-Laenge uebergeben!` angezeigt werden. Anschließend soll sich das Programm mit dem Exit-Code 1 beenden.
* Möchte der Benutzer weniger Strings als die vom Kommandozeilenparameter vorgesehene Maximalzahl eingeben, kann er die Eingabe jederzeit mit 'x' beenden (es ist folglich nicht möglich, den String 'x' für die Bearbeitung einzugeben)
* Auf jeden eingegebenen String wird nach Ende der Eingabe eine der folgenden Veränderungen angewandt:
  * Wenn der String ausschließlich Ziffernzeichen ('0' bis '9') enthält, werden alle Ziffern darin um 1 erhöht und aus der '9' wird eine '0'.
  * Enthält der String ansonsten mindestens einen Großbuchstaben, wird bei allen Buchstaben die Groß- / Kleinschreibung vertauscht und die Anzahl der Vertauschungen wird mit berechnet. Alle Umlaute, Sonderzeichen, Satzzeichen, Steuerzeichen etc. werden hiervon nicht verändert.
  * Ansonsten wird der String mit allen enthaltenen Zeichen gespiegelt
* Abschließend werden alle Strings zeilenweise nummeriert ausgegeben, wobei jeweils am Anfang die angewandte Methode steht (also z.B. "Ziffern erhöhen", "Groß-/Kleinschreibung vertauschen" und "Spiegeln"), danach der eingegebene Ursprungszustand des Strings und am Ende das berechnete neue Ergebnis. Zum Beispiel könnte das für die eingegebenen Strings '1349', 'Liebe Gäste!' und 'klein erna' so aussehen:

        1 Ziffern erhöhen: 1349 -> 2450
        2 Groß-/Kleinschreibung vertauschen: Liebe Gaeste! -> lIEBE gAESTE! (11 Vertauschungen)
        3 Spiegeln: klein erna -> anre nielk

* In dieser Aufgabe dürfen folgende vordefinierte Funktionen von Java NICHT verwendet werden (es soll - wie das Thema der Aufgabe schon sagt - zeichenweise auf den Strings gearbeitet werden):
    * Alle Stringfunktionen mit Ausnahme von `length()` und `charAt()`
    * `Integer.parseInt()`, `Double.parseDouble()` und ähnliche Funktionen, die Strings in Zahlen umwandeln
    * Alle Funktionen aus `Math`
    * `try` und `catch`
* Euer Programm soll folgende Funktionen aufweisen (zusätzlich zum Hauptprogramm). Die genauen sinnvollen Parameter und Rückgabetypen überlegt Euch bitte selbst! Das Hauptprogramm selbst wird dadurch relativ kurz (in der Beispiel-Lösung hat es ohne Kommentare gerade mal noch 15 Zeilen...).

    ```java
    
    // Gibt eine Fehlermeldung aus und beendet das Programm mit dem Exit-Code 1
    ... printErrorAndExit(... errorMessage) {}
  
    // Liest die Array-Länge aus dem Kommandozeilenparameter-Array aus und gibt
    // diese zurück. Wurde keine oder eine ungültige Array-Länge übergeben, soll
    // die Funktion -1 zurückgeben
    ... getArrayLengthFromArgs(... args) {}
  
    // Liest mehrere Strings vom Benutzer ein. Speichert die Strings in lines ab
    // und gibt die Anzahl der eingelesenen Strings zurück
    int getStrings(String[] lines) {}
  
    // Berechnet den Wert der Potenz. Zur Vereinfachung kann davon ausgegangen werden,
    // dass der Exponent immer größer oder gleich Null ist
    ... power(... base, ... exponent) {}
  
    // Wandelt einen String in eine Ganzzahl um. Zur Vereinfachung kann davon
    // ausgegangen werden, dass s immer eine Ganzzahl größer oder gleich Null enthält
    ... toNumber(... s) {

    // Gibt zurueck, ob das Zeichen c ein Ziffernzeichen ist
    ... isDigit(... c) {}

    // Gibt zurueck, ob s ausschliesslich aus Ziffernzeichen besteht
    ... isNumber(... s) {}

    // Wandelt s in eine Ganzzahl um
    ... toNumber(... s) {}

    // Erhoeht in s jede Ziffer um 1 und macht aus einer 9 eine 0.
    ... shiftDigits(... s) {}

    // Gibt zurueck, ob in s mindestens ein Grossbuchstabe enthalten ist
    ... hasCapital(... s) {}

    // Macht in s bei allen Buchstaben aus Klein- Grossbuchstaben und
    // umgekehrt und gibt das Ergebnis inklusive Anzahl der Vertauschungen zurück
    ... changeCapitalization(... s) {}

    // Spiegelt den String s und gibt das Ergebnis zurück
    ... mirrorString(... s) {}

    // Gibt die laufende Nummer des Strings, die angewandte Methode, den
    // Ursprungszustand und den neu berechneten String formatiert (z.B. mit einem -> dazwischen) aus
    ... print(... nr, ... method, ... old, ... res) {}
    ```
* Schreibt im pair jeweils einen JUNIT-Test in eine eigene Testklasse. Dieser Test soll eine der oben aufgeführten Methoden (VOR der Implementierung) sinnvoll abtesten. Danach soll euer Partner\*in den code implementieren. Dabei ist Diskussion und ggbf. Unterstützung erwünscht.
* Ausgaben dürfen ausschließlich über die Funktionen `print` und `printErrorAndExit` erfolgen. Ein `System.out.println` / `system.out.print` in der `main` ist nicht erlaubt!
* Globale Variablen sind nicht zugelassen, es soll stattdessen umfangreich mit Parametern gearbeitet werden!

## Abnahmetest

Hier findet Ihr den Basis-Abnahmetest für diese Übung:

* [Ueb07Test.java](Ueb07Test.java)

Bitte beachtet, dass die Abnahme im Tutorium mit umfangreicheren Tests erfolgt.

## Hilfe

Die Parameterübergabe erfolgt in Java immer nach dem Prinzip "call by value". Das bedeutet, dass die übergebenen Werte immer kopiert werden. Eine Variable, die vor einem Funktionsaufruf deklariert wird und dann einer Funktion übergeben wird, enthält daher nach dem Funktionsaufruf immer denselben Wert wie zuvor, auch wenn innerhalb der Funktion Veränderungen darauf vorgenommen werden. ACHTUNG: Es gibt jedoch einen Sonderfall, in dem das nicht so ist. Modifiziert man innerhalb einer Funktion einen Parameter, der auf ein Objekt (dazu gehören auch Arrays) zeigt, ändert sich auch der Wert außerhalb der Funktion. Hierzu ein Beispiel: 

```java
private static void modify(String[] strings) {
	strings[0] = "foo";
	strings[1] = "bar";
}

public static void main(final String[] args) {
	String[] strings = new String[2];
	
	strings[0] = "Hallo";
	strings[1] = "Welt";
	
	System.out.println(strings[0]); // Hallo
	System.out.println(strings[1]); // Welt
	
	modify(strings);
	
	System.out.println(strings[0]); // foo
	System.out.println(strings[1]); // bar
}
```

Funktionen inkl. ihrer Parameter und ggf. des Rückgabewertes sind umfangreich zu kommentieren! Dies erleichtert die Lesbarkeit und Wiederverwendung ganz immens. 

Arbeiten mit dem Datentyp `char`:
 * In einem `char` kann man im Gegensatz zu einem String nur ein einzelnes Zeichen ablegen
 * Zu jedem `char` Zeichen existiert eine dezimale Repräsentation (siehe [ASCII-Tabelle](https://de.wikipedia.org/wiki/American_Standard_Code_for_Information_Interchange#ASCII-Tabelle))
 * Aus diesem Grund kann man in Java auch mit `char` Variablen rechnen:
    ```java
    char c = 'A';
    c++;
    system.out.print(c); // Ausgabe: B
    ```
    oder:
    ```java
    char c = 'j' - 'J';
    system.out.print(c); // Ausgabe: (
    ```
    oder in Schleifen verwenden:
    ```java
    for (char c = 'a'; c <= 'b'; c++) {
       System.out.println(c);
    }
    ```
 * Die dezimale Repräsentation eines `char` erhält man, wenn man die Variable in einen `int` castet. Hierfür schreibt
 man einfach `(int)` vor den `char`: `(int) 'A'` ergibt beispielsweise `65`, also die Position des großen A in der
 ASCII-Tabelle. In die andere Ruichtung, also von `int` zu `char` funktioniert übrigens genauso: `(char) 65` ergibt `A`

#### Tests
Für einfache isolierte Tests könnt ihr euch an dem "Given-When-Then"-Prinzip orientieren.
Tests könnt ihr auch benutzen um euer pairing zu verbessern. Eine\*r schreibt den Test, und gibt die Tastatur ab, 
und der/die Pairingpartner\*in implementiert den code, um den Test erfolgreich laufen zu lassen.

```java
package ueb04;  //Das package sollte das selbe sein, wie die zu testende klasse. Ansonsten müsst ihr importieren

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class SentenceInvestigatorTest {

    @Test
    public void shouldCountSpaces() {
        // Given
        String testSentence1 = "I Like Turtles!";
        int expectedWhiteSpaceCount = 2;

        // When
        int result = SentenceInvestigator.countWhiteSpaces(testSentence1);

        // Then
        assertEquals(expectedWhiteSpaceCount, result);
    }
}
```
##
Um Kommandozeilenparameter in IntelliJ zu setzen: 
- klickt auf das Play-Zeichen links neben der Main.
- wählt die untere Option "Edit/Create UebXX.main".
- im Pup-Up unter "Programm Arguments" die Parameter kommasepariert angeben.


Testet vor der Abgabe selbst mit verschiedenen Strings für alle Methoden, ob die Berechnung wie gewünscht funktioniert und dass Ihr keine globalen Variablen mehr im Code habt!
