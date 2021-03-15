package co.com.sofka.domain.round;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.values.DiceId;

import java.util.HashMap;

public class RondaChange extends EventChange {
    public RondaChange(Round round) {
        apply((RoundCreated event) -> {
            round.gameId = event.gameId();
            round.dices = new HashMap<>();
            round.phases = new HashMap<>();
            round.playersId = event.playersId();

            for (var i = 1; i <= 6; i++) {//inicializar dados
                round.dices.put(DiceId.of(i), new Dice(DiceId.of(i)));
            }
        });

    }
}
