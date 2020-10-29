# Aufgabe 5

## Thema: Arrays

Für eine Menge einzugebender Benzinpreise sollen einfache Statistiken zur Verfügung gestellt werden.

## Anforderungen

* Vom Programm werden nacheinander mehrere Benzinpreise eingelesen und in einem Array abgelegt. Wie viele Preise dabei maximal in das Array passen, soll über einen Kommandozeilenparameter geregelt werden.

* Wird kein oder ein nicht numerischer Wert als Kommandozeilenparameter übergeben, soll die Fehlermeldung `Es wurde keine gueltige Array-Laenge uebergeben!` angezeigt werden. Anschließend soll sich das Programm mit dem Exit-Code 1 beenden.

* Der Benutzer gibt solange Preise ein, bis entweder das Array voll ist oder er bei einer der Eingaben ein 'x' eingibt. In dem Fall wird die Eingabe sofort beendet, alle vorher eingegebenen Benzinpreise bleiben aber erhalten.

* Es sollen nur gültige Preise (von 1 bis 2 € inklusiv der Grenzen, maximal mit 2 Nachkommastellen) eingegeben werden können! Wird ein fehlerhafter Preis eingegeben, soll die Fehlermeldung `Es wurde ein ungueltiger Preis eingegeben!` angezeigt werden und anschließend die erneute Eingabe eines korrekten Preises möglich sein.

* Nach dem Ende der Eingabe werden die Daten wie folgt ausgewertet:

  * Die Anzahl der eingegebenen Preise wird ausgegeben

  * Der kleinste und der größte eingegebene Preis wird ausgegeben

  * Der Mittelwert aller eingegebenen Preise wird ausgegeben

  * Die Spanne zwischen dem größten und dem kleinsten Preis wird ausgegeben

    Beispiel:
    Für die eingegebenen Benzinpreise 1.0, 1.20 und 1.8 würde die Auswertung z.B. folgende Ausgabe machen:

    ```
    Anzahl Preise:   3
    Kleinster Preis: 1.00
    Größter Preis:   1.80
    Mittelwert:      1.33
    Spanne:          0.80
    ```

* Danach beendet sich das Programm von selbst

* Die Ausgabe soll dabei wie oben zu sehen so erfolgen, dass die Zahlwerte linksbündig erscheinen und je nach Typ ohne oder mit zwei Nachkommastellen ausgegeben werden (siehe Hilfe)

* Die Benutzung  dynamische Datenstrukturen wie `List` und `Map` und sonstige Hilfsfunktionen von Java sind nicht erlaubt.

* Nutzt statische Hilfmethoden/Klassen, um den Code lesbarer zu gestalten.

## Hilfe

Für die Umwandlung eines Strings in eine Fließkommazahl kann die Funktion `Double.parseDouble()` verwendet werden. Falls die Umwandlung fehlschlägt, weil es sich um eine ungültige Zahl handelt, wird eine `NumberFormatException` geworfen. Diese lässt sich mittels `try`-`catch` fangen, um auf den Eingabefehler zu reagieren.

Beispiel:

```java
try {
    Double.parseDouble(str);
    // Umwandlung erfolgreich
} catch (NumberFormatException e) {
    // Umwandlung nicht erfolgreich
}
```

Analog hierzu kann ein String mit `Integer.parseInt()` in eine Ganzzahl umgewandelt werden.

Ein Java-Programm lässt sich mit `System.exit()` beenden. Der Aufruf beendet die aktuell laufende Java Virtual Machine.
Das Argument `status` nimmt den Status-Codeserves entgegen; nach Konvention zeigt ein Statuscode ungleich Null ann, dass
das Programm aufgrund eines Fehlers beendet wurde.

Mit `system.out.format()` können Werte von Variablen formatiert ausgegeben werden (siehe Aufgabe 3). Die Funktion `format()` kann übrigens auch mehrere Variablen gleichzeitig ausgeben. So kann beispielsweise vor einer formatierten Zahl auch noch ein String ausgegeben werden. Im Format-String wird hierzu der Platzhalter `%s` verwendet. Im nachfolgenden Beispiel wird zusätzlich noch `%n` verwendet, um am Ende der Zeile einen Zeilenumbruch, wie es `println` automatisch macht, zu erzeugen.

Beispiel:
```java
String text = "Test";
System.out.format("%s: %4.2f%n", text, Math.PI);
// Ausgabe:
// Test: 3.14
```

Ein Array kann mehrere gleiche Werte geordnet vorhalten. Die Größe des Arrays sollte zur besseren Wartbarkeit über eine Konstante geregelt werden:

```java
final static int MAX_ENTRIES = 10;

int[] entries = new int[MAX_ENTRIES];
```
Auf einen Wert in einem Array kann man lesend und schreibend wie folgt zugreifen: 
```java
final static int MAX_ENTRIES = 10;

int entry;
int[] entries = new int[MAX_ENTRIES];

// schreibend
entry = 3;
entries[4] = entry;

// lesend
entry = entries[4];
```

Die Kommandozeilenparameter werden der main-Methode als Parameter in Form eines Arrays übergeben. Der erste
Kommandozeilenparameter befindet sich dann beispielsweise an der ersten Position des `args`-Arrays. Werden beim Start
des Programms keine Parameter angegeben, existiert auch kein Array. Folgendes Beispiel gibt den ersten
Kommandozeilenparameter auf der Konsole aus:

```java
    System.out.println(args[0]);
``` 

Testet vor der Abgabe selbst mit verschiedenen Preisen, ob die Statistiken wie gefordert berechnet werden. Denkt dabei
auch daran, dass das Array evtl. nicht immer vollständig gefüllt sein muss (Abbruch durch 'x')! Auch für gar keinen
eingegebenen Preis sollen sinnvolle Ausgaben entstehen...

Formatierungsstrings für die Ausgabe:
```java
"\nAnzahl Preise:   %-4d"
"\nKleinster Preis: %-4.2f"
"\nGroesster Preis: %-4.2f"
"\nMittelwert:      %-4.2f"
"\nSpanne:          %-4.2f\n"
```