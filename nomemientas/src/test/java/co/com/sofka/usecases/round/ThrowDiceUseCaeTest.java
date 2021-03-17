package co.com.sofka.usecases.round;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.round.events.RoundCreated;
import co.com.sofka.domain.round.events.ThrewDice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


    class ThrowDiceUseCaseTest {

        @Test
        void threwDices(){
            var event = new RoundCreated(Set.of(PlayerId.of("xxx"), PlayerId.of("hhh")),
                    GameId.of("jjj"));
            event.setAggregateRootId("luisa");


            var useCase = new ThrowDiceUseCae();

            var events = UseCaseHandler
                    .getInstance()
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow()
                    .getDomainEvents();

            var threwDice = (ThrewDice) events.get(0);

            Assertions.assertEquals(6, threwDice.faces().size());

        }

    }