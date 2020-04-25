package cc.phil.firstgame;

import org.newdawn.slick.Graphics;

public class Ellipse implements Actor {
    // Membervariables
    //
    private float x;
    private float y;
    private float speed;

    // Constructor
    //
    public Ellipse(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 5;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 30, 10);
    }

    @Override
    public void update(int delta) {
        this.y += (float) delta / speed;
        this.x += (float) delta /speed;

        if (y > 600){
            y = 0;
        }

        if (x > 800){
            x = 0;
        }
    }
}
