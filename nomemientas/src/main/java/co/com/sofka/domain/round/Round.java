package co.com.sofka.domain.round;

import co.com.sofka.domain.game.ChangeGame;
import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.values.RoundId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Round extends AggregateEvent<RoundId> {

    protected List<Phase> phases;
    protected List<Dice> dices;
    protected GameId gameId;

    public Round(RoundId entityId, List<Player> players) {
        super(entityId);
        Map<PlayerId, Player> newPlayers = new HashMap<>();
        players.forEach(player -> newPlayers.put(player.identity(), player));
        appendChange(new GameCreated(newPlayers)).apply();
    }

    private Round(RoundId entityId){
        super(entityId);
        subscribe(new ChangeRound(this));
    }
    public static Round from(RoundId entityId, List<DomainEvent> events){
        var round = new Round(entityId);
        events.forEach(round::applyEvent);
        return round;
    }

}
