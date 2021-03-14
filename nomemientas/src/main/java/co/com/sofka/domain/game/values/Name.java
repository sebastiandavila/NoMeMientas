package co.com.sofka.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {
    private String value;

    public Name(String value){
        this.value = Objects.requireNonNull(value);
        if(value.isEmpty()){
            throw new IllegalArgumentException("No puede ser vacio el nombre del jugador");
        }
    }
    public String value(){
        return value;
    }

}
