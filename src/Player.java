/**
 * Created by Slime on 24/03/2017.
 */
public class Player extends Car {
    private int fuel;
    private int lives;

    public Player(Coordinates pos, int speed, int fuel){
        super(pos, speed);
        this.fuel = fuel;
    }


    public void move(Character dir){
        super.setPrevPos(new Coordinates(super.getPos().getX(), super.getPos().getY()));

        Coordinates co = super.getDirections().get(dir);
        int x = co.getX();
        int y = co.getY();
        super.getPos().move(x, y);
    }
}
