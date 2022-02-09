package com.shantanu.personaddrmgmt.service;


import com.shantanu.personaddrmgmt.model.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author shantanu
 */
public interface MysqlRepository extends JpaRepository<PersonAddress,Integer>
{
    
}
