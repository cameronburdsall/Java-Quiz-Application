COEN 160 Final Project Usage Instructions

Launching the Application:
	You can run the application from the .jar executable, which will launch it in the JRE.
	You can also recompile by importing the project folder into Eclipse and Running the Login.java 

First Screen:
Select Either the Student or Admin login, the appropriate window will apear after.

Student:

	Enter your name on popup window:
		If you have already used the application, your scores will be imported behind the scenes.
		If not, then a new Student will automatically be created with all scores set to 0.
	Home Page:
		You will recieve a greeting, followed by 4 game options and a Save and Quit Button
		Math:
			Play the math game, you will be prompted with a question and must enter the correct answer.
			You will be asked a total of 5 questions.
			You will need to enter the correct answer to progress, each attempt lowers the score achieved.
			Incorrect answers yield a popup window notifying user of mistake.
		Geography:
			You will need to select which state is being asked from a selection of 4.
			Notification is given when wrong answer selected.
			You will be asked 5 questions.
		Animals:
			From a drop down menu, select which animal is which.
			Incorrect Responses will yield a popup. 
			You will be asked 4 questions.
		Puzzle:
			Press submit on first popup.
			Move the pieces by dragging and dropping with mouse.
			Form the full picture by arranging in proper order.
			Press check when you think you have the solution, incorrect will yield a popup.
		Save and Quit:
			Saves student data via serialization and terminates the application.

Admin:
	Defualt admin is: Name: Bill, Password: apple
	New admin accounts can be created by entering "newadmin" without quotation marks.
		The default password will then be set to admin, can be changed from Admin Home Page
	Upon entering credentials, if they are legitamate, a Admin Home Page will be launched. 
		If not, you will be notified via popup that credentials are not accepted
	Home Page:
		Show All Students:
			Displays a list of all student users and their overall grades
		Individual Student Scores:
			Displays a popup asking for a student name
				Tells user if name is not found
			Then displays a window with the point totals for each category.
		Change Score:
			Same as Individual Student Scores, except adds another popup to select a score to change.
		Change <user's> Password: 
			Asks user for current password and new password. Current must be correct to change.
		Add Question:
			Allows user to add a Math question to the Math game. 
		Save and Exit:
			Saves all changes to students to the students.ser file.
			Also saves any admin changes to the admins.ser file.
