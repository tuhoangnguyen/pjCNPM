package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Course;

public class CourseModel {


	public static void main(String[] args) {
		System.out.println(findAll());
	}

	// Phương thức tìm dữ liệu trong course.csv
	public static List<Course> findAll() {
		List<Course> listCourse = new ArrayList<Course>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
		try {
			List<String> files = Files.readAllLines(Paths.get("src/data/course.csv"));
			for (int i = 0; i < files.size(); i++) {
				String[] value = files.get(i).split(",");
				try {
					listCourse.add(new Course(Integer.parseInt(value[0]), value[1], simpleDateFormat.parse(value[2]),
							Double.parseDouble(value[3]), Integer.parseInt(value[4]), value[5], value[6],
							Integer.parseInt(value[7]), value[8], value[9]));
				} catch (NumberFormatException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCourse;
	}

	// Phương thức tạo mới 1 khóa học trong course.csv
	public boolean createNewCourse(String content) {
		boolean result = true;
		String oldContent = "";
		try {
			List<String> files = Files.readAllLines(Paths.get("src/data/course.csv"));
			for (String strings : files) {
				oldContent += strings + "\n";
			}
			String newContent = oldContent + content;
			Files.write(Paths.get("src/data/course.csv"), newContent.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}

	public static boolean updateStudent(int AccID, String content) {
		boolean result = true;

		List<String> files;
		try {
			String first = "";
			String last = "";
			String newContent = "";
			files = Files.readAllLines(Paths.get("src/data/course.csv"));
			for (int i = 0; i < files.size(); i++) {
				String[] values = files.get(i).split(",");
				if (values[0].equalsIgnoreCase(String.valueOf(AccID))) {
					System.out.println(i);
					for (int j = 0; j < i; j++) {
						first += files.get(j) + "\n";
					}
					for (int k = i + 1; k < files.size(); k++) {
						last += files.get(k) + "\n";
					}
				}

			}
			newContent = first + content + "\n" + last;
			Files.write(Paths.get("src/data/course.csv"), newContent.getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public Course findCourseByID(int id) {
		Course course = null;
		for (Course courses : findAll()) {
			if (courses.getCourseID() == id) {
				course = courses;
			}
		}
		return course;
	}

	public List<Course> searchByName(String name) {
		List<Course> courses = new ArrayList<>();
		for (Course course : findAll()) {
			if (course.getCourseName().toLowerCase().contains(name)) {
				courses.add(course);
			}
		}
		return courses;
	}

	public Course findCourseByName(String name) {
		Course course = null;
		for (Course courses : findAll()) {
			if (courses.getCourseName().equalsIgnoreCase(name)) {
				course = courses;
			}
		}
		return course;
	}

	public List<Course> searchByTeacherID(int id) {
		List<Course> courses = new ArrayList<>();
		for (Course course : findAll()) {
			if (course.getTeacherID() == id) {
				courses.add(course);
			}
		}
		return courses;
	}

	public List<Course> searchByNameAndTeacherID(String name, int teacherID) {
		List<Course> courses = new ArrayList<>();
		for (Course course : findAll()) {
			if (course.getCourseName().toLowerCase().contains(name) && course.getTeacherID() == teacherID) {
				courses.add(course);
			}
		}
		return courses;
	}


}