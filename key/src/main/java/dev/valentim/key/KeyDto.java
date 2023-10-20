package dev.valentim.key;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class KeyDto {
    private Integer id;
    private UUID chave;

    public KeyDto() {
        this.chave = UUID.randomUUID();
    }
}
