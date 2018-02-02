import com.sun.xml.internal.bind.v2.runtime.MimeTypedTransducer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        AddressBuilder builder = new AddressBuilder();

        Datenbank datenbank = new Datenbank();
        UserSpeicher speicher1= new UserSpeicher(datenbank);

        Adresse adresse = builder.withHausnummer(5)
                .withPostleitzahl(91757)
                .withWohnort("Treuchtlingen")
                .build();

        User user = new User("hans", "wurscht", "hans@wurscht.com", "wer", 1992,
                new Adresse(43245));

        User user2 = new User("manni", "Mannheim", "mannheim@gmail.com", "asdfadf", 1986);

/*
        Mitarbeiter mittarbeiter1 = new Mitarbeiter("Egon", "Lehner", "egon.lehner@web.de", "passwort", 1965);
        mittarbeiter1.setEmail("adfasdf@awesomecompany.com"); //ich kann trotzdem in den konstruktor ne falsche email übergeben
        System.out.println(mittarbeiter1.getEmail());



        datenbank.register(user);
        datenbank.register(user2);
        datenbank.register(mittarbeiter1);

        LoginMechanismus hauptTor = new LoginMechanismus(datenbank);

        user2.postHinzufügen("hallo du lulli");
        user2.postHinzufügen("bin gerade in der Vorlesung");
        user2.postHinzufügen("Habe hemoriden!!!!!!");
        user2.postHinzufügen("man das tut weh");
        user2.postHinzufügen("sollte villeicht einen Arzt aufsuchen und nicht den Schmarn im sozialen Netzwerk posten");
        List<Statusmeldung> gefiltertePosts = user2.filtereNachZeichenZahl(20);
        for (int i = 0; i < gefiltertePosts.size(); i++) {
            System.out.println(gefiltertePosts.get(i).getText());
        }
*/
        // Ich brauch ne Liste an Nutzern!!!!!
       speicher1.saveUser(user);
       speicher1.saveUser(user2);



        //System.out.println(user2.gibeineStatusmeldungAus());
       /* user2.gibAlleStatusMeldungenAus();
        System.out.println(datenbank.istNutzervorhanden(mittarbeiter1.getEmail(), mittarbeiter1.getPasswort()));
        System.out.println(datenbank.istNutzervorhanden(mittarbeiter1.getEmail(), "aaaa"));

        */

/*
        l = user2;
        l.loesche(datenbank);
        l = mittarbeiter1;
        l.loesche(datenbank);
        System.out.println(datenbank.istNutzervorhanden(mittarbeiter1.getEmail(), mittarbeiter1.getPasswort()));
*/
//"G:\6_Datein\Unterlagen2018\Programmieren\NeuerUser.csv"
/*
        if (user.istVolljährig()) {
            System.out.println("Internet is for porn");
        } else {
            System.out.println("du kommst hier nicht rein");
        }
*/

    }


}