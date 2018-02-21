package model;

import model.User;

import java.time.LocalDateTime;

public class Statusmeldung {

    private String text;
    private User absender;
    private LocalDateTime datum;

    public Statusmeldung(String text, User absender) {
        this.text = text;
        this.absender = absender;
        this.datum = LocalDateTime.now();
    }


    public void setText(String newText) {
        this.text = newText;
    }


    public String getText() {
        return this.text;
    }

    public void setAbsender(User newAbsender) {
        this.absender = newAbsender;
    }

    public User getAbsender() {
        return this.absender;
    }

    public void setDatum(LocalDateTime newDatum) {
        this.datum = newDatum;
    }

    public LocalDateTime getDatum() {
        return this.datum;
    }


}
