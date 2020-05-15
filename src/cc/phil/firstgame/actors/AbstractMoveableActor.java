package cc.phil.firstgame.actors;

import cc.phil.firstgame.movement.MoveStrategy;
import org.newdawn.slick.GameContainer;

public abstract class AbstractMoveableActor implements CollisionActor {
    // Membervariables
    //
    protected MoveStrategy moveStrategy;

    // Constructor
    //
    public AbstractMoveableActor(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    // Methodes
    //
    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.moveStrategy.update(delta);
    }
}
