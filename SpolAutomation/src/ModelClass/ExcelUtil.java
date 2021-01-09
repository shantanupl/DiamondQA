package ModelClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	//Write
	public ExcelUtil() {
		// TODO Auto-generated constructor stub
	}
	public static void writeToFile(int a, ArrayList<String> testcase) throws IOException{
		
		File src = new File(System.getProperty("user.dir")+"/src/resources/excelfile/SPOL_TestCase.xlsx");
        FileInputStream fis=new FileInputStream(src);
        
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sheet1=wb.getSheetAt(2);
        int i1;
        for(i1=0;i1<testcase.size();i1++) {
      	  sheet1.getRow(a).createCell(10).setCellValue(testcase.get(i1));
      	  a++;
        }
		  FileOutputStream out = new FileOutputStream(src);
		  wb.write(out);
		  wb.close();
	}


}
