///////////////////////////////////////////////////////////////////////////////
// File:   player.cpp                  Summer 2013
// Author: Patrick Vargas              patrick.vargas@colorado.edu
// Description:
//    Provides a basic player class for use in a card game program or simulation.
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
  // Pre:  None.
  // Post: A player with player_name is added to the game.
  // Facilities used: cstring
  Player::Player(string player_name)
  {
    hand_.clear();
    name_ = player_name;
  }
  
  //
  // Member Methods
  //
  // Pre:  None.
  // Post: Returns the player's name.
  // Facilities used: cstring
  string Player::get_name() { return name_; }
  
  // Pre:  Player has at least one card in hand.
  // Post: Player has returned one card from the top of their pile.
  // Facilities used: cassert
  Card Player::discard_card()
  {
    Card temp;
    
    assert(!hand_.empty());
    
    temp = hand_.front();
    hand_.pop_front();
    return temp;
  }
  
  // Pre:  None.
  // Post: Player has received one card.
  void Player::take_card( Card new_card )
  {
    hand_.push_front( new_card );
  }
  
  // Pre:  None.
  // Post: All cards in the player's hand have been returned the deck d.
  void Player::clear_hand( Deck &d )
  {
    while (!hand_.empty())
    {
      d.discard(discard_card());
    }
  }
  
  //
  // Friend Methods
  //
  // Pre:  None.
  // Post: Player's cards (if any) have been returned as a string
  void Player::print( )
  {
    list<Card>::const_iterator it;
    cout << name_ << "'s Hand: " << endl;
  }

  // Post: Card has been outputted to ostream
  ostream &operator<<( ostream &output, const Player &p ) {
    list<Card>::const_iterator it, end;
    
    if ( !p.hand_.empty( ) )
    {
      output << p.name_ << "'s Hand:" << endl;
      it  = p.hand_.begin();
      end = p.hand_.end();

      for ( ; it != end; ++it )
      {
        output << *it << ", ";
      }
    }
    else
    {
      output << p.name_ << " has no cards";
    }

    return output;
  }

}
///////////////////////////////////////////////////////////////////////////////
