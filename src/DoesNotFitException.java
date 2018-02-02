public class DoesNotFitException extends IndexOutOfBoundsException {
    public DoesNotFitException(int unter, int ober, int eingegeben) {
        super("Kein zulässiger Wert!" +
                "Erhalten: " + eingegeben +
                "Mindestwert: " + unter +
                "Maximalwert: " + ober);
    }
}
