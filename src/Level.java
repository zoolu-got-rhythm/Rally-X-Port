import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slime on 25/03/2017.
 */
public class Level implements ContainsCars{
    // compose everything
    private Grid grid; // aggregated object reference
    private List<? extends Car> cars;
    private List<Obstacle> obstacles;
    private List<Flag> flags;

    public Level() {
        this.grid = new Grid();
        this.cars = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        this.flags = new ArrayList<>();
    }

    @Override
    public List<? extends Car> getCars() {
        return this.cars;
    }

    public Grid getGrid() {
        return grid;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public <T extends Car> void addCars(T car) {
        this.cars.add(car);
    }

    public void addObstacles(Obstacle obstacle) {
        this.obstacles.add(obstacle);
    }

    public void addFlags(Flag flag) {
        this.flags.add(flag);
    }
}

interface ContainsCars{
    public List<? extends Car> getCars();
}
