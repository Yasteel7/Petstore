package com.petstore.Petstore.repository;

import com.petstore.Petstore.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository
    extends CrudRepository<Pet, Long> {
}
