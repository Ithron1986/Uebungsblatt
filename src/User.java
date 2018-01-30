import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    List<Statusmeldung> posts;

    Adresse newUserAdresse;

    public User(String vorname, String nachname, String email, String passwort, int geburtsjahr, Adresse newUserAdresse) {
        super(vorname, nachname, email, passwort, geburtsjahr);
        this.newUserAdresse = newUserAdresse;
        this.posts = new ArrayList<Statusmeldung>();

    }

    public User(String vorname, String nachname, String email, String passwort, int geburtsjahr) {
        this(vorname, nachname, email, passwort, geburtsjahr, null);
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

}
