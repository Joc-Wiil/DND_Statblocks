# DND_Statblocks

## Description:
A Java-based tool that processes player character data from Character Sheets and converts it into accurate monster data for Monster Stat Blocks.
Referencing Wizards of the Coast's Player's Handbook (2024/5.5e) and Dungeon Master's Guide (2014/5e)."

## Features:
- Tracks core class features such as Rage or Action Surge that modifiy or utilize the following, Weapon and Spell Damage, Ability Scores and Ability Modifiers, Initiative, Saving Throws, Proficiency Bonus, optional feats (focused on those that modify the other data points being tracked), Hit Points, Spell Slots, Armor Class, Difficulty Checks, Hit Chance, Skills, Item Magic Modifier, Attacks per Action, Player Levels, and Monster Challenge Ratings.
- Low Priority are Weapon and Spell Range, and Movement Speeds, but will be relevant for greater accuracy monster stat block creation and understanding how to manage players as a DM.

## Tech Stack:
Java, IntelliJ IDEA

## Status:
In Progress

## How to Run:
Run from the main method in IntelliJ IDEA. 
Output is displayed in the IDE's integrated console.

## Usage:
Phase 1 calculates the data of the players characters and Phase 2 converts that into data for the monster characters.
Player character stats are used as the basis for monster stats. 
For example, a player character's hit points inform the monster damage output, and a player character's armor class informs the monster's hit chance.
Data is displayed one level at a time across all 20 player levels and mapped to the 34 monster challenge ratings.

## Roadmap:
- **Phase 1:** Finish creating the player character data calculator.
- **Phase 1:** Create the player character data display code with a focus on data relevant to the character class and features available to that level.
- **Phase 1.5:** Polish and refine Phase 1 output in preparation for Phase 2.
- **Phase 2:** Create a data collector for the player character data and send it to the monster calculator.
- **Phase 2:** Create the monster calculator.

## License:
None.
