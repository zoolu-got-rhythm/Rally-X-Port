import java.util.*;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Slime on 24/03/2017.
 */
public abstract class Car implements Veichle, RequestMove {
    private Coordinates pos;
    private Coordinates prevPos;
    private int speed;
    private Boolean readyToMove;
    private java.util.Map<Character, Coordinates> directions;
    private Character[] dirs = {'n', 'e', 's', 'w'};

    // directions

    public Car(Coordinates co, int speed){
        this.pos = co; // set origin position of car
        this.prevPos = this.pos;
        this.speed = speed;
        this.readyToMove = false;
        this.directions = new HashMap<>();
        this.directions.put('n', new Coordinates(0, -1));
        this.directions.put('e', new Coordinates(1, 0));
        this.directions.put('s', new Coordinates(0, 1));
        this.directions.put('w', new Coordinates(-1, 0));
    }

    // default move implementation: move to a random position.
    @Override
    public void move() {
        this.setPrevPos(new Coordinates(this.getPos().getX(), this.getPos().getY()));
        // random
        Coordinates newPos = this.directions.get(this.dirs[(int) Math.floor(Math.random() * this.dirs.length)]);
        this.pos.move(newPos.getX(), newPos.getY());
    }

    @Override
    public void undoMove() {
        // random
        this.pos = prevPos;
        System.out.println("ran");
    }

    @Override
    public void requestMove(){
        System.out.println("waiting to make move");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                readyToMove = true;
                System.out.println("ran");
            }
        }, speed);
    }

    public Coordinates getPos() {
        return pos;
    }

    public Coordinates getPrevPos() {
        return prevPos;
    }

    public int getSpeed() {
        return speed;
    }

    public Map<Character, Coordinates> getDirections() {
        return this.directions;
    }

    public void setPrevPos(Coordinates prevPos) {
        this.prevPos = prevPos;
    }

    public Boolean getReadyToMove() {
        return readyToMove;
    }

    public void setReadyToMove(Boolean readyToMove) {
        this.readyToMove = readyToMove;
    }
}
