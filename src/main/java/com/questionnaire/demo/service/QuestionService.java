package com.questionnaire.demo.service;

import com.questionnaire.demo.dao.QuestionDao;
import com.questionnaire.demo.entity.QuestionEntity;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionDao questionDao;

    public List<QuestionEntity> findAll(){
        List<QuestionEntity> list = new ArrayList<>();
        String t = "img_";
        for(int i=0;i<=499;i++) {
            String path = t+ String.valueOf(i);
            QuestionEntity temp = new QuestionEntity("image",path+"/0.jpg",path+"/1.jpg");
            list.add(temp);
        }
        return list;
    }
    public List<QuestionEntity> test(){
        List<QuestionEntity> list = new ArrayList<>();
        String t = "img_";
        for(int i=0;i<=5;i++) {
            String path = t+ String.valueOf(i);
            QuestionEntity temp = new QuestionEntity("image",path+"/0.jpg",path+"/1.jpg");
            list.add(temp);
        }
        return list;
    }
    public List<String> readColumn(File file, int index) throws Exception {
        List<String > list = new ArrayList<>();
        InputStream inputStream = new FileInputStream(file.getAbsoluteFile());
        Workbook workbook = Workbook.getWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(0);
        int rows = sheet.getRows();
        int columns = sheet.getColumns();
        for (int i = 0; i < rows; i++) {
            Cell cell = sheet.getCell(index, i);
            list.add(cell.getContents());
        }
        return list;
    }
}
