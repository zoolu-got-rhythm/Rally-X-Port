import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Slime on 26/03/2017.
 */
public class EnemyTest {
    private Enemy enemyCar;

    @Before
    public void setUp() throws Exception {
         this.enemyCar = new Enemy(new Coordinates(5,5), 10);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void move() throws Exception {
        Coordinates lastMove;
        for(int i = 0; i <= 20; i++){
            lastMove = new Coordinates(this.enemyCar.getPos());
            this.enemyCar.move();

            assertTrue(lastMove.getX() != this.enemyCar.getPos().getX() || lastMove.getY() != this.enemyCar.getPos().getY());
            System.out.println(this.enemyCar.getPos().getX() + ", " + this.enemyCar.getPos().getY());
        }
        this.enemyCar.undoMove();
        System.out.println(this.enemyCar.getPos().getX() + ", " + this.enemyCar.getPos().getY());

    }
}