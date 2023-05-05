package com.promineotech.gamestore.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gamestore.entity.Products;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/gamestore")
public interface ProductsController {

//@formatter:off
 @Operation(
     summary = "Products",
     description = "Products",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "The created Product is returned",
             content = @Content(mediaType = "application/json",
             schema = @Schema(implementation = Products.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "A Product component was not found with the input criteria", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred", 
             content = @Content(mediaType = "application/json"))
     }
    )
 @GetMapping("/getProducts")
 @ResponseStatus(code = HttpStatus.OK)
 List<Products> fetchProducts();

}
