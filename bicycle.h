///////////////////////////////////////////////////////////////////////////////
// File:   bicycle.h                   Summer 2013
// Author: Patrick Vargas              patrick.vargas@colorado.edu
// Description:
//    Provides the declarations for all the necessary classes for card games
//    and simulation.
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
#ifndef BICYCLE_H
#define BICYCLE_H

#include <cassert>
#include <iostream>
#include <list>
#include <string>
#include <sstream>

using namespace std;

#define STDDECK   52 // Standard Deck
#define STDDECKWJ 54 // With Jokers
enum Suit { SPADES, DIAMONDS, CLUBS, HEARTS, JOKERS };
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
namespace bicycle
{
  //=====================================
  // From card.cpp
  //=====================================
  class Card
  {
  public:
    //
    // Constructor
    //
    Card ( short rankInit = 1, short suitInit = SPADES, bool isFaceUpInit = false, short valueInit = 0 );

    //
    // Member Methods // Getters
    // 
    const bool  isFaceUp( );
    const short rank( );
    const short suit( );
    const short value( );

    //
    // Member Methods // Setters
    // 
    // Pre: Must be a boolean
    void isFaceUp( bool temp );

    // Pre: Must Be a value between 1 and 14
    void rank( short temp );

    // Pre: Must be a value in enum Suit
    void suit( short temp );

    // Pre: Can be any value
    void value( short temp );

    //
    // Auxiliary Methods
    //
    // Post: Flips card over
    void flip( );

    // Post: Prints the necessary information
    void print( );

    // Post: Card has been outputted to ostream
    friend ostream &operator<<( ostream &output, const Card &c );

  private:
    //
    // Private Member Data
    //
    short rank_;     // Rank of Card, 1 - 14
    short suit_;     // Suit of Card, enum Suit
    short value_;    // Game value, based upon game bing played
    bool  isFaceUp_; // Is this card face up?
  };
  //=====================================

  //=====================================
  // From deck.cpp
  //=====================================
  class Deck
  {
  public:
    //
    // Constructor
    //
    // Pre: Number of standard decks, if jokers are needed.
    Deck ( short decks = 1, bool needJokers = false );

    //
    // Member Methods
    //
    // Post: Private variables have been changed.
    void set_info( int decks, bool needJokers );

    // Pre:  There must be at least one card in discard pile.
    // Post: Cards from the discard pile and draw pile have been shuffled together.
    void combine( );

    // Pre:  There must be at least one card in draw pile.
    // Post: The top card is given and removed from the draw pile,
    //       decreasing the number of cards left.
    Card deal( );

    // Pre:  Player is discarding a card.
    void discard( Card garbage );

    // Post: Deck is in factory order: A - K; S, D, C, H.
    void reset( );

    // Pre:  There is at least one card in the draw pile.
    void shuffle( );

    // Post: The contents of the deck have been printed
    void print( );

  private:
    list<Card> draw_;      // Draw pile
    list<Card> discard_;   // Discard Pile
    bool       hasJokers_; // If jokers are in play
    short      size_;      // Total number of cards in play
  };
  //=====================================

  //=====================================
  // From player.cpp
  //=====================================
  class Player
  {
  public:
    //
    // Constructor
    //
    // Pre:  None.
    // Post: A player with player_name is added to the game.
    // Facilities used: cstring
    Player(string player_name = "Anon");
    
    //
    // Member Methods
    //
    // Pre:  None.
    // Post: Returns the player's name.
    // Facilities used: cstring
    string get_name();
    
    // Pre:  Player has at least one card in hand.
    // Post: Player has returned one card from the top of their pile.
    // Facilities used: cassert
    Card discard_card();
    
    // Pre:  None.
    // Post: Player has received one card.
    void take_card( Card new_card );
    
    // Pre:  None.
    // Post: All cards in the player's hand have been returned the deck d.
    void clear_hand( Deck &d );
    
    // 
    //  Friend Methods
    //
    // Pre: None.
    // Post: Player's cards (if any) have been printed to console
    void print( );

    // Post: Card has been outputted to ostream
    friend ostream &operator<<( ostream &output, const Player &p );

  private:
    list<Card> hand_;
    string     name_;
  };
  //=====================================

  //=====================================
  class Game
  {
  public:
    // 
    // Member Methods
    //
    virtual void addValues( Deck &d ) =0;

    // Pre: Number of decks needed
    int decks();

    // Pre: True if jokers are needed
    bool jokers();
  protected:
    short decks_;
    bool  jokers_;
  };
  //=====================================

  //=====================================
  // From euchre.cpp
  //=====================================
  class Euchre : public Game {
  public:
    Euchre();
    void addValues( Deck &d );
  };
  //=====================================

  //=====================================
  // From dealer.cpp
  //=====================================
  class Dealer
  {
  public:
    //
    // Constructor
    //
    Dealer( Game &g );

    //
    // Member Methods
    //
    // Post: Player has been added to the game
    void register( void *player );

    // Post: Dealer prints the state of the game
    void print();
  private:
    list<void *> players_;
    Player board_;
    Deck deck_;
    Game *game_;
  };
  //=====================================
}
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
#endif // BICYCLE_H
///////////////////////////////////////////////////////////////////////////////
