package service;

import dao.EmpDao;
import dao.EmpDaoImpl;

/**
 * Created by jatingarg on 11/10/16.
 */
public class EmpServiceImpl implements EmpService {

    private EmpDao empDao;

    public int addEmp(String name,int phoneNumber)
    {
        empDao = new EmpDaoImpl();
        return empDao.addEmp(name,phoneNumber);
    }
   public  boolean deleteemp(int id)
    {
        return false;
    }


}
