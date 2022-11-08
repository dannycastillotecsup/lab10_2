package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {

    Owner create(Owner owner);

    /**
     * 
     * @param owner
     * @return
     */
    Owner update(Owner owner);

    /**
     * 
     * @param id
     * @throws OwnerNotFoundException
     */
    void delete(Long id) throws OwnerNotFoundException;

    /**
     * 
     * @param id
     * @return
     */
    Owner findById(long id) throws OwnerNotFoundException;

    /**
     * 
     * @param name
     * @return
     */
    List<Owner> findByfirst_name(String first_name);

    /**
     * 
     * @param typeId
     * @return
     */
    List<Owner> findBylast_name(String last_name);

    /**
     * 
     * @return
     */
    List<Owner> findByaddress(String adress);

    /**
     * 
     * @return
     */
    List<Owner> findBycity(String city);

    /**
     * 
     * @return
     */
    List<Owner> findBytelephone(String telephone);

    /**
     * 
     * @return
     */
    Iterable<Owner> findAll();
}