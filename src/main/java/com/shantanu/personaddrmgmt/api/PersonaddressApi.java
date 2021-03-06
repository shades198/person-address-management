/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.shantanu.personaddrmgmt.api;

import com.shantanu.personaddrmgmt.model.PersonAddress;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-02-09T06:18:00.153Z[GMT]")
@Validated
public interface PersonaddressApi {

    @Operation(summary = "Add a new person address", description = "", tags={ "personaddress" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Person address saved"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/personaddress",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> addPersonAddress(@Parameter(in = ParameterIn.DEFAULT, description = "Person address to be saved", required=true, schema=@Schema()) @Valid @RequestBody PersonAddress body);


    @Operation(summary = "", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Person address deleted"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/personaddress",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePersonAddress(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "personId", required = true) Integer personId);


    @Operation(summary = "Add a new person address", description = "", tags={ "getPersonaddress" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Person address found", content = @Content(mediaType = "text/json", array = @ArraySchema(schema = @Schema(implementation = PersonAddress.class)))),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/personaddress",
        produces = { "text/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> getPersonAddress(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true) @Valid @RequestParam(value = "personId", required = true) Integer personId);


    @Operation(summary = "Add a new person address", description = "", tags={ "personaddress" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Person address updated"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/personaddress",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePersonAddress(@Parameter(in = ParameterIn.DEFAULT, description = "Person address to be updated", required=true, schema=@Schema()) @Valid @RequestBody PersonAddress body);

}

