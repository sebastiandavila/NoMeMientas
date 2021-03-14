package co.com.sofka.domain.game.commands;

import co.com.sofka.domain.game.Player;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class CreateGame implements Command {
    private final List<Player> players;

    public CreateGame(List<Player> players) {
        this.players = players;
    }

    public List<Player> players() {
        return players;
    }
}
