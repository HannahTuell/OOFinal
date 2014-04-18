//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//  FILE: CSCIx229.h
//  AUTHOR: Willem Schreüder
//    Provided for Computer Graphics Summer 2012 - vlakkies@Colorado.EDU
//  
//  PURPOSE: Extends OpenGL functionality
//------------------------------------------------------------------------------

#ifndef CSCIx229
#define CSCIx229

#include <cstdio>
#include <cstdlib>

#include <stdarg.h>
#include <string.h>
#include <math.h>

#ifdef USEGLEW
#include <GL/glew.h>
#endif
#define GL_GLEXT_PROTOTYPES
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#define Cos(th) cos(3.1415926/180*(th))
#define Sin(th) sin(3.1415926/180*(th))

void PrintText(const char* format , ...);
void Fatal(const char* format , ...);
unsigned int LoadTexBMP(const char* file);
void Project(double fov,double asp,double dim);
void ErrCheck(const char* where);
int  LoadOBJ(const char* file);

#endif
//------------------------------------------------------------------------------