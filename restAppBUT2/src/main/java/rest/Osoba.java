/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edu
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Osoba {
    private String meno;
    
    private int rc;
    
    private String bydlisko;

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public void setBydlisko(String bydlisko) {
        this.bydlisko = bydlisko;
    }

    public String getMeno() {
        return meno;
    }

    public int getRc() {
        return rc;
    }

    public String getBydlisko() {
        return bydlisko;
    }
    
    
}
