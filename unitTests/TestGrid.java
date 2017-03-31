/**
 * Created by Slime on 31/03/2017.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestGrid {
    private Grid grid;

    @Before
    public void setMockObjectsUp(){
        this.grid = new Grid(4,5);
    }

    @Test
    public void testGridSize(){
        assertEquals(20, this.grid.getTiles().size());
    }

    @Test
    public void testTiles(){
        for(Coordinates tile : this.grid.getTiles()){
            System.out.println(tile.getX() + " " + tile.getY());
        }

        Coordinates c1 = this.grid.getTiles().get(0);
        assertTrue(c1.getX() == 0 && c1.getY() == 0);

        Coordinates c2 = this.grid.getTiles().get(this.grid.getTiles().size() - 1);
        assertTrue(c2.getX() == 3 && c2.getY() == 4);
    }
}
