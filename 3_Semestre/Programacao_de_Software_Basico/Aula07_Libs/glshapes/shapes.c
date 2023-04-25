#include "opengl.h"
#include "shapes.h"
#include <math.h>

// Biblioteca para desenho de formas simples

void drawCircle(float x, float y, float radius)
{
  glBegin(GL_LINE_LOOP);
  float ang;
  for(ang=0; ang <= 2*M_PI; ang+=0.2)
  {
    float px = x + radius * cos(ang);
    float py = y + radius * sin(ang);
    glVertex2f(px, py);
  }
  glEnd();
}

void drawSquare(float x, float y, float side)
{
  glBegin(GL_LINE_LOOP);
    glVertex2f(x,y);
    glVertex2f(x+side,y);
    glVertex2f(x+side,y+side);
    glVertex2f(x,y+side);
  glEnd();
}

void drawRect(float left, float top, float width, float height)
{
  glBegin(GL_LINE_LOOP);
    glVertex2f(left,top);
    glVertex2f(left+width,top);
    glVertex2f(left+width,top+height);
    glVertex2f(left,top+height);
  glEnd();
}

void drawLine(float x1, float y1, float x2, float y2)
{
  glBegin(GL_LINES);
  glVertex2f(x1,y1);
  glVertex2f(x2,y2);
  glEnd();
}

