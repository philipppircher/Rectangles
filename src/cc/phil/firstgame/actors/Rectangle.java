package cc.phil.firstgame.actors;

import cc.phil.firstgame.movement.MoveStrategy;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Rectangle implements CollisionActor {
    // Membervariables
    //
    private MoveStrategy moveStrategy;
    private Shape collisionShape;

    // Constructor
    //

    public Rectangle(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.collisionShape =
                new org.newdawn.slick.geom.Rectangle(moveStrategy.getX(), moveStrategy.getY(), 10.0f, 10.0f);

    }

    // Methodes
    //
    public void render(Graphics graphics) {
        graphics.drawRect(moveStrategy.getX(), moveStrategy.getY(), 10.0f, 10.0f);
        graphics.setColor(Color.magenta);
        graphics.draw(collisionShape);
        graphics.setColor(Color.white);
    }

    public void update(GameContainer gameContainer, int delta) {
        moveStrategy.update(delta);
        this.collisionShape.setX(this.moveStrategy.getX());
        this.collisionShape.setY(this.moveStrategy.getY());
    }

    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    @Override
    public String getString() {
        return getClass().getSimpleName() + " collision";
    }
}
