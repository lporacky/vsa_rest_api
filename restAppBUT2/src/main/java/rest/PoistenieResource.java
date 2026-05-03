/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edu
 */
@Singleton
@Path("poistenie")
public class PoistenieResource {
    private List<Poistenie> poistenia;
    
    public PoistenieResource() {
        Osoba m1 = new Osoba();
        m1.setMeno("Hrasko");
        m1.setBydlisko("Hlavna 22");
        m1.setRc(2001);
        
        Poistenie p1 = new Poistenie();
        
        p1.setIdZmluvy("Z123");
        p1.setPoistnaSuma(199.0);
        p1.setMajitel(m1);
        
        List<Osoba> pci = new ArrayList<>();
        
        p1.setPoistenci(pci);
        
        poistenia = new ArrayList<>();
        poistenia.add(p1);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void vlozPoistenie(Poistenie p) {
        List<Osoba> nikto = new ArrayList<>();
        Poistenie pos = new Poistenie();
        pos.setIdZmluvy(p.getIdZmluvy());
        pos.setMajitel(p.getMajitel());
        pos.setPoistnaSuma(p.getPoistnaSuma());
        pos.setPocetPoistencov(0);
        pos.setPoistenci(nikto);
        poistenia.add(pos);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Poistenie getPoistenie(@PathParam("id") String idZ) {
        for(Poistenie p : poistenia) {
            if(p.getIdZmluvy().equals(idZ)) {
                return p;
            }
        }
        return null;
    }
    
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String vlozOsobu(@PathParam("id") String idZ, Osoba osoba) {
        for(Poistenie p : poistenia) {
            if(p.getIdZmluvy().equals(idZ)) {
                p.addPoistenec(osoba);
                return String.valueOf(p.getPocetPoistencov());
                
            }
        }
        return null;
    }
    
    
    
    @GET
    @Path("{id}/{no}")
    @Produces(MediaType.APPLICATION_XML)
    public Osoba vratOsobu(@PathParam("id") String idZ, @PathParam("no") int poradie) {
        for(Poistenie p : poistenia) {
            if(p.getIdZmluvy().equals(idZ)) {
                if(poradie < 1 || poradie > p.getPocetPoistencov()) {
                    return null;
                }
                
                return p.getPoistenci().get(poradie-1);                
             
            }
        }
        return null;
    }
    
    
    
    @DELETE
    @Path("{id}/{no}")
    public void odstranOsobu(@PathParam("id") String idZ, @PathParam("no") int poradie) {
        for(Poistenie p : poistenia) {
            if(p.getIdZmluvy().equals(idZ)) {
                if(poradie < 1 || poradie > p.getPocetPoistencov()) {
                    return;
                }
                p.removePoistenec(poradie-1);
                return;
            }
        }
    }
}
