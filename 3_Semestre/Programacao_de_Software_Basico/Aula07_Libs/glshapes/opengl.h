#ifndef MYOPENGL_H
#define MYOPENGL_H

#ifdef WIN32
#include <windows.h> // includes only in MSWindows not in UNIX
#include "gl/glut.h"
#endif

#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#endif // MYOPENGL_H
