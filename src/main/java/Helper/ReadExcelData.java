package Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static ArrayList<String> getExcelData(String fileLocation, String sheetName, String columnName, String testCaseName) throws IOException
	{
		ArrayList<String> data = new ArrayList<String>();
		
		// download the excel file
		FileInputStream file = new FileInputStream(fileLocation);
		
		// load file into Apache workbook
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		
		// get the data sheet
		XSSFSheet sheet = workBook.getSheet(sheetName);
		

		// call Iterator to iterate through available row in the sheet
		Iterator<Row> rows = sheet.rowIterator();
		
		// get first row of the sheet
		Row firstRow = rows.next();
		
		// now iterate cells in that specific row
		Iterator<Cell> cells = firstRow.iterator();
		
		// set two variables
		int k = 0;
		int column = 0;
		// check if there is next cell(column) available
		while(cells.hasNext())
		{
			Cell cellValue = cells.next();
			
			// get the value in first cell to see if the value = test case Name (as columnName)
			if(cellValue.getStringCellValue().equalsIgnoreCase(columnName))
			{
				column = k; // k value is assigned to column
			}
			 
			// k increases by 1 for each while loop when check the value of each cell 
			// to see if it equals to the columnName.  assign that k value to column 
			// once there is a match!
			k++;
		}
		
		
		
		// Once column is identify, now we need to locate the specific row we need in "THAT COLUMN"
		while(rows.hasNext())
		{
			Row r = rows.next(); // cell value in Excel is "Test Case Name"
			
			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
				// once desired row is located, call Iterator to iterate all cells in that row
				Iterator<Cell> cv = r.cellIterator();
				
				while(cv.hasNext())
				{
					Cell cValueInThatRow = cv.next();
					
//							switch(cValueInThatRow.getCellType())
//							{
//							case STRING:
//								data.add(cValueInThatRow.getStringCellValue());
//							case NUMERIC:
//								data.add(NumberToTextConverter.toText(cValueInThatRow.getNumericCellValue()));
//							default:
//								break;
//							}
					
					// format data into string with Apache Formatter
					HSSFDataFormatter hdf = new HSSFDataFormatter();
					String text = hdf.formatCellValue(cValueInThatRow);

					data.add(text);
					
					
//							if(cValueInThatRow.getCellType() == CellType.STRING)
//							{
//								data.add(cValueInThatRow.getStringCellValue());
//							}
//							else if(cValueInThatRow.getCellType() == CellType.NUMERIC)
//							{
//								data.add(NumberToTextConverter.toText(cValueInThatRow.getNumericCellValue()));
//							}
				}
				
			}
		}
		
	// outside of for loop
	return data;
	}
	
}
