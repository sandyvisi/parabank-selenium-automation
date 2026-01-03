package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtility {

	public static Object[][] readExceldata(String excelPath) throws IOException {
		String filePath = excelPath;
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("OrangeHRMLogin");

		int numberOfRows = 1;

		int rowsCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		System.out.println("rowsCount" + rowsCount);
		System.out.println("colCount" + colCount);

		int numberOfColumns = 11;

		DataFormatter df = new DataFormatter();
		Object[][] datas;

		datas = new Object[numberOfRows][numberOfColumns];

		for (int a = 1; a <= 1; a++) {

			XSSFRow rows = sheet.getRow(a);

			if (rows == null) {
				continue;
			}

			for (int b = 0; b < 11; b++) {

				XSSFCell cellValue = rows.getCell(b);
				datas[a - 1][b] = df.formatCellValue(cellValue);

			}

		}
		wb.close();
		fis.close();

		System.out.println(datas.toString());

		return datas;

	}

}
