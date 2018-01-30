import java.util.HashMap;
import java.util.Map;

public class Datenbank {
    Map<String, Person> users;

    public Datenbank() {
        this.users = new HashMap<>();
    }

    public void register(Person person) {
        if (this.users.containsKey(person.getEmail())) {
            throw new RuntimeException("Email bereits belegt");
        }
        this.users.put(person.getEmail(), person);
    }

    public boolean istNutzervorhanden(String email, String passwort) {
        Person person = this.users.get(email);
        return person != null && person.getPasswort().equals(passwort);
    }

}
