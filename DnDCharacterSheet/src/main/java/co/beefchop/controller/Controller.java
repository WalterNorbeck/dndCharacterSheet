package co.beefchop.controller;

import co.beefchop.repository.DTO.*;
import co.beefchop.repository.entities.*;
import co.beefchop.repository.repository.Repository;


public class Controller {
    private Repository repository;
    private TopBannerDTO topBannerDTO = new TopBannerDTO();

    private int ID;

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public Controller(Repository r) {
        this.repository = r;
    }

    //Retrieve id using character name
    public int getId(String charName) {
        return repository.getId(charName);
    }

    //SAVE

    //Top Banner
    public void saveTopBanner(String charName,
                              String charClass,
                              String level,
                              String background,
                              String playerName,
                              String race,
                              String alignment,
                              String expPoints) {
        int lvl = Integer.parseInt(level);
        int xp = Integer.parseInt(expPoints);
        repository.saveTopBanner( charName, charClass, lvl, background, playerName, race, alignment, xp);
    }

    //Abilities
    public void saveAbilities(String charName,
                              String strength,
                              String dexterity,
                              String constitution,
                              String intelligence,
                              String wisdom,
                              String charisma) {
        int strNum = Integer.parseInt(strength);
        int dexNum = Integer.parseInt(dexterity);
        int conNum = Integer.parseInt(constitution);
        int intNum = Integer.parseInt(intelligence);
        int wisNum = Integer.parseInt(wisdom);
        int chaNum = Integer.parseInt(charisma);
        repository.saveAbilities(charName, strNum, dexNum, conNum, intNum, wisNum, chaNum);
    }

    //Skills
    public int isChecked(boolean checkbox) {
        if (checkbox) {
            return 1;
        } else {
            return 0;
        }
    }

    public void saveSkills(String charName,
                           String inspiration,
                           boolean strSTProf,
                           boolean conSTProf,
                           boolean dexSTProf,
                           boolean intSTProf,
                           boolean wisSTProf,
                           boolean chaSTProf,
                           boolean acrobaticsProf,
                           boolean animalHandlingProf,
                           boolean arcanaProf,
                           boolean athleticsProf,
                           boolean deceptionProf,
                           boolean historyProf,
                           boolean insightProf,
                           boolean intimidationProf,
                           boolean investigationProf,
                           boolean medicineProf,
                           boolean natureProf,
                           boolean perceptionProf,
                           boolean performanceProf,
                           boolean persuasionProf,
                           boolean religionProf,
                           boolean sleightOfHandProf,
                           boolean stealthProf,
                           boolean survivalProf,
                           boolean acrobaticsExpert,
                           boolean animalHandlingExpert,
                           boolean arcanaExpert,
                           boolean athleticsExpert,
                           boolean deceptionExpert,
                           boolean historyExpert,
                           boolean insightExpert,
                           boolean intimidationExpert,
                           boolean investigationExpert,
                           boolean medicineExpert,
                           boolean natureExpert,
                           boolean perceptionExpert,
                           boolean performanceExpert,
                           boolean persuasionExpert,
                           boolean religionExpert,
                           boolean sleightOfHandExpert,
                           boolean stealthExpert,
                           boolean survivalExpert) {
        int insp = Integer.parseInt(inspiration);
        int strengthSTProf = isChecked(strSTProf);
        int dexteritySTProf = isChecked(dexSTProf);
        int constitutionSTProf = isChecked(conSTProf);
        int intelligenceSTProf = isChecked(intSTProf);
        int wisdomSTProf = isChecked(wisSTProf);
        int charismaSTProf = isChecked(chaSTProf);
        int acroProf = isChecked(acrobaticsProf);
        int animProf = isChecked(animalHandlingProf);
        int arcaProf = isChecked(arcanaProf);
        int athlProf = isChecked(athleticsProf);
        int deceProf = isChecked(deceptionProf);
        int histProf = isChecked(historyProf);
        int insiProf = isChecked(insightProf);
        int intiProf = isChecked(intimidationProf);
        int inveProf = isChecked(investigationProf);
        int mediProf = isChecked(medicineProf);
        int natuProf = isChecked(natureProf);
        int percProf = isChecked(perceptionProf);
        int perfProf = isChecked(performanceProf);
        int persProf = isChecked(persuasionProf);
        int reliProf = isChecked(religionProf);
        int sleiProf = isChecked(sleightOfHandProf);
        int steaProf = isChecked(stealthProf);
        int survProf = isChecked(survivalProf);
        int acroExpert = isChecked(acrobaticsExpert);
        int animExpert = isChecked(animalHandlingExpert);
        int arcaExpert = isChecked(arcanaExpert);
        int athlExpert = isChecked(athleticsExpert);
        int deceExpert = isChecked(deceptionExpert);
        int histExpert = isChecked(historyExpert);
        int insiExpert = isChecked(insightExpert);
        int intiExpert = isChecked(intimidationExpert);
        int inveExpert = isChecked(investigationExpert);
        int mediExpert = isChecked(medicineExpert);
        int natuExpert = isChecked(natureExpert);
        int percExpert = isChecked(perceptionExpert);
        int perfExpert = isChecked(performanceExpert);
        int persExpert = isChecked(persuasionExpert);
        int reliExpert = isChecked(religionExpert);
        int sleiExpert = isChecked(sleightOfHandExpert);
        int steaExpert = isChecked(stealthExpert);
        int survExpert = isChecked(survivalExpert);
        repository.saveSkills(charName, insp, strengthSTProf, dexteritySTProf, constitutionSTProf, intelligenceSTProf, wisdomSTProf, charismaSTProf,
                acroProf, animProf, arcaProf, athlProf, deceProf, histProf, insiProf, intiProf, inveProf, mediProf, natuProf, percProf, perfProf,
                persProf, reliProf, sleiProf, steaProf, survProf, acroExpert, animExpert, arcaExpert, athlExpert, deceExpert, histExpert, insiExpert,
                intiExpert, inveExpert, mediExpert, natuExpert, percExpert, perfExpert, persExpert, reliExpert, sleiExpert, steaExpert, survExpert);
    }

