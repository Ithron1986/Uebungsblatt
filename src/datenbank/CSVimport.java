package datenbank;

import model.Person;

public class CSVimport {
    UserSpeicher userSpeicher = new UserSpeicher();
    Datenbank datenbank = new Datenbank(userSpeicher);
    Person user;
    Person mitarbeiter;


}
