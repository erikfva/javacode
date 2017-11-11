/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.controlador;

import db.usuarios.Userlevels;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author evargas
 */
@Stateless
public class UserlevelsFacade extends AbstractFacade<Userlevels> {

    @PersistenceContext(unitName = "usuariosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserlevelsFacade() {
        super(Userlevels.class);
    }
    
}
