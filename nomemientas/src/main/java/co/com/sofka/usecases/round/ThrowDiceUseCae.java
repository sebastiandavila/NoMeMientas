package co.com.sofka.usecases.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.round.Round;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.values.Face;
import co.com.sofka.domain.round.values.RoundId;

import java.util.List;
import java.util.Map;

public class ThrowDiceUseCae extends UseCase<TriggeredEvent<RoundCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RoundCreated> roundCreatedTriggeredEvent) {
        var event = roundCreatedTriggeredEvent.getDomainEvent();
        var roundId = RoundId.of(event.aggregateRootId());

        var round = Round.from(roundId, List.of(event));

        round.tirarDados();
        emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));

    }
}
