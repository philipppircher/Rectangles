package cc.phil.firstgame.actors;

import cc.phil.firstgame.actors.Actor;
import org.newdawn.slick.geom.Shape;

public interface CollisionActor extends Actor {
    public Shape getShape();
}
