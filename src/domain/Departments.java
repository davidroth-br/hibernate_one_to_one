package domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENTS")
public class Departments {

    @Id
    @GenericGenerator(name="dep_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "departments_seq", value = "SEQUENCE")}
    )
    @GeneratedValue(generator = "departments_seq")
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Column(name = "LOCATION_ID")
    private Integer locationId;

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private DepartmentInfo departmentInfo;

    public Departments() {
    }

    public Departments(String departmentName, Integer managerId, Integer locationId) {
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public DepartmentInfo getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(DepartmentInfo departmentInfo) {
        this.departmentInfo = departmentInfo;
    }
}
