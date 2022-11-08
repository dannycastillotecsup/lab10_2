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
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);


	@Autowired
	private OwnerService ownerService;

	/**
	 * 
	 */
	@Test
	public void testFindPetById() {

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

		List<Owner> owners = ownerService.findByName(FIND_NAME);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerBylast_name() {

		int TYPE_ID = 5;
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findByLastName(TYPE_ID);

		assertThat(owners.size(), is(SIZE_EXPECTED));
	}

	/**
	 * 
	 */
	@Test
	public void testFindPetByOwnerId() {

		int OWNER_ID = 10;
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findById(OWNER_ID);

		assertThat(owners.size(), is(SIZE_EXPECTED));
		
	}

	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreateOwner() {

		String OWNER_NAME = "Ponky";
		int OWNER_ID = 1;
		int TYPE_ID = 1;

		Owner owner = new Owner(OWNER_NAME, 1, 1);
		
		Owner ownerCreated = ownerService.create(owner);
		
		logger.info("OWNER CREATED :" + ownerCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(ownerCreated.getId()      , notNullValue());
		assertThat(ownerCreated.getFirstName()    , is(PET_NAME));
		assertThat(ownerCreated.getId() , is(OWNER_ID));
		assertThat(ownerCreated.getId()  , is(TYPE_ID));

	}

	
	/**
	 * 
	 */
	@Test
	public void testUpdateOwner() {

		String PET_NAME = "Bear";
		int OWNER_ID = 1;
		int TYPE_ID = 1;
		long create_id = -1;

		String UP_PET_NAME = "Bear2";
		int UP_OWNER_ID = 2;
		int UP_TYPE_ID = 2;

		Owner owner = new Owner(PET_NAME, OWNER_ID, TYPE_ID);

		// Create record
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		logger.info(">>" + ownerCreated);

		create_id = ownerCreated.getId();

		// Prepare data for update
		ownerCreated.setFirstName(UP_PET_NAME);
		ownerCreated.setId(UP_OWNER_ID);
		ownerCreated.setId(UP_TYPE_ID);

		// Execute update
		Owner upgradePet = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradePet);

		//        ACTUAL       EXPECTED
		assertThat(create_id ,notNullValue());
		assertThat(upgradePet.getId(), is(create_id));
		assertThat(upgradePet.getFirstName(), is(UP_PET_NAME));
		assertThat(upgradePet.getId(), is(UP_OWNER_ID));
		assertThat(upgradePet.getId(), is(UP_TYPE_ID));
	}

	/**
	 * 
	 */
	@Test
	public void testDeleteOwner() {

		String PET_NAME = "Bird";
		int OWNER_ID = 1;
		int TYPE_ID = 1;

		Owner owner = new Owner(PET_NAME, OWNER_ID, TYPE_ID);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			ownerService.findById(owner.getId());
			fail("Pet id = " + owner.getId() + " has not delete");
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
