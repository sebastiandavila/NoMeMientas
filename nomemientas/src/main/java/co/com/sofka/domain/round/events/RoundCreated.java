package co.com.sofka.domain.round.events;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.Dice;
import co.com.sofka.domain.round.Phase;
import co.com.sofka.domain.round.values.RoundId;

import java.util.List;
import java.util.Set;


public class RoundCreated extends DomainEvent {
    private final Set<PlayerId> playerIds;
    private final GameId gameId;

    public RoundCreated(Set<PlayerId> playerIds, GameId gameId) {
        super("nomemientas.round.created");
        this.playerIds = playerIds;
        this.gameId = gameId;
    }

    public Set<PlayerId> playersId() {
        return playerIds;
    }

    public GameId gameId() {
        return gameId;
    }
}
