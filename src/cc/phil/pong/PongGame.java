package cc.phil.pong;

import org.newdawn.slick.AngelCodeFont;
import cc.phil.firstgame.actors.Actor;
import cc.phil.firstgame.actors.CollisionActor;
import org.newdawn.slick.*;

import java.util.ArrayList;


public class PongGame extends BasicGame {

    // Membervariables
    //
    private ArrayList<Actor> actors;
    private AngelCodeFont fontShowScore;
    private AngelCodeFont fontShowWinner;
    private Ball ball;
    private String printScore;
    private String printWinner;
    private final int SCORETOWIN = 3;
    private boolean hasWinner = false;

    // Constructor
    //
    public PongGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        fontShowScore = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        fontShowWinner = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        this.actors = new ArrayList<>();
        PaddlePlayer paddlePlayer = new PaddlePlayer();
        PaddleComputer paddleComputer = new PaddleComputer();

        ArrayList<CollisionActor> collisionActors = new ArrayList<>();
        collisionActors.add(paddleComputer);
        collisionActors.add(paddlePlayer);

        Ball ball = new Ball(collisionActors);
        this.ball = ball;
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

        if (ball.scoreComputer == SCORETOWIN) {
            ball.scoreComputer = 0;
            ball.scorePlayer = 0;
            printWinner = "Computer Wins";
            this.hasWinner = true;
        }

        if (ball.scorePlayer == SCORETOWIN) {
            ball.scoreComputer = 0;
            ball.scorePlayer = 0;
            printWinner = "Player Wins";
            this.hasWinner = true;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        printScore = this.ball.scorePlayer + " : " + this.ball.scoreComputer;
        fontShowScore.drawString(725, 10, printScore, Color.magenta);

        if (this.hasWinner){
            fontShowWinner.drawString(300, 300, printWinner, Color.magenta);
        }

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
