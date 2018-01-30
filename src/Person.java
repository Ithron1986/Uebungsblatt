public class Person {

    private String vorname;
    private String nachname;
    private String email;
    private int geburtsjahr;
    private String passwort;

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
        this.passwort = passwort;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGeburtsjahr(int newGeburtsjahr) {
        if (geburtsjahr > 1900 && geburtsjahr < 2018) {
            this.geburtsjahr = newGeburtsjahr;
        } else

        {
            System.out.println("Angegebenes Geburtsjahr nicht valide");
        }

    }

    int getGeburtsjahr() {
        return this.geburtsjahr;
    }

    public boolean istVolljährig() {
        return 2018 - geburtsjahr >= 18;
    }

}
