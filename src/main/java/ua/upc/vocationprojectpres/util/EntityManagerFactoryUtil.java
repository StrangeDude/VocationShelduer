package ua.upc.vocationprojectpres.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {

    private static EntityManager entityManager;

    private EntityManagerFactoryUtil() {}

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            try {
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
                entityManager = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return entityManager;
    }
}
