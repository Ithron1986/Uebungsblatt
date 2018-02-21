package model;

import datenbank.Datenbank;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Adresse;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Loeschbar {
    ObservableList<Statusmeldung> posts;

    Adresse newUserAdresse;

    public User(String vorname, String nachname, String email, String passwort, int geburtsjahr, Adresse newUserAdresse) {
        super(vorname, nachname, email, passwort, geburtsjahr);
        this.newUserAdresse = newUserAdresse;
        this.posts = FXCollections.observableArrayList();

    }

    public User(String vorname, String nachname, String email, String passwort, int geburtsjahr) {
        this(vorname, nachname, email, passwort, geburtsjahr, null);
    }

    public String toString() {
        return getVorname() + "," + getNachname() + "," + getEmail() + "," + getPasswort() + "," + getGeburtsjahr()+"\n";
    }

    public ObservableList<Statusmeldung> getPosts (){
        return posts;
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

    @Override
    public void loesche(Datenbank datenbank) {
        datenbank.loescheUser(getEmail());
    }
}
