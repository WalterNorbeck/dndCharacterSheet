package co.beefchop.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {
    private String equipment;
    private String copper;
    private String silver;
    private String electrum;
    private String gold;
    private String platinum;
    private String otherCurrency;
}
