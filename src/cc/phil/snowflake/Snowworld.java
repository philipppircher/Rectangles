package cc.phil.snowflake;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;

public class Snowworld extends BasicGame {
    // Membervariables
    //
    public enum SnowflakeSize {LARGE, MEDIUM, SMALL}

    ;
    private ArrayList<Actor> actors = new ArrayList<>();

    // Constructor
    //
    public Snowworld(String title) {
        super(title);
    }

    // Methodes
    //
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        Random random = new Random();

        int randomValue = 0;

        for (int i = 0; i < 50; i++) {
            randomValue = random.nextInt(400);
            actors.add(new Snowflake(random.nextInt(800), random.nextInt(600), SnowflakeSize.LARGE));
            actors.add(new Snowflake(random.nextInt(800), random.nextInt(600), SnowflakeSize.MEDIUM));
            actors.add(new Snowflake(random.nextInt(800), random.nextInt(600), SnowflakeSize.SMALL));
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : actors) {
            actor.update(gameContainer, delta);
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
            AppGameContainer container = new AppGameContainer(new Snowworld("Snowworld"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