    //Health Section
    public void saveHealthSection(String charName,
                                  String ac,
                                  String initiative,
                                  String speed,
                                  String hpMax,
                                  String hpCurrent,
                                  String hpTemp,
                                  String hitDie,
                                  boolean deathSaveSuccessOne,
                                  boolean deathSaveSuccessTwo,
                                  boolean deathSaveSuccessThree,
                                  boolean deathSaveFailOne,
                                  boolean deathSaveFailTwo,
                                  boolean deathSaveFailThree) {
        int armor = Integer.parseInt(ac);
        int spd = Integer.parseInt(speed);
        int maxHP = Integer.parseInt(hpMax);
        int currentHP = Integer.parseInt(hpCurrent);
        int tempHP = Integer.parseInt(hpTemp);
        int deathSuccOne = isChecked(deathSaveSuccessOne);
        int deathSuccTwo = isChecked(deathSaveSuccessTwo);
        int deathSuccThree = isChecked(deathSaveSuccessThree);
        int deathFailOne = isChecked(deathSaveFailOne);
        int deathFailTwo = isChecked(deathSaveFailTwo);
        int deathFailThree = isChecked(deathSaveFailThree);
        repository.saveHealthSection(charName, armor, initiative, spd, maxHP, currentHP, tempHP, hitDie, deathSuccOne, deathSuccTwo, deathSuccThree,
                deathFailOne, deathFailTwo, deathFailThree);
    }

    //Proficiencies and Languages
    public String fixApostrophe(String originalString) {
        int index = originalString.indexOf('\'');
        String newString = new String();
        if (index > 0) {
            for (int i = 0; i < originalString.length(); i++) {
                newString += originalString.charAt(i);
                if (i+1==index) {
                    newString += "\\";
                }
            }
            return newString;
        } else {
            return originalString;
        }
    }

    public void saveProfAndLang(String charName,
                                String profAndLang) {
        int index = profAndLang.indexOf('\'');
        if (index > 0) {
            String newProfString = fixApostrophe(profAndLang);
            repository.saveProfAndLang(charName, newProfString);
        } else {
            repository.saveProfAndLang(charName, profAndLang);
        }

    }

