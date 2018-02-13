package model;

import java.time.LocalDateTime;

public abstract class Person {

    private String vorname;
    private String nachname;
    protected String email;
    private int geburtsjahr;
    private String passwort;
    int aktuellesJahr = LocalDateTime.now().getYear();

    public Person(String vorname, String nachname, String email, String passwort, int geburtsjahr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.geburtsjahr = geburtsjahr;
        this.passwort = passwort;
    }

    public void setVorname(String newVorname) {
        this.vorname = newVorname;
    }

    String getVorname() {
        return this.vorname;
    }

    public void setNachname(String newNachname) {
        this.nachname = newNachname;
    }

    String getNachname() {
        return this.nachname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPasswort() {
        return this.passwort;
    }

    public void setPasswort(String passwort) {
        final int minimalePasswortlänge = 8;
        if (passwort.length() >= minimalePasswortlänge) {
            this.passwort = passwort;
        } else{ throw new DoesNotFitLengthPassword(passwort);
        }
    }

    public abstract void setEmail(String email);


    public void setGeburtsjahr(int newGeburtsjahr) {
        if (geburtsjahr <= 1900 || geburtsjahr > this.aktuellesJahr)
            throw new DoesNotFitException(1900, this.aktuellesJahr, geburtsjahr);

        this.geburtsjahr = newGeburtsjahr;

    }

    int getGeburtsjahr() {
        return this.geburtsjahr;
    }

    public boolean istVolljährig() {
        return this.aktuellesJahr - geburtsjahr >= 18;
    }

}
