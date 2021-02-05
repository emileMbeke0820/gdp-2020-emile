# Aufgabe 11: Figuren

### Thema: Vererbung, Überschreiben, dynamisches Binden, Polymorphie

## Aufgabenstellung

Zu erstellen ist eine Klasse für geometrische Figuren und mehrere Spezialisierungen dieser Klasse. Mehrere Figuren sind in einer verketteten Liste nach Größe der Fläche absteigend sortiert aufzunehmen und anschließend auszugeben.

### Klasse Color

Schreibt zunächst eine Klasse `Color`. Enthalten sein soll ein öffentlicher Aufzählungstyp (`enum`) mit den Bezeichnern diverser Farben und ein privates Array, was zu jeder Farbbezeichnung die zugehörigen Werte für die Kanäle rot, grün und blau enthält. Verwendet werden sollen die Bezeichnungen und Werte aus der Farbtabelle. Als Attribut der Klasse dient ein Array mit den Werten der drei Kanälen. Es sollen Instanzen erstellt werden können, indem

- die Werte für die drei Kanäle einzeln übergeben werden,
- die Werte für die drei Kanäle in einem Array übergeben werden,
- der Name der Farbe (als `enum`) übergeben wird,
- der Name der Farbe (als `String`, groß- oder kleingeschrieben) übergeben wird. In letztem Fall soll `null` zurückgeliefert werden, falls zu dem String keine äquivalente Bezeichnung existiert.

Legt hierfür - wenn möglich - Konstruktoren an und nutzt statische Methoden zum Erstellen einer Instanz nur, wenn ein Konstruktor nicht möglich ist. Nur einer der Konstruktoren darf das Attribut des Farbwertes setzen, die anderen Konstruktoren müssen diesen Konstruktor nutzen.

Public angeboten werden sollen außerdem die Methoden

- `boolean isKnownColorName(String colorName)` liefert true, wenn der Parameter einem definierten Farbbezeichner entspricht
- `int[] getRGB()` liefert die Werte der drei Kanäle in einem Array zurück
- `int getRGB(int channel)` liefert den Wert des gewünschten Farbkanals
- `int getPackedRGB()` liefert den Farbwert (die Werte der drei Kanäle) in einem int (Beispiel: (rot=10, grün=128, blau=255) -> hexA80FF = dez688383). Stringroutinen dürfen für die Wandlung nicht verwendet werden. Nutzt stattdessen ausschließlich bitweise Operatoren für die Umwandlung!
- `String toString()` liefert eine Stringdarstellung der Farbe: die Bezeichnung, falls eine für die Farbwerte vorhanden ist, sonst die Werte der 3 Farbkanäle in Hex-Darstellung.

Als private Methode soll mindestens entstehen

- `String getName()` liefert die Bezeichnung der Farbe oder `null` (verwendet `Arrays.equals()`).

Alle Methoden müssen ohne Änderung korrekt arbeiten, wenn der Enum zusammen mit der Farbtabelle erweitert (oder verkürzt) wird.

Entscheidet und begründet bei der Abnahme, welche Elemente der Klasse `static` sein müssen.

### Klasse Figure

Erstellt dann eine abstrakte Klasse `Figure` mit dem Attribut `color` vom Typ `Color` und den Methoden

- `getArea()` und
- `getPerimeter()`,

die jeweils als Default den Wert 0 zurückliefern.

### Klassen Circle, Triangle, Rectangle und Square

Fügt als Spezialisierungen in jeweils eigenen Dateien die Klassen `Circle`, `Triangle`, `Rectangle` und `Square` hinzu, die als Attribute den Durchmesser bzw. die Kantenlängen besitzen und die Methoden

- `getArea()` zum Ermitteln der Fläche und
- `getPerimeter()` zum Berechnen des Umfangs überschreiben.

Jede dieser Klassen benötigt mindestens einen Konstruktor, der die Farbe und die Attribute der Klasse übergeben bekommt und diese setzt.

Jede spezialisierte Klasse bietet eine Methode

- `getDescription()`, die eine Beschreibung der Klasse mit ihren speziellen Attributen in einem String liefert (Kantenlängen und Durchmesser besitzen maximal 2 Vor- und 2 Nachkommastellen).

