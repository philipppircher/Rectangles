package cc.phil.snake;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.List;

public class Snake implements Actor {
    // Membervariables
    //
    private GameContainer gameContainer;
    private List<Element> elements;
    private Element firstElement, lastElement;
    private Direction directionOfFirstElement;

    // Constructor
    //
    public Snake(GameContainer gameContainer) {
        this.gameContainer = gameContainer;

        this.elements = new ArrayList<>();
        this.elements.add(new Element(null));
        this.elements.add(new Element(elements.get(0)));
        this.elements.add(new Element(elements.get(1)));

        // Set all elements to right
        for (int i = 0; i < elements.size()-1; i++) {
            elements.get(i).setDirection(Direction.RIGHT);
            elements.get(i).setX(500 + 20 * i);
            elements.get(i).setY(400);
        }

        this.directionOfFirstElement = Direction.RIGHT;
    }

    // Methodes
    //
    @Override
    public void render(Graphics graphics) {}

    @Override
    public void update(GameContainer gameContainer, int delta) {
        setDirectionOfFirstElement(gameContainer);
        elements.get(0).setDirection(directionOfFirstElement);
    }

    public void updateFirstLast() {
        this.firstElement = this.elements.get(0);
        this.lastElement = this.elements.get(elements.size() -1);
    }

    public void snakeMoveRoutine() {
        this.gameContainer.sleep(100);

        elements.set(0, lastElement);
    }

    private void setDirectionOfFirstElement(GameContainer gameContainer) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            this.directionOfFirstElement = Direction.RIGHT;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            this.directionOfFirstElement = Direction.LEFT;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            this.directionOfFirstElement = Direction.UP;
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_S)) {
            this.directionOfFirstElement = Direction.DOWN;
        }

        elements.get(0).setDirection(this.directionOfFirstElement);
    }

    public void addElement(){
        this.elements.add(new Element(this.elements.get(elements.size())));
    }
}
