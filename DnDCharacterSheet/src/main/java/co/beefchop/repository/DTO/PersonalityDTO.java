package co.beefchop.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalityDTO {
    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;
    private String featuresAndTriats;
}