In `Figure` soll `toString()` so überschrieben werden, dass eine Figur mit allen ihren allgemeinen Attributen Farbe, Umfang und Fläche und ihren speziellen Attributen (durch den Aufruf von `getDescription()`) beschrieben wird. Formatiert werden soll die Farbe auf 10 Stellen, Umfang besitzt 3, Fläche 4 Vor- und beide jeweils 2 Nachkommastellen. Nutzt hierfür die Methode `String.format()`, die genauso wie `System.out.printf()` als Parameter einen Formatierungsstring und Argumente erwartet, jedoch den formatierten String zurückliefert ohne ihn gleich auszugeben. Im Formatstring kann auch angegeben werden, dass ein Wert in hexadezimaler Form ausgegeben werden soll. Die Aufteilung der Texte in die verschiedenen `toString()`-Methoden ist gut gelungen, wenn der selbe (Formatierungs-)String nicht mehrfach in verschiedenen Klassen auftaucht.

### Klasse Element

Nutzt wie in den vorigen Übungen für eine Listenstruktur eine Klasse `Element` und passt das erste Attribut an (vom Typ `Figure` statt int). Erstellt einen Konstruktor, der eine `Figure` übergeben bekommt und entfernt die Methode `setValue()`. Die Methoden `isSame()` und `deleteElement()` können entfernt werden, da wir nicht entscheiden wollen, wann Figuren gleich sind. Auch andere nicht benötigte Methoden können entfernt werden.

Um Tests implementieren zu können, muss hier eine Methode `Figure[] getValues()` entstehen. Diese soll iterativ arbeiten.

Statt `showValues()` soll die Methode `toString()` entstehen, die einen String zurückliefert, der zeilenweise nummeriert die Informationen bezüglich des aktuellen und aller folgenden Elemente liefert. Die Werte sollen zur optimalen Lesbarkeit spaltenweise angeordnet sein. toString() soll eine rekursiv arbeitende private Hilfsmethode nutzen (rechts nicht angezeigt).

Die Figuren sollen der Flächengröße nach absteigend sortiert werden. Eine neue Figur soll hinter eine bestehende Figur mit gleich großer oder größerer Fläche einsortiert werden. Es muss eine Methode `compare()` entstehen, die die Größen der Flächen zweier Figuren miteinander vergleicht. Diese Methode wird sinnvollerweise in der Klasse `Figure` verankert. Angelehnt an gängige Vergleichsmethoden soll die Methode -1, 0 oder +1 zurückliefern, wenn die Fläche der übergebenen Figur größer, gleich oder kleiner als die der aktuellen Figur ist.
Da der Vergleich zweier Gleitkommawerte durch die Ungenauigkeiten nicht per Gleichheitszeichen möglich ist, bietet es sich an, eine Gleichheit zweier Werte anzunehmen, sobald ihre Differenz eine bestimmte Grenze unterschreitet. Die Grenze ist als Konstante in der Klasse `Figure` festzulegen.

    same = Math.abs(value1 - value2) < EPSILON; 

### Klasse Ueb11

In der Hauptklasse `Ueb11` soll eine Liste von Figuren aufgebaut werden. Gestaltet die Figuren bzw. die Reihenfolge derart, dass deutlich wird, dass ein Zufügen in der Liste am Anfang, am Ende und in der Mitte erfolgreich ist. Anschließend sollen die fertig erstellten Listenelemente unter Nutzung von `Element.toString()` ausgegeben werden.

