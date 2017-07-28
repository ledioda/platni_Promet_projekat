package com.iktpreobuka.platni_promet.repositories;

import org.springframework.data.repository.CrudRepository;
import com.iktpreobuka.platni_promet.entities.BankEntity;


public interface BankRepository extends CrudRepository<BankEntity, Integer>{

	BankEntity findFirstByNameIgnoreCase (String name);
	
	BankEntity findFirstByPibIgnoreCase (String pib);
}