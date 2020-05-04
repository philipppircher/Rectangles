package cc.phil.firstgame.actors;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Circle implements CollisionActor {

    protected float x;
    protected float y;
    protected float speed;
    private float diameter;
    private Shape collisionShape;

    // Constructor
    //
    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(40) + 10;
        this.diameter = random.nextInt(20) + 20;
        this.collisionShape = new org.newdawn.slick.geom.Circle(this.x, this.y, this.diameter/2);
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
        graphics.setColor(Color.magenta);
        graphics.draw(collisionShape);
        graphics.setColor(Color.white);
    }

    public void update(GameContainer gameContainer, int delta) {
        // Code underneath for growing Circles
        //this.diameter += (float) delta / 100;

        this.y += (float) delta / speed;

        if (this.y > 600) {
            this.y = 0;
        }

        collisionShape.setX(this.x);
        collisionShape.setY(this.y);
    }

    // Getter/Setter
    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    @Override
    public String getString() {
        return getClass().getSimpleName() + " collision";
    }
}
