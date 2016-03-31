package com.nab.skilltest.question.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nab.skilltest.model.ComplexityLevel;
import com.nab.skilltest.model.Question;
import com.nab.skilltest.model.QuestionType;
import com.nab.skilltest.model.Skill;

public class QuestionHelper {


	public List<Question> readExcel(File file) {
		
		List<Question> questionList = new ArrayList<Question>();
		
		try
		{
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			if(rowIterator.hasNext()) rowIterator.next();
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				Question question = new Question();
				List<String> answerOptions = new ArrayList<String>();
				List<String> correctAnswers = new ArrayList<String>();
				
				question.setId((int)row.getCell(0).getNumericCellValue());
				question.setDescription(row.getCell(1).getStringCellValue());
				question.setqType(QuestionType.valueOf(row.getCell(2).getStringCellValue()));
				question.setcLevel(ComplexityLevel.valueOf(row.getCell(3).getStringCellValue()));
				question.setSkill(Skill.valueOf(row.getCell(4).getStringCellValue()));
				if(row.getCell(5) != null) answerOptions.add(row.getCell(5).getStringCellValue());
				if(row.getCell(6) != null) answerOptions.add(row.getCell(6).getStringCellValue());
				if(row.getCell(7) != null) answerOptions.add(row.getCell(7).getStringCellValue());
				if(row.getCell(8) != null) answerOptions.add(row.getCell(8).getStringCellValue());
				question.setAnswerOptions(answerOptions);
				if(row.getCell(9) !=null) correctAnswers.add(row.getCell(9).getStringCellValue());
				question.setCorrectAnswers(correctAnswers);
				
				questionList.add(question);
			}
			fis.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return questionList;
	}

}
