package co.beefchop.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentEntity {
    private String equipment;
    private int copper;
    private int silver;
    private int electrum;
    private int gold;
    private int platinum;
    private int otherCurrency;
}
