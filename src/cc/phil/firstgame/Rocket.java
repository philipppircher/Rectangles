package cc.phil.firstgame;

import org.newdawn.slick.*;

public class Rocket implements Actor {
    // Membervariables
    //
    private Image rocketImage;
    private float x, y;
    private float speed;

    // Constructor
    //
    public Rocket() throws SlickException {
        Image temp = new Image("testdata/rocket.png");
        this.rocketImage = temp.getScaledCopy(70, 70);
        this.x = 100;
        this.y = 100;
        this.speed = 5.0f;
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        // Rocket moves up
        if (gameContainer.getInput().isKeyDown(Input.KEY_W)){
            if (this.y > 0) {
                this.y -= (float) delta / this.speed;
            }
        }

        // Rocket moves down
        if (gameContainer.getInput().isKeyDown(Input.KEY_S)){
            if (this.y < 530) {
                this.y += (float) delta / this.speed;
            }
        }

        // Rocket moves right
        if (gameContainer.getInput().isKeyDown(Input.KEY_D)){
            if (this.x < 730) {
                this.x += (float) delta / this.speed;
            }
        }

        // Rocket moves left
        if (gameContainer.getInput().isKeyDown(Input.KEY_A)){
            if (this.x > 0) {
                this.x -= (float) delta / this.speed;
            }
        }
    }

    // Getter
    //
    public float getX() {
        return x + 27;
    }

    public float getY() {
        return y - 20;
    }
}
