package pojos;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jatingarg on 11/8/16.
 */

@Entity
public class Employee {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int phoneNumber;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Address> addressSet;


    public Employee() {

    }

    public Employee(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }
}
