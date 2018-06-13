package ro.siit.java10.ElectricCarPurchaseProgram;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import ro.siit.java10.ElectricCarPurchaseProgram.dao.ElectricCarDAO;
import ro.siit.java10.ElectricCarPurchaseProgram.dao.ElectricCarDAOImpl;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public ElectricCarDAO electricCarDAO() {
        return new ElectricCarDAOImpl(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5432")
                .append("/")
                .append("carsdatabase")
                .append("?user=")
                .append("postgres")
                .append("&password=")
                .append("22071980win").toString();

        return new SingleConnectionDataSource(url, false);
    }
}