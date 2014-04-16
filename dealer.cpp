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
    deck_ = game_->set_deck();
    Player board("Board");
    board_ = board;
    Player wallace("Wallace");
    partner_ = wallace;
    Player scott("Scott");
    ai1_ = scott;
    Player ramona("Ramona");
    ai2_ = ramona;
  }

  //
  // Member Methods
  //
  // Post: Runs the game
  void Dealer::play( )
  {
    deck_.shuffle();

    for (short i = 0; i < game_->starting_hand(); ++i ) {
      user_.take_card( deck_.deal( ) );
      ai1_.take_card( deck_.deal( ) );
      partner_.take_card( deck_.deal( ) );
      ai2_.take_card( deck_.deal( ) );
    } 

    Card trump = deck_.deal();
    game_->trump( trump.suit() );
    deck_.discard( trump );
    print();
  }


  // Post: Dealer prints the state of the game
  void Dealer::print( )
  {
    if ( game_->trump() != JOKERS ) {
      cout << "The trump is ";
      switch( game_->trump( ) ) {
        case SPADES:
          cout << "Spades" << endl;
          break;
        case DIAMONDS:
          cout << "Diamonds" << endl;
          break;
        case CLUBS:
          cout << "Clubs" << endl;
          break;
        case HEARTS:
          cout << "Hearts" << endl;
          break;
      }
    }
    deck_.print();
    cout << board_   << endl;
    cout << user_    << endl;
    cout << ai1_     << endl;
    cout << partner_ << endl;
    cout << ai2_     << endl;
  }

  // Post: The user has been registered to play
  void Dealer::user( Player &u )
  {
    user_ = u;
    cout << user_.get_name() << " has joined the game" << endl;
  }
}
///////////////////////////////////////////////////////////////////////////////
