/**
 * Created by Slime on 24/03/2017.
 */
public class Coordinates{
    private int x;
    private int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates co){
        this(co.getX(), co.getY());
    }

    public Coordinates plot(Coordinates other){
        return new Coordinates(this.getX() + other.getX(), this.getY() + other.getY());
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
