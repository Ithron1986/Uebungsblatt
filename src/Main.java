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

        int zahl = Main.quadratzahl(5);
        System.out.println(zahl);
        System.out.println(Main.quadratzahl(10));
        System.out.println(quadratzahl(3));
        System.out.println(Main.addieren(1));
        User manni = new User("Manni", "manni@hochschule-trier.de", 1986);
        Statusmeldung ersterPost = new Statusmeldung("ihr könnt mir garnichts", manni);

        manni.postHinzufügen("hallo du lulli");
        //System.out.println(manni.gibeineStatusmeldungAus());
        System.out.println(manni.getPost(0).getText());


        if (manni.istVolljährig()) {
            System.out.println("Internet is for porn");
        } else {
            System.out.println("du kommst hier nicht rein");
        }


        //String name = Main.greetings(Stefan);
        //System.out.println(Main.greetings(Stefan));
    }


}