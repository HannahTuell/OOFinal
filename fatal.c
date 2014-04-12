//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//  FILE: fatal.c
//  AUTHOR: Willem Schreüder
//    Provided for Computer Graphics Summer 2012 - vlakkies@Colorado.EDU
//  
//  PURPOSE: Print message to stderr and exit.
//------------------------------------------------------------------------------

#include "CSCIx229.h"

void Fatal(const char* format , ...)
{
   va_list args;
   va_start(args,format);
   vfprintf(stderr,format,args);
   va_end(args);
   exit(1);
}
//------------------------------------------------------------------------------