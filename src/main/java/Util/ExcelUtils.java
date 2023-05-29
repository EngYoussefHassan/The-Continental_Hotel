package Util;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell cell;
    private static XSSFRow Row;
    private static String path;
    private static int sheetNum;
    private static FileInputStream excelFile;

    public static int getNumberOfRows() {
        return ExcelWSheet.getLastRowNum();
    }

    public static int getNumberOfColumns() {
        return ExcelWSheet.getRow(ExcelWSheet.getFirstRowNum()).getLastCellNum();
    }

    public static void setExcelFile(String Path, int sheetNum) throws IOException {
        try {
            path = Path;
            ExcelUtils.sheetNum = sheetNum;
            ZipSecureFile.setMinInflateRatio(0);
            excelFile = new FileInputStream(Path);
            ExcelWBook = new XSSFWorkbook(excelFile);
            ExcelWSheet = ExcelWBook.getSheetAt(sheetNum);
        } catch (IOException e) {  // Exception Handling
            System.out.println(e.getMessage());
            excelFile.close();
            throw (e);
        }
    }

    public static Object getCellData(int RowNum, int ColNum) {
        try {
            cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            return getCellValueAsString(cell);
        } catch (Exception e) {
            return "";
        }
    }

    private static Object getCellValueAsString(XSSFCell cell) {
        if (cell == null || (cell.getCellType() == CellType.BLANK)) {
            return "";
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            // For Date
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue();
            }
            double temp = cell.getNumericCellValue();
            int a = (int) temp;
            if (temp > a) {
                return temp;
            } else {
                return a;
            }
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue();
        } else if (cell.getCellType() == CellType.BLANK) {
            return "";
        } else if (cell.getCellType() == CellType.ERROR) {
            return cell.getErrorCellValue();
        } else {
            return null;
        }

    }


}
