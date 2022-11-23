package utils;

import org.hibernate.SessionFactory;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

                if (sessionFactory == null) {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Customer.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
    }
        return sessionFactory;

}
