/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import javax.ejb.EJB;
import model.UsuariosFacade;
import entities.*;

/**
 *
 * @author cristiandulcey
 */
@ManagedBean
@SessionScoped
public class UsuarioController {
    @EJB
    private UsuariosFacade usuariosFacade;
    private Usuarios U=new Usuarios();

    public Usuarios getU() {
        return U;
    }

    public void setU(Usuarios U) {
        this.U = U;
    }
    
   
    public UsuarioController() {
    }
    
    public List<Usuarios> findAll(){
        return this.usuariosFacade.findAll();
    }
    public String add(){
       this.usuariosFacade.create(this.U);
       this.U =new Usuarios();
       return "index";
   }
    public void delete(Usuarios U){
        this.usuariosFacade.remove(U);
    }
    public String edit(Usuarios U){
        this.U=U;
        return "editar";
    } 
    public String edit(){
        this.usuariosFacade.edit(this.U);
        return "index";
    } 
    
}
