package co.com.sofka.domain.round.values;

import co.com.sofka.domain.generic.Identity;

public class PhaseId extends Identity {
    private PhaseId(String id) {
        super(id);
    }

    public PhaseId()
    {

    }

    public static PhaseId of(String id){
        return new PhaseId(id);
    }
}
