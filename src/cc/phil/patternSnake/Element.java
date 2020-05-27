package cc.phil.patternSnake;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Element implements Actor {
    private int x,y;
    private Element next;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x * SnakeGame.GRID_SIZE, this.y * SnakeGame.GRID_SIZE,
                SnakeGame.GRID_SIZE - 1, SnakeGame.GRID_SIZE - 2);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
