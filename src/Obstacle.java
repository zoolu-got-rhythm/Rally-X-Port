import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slime on 24/03/2017.
 */
public class Obstacle {
    private List<Block> blocks;

    public Obstacle(){
        this.blocks = new ArrayList<>();
    }

    public void addBlock(Block block){
        this.blocks.add(block);
    }

}
