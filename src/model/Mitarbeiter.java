package model;

import datenbank.Datenbank;
import model.Person;

public class Mitarbeiter extends Person implements Loeschbar {


    private String wohnort;
    private boolean isactive;
    private String aufgabenBereich;
    private double gehalt;

    public Mitarbeiter(String vorname, String nachname, String email, String passwort, int geburtsjahr) {
        super(vorname, nachname, email, passwort, geburtsjahr);
    }

    public void setAktive(boolean newAktive) {
        this.isactive = newAktive;
    }

    public boolean getAktive() {
        return this.isactive;
    }

    public void setEmail(String email) {
        if (email.endsWith("@awesomecompany.com") && !email.isEmpty()) {
            super.email = email;
        } else {
            System.out.println("keine gültige Email-model.Adresse für model.Mitarbeiter");
        }
    }

    public void setWohnort(String newWohnort) {
        this.wohnort = newWohnort;
    }

    String getWohnort() {
        return this.wohnort;
    }


    @Override
    public void loesche(Datenbank datenbank) {
        datenbank.statuswechselMitarbeiter(email);
    }
}
