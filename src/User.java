public class User {
    private String vorname;
    private String email;
    private Statusmeldung[] posts;
    private int ersterFreierIndex;
    private int geburtsjahr;

    Adresse newUserAdresse = new Adresse("a", 1, 96757, "adf");

    public User(String vorname, String email, int geburtsjahr, Adresse newUserAdresse) {
        this.vorname = vorname;
        this.email = email;
        this.geburtsjahr = geburtsjahr;
        this.newUserAdresse = newUserAdresse;
        posts = new Statusmeldung[10];
        ersterFreierIndex = 0;
    }

    public User(String vorname, String email, int geburtsjahr) {
        this(vorname, email, geburtsjahr, null);
    }

    //Setter
    public void setVorname(String newVorname) {
        this.vorname = newVorname;

    }

    //Getter
    String getVorname() {
        return this.vorname;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;

    }

    String getEmail() {
        return this.email;
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

    public void setAdresse(Adresse newAdresse) {
        this.newUserAdresse = newAdresse;

    }

    Adresse getAdresse() {
        return this.newUserAdresse;
    }


    public boolean istVolljährig() {
        return 2018 - geburtsjahr >= 18;
    }

    public void postHinzufügen(String text) {
        this.posts[ersterFreierIndex] = new Statusmeldung(text, this);
        ersterFreierIndex++;
    }

    public Statusmeldung getPost(int i) {
        return posts[i];
    }


}
