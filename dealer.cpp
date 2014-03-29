///////////////////////////////////////////////////////////////////////////////
// File:   dealer.cpp                  Spring 2014
// Author: Patrick Vargas              patrick.vargas@colorado.edu
// Description:
//    Provides the manager for the card game
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
  Dealer::Dealer( Game &g )
  {
    game_ = &g;
    deck_.set_info( game_->decks(), game_->jokers() );
    Player board("Board");
    board_ = board;
  }

  //
  // Member Methods
  //
  // Post: Player has been added to the game
  void Dealer::register( void *player )
  {
    players_.push_front( &player );
  }

  // Post: Dealer prints the state of the game
  void Dealer::print( )
  {
    list<Player>::const_iterator it, end;
    deck_.print();
    cout << board_ << endl;

    if ( !players_.empty() )
    {
      for ( ; it != end; ++it ) {
        cout << *it << endl;
      }
    }
  }
}
///////////////////////////////////////////////////////////////////////////////
