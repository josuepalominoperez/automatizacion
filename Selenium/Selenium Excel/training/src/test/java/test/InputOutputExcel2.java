package test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InputOutputExcel2 {

	@SuppressWarnings({ "deprecation", "resource", "unused" })
	public static List<String> readExcelFile(Integer col) {

		List<String> contador = new ArrayList<String>();
		try {
			File file = new File("D:\\automatizacion3\\input\\data.xlsx");
			InputStream excelStream = new FileInputStream(file);
			XSSFWorkbook hssfWorkbook = new XSSFWorkbook(excelStream);
			// Elegimos la hoja que se pasa por parámetro.
			XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			XSSFRow hssfRow;
			// Obtengo el número de filas ocupadas en la hoja
			int rows = hssfSheet.getLastRowNum();
			// Para que empiece a partir de la fila 1
			int fila = 1;
			// Obtengo el número de columnas ocupadas en la hoja
			int cols = 0;
			// Cadena que usamos para almacenar la lectura de la celda
			String cellValue = null;

			for (int r = fila; r <= rows; r++) {
				hssfRow = hssfSheet.getRow(r);

				if (hssfRow == null) {
					break;
				} else {
					for (int c = 0; c < (cols = hssfRow.getLastCellNum()); c++) {
						if (c == col) {
							cellValue = hssfRow.getCell(c) == null ? ""
									: (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_STRING)
											? hssfRow.getCell(c).getStringCellValue()
											: (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_NUMERIC)
													? "" + hssfRow.getCell(c).getDateCellValue().getTime()
													: (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BOOLEAN)
															? "" + hssfRow.getCell(c).getBooleanCellValue()
															: (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BLANK)
																	? "BLANK"
																	: (hssfRow.getCell(c)
																			.getCellType() == Cell.CELL_TYPE_FORMULA)
																					? "FORMULA"
																					: (hssfRow.getCell(c)
																							.getCellType() == Cell.CELL_TYPE_ERROR)
																									? "ERROR"
																									: "";
							// contador +=cellValue+",";
							contador.add(cellValue);
						}
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception: " + ex.getMessage());
		}

		return contador;
	}

	public static void SaveDataExcel(Map<Integer, Object[]> empinfo) {

		try {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
			LocalDateTime now = LocalDateTime.now();
			String ruta = "D:\\automatizacion3\\log11122020.xlsx";

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet spreadsheet = workbook.createSheet("casosdeprueba");
			spreadsheet.setColumnWidth(0, 1500); // COLUMN - A
			spreadsheet.setColumnWidth(1, 10000); // COLUMN - B
			spreadsheet.setColumnWidth(2, 12000); // COLUMN - C
			spreadsheet.setColumnWidth(3, 8000); // COLUMN - D
			spreadsheet.setColumnWidth(4, 24000); // COLUMN - E
			// spreadsheet.addMergedRegion(new CellRangeAddress(0,0,0,3)); // Juntar celdas

			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setAlignment(HorizontalAlignment.LEFT);
			style.setWrapText(true);
			style.setBorderRight(BorderStyle.THIN);
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderLeft(BorderStyle.THIN);
			style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderTop(BorderStyle.THIN);
			style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderBottom(BorderStyle.THIN);
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

			final Font font = workbook.createFont();
			font.setFontName("Arial");
			font.setBold(true);
			style.setFont(font);

			String[] title = { "N�", "CASO DE PRUEBA", "VALOR", "MENSAJE DE VALIDACION", "OBSERVACION" };

			Row filaTile = spreadsheet.createRow(0); // Creamos una fila en la hoja
			for (int i = 0; i < title.length; i++) {
				Cell celda = filaTile.createCell(i);
				celda.setCellStyle(style);
				celda.setCellValue(title[i]);
			}

			Set<Integer> keyid = empinfo.keySet();
			int rowid = 1;
			for (Integer key : keyid) {
				XSSFRow row = spreadsheet.createRow(rowid++);
				Object[] objectArr = empinfo.get(key);
				int cellid = 0;

				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String) obj);
				}
			}

			FileOutputStream outputStream = new FileOutputStream(ruta);
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
