# Patterns and frameworks assignment 2
I have made a new version of 'poorrail' from scratch.
The tools I used for making 'richrail' is:

 - NetBeans IDE
 - JavaFX GUI framework

I have chosen to use the following architecture:
 
- Model-view-(mechanics?)

Also I implemented the following design patterns:

-	Singleton pattern (CommandParser, TrainFacade)
-	Observable pattern (Trainfacade (for updating tabs and objectview)
-	Factory pattern (ShapeFactory)
-	Facade pattern (TrainFacade)
-	Command pattern (The commands that the CommandParser will call)


## CLI
run `src/views/command_line_interface/UserInterface.java`

**NOTE**: To remove existing trains and wagons uncomment line 41-54 in src/views/command_line_interface/UserInterface.java

Commands:

| Command                                                | Example                                           |
|--------------------------------------------------------|---------------------------------------------------|
| new train \<trainname\>                                | new train train1                                  |
| new wagon \<wagonname\> [numseats \<number of seats\>] | new wagon wagon1 <br>new wagon wagon2 numseats 25 |
| new passenger wagon \<wagonname\>                      | new passenger wagon wagon1                        |
| new freight wagon \<wagonname\>                        | new freight wagon wagon1                          |
| add \<wagonname\> to \<trainname\>                     | add wagon1 to train1                              |
| remove \<wagonname\> from \<trainname\>                | remove wagon1 from train1                         |
| getnumseats train \<trainname\>                        | getnumseats train train1                          |
| getnumseats wagon \<wagonname\>                        | getnumseats wagon wagon1                          |
| delete train \<trainname\>                             | delete train train1                               |
| delete wagon \<wagonname\>                             | delete wagon wagon1                               |

## GUI
run `src/views/graphical_user_interface/UserInterface.java`

**NOTE**: To remove existing trains and wagons uncomment line 41-54 in src/views/command_line_interface/UserInterface.java
