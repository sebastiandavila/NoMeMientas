package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

public class GameStarted extends DomainEvent {

    public GameStarted() {
        super("nomemientas.game.started");
    }
}
