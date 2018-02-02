public class LogFileException extends Exception{

    private String pfad;
    public  LogFileException (String text, String pfad){
        super(text);

        this.pfad = pfad;
    }
    public String getPfad(){
        return this.pfad;

    }
    public String toString(){
        return this.pfad + ""+super.getMessage();
    }
}
