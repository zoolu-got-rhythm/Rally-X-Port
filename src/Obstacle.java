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

    public void addBlock(Block block) throws Exception {
        for(Block b : blocks){
            if(block.getPos().getX() == b.getPos().getX() && block.getPos().getY() == b.getPos().getY()){
                throw new Exception("this position has already been taken by another block");
            }
        }
        this.blocks.add(block);
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
