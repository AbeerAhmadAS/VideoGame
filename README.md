# Video Game System
[Presentation](https://docs.google.com/presentation/d/1WFH-f5g4sDzrNarR49ZVdJQ5dc5_Iof44dC7xLShhys/edit?usp=sharing)

![Java](https://img.shields.io/badge/Java-11-green)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5-blue)

This repository contains Video Game System project built with Java and Spring Boot. The project is designed to manage and organize information about video games, including details about designer, game and player. It also allows  different users to interact with each other.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Code Structure](#code-structure)  <!-- Corrected anchor link -->
- [Usage](#usage)
- [UML](#uml)  <!-- Corrected anchor link -->
- [Configuration](#configuration)
- [Contact](#contact)
- [Resources](#resources)


## Overview

This video game System project is built using Java and Spring Boot, and it provides a RESTful API for managing video game system information. It allows adding, modifying, and deleting a designer. It also allows games with the ability to link them to their own designer. It can also create multiple players with the ability to link them to several games.
## Features
- Designers: The user can add a new designer by entering all his data, and he can also modify it and delete this designer.

- Game: The user can enter a new game, adding all its data, linking it to a designer, and he can also delete it.

- Player: The user can enter a new player and also enter all his data with the ability to link him to the games he prefers.

## Getting Started

To get started with this project, you will need to have Java and Spring Boot set up on your local development environment. You can follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/your-game-library.git](https://github.com/HUDAAYOUB/ProjectGameLibrary.git)https://github.com/HUDAAYOUB/ProjectGameLibrary.git
   cd your-game-library

## Code Structure

### Controllers:

- DesignerController.java: Manages endpoints related to designer operations.
- GameController.java: Manages endpoints related to game operations
- PlayerController.java: Handles Player-related endpoints.
  
### Model:

- Designer.java: Represents the designer entity with attributes like id, name, email, and nationality.
- game.java: Represents the game entity with attributes like id, name, type, and device Game Running On.
- player.java: Represents the player entity with attributes like id, name, email, and age.

### Repository:

- DesignerRepository.java: Provides data access methods for the Designer entity.
- GameRepository.java: Provides data access methods for the Game entity.
- PlayerRepository.java: Provides data access methods for the Player entity.

### Service:

- DesignerService.java: Contains business logic for designer-related operations.
- GameService.java: Implements business logic for game-related operations.
- PlayerService.java: Implements business logic for Player-related operations.

### Resources:

- application.properties: Configuration file for setting up the database and other properties.

  
### Tests:

- Unit test classes for controllers, repositories.
  
### Other Project Files:


- pom.xml: Maven configuration file for project dependencies and build settings.
- Other project-specific files and directories as needed.

## Usage

To use this project, you can interact with the API endpoints through tools like Postman or by creating your own front-end application. Here are some sample API endpoints:

GET /designer: Retrieve a list of all designers.

GET /designer/{designerId}: Retrieve a specific designer by its ID.s.

GET /designer/designerName/{designerName}: Retrieve a specific designer by its name.

PUT/designer/{designerId} :Update an existing designer.

PATCH/designer/designerName/{designerId} :Update name of designer.

DELETE/designer/{designerId} : Delete designer.

POST/designer: Add new designer.

GET /games: Retrieve a list of all games.

GET /games/id/{gameId}: Retrieve a specific game by its ID.s.

GET /game/{deviceGameRunningOn}: Retrieve a specific game by  name of device that running the game.

GET /games/designerName/{designerName}: Retrieve a specific game by  name of designer of the game.

PUT/games/{gameID} :Update an existing game.

PATCH/games/gamePrice/{gameID} :Update price of game.

DELETE/games/{gameID} : Delete game .

POST/games: Add new game.

GET /player: Retrieve a list of all players.

GET /player/id/{playerID}: Retrieve a specific player by its ID.s.

GET /player/gameName/{gameName}: Retrieve a specific player by  name of game.

PUT/player/{playerID} :Update an existing player.

PATCH/player/playerAge/{playerID} :Update Age of player.

DELETE/player/{playerID} : Delete player .

POST/player: Add new player.



## UML

| Use case                                  | Database                                                 | Class      
|-------------------------------------------|----------------------------------------------------------|------------
| <img src = "https://github.com/HUDAAYOUB/ProjectGameLibrary/blob/main/11.png" > | <img src = "https://github.com/HUDAAYOUB/ProjectGameLibrary/blob/main/game%20-%20games_library.png" hight="100%" width="350%"> | <img src = "https://github.com/HUDAAYOUB/ProjectGameLibrary/blob/main/12.png">


## Configuration
The project uses a PostgreSQL database, and you may need to configure the database connection details in the application.properties file. Additionally, the project includes validation constraints and error messages for input data, which you can customize if needed.

## Resources

[wikipedia](https://www.wikipedia.org/)
[Code Java](https://www.codejava.net/spring-boot-tutorials)
[Java T point](https://www.javatpoint.com/)
[Canva](https://www.canva.com/)
[ChatGPT](https://chat.openai.com/)


## Contact
For any questions or inquiries related to this project, you can contact the project maintainer:

GitHub: [HUDAAYOUB](https://github.com/HUDAAYOUB)
