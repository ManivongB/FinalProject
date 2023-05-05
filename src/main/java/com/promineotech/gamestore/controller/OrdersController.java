package com.promineotech.gamestore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gamestore.entity.Orders;
import com.promineotech.gamestore.entity.Dto.OrdersDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "WELCOME TO THE GAMING STORE"),
servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface OrdersController {
  // @formatter:off
  @Operation(
      summary = "Returns list of Orders",
      description = "Returns a list of orders",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "List of Orders returned okay",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Orders.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "An Order component was not found with the input criteria",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json")),
      }
      )
     @GetMapping
     @ResponseStatus(code = HttpStatus.OK)
     List<Orders>fetchOrders();
  
  @Operation(
      summary = "Returns list of Orders",
      description = "Returns a list of orders",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "List of Orders returned okay",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Orders.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "An Order component was not found with the input criteria",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json")),
      },
        parameters = {
          @Parameter(
            name = "Customer Id",
            allowEmptyValue = false,
            required = false,
            description = "Customer Id information")
        }
      )
  @GetMapping("/getOrders")
  @ResponseStatus(code = HttpStatus.OK)
  List<Orders> fetchOrderByCustomerId(String customerId);
  
  @Operation(
      summary = "Create Orders",
      description = "Return created orders",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Order was created",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Orders.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Input invalid, order not created",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json")),
      }
      )
  @PostMapping("/createOrder")
  @ResponseStatus(code = HttpStatus.CREATED)
  Orders createOrder(@Valid OrdersDto orderDto);
  
  @Operation(
      summary = "Update an order",
      description = "Returns updated orders",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Order updated",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Orders.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "An Order was not updated",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json")),
      }
      )
  @PutMapping("/updateOrder")
  @ResponseStatus(code = HttpStatus.OK)
  Orders updateOrder(@Valid OrdersDto orderDto);
  
  @Operation(
      summary = "Delete an order",
      description = "Delete an order",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Order was Deleted",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Orders.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Order couldn't be deleted",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json")),
      }
      )
  @DeleteMapping("/deleteOrder")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteOrder(@Valid OrdersDto orderDto);
  // @formatter:on


}

