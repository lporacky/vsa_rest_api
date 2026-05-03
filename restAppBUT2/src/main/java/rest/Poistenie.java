/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 *
 * @author edu
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Poistenie {
    private String idZmluvy;
    
    private Osoba majitel;
    
    private Double poistnaSuma;
    
    private int pocetPoistencov;
    
    @XmlTransient
    private List<Osoba> poistenci;

    public void setIdZmluvy(String idZmluvy) {
        this.idZmluvy = idZmluvy;
    }

    public void setMajitel(Osoba majitel) {
        this.majitel = majitel;
    }

    public void setPoistnaSuma(Double poistnaSuma) {
        this.poistnaSuma = poistnaSuma;
    }

    public void setPocetPoistencov(int pocetPoistencov) {
        this.pocetPoistencov = pocetPoistencov;
    }

    public void setPoistenci(List<Osoba> poistenci) {
        this.poistenci = poistenci;
        this.pocetPoistencov = poistenci.size();
    }

    public String getIdZmluvy() {
        return idZmluvy;
    }

    public Osoba getMajitel() {
        return majitel;
    }

    public Double getPoistnaSuma() {
        return poistnaSuma;
    }

    public int getPocetPoistencov() {
        return pocetPoistencov;
    }

    public List<Osoba> getPoistenci() {
        return poistenci;
    }
    
    public void addPoistenec(Osoba o) {
        this.poistenci.add(o);
        this.pocetPoistencov += 1;
    }
    
    public void removePoistenec(int n) {
        this.poistenci.remove(n);
        this.pocetPoistencov -= 1;
    }
}
