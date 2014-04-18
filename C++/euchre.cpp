///////////////////////////////////////////////////////////////////////////////
// File:   euchre.cpp                    Spring 2014
// Author: Patrick Vargas              patrick.vargas@colorado.edu
// Description:
//    Provides the point value and rules of the game at play
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
#include "bicycle.h"
 ///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
namespace bicycle
{
  Euchre::Euchre() {
    decks_     = 1;
    jokers_    = false;
    init_hand_ = 5;
    trumps_    = JOKERS;
  }
  Deck Euchre::set_deck( ) {
    list<Card> draw;
    Card temp;
    Deck result;
    short size = 0;

    for ( int j = 0; j < 52; ++j ) {
      temp.rank( ( j % 13 ) + 1 );

      if ( j < 13 )      { temp.suit( SPADES );   }
      else if ( j < 26 ) { temp.suit( DIAMONDS ); }
      else if ( j < 39 ) { temp.suit( CLUBS );    }
      else               { temp.suit( HEARTS );   }

      switch ( j % 13 + 1 ) {
        case 1:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
          size++;
          draw.push_back( temp );
          break;
      }
    }

    result.set_draw( draw );
    result.set_size( size );

    return result;
  }
}
///////////////////////////////////////////////////////////////////////////////
