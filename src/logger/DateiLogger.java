package logger;

import logger.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DateiLogger implements Logger {
    private String pfad;

    public DateiLogger(String pfad) throws LogFileException {
        if (!Files.isDirectory(Paths.get(pfad)))
        throw new LogFileException("Angegebener Pfad zeigt auf einen Ordner", pfad);
        if (!Files.isWritable((Paths.get(pfad).getParent())))
        throw new LogFileException("Datei darf nicht geschrieben werden.", pfad);


        this.pfad = pfad;
    }


    @Override
    public void info(String text) {

    }

    @Override
    public void warnung(String text) {

    }

    @Override
    public void fehler(String text) {

    }
}
