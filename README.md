# My Personal Project

## Fitness App

A *bulleted* list:
- What will the application do?  


The application will help users track their macronutrients and weight as well building a 
workout plan for the day depending on what the user wants to train. They can also manually
select home workouts listed and build it themselves. Anyone of all ages can use this application
and it interests me to build this application because I like to workout.



- As a User, I want to be able to see my caloric intake 
- As a User, I want to be able to see the workouts in organized categories
- As a User, I want to be able to generate a workout plan for the day
- As a User, I want to be able to have a favourites list
As a user, I want to be able to save my favourites list to file
As a user, I want to be able to be able to load my favourites list from file 

P4 Task 2 choice: 
- Include a type hierarchy in your code other than the one that uses the Saveable interface
 introduced in Phase 2.  You must have more than one subclass and your subclasses must have distinct functionality.  
 They must therefore override at least one method inherited from a super type and override 
 it in different ways in each of the subclasses.
  - "WorkoutsGui" is an abstract class with multiple methods. To reduce duplication within my project, 
  I made every Workout a subclass of WorkoutsGui. The distinct functionality includes, the pictures its loading,
  and  the click method, which changes the label and icon accordingly. The main functionality of "WorkoutsGUI"
  is setting up the panels, buttons, and similar functionality between the different types of workouts.

P4: Task 3.
please see .data/UML_Design_Diagram.pdf

- if i had more time with this profject i would have refactored a lot of things
- first, in Gui, i would refactor MenuGui to a superclass and have WorkoutMenu be a subclass of that
- second, I would make refactor many methods within workoutApp class as there are many duplicate codes
- third, I would make more helper methods to increase the readability within my project.

