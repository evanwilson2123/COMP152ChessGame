# Chess COMP152

## Project Organization

The project consists of the following classes:

- **Chess:** The main class that sets up the frame and initializes the board array.
- **BoardComponent:** Draws the squares and the pieces in their current positions.
- **BoardMouseListener:** Identifies which piece is selected by the user’s mouse and calls the appropriate methods to move it.
- **Piece:** An abstract class modeling an individual piece.
- **Pawn, King, Queen, Bishop, Rook, Knight:** Subclasses of Piece.

## Steps Completed

### Step 1: Setting up the board

1. **Chess Class:** Created the main class to set up the JFrame and initialize the board array.
2. **BoardComponent Class:** Implemented a nested for-loop to draw the squares of the chessboard using specified colors (233, 174, 95) and (177, 113, 24).
3. **Chessboard Display:** Displayed a checkerboard pattern on the JFrame.

### Step 2: Draw a single piece

1. **Piece Display:** Verified piece drawing by displaying a white rook at the bottom left square.
2. **Initialization:** Removed the test code after verification for use in subsequent steps.

### Step 3: Setting up and displaying the pieces

1. **Piece Array:** Managed the board as an 8x8 array of Piece in the Chess class (`public static Piece[][] position = new Piece[8][8];`).
2. **Piece Classes:** Created an abstract class Piece with an ImageIcon, color, and drawPiece() method. Extended Piece to create Pawn, King, Queen, Bishop, Rook, and Knight classes.
3. **Initial Positions:** Initialized each piece in its starting position in the Chess class.
4. **Draw Pieces:** Implemented the drawPiece() method to draw the ImageIcon at given coordinates using a Graphics object.
5. **BoardComponent Update:** Modified BoardComponent to iterate through the position array and call drawPiece() for each non-null entry.

### Step 4: Selecting a piece with the mouse and moving it

1. **BoardMouseListener Class:** Created the class to handle mouse events.
2. **Piece Selection:** Implemented mousePressed to determine which piece is selected and store its coordinates.
3. **Move Piece:** Implemented mouseReleased to determine the destination square and move the piece by updating the position array and calling repaint().

### Step 5: Limiting movements

1. **Bounds Check:** Added checks in mouseReleased to ensure start and end coordinates are within the range 0 to 7.
2. **Same Square Check:** Prevented moves to the same square.
3. **Piece Existence Check:** Ensured there is an actual piece at the start coordinate before moving.
4. **Color Check:** Ensured the piece being moved is white (player's piece).

### Step 6: Make a random computer player

1. **Random Move:** Implemented a method to make a random move for the computer (black pieces) immediately after the player moves.
2. **Move Logic:** The computer randomly selects a coordinate, checks if it has a piece, and tries to move it following the same rules as the player.

### Step 7: Only allow valid moves

1. **canMove Method:** Created an abstract boolean method canMove in the Piece class to check if a proposed move is valid.
2. **Subclass Implementations:** Implemented the canMove method in each subclass of Piece, ensuring each piece follows its movement rules.
3. **Move Validation:** Revised mouseReleased to call canMove before moving a piece, and also updated the computer player to call canMove.

### Additional Features and Enhancements

- **Enhanced AI:** (Optional) Created a better AI for the computer player, prioritizing capturing moves over non-capturing moves

## Compilation and Execution

- Ensure all necessary images (.gif files) are placed in the correct directory.
- Compile the project using a Java IDE or command line.
- Run the Chess class to start the game.

## Conclusion

This project implements a functional chess game with a graphical interface and basic AI, following the assignment's steps. The game allows for human vs. computer play, with proper move validation and piece-specific movement rules.
