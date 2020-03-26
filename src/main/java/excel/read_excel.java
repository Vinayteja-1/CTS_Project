package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_excel {
	protected String[][] data=new String[4][3];
	int r,c;
	public void get_data()
	{
		File f=new File("src\\test\\resources\\TESTDATA\\login_1.xlsx");
		try {
			FileInputStream fis=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh1=wb.getSheet("Sheet1");
			for (r=0;r<=3;r++) {
			XSSFRow row=sh1.getRow(r);
			for(c=0;c<3;c++)
			{
				XSSFCell cell=row.getCell(c);
				String m=cell.getStringCellValue();
//				data_login[c]=m;
				data[r][c]=m;
			}}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

}
}
