package com.promineotech.gamestore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gamestore.entity.Customer;
import com.promineotech.gamestore.entity.Dto.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/customer")
public interface CustomerController {
  
  // @formatter:off
  @Operation(
      summary = "Returns list of customers",
      description = "Returns list of customers",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "List of customers gets returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Customer.class))),
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No customers were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
      }
      )
  @GetMapping("/getCustomers")
  @ResponseStatus(code = HttpStatus.OK)
  List<Customer> fetchCustomers();
/**
 * 
 */
  @Operation(
      summary = "Returns lists of customers by name", 
      description = "Returns the list of customers",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of customers gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No customers were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }  , 
      parameters = {
          @Parameter(
              name = "customerName", 
              allowEmptyValue = false,
              required = false,
              description = "Customer Name")
      }
      )
  @GetMapping("/getCustomerByName")
  @ResponseStatus(code = HttpStatus.OK)
  List<Customer> fetchCustomerByFirstNameLastNameCustomers(
      String customerFirstNameLastNameString);
  /**
   * 
   */
  @Operation(
      summary = "Creates a new customer", 
      description = "Returns created customer",
      responses = {
          @ApiResponse(
              responseCode= "201", 
              description= "A customer was created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to create a new customer", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }
      )
  
  @PostMapping("/createCustomer")
  @ResponseStatus(code = HttpStatus.CREATED)
  Customer createCustomer(@Valid @RequestBody CustomerDto customerDto);
  /**
   * 
   */
  @Operation(
      summary = "Updates a customer", 
      description = "Returns the updated customer",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A customer was updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to update customer with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }  
)
  @PutMapping("/updateCustomer")
  @ResponseStatus(code = HttpStatus.OK)
  Customer updateCustomer(@Valid @RequestBody CustomerDto customerDto);
  /**
   * 
   */
  @Operation(
      summary = "Delete a customer", 
      description = "Deletes a customer",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "Customer was deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to delete customer", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
      )
  @DeleteMapping("/deleteCustomer")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteCustomer(@Valid @RequestBody CustomerDto customerDto);
}
  
  
  
  