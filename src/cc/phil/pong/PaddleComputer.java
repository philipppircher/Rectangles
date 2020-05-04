package cc.phil.pong;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;

public class PaddleComputer extends Paddle {
    // Membervariable
    //
    private Ball targetBall;

    // Constructor
    //
    public PaddleComputer() {
        this.y = 50.0f;
    }

    // Methodes
    //
    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        controlComputerPaddle(gameContainer, delta);
    }

    public void controlComputerPaddle(GameContainer gameContainer, int delta){
        if (this.x > targetBall.x - 55) {
            moveLeft(gameContainer, delta);
        } else if (this.x < targetBall.x - 55 ) {
            moveRight(gameContainer, delta);
        }
    }

    @Override
    protected void moveLeft(GameContainer gameContainer, int delta) {
        super.moveLeft(gameContainer, delta);
    }

    @Override
    protected void moveRight(GameContainer gameContainer, int delta) {
        super.moveRight(gameContainer, delta);
    }

    public void addTargetToMove(Ball ball){
        this.targetBall = ball;
    }

    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    @Override
    public String getString() {
        return getClass().getSimpleName();
    }
}
