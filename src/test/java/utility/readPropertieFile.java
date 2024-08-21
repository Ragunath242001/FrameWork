package utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readPropertieFile {

    public  static String configProperties(String value) {

        Properties propobj = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("./src/test/java/Resource/config.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            propobj.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  propobj.getProperty(value);

    }


    public static Object[][] readExcelFile() throws IOException {


        FileInputStream fs = new FileInputStream(new File("./src/test/java/Resource/testData.xls"));

        HSSFWorkbook wb = new HSSFWorkbook(fs);


        HSSFSheet sheet = wb.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int col = sheet.getRow(rows).getLastCellNum();

        System.out.println(rows);
        System.out.println(col);

        Object[][] data = new Object[rows][col];
        for (int i = 0; i < rows; i++) {
            HSSFRow row = sheet.getRow(i+1);
            for (int j = 0; j < col; j++) {
               HSSFCell cell =  row.getCell(j);
               CellType cellType = cell.getCellType();
               switch (cellType) {
                   case STRING:
                       data[i][j] = cell.getStringCellValue();
                       break;
                   case NUMERIC:
                       data[i][j] = Integer.toString((int) cell.getNumericCellValue());
                       break;
                   case BOOLEAN:
               }


            }
        }

        return data;




    }


}
