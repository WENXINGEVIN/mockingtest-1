package app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webbertech.web.model.Contact;

public class ContactHibernateTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact user = new Contact();
		user.setId("1");
		user.setFirstname("Xin");
		user.setLastname("Li");
		user.setEmail("xinl@wolfram.com");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
