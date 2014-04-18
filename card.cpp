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
  Card::Card ( short rankInit, short suitInit, bool isFaceUpInit, short valueInit, Point p) {
    rank_     = rankInit;
    suit_     = suitInit;
    value_    = valueInit;
    isFaceUp_ = isFaceUpInit;
    position_ = p;
  }

  //
  // Member Methods // Getters
  // 
  const bool   Card::isFaceUp( ) { return isFaceUp_; }
  const short  Card::rank( )     { return rank_;     }
  const short  Card::suit( )     { return suit_;     }
  const short  Card::value( )    { return value_;    }
  const Point  Card::position( ) { return position_; }

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

  // Pre: Can be any position in the window
  void Card::position( Point temp ) { position_ = temp; }

  //
  // Auxiliary Methods
  //
  // Post: Flips card over
  void Card::flip( ) { isFaceUp ( !isFaceUp_ ); }

  // Post: Prints the necessary information
  void Card::print( ) {
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
    
    cout << rank << " of " << suit;
  }

  // Post: Card has been outputted to ostream
  ostream &operator<<( ostream &output, const Card &c )
  { 
    switch ( c.rank_ ) {
      case 14:  output << "O";     break;
      case 13:  output << "K";     break;
      case 12:  output << "Q";     break;
      case 11:  output << "J";     break;
      case  1:  output << "A";     break;
      default:  output << c.rank_; break;
    }

    // output << " of ";
    
    switch ( c.suit_ )
    {
      case SPADES:    output << "S"; break;
      case DIAMONDS:  output << "D"; break;
      case CLUBS:     output << "C"; break;
      default:        output << "H"; break;
    }

    return output;            
  }
}
///////////////////////////////////////////////////////////////////////////////
