package springJdbc;
import static springJdbc.Dao.*;
import java.util.Scanner;

public class SpringJdbcApplication {
	public static void main(String[] args) {

		System.out.println("PRESS 1 TO INSERT");
		System.out.println("PRESS 2 TO UPDATE");
		System.out.println("PRESS 3 TO DELETE");
		System.out.println("PRESS 4 TO VIEW STUDENT DETAILS");
		System.out.println("PRESS 5 TO ALL STUDENT");
		System.out.println("PRESS 6 TO VIEW STUDENT NAME");
		System.out.println("Enter");
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		switch (e){
			case 1:
				insertstudent();
				break;
			case 2:
				updatestudent();
				break;
			case 3:
				deletestudent();
				break;
			case 4:
				viewstudentbyId();
				break;
			case 5:
				viewstudent();
				break;
			case 6:
				viewName();
				break;
			default:
				System.out.println("Byee");
		}
	}
}
