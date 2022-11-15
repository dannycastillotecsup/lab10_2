package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);


	@Autowired
	private OwnerService ownerService;

	/**
	 * 
	 */
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "Leo";
		Owner owner = null;
		
		try {
			owner = ownerService.findById(ID);
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		
		logger.info("" + owner);
		assertThat(owner.getFirstName(), is(NAME));

	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByName() {

		String FIND_NAME = "Leo";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByfirst_name(FIND_NAME);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerBylast_name() {

		String last_name = "Huayta";
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findBylast_name(last_name);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}
	
	@Test
	public void testFindOwnerByAddress() {

		String address = "JhefersonHC";
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findByaddress(address);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}
	
	
	
	@Test
	public void testFindOwnerByCity() {

		String city = "Lima";
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findBycity(city);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}
	
	@Test
	public void testFindOwnerByTelephone() {

		String telephone = "990692179";
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findBytelephone(telephone);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}
	
	
	
	

	/**
	 * 
	 */

	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreateOwner() {
		int id = 1;
		String first_name="Jheferson";
		String last_name = "Huayta";
		String city = "Lima";
		String address = "Jheferson";
		String telephone = "990692179";
		
		Owner owner = new Owner(id, first_name, last_name, city,address,telephone);
		Owner ownerCreatea = OwnerServiceTest.create(owner);
		logger.info("Owner CREATED :" + ownerCreatea);
				
	}


	private static Owner create(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 */
	@Test
	public void testUpdatePet() {
		 
		int Id=1;
		String first_name="Jheferson";
		String last_name="Huayta";
		String city ="Lima";
		String address="JefersonHC";
		String telephone="990692179";
		
		

		Owner owner = new Owner(Id,first_name,last_name,city,address,telephone);

		// Create record
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		logger.info(">>" + ownerCreated);

		long create_id = ownerCreated.getId();

		// Prepare data for update
		ownerCreated.setFirstName(first_name);
		ownerCreated.setlastName(last_name);
		ownerCreated.setCity(city);
		ownerCreated.setAdress(address);
		ownerCreated.setTelephone(telephone);

		// Execute update
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);

		//        ACTUAL       EXPECTED
		assertThat(create_id ,notNullValue());
		assertThat(upgradeOwner.getId(), is(create_id));
		assertThat(upgradeOwner.getFirstName(), is(first_name));
		assertThat(upgradeOwner.getlastName(), is(last_name));
		assertThat(upgradeOwner.getCity(), is(city));
		assertThat(upgradeOwner.getTelephone(), is(telephone));
	}
	/**
	 * 
	 */
	@Test
	public void testDeleteOwner() {

		long ID = 1;
		String FIRST_NAME = "Jheferson";
		String LAST_NAME = "Huayta";
		String CITY = "Lima";
		String TELEPHONE = "990692179";

		Owner owner = new Owner(ID,FIRST_NAME,LAST_NAME,CITY,TELEPHONE,null);
		owner = ownerService.create(owner);
		logger.info("" + owner);
		
		
		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			ownerService.findById(owner.getId());
			fail("Owner id = " + owner.getId() + " has not delete");
		} catch (OwnerNotFoundException e) {
		} 				


	
	}


	
	
	
	
	//@Autowired
   //	private OwnerService ownerService;

	/**
	 * 
	 */
	/*
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "Jaime";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnertNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertEquals(NAME, owner.getName());

	}
	*/
}
