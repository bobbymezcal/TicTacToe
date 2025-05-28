Hello Git and GitHub.

This is an attempt to program a basic Tic-Tac-Toe game in Java, as a learning exercise.


Structure of this Program:

GameSession will be the main driver of the program, and will keep track of 
the game session. It will create two Player objects and prompt the user to provide
names, which it will pass to the Players. Player objects will hold their names (as
Strings), their current symbol ('X' or 'O') and how many wins/losses/ties/total
games they have in the current session.

("Player1" and "Player 2" refer only to who is the first player ('X') in the very 
first game. Regardless of who plays as 'X' or 'O' in subsequent games, the players 
assigned will not change numbers.)

GameSession will keep track of the active players, the active game, and will
follow a basic loop that keeps the display updated with the current game state
(pre-game, in-game, between-game, or finished). It will pass prompts to the display
only to get player names and to decide to keep playing or end a session.

            [Stretch: this class could save/restore sessions]

The Game class will manage individual games. They will be initialized with 
player names, win-loss-tie numbers, and which player is which letter. This game object 
will create a new Scoreboard oject that gets passed the player names and their assigned 
letters (which don't change during a game), as well as their wins/losses/ties (which
also don't change until a game is over). It will also create a GameBoard object
that should only contain the actual gameboard - which spaces are empty and which 
are marked with X or O. The Game class will constantly check for a winner or a tie game
and will pass this info up to the session.

Display Class - this class will be in charge of displaying everything on the screen:
    - A scoreboard that shows:
        --A welcome message (before the game begins)

        then, once a game starts:
        --Player names & which letter they are playing
        --How many wins each player has in the current session
        --How many games ended in a tie in the current session
        --Some method of indicating whose turn it is

        --An inter-game message that shows names & scores only

        --A final message (when the user quits) that shows final scores
    
    - A game board that will display instructions before the game begins.
    This will then show the current game board and will update each time 
    a player selects a square (using the numerical keypad) and will mark 
    that player's choice when 0 is entered.

    -A text display that prompts the user for required input.

This display class will call on an InputCollector to get input and will
refresh itself when characters press number keys. When 0 is hit, the 
GameBoard will be updated and the screen will refresh again.