package application;

import application.dao.EmployeeDao;
import application.dao.interfaces.IEmployeeDao;
import application.models.EmployeeModel;
import application.utils.StringUtils;
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
