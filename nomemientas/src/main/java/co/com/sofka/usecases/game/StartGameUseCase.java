package co.com.sofka.usecases.game;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.domain.game.Game;
import co.com.sofka.domain.game.commands.StartGame;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class StartGameUseCase extends UseCase<RequestCommand<StartGame>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<StartGame> startGameRequestCommand) {
        var command = startGameRequestCommand.getCommand();
        var game = Game.from(command.gameId(), retrieveEvents());
        try {
        game.startGame();
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        } catch (RuntimeException e){
            emit().onError(new BusinessException(game.identity().value(), e.getMessage()));
        }
    }
}
