package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Address;
import pojos.Employee;
import utils.HibUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jatingarg on 11/9/16.
 */
public class OneToManyTesterForCascadingSave {

    public static void main(String args[])
    {
        /*SessionFactory factory= HibUtils.getSessionFactory();
        Session session=factory.openSession();
        Set<Address> addressSet =new HashSet<Address>();
        Address address1= new Address("Paliva Vihar",198);
        Address address2= new Address("Sector 40",3485);
        Employee employee= new Employee();
        employee.setName("Jatin");
        employee.setPhoneNumber(9013);
        addressSet.add(address1);
        addressSet.add(address2);
        employee.setAddressSet(addressSet);

        Transaction tx= session.beginTransaction();
        session.persist(employee);
        //Here in this code we have not set employee in address1,address2 and hence though
        //cascade operation takes place and addresses are stored in address table but empid is null
        tx.commit();
        session.close();*/


        //Here we will set the employee in address1 and address2 and empid will be saved in address table
        SessionFactory factory= HibUtils.getSessionFactory();
        Session session=factory.openSession();
        Set<Address> addressSet =new HashSet<Address>();
        Address address1= new Address("Paliva Vihar",198);
        Address address2= new Address("Sector 40",3485);
        Employee employee= new Employee();
        employee.setName("Jatin");
        employee.setPhoneNumber(9013);
        addressSet.add(address1);
        addressSet.add(address2);
        address1.setEmployee(employee);
        address2.setEmployee(employee);
        employee.setAddressSet(addressSet);

        Transaction tx= session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();


    }
}
