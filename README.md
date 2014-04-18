Object Oriented Analysis and Design
===================================

We are creating a card game framework. This framework will allow people to create card games and play with them. We will go ahead and implement a game of Euchre.

Members
-------

**Hannah Tuell**

*    BS Computer Science, Software Engineering
*    BA Studio Art, Drawing
*    [hannah.tuell@colorado.edu][tuell]

**Patrick E. Vargas**

*   BS Computer Science, Software Engineering  
    *   Atmospheric and Oceanic Science Minor  
    *   Technology, Arts and Media Minor  
*   (720) 515 - 6402  
*   [www.vargascorpus.com][vargasweb]  
*   [patrick@vargascorpus.com][vargas]  

**Justin Woodward**

*   [justin.woodward@colorado.edu][woodward]

Commands
--------

### Build ###

      make

### Clean ###

      make clean

### Execute Program ###

      ./cardgame

Directory
---------

*  `Makefile` Builds the executable
*  `main.cpp` Starts the Program
*  `README.md` This file.
*  `bicycle.a` This file is an archive of the card game framework.
   - `card.cpp` The basic card class. Stores things like suit, value and rank. 
   - `deck.cpp` Holds a collection of cards.
   - `player.cpp` This is the player UI and opponent AI constituents of the game.
   - `game.cpp` This is the generic class for how the games are played.
   - `euchre.cpp` This is an instantiated game class which implements the game, Euchre, the card game of Indiana.
*  `CSCIx229.a` Archive library of OpenGL graphical helper functions, provided by Prof. Schreüder.
   - `print.c` Print
   - `fatal.c` Fatal
   - `loadtexbmp.c` LoadTexBMP
   - `project.c` Project
   - `errcheck.c` ErrCheck
   - `object.c` LoadOBJ
* `visuals.h` Library interface for drawing a card game



  [tuell]:     mailto:hannah.tuell@colorado.edu
  [vargas]:    mailto:patrick@vargascorpus.com
  [vargasweb]: http://www.vargascorpus.com
  [woodward]:  mailto:justin.woodward@colorado.edu
