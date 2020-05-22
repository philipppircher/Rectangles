package cc.phil.snake;

import cc.phil.firstgame.actors.CollisionActor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Food extends SnakeGameObject {
    // Membervariables
    //
    private Random random = new Random();
    private CollisionActor collisionActor;

    // Constructor
    //
    public Food(CollisionActor collisionActor) {
        this.collisionActor = collisionActor;       // Snake object
        setNewRandomPosition();
    }

    // Methodes
    //
    @Override
    public void render(Graphics graphics) {
        super.render(graphics, Color.magenta);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        checkFoodCollideWithSnake();
    }

    private void checkFoodCollideWithSnake() {
        if (this.getShape().intersects(collisionActor.getShape())) {
            setNewRandomPosition();
            SnakeMainGame.setScore(10);
        }
    }

    private void setNewRandomPosition() {
        int nextWidthField = random.nextInt(SnakeMainGame.getFieldsInHeight());
        int nextHeightField = random.nextInt(SnakeMainGame.getFieldsInHeight());
        this.x = nextWidthField * SnakeMainGame.getSizeInPixelPerPart();
        this.y = nextHeightField * SnakeMainGame.getSizeInPixelPerPart();
    }
}
