package cc.phil.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {
    // Membervariables
    //
    private int width;
    private int height;

    private float speed;

    private float squareX;
    private float squareY;
    private float circleY;
    private float ovalX;

    private Direction squareDirection;
    private Direction circleDirection;
    private Direction ovalDirection;

    // Constructor
    //
    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.speed = 0;

        this.squareX = 100.0f;
        this.squareY = 100.0f;
        this.squareDirection = Direction.RIGHT;

        this.circleY = 100.0f;
        this.circleDirection = Direction.DOWN;

        this.ovalX = 100.0f;
        this.ovalDirection = Direction.RIGHT;

        this.width = 800;
        this.height = 600;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.speed = (float) delta / 2.5f;

        movingSquare();
        movingVerticalCicle();
        movingHorizontalOval();
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(squareX, squareY, 100, 100);
        graphics.drawRoundRect(50, circleY, 80, 80, 100);
        graphics.drawOval(ovalX, 50, 100, 30);
    }


    private void movingVerticalCicle() {
        if (circleDirection == Direction.DOWN) {
            if (circleY < height - 200) {
                circleY += speed;
            } else {
                circleDirection = Direction.UP;
            }
        }

        if (circleDirection == Direction.UP) {
            if (circleY > 100) {
                circleY -= speed;
            } else {
                circleDirection = Direction.DOWN;
            }
        }
    }

    private void movingHorizontalOval() {
        if (ovalDirection == Direction.RIGHT) {
            if (ovalX < width - 100) {
                ovalX += speed;
            } else {
                ovalDirection = Direction.LEFT;
            }
        }

        if (ovalDirection == Direction.LEFT) {
            if (ovalX > 50) {
                ovalX -= speed;
            } else {
                ovalDirection = Direction.RIGHT;
            }
        }
    }

    private void movingSquare() {
        // Moves from Left to Right
        if (squareDirection == Direction.RIGHT) {
            if (squareX < width - 200) {
                squareX += speed;
            } else {
                squareDirection = Direction.DOWN;
            }
        }

        if (squareDirection == Direction.DOWN) {
            if (squareY < height - 200) {
                squareY += speed;
            } else {
                squareDirection = Direction.LEFT;
            }
        }

        if (squareDirection == Direction.LEFT) {
            if (squareX > 100) {
                squareX -= speed;
            } else {
                squareDirection = Direction.UP;
            }
        }

        if (squareDirection == Direction.UP) {
            if (squareY > 100) {
                squareY -= speed;
            } else {
                squareDirection = Direction.RIGHT;
            }
        }
    }

    // Main
    //
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
