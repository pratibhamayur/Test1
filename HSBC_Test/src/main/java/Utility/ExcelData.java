package Utility;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static Object[][] readDataFromExcel(String filepath, String sheetname,int startrow, int startcol){

		Workbook workbook=null;
		Object data[][]=null;

		try{
			FileInputStream fis = new FileInputStream(filepath);
			String fileExtensionName = filepath.substring(filepath.indexOf("."));

			if(fileExtensionName.equals(".xlsx")){
				workbook = new XSSFWorkbook(fis);
			}
			else if(fileExtensionName.equals(".xls")){
				workbook = new HSSFWorkbook(fis);
			}
			else{
				System.out.println("The file seleted for data read is not correct...");
			}

			Sheet sheet = workbook.getSheet(sheetname);
			int rowcount = sheet.getLastRowNum();
			int cellcount = sheet.getRow(0).getLastCellNum();
			data=new Object[rowcount-1][cellcount];

			for(int i=startrow; i<rowcount;i++){
				for(int j=startcol;j<cellcount;j++){	

					switch(sheet.getRow(i).getCell(j).getCellType()){
					case STRING:
						data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(j))) {
							data[i-1][j]=sheet.getRow(i).getCell(j).getDateCellValue();
						} else {			
							int value = (int)sheet.getRow(i).getCell(j).getNumericCellValue();
							data[i-1][j]=value;
						}

						break;
					case BOOLEAN:
						data[i-1][j]=sheet.getRow(i).getCell(j).getBooleanCellValue();
						break;
					case ERROR:
						data[i-1][j]=sheet.getRow(i).getCell(j).getErrorCellValue();
						break;
					case BLANK:
						data[i-1][j]=" ";
						break;
					case _NONE:
						data[i-1][j]=" ";
						break;
					default:
						System.out.println("Data in column is not in correct format..");
						break;	
					}
					System.out.println(data[i-1][j]);
				}

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}
}
