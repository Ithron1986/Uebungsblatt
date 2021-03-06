package datenbank;

import logger.Logger;
import model.Mitarbeiter;
import model.Person;
import model.Statusmeldung;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class Datenbank {
    private Logger logger;
    private Map<String, User> users;
    private Map<String, Mitarbeiter> mitarbeiter;
    private Datenbank standardDatenbank;
    UserSpeicher userSpeicher;

    public Datenbank(UserSpeicher userSpeicher) {
        this.userSpeicher = userSpeicher;

        //this.users = userSpeicher.load();
        this.users = new HashMap<>();
        this.mitarbeiter = new HashMap<>();
       /* try{this.logger = new logger.DateiLogger("G:/6_Datein/Unterlagen2018/Programmieren/NeuerUser.csv");}
        catch (logger.LogFileException lfe){
            System.err.println(lfe);
            this.logger = new logger.FakeLogger();
        }
*/
    }


    public void register(Person person) {
        if (this.users.containsKey(person.getEmail())) {
            throw new RuntimeException("Email bereits belegt");
        }
        if (person instanceof User) {
            User newUser = (User) person;
            this.users.put(newUser.getEmail(), newUser);
        } else if (person instanceof Mitarbeiter) {
            Mitarbeiter newMitarbeiter = (Mitarbeiter) person;
            newMitarbeiter.setAktive(true);
            this.mitarbeiter.put(newMitarbeiter.getEmail(), newMitarbeiter);
        } else {
            throw new RuntimeException("Unbekannter Nutzertyp");
        }

        //this.datenspeicher.save(this.users);
    }

    public void updateUserData(User user, String email) {
        System.out.println("hier");
        User alterUser = users.get(email);
        String lineToremove = alterUser.toString();
        alterUser.setVorname(user.getVorname());
        alterUser.setNachname(user.getNachname());
        alterUser.setEmail(user.getEmail());
        alterUser.setPasswort(user.getPasswort());
        alterUser.setGeburtsjahr(user.getGeburtsjahr());
        alterUser.setAdresse(user.getAdresse());

        userSpeicher.removeLine(lineToremove);
        userSpeicher.saveUser(user);
    }

    public void speichereStatusmeldungen(Statusmeldung statusmeldung) {
        userSpeicher.saveStatusmeldungen(statusmeldung);
    }


    public void statuswechselMitarbeiter(String email) {
        Mitarbeiter mitarbeiter = this.mitarbeiter.get(email);
        mitarbeiter.setAktive(false);
    }

    public User getUser(String email) {
        return this.users.get(email);
    }

    public boolean istNutzervorhanden(String email, String passwort) {
        Person person = this.users.get(email);
        if (person == null) {
            Mitarbeiter newMitarbeiter = this.mitarbeiter.get(email);
            if (newMitarbeiter == null || !newMitarbeiter.getAktive() || !newMitarbeiter.getPasswort().equals(passwort)) {
                return false;
            }
            return true;
        }
        return person != null && person.getPasswort().equals(passwort);
    }

    public void setStandardDatenbank(Datenbank newStandardDatenbank) {
        this.standardDatenbank = newStandardDatenbank;
    }

    Datenbank getStandardDatenbank() {
        return this.standardDatenbank;
    }

    public void loescheUser(String email) {
        this.users.remove(email);
    }
}
