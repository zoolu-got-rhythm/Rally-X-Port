/**
 * Created by Slime on 31/03/2017.
 */

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.regex.Matcher;

import static org.junit.Assert.*;


public class ObstacleTest {

    @Rule
    public ExpectedException thr = ExpectedException.none();

    private Obstacle obst;

    @Before
    public void setMockObjectsUp(){
        this.obst = new Obstacle();
    }

    @Test
    public void testArrayEmpty(){
        assertEquals("list should be empty", 0, this.obst.getBlocks().size());
    }

    @Test
    public void testBlocksAreAdded(){
        try{
            // spam add a bunch of blocks with the same co-ordinates.
            this.obst.addBlock(new Block(new Coordinates(3,3)));
            this.obst.addBlock(new Block(new Coordinates(3,3)));
            this.obst.addBlock(new Block(new Coordinates(3,3)));
            this.obst.addBlock(new Block(new Coordinates(3,3)));
            fail("expected Exception to be thrown by Obstacle class");
        }catch (Exception e){
            Assert.assertEquals("this position has already been taken by another block", e.getMessage());
        }

        assertEquals("length should be greater than 0", 1, this.obst.getBlocks().size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        this.obst.getBlocks().get(0);
    }

    @Test
    public void shouldTestExceptionMessage() throws Exception{
        thr.expect(IndexOutOfBoundsException.class);
        thr.expectMessage("Index: 0, Size: 0");
        this.obst.getBlocks().get(0);
    }




}
