# Animal Villa
## Design Document

## Contributors :
- Elizabeth Bissinger
- Chloe(Cass) Motz
- Jake Plagge
- Kelli Porter

## Scrum Roles :
- DevOps/Product Owner/Scrum Master: Kelli Porter
- Frontend Developer: Elizabeth Bissinger
- Integration Developer: Jake Plagge, Chloe(Cass) Motz

## Meeting Schedule :
- Wednesdays @ 6:00 PM via Microsoft Teams
- Sundays @ Any Time via Microsoft Teams (As Needed)

| Week | Topic | Elizabeth | Cass | Jake | Kelli |
| --- | --- | --- | --- | --- | --- |
| 1 (5/11/22) | Sprint 0 Start | --- | --- | --- | --- |
| 2 (5/18/22) | Forming Groups/Design Doc | Attended | Attended | Attended | Attended |
| 3 (5/25/22)| Sprint 1 Start | Attended | Attended | Attended | Attended |
| 4 (6/1/22)| Story Building and Sudo Code | --- | --- | --- | --- |
| 5 (6/8/22)| info | --- | --- | --- | --- |
| 6 (6/15/22)| info | --- | --- | --- | --- |
| 7 (6/22/22)| Sprint 2 Start | --- | --- | --- | --- |
| 8 (6/29/22)| info | --- | --- | --- | --- |
| 9 (7/6/22) | info | --- | --- | --- | --- |
| 10 (7/13/22) | info | --- | --- | --- | --- |
| 11 (7/20/22) | Sprint 3 Start | --- | --- | --- | --- |
| 12 (7/27/22) | info | --- | --- | --- | --- |
| 13 (8/3/22) | info | --- | --- | --- | --- |
| 14 (8/10/22) | info | --- | --- | --- | --- |
| 15 (8/17/22) | info | --- | --- | --- | --- |

## Introduction :
You have just moved into the town of Animal Villa! Introductions can be hard, but your neighbors seem friendly. Choose how you interact with your fellow animal friends and make meaningful relationships! Beware of creating a bad reputation for yourself, and make sure to keep track of your finances. There are a lot of new faces to see, places to visit, and connections to be made!
- Randomly generated scenarios and multiple endings
- Room for different play styles
- A cast of cutesy animal folk

## Functional Requirements :
### Requirement 1 - Navigating and Making Choices :
#### Scenario :
- As a player, I want to be able to swipe left and right to make quick and easy decisions

#### Dependencies :
- Navigation and choice making will be smooth and consistant
- Choices will have a YES or NO responce

#### Assumptions : 
- Players will be presented with two choices

#### Examples :
1. Making Choices
   - Given two choices on the screen
   - When a player wants to make a choice
   - The player will swipe left for NO and right for YES

### Requirement 2 - Saving Your Progress :
#### Scenario :
- As a player, I want to be able to save my progress

#### Dependencies :
- Saving progress will be automatic
- The game should save to the app or to a signed in account

#### Assumptions : 
- The player does not get to create a manual save

#### Examples :
1. Closing the App
   - Given the player wants to quit the game
   - When a player closes the applicaiton
   - The player's progress will be stored in the application or in an online cloud

### Requirement 3 - Changing Settings :
#### Scenario : 
- As a player, I want to be able to change the settings of the game

#### Dependencies:
- Adjusting the volume of the game
- Changing text speed

#### Assumptions:
- The background music is too loud/soft
- The sound effects are too soft
- The text speed is too slow/fast

#### Examples:
1. Turn On/Off background music
   - Given the ability to adjust the volume to a higher or lower setting
   - When a player wants to adjust the volume
   - The player can easily access the music settings
2. Turn On/Off sound effects
   - Given the ability to adjust the volume to a higher or lower setting
   - When the player wants to adjust the volume
   - The player can easily access the sound effect settings
3. Change the text speed 
   - Given the ability to adjust the text speed of the incoming prompts
   - When a player is having difficulties reading the prompt 
   - The player can easily access the text speed settings


## Class Diagram
![Class Diagram](https://github.com/portekn/Mobile-Device-Programming-Animal-Villa/blob/73444f57bbc2ccc11019ab19554065e46bbda7d6/Images/Animal-Villa-Class-Diagram-Final.png)

## Class Diagram Descriptions:
**Title:** The first screen the user sees. This is the title screen for the game.

**MainActivity:** This will host the actual game and the screen the user will interact most with.

**Choice 1:** One of two choices the player can make. Affects the storyline to a directed ending.

**Choice 2:**  One of two choices the player can make. Affects the storyline to a directed ending.

**Saving:** The automatic saving for the game.

**IheartAffectDAO:** Interface for the heart interaction choices for the story.

**IchaosAffectDAO:** Interface for the chaos (negative) interaction choices for the story.

**ImoneyAffectDAO:** Interface for the money interaction choices for the story.

## Story Board
![Story Board Gameplay](https://github.com/portekn/Mobile-Device-Programming-Animal-Villa/blob/73444f57bbc2ccc11019ab19554065e46bbda7d6/Images/storyboard%20idea.PNG)
![Story Board Title](https://github.com/portekn/Mobile-Device-Programming-Animal-Villa/blob/73444f57bbc2ccc11019ab19554065e46bbda7d6/Images/storyboard%20title.PNG)
