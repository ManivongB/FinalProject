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
import com.promineotech.gamestore.entity.Orders;

@Component
public class DefaultOrdersDao implements OrdersDao{

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  @Override
  public List<Orders> fetchOrders() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM orders";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Orders>() {
      
      @Override
      public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Orders.builder()
            .orderId(rs.getInt("order_id"))
            .customerId(rs.getInt("customer_id"))
            .productId(rs.getInt("product_id"))
            .employeeId(rs.getInt("employee_id"))
            .build();
        // @formatter:on
      }
    });
  }
/**
 * 
 */
  @Override
  public List<Orders> fetchOrdersByCustomerId(String customerId) {
    //formatter:off
    String sql = ""
        +"SELECT * FROM orders "
        +"WHERE customer_id = :customer_id";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Orders.builder()
           .customerId(rs.getInt("customer_id"))
           .orderId(rs.getInt("order_id"))
           .build();
        //@formatter:on
      }
    });
  }
/**
 * 
 */
  @Override
  public Orders createOrder(int customerId) {
    SqlParams params = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
  
    //@formatter:off
    params.sql= ""
        +"INSERT INTO orders "
        +"(customer_id) "
        +"VALUES (:customer_id)";
    //@formatter:on
    
    params.source.addValue("customer_id", customerId);
    
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    int orderId = keyHolder.getKey().intValue();
    
    
    // @formatter:off
    return Orders.builder()
        .orderId(orderId)
        .customerId(customerId)
        .build();
     //@formatter:on
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
    
  }
/**
 * 
 */
  @Override
  public Orders updateOrder(int customerId, int orderId) {
  //@formatter:off
    String sql = ""
        +"UPDATE orders "
        +"SET "
        +"customer_id = :customer_id, "
        +"WHERE order_id = :order_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("order_id", orderId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Unable to update order");
  }
    
  //@formatter:off
    return Orders.builder()
        .customerId(customerId)
        .orderId(orderId)
        .build();
    //@formatter:on
    
  }
  /**
   * 
   */
  @Override
  public void deleteOrder(int orderId) {
    //@formatter:off
    String sql = ""
        +"DELETE FROM orders "
        +"WHERE order_id = :order_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("order_id", orderId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Unable to delete order");
    
  }
  }
}

