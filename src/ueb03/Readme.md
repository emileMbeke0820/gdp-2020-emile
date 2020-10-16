# Aufgabe 3

## Thema: Schleifen (`for`, `while`, `do while`)

Mithilfe der verschiedenen Schleifentypen sollen für mehrere natürliche Zahlen ein paar Kennwerte ausgegeben werden.

## Anforderungen

* Nach Programmstart wird der Benutzer nacheinander nach einer unteren und oberen Grenze gefragt, zwischen diesen (inklusive der Grenzen) eine Zahl aufsteigend alle Werte durchlaufen soll. Die Grenzen könnten dabei z.B. bei 1 und 50 liegen. Ihr könnt davon ausgehen, dass die obere Grenze immer mindestens um 1 größer als die untere ist.

* Für jeden durchlaufenen Wert sollen folgende Dinge in statischen methoden bestimmt werden:

  * ist die Zahl gerade?

  * ist die Zahl prim? (https://de.wikipedia.org/wiki/Primzahl)

  * ist die Zahl eine Dreieckszahl? (https://de.wikipedia.org/wiki/Dreieckszahl)

* Pro Zahl sollen dann in jeweils einer Zeile die Zahl selbst sowie die Ergebnisse der drei Prüfungen ausgegeben werden. Die Ausgabe der ersten Zeilen soll wie folgt aussehen:

```
 1 gerade: false prim: false dreieck: true
 2 gerade: true  prim: true  dreieck: false
 3 gerade: false prim: true  dreieck: true
 4 gerade: true  prim: false dreieck: false
 5 gerade: false prim: true  dreieck: false
 6 gerade: true  prim: false dreieck: true
 7 gerade: false prim: true  dreieck: false
 8 gerade: true  prim: false dreieck: false
 9 gerade: false prim: false dreieck: false
10 gerade: true  prim: false dreieck: true
11 gerade: false prim: true  dreieck: false
12 gerade: true  prim: false dreieck: false
...
```

* Überlegt Euch bei allen sich wiederholenden Schritten, welcher Schleifentyp der passendste ist (hinsichtlich Eintritts- und Abbruchbedingung und Häufigkeit der Ausführung des Schleifenrumpfes) und begründet dies ggf. auch bei der Abnahme!

* Jeder Schleifentyp (`for`, `while`, `do while`) muss mindestens ein Mal vorkommen!

* Die Benutzung von Arrays und Schleifen sowie weiteren, hier noch nicht behandelten Themen ist nicht erlaubt! Hierzu zählen auch dynamische Datenstrukturen wie `List` und `Map` und sonstige Hilfsfunktionen von Java

## Hilfe

`System.out.format` kann Euch bei der formatierten Ausgabe behilflich sein! Bei der Nutzung dieser Ausgabe-Methode baut man den auszugebenden String nicht durch Konkatenation von Strings und Variablen auf, sondern definiert vorab einen String mit Platzhaltern, welche beim Aufruf der Methode durch die Werte der übergebenen Variaben ersetzt werden.

Folgende Platzhalter können in dieser Aufgabe nützlich sein: `%d` (Ganzzahl), `%b` (Boolean) und `%n` (Zeilenumbruch). Die Platzhalter lassen sich zusätzlich in ihrer Breite konfigurieren. Ein `%2d` sorgt beispielsweise dafür, dass eine Ganzzahl-Variable immer zweistellig rechtsbündig ausgegeben wird. Soll die Ausgabe stattdessen linksbündig sein, muss zusätzlich noch ein Minuszeichen verwendet werden: `%-2d`.

Ein Beispiel:
```java
int zahl1 = 1;
int zahl2 = 10;

System.out.format("%2d%n", zahl1);
System.out.format("%2d%n", zahl2);

// Ausgabe:
//  1
// 10
```
Bei der Entwicklung definiert Ihr Euch am besten zunächst nur einen kleinen Bereich von Zahlen, für die alles berechnet wird, testet jeden Teil nach seiner Implementierung für sich und baut auch in Schleifen zwischendrin mal Testausgaben ein. So könnt Ihr schon während der Entwicklung Dinge testen und stellt nicht erst am Ende fest, dass irgendwas falsch läuft :-)

Der syntaktische Aufbau der drei Schleifentypen ist in den folgenden Beispielen ersichtlich (die übrigens alle drei exakt dasselbe ausgeben): 

```java
int i, j;

for (i = 1; i <= 10; i++) {
 System.out.println(i);
}

for (i = 1; i <= 10; i++) {
 j = i * i;
 System.out.println(j);
}

i = 0;
while (i < 10) {
 i++;
 System.out.println(i);
}

i = 0;
while (i < 10) {
 i++;
 j = i * i;
 System.out.println(j);
}

i = 0;
do {
 i++;
 System.out.println(i);
} while (i < 10);

i = 0;
do {
 i++;
 j = i * i;
 System.out.println(j);
} while (i < 10);
```

Testet vor der Abgabe selbst mit verschiedenen Zahlen für die Konstanten, ob die Ausgaben und Berechnungen korrekt sind!

### Funktionen

Mit Funktionen lassen sich wiederkehrende Aufgaben aus dem Hauptprogramm ausgliedern, sodass man diesen Code nicht doppelt schreiben muss und ihn stattdessen wiederverwenden kann. Das macht den Code kürzer, lesbarer und leichter wartbar.

Die Parameterübergabe erfolgt in Java immer nach dem Prinzip "call by value". Das bedeutet, dass die übergebenen Werte immer kopiert werden. 
Eine Variable, die vor einem Funktionsaufruf deklariert wird und dann einer Funktion übergeben wird, enthält daher nach dem Funktionsaufruf immer denselben Wert wie zuvor, auch wenn innerhalb der Funktion Veränderungen darauf vorgenommen werden. 
ACHTUNG: Es gibt jedoch einen Sonderfall, in dem das nicht so ist. Modifiziert man innerhalb einer Funktion einen Parameter, der auf ein Objekt (dazu gehören auch Arrays) zeigt, ändert sich auch der Wert außerhalb der Funktion. Hierauf gehen wir in einer zukünftigen Aufgabe noch genauer ein.

Ein Beispiel für eine Funktion ohne Rückgabe Wert:

```java
private static void schrei(String wort) {   
    System.out.println("wort".toUpperCase() + "!")
}

public static void main(final String[] args) {
	String meinWort = "hallo"
	schrei(meinWort) // ergibt  "HALLO!" in der Log ausgabe
}
```

Ein Beispiel for eine Funktion mit Rückgabewert:
```java
public static String passendesZielFuer(boolean magTiere, boolean magHamburg) {
        if (magTiere && magHamburg) {
            return "Hagenbecks Tierpark";
        } else if (magTiere) {
            return  "Wildpark Schwarze Berge";
        } else if (magHamburg) {
            return  "Dom";
        } else {
            return "Kieler Woche";
        }
    }

public static void main(final String[] args) {
	String zielFuerHamburgerTierliebhaber = passendesZielFuer(true, true)
    System.out.println("Das passende Ziel für einen Tierliebhaber in Hamburg ist " + zielFuerHamburgerTierliebhaber);
}
```
