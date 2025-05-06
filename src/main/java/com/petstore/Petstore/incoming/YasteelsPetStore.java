package com.petstore.Petstore.incoming;

import com.petstore.openapi.api.PetApi;
import com.petstore.yasteel.api.PetApiDelegate;
import com.petstore.yasteel.model.Pet;
import com.petstore.Petstore.repository.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class YasteelsPetStore implements PetApiDelegate {

    private final PetApi petApi;
    private final PetRepository petRepository;

    public YasteelsPetStore(PetApi petApi, PetRepository petRepository) {
        this.petApi = petApi;
        this.petRepository = petRepository;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByStatus(List<String> status, List<String> tags) {
        // Build a Map of petId -> breed from your H2 database
        Map<Long, String> petIdToBreed = StreamSupport.stream(petRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(
                        pet -> pet.getId().longValue(), // convert Integer to Long
                        com.petstore.Petstore.models.Pet::getBreed
                ));

        List<Pet> pets = new ArrayList<>();

        if (status != null) {
            List<com.petstore.openapi.model.Pet> petsByStatus = petApi.findPetsByStatus(status);
            pets.addAll(
                    petsByStatus.stream()
                            .limit(20) // Only take the first 20
                            .map(openApiPet -> convertToLocalPet(openApiPet, petIdToBreed))
                            .toList()
            );
        }

        if (tags != null) {
            List<com.petstore.openapi.model.Pet> petsByTags = petApi.findPetsByTags(tags);
            pets.addAll(
                    petsByTags.stream()
                            .limit(20)
                            .map(openApiPet -> convertToLocalPet(openApiPet, petIdToBreed))
                            .toList()
            );
        }

        return ResponseEntity.ok(pets);
    }

    private Pet convertToLocalPet(com.petstore.openapi.model.Pet openApiPet, Map<Long, String> petIdToBreed) {
        Pet pet = new Pet();
        pet.setName(openApiPet.getName()); // Only if your local model has "name"
        pet.setBreed(petIdToBreed.getOrDefault(openApiPet.getId(), "German Shepard"));
        return pet;
    }
}
