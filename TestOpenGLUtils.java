import graphics.core.*;
import static org.lwjgl.opengl.GL40.*;

/**
 * Write a description of class TestOpenGLUtils here.
 *
 * @author Austin Jones
 * @version 1/28/22
 */
public class TestOpenGLUtils extends Base
{
    int programRef;
    // data array
    int arrayRef;
    public void initialize()
    {
        /*
        String code = OpenGLUtils.readFile("shaders/center.vert");
        System.out.println(code);
        
        // test compiling shader
        int shaderRef = OpenGLUtils.initializeShader(code, GL_VERTEX_SHADER);
        System.out.println("Shader reference: " + shaderRef);
        
        // write fragment code
        String code2 = OpenGLUtils.readFile("shaders/yellow.frag");
        int shaderRef2 = OpenGLUtils.initializeShader(code2, GL_FRAGMENT_SHADER);
        System.out.println("Shader reference" + shaderRef2);
        */
        
        programRef = OpenGLUtils.initializeProgram(
            "shaders/position.vert", "shaders/yellow.frag");
            
        System.out.println("Program reference: " + programRef);
        
        // creates an array to store vertex data
        arrayRef = glGenVertexArrays();
        // make this array object active (use it in future OpenGL commands)
        glBindVertexArray(arrayRef);
        
        // create an array of points
        float[] positionData = 
        {
            // x, y, z, moving counter clockwise
            0.8f,  0.0f, 0.0f,
            0.3f,  0.7f, 0.0f,
           -0.3f,  0.7f, 0.0f,
           -0.8f,  0.0f, 0.0f,
           -0.3f, -0.7f, 0.0f,
            0.3f, -0.7f, 0.0f
        };
        
        // creating a buffer to store data
        int bufferRef = glGenBuffers();
        
        // activate buffer: storing array data
        glBindBuffer( GL_ARRAY_BUFFER, bufferRef);
        
        // transmit data into buffer
        glBufferData(GL_ARRAY_BUFFER, positionData, GL_STATIC_DRAW);
        
        // locate reference for shader variable where data should be sent
        int variableRef = glGetAttribLocation(programRef, "pos");
        
        // set up buffer to variable association
        glVertexAttribPointer(variableRef, 3,GL_FLOAT, false, 0, 0);
        
        // activate/enable data flow
        glEnableVertexAttribArray(variableRef);
    }
    
    public void update()
    {
        // declare GPU program to use
        glUseProgram(programRef);
        
        // increases size of points to 20 pixels
        glPointSize(20);
        // increases line width
        //glLineWidth(10);
        
        // draw all the points
        // parameters: draw style (points/lines/triangles), starting index, # of vertices
        //GL_LINES (2 points per line), GL_LINE_STRIP (0 through end point), GL_LINE_LOOP(0 through 0)
        //GL_TRIANGLES (012 is one tri, 345 is another, groups of 3) GL_TRIANGLE_STRIP (012, 123, 234, etc. groups of 3 that fill in)
        //  GL_TRIANGLE_FAN (012, 023, 034, etc. uses one point as a base and fills in entire object) 
        glDrawArrays(GL_POINTS, 0, 6);
    }
    
    public static void main(String[] args)
    {
        new TestOpenGLUtils().run();
    }
}
