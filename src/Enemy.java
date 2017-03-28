import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slime on 24/03/2017.
 */
public class Enemy extends Car {
    private Player player = null;
    public Enemy(Coordinates pos, int speed){
        super(pos, speed);
    }
    public Enemy(Coordinates pos, int speed, Player player){
        super(pos, speed);
        this.player = player;
    }

    @Override
    public void move(){
        Coordinates playerLoc;

        // adjust AI logic to chase player object reference
        if(this.player != null){
            // playerLoc = this.findPlayerLocation(this.player);

            List<Character> directionsToMoveIn = decideOnWhichDirectionToGoInBasedOnPlayersPosition(this.player.getPos());
            Character getTheDirectionToMoveIn = pickADirection(directionsToMoveIn);
            moveInADirection(getTheDirectionToMoveIn);

        // run default random movement logic: if no player object has been parsed in
        }else{
            super.move();
        }
    }

    private void moveInADirection(Character direction){
        int x = super.getDirections().get(direction).getX();
        int y = super.getDirections().get(direction).getY();
        super.getPos().move(x, y);
    }

    private List<Character> decideOnWhichDirectionToGoInBasedOnPlayersPosition(Coordinates playersLocation){
        List<Character> potentialDirections = new ArrayList<>();
        // if/elses
//        if(playersLocation.getX() == super.getPos().getX() && playersLocation.getY() == super.getPos().getY())
//            throw new Exception("this enemy object is on the same position as the player");


        if(playersLocation.getX() > super.getPos().getX()) {
            potentialDirections.add('e');
        }

        if(playersLocation.getY() > super.getPos().getY()){
            potentialDirections.add('s');
        }

        if(playersLocation.getX() < super.getPos().getX()){
            potentialDirections.add('w');
        }

        if(playersLocation.getY() < super.getPos().getY()){
            potentialDirections.add('n');
        }

        return potentialDirections;
    }

    private Character pickADirection(List<Character> gatherdDirections){

        int n = (int) Math.floor(Math.random() * gatherdDirections.size());
        System.out.println(n);
        return gatherdDirections.get(n);
    }


    public Coordinates findPlayerLocation(Player player) {
        return player.getPos();
        // throw new TypeNotPresentException("couldn't find player car in given context", null);
    }
}
