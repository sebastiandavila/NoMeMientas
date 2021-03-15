package co.com.sofka.usecases.round;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.round.Round;
import co.com.sofka.domain.round.values.RoundId;


public class CreateRoundUseCase extends UseCase<TriggeredEvent<GameStarted>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<GameStarted> input) {
        var event = input.getDomainEvent();
        var roundId = new RoundId();
        if (event.getJugadoresIds().size() < 2) {
            throw new BusinessException(roundId.value(), "No se puede crear la ronda por falta de jugadores");
        }
        var gameId = GameId.of(event.aggregateRootId());
        var round = new Round(roundId, gameId, event.getJugadoresIds());


        emit().onResponse(new ResponseEvents(round.getUncommittedChanges()));
    }
}
