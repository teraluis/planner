# Application de Réservation de Salles - COVID-19

Cette application est conçue pour gérer la réservation de salles en tenant compte des contraintes liées au COVID-19. Elle est développée avec Java 17 et Spring Boot.

## Fonctionnalités

- **Réservation de salles** : Permet aux utilisateurs de réserver une salle pour des créneaux d'une heure entre 8h00-18h.
- **Gestion des capacités** : Les capacités des salles sont ajustées en fonction des directives sanitaires pour assurer la distanciation sociale.

## Prérequis

- Java 17
- Maven
- Postman

## Configuration

1. Clonez le dépôt : `git clone https://github.com/teraluis/planner.git`
2. Naviguez dans le répertoire du projet : `cd planner`

4. Construisez l'application : `mvn clean install`

## Lancement

- Lancez l'application avec Spring Boot : `mvn spring-boot:run` ou via eclipse executez PlannerApplication.java
- Accédez à l'application via : `http://localhost:8080`
- Accédez au swagger via : `http://localhost:8080/swagger-ui.html` ou `http://localhost:8080/api-docs`
- Importez la collection postman qui se trouve à la racine du projet

## Utilisation

Pour réserver une salle, consultez le swagger d'application ou la collection postman à la racine du projet.

## Contribution

Les contributions sont les bienvenues. Veuillez soumettre vos pull requests sur la branche `develop`.
