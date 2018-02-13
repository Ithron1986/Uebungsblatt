package datenbank;

import datenbank.Datenbank;
import model.User;

import java.io.*;


public class UserSpeicher {
    private int speicherFortschritt = 0;
    Datenbank datenbank;
    String pfad = "G:/6_Datein/Unterlagen2018/Programmieren/Datenspeicher.csv";
    private String headerLine = "Vorname,Nachname,Email,Passwort,Geburtsjahr";

    public UserSpeicher(Datenbank datenbank) {
        this.datenbank = datenbank;
        datenSpeicherohneRedundanz(headerLine);
    }

    public void backupSpeicher(User user) {

        if (speicherFortschritt>3 ){
            saveUser(user);
            // hier will ich einen alternativen Speicherpfad nehmen (dafür müsste
            // ich allerdings tief in die Methode zum Abspeichern)
            //datenSpeicherohneRedundanz(line).writeline(line)+ anderen Pfad für den Filewriter;
            // erstelle eine neue Datei für den Backupspeicher in dieser Datei wird abhängig vom Inhalt hochgezählt
            // wenn der Counter einen Schwellenwert erreicht hat wird dieser zurückgesetzt und in das zweite Dokument gespeichert
            speicherFortschritt =0;
        }saveUser(user);
    }

    private void datenSpeicherohneRedundanz(String line) {
        if (!istZeileVorhanden(line)) {
            writeLine(line);
        }
    }

    private boolean istZeileVorhanden(String zeile) {
        try {
            FileReader newFileReader = new FileReader(pfad);
            BufferedReader newBufferedReader = new BufferedReader(newFileReader);
            String line = null;
            while ((line = newBufferedReader.readLine()) != null) {
                line = line.replaceAll("\n", "").replaceAll("\r", "");
                zeile = zeile.replaceAll("\n", "").replaceAll("\r", "");
                System.out.println("src: " + line + "\r\ntarget: " + line);
                if (line.equals(zeile)) {
                    System.out.println("zeile vorhanden " + zeile);
                    return true;
                }
            }
            newFileReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return false;
    }


    private void writeLine(String line) {
        try {
            FileWriter newFileWriter = new FileWriter(pfad, true);
            newFileWriter.append(line);
            newFileWriter.append("\r\n");
            newFileWriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void saveUser(User user) {
        datenSpeicherohneRedundanz(user.toString());
    }
}
