package pojos;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jatingarg on 11/9/16.
 */

@Entity
public class Company {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private  int companyId;

    private String name;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private Set<Address> addressSet;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinTable(name = "Company_Emp",joinColumns = {
            @JoinColumn(name = "company_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "employee_id",
                    nullable = false, updatable = false) })
    private Set<Employee> employeeSet;


    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                '}';
    }
}
