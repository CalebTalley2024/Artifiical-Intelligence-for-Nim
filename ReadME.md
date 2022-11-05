# Bonus Questions
- Real name of the game: Nim
- Who solved the game: Charles Bouton

# Instructions

## User Commands
### Startup
- You can decide who starts the game first: You (the user), or the CPU
### CPU levels
- You will be able to decide the CPU level that you play against
    - if you type "1" when prompted, you will face the CPU with easy (random) difficulty
        - - Random: does random moves
    - if you type "2" when prompted, you will face the CPU with Hard  difficulty
    - Hard: Will make the most optimal legal move each turn it gets.
    - To have a chance to win, you will have to.....
        - play perfectly
        - have to play first 

### Color
- You will be asked to pick **one** out of the **three** colors (green, yellow and orange)
- You can pick a color by typing it's first letter in the terminal
    - Example: if you want to remove a green markers, write `g` in the terminal when prompted
### Amount to remove
- After being asked about what colored markers set you want to remove from, you will be asked how many you want to remove
- Just type the number of markers that you want to remove

    - Example: if I want to remove 3 markers, just write `3` in the terminal when prompted
### Bounds
#### Color
- You should only pick the letters `g`, `y`, and `o`
    - Type any other letters into the terminal and the game will not work.
#### Amount to remove
- You should only remove an amount that is less than or equal to the size of the marker set
    - typing any number greater than the marker set size will not work.
    - Example: you will get an error if you try to get rid of 4 markers in the green marker set(where there are only 3 markers).
