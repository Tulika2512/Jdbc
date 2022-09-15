package DaoDemo;

//fetch name with rollno.

public class JdbcDAO {

	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		StudentDAO sDAO = new StudentDAO();
		sDAO.connect();
		Student s = new Student();
		//s.rollno = 2;
		
		//sDAO.getname(2);
		
		//s.sname = "Parth";
		//sDAO.addStudent(s);
		
		sDAO.deleteStudent(3);
		
		
		
	}
}
