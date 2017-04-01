import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Slime on 01/04/2017.
 */
public class EnemyRequestMoveAndMove {
    private Level lvl1;
    private Enemy enemyAI;

    @Before
    public void setupIntegrationTest(){
        this.lvl1 = new Level();
        this.enemyAI = new Enemy(new Coordinates(5,5), 500);
        this.lvl1.addCars(this.enemyAI);
    }

    @Test
    public void waitToMoveBasedOnCarSpeed(){
        // this logic will be ran x frames per sec in the visual api to paint?

            //this.enemyAI.setReadyToMove(true);
        this.enemyAI.setReadyToMove(true);
        for(int i = 0; i < 5; i++) {
            if(this.enemyAI.getReadyToMove() == true) {
                this.enemyAI.move();
                this.enemyAI.setReadyToMove(false);
                this.enemyAI.requestMove();
            }

            try {
                Thread.sleep(100);
                if(i < 4) {
                    assertTrue(this.enemyAI.getReadyToMove() == false);
                }else{
                    assertTrue(this.enemyAI.getReadyToMove() == true);
                }
            }catch (InterruptedException e){

            }
        }
    }
}
