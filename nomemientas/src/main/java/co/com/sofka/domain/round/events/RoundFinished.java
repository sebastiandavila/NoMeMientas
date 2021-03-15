package co.com.sofka.domain.round.events;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.DomainEvent;

public class RoundFinished extends DomainEvent {
    private final GameId gameId;

    public RoundFinished(GameId gameId) {
        super("nomemientan.ronda.rondafinalizada");
        this.gameId = gameId;
    }

    public GameId getJuegoId() {
        return gameId;
    }
}