    //Attacks and Spellcasting
    public void saveAttackAndSpell(String charName,
                                   String attackName,
                                   String attackModifier,
                                   String damageBase,
                                   String damageMod,
                                   String damageType,
                                   String damageRange,
                                   String attacksAndSpellcasting) {
        int index = attacksAndSpellcasting.indexOf('\'');
        if (index > 0) {
            String attackAndSpell = fixApostrophe(attacksAndSpellcasting);
            repository.saveAttackAndSpell(charName, attackName, attackModifier, damageBase, damageMod, damageType, damageRange, attackAndSpell);
        } else {
            repository.saveAttackAndSpell(charName, attackName, attackModifier, damageBase, damageMod, damageType, damageRange, attacksAndSpellcasting);
        }
    }

    //Equipment
    public void saveEquipment(String charName,
                              String equipment,
                              String copper,
                              String silver,
                              String electrum,
                              String gold,
                              String platinum,
                              String otherCurrency) {
        int cop = Integer.parseInt(copper);
        int sil = Integer.parseInt(silver);
        int ele = Integer.parseInt(electrum);
        int gol = Integer.parseInt(gold);
        int pla = Integer.parseInt(platinum);
        int oth = Integer.parseInt(otherCurrency);

        int index = equipment.indexOf('\'');
        if (index > 0) {
            String equip = fixApostrophe(equipment);
            repository.saveEquipment(charName, equip, cop, sil, ele, gol, pla, oth);
        } else {
            repository.saveEquipment(charName, equipment, cop, sil, ele, gol, pla, oth);
        }
    }

    //Personality
    public void savePersonality(String charName,
                                String personalityTraits,
                                String ideals,
                                String bonds,
                                String flaws,
                                String featuresAndTraits) {
        String per = fixApostrophe(personalityTraits);
        String ide = fixApostrophe(ideals);
        String bon = fixApostrophe(bonds);
        String fla = fixApostrophe(flaws);
        String fea = fixApostrophe(featuresAndTraits);
        repository.savePersonality(charName, per, ide, bon, fla, fea);
    }

    //Load
    public String loadCharacters(int id) {
        return repository.loadCharacters(id);
    }

    public int idDecider(int slotNumber) {
        return repository.idDecider(slotNumber);
    }

    public boolean trueOrFalse(int prof) {
        if (prof == 1) {
            return true;
        } else {
            return false;
        }
    }

    //Top Banner
    public TopBannerDTO loadTopBanner(int id) {
        TopBannerEntity topBannerEntity = repository.loadTopBanner(id);
        String characterName = topBannerEntity.getCharacterName();
        String characterClass = topBannerEntity.getCharacterClass();
        String background = topBannerEntity.getBackground();
        String playerName = topBannerEntity.getPlayerName();
        String race = topBannerEntity.getRace();
        String alignment = topBannerEntity.getAlignment();
        String level = Integer.toString(topBannerEntity.getLevel());
        String expPoints = Integer.toString(topBannerEntity.getExpPoints());
        TopBannerDTO topBannerDTO = new TopBannerDTO(characterName, characterClass, background, playerName, race, alignment, level, expPoints);
        return topBannerDTO;
    }

    //Abilities
    public AbilitiesDTO loadAbilities(int id) {
        AbilitiesEntity abilitiesEntity = repository.loadAbilities(id);
        String Strength = Integer.toString(abilitiesEntity.getStrength());
        String Dexterity = Integer.toString(abilitiesEntity.getDexterity());
        String Constitution = Integer.toString(abilitiesEntity.getConstitution());
        String Intelligence = Integer.toString(abilitiesEntity.getIntelligence());
        String Wisdom = Integer.toString(abilitiesEntity.getWisdom());
        String Charisma = Integer.toString(abilitiesEntity.getCharisma());
        AbilitiesDTO abilitiesDTO = new AbilitiesDTO(Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma);
        return abilitiesDTO;
    }

