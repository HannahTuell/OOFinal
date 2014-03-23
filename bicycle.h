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
#include <list>
#include <string>
#include <sstream>

using namespace std;

#define STDDECK   52 // Standard Deck
#define STDDECKWJ 54 // With Jokers
enum Suit { SPADES, DIAMONDS, CLUBS, HEARTS, JOKERS };
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
namespace bicycle {

  //=====================================
  // From card.cpp
  //=====================================
  class Card {
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
    const char * print( );

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
  class Deck {
  public:
    //
    // Constructor
    //
    // Pre: Number of standard decks, if jokers are needed.
    Deck ( short decks = 1, bool needJokers = false );

    //
    // Member Methods
    //
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

  private:
    list<Card> draw_;
    list<Card> discard_;
    bool       hasJokers_;
    short      size_;
  };
  //=====================================
}
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
#endif // BICYCLE_H
///////////////////////////////////////////////////////////////////////////////
