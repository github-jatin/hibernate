package tester;

import dao.EmpDao;
import dao.EmpDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Employee;
import utils.HibUtils;

/**
 * Hello world!
 *
 */
public class SaveAndPersist
{
    public static void main( String[] args )
    {
       /* System.out.println( "Hello World!" );
        EmpDao dao =new EmpDaoImpl();
        int id=dao.addEmp("Jatin",1234);*/

        SessionFactory  factory= HibUtils.getSessionFactory();
        Session session=factory.openSession();

       Employee emp = session.get(Employee.class,1);
        System.out.println("Employee is "+emp);
        session.close();// Now emp is in detached state
        session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.persist(emp);//Here hibernate will throw javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist: pojos.Employee
        //session.save(emp);   There will be no error for this and will insert a new row in the column
        tx.commit();
        session.close();



    }
}
