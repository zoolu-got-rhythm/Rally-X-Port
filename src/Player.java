/**
 * Created by Slime on 24/03/2017.
 */
public class Player extends Car {
    private double fuel;
    private int lives;

    public Player(Coordinates pos, int speed, double fuel){
        super(pos, speed);
        this.fuel = fuel;
    }


    public void move(Character dir){
        super.setPrevPos(new Coordinates(super.getPos().getX(), super.getPos().getY()));

        Coordinates co = super.getDirections().get(dir);
        int x = co.getX();
        int y = co.getY();
        super.getPos().move(x, y);

        // drain players fuel after every move
        this.drainFuel();
    }

    private void drainFuel() {
        if (this.getFuel() > 0.1) {
            this.fuel -= 0.1;
        }
    }

    public double getFuel() {
        return fuel;
    }

    public int getLives() {
        return lives;
    }
}
