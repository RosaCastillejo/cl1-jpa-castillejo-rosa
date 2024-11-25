package pe.edu.i202120378.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202120378.Main;
import pe.edu.i202120378.entity.Country;

public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "RAM");

        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

    }
}
