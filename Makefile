# Makefile for Patrick E. Vargas       (patrick.vargas@colorado.edu)

# Declaration of Variables
CXX  = g++ 
FLAGS = -Wall -O2 -arch x86_64

# File Names
EXEC = canasta
TEST = testsuit
TESTFILES = $(wildcard test*.cpp)
LIBS = bicycle.a

# Libraries - Linux
# GLLIBS = -lglut -lGLU
# Libraries - OSX
GLLIBS = -framework GLUT -framework OpenGL 
# Libraries - MinGW
# GLLIBS =-lglut32cu -lglu32 -lopengl32

# Main Targets
all: $(EXEC) $(TEST)
	@echo // Done Building $@

$(EXEC): main.o $(LIBS)
	@$(CXX) $(FLAGS) -o $@ $^ 

$(TEST): $(TESTFILES) $(LIBS)
	@$(CXX) $(FLAGS) -o $@ $^ 

# Generic Compile Rules
%.o: %.cpp
	@echo // Building $@
	@$(CXX) -c $< -o $@ $(FLAGS)

bicycle.a: card.o deck.o
	@echo // Building $@
	@ar -rcs $@ $^

# Delete unwanted files - Linux or OX/X
clean:; @rm -f $(wildcard $(EXEC)) $(wildcard $(TEST)) $(wildcard *.o) $(wildcard *.a) *~
# Delete unwanted files - MinGW
#clean:;del *.exe *.o *.a

# Obligatory UNIX inside joke
love:
	@echo "not war?"