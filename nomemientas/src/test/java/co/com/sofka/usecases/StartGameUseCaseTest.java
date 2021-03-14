package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.game.commands.StartGame;
import co.com.sofka.domain.game.events.GameCreated;
import co.com.sofka.domain.game.events.GameStarted;
import co.com.sofka.domain.game.values.GameId;
import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.Name;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecases.game.StartGameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StartGameUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void startgame(){
        var gameId = GameId.of("ffff");
        var command = new StartGame(gameId);

        when(repository.getEventsBy(gameId.value())).thenReturn(eventStored());

        var startGameUseCase = new StartGameUseCase();
        startGameUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(gameId.value())
                .syncExecutor(startGameUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (GameStarted)events.get(0);
        Assertions.assertEquals(gameId.value(), event.aggregateRootId());
    }

    @Test
    void gamestarted(){
        var gameId = GameId.of("ffff");
        var command = new StartGame(gameId);
        var events = new ArrayList<>(eventStored());
        events.add(new GameStarted());
        when(repository.getEventsBy(gameId.value())).thenReturn(events);

        var startGameUseCase = new StartGameUseCase();
        startGameUseCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class,() ->
                UseCaseHandler.getInstance()
                        .setIdentifyExecutor(gameId.value())
                        .syncExecutor(startGameUseCase, new RequestCommand<>(command))
                        .orElseThrow(), "El juego ya ha iniciado"
        );
    }

    private List<DomainEvent> eventStored() {
        return List.of(new GameCreated(Map.of(
                PlayerId.of("xxxx"), new Player(PlayerId.of("xxxx"), new Name("Raul Alzate"), new Money(100.0,"US")),
                PlayerId.of("ffff"), new Player(PlayerId.of("ffff"), new Name("Andres"), new Money(100.0,"US")),
                PlayerId.of("tttt"), new Player(PlayerId.of("tttt"), new Name("Camilo"), new Money(100.0,"US"))
        )));
    }
}