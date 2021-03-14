package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Money implements ValueObject<Double> {
    private Double value;
    private String currency;

    public Money(Double value, String currency){
        this.value = Objects.requireNonNull(value);
        this.currency = currency;
        if(value < 0){
            throw new IllegalArgumentException("EL dinero no puede ser negativo");
        }
    }

    @Override
    public Double value() {
        return value;
    }
    public String moneda() {
        return currency;
    }

    public Money increase(Double money, String currency) {
        return new Money(money+this.value, currency);
    }
}
