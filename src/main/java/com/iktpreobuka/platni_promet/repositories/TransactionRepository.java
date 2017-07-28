package com.iktpreobuka.platni_promet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.platni_promet.entities.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long>{

}