    //Skills
    public SkillsDTO loadSkills(int id) {
        SkillsEntity skillsEntity = repository.loadSkills(id);
        String inspiration = Integer.toString(skillsEntity.getInspiration());
        boolean strStProf = trueOrFalse(skillsEntity.getStrSTProf());
        boolean dexStProf = trueOrFalse(skillsEntity.getDexSTProf());
        boolean conStProf = trueOrFalse(skillsEntity.getConSTProf());
        boolean intStProf = trueOrFalse(skillsEntity.getIntSTProf());
        boolean wisStProf = trueOrFalse(skillsEntity.getWisSTProf());
        boolean chaStProf = trueOrFalse(skillsEntity.getChaSTProf());
        boolean acrobaticsProf = trueOrFalse(skillsEntity.getAcrobaticsProf());
        boolean animalHandlingProf = trueOrFalse(skillsEntity.getAnimalHandlingProf());
        boolean arcanaProf = trueOrFalse(skillsEntity.getArcanaProf());
        boolean athleticsProf = trueOrFalse(skillsEntity.getAthleticsProf());
        boolean deceptionProf = trueOrFalse(skillsEntity.getDeceptionProf());
        boolean historyProf = trueOrFalse(skillsEntity.getHistoryProf());
        boolean insightProf = trueOrFalse(skillsEntity.getInsightProf());
        boolean intimidationProf = trueOrFalse(skillsEntity.getIntimidationProf());
        boolean investigationProf = trueOrFalse(skillsEntity.getInvestigationProf());
        boolean medicineProf = trueOrFalse(skillsEntity.getMedicineProf());
        boolean natureProf = trueOrFalse(skillsEntity.getNatureProf());
        boolean perceptionProf = trueOrFalse(skillsEntity.getPerceptionProf());
        boolean performanceProf = trueOrFalse(skillsEntity.getPerformanceProf());
        boolean persuasionProf = trueOrFalse(skillsEntity.getPersuasionProf());
        boolean religionProf = trueOrFalse(skillsEntity.getReligionProf());
        boolean sleightOfHandProf = trueOrFalse(skillsEntity.getSleightOfHandProf());
        boolean stealthProf = trueOrFalse(skillsEntity.getStealthProf());
        boolean survivalProf = trueOrFalse(skillsEntity.getSurvivalProf());
        boolean acrobaticsExpert = trueOrFalse(skillsEntity.getAcrobaticsExpert());
        boolean animalHandlingExpert = trueOrFalse(skillsEntity.getAnimalHandlingExpert());
        boolean arcanaExpert = trueOrFalse(skillsEntity.getArcanaExpert());
        boolean athleticsExpert = trueOrFalse(skillsEntity.getAthleticsExpert());
        boolean deceptionExpert = trueOrFalse(skillsEntity.getDeceptionExpert());
        boolean historyExpert = trueOrFalse(skillsEntity.getHistoryExpert());
        boolean insightExpert = trueOrFalse(skillsEntity.getInsightExpert());
        boolean intimidationExpert = trueOrFalse(skillsEntity.getIntimidationExpert());
        boolean investigationExpert = trueOrFalse(skillsEntity.getInvestigationExpert());
        boolean medicineExpert = trueOrFalse(skillsEntity.getMedicineExpert());
        boolean natureExpert = trueOrFalse(skillsEntity.getNatureExpert());
        boolean perceptionExpert = trueOrFalse(skillsEntity.getPerceptionExpert());
        boolean performanceExpert = trueOrFalse(skillsEntity.getPerformanceExpert());
        boolean persuasionExpert = trueOrFalse(skillsEntity.getPersuasionExpert());
        boolean religionExpert = trueOrFalse(skillsEntity.getReligionExpert());
        boolean sleightOfHandExpert = trueOrFalse(skillsEntity.getSleightOfHandExpert());
        boolean stealthExpert = trueOrFalse(skillsEntity.getStealthExpert());
        boolean survivalExpert = trueOrFalse(skillsEntity.getSurvivalExpert());
        SkillsDTO skillsDTO = new SkillsDTO(inspiration, strStProf, dexStProf, conStProf, intStProf, wisStProf, chaStProf, acrobaticsProf, animalHandlingProf,
                arcanaProf, athleticsProf, deceptionProf, historyProf, insightProf, intimidationProf, investigationProf, medicineProf, natureProf,
                perceptionProf, performanceProf, persuasionProf, religionProf, sleightOfHandProf, stealthProf, survivalProf, acrobaticsExpert,
                animalHandlingExpert, arcanaExpert, athleticsExpert, deceptionExpert, historyExpert, insightExpert, intimidationExpert, investigationExpert,
                medicineExpert, natureExpert, perceptionExpert, performanceExpert, persuasionExpert, religionExpert, sleightOfHandExpert, stealthExpert,
                survivalExpert);
        return skillsDTO;
    }

