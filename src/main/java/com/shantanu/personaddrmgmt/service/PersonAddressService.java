/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shantanu.personaddrmgmt.service;

import com.shantanu.personaddrmgmt.model.PersonAddress;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonAddressService
{
    private static final Logger log = LoggerFactory.getLogger(PersonAddressService.class);
    
    MysqlRepository mysqlRepository;
    
    public PersonAddressService(@Autowired MysqlRepository mysqlRepository)
    {
        this.mysqlRepository = mysqlRepository;
    }
    
    public PersonAddress getAddress(Integer id)
    {
        return mysqlRepository.findById(id).get();
    }
    
    public void saveAddress(PersonAddress personAddress)
    {
        mysqlRepository.save(personAddress);
    }
    
    @Transactional
    public void updateAddress(PersonAddress personAddress)
    {
        mysqlRepository.findById(personAddress.getId())
            .map(existingAddress -> {
                BeanUtils.copyProperties(personAddress, existingAddress);
                log.info("Saving updated address: {}", existingAddress);
                return existingAddress;
            });
    }
    
    public void deleteAddress(Integer id)
    {
        mysqlRepository.deleteById(id);
    }
    
}
