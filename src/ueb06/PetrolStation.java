package ueb06;

/**
 * created by EESSAMMB on 06.11.2020
 */
public class PetrolStation {


    private String marke;
    private int plz;
    private String ort;
    private double preis;


    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
        if(marke.matches("-?\\d+"))
        {
            System.out.println("Keine gültige Eingabe!");
        }
        else
        {
            System.err.println("Error");
        }
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }






}
