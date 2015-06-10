package ch.hevs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.hevs.businessobject.Department;
import ch.hevs.businessobject.Employee;
import ch.hevs.businessobject.Office;

public class PersistenceTest {

	@Test
	public void test() {
		EntityTransaction tx = null;
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankPU");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Department d1 = new Department("Compta");
			Department d2 = new Department("Admin");
			Department d3 = new Department("Dev");
			
			Office o1 = new Office("Bureau nord", 1);
			Office o2 = new Office("Bureau sud", 2);
			Office o3 = new Office("Bureau principale", 3);
			Office o4 = new Office("Bureau principale", 4);
			
			d1.getOffices().add(o1);
			d1.getOffices().add(o2);
			d2.getOffices().add(o3);
			d3.getOffices().add(o2);
			
			Employee e1 = new Employee("Dany", "Maillard");
			Employee e2 = new Employee("Vincent", "Huck");
			Employee e3 = new Employee("Siméon", "Bobylev");
			Employee e4 = new Employee("Sherlock", "Holmes");
			Employee e5 = new Employee("Hercule", "Poireau");
			
			o1.getEmployees().add(e1);
			o2.getEmployees().add(e2);
			o3.getEmployees().add(e3);
			o4.getEmployees().add(e4);
			o4.getEmployees().add(e5);
			
			em.persist(d1);
			em.persist(d2);
			em.persist(d3);
			
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
