package cc.phil.firstgame;

import cc.phil.firstgame.actors.Actor;
import cc.phil.firstgame.actors.CollisionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;

public class Rocket implements Actor {
    // Membervariables
    //
    private Image rocketImage;
    private float x, y;
    private float speed;
    private Shape collisionShape;                            // Collisionshape for Rocket
    private ArrayList<CollisionActor> collisionActors;       // Collisionshape partners, example Circle .getShape()

    // Constructor
    //
    public Rocket() throws SlickException {
        Image temp = new Image("testdata/rocket.png");
        this.rocketImage = temp.getScaledCopy(70, 70);
        this.x = 100;
        this.y = 100;
        this.speed = 5.0f;
        this.collisionShape = new Rectangle(this.x, this.y, 60, 60);
        this.collisionActors = new ArrayList<CollisionActor>();
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x, this.y);
        // nur jetzt
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for (CollisionActor collisionActor : this.collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getShape())) {
                //System.out.println(collisionActor.getString());
            }
        }

        moveRocketFourInFourDirections(gameContainer, delta);

        // update collisionShape to rocket sprite
        collisionShape.setX(this.x + 5);
        collisionShape.setY(this.y + 5);
    }

    public void addCollisionPartner(CollisionActor collisionActor) {
        this.collisionActors.add(collisionActor);
    }

    private void moveRocketFourInFourDirections(GameContainer gameContainer, int delta){
        moveRocketRight(gameContainer, delta);
        moveRocketLeft(gameContainer, delta);
        moveRocketUp(gameContainer, delta);
        moveRocketDown(gameContainer, delta);
    }

    private void moveRocketLeft(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            if (this.x > 0) {
                this.x -= (float) delta / this.speed;
            }
        }
    }

    private void moveRocketRight(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            if (this.x < 730) {
                this.x += (float) delta / this.speed;
            }
        }
    }

    private void moveRocketDown(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_S)) {
            if (this.y < 530) {
                this.y += (float) delta / this.speed;
            }
        }
    }

    private void moveRocketUp(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            if (this.y > 0) {
                this.y -= (float) delta / this.speed;
            }
        }
    }

    // Getter
    //
    public float getX() {
        return x + 27;
    }

    public float getY() {
        return y - 20;
    }
}
