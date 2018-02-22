package model;

import java.time.LocalDateTime;

public abstract class Person {

    private String vorname;
    private String nachname;
    protected String email;
    private int geburtsjahr;
    private String passwort;
    int aktuellesJahr = LocalDateTime.now().getYear();
    Adresse adresse = new Adresse();

    public Person(String vorname, String nachname, String email, String passwort, int geburtsjahr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.geburtsjahr = geburtsjahr;
        this.passwort = passwort;
    }

    public Person(String vorname, String nachname, String email, String passwort, int geburtsjahr, Adresse adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.geburtsjahr = geburtsjahr;
        this.passwort = passwort;
        this.adresse =adresse;
    }

    public void setVorname(String newVorname) {
        this.vorname = newVorname;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setNachname(String newNachname) {
        this.nachname = newNachname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPasswort() {
        return this.passwort;
    }

    public void setAdresse(Adresse newAdresse) {
        this.adresse = newAdresse;

    }

    public Adresse getAdresse() {
        return this.adresse;
    }



    public void setPasswort(String passwort) {
        final int minimalePasswortlänge = 8;
        if (passwort.length() >= minimalePasswortlänge) {
            this.passwort = passwort;
        } else {
            throw new DoesNotFitLengthPassword(passwort);
        }
    }

    public abstract void setEmail(String email);


    public void setGeburtsjahr(int newGeburtsjahr) {
        if (geburtsjahr <= 1900 || geburtsjahr > this.aktuellesJahr)
            throw new DoesNotFitException(1900, this.aktuellesJahr, geburtsjahr);

        this.geburtsjahr = newGeburtsjahr;

    }

    public int getGeburtsjahr() {
        return this.geburtsjahr;
    }

    public boolean istVolljährig() {
        return this.aktuellesJahr - geburtsjahr >= 18;
    }

}
