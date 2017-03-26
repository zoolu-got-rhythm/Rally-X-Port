import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slime on 24/03/2017.
 */
public class Grid {
    private int h;
    private int w;
    List<Coordinates> tiles;
    // List<Car> cars = new ArrayList<>();


    public Grid(){
        this.tiles = new ArrayList<>();
        for(int x = 0; x <= w; x++){
            for(int y = 0; y <= h; y++){
                this.tiles.add(new Coordinates(x, y));
            }
        }
    }


    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public List<Coordinates> getTiles() {
        return tiles;
    }
}
