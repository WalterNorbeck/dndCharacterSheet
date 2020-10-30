package co.beefchop.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopBannerEntity {
    private String characterName;
    private String characterClass;
    private int level;
    private String background;
    private String playerName;
    private String race;
    private String alignment;
    private int expPoints;
}
