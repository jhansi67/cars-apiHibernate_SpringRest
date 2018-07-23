

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rest.api.db.model.Course;
import com.rest.api.db.model.Student;

public class StudentTest {
	private static SessionFactory factory = HibernateUtility.getSessionFactory();

	public static void main(String[] args) {
		 saveStudent();
		//saveCourse();
		/*
		 * Session session = HibernateUtility.getSessionFactory().openSession();
		 * List<Student> students =
		 * (List<Student>)session.createQuery("from Student ").list(); for(Student stu:
		 * students){ System.out.println("Details : "+stu); }
		 */
		 factory.close();
	}

	public static void saveStudent() {
		List<Course> courselist = Arrays.asList(new Course("10 Silver street"), new Course("JAVA"));
		Student s = new Student("Sam", "Disilva", "Maths", courselist);
		Student s1 = new Student("Ram", "swamy", "Science", courselist);

		Session session = factory.openSession();
		session.beginTransaction();

		session.save(s);
		session.save(s1);
		session.getTransaction().commit();
		session.close();
		session = factory.openSession();
		List<Student> students = (List<Student>) session.createQuery("from Student ").list();
		for (Student stu : students) {
			System.out.println("Details : " + stu);
		}

		
	}

	public static void saveCourse() {
		List<Student> studentList = Arrays.asList(new Student("Sam", "Disilva", "Maths"),
				new Student("Ram", "swamy", "Science"));

		Course c = new Course("10 Silver street", studentList);
		Course c1 = new Course("JAVA", studentList);

		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(c);
		session.save(c1);
		session.getTransaction().commit();
		session.close();
		session = HibernateUtility.getSessionFactory().openSession();
		List<Course> students = (List<Course>) session.createQuery("from Course ").list();
		for (Course stu : students) {
			System.out.println("Details : " + stu);
			//System.out.println("Details : " + stu.getStudent());
		}

		
	}
}
