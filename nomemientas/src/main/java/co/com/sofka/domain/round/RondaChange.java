package co.com.sofka.domain.round;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.events.ThrewDice;
import co.com.sofka.domain.round.values.DiceId;

import java.util.HashMap;

public class RondaChange extends EventChange {
    public RondaChange(Round round) {
        apply((RoundCreated event) -> {
            round.gameId = event.gameId();
            round.dices = new HashMap<>();
            round.phases = new HashMap<>();
            round.playersId = event.playersId();

        });

        apply((ThrewDice event) -> {
            event.faces().forEach((diceId, face) -> round.dices.put(diceId, new Dice(diceId)));
            event.faces().forEach((diceId, face) -> round.dices.get(diceId).setFace(face));
        });

    }
}
