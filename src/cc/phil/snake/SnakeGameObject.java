package cc.phil.snake;

import cc.phil.firstgame.actors.CollisionActor;
import cc.phil.pong.GameObject;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;

public abstract class SnakeGameObject extends GameObject implements CollisionActor {
    // Membervariables
    //
    private Shape collisionShape;

    // Constructor
    //
    public SnakeGameObject() {
        this.collisionShape = new org.newdawn.slick.geom.Rectangle(this.x, this.y,
                SnakeMainGame.getSizeInPixelPerPart() - 2, SnakeMainGame.getSizeInPixelPerPart() - 2);
    }

    // Methodes
    //
    public void render(Graphics graphics, Color color) {
        graphics.setColor(color);
        graphics.fillRect(this.x, this.y, SnakeMainGame.getSizeInPixelPerPart(), SnakeMainGame.getSizeInPixelPerPart());
        graphics.setColor(Color.white);
        graphics.draw(collisionShape);
    }

    public void update(GameContainer gameContainer, int delta) {
        this.collisionShape.setX(this.x);
        this.collisionShape.setY(this.y);
    }

    // Getter
    //
    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
