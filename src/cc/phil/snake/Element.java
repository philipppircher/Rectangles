package cc.phil.snake;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Element extends SnakeGameObject {
    // Membervariables
    //
    private Direction direction;
    private Element nextElement;

    // Constructor
    //
    public Element(Element element) {
        this.nextElement = element;
        this.direction = Direction.RIGHT;
    }

    // Methodes
    //
    @Override
    public void render(Graphics graphics) {
        super.render(graphics, Color.green);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);     // Call super here to set collisionshape to current x,y of snake
    }

    // Getter / Setter
    //
    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }
}
