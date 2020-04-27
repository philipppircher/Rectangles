package cc.phil.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle implements Actor {
    // Membervariables
    //
    private float x;
    private float y;
    private float speed;
    private DirectionHorizontal directionHorizontal;

    // Constructor
    //

    public Rectangle(float x, float y, float speed, DirectionHorizontal directionHorizontal) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.directionHorizontal = directionHorizontal;
    }

    // Methodes
    //
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10.0f, 10.0f);
    }

    public void update(GameContainer gameContainer, int delta) {
        if (this.directionHorizontal == DirectionHorizontal.RIGHT) {
            this.x += (float) delta / this.speed;

            if (this.x > 800) {
                this.x = 0;
            }
        } else {
            this.x -= (float) delta / this.speed;

            if (this.x < 0) {
                this.x = 800;
            }
        }
    }
}
