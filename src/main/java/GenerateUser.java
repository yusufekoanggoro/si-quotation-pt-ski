package main.java;

import main.java.dao.EmployeeDao;
import main.java.dao.interfaces.IEmployeeDao;
import main.java.models.EmployeeModel;
import main.java.utils.StringUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GenerateUser {
    List<EmployeeModel> employees = new ArrayList<>();
    private final IEmployeeDao employeeDao = new EmployeeDao();
    
    public GenerateUser(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
        
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.YEAR, 2001 );
        cal.set( Calendar.MONTH, Calendar.FEBRUARY );
        cal.set( Calendar.DATE, 24 );

        java.sql.Date dateOfBirth = new java.sql.Date(cal.getTimeInMillis());
        
        EmployeeModel employee1 = new EmployeeModel();
        employee1.setName("Athalarik");
        employee1.setGender("Laki-laki");
        employee1.setPlaceOfBirth("Jakarta");
        employee1.setPhoneNumber("087884890913");
        employee1.setDateOfBirth(dateOfBirth);
        employee1.setCreatedAt(dateNow);
        employee1.setUpdatedAt(dateNow);
        employee1.setAddress("Jalan-jalan");
        employee1.setReligion("Islam");
        employee1.setJoinDate(dateNow);
        employee1.setStatus("Kawin");
        employee1.setRoleId(1);
        this.employees.add(employee1); 
        
        EmployeeModel employee2 = new EmployeeModel();
        employee2.setName("Pandu");
        employee2.setGender("Laki-laki");
        employee2.setPlaceOfBirth("Jakarta");
        employee2.setPhoneNumber("087884890913");
        employee2.setDateOfBirth(dateOfBirth);
        employee2.setCreatedAt(dateNow);
        employee2.setUpdatedAt(dateNow);
        employee2.setAddress("Jalan-jalan");
        employee2.setReligion("Islam");
        employee2.setJoinDate(dateNow);
        employee2.setStatus("Kawin");
        employee2.setRoleId(1);
        this.employees.add(employee2);

        EmployeeModel employee3 = new EmployeeModel();
        employee3.setName("Yusuf");
        employee3.setGender("Laki-laki");
        employee3.setPlaceOfBirth("Jakarta");
        employee3.setPhoneNumber("087884890913");
        employee3.setDateOfBirth(dateOfBirth);
        employee3.setCreatedAt(dateNow);
        employee3.setUpdatedAt(dateNow);
        employee3.setAddress("Jalan-jalan");
        employee3.setReligion("Islam");
        employee3.setJoinDate(dateNow);
        employee3.setStatus("Kawin");
        employee3.setRoleId(1);
        this.employees.add(employee3);

        EmployeeModel employee4 = new EmployeeModel();
        employee4.setName("Dias");
        employee4.setGender("Laki-laki");
        employee4.setPlaceOfBirth("Jakarta");
        employee4.setPhoneNumber("087884890913");
        employee4.setDateOfBirth(dateOfBirth);
        employee4.setCreatedAt(dateNow);
        employee4.setUpdatedAt(dateNow);
        employee4.setAddress("Jalan-jalan");
        employee4.setReligion("Islam");
        employee4.setJoinDate(dateNow);
        employee4.setStatus("Kawin");
        employee4.setRoleId(1);
        this.employees.add(employee4);


        EmployeeModel employee5 = new EmployeeModel();
        employee5.setName("Ilham");
        employee5.setGender("Laki-laki");
        employee5.setPlaceOfBirth("Jakarta");
        employee5.setPhoneNumber("087884890913");
        employee5.setDateOfBirth(dateOfBirth);
        employee5.setCreatedAt(dateNow);
        employee5.setUpdatedAt(dateNow);
        employee5.setAddress("Jalan-jalan");
        employee5.setReligion("Islam");
        employee5.setJoinDate(dateNow);
        employee5.setStatus("Kawin");
        employee5.setRoleId(3);
        this.employees.add(employee5);

        EmployeeModel employee6 = new EmployeeModel();
        employee6.setName("Fauziah");
        employee6.setGender("Perempuan");
        employee6.setPlaceOfBirth("Jakarta");
        employee6.setPhoneNumber("087884890913");
        employee6.setDateOfBirth(dateOfBirth);
        employee6.setCreatedAt(dateNow);
        employee6.setUpdatedAt(dateNow);
        employee6.setAddress("Jalan-jalan");
        employee6.setReligion("Islam");
        employee6.setJoinDate(dateNow);
        employee6.setStatus("Kawin");
        employee6.setRoleId(3);
        this.employees.add(employee6);

        EmployeeModel employee7 = new EmployeeModel();
        employee7.setName("Nur Cantika");
        employee7.setGender("Perempuan");
        employee7.setPlaceOfBirth("Jakarta");
        employee7.setPhoneNumber("087884890913");
        employee7.setDateOfBirth(dateOfBirth);
        employee7.setCreatedAt(dateNow);
        employee7.setUpdatedAt(dateNow);
        employee7.setAddress("Jalan-jalan");
        employee7.setReligion("Islam");
        employee7.setJoinDate(dateNow);
        employee7.setStatus("Kawin");
        employee7.setRoleId(2);
        this.employees.add(employee7);

        EmployeeModel employee8 = new EmployeeModel();
        employee8.setName("Jimmi");
        employee8.setGender("Laki-laki");
        employee8.setPlaceOfBirth("Jakarta");
        employee8.setPhoneNumber("087884890913");
        employee8.setDateOfBirth(dateOfBirth);
        employee8.setCreatedAt(dateNow);
        employee8.setUpdatedAt(dateNow);
        employee8.setAddress("Jalan-jalan");
        employee8.setReligion("Islam");
        employee8.setJoinDate(dateNow);
        employee8.setStatus("Kawin");
        employee8.setRoleId(2);
        this.employees.add(employee8);
    }
    
    public void start(){
        int index = 1;
        String roleName = null;
        for (EmployeeModel employee : this.employees) {
            if(employee.getRoleId() == 1){
                roleName = "salessupport";
            }
            String username = StringUtils.getInitialsFullName(employee.getName()).toLowerCase() + index++  + "-" + roleName;
            employee.setUsername(username);
            employee.setPassword(Password.getSecurePassword(username));
            this.employeeDao.upsert(employee);
        }
        System.out.println("Success Generate User");
        this.employeeDao.closeConnection();
    }
}
