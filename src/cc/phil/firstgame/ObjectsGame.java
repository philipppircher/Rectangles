package cc.phil.firstgame;

import cc.phil.firstgame.actors.*;
import cc.phil.firstgame.movement.LeftMoveStrategy;
import cc.phil.firstgame.movement.MoveStrategy;
import cc.phil.firstgame.movement.RightMoveStrategy;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    // Membervariables
    //
    private List<Actor> actors;
    private Rocket rocket;

    // Constructor
    //
    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Random random = new Random();

        Rocket rocket = new Rocket();
        this.rocket = rocket;
        this.actors.add(rocket);


        // Rectangle leftMoveStrategy
        for (int i = 0; i < 5; i++) {
            MoveStrategy moveStrategy =
                    new LeftMoveStrategy(random.nextInt(600), random.nextInt(600), random.nextInt(50), false);

            Rectangle rectangle = new Rectangle(moveStrategy);

            actors.add(rectangle);
            this.rocket.addCollisionPartner(rectangle);
        }

        // Rectangle rightMoveStrategy
        for (int i = 0; i < 5; i++) {
            MoveStrategy moveStrategy =
                    new RightMoveStrategy(random.nextInt(600), random.nextInt(600), random.nextInt(50), false);

            Rectangle rectangle = new Rectangle(moveStrategy);

            actors.add(rectangle);
            this.rocket.addCollisionPartner(rectangle);
        }

        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
            this.rocket.addCollisionPartner(circle);
        }

        RightCircle rc1 = new RightCircle();
        actors.add(rc1);

        LeftCircle lc1 = new LeftCircle();
        actors.add(lc1);


        for (int i = 0; i < 10; i++) {
            MoveStrategy moveStrategy =
                    new RightMoveStrategy(random.nextInt(800), random.nextInt(600), random.nextInt(50), false);
            Ellipse ellipse = new Ellipse(moveStrategy);
            this.actors.add(ellipse);
        }

        for (int i = 0; i < 4; i++) {
            MoveStrategy moveStrategy =
                    new LeftMoveStrategy(random.nextInt(800), random.nextInt(600), random.nextInt(50), false);
            RectangleFilled rectangleFilled = new RectangleFilled(moveStrategy);
            this.actors.add(rectangleFilled);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
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

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            CannonBall cannonBall = new CannonBall(this.rocket.getX(), this.rocket.getY());
            this.actors.add((cannonBall));
        }
    }

    // Main
    //
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
