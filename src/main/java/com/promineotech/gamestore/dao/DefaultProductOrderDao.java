package com.promineotech.gamestore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.gamestore.entity.ProductOrders;

@Component
public class DefaultProductOrderDao implements ProductOrdersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<ProductOrders> fetchProductOrders() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM coffee_orders";
    //@formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<ProductOrders>() {

      @Override
      public ProductOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return ProductOrders.builder()
           .orderId(rs.getInt("order_id"))
           .productId(rs.getInt("product_id"))
           .build();
        //@formatter:on
      }
    });
  }

}
