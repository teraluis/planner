# Application de Réservation de Salles - COVID-19

Cette application est conçue pour gérer la réservation de salles en tenant compte des contraintes liées au COVID-19. Elle est développée avec Java 17 et Spring Boot.

## Fonctionnalités

- **Réservation de salles** : Permet aux utilisateurs de réserver une salle pour des créneaux d'une heure entre 8h00-18h en respectant les normes sanitaires.
- **Gestion des capacités** : Les capacités des salles sont ajustées en fonction des directives sanitaires pour assurer la distanciation sociale.

## Prérequis

- Java 17
- Maven
- Postman

## Configuration

1. Clonez le dépôt : `git clone https://github.com/teraluis/planner.git`
2. Naviguez dans le répertoire du projet : `cd planner`

4. Construisez l'application : `mvn update`, `mvn clean install`


## Generation du jar (optionel)
- `java -jar` ou `mvn clean package` cela va generer un fichier jar sur target
-  `cd planner/target`
- `java -jar PlannnerStarter.jar`

## Lancement Planner Starter
- Lancez l'application avec Spring Boot : `mvn spring-boot:run`
- Accédez à l'application via : `http://localhost:8080`
- Accédez au swagger JSON : `http://localhost:8080/api-docs`
- Accédez au swagger YML : `http://localhost:8080/api-docs.yaml`
- Accédez au swagger ui: `http://localhost:8080/swagger-ui/index.html`
- Importez la collection postman qui se trouve à la racine du projet si vous voulez tester l'application facielement

## Utilisation

Pour réserver une salle, consultez le swagger d'application ou la collection postman à la racine du projet.

## Contribution

Les contributions sont les bienvenues. Veuillez soumettre vos pull requests sur la branche `develop`.
