import org.junit.Before;
import org.junit.Test;

/**
 * Created by Slime on 26/03/2017.
 */
public class EnemyChasePlayerTest {

    private Player playerCar;
    private Level level1;
    private Enemy enemyAI;


    // note there some fairly tight coupling here. is there a better way?
    @Before
    public void setUp() throws Exception {
        this.level1 = new Level();
        this.playerCar = new Player(new Coordinates(5,5), 5, 10);
        this.enemyAI = new Enemy(new Coordinates(7,7), 10);

        this.level1.addCars(this.enemyAI);
        this.level1.addCars(this.playerCar);

        this.enemyAI.findPlayerLocation(this.level1.getCars());




    }

    // write some logic that tests if an enemy moves in direction of player when enemy is given context
    @Test
    public void testEnemyMovesInPlayerDirectionEachTurn(){
        for(int i = 0; i < this.level1.getCars().size(); i++){
            // if()
            this.level1.getCars().get(i).move();
        }
    }

    @Test
    public void checkSubClassNames(){
        for(int i = 0; i < this.level1.getCars().size(); i++){
            Car currentCar = this.level1.getCars().get(i);
            System.out.println(currentCar.getClass().getName());
        }
    }





}
