package cc.phil.snake;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnakeMainGame extends BasicGame {
    private List<Actor> actors;
    private AngelCodeFont printPostition;
    private Element elements;
    private Snake snake;
    private Food food;
    private static int score;
    private boolean isRectangleFieldActive = false;
    private static int[][] fields;
    private static final int fieldsInWidth = 40;
    private static final int fieldsInHeight = 30;
    private static final float sizeInPixelPerPart = 20.0f;     // allways 20.0f !!

    // Constructor
    //
    public SnakeMainGame(String title) {
        super(title);
    }

    // Methodes
    //
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        printPostition = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        actors = new ArrayList<>();
        /*
        elements = new Element();
        food = new Food(elements);
        */
        /*
        actors.add(elements);
        actors.add(new Element());
        actors.add(new Element());
        */
        this.snake = new Snake(gameContainer);
        actors.add(snake);
        //actors.add(food);
        score = 0;
        initializeFieldArray();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
        if (gameContainer.getInput().isKeyPressed(Input.KEY_R)) {
            if (this.isRectangleFieldActive) {
                this.isRectangleFieldActive = false;
            } else {
                this.isRectangleFieldActive = true;
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
        //printDebugOutput();
        drawRectangleFields(graphics);
    }

    // Main
    //
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SnakeMainGame("Snake"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void initializeFieldArray(){
        fields = new int[SnakeMainGame.getFieldsInWidth()][SnakeMainGame.getFieldsInHeight()];

        for (int i = 0; i < this.fieldsInWidth; i++) {
            for (int j = 0; j < this.fieldsInHeight; j++) {
                fields[i][j] = (int) this.sizeInPixelPerPart;
            }
        }
    }

    private void drawRectangleFields(Graphics graphics) {
        // Draw fields array over complete Screen
        if (this.isRectangleFieldActive) {
            for (int i = 0; i < this.fieldsInWidth; i++) {
                for (int j = 0; j < this.fieldsInHeight; j++) {
                    graphics.drawRect(i * sizeInPixelPerPart, j * sizeInPixelPerPart, sizeInPixelPerPart, sizeInPixelPerPart);
                }
            }
        }
    }

    private void printDebugOutput(){
        this.printPostition.drawString(550, 400, "snake-X: ");
        this.printPostition.drawString(550, 430, "snake-Y: ");
        this.printPostition.drawString(550, 460, "food-X: " + food.getX());
        this.printPostition.drawString(550, 490, "food-Y: " + food.getY());
        this.printPostition.drawString(550, 520, "score: " + score);
    }

    // Getter - Setter
    //
    public static void setScore(int value) {
        score += value;
    }

    public static int getFieldsInWidth() {
        return fieldsInWidth;
    }

    public static int getFieldsInHeight() {
        return fieldsInHeight;
    }

    public static float getSizeInPixelPerPart() {
        return sizeInPixelPerPart;
    }
}
