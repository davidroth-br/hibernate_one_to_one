package college;

import domain.DepartmentInfo;
import domain.Departments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Departments dept = new Departments();
        dept.setDepartmentName("Mail Room");
        dept.setLocationId(2700);

        DepartmentInfo deptInfo = new DepartmentInfo();
        deptInfo.setBudget(2000L);
        deptInfo.setCreationDate(new Date());
        deptInfo.setAddress("Over there");

        dept.setDepartmentInfo(deptInfo);
        deptInfo.setDepartment(dept);

        session.save(dept);

        session.getTransaction().commit();
        session.close();
    }
}

