package cc.phil.firstgame.actors;

import cc.phil.firstgame.movement.MoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Ellipse extends AbstractMoveableActor {
    // Constructor
    //
    public Ellipse(MoveStrategy moveStrategy) {
        super(moveStrategy);
    }

    // Methodes
    //
    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.moveStrategy.getX(), this.moveStrategy.getY(), 30, 10);
    }

    // Getter
    //
    @Override
    public Shape getShape() {
        return null;
    }
}
