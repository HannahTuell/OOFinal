///////////////////////////////////////////////////////////////////////////////
// File:   main.cpp                    Spring 2014
// Author: Patrick Vargas              patrick.vargas@colorado.edu
// Description:
//    Main Program
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
#include <cstdio>
#include <cstdlib>
#include "bicycle.h"

// openGL functionality
#include "CSCIx229.h"
#include "visuals.h"

using namespace std;
using namespace bicycle;
///////////////////////////////////////////////////////////////////////////////

int main(int argc, char* argv[]) {

   //  Initialize GLUT
   glutInit(&argc,argv);
   // default frame buffers identified
   glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
   //  Create window
   glutCreateWindow("Hello World");
   //  Register function used to display scene
   glutDisplayFunc(display);
   //  Pass control to GLUT for events
   glutMainLoop();
   //  Return to OS
   return 0;

  Euchre game;
  Dealer joe( game );
  string name;
  cout << endl << "Your Name, Please: ";
  cin >> name;
  Player me ( name );

  joe.user( me );
  joe.play();

  return EXIT_SUCCESS;

}
///////////////////////////////////////////////////////////////////////////////
