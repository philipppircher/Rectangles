package cc.phil.snowflake;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor {
    // Methodes
    //
    private float x;
    private float y;
    private Snowworld.SnowflakeSize size;
    private float speed;
    private float diameter;


    // Constructor
    //
    public Snowflake(float x, float y, Snowworld.SnowflakeSize size) {
        this.x = x;
        this.y = y;
        this.size = size;

        if (size == Snowworld.SnowflakeSize.LARGE) {
            speed = 2;
            diameter = 60;
        } else if (size == Snowworld.SnowflakeSize.MEDIUM) {
            speed = 5;
            diameter = 30;
        } else if (size == Snowworld.SnowflakeSize.SMALL) {
            speed = 10;
            diameter = 10;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.diameter, this.diameter);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y += (float) delta / speed;

        if (this.y > 600) {
            randomPosition();
        }
    }

    public void randomPosition() {
        Random random = new Random();
        int randomValue = 0;

        randomValue = random.nextInt(600);
        this.y = -randomValue;

        randomValue = random.nextInt(800);
        this.x = randomValue;
    }
}
