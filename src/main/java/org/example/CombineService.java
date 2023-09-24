package org.example;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorksheetCollection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CombineService {
    public void combineExcelFile() throws Exception{
        File root = new File("./");
        File[] files = root.listFiles();
        assert files != null;

        System.out.println("discovering following excel file: ");
        List<File> excelFiles = getExcelFiles(files);
        File number1 = excelFiles.stream().filter(e -> e.getName().contains("number1")).findFirst().orElse(null);
        excelFiles.remove(number1);
        if (number1 != null) {
            System.out.println("found file number1");
            Workbook numberOne = new Workbook(number1.getName());
            for(File file : excelFiles) {
                Workbook otherPage = new Workbook(file.getName());
                int newPage = numberOne.getWorksheets().add();
                numberOne.getWorksheets().get(newPage).copy(otherPage.getWorksheets().get(0));
            }
            numberOne.save("combined_sheet.xlsx");
        } else {
            System.out.println("cannot found file number1 ...");
        }


    }

    public List<File> getExcelFiles(File[] files) {
        List<File> result = new ArrayList<>();
        for (File file : files) {
            String fileName = file.getName();
            String ext = Util.getExtension(fileName);
            if ("xlsx".equals(ext) || "xls".equals(ext)) {
                result.add(file);
                System.out.println(file.getName());
            }
        }
        return result;
    }
}
