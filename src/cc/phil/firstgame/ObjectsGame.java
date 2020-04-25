package cc.phil.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    // Membervariables
    //
    private List<Actor> actors;

    // Constructor
    //
    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600),
                    random.nextInt(50), DirectionHorizontal.LEFT);
            actors.add(rectangle);
        }

        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            actors.add(circle);
        }

        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(800), random.nextInt(600));
            actors.add(ellipse);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor: this.actors){
            actor.update(delta);
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor: this.actors){
            actor.render(graphics);
        }
    }

/*
    private void movingVerticalCicle() {
        if (circleDirection == Direction.DOWN) {
            if (circleY < height - 200) {
                circleY += speed;
            } else {
                circleDirection = Direction.UP;
            }
        }

        if (circleDirection == Direction.UP) {
            if (circleY > 100) {
                circleY -= speed;
            } else {
                circleDirection = Direction.DOWN;
            }
        }
    }

    private void movingHorizontalOval() {
        if (ovalDirection == Direction.RIGHT) {
            if (ovalX < width - 100) {
                ovalX += speed;
            } else {
                ovalDirection = Direction.LEFT;
            }
        }

        if (ovalDirection == Direction.LEFT) {
            if (ovalX > 50) {
                ovalX -= speed;
            } else {
                ovalDirection = Direction.RIGHT;
            }
        }
    }

    private void movingSquare() {
        // Moves from Left to Right
        if (squareDirection == Direction.RIGHT) {
            if (squareX < width - 200) {
                squareX += speed;
            } else {
                squareDirection = Direction.DOWN;
            }
        }

        if (squareDirection == Direction.DOWN) {
            if (squareY < height - 200) {
                squareY += speed;
            } else {
                squareDirection = Direction.LEFT;
            }
        }

        if (squareDirection == Direction.LEFT) {
            if (squareX > 100) {
                squareX -= speed;
            } else {
                squareDirection = Direction.UP;
            }
        }

        if (squareDirection == Direction.UP) {
            if (squareY > 100) {
                squareY -= speed;
            } else {
                squareDirection = Direction.RIGHT;
            }
        }
    }
    */

    // Main
    //
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
