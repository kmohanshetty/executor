package test.program.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestColumn {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a sheet
        Sheet sheet = workbook.createSheet("ExampleSheet");

        // Create a row
        Row row = sheet.createRow(0);

        // Create a cell
        Cell cell = row.createCell(0);
        String cellText = "This is an example text";

        // Set the cell value
        cell.setCellValue(cellText);

        // Calculate the width of the column in terms of character units
        int width = cellText.length() * 256;

        // Set the column width
        sheet.setColumnWidth(0, width);

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("example.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
