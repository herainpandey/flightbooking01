package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static String [][] getExcelData() throws IOException {

        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("test1");
        String [][] dataval =null;

        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        dataval = new String[totalRows-1][totalColumns];

        for(int i=1;i<totalRows;i++){
            for(int j=0;j<totalColumns;j++){
                dataval[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return dataval;
    }
}