Beispiel für die Ausgabe:

    Füge folgende Figuren zu:
    1.    unknown Dreieck  mit Kantenlängen (  7,00,   8,00,   4,00), Umfang:  19,00, Fläche:  14,00
    2.      GREEN Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07
    3.        RED Rechteck mit Kantenlängen (  7,00,   8,00),         Umfang:  30,00, Fläche:  56,00
    4.     YELLOW Quadrat  mit Kantenlänge  (  2,50),                 Umfang:  10,00, Fläche:   6,25
    und die weiteren...
    Liste neu erzeugt mit 12 Elementen.
    ------------------------------
     1.        RED Rechteck mit Kantenlängen ( 14,00,  16,00),         Umfang:  60,00, Fläche: 224,00
     2.        RED Rechteck mit Kantenlängen (  7,00,   8,00),         Umfang:  30,00, Fläche:  56,00
     3.    unknown Dreieck  mit Kantenlängen ( 14,00,  16,00,   8,00), Umfang:  38,00, Fläche:  55,99
     4.      GREEN Kreis    mit Durchmesser  (  6,00),                 Umfang:  18,85, Fläche:  28,27
     5.     YELLOW Quadrat  mit Kantenlänge  (  5,00),                 Umfang:  20,00, Fläche:  25,00 
     6.    unknown Dreieck  mit Kantenlängen (  7,00,   8,00,   4,00), Umfang:  19,00, Fläche:  14,00
     7.        RED Rechteck mit Kantenlängen (  3,50,   4,00),         Umfang:  15,00, Fläche:  14,00
     8.      GREEN Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07
     9.     YELLOW Quadrat  mit Kantenlänge  (  2,50),                 Umfang:  10,00, Fläche:   6,25 
    10.      WHITE Dreieck  mit Kantenlängen (  3,50,   4,00,   2,00), Umfang:   9,50, Fläche:   3,50
    11.      GREEN Kreis    mit Durchmesser  (  1,50),                 Umfang:   4,71, Fläche:   1,77
    12.    #0A80FF Quadrat  mit Kantenlänge  (  1,25),                 Umfang:   5,00, Fläche:   1,56
    ------------------------------

Stringformat für Figur:

    String.format(Locale.GERMAN, "%-10s %-51s Umfang: %6.2f, Fläche: %6.2f", colorName, getDescription() + ",", getPerimeter(), getArea())
Die Description muss aber auch entsprechend formatiert werden
## Tests
Versucht mit den Tests zu arbeiten. Sie geben euche eine hilfreiche Leitlinie

## Abstrakte Klassen
Abstrakte Klassen sind Klassen, die als Oberklassen dienen und selbst nicht zur Bildung von Objekten herangezogen werden können.

    abstract class Fahrzeug {
        Point pos = new Point(0,0);
        abstract void bewegDich(int h, int v);
        Point getPos() {
            return pos;
        }
    }

Das Beispiel Fahrzeug ist eine Klasse, die selbst nicht initialisiert werden kann.
Jede erbende Klasse kann die Funktion `getPos()` verwenden und muss selbst `bewegDich(...)` implementieren.

    abstract class Motorrad extends Fahrzeug {
        @Override
        void bewegDich(int h, int v) {
            pos = new Point(h, v);
        }
    }


## Nutzen von Assertions

Beim Entwickeln der Klassen wird klar, dass manche Methoden niemals aufgerufen werden, da sie von jeder erbenden Klasse überschrieben werden müssen. Hier ist es angebracht, den Programmierer über einen Fehler im Programmablauf zu informieren.

Auch im Programmcode kann man Erwartungen formulieren. Erwartet man z.B., dass eine Methode ausschließlich mit Arrays der Länge 3 aufgerufen wird, so kann man dies formulieren mit `assert 3 == arr.length;`. Soll eine Methode nie aufgerufen werden, so kann mit `assert false;` ein Fehlerhinweis erzeugt werden.

Damit Assertions bei der Programmausführung ausgewertet werden, muss in den Projekteigenschaften unter File/Project Properties unter der Kategorie Run die Option -ea (enable assertions) angegeben werden:

Auf diese Weise kann man während der Entwicklung auf Fehler im Programmcode hingewiesen werden. Zur Auslieferung würde man das Projekt ohne die Option kompilieren und so ein schlankeres Kompilat erhalten, ohne die Fehlerprüfung aus den Sourcen genommen zu haben.



Möchte man in JUnit testen, ob beispielsweise bei Übergabe eines zu langen Arrays eine Assertion ausgelöst wird, so schreibt man im Testcode eine Erwartung hinter die Annotation des auslösenden Tests:

    @Test (expected = AssertionError.class)

## Farbtabelle

Farbbezeichnungen mit Werten in hexadezimaler Darstellung:

    Bezeichnung	R	G	B
    BLACK       00  00  00
    NAVY        00  00  80
    BLUE        00  00  FF
    GREEN       00  80  00
    LIME        00  FF  00
    AQUA        00  FF  FF
    PURPLE      80  00  80
    SILVER      C0  C0  C0
    RED         FF  00  00
    FUCHSIA     FF  00  FF
    YELLOW      FF  FF  00
    WHITE       FF  FF  FF

### Viel Erfolg!