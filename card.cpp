///////////////////////////////////////////////////////////////////////////////
// File:   card.cpp                    Summer 2013
// Author: Patrick Vargas              patrick.vargas@colorado.edu
// Description:
//    Provides a basic card class for use in a card game program or simulation.
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
#include "bicycle.h"
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
namespace bicycle {
  //
  // Constructors
  //
  // Legal Values Include
  //   rank: 1-14; 1 default
  //   suit: SPADES, DIAMONDS, CLUBS, HEARTS; Spades by default
  //   value: Any value based on game or simulation; 0 by default
  //   isFaceUp: Boolean; False (or down) by default
  Card::Card ( short rankInit, short suitInit, bool isFaceUpInit, short valueInit ) {
    rank_     = rankInit;
    suit_     = suitInit;
    value_    = valueInit;
    isFaceUp_ = isFaceUpInit;
  }

  //
  // Member Methods // Getters
  // 
  const bool  Card::isFaceUp( ) { return isFaceUp_; }
  const short Card::rank( )     { return rank_;     }
  const short Card::suit( )     { return suit_;     }
  const short Card::value( )    { return value_;    }

  //
  // Member Methods // Setters
  //
  // Pre: Must be a boolean
  void Card::isFaceUp( bool temp ) {
    assert( temp == true || temp == false );
    isFaceUp_ = temp;
  }

  // Pre: Must Be a value between 1 and 14
  void Card::rank( short temp ) {
    assert( temp >= 1 && temp <= 14 );
    rank_ = temp;
  }

  // Pre: Must be a value in enum Suit
  void Card::suit( short temp ) {
    assert( temp == SPADES || temp == DIAMONDS || temp == CLUBS || temp == HEARTS || temp == JOKERS );
    suit_ = temp;
  }

  // Pre: Can be any value
  void Card::value( short temp ) { value_ = temp; }

  //
  // Auxiliary Methods
  //
  // Post: Flips card over
  void Card::flip( ) { isFaceUp ( !isFaceUp_ ); }

  // Post: Prints the necessary information
  const char * Card::print( ) {
    stringstream ss;
    string rank, suit;
    
    switch ( rank_ ) {
      case 14:  rank = "Joker"; break;
      case 13:  rank = "King";  break;
      case 12:  rank = "Queen"; break;
      case 11:  rank = "Jack";  break;
      case  1:  rank = "Ace";   break;
      default:
        ss << rank_;
        rank = ss.str();
        break;
    }
    
    switch ( suit_ )
    {
      case SPADES:    suit = "Spades";    break;
      case DIAMONDS:  suit = "Diamonds";  break;
      case CLUBS:     suit = "Clubs";     break;
      default:        suit = "Hearts";    break;
    }
    
    ss.clear();
    ss << rank << " of " << suit;
    
    return ss.str().c_str();
  }
}
///////////////////////////////////////////////////////////////////////////////
