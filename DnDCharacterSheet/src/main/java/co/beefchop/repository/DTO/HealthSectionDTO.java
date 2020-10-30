package co.beefchop.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthSectionDTO {
    private String ac;
    private String initiative;
    private String speed;
    private String HPMax;
    private String HPCurrent;
    private String HPTemp;
    private String hitDice;
    private boolean deathSaveSuccessOne;
    private boolean deathSaveSuccessTwo;
    private boolean deathSaveSuccessThree;
    private boolean deathSaveFailOne;
    private boolean deathSaveFailTwo;
    private boolean deathSaveFailThree;
}
