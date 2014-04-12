//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//  FILE: errcheck.c
//  AUTHOR: Willem Schreüder
//    Provided for Computer Graphics Summer 2012 - vlakkies@Colorado.EDU
//  
//  PURPOSE: Check for OpenGL errors.
//------------------------------------------------------------------------------

#include "CSCIx229.h"

void ErrCheck(const char* where)
{
   int err = glGetError();
   if (err) fprintf(stderr,"ERROR: %s [%s]\n",gluErrorString(err),where);
}
//------------------------------------------------------------------------------