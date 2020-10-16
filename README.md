# Principles of Programming

## Rules of Play
- The tutorial is part of your training, treat it diligently
- Work in pairs (share harder problems in groups)
- Work together (not one student coding and the other just receives the solution)
- If you know the topic use that as a chance to dig deeper, explore or explain to others
- Agree/cancel the meetings (only cancel with a reason)
- In doubt ask. There might be errors in the exercises and you may have an idea how to improve it

## Quick Start
1.  Clone this repository
2.  Create your own private repository in github (gdp-2020-Kürzel)
3.  open a terminal and move to gdp-2020
4.  `git remote add gdp-2020-identifier git@github.com:YourUser/gdp-2020-identifier.git`
5.  `git push -u gdp-2020-identifier master`
6. clone your own repo into a different folder
    ```
    cd ..
    git clone git@github.com:YourUser/gdp-2020-identifier.git
    ```

# Allgemeine Einrichtung

Die Anleitung für die Einrichtung von Git unter Windows findest Du weiter unten.

## Repository auschecken

ACHTUNG: Das Auschecken funktioniert nur im `guestbykey` WLAN!

* `Git Bash` oder `Terminal` öffnen und in das gewünschte Verzeichnis wechseln
* SSH-URL auf der Projektseite in GitLab des gewünschten Repositorys kopieren und damit das Repository clonen

      git clone git@gitlab.com:rhahn/gdp-2018.git

* Anschließend fragt Git nach dem Passwort des SSH-Keys
* Beim ersten Auschecken muss noch das Zertifikat mit `yes` akzeptiert werden. 

## Projekt in IntelliJ importieren

* IntelliJ starten
* `File` `New` `Project from Existing Sources...` wählen
* Im Dialog `Select File or Directory to Import` das ausgecheckte Verzeichnis öffnen und die `build.gradle` auswählen und mit `OK` bestätigen
* Das Fenster `Import Project from Gradle` kann ohne Änderung bestätigt werden

# Einrichtung von Git unter Windows

## Git installieren

* Git for Windows von https://git-scm.com/download/win herunterladen
* Durch Doppelklick auf die heruntergeladene Datei die Installation starten

## Umgebungsvariable hinzufügen

Git for Windows erwartet standardmäßig den `.ssh` Ordner im Benutzerverzeichnis,
welches auf den standardbetankten Rechnern auf Laufwerk `G` liegt. Da man aber aus
dem standardmäßig eingestellten WLAN `gitlab.com` per SSH nicht erreichen kann und
über das guestbykey WLAN das Laufwerk `G` nicht erreichbar ist, muss das
Benutzerverzeichnis für Git mithilfe der `HOME` Umgebungsvariablen auf das lokale
Benutzerverzeichnis umgebogen werden.

## SSH-Key erstellen
Git Bash öffnen und folgenden Befehl ausführen. Zuvor muss allerdings noch die
E-Mail-Adresse angepasst werden!

    ssh-keygen -o -t rsa -C "vorname.nachname@otto.de" -b 4096

Nach kurzer Zeit erfolgt eine Abfrage nach dem Speicherort für den Key. Hier
sollte ein Pfad beginnend mit `/c` angezeigt werden. Andernfalls wurde die `HOME`
Umgebungsvariable nicht korrekt gesetzt bzw. muss die Git Bash nochmals
geschlossen und wieder geöffnet werden.

    Enter file in which to save the key (/c/Users/benutzername/.ssh/id_rsa):

Der vorgeschlagene Pfad kann einfach mit Enter ohne Änderung übernommen werden.

Der Key sollte auf jeden Fall mit einem Passwort geschützt werden.

    Enter passphrase (empty for no passphrase):
    Enter same passphrase again:

Wenn alles geklappt hat sollte sich ein `.ssh` Ordner unter `C:\Users\benutzername`
befinden.

## SSH-Key zu GitLab-Account hinzufügen

* In der GitLab-Oberfläche auf das Benutzer-Symbol (oben rechts) klicken und Settings anklicken.
* Im linken Menü SSH Keys aufrufen.
* Unter `Add an SSH key` den öffentlichen Schlüssel einfügen. Dieser befindet sich in der Datei `C:\Users\benutzername\.ssh\is_rsa.pub`, die zum Beispiel mit Notepadd++ geöffnet werden kann.
* Den neuen Key mit einem Klick auf `Add key` speichern