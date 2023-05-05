package com.promineotech.gamestore.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.gamestore.entity.ProductConsole;
import com.promineotech.gamestore.entity.ProductGame;
import com.promineotech.gamestore.entity.Products;

@Component
public class DefaultProductDao implements ProductDao{

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Products> fetchProducts() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM products";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new RowMapper<Products>() {
       
        @Override
        public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
          // @formatter:off
         return Products.builder()
             .productId(rs.getInt("product_id"))
             .console(ProductConsole.valueOf(rs.getString("console")))
             .game(ProductGame.valueOf(rs.getString("game")))
             .price(new BigDecimal(rs.getString("price")))
             .build();
          //@formatter:on
        }
      });
}
}