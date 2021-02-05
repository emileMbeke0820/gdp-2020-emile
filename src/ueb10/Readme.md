# Aufgabe 10: Nutzung der Liste

### Thema: Nutzung der Liste

## Aufgabenstellung

Es soll eine Klasse `Set` erstellt werden, die mehrere Funktionalitäten einer Menge bietet.

Dem Programm werden beim Aufruf mehrere Ganzzahlen übergeben. Die Zahlen sind jeweils durch Leerzeichen voneinander getrennt und stellen die Elemente einer Menge dar. Sobald eines der Aufrufargumente aus einem Schrägstrich besteht, werden alle folgenden Zahlen einer zweiten Menge zugeordnet.

In der Main wird zunächst die Argumentliste ausgegeben, dann in Folge

- die erste Menge,
- die zweite Menge,
- die Vereinigungsmenge,
- die Schnittmenge,
- die Differenzmenge und
- ob die erste Menge eine echte [Teilmenge](https://de.wikipedia.org/wiki/Teilmenge) der zweiten ist.

Die Mengenelemente werden aufsteigend sortiert gespeichert und ausgegeben. Beispiel für die Ausgabe:

    Test Klasse Set
     Argumente            : [5, 2, 4, 3, 1, /, 2, 6, 1]
     Menge A              : {1 2 3 4 5}
     Menge B              : {1 2 6}
     Vereinigung     A ∪ B: {1 2 3 4 5 6}
     Schnittmenge    A ∩ B: {1 2}
     Differenzmenge  A \ B: {3 4 5}
     echte Teilmenge A ⊂ B: false

## Zu erfüllende Vorgaben

Erstellt ein neues Package (ueb10), ladet euch die Klassen [Ueb10.java](Ueb10.java) und [Set.java](Set.java) herunter und kopiert diese und die in Aufgabe 09 erstellte Klasse `Element` hinein.

### Klasse Set:

- Die Klasse `Set` stellt eine Menge und die mit dieser Menge möglichen Operationen dar.
- Um die Elemente der Menge zu fassen, wird ein Attribut vom Typ `Element` angelegt.

Folgende public Methoden sollen implementiert werden:

- `boolean isEmpty()` prüft, ob Elemente enthalten sind,
- `addElement(int value)` fügt ein neues Element mit übergebenem Wert zu, wenn der Wert noch nicht existiert. Ein Wert kann also nur ein Mal in der Menge vorkommen.
- `boolean existsElement(int value)` prüft, ob der Wert schon in der Elementliste existiert,
- `deleteElement(int value)` löscht ein Element diesen Wertes; falls es nicht vorhanden ist, passiert nichts,
- `String showValues()` liefert eine Stringdarstellung des Mengeninhalts mit umschließenden geschweiften Klammern,
- `int[] getValues()` liefert ein Array mit allen enthaltenen Werten (iterative Lösung),
- `boolean isSame(Set other)` prüft, ob die übergebene Menge die gleichen Werte enthält wie die aktuelle (size() darf hier nicht verwendet werden!),

- `Set union(Set other)` liefert eine neue Menge, die die Vereinigung der aktuellen mit der übergebenen abbildet,
- `Set intersection(Set other)` liefert eine neue Menge, die die Schnittmenge der aktuellen mit der übergebenen abbildet,
- `Set diff(Set other)` liefert eine neue Menge, die die Differenzmenge der aktuellen mit der übergebenen abbildet,
- `boolean isProperSubSet(Set other)` prüft, ob diese Menge eine echte Teilmenge der übergebenen ist.

Die Klasse soll mindestens folgende private Methode enthalten:

- `addElementList(Element list)` fügt alle noch nicht enthaltenen Werte einer übergebenen Liste vom Typ Element als Elemente zu

Keine der `public`-Methoden benutzt die Klasse Element als Typ für die Rückgabe oder einen Parameter.


### Klasse Element:

Es dürfen alle Methoden dieser Klasse aus der vorigen Übung beibehalten werden oder aber nur die benötigten gelassen werden.

Das Zufügen eines Elements soll aufsteigend sortiert erfolgen. Methoden wie `existsElement()` und `deleteElement()` sollen von der sortierten Liste ausgehen und somit - wenn möglich - nicht bis zum Listenende suchen. Legen Sie diese Einschränkung im Kommentar der jeweiligen Methode dar.

Zusätzlich erstellt werden muss die `public`-Methode

- `boolean isSame(Element other)` prüft, ob dies und die jeweiligen Folgeelemente die gleichen Werte enthalten und die Listen gleich lang sind. Nutzt `size()` nicht in dieser rekursiven Struktur!


### Klasse Ueb10:

enthält die auszuführende Routine `main()` und zwei Routinen.
Um bei der Eingabe variabel zu sein, wird in der Klasse eine Konstante für das Trennzeichen angelegt. Per Default soll die Konstante für das Eingabetrennzeichen mit einem Schrägstrich belegt sein.

- `getSetsFromArgs()` erhält als Parameter zwei Mengen und die dem Programm übergebene Argumentliste und füllt die Mengen mit den zu Zahlen umgewandelten Strings aus der Argumentliste. Die Argumentliste enthält dabei ein in der Klasse als Konstante festgelegtes Trennzeichen (per default "/"). Alle Werte vor dem Trennzeichen werden der ersten Menge zugewiesen, alle nach dem Trennzeichen der zweiten Menge. Existiert kein Trennzeichen, so wandern alle Werte in die erste Menge und die zweite Menge bleibt leer. Wird kein Parameter angegeben, so bleiben beide Mengen leer. In dieser Aufgabe darf davon ausgegangen werden, dass nur gültige Integerwerte und das Trennzeichen als Parameter eingegeben werden, andernfalls darf das Programm mit einer Exception abbrechen.
- `testClassSet()` erhält zwei Mengen als Parameter. Jede der über die Methoden von Set angebotenen Mengenoperationen wird jetzt mit diesen zwei Mengen aufgerufen und die erhaltenen Mengen wie in obigem Beispiel ausgegeben.

In der `main()` werden zunächst die erhaltenen Argumente angezeigt (nutzt hierfür `Arrays.toString(args)`) und dann beide Methoden passend aufgerufen.

### Tests

- [Ueb10Test.java](Ueb10Test.java) enthält den Test der `main` Methode und testet die Ausgabe auf der Konsole.
- [SetTest.java](SetTest.java) enthält bereits Tests für die Methode `Set.isSame()`.
- Schreibt Tests für die Set-Methoden `union()`, `diff()`, `intersection()` und `isProperSubSet()`.
- Testet die Methoden jeweils mit
  - zwei disjunkten Mengen,
  - zwei Mengen mit Überschneidung,
  - zwei Mengen, von denen eine die andere enthält,
  - zwei Mengen, von denen eine leer ist.
- Pro zu testender Set-Methode entstehen also mindestens 4 Testmethoden.
- Achtet bei der Benennung der Tests darauf, dass die Testmethode mit <test> beginnt, mit dem beginnend groß geschriebenen Methodennamen fortfährt und durch einen Unterstrich getrennt die besondere Situation beschrieben wird: z.B. `testUnion_EmptySet()`.
- Vergleicht die erhaltenen Mengen mit den erwarteten per `assertArrayEquals()` unter Nutzung von `Set.getValues()`.
- Schreibt zunächst alle Testmethoden für eine zu testende Set-Methode (z.B. `union()`). Implementiert dann die zu testende Methode (`Set.union()`) und testet sie. Die Testmethoden `testUnion_*()` können dann einfach kopiert und für die anderen Set-Methoden angepasst werden.

## Hilfe
### Hilfreiche Methoden

`Arrays.toString(args)` - liefert die Werte des übergebenen Arrays kommasepariert und mit umgebender eckiger Klammer in einem String zurück

`Integer.valueOf(s)` - wandelt einen übergebenen String in einen Integer-Wert


### Programmparameter

Bei Ausführung in IntelliJ kann unter Run -> Run Configurations... für die jeweilige Konfiguration im Feld Program Arguments die Argumentliste angegeben werden.

Im Programm erhält die Methode `main(String[] args)` alle Programmparameter in dem Array args. Es liegen also alle als Programmparameter eingegebenen Werte (und eventuell auch ein "/") einzeln als String in einem Array vor und können in weiteren Methoden verarbeitet werden.

### Viel Erfolg!