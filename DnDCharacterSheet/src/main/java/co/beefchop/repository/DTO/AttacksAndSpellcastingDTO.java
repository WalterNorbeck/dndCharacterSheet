package co.beefchop.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttacksAndSpellcastingDTO {
    private String attackName;
    private String attackModifier;
    private String damageBase;
    private String damageMod;
    private String damageType;
    private String damageRange;
    private String attacksAndSpellcasting;
}
