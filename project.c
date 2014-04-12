//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//  FILE: project.c
//  AUTHOR: Willem Schreüder
//    Provided for Computer Graphics Summer 2012 - vlakkies@Colorado.EDU
//  
//  PURPOSE: Set projection
//------------------------------------------------------------------------------

#include "CSCIx229.h"

void Project(double fov,double asp,double dim)
{
   //  Tell OpenGL we want to manipulate the projection matrix
   glMatrixMode(GL_PROJECTION);
   //  Undo previous transformations
   glLoadIdentity();
   //  Perspective transformation
   gluPerspective(fov,asp,dim/16,16*dim);
   //  Switch to manipulating the model matrix
   glMatrixMode(GL_MODELVIEW);
   //  Undo previous transformations
   glLoadIdentity();
}
//------------------------------------------------------------------------------