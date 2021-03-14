package co.com.sofka.domain.game;

import co.com.sofka.domain.game.values.Money;
import co.com.sofka.domain.game.values.Name;
import co.com.sofka.domain.game.values.PlayerId;
import co.com.sofka.domain.generic.Entity;

public class Player extends Entity<PlayerId> {
    private Name name;
    private Money money;

    public Player(PlayerId entityId, Name name, Money money) {
        super(entityId);
        this.name = name;
        this.money = money;
    }

    public void earnMoney(Double money) {
        this.money = this.money.increase(money, this.money.moneda());
    }

    public Name name(){
        return name;
    }
    public Money money(){
        return money;
    }
}
