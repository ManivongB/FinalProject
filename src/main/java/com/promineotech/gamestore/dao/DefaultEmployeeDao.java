package com.promineotech.gamestore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.gamestore.entity.Employees;

@Component
public class DefaultEmployeeDao implements EmployeesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Employees> fetchEmployees() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM employees";
    // @formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<Employees>() {
      
      public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Employees.builder()
            .employeeId(rs.getInt("employee_id"))
            .employeeName(rs.getString("employee_name"))
            .build();
        // @formatter:off
      }
    });
  }
/**
 * 
 */
  @Override
  public List<Employees> fetchEmployeeByName(String employeeName) {
    // @formatter:off
    String sql = ""
        +"SELECT * FROM employees "
        +"WHERE employee_name = :employee_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("employee_name", employeeName);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Employees.builder()
            .employeeId(rs.getInt("employee_id"))
            .employeeName(rs.getString("employee_name"))
            .build();
      }
    });
  }

  @Override
  public Employees createEmployee(int employeeId, String employeeName) {
    
    SqlParams params = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    //@formatter:off
    params.sql= ""
        +"INSERT INTO employees "
        +"(employee_id, employee_name) "
        +"VALUES (:employee_id, :employee_name)";
    //@formatter:on
    
    params.source.addValue("employee_id", employeeId);
    params.source.addValue("employee_name", employeeName);
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
   
    
    // @formatter:off
    return Employees.builder()
        .employeeId(employeeId)
        .employeeName(employeeName)
        .build();
     //@formatter:on

  }
/**
 * 
 * @author 17028
 *
 */
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
    
  }
  /**
   * 
   */
  @Override
  public Employees updateEmployee(int employeeId, String employeeName) {
    
  //@formatter:off
    String sql = ""
        +"UPDATE employee "
        +"SET "
        +"employee_name = :employee_name, "
        +"WHERE employee_id = :employee_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("employee_name", employeeName);
    params.put("employee_id", employeeId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      
    }
      throw new NoSuchElementException("Could not update employee info");
  }
/**
 * 
 */
  @Override
  public void deleteEmployee(int employeeId) {
    
  //@formatter:off
    String sql = ""
        +"DELETE FROM employees "
        +"WHERE employee_id = :employee_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("employee_id", employeeId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not delete employee");
    }
    
  }

}
