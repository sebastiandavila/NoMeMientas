package co.com.sofka.domain.game;

import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.values.RoundId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game extends AggregateEvent<GameId> {
    protected Map<PlayerId, Player> players;
    protected Boolean started;
    protected Boolean winner;

    public Game(GameId entityId, List<Player> players) {
        super(entityId);
        Map<PlayerId, Player> newPlayers = new HashMap<>();
        players.forEach(player -> newPlayers.put(player.identity(), player));
        appendChange(new GameCreated(newPlayers)).apply();
    }

    private Game(GameId entityId){
        super(entityId);
        subscribe(new ChangeGame(this));
    }
    public static Game from(GameId entityId, List<DomainEvent> events){
        var game = new Game(entityId);
        events.forEach(game::applyEvent);
        return game;
    }

    public void startGame() {
        var jugadoresIds = players.keySet();
        appendChange(new GameStarted(jugadoresIds)).apply();
    }

    // public void startGame()
    //{appendChange(new GameStarted()).apply();}

    public Boolean Winner() {
        return winner;
    }

}
