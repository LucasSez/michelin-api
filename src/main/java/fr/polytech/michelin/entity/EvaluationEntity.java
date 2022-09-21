package fr.polytech.michelin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Evaluation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "note")
    private int note;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantEntity restaurant;

}
