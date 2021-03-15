package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Collection;
import java.util.Set;

public class GameStarted extends DomainEvent {
    private final Set<PlayerId> playerIds;

    public GameStarted(Set<PlayerId> playerIds) {
        super("nomemientas.game.started");
        this.playerIds = playerIds;
    }

    public Set<PlayerId> getJugadoresIds() {
        return playerIds;
    }
}
