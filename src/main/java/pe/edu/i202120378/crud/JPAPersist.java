package pe.edu.i202120378.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202120378.entity.City;
import pe.edu.i202120378.entity.Country;
import pe.edu.i202120378.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = new Country(
                "RAM", "MARAVILLAS", "Asia", "Asia", 100000.0, 1520,
                5236014, 85.00, 200.00, 23568.0, "Maravillito",
                "Republica", "Alicia", 5, "DG", null, null);

        // crear las ciudades
        City c1 = new City("Bosques Iluminados", "Los iluminados", 1000000, country);
        City c2 = new City("Valle de los Espejismos", "Los espejos", 1300000, country);
        City c3 = new City("Montañas Flotantes", "las montañas", 550000, country);

        // agregar ciudades al país
        country.setCity(Arrays.asList(c1, c2, c3));

        // crear los lenguajes
        CountryLanguage l1 = new CountryLanguage("Ingles", "F", 95.00, country);
        CountryLanguage l2 = new CountryLanguage("Español", "T", 5.00, country);

        // agregar lenguajes al país
        country.setCountryLanguages(Arrays.asList(l1, l2));
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        System.out.println("Datos persistidos correctamente");
    }
}

