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


    public Grid(int w, int h){
        this.w = w;
        this.h = h;
        this.tiles = new ArrayList<>();
        for(int x = 0; x < this.getW(); x++){
            for(int y = 0; y < this.getH(); y++){
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
