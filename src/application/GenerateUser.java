package application;

import application.dao.EmployeeDao;
import application.dao.interfaces.IEmployeeDao;
import application.models.EmployeeModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GenerateUser {
    List<EmployeeModel> employees = new ArrayList<>();
    private final IEmployeeDao<EmployeeModel> employeeDao;
    
    public GenerateUser(){
        this.employeeDao = new EmployeeDao();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date dateNow = new java.sql.Date(utilDate.getTime());
        
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.YEAR, 2001 );
        cal.set( Calendar.MONTH, Calendar.FEBRUARY );
        cal.set( Calendar.DATE, 24 );

        java.sql.Date dateOfBirth = new java.sql.Date(cal.getTimeInMillis());
        
        EmployeeModel employee = new EmployeeModel();
        employee.setName("Yusuf Eko Anggoro");
        employee.setGender("Laki-laki");
        employee.setPlaceOfBirth("Jakarta");
        employee.setPhoneNumber("08121857486");
        employee.setDateOfBirth(dateOfBirth);
        employee.setCreatedAt(dateNow);
        employee.setUpdatedAt(dateNow);
        employee.setAddress("Jalan-jalan");
        employee.setReligion("Islam");
        employee.setJoinDate(dateNow);
        employee.setStatus("Kawin");
        employee.setRoleId(1);
        employees.add(employee);
        
        EmployeeModel employee2 = new EmployeeModel();
        employee2.setName("Yusuf Eko Anggoro");
        employee2.setGender("Laki-laki");
        employee2.setPlaceOfBirth("Jakarta");
        employee2.setPhoneNumber("08121857486");
        employee2.setDateOfBirth(dateOfBirth);
        employee2.setCreatedAt(dateNow);
        employee2.setUpdatedAt(dateNow);
        employee2.setAddress("Jalan-jalan");
        employee2.setReligion("Islam");
        employee2.setJoinDate(dateNow);
        employee2.setStatus("Kawin");
        employee2.setRoleId(1);
        employees.add(employee2);
    }
    
    public static String getInitials(String fullName) {
        String initials = String.valueOf(fullName.charAt(0));

        for (int i = 1; i < fullName.length() - 1; i++){
            if (fullName.charAt(i) == ' '){
                initials = initials + String.valueOf(fullName.charAt(i + 1));
            }                
        }
        return initials.toUpperCase();
    }

    public void start(){
        int index = 1;
        String roleName = null;
        for (EmployeeModel employee : employees) {
            if(employee.getRoleId() == 1){
                roleName = "salessupport";
            }
            String username = getInitials(employee.getName()).toLowerCase() + index++  + "-" + roleName;
            employee.setUsername(username);
            employee.setPassword(Password.getSecurePassword(username));
            employeeDao.create(employee);
        }
        System.out.println("Success Generate User");
    }
}
