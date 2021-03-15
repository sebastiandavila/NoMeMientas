package co.com.sofka.usecases.round;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.round.events.RoundCreated;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateRoundUseCaseTest {
    @Test
    void create() {
        var event = new GameStarted(Set.of(PlayerId.of("xxx"), PlayerId.of("fff"), PlayerId.of("red")));
        event.setAggregateRootId("hhhhhh");
        var useCase = new CreateRoundUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var rondaCreada = (RoundCreated) events.get(0);
        Assertions.assertEquals("hhhhhh", rondaCreada.gameId().value());
        Assertions.assertEquals(3, rondaCreada.playersId().size());
    }


}