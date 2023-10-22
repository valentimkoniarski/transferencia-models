package dev.valentim.key;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Embeddable
@Getter
@Setter
public class Key {

    @Column(name = "chave")
    private UUID chave;

    public Key() {
        this.chave = UUID.randomUUID();
    }
}
