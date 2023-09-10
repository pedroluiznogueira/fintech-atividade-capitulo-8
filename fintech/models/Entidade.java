package fintech.models;

import java.util.UUID;

public class Entidade {
    private final UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }
}
