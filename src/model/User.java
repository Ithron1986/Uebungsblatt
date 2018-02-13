package model;

import datenbank.Datenbank;
import model.Adresse;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Loeschbar {
    List<Statusmeldung> posts;

    Adresse newUserAdresse;

    public User(String vorname, String nachname, String email, String passwort, int geburtsjahr, Adresse newUserAdresse) {
        super(vorname, nachname, email, passwort, geburtsjahr);
        this.newUserAdresse = newUserAdresse;
        this.posts = new ArrayList<>();

    }

    public User(String vorname, String nachname, String email, String passwort, int geburtsjahr) {
        this(vorname, nachname, email, passwort, geburtsjahr, null);
    }

    public String toString() {
        return getVorname() + "," + getNachname() + "," + getEmail() + "," + getPasswort() + "," + getGeburtsjahr()+"\n";
    }

    public List<Statusmeldung> filtereNachZeichenZahl(int zeichenzahl) {
        ArrayList<Statusmeldung> ergebnis = new ArrayList<>();
        for (Statusmeldung s : posts) {
            if (s.getText().length() > zeichenzahl) {
                ergebnis.add(s);
            }
        }
        return ergebnis;
    }

    public void setEmail(String email) {
        if (!email.isEmpty() && email.contains("@") && email.contains(".")) {
            super.email = email;
        } else {
            System.out.println("keine gültige Email");
        }
    }

    public void postHinzufügen(String text) {
        this.posts.add(new Statusmeldung(text, this));
    }


    public void setAdresse(Adresse newAdresse) {
        this.newUserAdresse = newAdresse;

    }

    Adresse getAdresse() {
        return this.newUserAdresse;
    }

    public void gibAlleStatusMeldungenAus() {
        for (Statusmeldung post : posts) {
            System.out.println(post.getText());
            System.out.println((super.getVorname() + ", " + post.getDatum()));
        }
    }

    @Override
    public void loesche(Datenbank datenbank) {
        datenbank.loescheUser(getEmail());
    }
}
