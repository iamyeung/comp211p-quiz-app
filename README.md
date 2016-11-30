# comp211p-quiz-app

The program currently goes like this.
1. Start Screen (MainActivity.java)
Press Single Player
2. Single Player Screen (SinglePlayerInputName.java)
Enter Name
3. Question Page Screen (QuestionPage.java)
Press Q1
4. Quiz 1 Screen (QuizInterface.java)


JT made the following changes on November 30, 2016:
Fix 1: You can now enter your name, and a personal greeting can be made in the subsequent question page.
Fix 2: All buttons are disabled from pressing after making your choice in the quiz page interface.
Fix 3: After making your choice in the quiz page interface, you will automatically be directed back to the question page in 3500ms (3.5s) OR if you press the "Return to Question Page" button [whichever is faster]


Annette should make:
1. Quiz 2 Screen (preferrably QuizInterface2.java)
2. Quiz 3 Screen (preferrably QuizInterface3.java)
3. Quiz 4 Screen (preferrably QuizInterface4.java)
4. Quiz 5 Screen (preferrably QuizInterface5.java)
5. A way to count the score (maybe using the GlobalInterface?)
6. Final Score Page
7. High Score Page
8. Multiplayer Page - you'll also need to make another screen for Player 2 to input their name

Note: The 5 questions and answers are stored in the Strings.xml file
When you change the <TextView for Q2, change the android:text value from "@string/Q1" to "@string/Q2" and do the same for the answer.
Also make sure that the Button Q2 on the Question Page Screen links to the QUizInterface2.java screen
