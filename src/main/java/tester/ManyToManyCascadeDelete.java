package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Company;
import pojos.Employee;
import utils.HibUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jatingarg on 11/9/16.
 */
public class ManyToManyCascadeDelete {

    public static void main(String args[])
    {
        SessionFactory factory= HibUtils.getSessionFactory();
        Session session=factory.openSession();
        Company company=session.get(Company.class,1);

        /*Set<Employee> employeeSet=company.getEmployeeSet();

        System.out.println("Employee set of company  is"+employeeSet);

        for (Employee emp :
                employeeSet) {
            System.out.println("Address set of employee----------->"+emp+"  is ........."+emp.getAddressSet());

        }
*/


        Transaction tx=session.beginTransaction();
        //company.getAddressSet().clear();
        session.remove(company);
        tx.commit();
        session.close();
    }
}
