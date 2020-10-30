package co.beefchop.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopBannerDTO {
    private String characterName;
    private String characterClass;
    private String background;
    private String playerName;
    private String race;
    private String alignment;
    private String level;
    private String expPoints;
}
