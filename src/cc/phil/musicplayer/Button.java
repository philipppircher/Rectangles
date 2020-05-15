package cc.phil.musicplayer;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


public class Button implements Actor {
    // Membervariables
    //
    private Image image;
    private float x, y;

    // Constructor
    //
    public Button(Image image, float x, float y){
        Image temp = image;
        this.image = temp.getScaledCopy(50, 50);
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        image.draw(this.x,this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
    }
}
