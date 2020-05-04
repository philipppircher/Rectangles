package cc.phil.pong;

import cc.phil.firstgame.actors.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;

public class PaddlePlayer extends Paddle {
    // Constructor
    //
    public PaddlePlayer() {
        this.y = 500.0f;
    }

    // Methodes
    //
    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        controlPlayerPaddle(gameContainer, delta);
    }

    public void controlPlayerPaddle(GameContainer gameContainer, int delta){
        moveLeft(gameContainer, delta);
        moveRight(gameContainer, delta);
    }

    @Override
    protected void moveLeft(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            super.moveLeft(gameContainer, delta);
        }
    }

    @Override
    protected void moveRight(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            super.moveRight(gameContainer, delta);
        }
    }

    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    @Override
    public String getString() {
        return this.getClass().getSimpleName();
    }
}