    //Attacks and Spellcasting
    public AttacksAndSpellcastingDTO loadAttacks(int id) {
        AttacksAndSpellcastingEntity attacksAndSpellcastingEntity = repository.loadAttacks(id);
        String attackName = attacksAndSpellcastingEntity.getAttackName();
        String attackMod = attacksAndSpellcastingEntity.getAttackModifier();
        String damageBase = attacksAndSpellcastingEntity.getDamageBase();
        String damageMod = attacksAndSpellcastingEntity.getDamageMod();
        String damageType = attacksAndSpellcastingEntity.getDamageType();
        String damageRange = attacksAndSpellcastingEntity.getDamageRange();
        String attacksAndSpellcasting = attacksAndSpellcastingEntity.getAttacksAndSpellcasting();
        AttacksAndSpellcastingDTO attacksAndSpellcastingDTO = new AttacksAndSpellcastingDTO(attackName, attackMod, damageBase, damageMod, damageType,
                damageRange, attacksAndSpellcasting);
        return attacksAndSpellcastingDTO;
    }

    //Equipment
    public EquipmentDTO loadEquipment(int id) {
        EquipmentEntity equipmentEntity = repository.loadEquipment(id);
        String equipment = equipmentEntity.getEquipment();
        String copper = Integer.toString(equipmentEntity.getCopper());
        String silver = Integer.toString(equipmentEntity.getSilver());
        String electrum = Integer.toString(equipmentEntity.getElectrum());
        String gold = Integer.toString(equipmentEntity.getGold());
        String platinum = Integer.toString(equipmentEntity.getPlatinum());
        String otherCurrency = Integer.toString(equipmentEntity.getOtherCurrency());
        EquipmentDTO equipmentDTO = new EquipmentDTO(equipment, copper, silver, electrum, gold, platinum, otherCurrency);
        return equipmentDTO;
    }

    //Health Section
    public HealthSectionDTO loadHealth(int id) {
        HealthSectionEntity healthSectionEntity = repository.loadHealth(id);
        String ac = Integer.toString(healthSectionEntity.getAc());
        String initiative = healthSectionEntity.getInitiative();
        String speed = Integer.toString(healthSectionEntity.getSpeed());
        String HPMax = Integer.toString(healthSectionEntity.getHPMax());
        String HPCurrent = Integer.toString(healthSectionEntity.getHPCurrent());
        String HPTemp = Integer.toString(healthSectionEntity.getHPTemp());
        String hitDie = healthSectionEntity.getHitDice();
        boolean deathSuccOne = trueOrFalse(healthSectionEntity.getDeathSaveSuccessOne());
        boolean deathSuccTwo = trueOrFalse(healthSectionEntity.getDeathSaveSuccessTwo());
        boolean deathSuccThree = trueOrFalse(healthSectionEntity.getDeathSaveSuccessThree());
        boolean deathFailOne = trueOrFalse(healthSectionEntity.getDeathSaveFailOne());
        boolean deathFailTwo = trueOrFalse(healthSectionEntity.getDeathSaveFailTwo());
        boolean deathFailThree = trueOrFalse(healthSectionEntity.getDeathSaveFailThree());
        HealthSectionDTO healthSectionDTO = new HealthSectionDTO(ac, initiative, speed, HPMax, HPCurrent, HPTemp, hitDie, deathSuccOne, deathSuccTwo,
                deathSuccThree, deathFailOne, deathFailTwo, deathFailThree);
        return healthSectionDTO;
    }

    //Personality
    public PersonalityDTO loadPersonality(int id) {
        PersonalityEntity personalityEntity = repository.loadPersonality(id);
        String personalityTraits = personalityEntity.getPersonalityTraits();
        String ideals = personalityEntity.getIdeals();
        String bonds = personalityEntity.getBonds();
        String flaws = personalityEntity.getFlaws();
        String featuresAndTraits = personalityEntity.getFeaturesAndTraits();
        PersonalityDTO personalityDTO = new PersonalityDTO(personalityTraits, ideals, bonds, flaws, featuresAndTraits);
        return personalityDTO;
    }

