package cc.phil.musicplayer;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.List;

public class MainMusicPlayer extends BasicGame {
    // Membervariables
    //
    private List<Actor> actors;
    private static final int BUTTON_Y_POSITION = 500;

    public MainMusicPlayer(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        Button playButton = new Button(new Image("testdata/play.png"), 50, BUTTON_Y_POSITION);
        Button stopButton = new Button(new Image("testdata/stop.png"), 150, BUTTON_Y_POSITION);
        Button nextSongButton = new Button(new Image("testdata/nextsong.png"), 250, BUTTON_Y_POSITION);
        Button lastSongButton = new Button(new Image("testdata/lastsong.png"), 350, BUTTON_Y_POSITION);

        actors = new ArrayList<>();
        actors.add(playButton);
        actors.add(stopButton);
        actors.add(nextSongButton);
        actors.add(lastSongButton);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

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
            AppGameContainer container = new AppGameContainer(new MainMusicPlayer("MusicPlayer"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
