package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Employee;
import utils.HibUtils;

/**
 * Created by jatingarg on 11/9/16.
 */
public class OneToManyTesterForCascadeDelete {

    public static void main(String args[])
    {
        SessionFactory factory= HibUtils.getSessionFactory();
        Session session=factory.openSession();
        Employee emp=session.get(Employee.class,1);

        System.out.println("Size is "+emp.getAddressSet().size());
        Transaction tx=session.beginTransaction();
        session.remove(emp);
        tx.commit();
        session.close();


    }

}
