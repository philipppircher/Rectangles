package cc.phil.patternSnake;

import cc.phil.firstgame.actors.Actor;
import cc.phil.firstgame.actors.CollisionActor;
import cc.phil.snake.Direction;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame extends BasicGame {
    private List<Actor> actors;
    public static final int GRID_SIZE = 40;
    private Element tail, tip;
    private int clock = 250;
    private Direction direction;
    private int elapsedTime;
    private List<CollisionActor> collisionActors;

    public SnakeGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Element e1 = new Element(3, 3);
        Element e2 = new Element(4, 3);
        Element e3 = new Element(5, 3);
        Element e4 = new Element(6, 3);

        e1.setNext(e2);
        e2.setNext(e3);
        e3.setNext(e4);
        this.tail = e1;
        this.tip = e4;

        this.actors.add(e1);
        this.actors.add(e2);
        this.actors.add(e3);
        this.actors.add(e4);

        this.direction = Direction.RIGHT;
        this.elapsedTime = 0;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : actors) {
            actor.update(gameContainer, delta);
        }

        // Use delta and elapsed time, instead of using gamecontainer.sleep() -> cause slowdown
        this.elapsedTime += delta;

        if (this.elapsedTime > clock) {
            elapsedTime = 0;
            Element temp = this.tail;
            this.tail = temp.getNext();
            temp.setNext(null);
            tip.setNext(temp);

            int newX = this.tip.getX();
            int newY = this.tip.getY();

            switch (this.direction) {
                case RIGHT:
                    newX++;
                    if (newX > gameContainer.getWidth() / GRID_SIZE) {
                        newX = 0;
                    }
                    break;
                case LEFT:
                    newX--;
                    if (newX < 0) {
                        newX = gameContainer.getWidth() / GRID_SIZE;
                    }
                    break;
                case UP:
                    newY--;
                    if (newY < 0) {
                        newY = gameContainer.getHeight() / GRID_SIZE;
                    }
                    break;
                case DOWN:
                    newY++;
                    if (newY > gameContainer.getHeight() / GRID_SIZE) {
                        newY = 0;
                    }
                    break;
            }

            temp.setX(newX);
            temp.setY(newY);

            // logic for directions
            moveDirection(gameContainer);

            this.tip = temp;

            /*
            if (this.getShape().intersects(collisionActor.getShape())) {
                setNewRandomPosition();
                SnakeMainGame.setScore(10);
            }*/
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : actors) {
            actor.render(graphics);
        }
    }

    // Main
    //
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SnakeGame("SnakePattern"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void moveDirection(GameContainer gameContainer) {
        moveDown(gameContainer);
        moveUp(gameContainer);
        moveLeft(gameContainer);
        moveRight(gameContainer);
    }

    private void moveRight(GameContainer gameContainer) {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_D) && this.direction != Direction.LEFT) {
            this.direction = Direction.RIGHT;
        }
    }

    private void moveLeft(GameContainer gameContainer) {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_A) && this.direction != Direction.RIGHT) {
            this.direction = Direction.LEFT;
        }
    }

    private void moveUp(GameContainer gameContainer) {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_W) && this.direction != Direction.DOWN) {
            this.direction = Direction.UP;
        }
    }

    private void moveDown(GameContainer gameContainer) {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_S) && this.direction != Direction.UP) {
            this.direction = Direction.DOWN;
        }
    }
}
