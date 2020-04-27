package cc.phil.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class CannonBall implements Actor {
    // Membervariables
    //
    private float x,y;

    // Constructor
    //
    public CannonBall(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 15, 30);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y--;
    }
}
