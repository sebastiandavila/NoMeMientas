package co.com.sofka.usecases.round;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.round.commands.CreateRound;


public class CreateRoundUseCase extends UseCase<RequestCommand<CreateRound>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CreateRound> createRoundRequestCommand) {

    }
}
