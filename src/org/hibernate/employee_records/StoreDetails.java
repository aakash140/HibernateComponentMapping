package org.hibernate.employee_records;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author aakash.gupta
 *
 */
public class StoreDetails {

	public void storeDetails(Session session) {
		Transaction transaction=session.beginTransaction();
		
		Address address1=new Address();
		address1.setState("Punjab");
		address1.setCity("Chandigarh");
		address1.setPinCode(110051);
		
		Address address2=new Address();
		address2.setState("Punjab");
		address2.setCity("Jalandhar");
		address2.setPinCode(110092);
		
		Employee employee1=new Employee();
		employee1.setEmp_id(1234);
		employee1.setName("Aakash");
		employee1.setDepartment("HR");
		employee1.setAddress(address1);
		
		Employee employee2=new Employee();
		employee2.setEmp_id(4321);
		employee2.setName("Vikas");
		employee2.setDepartment("IT");
		employee2.setAddress(address2);
		
		session.persist(employee1);
		session.persist(employee2);
		transaction.commit();
		System.out.println("Data has been saved");
	}
	
	public void updateDetails(Session session,Integer id){
		Transaction transaction=session.beginTransaction();
		Employee employee=(Employee)session.get(Employee.class, id);
		employee.setDepartment("Admin");
		transaction.commit();
		session.save(employee);
		System.out.println("Data has been updated");
	}
	
	public void deleteDetails(Session session,Integer id){
		Transaction transaction=session.beginTransaction();
		Employee employee=(Employee)session.get(Employee.class, id);
		session.delete(employee);
		transaction.commit();
		System.out.println("Data has been deleted");
	}
}