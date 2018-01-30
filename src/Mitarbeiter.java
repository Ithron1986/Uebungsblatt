public class Mitarbeiter extends Person {


    private String wohnort;

    private String aufgabenBereich;
    private double gehalt;

    public Mitarbeiter(String vorname, String nachname, String email, String passwort, int geburtsjahr) {
        super(vorname, nachname, email, passwort, geburtsjahr);
    }


    public void setWohnort(String newWohnort) {
        this.wohnort = newWohnort;
    }

    String getWohnort() {
        return this.wohnort;
    }


}
