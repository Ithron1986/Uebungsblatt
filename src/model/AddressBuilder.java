package model;

public class AddressBuilder {

    int postleitzahl;
    String wohnort;
    int hausnummer;
    String straße;


    public AddressBuilder withStraße(String straße) {
        this.straße = straße;
        return this;
    }

    public AddressBuilder withWohnort(String wohnort) {
        this.wohnort = wohnort;
        return this;
    }

    public AddressBuilder withHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
        return this;
    }

    public AddressBuilder withPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
        return this;
    }

    public Adresse build() {

        Adresse addresse = new Adresse();
        addresse.setHausnummer(this.hausnummer);
        addresse.setPostleitzahl(this.postleitzahl);
        addresse.setStraße(this.straße);
        addresse.setWohnort(this.wohnort);
        return addresse;

    }
}
