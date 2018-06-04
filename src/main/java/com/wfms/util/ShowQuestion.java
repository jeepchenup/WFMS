package com.wfms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class ShowQuestion {

	public File readFile(String fileName) {
		String name = fileName + ".txt";
		File file = new File(name);
		if (file.exists()) {
			return file;
		}
		return null;
	}

	public void showRandomQuestion(File file) {
		ArrayList<String> questions = null;
		try {
			String question;
			questions = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while ((question = reader.readLine()) != null) {
				questions.add(question);
			}
			reader.close();

			int randomIdx = new Random().nextInt(questions.size());
			System.out.println("请回答：");
			System.out.println(questions.get(randomIdx));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void run(String fileName) {
		ShowQuestion app = new ShowQuestion();
		File file = app.readFile(fileName);
		app.showRandomQuestion(file);
	}

	public static void main(String[] args) {
		run("question_bank_utf8");
	}
}