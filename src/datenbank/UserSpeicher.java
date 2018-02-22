package datenbank;

import datenbank.Datenbank;
import model.Statusmeldung;
import model.User;

import java.io.*;
import java.nio.file.Files;


public class UserSpeicher {
    private int speicherFortschritt = 0;
    String currentLine;
    File inputFile = new File("G:/6_Datein/Unterlagen2018/Programmieren/Datenspeicher.csv");
    File tempFile = new File("G:/6_Datein/Unterlagen2018/Programmieren/Tempfile.csv");
    String pfad = "G:/6_Datein/Unterlagen2018/Programmieren/Datenspeicher.csv";
    String pfadStatusMeldung = "G:/6_Datein/Unterlagen2018/Programmieren/DatenspeicherStatusmeldungen.csv";
    private String headerLine = "Vorname,Nachname,Email,Passwort,Geburtsjahr";

    public UserSpeicher() {
        datenSpeicherohneRedundanz(headerLine);
    }

    public void saveStatusmeldungen(Statusmeldung statusmeldung) {
        writeLine(statusmeldung.getText(), pfadStatusMeldung);
    }

    // Datei einlesen durchsuchen nach Zeile X in Temp File speichern ohne die bestimmte Zeile X und anschließend ursprungsdatei Löschen + Temp umbennen
//version 1
    /*public void delete(String linetoRemove) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            while ((currentLine = reader.readLine()) != null) {
                String trimmmedLine = currentLine.trim();
                if (trimmmedLine.equals(linetoRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

//das hier hat mit fehlermeldungen zu tun
            boolean successfull = tempFile.renameTo(inputFile);
            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }*/
    //Version2

    public void removeLine(String email) {
        try {
            File file = new File(pfad);
            File temp = new File("G:/6_Datein/Unterlagen2018/Programmieren/Tempfile.csv");
            PrintWriter out = new PrintWriter(new FileWriter(tempFile));
            Files.lines(file.toPath())
                    .filter(line -> !line.contains(email))
                    .forEach(out::println);
            out.flush();
            out.close();
            boolean hatGeklappt = temp.renameTo(file);
            if (!hatGeklappt) {
                System.out.println("hat nicht geklappt");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /* }
    public void  delete(String zeile){
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

                }
            }
            newFileReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }*/

    public void backupSpeicher(User user) {

        if (speicherFortschritt > 3) {
            saveUser(user);
            // hier will ich einen alternativen Speicherpfad nehmen (dafür müsste
            // ich allerdings tief in die Methode zum Abspeichern)
            //datenSpeicherohneRedundanz(line).writeline(line)+ anderen Pfad für den Filewriter;
            // erstelle eine neue Datei für den Backupspeicher in dieser Datei wird abhängig vom Inhalt hochgezählt
            // wenn der Counter einen Schwellenwert erreicht hat wird dieser zurückgesetzt und in das zweite Dokument gespeichert
            speicherFortschritt = 0;
        }
        saveUser(user);
    }

    private void datenSpeicherohneRedundanz(String line) {
        if (!istZeileVorhanden(line)) {
            writeLine(line, pfad);
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


    private void writeLine(String line, String pfadVariabel) {
        try {
            FileWriter newFileWriter = new FileWriter(pfadVariabel, true);
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
