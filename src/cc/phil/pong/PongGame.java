package cc.phil.pong;

import cc.phil.firstgame.actors.Actor;
import cc.phil.firstgame.actors.CollisionActor;
import org.newdawn.slick.*;
import java.util.ArrayList;


public class PongGame extends BasicGame {

    // Membervariables
    //
    private ArrayList<Actor> actors;

    // Constructor
    //
    public PongGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        PaddlePlayer paddlePlayer= new PaddlePlayer();
        PaddleComputer paddleComputer = new PaddleComputer();

        ArrayList<CollisionActor> collisionActors = new ArrayList<>();
        collisionActors.add(paddleComputer);
        collisionActors.add(paddlePlayer);

        Ball ball = new Ball(collisionActors);
        paddleComputer.addTargetToMove(ball);

        actors.add(paddlePlayer);
        actors.add(paddleComputer);
        actors.add(ball);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    // Main
    //
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new PongGame("Pong"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
