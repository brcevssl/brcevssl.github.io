# CRM


<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->


## Présentation du projet

Technologies utilisées : Java 17, Spring, REST API, React, React Bootstrap, Hibernate, MySQL, JavaScript, et un pipeline CI/CD intégrant des contrôles de sécurité (CodeQL) et de qualité du code (Super-Linter), avec reporting de la couverture du code sur Codecov.

## Technologies clés

**Backend**: Java 17, Spring, REST API, Hibernate, MySQL  
**Frontend**: React, React Bootstrap, JavaScript  
**CI/CD**: GitHub Actions, CodeQL, Super-Linter, Codecov  

## Structure du projet

### Organisation du projet :

#### Back-end

Implémente les fonctionnalités principales de l'application CRM.

- **Data Access Layer (DAL)**: Utilise Hibernate pour interagir avec la base de données MySQL, en employant des opérations CRUD (Create, Read, Update, Delete) pour gérer les données des clients.
- **Business Logic Layer (BLL)**: Encapsule les règles métier et la logique pour gérer les processus liés au CRM.
- **REST API Layer**: Expose les fonctionnalités de l'application via une API RESTful, permettant l'interaction avec les données CRM à partir de systèmes externes ou de composants front-end.

#### Front-end

Construit l'interface utilisateur en utilisant React et React Bootstrap.

- **Composants**: Des composants React réutilisables pour les éléments d'interface utilisateur tels que les tableaux, les formulaires, les graphiques et autres éléments visuels.
- **Routage**: Gère la navigation entre les différentes sections de l'application en utilisant React Router.
- **Récupération de données**: Utilisation de l'API REST pour récupérer et afficher les données, permettant aux utilisateurs d'interagir avec les informations du CRM.

#### CI/CD avec GitHub Actions

**`.github/workflows/codeql.yml`**: Ce workflow permet d'automatiser des analyses de sécurité régulières à l'aide de CodeQL.

Éléments clés du fichier:

- **`name`**: Le nom du workflow est défini comme "CodeQL".
- **`on`**: Le workflow est déclenché dans plusieurs situations:
  - **`push`**: Déclenche le workflow lors d'un push vers la branche principale (main).
  - **`pull_request`**: Déclenche le workflow lors de la création d'une pull request vers la branche principale (main).
  - **`schedule`**: Exécution quotidienne de l'analyse à 16h16 (cron: '16 16 * * 0').

- **`jobs`**: Le workflow définit un job "analyze".
  - **`analyze`**: Ce job effectue les analyses de sécurité.
    - **`name`**: Le nom du job est défini comme "Analyze (${{ matrix.language }})". La mention entre parenthèses indique qu'il peut analyser différents langages selon la configuration.
    - **`runs-on`**: L'exécution du job dépend du langage analysé. Par défaut, il s'exécute sur Ubuntu, sauf pour Swift qui nécessite un runner utilisant macOS comme OS.
    - **`timeout-minutes`**: Le temps d'exécution maximum est défini en minutes (360 minutes par défaut, pouvant aller jusqu'à 120 minutes pour Swift).
    - **`permissions`**: Gestion des permissions dont le job requiert pour écrire les événements liés à la sécurité en analysant les packages, les actions (workflows Github) et le contenu du repository.
    - **`strategy`**: La stratégie d'exécution pour les différents langages.
      - **`fail-fast`**: La configuration est définie sur 'false' pour permettre l'analyse de tous les langages configurés même si l'un d'eux échoue.
      - **`matrix.include`**: La liste des langages à analyser. Actuellement, le fichier prend en charge Java/Kotlin et JavaScript/TypeScript.
  - **`steps`**: Les étapes du job d'analyse:
    - **`Checkout repository`**: Récupère le code source du dépôt GitHub.
    - **`Initialize CodeQL`**: Initialise l'utilisation de CodeQL en spécifiant les langages à analyser et le mode de build.
    - **`Setup Java JDK`**: Installe le  JDK Java 17 si l'un des langages analysés correspond à Java ou Kotlin.
    - **`Manual Build Instructions (optionnel)`**: Si le mode de build est défini comme 'manual', cette étape permet d'ajouter des instructions de build spécifiques au projet.
    - **`Perform CodeQL Analysis`**: Lance l'analyse de sécurité du code avec CodeQL en ciblant la catégorie appropriée en fonction du langage analysé.

## Build et exécution de l'application

### Cloner le référentiel

```sh
git clone https://github.com/user/repo  
```

### Configuration du backend

Installer Java 17 et configurer l'environnement de développement Java.

### Accéder au répertoire backend et compiler le projet en utilisant Maven

```sh
mvn clean install
```

### Configuration du frontend

Accéder au répertoire frontend et installer les dépendances en utilisant npm:

```sh
npm install
```

### Démarrer le serveur de développement

```sh
npm start
```

### Configuration de la base de données

#### Création de la base de données 

Créer une base de données MySQL et configurer les détails de connexion dans le fichier de configuration `application.properties`.

#### Configuration du fichier `application.properties`

```sh
spring.application.name=<nom du projet>

spring.datasource.url=jdbc:mysql://localhost:<port>/<nom de la base de données>
spring.datasource.username=<nom d\'utilisateur>
spring.datasource.password=<mot de passe>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

- `spring.application.name`: Définissez le nom de votre application Spring Boot. Ce nom est utilisé à des fins d'identification et de journalisation.

- `spring.datasource.url`: Spécifiez l'URL de connexion à la base de données MySQL. Remplacez <port>, <nom de la base de données> et localhost par les valeurs correspondantes.

- `spring.datasource.username`: Indiquez le nom d'utilisateur pour vous connecter à la base de données MySQL. N'oubliez pas de remplacer le champ par votre nom d'utilisateur.

- `spring.datasource.password`: Définissez le mot de passe pour vous connecter à la base de données MySQL. N'oubliez pas de remplacer le champ par votre mot de passe.

### Exécuter l'application

Accéder à l'application dans votre navigateur Web en utilisant l'URL appropriée.
