package co.beefchop.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthSectionEntity {
    private int ac;
    private String initiative;
    private int speed;
    private int HPMax;
    private int HPCurrent;
    private int HPTemp;
    private String hitDice;
    private int deathSaveSuccessOne;
    private int deathSaveSuccessTwo;
    private int deathSaveSuccessThree;
    private int deathSaveFailOne;
    private int deathSaveFailTwo;
    private int deathSaveFailThree;
}
