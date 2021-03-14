package co.com.sofka.domain.game.events;

import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class GameCreated extends DomainEvent {
    private Map<PlayerId, Player> players;
    public GameCreated(Map<PlayerId, Player> newPlayers) {
        super("nomemientas.game.created");
        players = newPlayers;
    }

    public Map<PlayerId, Player> players(){
        return players;
    }
}
