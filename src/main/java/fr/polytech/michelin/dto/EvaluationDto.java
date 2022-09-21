package fr.polytech.michelin.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
// import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.polytech.michelin.entity.EvaluationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EvaluationDto {
    @JsonProperty("id")
    @Min(value = 0)
    private int id;

    @JsonProperty("nom")
    @Size(max = 50)
    private String nom;

    @JsonProperty("commentaire")
    @Size(max = 255)
    private String commentaire;

    @JsonProperty("note")
    @Min(value = 0, message = "Note should not be less than 0")
    @Max(value = 3, message = "Note should not be greater than 3")
    private int note;

    public static EvaluationDto fromEntity(EvaluationEntity entity) {
        return EvaluationDto.builder()
                            .id(entity.getId())
                            .nom(entity.getNom())
                            .commentaire(entity.getCommentaire())
                            .note(entity.getNote())
                            .build();
    }

}
