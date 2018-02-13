package datenbank;

import datenbank.Datenbank;
import model.Person;

public class LoginMechanismus {
    private Datenbank datenbank;

    public LoginMechanismus(Datenbank datenbank) {
        this.datenbank = datenbank;
    }


    public boolean login(Person person) {
        String passwort = person.getPasswort();
        String email = person.getEmail();
        return datenbank.istNutzervorhanden(email, passwort);
    }
}
