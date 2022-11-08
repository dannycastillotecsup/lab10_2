package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {

	Owner create(Owner pet);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner pet);

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
	List<Owner> findByName(String first_name);

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	List<Owner> findByLastName(String last_name);

	/**
	 * 
	 * @return
	 */
	List<Owner> findByAdress(String adress);

	/**
	 * 
	 * @return
	 */
	List<Owner> findByCity(String city);

	/**
	 * 
	 * @return
	 */
	List<Owner> findByTelephone(String telephone);

	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();
}
