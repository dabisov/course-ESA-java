package beans;

import entity.Box;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class BoxBean {

    @PersistenceContext(unitName = "esa")
    private EntityManager em;
    public Collection<Box> findAll(){
        return em.createQuery("SELECT c FROM Box c", Box.class).getResultList();
    }
}
