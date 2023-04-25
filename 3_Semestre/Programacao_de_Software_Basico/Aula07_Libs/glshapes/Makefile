# Makefile para Linux e macOS

PROG = glshapes
FONTES = main.c
FONTES2 = shapes.c
OBJETOS = $(FONTES:.c=.o)
OBJETOS2 = $(FONTES2:.c=.o)
CFLAGS = -g -O3 -DGL_SILENCE_DEPRECATION -Wno-deprecated # -Wall -g  # Todas as warnings, infos de debug

UNAME = $(shell uname)

ifeq ($(UNAME),Darwin)
	LDFLAGS = -framework OpenGL -framework Cocoa -framework GLUT -lm
else
	LDFLAGS = -lGL -lGLU -lglut -lm
endif

$(PROG): $(OBJETOS) libshapes.a
	$(CC) $(CFLAGS) $(OBJETOS) -L. -lshapes $(LDFLAGS) -o $(PROG)

libshapes.a: $(OBJETOS2)
	ar rcs libshapes.a $(OBJETOS2)

clean:
	-@ rm -f $(OBJETOS) $(OBJETOS2) $(PROG) libshapes.a

