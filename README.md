# Simple Hangman Game 

**Description**<br /> 
- This is a simple hangman game allowing the user to provide a word/phrase to be guessed, 
where another user can then select letters from the dropdown to guess individual 
letters in the word/phrase. Each time an incorrect letter is guessed, a body part of 
a stick figure is displayed. The user has 7 guesses before the game is over. The 
user can restart the game at any time to enter and play with a new word/phrase. 
- Future iterations of this game will allow for a user to select single-player or 
multi-player versions of the game. Currently, this application is intended to be 
used with more than one person, but a single-player version would provide the user 
with a random word/phrase to guess. 
- I programmed this game as an upgraded iteration of a previous hangman game I had 
worked on. In this version, I allowed for more direct user interaction by allowing 
a user to provide the word/phrase to be guessed, select the letters to guess, and 
press a restart button to start a new game. My implementation of a graphical user 
interface allows for this enhanced interaction. 
- I was also motivated to build this program as a way to apply concepts from the 
Northeastern University CS3500 class (Object Oriented Design) on my own. Here, I 
was able to implement the Model-View-Controller design pattern to separate the 
functionalities of the game and to allow for more versatility and flexibility for 
enhancing the game's current functionality. 
- One difficulty of designing the game was figuring out how to represent 
each data type in order to have the program implement certain functionalities. For 
example, the user types in a word/phrase as a String, but I decided to represent 
the word/phrase as a list of Strings while the user guesses letters to make it a
bit simpler to update the word/phrase as guesses are made. 
- The most challenging part of designing the program was displaying the body parts 
one at a time in response to the user's selection of a letter. To implement this, 
I used the command design pattern, where I created a hashmap of Integer to Command 
objects, with each command object containing a method to draw a body part. The 
body parts being drawn were then dependent upon the number of remaining guesses the 
user had, as the program loops through as many times as guesses remaining there are, 
drawing a body part each time. I had to get creative with this part of the program, 
but the command design pattern allows for more body parts to be added in future 
implementations of the game. 

**Installation**<br />
- This program does not require installation. 

**How to Use**<br />
- To use, run the RunHangman.java file. 

