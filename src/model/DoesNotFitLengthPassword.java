package model;

public class DoesNotFitLengthPassword extends IndexOutOfBoundsException {


    public DoesNotFitLengthPassword(String passwort) {
        super("Keine zulässige Passwortlänge" +
                "erhalten: " + passwort +
                "mindestlänge für Passwort" + 8);
    }


}
