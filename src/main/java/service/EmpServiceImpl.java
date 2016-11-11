package service;

import dao.EmpDao;
import dao.EmpDaoImpl;

/**
 * Created by jatingarg on 11/10/16.
 */
public class EmpService {

    private EmpDao empDao;

    int addEmp(String name,int phoneNumber)
    {
        empDao = new EmpDaoImpl();
        return empDao.addEmp(name,phoneNumber);
    }
    boolean deleteemp(int id)
    {
        retun false;
    }

    
}
