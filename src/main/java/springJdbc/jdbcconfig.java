package springJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


// Using Annotations
@Configuration
public class jdbcconfig {
@Bean("ds")
    public DriverManagerDataSource getdatasource(){

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://Localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("Rushabhjay002@");
        return ds;
    }
@Bean("template")
    public JdbcTemplate gettemplate(){

        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(getdatasource());
        return template;
    }
}
