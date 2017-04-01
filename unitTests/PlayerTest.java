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
        this.playerCar = new Player(new Coordinates(5,5), 6000, 10);
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
    public void testRequestMove(){
        this.playerCar.requestMove();

        try {
            assertEquals(false, this.playerCar.getReadyToMove());
            Thread.sleep(3000);
            assertEquals(false, this.playerCar.getReadyToMove());
            Thread.sleep(3300);
            assertEquals(true, this.playerCar.getReadyToMove());
        }catch (Exception e){

        }
    }

    @Test
    public void testMoveDirections(){

    }

    @Test
    public void testFuelIsBeingDrainedAfterEachMove(){
        for(double i = 10.0; i >= 0.0; i-=0.1){
            System.out.println(i);
            System.out.println(this.playerCar.getFuel());
            assertEquals(i, this.playerCar.getFuel(), 0);
            this.playerCar.move('n');
            if(i == 0.0){

               assertNotEquals(i, this.playerCar.getFuel(), 0);
            }
        }

    }

}