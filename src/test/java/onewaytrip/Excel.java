package onewaytrip;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;


public class Excel {
	Workbook wb;
	public Excel(String path)throws Exception
	{
	   wb=new HSSFWorkbook(new FileInputStream(path));
	}
			
	public String getData(String SheetName,int row,int col)
	{
		String data=wb.getSheet(SheetName).getRow(row).getCell(col).toString();
		return data;
	}
	public int getRowNum(String SheetName)
	{
		int row=wb.getSheet(SheetName).getLastRowNum()+1;
		return row;
	}
	public int getColNum(String SheetName)
	{
		int col=wb.getSheet(SheetName).getRow(0).getLastCellNum();
		return col;
	}
	

}
