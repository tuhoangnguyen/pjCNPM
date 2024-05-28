package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Teacher;

public class TeacherModel {
	public static void main(String[] args) {
		System.out.println(new TeacherModel().findById(12));
	
	}
	public static List<Teacher> findAll(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			List<String> files = Files.readAllLines(Paths.get("src/data/teacher.csv"));
			for (int i = 0; i < files.size(); i++) {
				String[] values = files.get(i).split(",");
				try {
					teachers.add(new Teacher(Integer.parseInt(values[0]),Integer.parseInt(values[1]), values[2], dateFormat.parse(values[3]), 
							values[4], values[5], values[6]));
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teachers;
	}
	public Teacher findById(int id) {
		Teacher teacher = null;
		for (Teacher teachers : findAll()) {
			if(teachers.getAccountID() == id) {
				teacher = teachers;
			}
		}
		return teacher;
	}
	public Teacher findByName(String name) {
		Teacher teacher = null;
		for (Teacher teachers : findAll()) {
			if(teachers.getName().equalsIgnoreCase(name)) {
				teacher = teachers;
			}
		}
		return teacher;
	}
	
	// Phương thức dựa vào id sẽ tìm ra được tên giảng viên
		public String findTeacherById(int id) {
			String result = "";
			try {
				List<String> file = Files.readAllLines(Paths.get("src/data/teacher.csv"));
				for (int i = 0; i < file.size(); i++) {
					String[] value = file.get(i).split(",");
					if (Integer.parseInt(value[0]) == id) {
						result = value[1];
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;
		}
}
