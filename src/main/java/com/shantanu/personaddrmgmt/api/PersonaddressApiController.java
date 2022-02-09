package com.shantanu.personaddrmgmt.api;

import com.shantanu.personaddrmgmt.api.PersonaddressApi;
import com.shantanu.personaddrmgmt.model.PersonAddress;
import com.shantanu.personaddrmgmt.service.PersonAddressService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-02-09T06:18:00.153Z[GMT]")
@RestController
public class PersonaddressApiController implements PersonaddressApi
{

    private static final Logger log = LoggerFactory.getLogger(PersonaddressApiController.class);

    private final HttpServletRequest request;

    private PersonAddressService personAddressService;

    @org.springframework.beans.factory.annotation.Autowired
    public PersonaddressApiController(@Autowired PersonAddressService personAddressService, HttpServletRequest request)
    {
        this.personAddressService = personAddressService;
        this.request = request;
    }

    public ResponseEntity<Void> addPersonAddress(@Parameter(in = ParameterIn.DEFAULT, description = "Person address to be saved", required = true, schema = @Schema()) @Valid @RequestBody PersonAddress body)
    {
        String accept = request.getHeader("Accept");
        log.info("Saving person with id {} in database", body.getId());
        personAddressService.saveAddress(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deletePersonAddress(@NotNull @Parameter(in = ParameterIn.QUERY, description = "", required = true, schema = @Schema()) @Valid @RequestParam(value = "personId", required = true) Integer personId)
    {
        String accept = request.getHeader("Accept");
        log.info("Deleting address entry for person-id: {}", personId);
        personAddressService.deleteAddress(personId);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> getPersonAddress(@NotNull @Parameter(in = ParameterIn.QUERY, description = "", required = true) @Valid @RequestParam(value = "personId", required = true) Integer personId)
    {
        log.info("Trying to find address details for person-id: {}", personId);
        PersonAddress address = personAddressService.getAddress(personId);
        if(address != null) {
            return new ResponseEntity(address.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
    }

    public ResponseEntity<Void> updatePersonAddress(@Parameter(in = ParameterIn.DEFAULT, description = "Person address to be updated", required = true, schema = @Schema()) @Valid @RequestBody PersonAddress body)
    {
        String accept = request.getHeader("Accept");
        log.info("Updating Address object for person-id: {}", body.getId());
        personAddressService.updateAddress(body);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