    //Proficiencies and Languages
    public ProficienciesAndLanguagesDTO loadProfAndLang(int id) {
        ProficienciesAndLanguagesEntity proficienciesAndLanguagesEntity = repository.loadProfAndLang(id);
        String profAndLang = proficienciesAndLanguagesEntity.getProfAndLang();
        ProficienciesAndLanguagesDTO proficienciesAndLanguagesDTO = new ProficienciesAndLanguagesDTO(profAndLang);
        return proficienciesAndLanguagesDTO;
    }

    //GAME MATHS
    public String calcAbilityMod(String ability) {
        String abilityMod;
        int abilityNum = Integer.parseInt(ability);
        if (abilityNum == 1) {
            abilityMod = "-5";
        } else if (abilityNum == 2 || abilityNum == 3) {
            abilityMod = "-4";
        } else if (abilityNum == 4 || abilityNum == 5) {
            abilityMod = "-3";
        } else if (abilityNum == 6 || abilityNum == 7) {
            abilityMod = "-2";
        } else if (abilityNum == 8 || abilityNum == 9) {
            abilityMod = "-1";
        } else if (abilityNum == 10 || abilityNum == 11) {
            abilityMod = "0";
        } else if (abilityNum == 12 || abilityNum == 13) {
            abilityMod = "+1";
        } else if (abilityNum == 14 || abilityNum == 15) {
            abilityMod = "+2";
        } else if (abilityNum == 16 || abilityNum == 17) {
            abilityMod = "+3";
        } else if (abilityNum == 18 || abilityNum == 19) {
            abilityMod = "+4";
        } else if (abilityNum == 20 || abilityNum == 21) {
            abilityMod = "+5";
        } else if (abilityNum == 22 || abilityNum == 23) {
            abilityMod = "+6";
        } else if (abilityNum == 24 || abilityNum == 25) {
            abilityMod = "+7";
        } else if (abilityNum == 26 || abilityNum == 27) {
            abilityMod = "+8";
        } else if (abilityNum == 28 || abilityNum == 29) {
            abilityMod = "+9";
        } else if (abilityNum == 30) {
            abilityMod = "+10";
        } else {
            abilityMod = "0";
        }
        return abilityMod;
    }

    public String calcProfBonus(String level) {
        int levelNum = Integer.parseInt(level);
        String profBonus;
        if (levelNum < 5) {
            profBonus = "+2";
        } else if (levelNum > 4 && levelNum < 9) {
            profBonus = "+3";
        } else if (levelNum > 8 && levelNum < 13) {
            profBonus = "+4";
        } else if (levelNum > 12 && levelNum < 17) {
            profBonus = "+5";
        } else {
            profBonus = "+6";
        }
        return profBonus;
    }

    public String calcSavingThrow(boolean prof, String profBonus, String abilityMod) {
        int savingThrowModNum;
        int profBonusNum = Integer.parseInt(profBonus);
        int abilityModNum = Integer.parseInt(abilityMod);
        if (prof) {
            savingThrowModNum = profBonusNum + abilityModNum;
        } else {
            savingThrowModNum = abilityModNum;
        }
        String savingThrowMod = Integer.toString(savingThrowModNum);
        if (Integer.parseInt(savingThrowMod) > 0) {
            String savingThrowModNew = "+" + savingThrowMod;
            return savingThrowModNew;
        } else {
            return savingThrowMod;
        }
    }

    public String calcSkills(boolean prof, boolean expert, String profBonus, String abilityMod) {
        int skillModNum = 0;
        int profBonusNum = Integer.parseInt(profBonus);
        int abilityModNum = Integer.parseInt(abilityMod);
        if (prof == false && expert == false) {
            skillModNum = abilityModNum;
        } else if (prof && expert == false) {
            skillModNum = abilityModNum + profBonusNum;
        } else if (expert) {
            skillModNum = abilityModNum + (profBonusNum*2);
        }
        String skillMod = Integer.toString(skillModNum);
        if (Integer.parseInt(skillMod) > 0) {
            String skillModNew = "+" + skillMod;
            return skillModNew;
        } else {
            return skillMod;
        }
    }
}































