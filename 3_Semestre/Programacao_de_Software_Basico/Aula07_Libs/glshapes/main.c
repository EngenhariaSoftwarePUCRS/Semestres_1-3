#include "opengl.h"
#include <stdio.h>
#include <stdlib.h>
#include "shapes.h"

void display()
{
  glClear( GL_COLOR_BUFFER_BIT );
  glLoadIdentity();

  glColor3f(1,1,1);

  drawLine(-100,0,100,0);
  drawLine(0,-100,0,100);

  glColor3f(1,0.5,0);
  drawCircle(0,0,20);

  glutSwapBuffers();
}

void keyboard(unsigned char key, int x, int y)
{
    if(key == 27)
        exit(1);
}

int main(int argc, char** argv)
{
  glutInit(&argc,argv);
  glutInitDisplayMode(GLUT_RGB|GLUT_DOUBLE);

  glutInitWindowSize(800,800);
  glutCreateWindow("Shape library");

  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();

  // Define o tamanho da janela 2D
  glOrtho (-100.0, 100.0, -100.0, 100.0, 100.0, -100.0);

  glMatrixMode(GL_MODELVIEW);
  glClearColor(0.0,0.0,0.0,1.0);

  glutDisplayFunc( display );
  glutKeyboardFunc( keyboard );
  glutMainLoop();
}

