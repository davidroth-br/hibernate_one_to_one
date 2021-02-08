package domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DEPARTMENT_INFO")
public class DepartmentInfo {

    @Id
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "department"))
    @GeneratedValue(generator = "gen")
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "BUDGET")
    private Long budget;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @Column(name = "ADDRESS")
    private String address;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Departments department;

    public DepartmentInfo() {
    }

    public DepartmentInfo(Long budget, Date creationDate, String address, Departments department) {
        this.budget = budget;
        this.creationDate = creationDate;
        this.address = address;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }
}
