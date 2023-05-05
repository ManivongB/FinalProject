package com.promineotech.gamestore.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gamestore.entity.ProductOrders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@Validated
@RequestMapping("/ProductOrders")
public interface ProductOrdersController {
  
  // @formatter:off
  @Operation(summary = "Return list of products ordered",
      description = "Returns list of product orders",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "List of products orders",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ProductOrders.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The parameters requested are not valid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No product orders found",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")),
      }
      
      )
  @GetMapping("/getProductOrders")
  @ResponseStatus(code = HttpStatus.OK)
  List<ProductOrders> fetchProductOrders();


}
