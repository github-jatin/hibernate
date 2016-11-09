package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Employee;
import utils.HibUtils;

/**
 * Created by jatingarg on 11/8/16.
 */
public class EmpDaoImpl implements  EmpDao {


    private SessionFactory factory;

    public EmpDaoImpl()
    {
        factory= HibUtils.getSessionFactory();
    }

    public int addEmp(String name, int phoneNumber) {

        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Employee emp=new Employee(name,phoneNumber);
        session.persist(emp);
        System.out.println("Id before is"+emp.getId());
        session.flush();
        System.out.println("Id after is"+emp.getId());
        tx.commit();
        session.close();
        return emp.getId();
    }

    public boolean deleteemp(int id) {
        return false;
    }
}
