package model;
import java.util.*;

public class Mariage {
    private Date dateMariage;
    private Homme epoux;
    private Femme epouse;
    public Mariage(Homme epoux, Femme epouse, Date dateMariage) {
        this.epoux = epoux;
        this.epouse = epouse;
        this.dateMariage = dateMariage;
    }
    public Date getDateMariage() {
        return this.dateMariage;
    }
    public Homme getEpoux() {
        return this.epoux;
    }
    public Femme getEpouse() {
        return this.epouse;
    }
}