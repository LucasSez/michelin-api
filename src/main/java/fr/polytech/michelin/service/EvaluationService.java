package fr.polytech.michelin.service;

import fr.polytech.michelin.entity.EvaluationEntity;
import fr.polytech.michelin.entity.RestaurantEntity;
import fr.polytech.michelin.exception.ResourceDoesntExistException;
import fr.polytech.michelin.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity getEvaluationById(int id) {
        return this.evaluationRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesntExistException("Evaluation with id " + id + " doesn't exist."));
    }

    public EvaluationEntity addEvaluation(int restaurantId, String nomEvaluateur, String commentaireEvaluation, int noteEvaluation) {
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity nouvelleEvaluation = EvaluationEntity.builder()
                                                                    .nom(nomEvaluateur)
                                                                    .commentaire(commentaireEvaluation)
                                                                    .note(noteEvaluation)
                                                                    .restaurant(restaurant)
                                                                    .build();

        return this.evaluationRepository.save(nouvelleEvaluation);
    }

    public boolean deleteEvaluation(int restaurantId, int evaluationId) {
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity evaluation = getEvaluationById(evaluationId);
        
        if( restaurant == null || evaluation == null) {
            return false;
        } else {
            this.evaluationRepository.delete(evaluation);
            return true;
        }
    }
    
}
