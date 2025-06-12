package com.rahulshettyacademy.utils;

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader {
    private XWPFDocument document;
    private String filePath;

    public WordReader(String filePath) {
        this.filePath = filePath;
    }

    public void loadDocument() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        document = new XWPFDocument(fis);
    }

    public List<String> getAllParagraphsText() {
        List<String> paragraphs = new ArrayList<>();
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            paragraphs.add(paragraph.getText());
        }
        return paragraphs;
    }

    public List<List<String>> getAllTablesData() {
        List<List<String>> allTablesData = new ArrayList<>();
        
        for (XWPFTable table : document.getTables()) {
            List<String> tableData = new ArrayList<>();
            
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    tableData.add(cell.getText());
                }
            }
            
            allTablesData.add(tableData);
        }
        
        return allTablesData;
    }

    public String searchText(String searchTerm) {
        StringBuilder result = new StringBuilder();
        
        // Search in paragraphs
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            String text = paragraph.getText();
            if (text.contains(searchTerm)) {
                result.append("Found in paragraph: ").append(text).append("\n");
            }
        }
        
        // Search in tables
        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    String text = cell.getText();
                    if (text.contains(searchTerm)) {
                        result.append("Found in table cell: ").append(text).append("\n");
                    }
                }
            }
        }
        
        return result.toString();
    }

    public List<String> getHeaders() {
        List<String> headers = new ArrayList<>();
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            if (!paragraph.getRuns().isEmpty() && paragraph.getRuns().get(0).isBold()) {
                headers.add(paragraph.getText());
            }
        }
        return headers;
    }

    public void close() throws IOException {
        if (document != null) {
            document.close();
        }
    }
} 