/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shantanu.personaddrmgmt;

import com.shantanu.personaddrmgmt.api.PersonaddressApiController;
import com.shantanu.personaddrmgmt.model.PersonAddress;
import com.shantanu.personaddrmgmt.service.PersonAddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author shantanu
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonaddressApiController.class)
public class PersonAddressControllerTest
{
    @MockBean
    PersonAddressService personAddressService;
    
    @Autowired
    MockMvc mockMvc;
    
    @WithMockUser(value = "spring")
    @Test
    public void testPersonAddressGet() throws Exception
    {
        when(personAddressService.getAddress(ArgumentMatchers.anyInt()))
                .thenReturn(getSamplePersonAddress());
        
        mockMvc.perform(get("/personaddress").param("personId", "123"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getSamplePersonAddress().toString()));
    }
    
    private PersonAddress getSamplePersonAddress()
    {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setAddress1("221-B, Bhandarkar Road");
        personAddress.setAddress2("Borivali-W");
        personAddress.setArea("Borivali Station");
        personAddress.setCity("Mumbai");
        personAddress.setState("Maharashtra");
        personAddress.setPostalCode("400092");
        
        return personAddress;
    }
}
