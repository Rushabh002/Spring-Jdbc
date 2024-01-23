package springJdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Dao {

    static ApplicationContext context = new AnnotationConfigApplicationContext(jdbcconfig.class);
    static JdbcTemplate template = (JdbcTemplate) context.getBean("template");

    public static void insertstudent(){
        String query = "Insert into student(id,name,city) values(?,?,?)";
        int row =template.update(query,500,"Rush Mishra","Gwalior");
    }
    public static void updatestudent(){
        String query = "Update student set name=?,city =? where id =?";
        int row=template.update(query,"Vaishali Mishra","Vadodara",147);
        if(row>0){
            System.out.println("Success");
        }else{
            System.out.println("Not");
        }
    }
    public static void deletestudent(){
        String query = "Delete from student where id =?";
        int row=template.update(query,147);
        if(row>0){
            System.out.println("Success");
        }else{
            System.out.println("Not");
        }
    }
    public static void viewstudentbyId(){
        String query = "Select *from student where id = ?";
        RowMapper rowmapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
               student.setId(rs.getInt(1));
               student.setName(rs.getString(2));
               student.setCity(rs.getString(3));
               return student;
            }
        };
        Student st = (Student) template.queryForObject(query,rowmapper,185);
        System.out.println(st);
    }
    public static void viewstudent(){
        String query = "Select *from student ";
        RowMapper rowmapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setCity(rs.getString(3));
                return student;
            }
        };
        List<Student> st =  template.query(query,rowmapper);
        for (Student i:st) {
            System.out.println(i);
        }
    }
    public static void viewName(){
        String n = "select name from student where id =?";
        RowMapper rowMapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                String name = rs.getString(1);
                return name;
            }
        };
       String name =(String) template.queryForObject(n,rowMapper,185);
        System.out.println(name);
    }

}
