# -*- mode: makefile-gmake; -*-
# This is a minimalistic generic makefile with automatic dependency
# generation. It is only expected to work with GNU make and g++ or
# clang.

# For a fancier version, with copious explanatory comments, look at
# the file called 'Makefile' in this same directory

# Instructions for use:

CPPFLAGS += 

# 1.  Save this file in your source directory under the name
#     'Makefile'.

# 2.  If you do not use .cc as the filename extension for your C++
#     source code replace the three occurrances of .cc near the bottom
#     of this file, with whatever extension you use. Allowed choices
#     are:
#                       .cc .cp .cxx .cpp .CPP .c++ .C

# 3.  Make sure that the only files with the filename extension
#     specified in the last step, that can be found in the source
#     directory, are those which contain source code for your project.

# 4a. If you are using nonstandard libraries, you may have to specify
#     include directories here ...
	# -I /usr/local/include/SomeLibrary
CXXFLAGS += -ansi -pedantic -Wall -std=c++14 
# 4b. ... and library directories here.
	# -L /usr/local/lib/SomeLibrary
LDFLAGS +=  

# 5.  If you want to use clang rather than g++, uncomment the next line
CXX := clang++

# 6.  Change 'executable' below, to whatever name you want your
#     executable to have.

# 7.  Type 'make' on the command line.

CPPFLAGS += -MD -MP -O3 -g

SOURCES := $(wildcard *.cc)
-include $(SOURCES:%.cc=%.d)

all: client

client: $(SOURCES:%.cc=%.o) 
	$(CXX) -lpthread -o $@ $^ $(LDFLAGS)

clean:
	rm -rf *.o *.a *.d client


