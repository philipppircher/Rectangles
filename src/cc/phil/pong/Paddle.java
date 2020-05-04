package cc.phil.pong;

import cc.phil.firstgame.actors.CollisionActor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class Paddle extends GameObject implements CollisionActor {
    private final static float paddleWidth = 150.0f;
    private final static float paddleHeight = 30.0f;

    // Paddle Constructor use default Constructor of GameObject
    public Paddle() {
        this.collisionShape =
                new org.newdawn.slick.geom.Rectangle(this.x, this.y, paddleWidth, paddleHeight);
        this.speed = 3.0f;
        this.x = X_CENTER_OF_SCREEN;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(this.x, this.y, paddleWidth, paddleHeight);
        graphics.setColor(Color.magenta);
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        // update collisionShape to paddle
        collisionShape.setX(this.x);
        collisionShape.setY(this.y);
    }

    protected void moveLeft(GameContainer gameContainer, int delta) {
        if (this.x > 0) {
            this.x -= (float) delta / this.speed;
        }
    }

    protected void moveRight(GameContainer gameContainer, int delta) {
        if (this.x < 650) {
            this.x += (float) delta / this.speed;
        }
    }

    // Getter
    //
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
