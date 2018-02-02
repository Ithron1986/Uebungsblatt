import javax.xml.ws.soap.Addressing;

public class Adresse {
    private String wohnort;
    private String straße;
    private int postleitzahl;
    private int hausnummer;

    public Adresse(String straße, int hausnummer, int postleitzahl, String wohnort) {
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        this.wohnort = wohnort;

    }

    public Adresse() {
    }


    public Adresse(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public void setStraße(String newStraße) {
        this.straße = newStraße;
    }

    String getStraße() {
        return this.straße;
    }

    public void setHausnummer(int newHausnummer) {
        this.hausnummer = newHausnummer;
    }

    int getHausnummer() {
        return this.hausnummer;

    }

    public void setPostleitzahl(int newPostleitzahl) {
        this.postleitzahl = newPostleitzahl;
    }

    int getPostleitzahl() {
        return this.postleitzahl;
    }

    public void setWohnort(String newWohnort) {
        this.wohnort = newWohnort;
    }

    String getWohnort() {
        return this.wohnort;
    }


}
