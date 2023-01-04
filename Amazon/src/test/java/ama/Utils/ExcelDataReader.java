package ama.Utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelDataReader {
	
	public WebDriver driver;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	
	//creating a constructor this will load the excel data when class obj was created
	public ExcelDataReader() {
			
		File src = new File("./TestData/testdata.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());	
		}	
	}
	
	
	/* public String Username_Data() throws Exception
	  {
		  FileInputStream fis= new FileInputStream("./TestData/testdata1.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  Row row2 = sheet.getRow(1);
		  Cell cell2 = row2.getCell(1);
		  System.out.println(sheet.getRow(1).getCell(0));
		  String user= sheet.getRow(1).getCell(0).getStringCellValue();
		  return user;
	  }
	 
	 
	 public String Password_Data() throws Exception
	  {
		  FileInputStream fis= new FileInputStream("./TestData/testdata1.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  Row row2 = sheet.getRow(1);
		  Cell cell2 = row2.getCell(1);
		  System.out.println(sheet.getRow(1).getCell(1));
		  String pass= sheet.getRow(1).getCell(1).getStringCellValue();
		  return pass;
	  } */
	
	public String getStringdata(String sheetname, int row, int column) {
				
		Cell cell = wb.getSheet(sheetname).getRow(row).getCell(column);//.getNumericCellValue();
	//	 String zip1Value = cell.getStringCellValue();
		 String str = cell.getStringCellValue();
		 return str;
	}
	
	public String getStringdata1(String sheetname, int row, int column) {
		
		Cell cell = wb.getSheet(sheetname).getRow(row).getCell(column);//.getNumericCellValue();
		 cell.setCellType(cell.CELL_TYPE_STRING);
		 String str = cell.getStringCellValue();
		 return str;
		 
	//	return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
		/* Cell cell1 = sheet1.getRow(i).getCell(0);   
        
        switch (cell1.getCellType()) {
        
        case Cell.CELL_TYPE_STRING:
            System.out.println(cell1.getRichStringCellValue().getString());
            break;
            
        case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell1)) {
                System.out.println(cell1.getDateCellValue());
            } else {
                System.out.println(cell1.getNumericCellValue());
            }
            break;
            
        case Cell.CELL_TYPE_BOOLEAN:
            System.out.println(cell1.getBooleanCellValue());
            break;
            
        case Cell.CELL_TYPE_FORMULA:
            System.out.println(cell1.getCellFormula());
            break; */
	}
	
     public int getintegerdata1(String sheetname, int row, int column) {
		
		Cell cell = wb.getSheet(sheetname).getRow(row).getCell(column);//.getNumericCellValue();
		 cell.setCellType(cell.CELL_TYPE_STRING);
		 int str = (int) cell.getNumericCellValue();
		 return str;
     }
	public double getNumericData(String sheetname, int row, int column) {
		
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public int getNumericDatatoint(String sheetname, int row, int column) {
		double d = wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
        int i = (int) (d);
        return i;
	}
		
	public String getStringdata(int sheetindex, int row, int column) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	} 

}
