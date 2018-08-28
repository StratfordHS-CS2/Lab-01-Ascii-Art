import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.InputStream;

/**
 * The test class ArtTest.
 *
 * @author  Dave Avis
 * @version 7.1.2018
 */
public class ArtTest
{
    private OutputStream os;
    private InputStream origIn = System.in;
    private PrintStream origOut = System.out;
    private String ls = System.getProperty("line.separator");
    
    /**
     * Default constructor for test class ArtTest.
     */
    public ArtTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        //Prepare to redirect output
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        //PrintStream originalOut = System.out;
        System.setOut(origOut);
        System.setIn(origIn);
    }
    
    /**
     * Tests for output of 10 lines of 25 characters each.
     */
    @Test
    public void asciiBoxTest()
    {
        //String expectedOutput = "+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n+++++++++++++++++++++++++\n";
        Art.asciiBox();
        //assertEquals("asciiBox() failed:", expectedOutput, os.toString());
        String output = os.toString();
        int width = output.indexOf( ls );  // line seperator (ls) is the 26th character, so 25th location.
        assertEquals("Width should be 25:", 25, width);
        assertEquals("Probably not 25x10:", 260, output.length());
    }
    
    /**
     * Tests for output of a hollow box of plusses 10 wide and 25 tall with a message inside.
     */
    @Test
    public void asciiBox2Test()
    {
        Art.asciiBox2();
        String output = os.toString();
        
        int width = output.indexOf( ls );  // line seperator (ls) is the 26th character, so 25th location.
        assertEquals("Width should be 25:", 25, width);
        assertEquals("Probably not 25x10:", 260, output.length());
    }
}
