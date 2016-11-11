package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Address;
import pojos.Company;
import pojos.Employee;
import utils.HibUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jatingarg on 11/9/16.
 */
public class ManyToManyCascadeSave {

    public static void main(String args[])
    {
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


        Set<Address> addressSetSujaat =new HashSet<Address>();
        Address addressu1= new Address("Pune",9999);
        Address addressu2= new Address("Nagpur",8888);
        Employee employeeSujatt= new Employee();
        employeeSujatt.setName("Sujaat");
        employeeSujatt.setPhoneNumber(4013);
        addressSetSujaat.add(addressu1);
        addressSetSujaat.add(addressu2);
        addressu1.setEmployee(employeeSujatt);
        addressu2.setEmployee(employeeSujatt);
        employeeSujatt.setAddressSet(addressSetSujaat);



        Set<Address> addressSetParv =new HashSet<Address>();
        Address addressParv= new Address("Delhi",1111);
        Address addressParv2= new Address("Ambala",2222);
        Employee employeeParv= new Employee();
        employeeParv.setName("Parv");
        employeeParv.setPhoneNumber(6666);
        addressSetParv.add(addressParv);
        addressSetParv.add(addressParv2);
        addressParv.setEmployee(employeeParv);
        addressParv2.setEmployee(employeeParv);
        employeeParv.setAddressSet(addressSetParv);


        Company cybage = new Company();
        cybage.setName("Cybage");

        Company jaitra = new Company();
        jaitra.setName("Jaitra");

        Address jaitraAddress=new Address("Bangalore",911014);
        jaitraAddress.setCompany(jaitra);
        Set<Address>jaitraAddressSet=new HashSet<Address>();
        jaitraAddressSet.add(jaitraAddress);
        jaitra.setAddressSet(jaitraAddressSet);


        Address cybageAddressPune=new Address("Pune",411014);
        cybageAddressPune.setCompany(cybage);
        Address cybageAddressHyd=new Address("Hyderabad",211016);
        cybageAddressHyd.setCompany(cybage);
        Set<Address>cybageAddressSet=new HashSet<Address>();
        cybageAddressSet.add(cybageAddressHyd);
        cybageAddressSet.add(cybageAddressPune);
        cybage.setAddressSet(cybageAddressSet);

        Set<Employee>cybageEmployeeSet=new HashSet<Employee>();
        cybageEmployeeSet.add(employee);
        cybageEmployeeSet.add(employeeSujatt);
        cybage.setEmployeeSet(cybageEmployeeSet);

        Set<Company>jatinCompanies=new HashSet<Company>();
        jatinCompanies.add(cybage);
        jatinCompanies.add(jaitra);

        Set<Company>sujaatCompanies=new HashSet<Company>();
        sujaatCompanies.add(cybage);
        //sujaatCompanies.add(jaitra);

        employee.setCompanySet(jatinCompanies);
        employeeSujatt.setCompanySet(sujaatCompanies);

        Set<Employee>jaitraEmployeeSet=new HashSet<Employee>();
        jaitraEmployeeSet.add(employeeSujatt);
        jaitra.setEmployeeSet(jaitraEmployeeSet);


        Transaction tx =session.beginTransaction();
        session.persist(cybage);
        session.persist(jaitra);
        tx.commit();
        session.close();





    }
}
