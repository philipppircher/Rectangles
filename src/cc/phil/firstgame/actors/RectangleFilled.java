package cc.phil.firstgame.actors;

import cc.phil.firstgame.movement.MoveStrategy;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class RectangleFilled extends AbstractMoveableActor {
    // Constructor
    //
    public RectangleFilled(MoveStrategy moveStrategy) {
        super(moveStrategy);
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(moveStrategy.getX(), moveStrategy.getY(), 20, 20);
    }
}
