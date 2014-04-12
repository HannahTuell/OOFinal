//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//  FILE: visuals.h
//  AUTHOR: Hannah Tuell
//    
//  
//  PURPOSE: Library Interface functioning as an adapter to draw the visuals of
//    a card game.
//------------------------------------------------------------------------------
#ifndef visuals
#define visuals

#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>
#include <math.h>
#include <time.h>

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
#define true 1
#define false 0

typedef struct Color {
    double r, g, b;
} Color;

//[define functions here]

#endif
//------------------------------------------------------------------------------