///////////////////////////////////////////////////////////////////////////////
// File:   deck.cpp                    Summer 2013
// Author: Patrick Vargas              patrick.vargas@colorado.edu
// Description:
//    Provides a basic deck class for use in a card game program or simulation.
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
#include "bicycle.h"
 ///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
namespace bicycle
{
  //
  // Constructor
  //
  // Pre: Number of standard decks, if jokers are needed.
  Deck::Deck ( short decks, bool needJokers )
  {
    Card temp;
    hasJokers_ = needJokers;
    int decktotal = hasJokers_ ? STDDECKWJ : STDDECK;
    size_ = decktotal * decks;

    for ( int i = 0; i < decks; ++i ) {
      for ( int j = 0; j < decktotal; ++j ) {
        temp.rank( ( j % 13 ) + 1 );

        if ( j < 13 )      { temp.suit( SPADES );   }
        else if ( j < 26 ) { temp.suit( DIAMONDS ); }
        else if ( j < 39 ) { temp.suit( CLUBS );    }
        else if ( j < 52 ) { temp.suit( HEARTS );   }
        else               { temp.suit( JOKERS );   }

        draw_.push_back( temp );
      }
    }
  }

  //
  // Member Methods
  //
  // Post: The new draw deck has been set.
  void Deck::set_draw( list<Card> list ) {
    draw_ = list;
  }

  // Post: Private variables have been changed.
  void Deck::set_info( int decks, bool needJokers ) { 
    hasJokers_ = needJokers;
    int decktotal = hasJokers_ ? STDDECKWJ : STDDECK;
    size_ = decktotal * decks;
  }

  // Post: The size of the deck has been set.
  void Deck::set_size( short size ) {
    size_ = size;
  }
  // Post: The number of cards remaining is returned.
  short Deck::get_cards_left( ) { return draw_.size( ); }

  // Pre:  There must be at least one card in discard pile.
  // Post: Cards from the discard pile and draw pile have been shuffled together.
  void Deck::combine( )
  {
    list<Card>::iterator it;

    // Check for any cards in pile
    if ( discard_.size( ) == 0 ) return;

    // Add the pile
    for ( it = discard_.begin(); it != discard_.end(); ++it )
      draw_.push_back( *it );

    discard_.clear( );

    // Shuffle new deck
    shuffle( );
  }

  // Pre:  There must be at least one card in draw pile.
  // Post: The top card is given and removed from the draw pile,
  //       decreasing the number of cards left.
  Card Deck::deal( )
  {
    Card temp;

    // Make sure cards are available
    if ( draw_.empty( ) ) combine( );

    temp = draw_.front( );
    draw_.pop_front();
    return temp;
  }

  // Pre:  Player is discarding a card.
  void Deck::discard( Card garbage ) { discard_.push_front( garbage ); }

  // Post: Deck is in factory order: A - K; S, D, C, H.
  void Deck::reset( )
  {
    Deck temp ( size_ / ( hasJokers_ ? STDDECKWJ : STDDECK ), hasJokers_ );
    combine( );
    draw_ = temp.draw_;
  }

  // Pre:  There is at least one card in the draw pile.
  void Deck::shuffle( )
  {
    short randomCard;
    list<Card> temp;
    list<Card>::iterator it;

    while ( !draw_.empty( ) ) {
      srand( (int) time( NULL ) );
      randomCard = (short) ( rand( ) % draw_.size( ) );

      it = draw_.begin();
      advance( it, randomCard );

      temp.push_back( *it );
      draw_.erase( it );
    }

    draw_ = temp;
  }

  // Post: The contents of the deck have been printed
  void Deck::print( ) {
    list<Card>::iterator it, end;
    cout << "*** Draw Deck ***" << endl;
    it  = draw_.begin();
    end = draw_.end();

    for ( ; it != end; ++it ) {
      cout << *it << ", ";
    }

    cout << endl << "*** Discard Deck ***" << endl;
    it  = discard_.begin();
    end = discard_.end();
    for ( ; it != end; ++it ) {
      cout << *it << ", ";
    }
    cout << endl;
  }
}
///////////////////////////////////////////////////////////////////////////////
