package co.com.sofka.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.round.values.DiceId;
import co.com.sofka.domain.round.values.Face;


public class Dice extends Entity<DiceId> {
    private Face face;
    public Dice(DiceId entityId) {
        super(entityId);
    }
}
