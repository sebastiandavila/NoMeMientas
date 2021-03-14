package co.com.sofka.usecases;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.commands.CreateGame;
import co.com.sofka.domain.game.values.GameId;

public class CreateGameUseCase extends UseCase<RequestCommand<CreateGame>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateGame> createGameRequestCommand) {
        var command = createGameRequestCommand.getCommand();
        var GameId = new GameId();
        var game = new Game(new GameId(), command.players());
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }
}
