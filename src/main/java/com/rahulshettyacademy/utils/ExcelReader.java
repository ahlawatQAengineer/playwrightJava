package com.rahulshettyacademy.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    private Workbook workbook;
    private Sheet sheet;
    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public void loadWorkbook() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    public void selectSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " not found");
        }
    }

    public void selectSheet(int index) {
        sheet = workbook.getSheetAt(index);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet at index " + index + " not found");
        }
    }

    public List<Map<String, String>> readSheet() {
        List<Map<String, String>> data = new ArrayList<>();
        Row headerRow = sheet.getRow(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            if (currentRow == null) continue;

            Map<String, String> rowData = new HashMap<>();
            for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                Cell headerCell = headerRow.getCell(j);
                Cell currentCell = currentRow.getCell(j);
                
                String header = getCellValueAsString(headerCell);
                String value = getCellValueAsString(currentCell);
                
                rowData.put(header, value);
            }
            data.add(rowData);
        }
        return data;
    }

    public Object[][] getDataAsObjectArray() {
        List<Map<String, String>> data = readSheet();
        Object[][] array = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            array[i][0] = data.get(i);
        }
        return array;
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                }
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
} 