For this lesson the shaders folder was added that creates center.vert which puts our pixel in the center
    and yellow.frag which gives our pixel the color yellow
In the core we are creating OpenGLUtils.java which will load text files into Strings and create a
    shader object in the GPU in order to recieve those code Strings. 
This will send the code into GPU shader object and compile the shader. All of this will need to be done twice for the double buffer(?)

Will also link vertex shader to the fragment shader and manually check for any errors

OUTPUT: reference GPU program to be used in our application

pretty much writing functions that makes our code compile manually