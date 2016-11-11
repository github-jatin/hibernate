package pojos;

import javax.persistence.*;

/**
 * Created by jatingarg on 11/9/16.
 */
@Entity
public class Address {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private int houseNumber;
    @ManyToOne()
    @JoinColumn(name="emp_id")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name="cmp_id")
    private Company company;


    public Address() {
    }

    public Address(String street, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;

    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
