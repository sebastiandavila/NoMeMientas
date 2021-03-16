package co.com.sofka.domain.round.events;

import co.com.sofka.domain.generic.DomainEvent;

import co.com.sofka.domain.round.values.DiceId;
import co.com.sofka.domain.round.values.Face;
import co.com.sofka.domain.round.values.RoundId;

import java.util.Map;

public class ThrewDice extends DomainEvent {
    private final RoundId roundId;
    private final Map<DiceId, Face> faces;

    public ThrewDice(RoundId roundId, Map<DiceId, Face> faces) {
        super("nomemientas.round.threwdice");
        this.roundId = roundId;
        this.faces = faces;
    }

    public RoundId roundId() {
        return roundId;
    }

    public Map<DiceId, Face> faces() {
        return faces;
    }
}