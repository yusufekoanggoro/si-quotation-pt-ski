package initialproject.controllers;

import initialproject.dao.InterfaceDao;
import initialproject.dao.UserDao;
import initialproject.databases.Mysql;
import initialproject.models.User;
import initialproject.models.UserTableModel;
import initialproject.views.UserFrame;
import java.io.File;
import java.util.List;

//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Cell;

public class UserController {

    private final UserFrame frame;
    private final InterfaceDao<User> userDao;
    private final List<User> users;

    public UserController(UserFrame frame) {
        this.frame = frame;
        userDao = new UserDao();
        users = userDao.findAll();
    }

    public void loadTable() {
        UserTableModel userTableModel = new UserTableModel(users);
        frame.getJTable1().setModel(userTableModel);
    }

    public void excelReport()  {
//        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("Users");
//            
//            String[] columns = {"ID", "Name", "Age"};
//            
//            Row headerRow = sheet.createRow(0);
//            
//            for (int i = 0; i < columns.length; i++) {
//                Cell cell;
//                cell = headerRow.createCell(i);
//                cell.setCellValue(columns[i]);
//            }
//            
//            int rowNum = 1;
//            for (User user : this.users) {
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellValue(user.getId());
//                row.createCell(1).setCellValue(user.getName());
//                row.createCell(2).setCellValue(user.getAge());
//            }
//            
//            // Write the output to a file
//            String home = System.getProperty("user.home");
//            FileOutputStream fileOut = new FileOutputStream(home+"/Downloads/" + "poi-generated-file.xlsx");
//            workbook.write(fileOut);
//            fileOut.close();
//            
//            // Closing the workbook
//            workbook.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
    
    
    public void jasperReport() {
//        try{
//            InputStream stream = UserController.class.getResourceAsStream("/resources/Cherry.jrxml");
//            if (stream == null) {
//                throw new RuntimeException("Report not found!");
//            }
//        }catch(RuntimeException e){
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }

    }

    public void daoCloseConnection() {
        userDao.closeConnection();
    }
}
