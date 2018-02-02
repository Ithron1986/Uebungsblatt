import java.io.*;


public class UserSpeicher {
    Datenbank datenbank;
    String pfad = "G:/6_Datein/Unterlagen2018/Programmieren/Datenspeicher.csv";
    private String headerLine = "Vorname,Nachname,Email,Passwort,Geburtsjahr";

    public UserSpeicher(Datenbank datenbank) {
        this.datenbank = datenbank;
        datenSpeicherohneRedundanz(headerLine);
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
                zeile = zeile.replaceAll("\n","").replaceAll("\r","");
                System.out.println("src: "+line +"\r\ntarget: "+line);
                if (line.equals(zeile)) {
                    System.out.println("zeile vorhanden "+zeile);
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
            FileWriter newFileWriter = new FileWriter(pfad,true);
            newFileWriter.append(line);
            newFileWriter.append("\r\n");
            newFileWriter.close();
            newFileWriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void saveUser(User user) {
        datenSpeicherohneRedundanz(user.toString());
    }
}
