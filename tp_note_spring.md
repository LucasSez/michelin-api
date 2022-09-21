# Examen Backend de la formation Fullstack De Polytech (5A)

**Lisez bien l'énoncé avant de vous lancer.**

## Introduction

Le guide Michelin a décidé de mettre à jour son application web permettant de gérer les
restaurants visités et leur classement.

Grâce à vos compétences, vous avez été choisis pour effectuer cette tâche.
Dans un premier temps, vous devez créer leur API a l'aide de la technologie Springboot (Java 8 ou plus).

Vous pouvez bien sûr créer un nouveau projet à partir de https://start.spring.io/

## Définitions

Un **restaurant** est caractérisé par :

- un identifiant unique (un nombre entier positif)
- Un nom (longueur max de 90 caractères)
- Une adresse (longueur max de 255 caractères)
- Une liste d'**évaluations**

Une **évaluation** est caractérisée par :

- un identifiant unique (un nombre entier positif)
- Le nom de l'évaluateur (longueur max de 50 caractères)
- Le commentaire (longueur max de 255 caractères)
- Le nombre d'étoiles recommandé (0,1,2 ou 3) appellée "note"

## Cahier des charges

L'API doit exposer les fonctionnalitées suivantes :

#### Restaurants

- La possibilité de récupérer tous les restaurants\*
- La possibilité de récupérer un restaurant en particulier\*
- La possibilité de créer un restaurant\*
- La possibilité de mettre à jour le nom et l'adresse d'un restaurant

#### Evaluations

- La possibilité d'ajouter une évaluation sur un restaurant
- La possibilité de supprimer une évaluation

Les routes retournant un (ou plusieurs) restaurant (marquées par \*) doivent aussi retourner la moyenne des notes du-dit restaurant dans une propriété nommée "moyenne". Si le restaurant ne dispose d'aucune evaluation, la moyenne est de -1.

Les cas d'erreur doivent être gérés pour retourner une erreur (404, 500, etc) contenant :

- Un code
- Un message expliquant l'erreur

#### Tests

- Les services et les controllers doivent être testés

#### Swagger

L'api doit exposer un swagger décrivant ses différentes routes

## Bonus

Soit la fonction Java suivante :

```Java
public void test(String a, String b) {
  System.out.println(a == b);
}
```

Si on appelle cette fonction, quel resultat sera affiché dans la console et pourquoi ? (Oui, il y a plusieurs cas)
Mettez la réponse dans un fichier Readme.md a la racine de votre projet

## Conseils supplémentaires

- Planifiez bien les tâches que vous devrez faire afin d'organiser au mieux vos dossiers et votre code dès le début.
- Mieux vaut faire peu correctement que beaucoup salement.
- Vous ne faites pas du code seulement pour vous-même mais aussi pour qu'il puisse être compris par quelqu'un d'autre, notamment moi.
- Les commentaires expliquant ce que vous faites sont bien sûr les bienvenus.
- Pour les tests, pensez bien à couvrir un maximum de cas (restaurant avec et sans evaluations, etc...)
- Vous avez accès à votre précédent travail et à internet.
- En revanche, votre dignité vous interdit de faire appel à vos camarades.
- La question bonus est, comme son nom l'indique, un bonus. Ne la faites que si vous avez terminé tout le reste.
