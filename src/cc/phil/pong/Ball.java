package cc.phil.pong;

import cc.phil.firstgame.actors.CollisionActor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.Random;

public class Ball extends GameObject implements CollisionActor {
    // Membervariables
    //
    private float diameter;
    private Random random = new Random();
    private int horizontalValue;
    private static final float Y_CENTER_OF_SCREEN = 250.0f;
    private boolean startMoving;
    private final static float START_BALL_SPEED = 5.0f;
    private final static float MAX_BALL_SPEED = 1.5f;
    private ArrayList<CollisionActor> collisionActors;       // Collisionshape partner -> ball
    private boolean isMovingUp;
    public int scorePlayer, scoreComputer;

    public Ball(ArrayList<CollisionActor> collisionActors) {
        this.speed = START_BALL_SPEED;
        this.x = X_CENTER_OF_SCREEN + 50;
        this.y = Y_CENTER_OF_SCREEN;
        this.diameter = 30;
        this.collisionShape =
                new org.newdawn.slick.geom.Circle(this.x, this.y, diameter / 2);
        this.collisionActors = collisionActors;
        this.startMoving = false;
        this.isMovingUp = true;
        this.scoreComputer = 0;
        this.scorePlayer = 0;
    }

    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.diameter, this.diameter);
        graphics.setColor(Color.magenta);
        graphics.draw(collisionShape);
        graphics.setColor(Color.white);
    }


    @Override
    public void update(GameContainer gameContainer, int delta) {
        collisionShape.setX(this.x);
        collisionShape.setY(this.y);

        // Check if pressed space -> move the Ball, set isMoving to true
        startMoveBall(gameContainer);

        if (this.startMoving) {
            ballMoveVertical(delta);
            ballMoveHorizontal(delta);
        }

        ballCollideWithBorder();
        ballOutsideYBorder();
        checkBallCollideWithPaddles();
    }

    private void ballCollideWithBorder() {
        // ball.x collide with left or right border
        if (this.x <= 0) {
            horizontalValue = 0;
        } else if (this.x >= 770) {
            horizontalValue = 1;
        }
    }

    private void ballMoveVertical(int delta) {
        if (isMovingUp) {
            this.y -= (float) delta / this.speed;
        } else {
            this.y += (float) delta / this.speed;
        }
    }

    private void ballMoveHorizontal(int delta) {
        if (horizontalValue == 0) {                 // move ball right
            this.x += (float) delta / this.speed;
        } else if (horizontalValue == 1) {          // move ball left
            this.x -= (float) delta / this.speed;
        } else if (horizontalValue == 2) {           // move ball straight
            this.x += 0;
        }
    }

    private void startMoveBall(GameContainer gameContainer) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && !startMoving) {
            this.horizontalValue = this.random.nextInt(3);
            this.startMoving = true;
        }
    }

    private void ballOutsideYBorder() {
        if (this.y < 0) {
            scorePlayer++;
        } else if (this.y > 700) {
            scoreComputer++;
        }

        // Outside upper or lower screen border
        if (this.y < 0 || this.y > 700) {
            this.y = this.Y_CENTER_OF_SCREEN;
            this.x = GameObject.X_CENTER_OF_SCREEN + 50;
            this.speed = this.START_BALL_SPEED;
            this.startMoving = false;
            horizontalValue = this.random.nextInt(3);
        }
    }

    private void checkBallCollideWithPaddles() {
        // Check collision with paddlePlayer and paddleComputer
        for (CollisionActor collisionActor : this.collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getShape())) {
                // Check instance to move ball up or down
                if (collisionActor instanceof PaddleComputer) {
                    isMovingUp = false;
                }
                if (collisionActor instanceof PaddlePlayer) {
                    isMovingUp = true;
                }

                if (horizontalValue == 2) {
                    horizontalValue = random.nextInt(3);
                }
                ballSpeedIncrease();    // Increase ball speed, everytime ball collides with a paddle
            }
        }
    }

    private void ballSpeedIncrease() {
        if (this.speed > MAX_BALL_SPEED) {
            this.speed -= 0.15f;
        }
    }
}