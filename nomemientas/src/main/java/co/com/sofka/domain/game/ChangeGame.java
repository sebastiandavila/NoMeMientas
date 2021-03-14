package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.generic.EventChange;

public class ChangeGame extends EventChange {

    public ChangeGame(Game game) {
        apply((GameCreated event)->{
            game.players = event.players();
            game.started = Boolean.FALSE;
        });

        apply((GameStarted event) -> {
            if(Boolean.TRUE.equals(game.started)){
                throw new IllegalArgumentException("El juego ya esta inicializado");
            }
            game.started = Boolean.TRUE;
        });
    }
}
