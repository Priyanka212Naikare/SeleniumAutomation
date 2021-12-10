package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	int rowcount,cellcount;
	File file;
	
	public ExcelDriver() throws IOException {
		// TODO Auto-generated constructor stub
		file=new File("D:\\TestData.xlsx");
		FileInputStream fin=new FileInputStream(file);
		workbook=new XSSFWorkbook(fin);
		sheet=workbook.getSheet("testData");
		
	}
	public void readExcel() throws IOException
	{
		
		
	    rowcount=sheet.getLastRowNum();
	    
	    for(int i=0;i<rowcount+1;i++)
	    {
	    	row=sheet.getRow(i);
	    	cellcount=row.getLastCellNum();
	    	
	    	for(int j=0;j<cellcount;j++)
	    	{
	    		 cell=row.getCell(j);
	    	     String cellData=cell.getStringCellValue();
	    	     System.out.println(""+cellData);
	    	}
	    }
	}
	
	public void writeExcel() throws IOException
	{
		String[][] dataset= {{"shreeshailmba@gmail.com","shree@123"},{"pri@gmail.com","pri123"}};
		 rowcount=sheet.getLastRowNum();
		row=sheet.getRow(0);
		cellcount=row.getLastCellNum();
		for(int k=0;k<dataset.length;k++)
		{
			for(int l=0;l<cellcount;l++)
			{
				cell=row.createCell(rowcount+k);
				cell.setCellValue(dataset[k][l]);
			}
			
		}
		
		FileOutputStream fout=new FileOutputStream(file);
		workbook.write(fout);
		
	}

}
