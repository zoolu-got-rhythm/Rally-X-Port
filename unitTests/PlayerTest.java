import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Slime on 25/03/2017.
 */
public class PlayerTest {
    private Player playerCar;
    @Before
    public void setUp() throws Exception {
        this.playerCar = new Player(new Coordinates(5,5), 5, 10);
    }

    @Test
    public void testMove() throws Exception {
        assertEquals(10, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.move('n');
        assertEquals(9, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.move('n');
        assertEquals(8, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
    }

    @Test
    public void testUndoMove() throws Exception {
        assertEquals(10, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.move('n');
        assertEquals(9, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.undoMove();
        assertEquals(10, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.undoMove();
        assertEquals(10, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.move('n');
        assertEquals(9, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.undoMove();
        assertEquals(10, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
        this.playerCar.move('s');
        assertEquals(11, this.playerCar.getPos().getX() + this.playerCar.getPos().getY());
    }

    @Test
    public void testMoveDirections(){

    }

}