package ro.siit.java10.ElectricCarPurchaseProgram.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.DatabaseElement;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.ElectricCar;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ElectricCarDAOImpl implements ElectricCarDAO {


    JdbcTemplate jdbcTemplate;


    public ElectricCarDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<DatabaseElement> getAll(String sql) {
        return jdbcTemplate.query(sql, new RowMapper<DatabaseElement>() {
            @Override
            public DatabaseElement mapRow(ResultSet resultSet, int i) throws SQLException {
                ElectricCar electricCar = new ElectricCar();
                electricCar.setManufacturer(resultSet.getString("manufacturer"));
                electricCar.setModel(resultSet.getString("model"));
                electricCar.setProductionYear(resultSet.getInt("productionYear"));
                electricCar.setFastCharging(resultSet.getBoolean("fastCharging"));
                electricCar.setElectricMotor(resultSet.getString("electricMotor"));
                electricCar.setElectricBattery(resultSet.getString("electricBattery"));
                electricCar.setConsumption(resultSet.getString("consumption"));
                electricCar.setHorsePower(resultSet.getInt("horsePower"));
                electricCar.setRangePerCharge(resultSet.getInt("rangePerCharge"));
                electricCar.setNew(resultSet.getBoolean("isNew"));
                electricCar.setId(resultSet.getInt("Id"));

                DatabaseElement result = new DatabaseElement();
                result.setElectricCar(electricCar);
                result.setStock(resultSet.getInt("stock"));
                result.setPrice(resultSet.getDouble("price"));
                return result;
            }
        });
    }


    @Override
    public DatabaseElement getById(int id) {
        return jdbcTemplate.queryForObject("select * from electriccars  where id = ?",

                DATABASE_ELEMENT_ROW_MAPPER, id);
    }


    public final RowMapper<DatabaseElement> DATABASE_ELEMENT_ROW_MAPPER = new RowMapper<DatabaseElement>() {

        @Override
        public DatabaseElement mapRow(ResultSet resultSet, int i) throws SQLException {
            return null;
        }


    };

};


