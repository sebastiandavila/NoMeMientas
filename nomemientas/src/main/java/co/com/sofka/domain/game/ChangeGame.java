package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.generic.EventChange;

public class ChangeGame extends EventChange {

    public ChangeGame(Game game) {
        apply((GameCreated event)->{
            game.players = event.players();
            game.started = Boolean.FALSE;
        });
    }
}
