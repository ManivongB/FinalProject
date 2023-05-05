package com.promineotech.gamestore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gamestore.entity.Employees;
import com.promineotech.gamestore.entity.Dto.EmployeesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface EmployeesController {
  
//@formatter:off
 @Operation(
     summary = "Returns list of Employees",
     description = "Returns a list of employees",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "List of employees returned okay",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Employees.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "An employee component was not found with the input criteria",
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
    List<Employees>fetchEmployee();
 
 @Operation(
     summary = "Returns list of employees",
     description = "Returns a list of employees",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "List of employees returned okay",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Employees.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "A employees component was not found with the input criteria",
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
           name = "Employee Id",
           allowEmptyValue = false,
           required = false,
           description = "Employee Id information")
       }
     )
 @GetMapping("/getEmployee")
 @ResponseStatus(code = HttpStatus.OK)
 List<Employees> fetchEmployeeByName(String employeeName);
 
 @Operation(
     summary = "Create employee",
     description = "Return created employee",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "An employee was created",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Employees.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "Input invalid, employee not created",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occurred",
             content = @Content(
                 mediaType = "application/json")),
     }
     )
 @PostMapping("/createEmployee")
 @ResponseStatus(code = HttpStatus.CREATED)
 Employees createEmployee(@Valid EmployeesDto employeesDto);
 
 @Operation(
     summary = "Update an employee",
     description = "Returns updated employee",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "Employee updated",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Employees.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "An Employee was not updated",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occurred",
             content = @Content(
                 mediaType = "application/json")),
     }
     )
 @PutMapping("/updateEmployees")
 @ResponseStatus(code = HttpStatus.OK)
 Employees updateEmployee(@Valid EmployeesDto employeesDto);
 
 @Operation(
     summary = "Delete an Employee",
     description = "Delete an Employee",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "Employee was Deleted",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = Employees.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "Employee couldn't be deleted",
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occurred",
             content = @Content(
                 mediaType = "application/json")),
     }
     )
 @DeleteMapping("/deleteEmployee")
 @ResponseStatus(code = HttpStatus.OK)
 void deleteEmployee(@Valid EmployeesDto employeesDto);
 // @formatter:on

}
