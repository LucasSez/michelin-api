package fr.polytech.michelin.service;

import fr.polytech.michelin.entity.EvaluationEntity;
import fr.polytech.michelin.entity.RestaurantEntity;
import fr.polytech.michelin.exception.InvalidValueException;
import fr.polytech.michelin.exception.ResourceDoesntExistException;
import fr.polytech.michelin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    
    public RestaurantEntity getRestaurantById(int id) {
        return this.restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesntExistException("Restaurant with id " + id + " doesn't exist."));
    }

    public List<RestaurantEntity> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity addRestaurant(final String nom, final String adresse) {
        final RestaurantEntity nouveauRestaurant = RestaurantEntity.builder()
                                                                   .nom(nom)
                                                                   .adresse(adresse)
                                                                   .evaluations(new ArrayList<EvaluationEntity>())
                                                                   .build();
        return this.restaurantRepository.save(nouveauRestaurant);
    }

    public RestaurantEntity updateRestaurant(int id, String nouveauNom, String nouvelleAdresse) {
        if (nouveauNom == null || nouvelleAdresse == null) {
            throw new InvalidValueException("New attributes cannot be empty.");
        }
        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceDoesntExistException("Restaurant with id " + id + " doesn't exist."));
        restaurantToUpdate.setNom(nouveauNom);
        restaurantToUpdate.setAdresse(nouvelleAdresse);
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

}
