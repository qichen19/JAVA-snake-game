## JAVA Snake Game
Welcome to the Java Snake Game, a classic yet enchanting experience with a cute and adorable user interface developed using JAVA Swing GUI. This project was a collaborative effort by Yunyang Li, Xiaoge Fan, and Qi Chen.

## Game Description
The game begins with a warm-up session every time a new program session is initiated. Users control the snake's movement using arrow keys, where input in the opposite direction of the snake's current movement won't trigger a direction change. The newborn baby snake starts with a length of 3, and each apple consumed adds +1 to the score, increasing the snake's body length.

## Levels and Challenges
#### Level 1 - The Forest (5 <= score < 10):

Three types of food: apple (+1 score), pear (+2 score), peach (+3 score).
Spiky cacti serve as themed obstacles, increasing difficulty.
Game over conditions: snake hits the boundary, cacti, or itself.
#### Level 2 - The Ocean (10 <= score < 15):

Three types of food: shrimp (+1 score), crab (+2 score), bomb (-2 score).
Bombs act as bait, disappearing if not eaten after a set time.
Spiky sea urchins introduce added challenges.
Game over conditions: snake hits the boundary, sea urchins, or itself.
#### Level 3 - The Outerspace (score >= 15):

One type of food: star (+3 score).
Increased speed and randomly falling meteors add an extra layer of difficulty.
Meteor impacts reduce the score to 15 and reset the snake's length to 3.
Game over conditions: snake hits the boundary, itself, or is struck by a meteor.
## End of Game
After the game concludes, players receive a summary of their current round score. If a new high score is achieved, a "New high score!" message congratulates the player. Users have the option to either exit the game or start a new round.

## How to Play
Simply download the snakegame.jar file.
In your terminal, run ```java -jar snakegame.jar```.
Enjoy the charming world of the Java Snake Game!

