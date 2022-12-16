## [](https://github.com/biong40/COMP2042_CW_hfygl1) 2048


1. Your name and student number, 
 Liong Gele (20303556)



2. How to compile the code to produce the application?
   Download JavaFX SDK from open source. To make sure the source cose is runnable in Intellij IDEA, the JavaFX bunndles plugin must be enabled. Make sure. Select the JDK that will be use for the project. Open the main method and debug the configurations. In this project, com.project_2048.Main is asisgned as the project name. Run the application through the "com.project_2048.Main" method. THe IDE starts ocmpiling the codes. When the application window appears, it is completed.



3. Where your Javadoc documentation is stored (the path to the directory) 
   FILE:\\COMP2042LiongGele\JavaDoc\com.project_2048\module-summary



4. A list of features that are implemented and are working properly,
Features:

a.Scene builder:
- switch scene from Start Screen to game Scene.
- switch scene from game Scene to Victory Scene or Defeat Scene.
- switch scene from Victory Scene or Defeat Scene to EndGame Scene;

b. Score incrementation bugs is fixed.
- the score will only add on if there is any addition operation happens.

c. Game scene Colour changing.
- using fxml function with the helpout Colour Picker, it will change whenever the player play it. 

d. " The difficulty of the game " is created.
- the player could play in 4x4, 5x5 or 6x6 boxes of 2048 games.

e. Score board is shown in the end scene.
- Load and save score on score board into file.
- Every time player can see how many their score.

f. Cell bugs is fixed.
- no more any randomly spawned cell when it does not move. 

g. J unit ( test ) is created and Build files are created too. 

h. Quit game method also is implemented.

j. have a howtoPlay tutorial Scene and also explanation about the concept of 2048 games.



5. A list of features that are implemented and are not working properly,

a. the Number of Cell that should be set as default 4x4
    - but I try to use n = 4 as the base of 4x4, the game could not run through the 5x5 grid and 6x6 grid too. I should the in bound of the grid is 4.
    - However, if i change to n= 6 the base of 6x6, the game could run all the difficulty 4x4, 5x5 and 6x6 too.



6. A list of features, if any, that are not implemented with an explanation of why they were not implemented,
a. High Score Board
    - it need to include Arraylist, separate the Username and Score to compare      the High score and Store it back to the files.
    - it is not implemented is because of using the correct method to separate the Username and Score and cannot find the way to store it back to the same files.
   
b. Account:
    - compare the same Account and update his own player score instead of adding on the same account name.
    - it is not implemented is because of using the correct method to separate the Username and Score and cannot find the way to store it back to the same files.
    


7. A list of new Java classes that you introduced for the assignment,
 
a.  Controller Class.</br>
b.  initializable class.
c.  singleSington class.</br>
 
 
 
8. A list of Java classes that you modified from the given code base

a. Account class (deleted)
b. Quit Game (deleted)
c. GameScene (added a lot of logic code)
   - modify the Grid of the game
   - modify the score of the game ( fix the bug )
   - modify the game(), which lead to the load fxml file ( either Victory or Defeat scene )
   - the bug mostly is fixed in the Game Scene like the randon spawn cell when any key is pressed, the score. 
d. Main 
   - the game scene and game root code is transfered to the our Controller class
   - the code with related to end game, Menu and account is deleted because it doesn't use in the project.
   - add the FXMl load to load the start screen which is created as a FXML file named "Scene2".
e. Cell 
   - modify the adder and the changeCell by adding if statement and condition.
   - this will be use when there is empty cell, if the cell is not moved and the no addition operation happen.
   - No random spawn of cell.
   - modify the score of the game ( fix the bug )
f. TextMaker
   - no much modify is ust change the size of the text.
  
