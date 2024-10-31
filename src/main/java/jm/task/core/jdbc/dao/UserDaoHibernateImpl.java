package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transact = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "lastName VARCHAR(100) NOT NULL," +
                    "age INT" +
                    ")").executeUpdate();
            transact.commit();
            System.out.println("Created users table");
        } catch (HibernateException e) {
            System.out.println("Ошибка при создании таблицы User: " + e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transact = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transact.commit();
            System.out.println("Dropped users table");
        } catch (HibernateException e) {
            System.out.println("Ошибка при удалении таблицы User: " + e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transact = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transact.commit();
            System.out.println("User saved");
        } catch (HibernateException e) {
            System.out.println("Ошибка при сохранении пользователя: " + e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transact = session.beginTransaction();
            User user = (User) session.load(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            transact.commit();
            System.out.println("User removed");

        } catch (HibernateException e) {
            System.out.println("Ошибка при удалении пользователя: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transact = session.beginTransaction();
            System.out.println("getAllUsers");
            users = session.createQuery("from User", User.class).list();
            transact.commit();
        } catch (HibernateException e) {
            System.out.println("Ошибка при получении всех пользователей: " + e.getMessage());
        }
        users.forEach(System.out::println);
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transact = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            transact.commit();
            System.out.println("Cleaned users table");

        } catch (HibernateException e) {
            System.out.println("Ошибка при очистке таблицы User: " + e.getMessage());
        }
    }
}
