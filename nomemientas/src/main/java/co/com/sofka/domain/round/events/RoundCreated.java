package co.com.sofka.domain.round.events;

import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.round.Dice;
import co.com.sofka.domain.round.Phase;

import java.util.List;
import java.util.UUID;

public class RoundCreated extends DomainEvent {
    protected List<Phase> phases;
    protected List<Dice> dices;
    protected GameId gameId;
    public RoundCreated() {
        super("nomemientas.round.created");


    }
}
