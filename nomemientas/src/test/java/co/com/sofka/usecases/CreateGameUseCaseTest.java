package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.commands.CreateGame;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.Name;
import co.com.sofka.domain.game.values.PlayerId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateGameUseCaseTest {

    @Test
    void CreateGame(){
        var command = new CreateGame(List.of(
                new Player(PlayerId.of("Identificacion1"), new Name("Yo"), new Money(10000.0, "COP")),
                new Player(PlayerId.of("Identificacion2"), new Name("Yo"), new Money(10000.0, "COP")),
                new Player(PlayerId.of("Identificacion3"), new Name("Yo"), new Money(10000.0, "COP"))
        ));
        var createGameUseCase = new CreateGameUseCase();
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(createGameUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var gameCreated = (GameCreated)events.get(0);
        Assertions.assertEquals(3, gameCreated.players().size());
        Assertions.assertEquals("Yo", gameCreated.players().get(PlayerId.of("Identificacion1")).name().value());
        Assertions.assertEquals("Yo", gameCreated.players().get(PlayerId.of("Identificacion2")).name().value());
        Assertions.assertEquals("Yo", gameCreated.players().get(PlayerId.of("Identificacion3")).name().value());
        gameCreated.players().forEach((jugadorId, jugador) -> System.out.println(jugador.name().value()));
    }

}