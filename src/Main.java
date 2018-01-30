import com.sun.xml.internal.bind.v2.runtime.MimeTypedTransducer;

public class Main {
    public static int quadratzahl(int zahl) {
        return zahl * zahl;
    }

    /* public static void greetings(String name)
     {
          System.out.println("Hallo "+ name + "!");
     }*/
    public static double addieren(double... zahlen) {
        double summe = 0;
        for (int i = 0; i < zahlen.length; i++) {
            summe = summe + zahlen[i];
        }
        return summe; // hat im skript gefehlt
    }

    public static void main(String[] args) {


        AddressBuilder builder = new AddressBuilder();


        Adresse adresse = builder.withHausnummer(5)
                .withPostleitzahl(91757)
                .withWohnort("Treuchtlingen")
                .build();

        User user = new User("hans", "wurscht", "hans@wurscht.com", "wer", 1992,
                new Adresse(43245));

        User user2 = new User("manni", "Mannheim", "mannheim@gmail.com", "asdfadf", 1986);


        Mitarbeiter mittarbeiter1 = new Mitarbeiter("Egon", "Lehner", "egon.lehner@web.de", "passwort", 1965);

        Datenbank datenbank = new Datenbank();
        datenbank.register(user);
        datenbank.register(user2);
        datenbank.register(mittarbeiter1);

        LoginMechanismus hauptTor = new LoginMechanismus(datenbank);

        System.out.println( hauptTor.login(new User("adf","asdfa","asdf@asdf","asd",1985)));



        user.postHinzufügen("hallo du lulli");
        user.postHinzufügen("bin gerade in der Vorlesung");
        //System.out.println(manni.gibeineStatusmeldungAus());
        user.gibAlleStatusMeldungenAus();


        if (user.istVolljährig()) {
            System.out.println("Internet is for porn");
        } else {
            System.out.println("du kommst hier nicht rein");
        }


        //String name = Main.greetings(Stefan);
        //System.out.println(Main.greetings(Stefan));
    }


}