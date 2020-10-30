package co.beefchop.repository.repository;

import java.sql.*;

import co.beefchop.repository.entities.*;

public class Repository {
    private Connection connection;
    String url = "jdbc:mysql://localhost:3306/dnd_character_sheet";

    public Repository() {
        try {
            this.connection = DriverManager.getConnection(url, "root", "whatishappening?");
            System.out.println("Connected to database");
        } catch (SQLException ex) {
            System.out.println("Error in connection: " + ex.getMessage());
        }
    }

    //retrieve id using character name
    public int getId(String charName) {
        int tempId = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select id from top_banner where character_name = '" + charName + "'");
            while (resSet.next()) {
                tempId = resSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error in getId: " + ex.getMessage());
        }
        return  tempId;
    }



    //SAVE

    //Top Banner
    public void saveTopBanner(String charName,
                              String charClass,
                              int level,
                              String background,
                              String playerName,
                              String race,
                              String alignment,
                              int expPoints) {
        System.out.println("saveTopBanner called");
        try {
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select character_name from top_banner where id = " + getId(charName));
            String foundType = null;
            while(resSet.next()) {
                foundType = resSet.getString(1);
            }
            if (foundType == null || foundType.equals(charName) == false) {
                statement.execute("insert into top_banner(character_name, class, level, background, " +
                        "player_name, race, alignment, exp_points) values ('"
                        + charName + "', '"
                        + charClass + "', "
                        + level + ", '"
                        + background + "', '"
                        + playerName + "', '"
                        + race + "', '"
                        + alignment + "', "
                        + expPoints + ")");
            } else if (foundType.equals(charName)) {
                statement.execute("update top_banner set " +
                        "character_name = '" + charName + "', " +
                        "class = '" + charClass + "', " +
                        "level = " + level + ", " +
                        "background = '" + background + "', " +
                        "player_name = '" + playerName + "', " +
                        "race = '" + race + "', " +
                        "alignment = '" + alignment + "', " +
                        "exp_points = " + expPoints +
                        " where id = " + getId(charName));
            } else {
                System.out.println("Idk man, something funky is going on, here.");
            }

        } catch (SQLException ex) {
            System.out.println("Error in saveTopBanner: " + ex.getMessage());
        }
    }


    //Abilities
    public void saveAbilities(String charName,
                              int strength,
                              int dexterity,
                              int constitution,
                              int intelligence,
                              int wisdom,
                              int charisma) {
        System.out.println("saveAbilities called");
        try{
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select abilities_id from abilities where abilities_id = " + getId(charName));
            int foundType = 0;
            while(resSet.next()) {
                foundType = resSet.getInt(1);
            }
            if (foundType == 0 || foundType != getId(charName)) {
                statement.execute("insert into abilities(Strength, dexterity, constitution, intelligence, wisdom, charisma, abilities_id) values ("
                        + strength + ", "
                        + dexterity + ", "
                        + constitution + ", "
                        + intelligence + ", "
                        + wisdom + ", "
                        + charisma + ", "
                        + getId(charName) + ")");
            } else if (foundType == getId(charName)) {
                statement.execute("update abilities set " +
                        "Strength = " + strength + ", " +
                        "dexterity = " + dexterity + ", " +
                        "constitution = " + constitution + ", " +
                        "intelligence = " + intelligence + ", " +
                        "wisdom = " + wisdom + ", " +
                        "charisma = " + charisma + " " +
                        "where abilities_id = " + getId(charName));
            } else {
                System.out.println("Something went wrong in saveAbilities");
            }

        } catch (SQLException ex) {
            System.out.println("Error in saveAbilities: " + ex.getMessage());
        }
    }

    //Skills (Includes Proficiency Panel and Saving Throws)
    public void saveSkills(String charName,
                           int inspiration,
                           int strSTProf,
                           int conSTProf,
                           int dexSTProf,
                           int intSTProf,
                           int wisSTProf,
                           int chaSTProf,
                           int acrobaticsProf,
                           int animalHandlingProf,
                           int arcanaProf,
                           int athleticsProf,
                           int deceptionProf,
                           int historyProf,
                           int insightProf,
                           int intimidationProf,
                           int investigationProf,
                           int medicineProf,
                           int natureProf,
                           int perceptionProf,
                           int performanceProf,
                           int persuasionProf,
                           int religionProf,
                           int sleightOfHandProf,
                           int stealthProf,
                           int survivalProf,
                           int acrobaticsExpert,
                           int animalHandlingExpert,
                           int arcanaExpert,
                           int athleticsExpert,
                           int deceptionExpert,
                           int historyExpert,
                           int insightExpert,
                           int intimidationExpert,
                           int investigationExpert,
                           int medicineExpert,
                           int natureExpert,
                           int perceptionExpert,
                           int performanceExpert,
                           int persuasionExpert,
                           int religionExpert,
                           int sleightOfHandExpert,
                           int stealthExpert,
                           int survivalExpert) {
        System.out.println("saveSkills called");
        try{
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select skills_id from skills where skills_id = " + getId(charName));
            int foundType = 0;
            while(resSet.next()) {
                foundType = resSet.getInt(1);
            }
            if (foundType == 0 || foundType != getId(charName)) {
                statement.execute("insert into skills (inspiration, " +
                        "str_st_prof, dex_st_prof, con_st_prof, int_st_prof, wis_st_prof, cha_st_prof, " +
                        "acrobatics_prof, animal_handling_prof, arcana_prof, athletics_prof, deception_prof, history_prof, insight_prof, intimidation_prof, " +
                        "investigation_prof, medicine_prof, nature_prof, perception_prof, performance_prof, persuasion_prof, religion_prof, " +
                        "sleight_of_hand_prof, stealth_prof, survival_prof, " +
                        "acrobatics_expert, animal_handling_expert, arcana_expert, athletics_expert, deception_expert, history_expert, insight_expert, intimidation_expert, " +
                        "investigation_expert, medicine_expert, nature_expert, perception_expert, performance_expert, persuasion_expert, religion_expert, " +
                        "sleight_of_hand_expert, stealth_expert, survival_expert, skills_id) values (" +
                        inspiration + ", " +
                        strSTProf + ", " + dexSTProf + ", " + conSTProf + ", " + intSTProf + ", " + wisSTProf + ", " + chaSTProf + ", " +
                        acrobaticsProf + ", " + animalHandlingProf + ", " + arcanaProf + ", " + athleticsProf + ", " + deceptionProf + ", " +
                        historyProf + ", " + insightProf + ", " + intimidationProf + ", " + investigationProf + ", " + medicineProf + ", " +
                        natureProf + ", " + perceptionProf + ", " + performanceProf + ", " + persuasionProf + ", " + religionProf + ", " +
                        sleightOfHandProf + ", " + stealthProf + ", " + survivalProf + ", " +
                        acrobaticsExpert + ", " + animalHandlingExpert + ", " + arcanaExpert + ", " + athleticsExpert + ", " + deceptionExpert + ", " +
                        historyExpert + ", " + insightExpert + ", " + intimidationExpert + ", " + investigationExpert + ", " + medicineExpert + ", " +
                        natureExpert + ", " + perceptionExpert + ", " + performanceExpert + ", " + persuasionExpert + ", " + religionExpert + ", " +
                        sleightOfHandExpert + ", " + stealthExpert + ", " + survivalExpert +  ", " + getId(charName) + ")");
            } else if (foundType == getId(charName)) {
                statement.execute("update skills set " +
                        "inspiration = " + inspiration + ", " +
                        "str_st_prof = " + strSTProf + ", dex_st_prof = " + dexSTProf + ", con_st_prof = " + conSTProf + ", int_st_prof = " + intSTProf +
                        ", wis_st_prof = " + wisSTProf + ", cha_st_prof = " + chaSTProf + ", " +
                        "acrobatics_prof = " + acrobaticsProf + ", animal_handling_prof = " + animalHandlingProf + ", arcana_prof = " + arcanaProf +
                        ", athletics_prof = " + athleticsProf + ", deception_prof = " + deceptionProf + ", history_prof = " + historyProf +
                        ", insight_prof = " + insightProf + ", intimidation_prof = " + intimidationProf + ", investigation_prof = " + investigationProf +
                        ", medicine_prof = " + medicineProf + ", nature_prof = " + natureProf + ", perception_prof = " + perceptionProf + ", performance_prof = " +
                        performanceProf + ", persuasion_prof = " + persuasionProf + ", religion_prof = " + religionProf + ", sleight_of_hand_prof = " +
                        sleightOfHandProf + ", stealth_prof = " + stealthProf + ", survival_prof = " + survivalProf +
                        ", acrobatics_expert = " + acrobaticsExpert + ", animal_handling_expert = " + animalHandlingExpert + ", arcana_expert = " + arcanaExpert +
                        ", athletics_expert = " + athleticsExpert + ", deception_expert = " + deceptionExpert + ", history_expert = " + historyExpert +
                        ", insight_expert = " + insightExpert + ", intimidation_expert = " + intimidationExpert + ", investigation_expert = " + investigationExpert +
                        ", medicine_expert = " + medicineExpert + ", nature_expert = " + natureExpert + ", perception_expert = " + perceptionExpert + ", performance_expert = " +
                        performanceExpert + ", persuasion_expert = " + persuasionExpert + ", religion_expert = " + religionExpert + ", sleight_of_hand_expert = " +
                        sleightOfHandExpert + ", stealth_expert = " + stealthExpert + ", survival_expert = " + survivalExpert + " where skills_id = " + getId(charName));
            } else {
                System.out.println("Something went wrong in saveSkills");
            }

        } catch (SQLException ex) {
            System.out.println("Error in saveSkills: " + ex.getMessage());
        }
    }

    //Health Section (Includes Death Save)
    public void saveHealthSection(String charName,
                                  int ac,
                                  String initiative,
                                  int speed,
                                  int hpMax,
                                  int hpCurrent,
                                  int hpTemp,
                                  String hitDie,
                                  int deathSaveSuccessOne,
                                  int deathSaveSuccessTwo,
                                  int deathSaveSuccessThree,
                                  int deathSaveFailOne,
                                  int deathSaveFailTwo,
                                  int deathSaveFailThree) {
        System.out.println("saveHealthSection called");
        try{
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select health_section_id from health_section where health_section_id = " + getId(charName));
            int foundType = 0;
            while(resSet.next()) {
                foundType = resSet.getInt(1);
            }
            if (foundType == 0 || foundType != getId(charName)) {
                statement.execute("insert into health_section (" +
                        "ac, initiative, speed, hp_max, hp_current, hp_temp, hit_dice_die, " +
                        "death_save_success_one, death_save_success_two, death_save_success_three, " +
                        "death_save_fail_one, death_save_fail_two, death_save_fail_three, health_section_id) values (" +
                        ac + ", '" + initiative + "', " + speed + ", " + hpMax + ", " + hpCurrent + ", " + hpTemp + ", '" +
                        hitDie + "', " + deathSaveSuccessOne + ", " + deathSaveSuccessTwo + ", " + deathSaveSuccessThree + ", " +
                        deathSaveFailOne + ", " + deathSaveFailTwo + ", " + deathSaveFailThree + ", " + getId(charName) + ")");
            } else if (foundType == getId(charName)) {
                statement.execute("update health_section set " +
                        "ac = " + ac + ", initiative = '" + initiative + "', speed = " + speed + ", hp_max = " + hpMax + ", hp_current = " +
                        hpCurrent + ", hp_temp = " + hpTemp + ", hit_dice_die = '" + hitDie + "', death_save_success_one = " + deathSaveSuccessOne +
                        ", death_save_success_two = " + deathSaveSuccessTwo + ", death_save_success_three = " + deathSaveSuccessThree +
                        ", death_save_fail_one = " + deathSaveFailOne + ", death_save_fail_two = " + deathSaveFailTwo + ", death_save_fail_three = " +
                        deathSaveFailThree + " where health_section_id = " + getId(charName));
            } else {
                System.out.println("Something went wrong in saveHealthSection");
            }

        } catch (SQLException ex) {
            System.out.println("Error in saveHealthSection: " + ex.getMessage());
        }
    }

    //Proficiencies and Languages
    public void saveProfAndLang(String charName,
                                String profAndLang) {
        System.out.println("saveProfAndLang called");
        try{
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select prof_and_lang_id from prof_and_lang where prof_and_lang_id = " + getId(charName));
            int foundType = 0;
            while(resSet.next()) {
                foundType = resSet.getInt(1);
            }
            if (foundType == 0 || foundType != getId(charName)) {
                statement.execute("insert into prof_and_lang (prof_and_lang, prof_and_lang_id) values ('" + profAndLang + "', " + getId(charName) + ")");
            } else if (foundType == getId(charName)) {
                statement.execute("update prof_and_lang set prof_and_lang = '" + profAndLang + "', prof_and_lang_id = " + getId(charName));
            } else {
                System.out.println("Something went wrong in saveProfAndLang");
            }

        } catch (SQLException ex) {
            System.out.println("Error in saveProfAndLang: " + ex.getMessage());
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
        System.out.println("saveAttackAndSpell called");
        try{
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select attacks_and_spellcasting_id from attacks_and_spellcasting where " +
                    "attacks_and_spellcasting_id = " + getId(charName));
            int foundType = 0;
            while(resSet.next()) {
                foundType = resSet.getInt(1);
            }
            if (foundType == 0 || foundType != getId(charName)) {
                statement.execute("insert into attacks_and_spellcasting (name, attack_modifier, damage_base, damage_mod, damage_type, damage_range, " +
                        "attacks_and_spellcasting, attacks_and_spellcasting_id) values ('" +
                        attackName + "', '" + attackModifier + "', '" + damageBase + "', '" + damageMod + "', '" + damageType + "', '" + damageRange +
                        "', '" + attacksAndSpellcasting + "', " + getId(charName) + ")");
            } else if (foundType == getId(charName)) {
                statement.execute("update attacks_and_spellcasting set " +
                        "name = '" + attackName + "', attack_modifier = '" + attackModifier + "', damage_base = '" + damageBase + "', damage_mod = '" +
                        damageMod + "', damage_type = '" + damageType + "', damage_range = '" + damageRange + "', attacks_and_spellcasting = '" +
                        attacksAndSpellcasting + "', attacks_and_spellcasting_id = " + getId(charName));
            } else {
                System.out.println("Something went wrong in saveAttackAndSpell");
            }

        } catch (SQLException ex) {
            System.out.println("Error in saveAttackAndSpell: " + ex.getMessage());
        }
    }

    //Equipment
    public void saveEquipment(String charName,
                              String equipment,
                              int copper,
                              int silver,
                              int electrum,
                              int gold,
                              int platinum,
                              int otherCurrency) {
        System.out.println("saveEquipment called");
        try{
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select equipment_id from equipment where equipment_id = " + getId(charName));
            int foundType = 0;
            while(resSet.next()) {
                foundType = resSet.getInt(1);
            }
            if (foundType == 0 || foundType != getId(charName)) {
                statement.execute("insert into equipment (" +
                        "equipment, copper, silver, electrum, gold, platinum, other_currency, equipment_id) values ('" +
                        equipment + "', " + copper + ", " + silver + ", " + electrum + ", " + gold + ", " + platinum + ", " + otherCurrency +
                        ", "+ getId(charName) + ")");
            } else if (foundType == getId(charName)) {
                statement.execute("update equipment set " +
                        "equipment = '" + equipment + "', copper = " + copper + ", silver = " + silver + ", gold = " + gold + ", platinum = " +
                        platinum + ", other_currency = " + otherCurrency + ", equipment_id = " + getId(charName));
            } else {
                System.out.println("Something went wrong in saveEquipment");
            }

        } catch (SQLException ex) {
            System.out.println("Error in saveEquipment: " + ex.getMessage());
        }
    }

    //Personality
    public void savePersonality(String charName,
                                String personalityTraits,
                                String ideals,
                                String bonds,
                                String flaws,
                                String featuresAndTraits) {
        System.out.println("savePersonality called");
        try{
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery("select personality_id from personality where personality_id = " + getId(charName));
            int foundType = 0;
            while(resSet.next()) {
                foundType = resSet.getInt(1);
            }
            if (foundType == 0 || foundType != getId(charName)) {
                statement.execute("insert into personality (" +
                        "personality_traits, ideals, bonds, flaws, features_and_traits, personality_id) values ('" +
                        personalityTraits + "', '" + ideals + "', '" + bonds + "', '" + flaws + "', '" + featuresAndTraits + "', " + getId(charName) + ")");
            } else if (foundType == getId(charName)) {
                statement.execute("update personality set " +
                        "personality_traits = '" + personalityTraits + "', ideals = '" + ideals + "', bonds = '" + bonds + "', flaws = '" + flaws +
                        "', features_and_traits = '" + featuresAndTraits + "', personality_id = " + getId(charName));
            } else {
                System.out.println("Something went wrong in savePersonality");
            }

        } catch (SQLException ex) {
            System.out.println("Error in savePersonality: " + ex.getMessage());
        }
    }

    //LOAD

    //Load Characters

    public String loadCharacters(int id) {
        String charName = new String();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select character_name from top_banner where id = " + id);
            while (resultSet.next()) {
                charName = resultSet.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadCharacters: " + ex.getMessage());
        }
        return charName;
    }

    public int idDecider(int slotNumber) {
        int id = 0;
        int newID = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select min(id) from top_banner");
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            newID = id+slotNumber-1;
        } catch (SQLException ex) {
            System.out.println("Error in idDecider: " + ex.getMessage());
        }
        return newID;
    }

    //Top Banner
    public TopBannerEntity loadTopBanner(int id) {
        String charName = null;
        String charClass = null;
        int level = 0;
        String background = null;
        String playerName = null;
        String race = null;
        String alignment = null;
        int XP = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from top_banner where id = " + id);
            if (resultSet.next()) {
                charName = resultSet.getString("character_name");
                charClass = resultSet.getString("class");
                level = resultSet.getInt("level");
                background = resultSet.getString("background");
                playerName = resultSet.getString("player_name");
                race = resultSet.getString("race");
                alignment = resultSet.getString("alignment");
                XP = resultSet.getInt("exp_points");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadTopBanner: " + ex.getMessage());
        }
        TopBannerEntity topBannerEntity = new TopBannerEntity(charName, charClass, level, background, playerName, race, alignment, XP);
        System.out.println("loadTopBannerExecuted");
        return topBannerEntity;
    }

    //Abilities
    public AbilitiesEntity loadAbilities(int id) {
        int strength = 0;
        int dexterity = 0;
        int constitution = 0;
        int intelligence = 0;
        int wisdom = 0;
        int charisma = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from abilities where abilities_id = " + id);
            if (resultSet.next()) {
                strength = resultSet.getInt("Strength");
                dexterity = resultSet.getInt("dexterity");
                constitution = resultSet.getInt("constitution");
                intelligence = resultSet.getInt("intelligence");
                wisdom = resultSet.getInt("wisdom");
                charisma = resultSet.getInt("charisma");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadAbilities: " + ex.getMessage());
        }
        AbilitiesEntity abilitiesEntity = new AbilitiesEntity(strength, dexterity, constitution, intelligence, wisdom, charisma);
        System.out.println("loadAbilitiesExecuted");
        return abilitiesEntity;

    }

    //Skills
    public SkillsEntity loadSkills(int id) {
        int inspiration = 0;
        int strStProf = 0;
        int dexStProf = 0;
        int conStProf = 0;
        int intStProf = 0;
        int wisStProf = 0;
        int chaStProf = 0;
        int acroProf = 0;
        int animProf = 0;
        int arcaProf = 0;
        int athlProf = 0;
        int deceProf = 0;
        int histProf = 0;
        int insiProf = 0;
        int intiProf = 0;
        int inveProf = 0;
        int mediProf = 0;
        int natuProf = 0;
        int percProf = 0;
        int perfProf = 0;
        int persProf = 0;
        int reliProf = 0;
        int sleiProf = 0;
        int steaProf = 0;
        int survProf = 0;
        int acroExpert = 0;
        int animExpert = 0;
        int arcaExpert = 0;
        int athlExpert = 0;
        int deceExpert = 0;
        int histExpert = 0;
        int insiExpert = 0;
        int intiExpert = 0;
        int inveExpert = 0;
        int mediExpert = 0;
        int natuExpert = 0;
        int percExpert = 0;
        int perfExpert = 0;
        int persExpert = 0;
        int reliExpert = 0;
        int sleiExpert = 0;
        int steaExpert = 0;
        int survExpert = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from skills where skills_id = " + id);
            if (resultSet.next()) {
                inspiration = resultSet.getInt("inspiration");
                strStProf = resultSet.getInt("str_st_prof");
                dexStProf = resultSet.getInt("dex_st_prof");
                conStProf = resultSet.getInt("con_st_prof");
                intStProf = resultSet.getInt("int_st_prof");
                wisStProf = resultSet.getInt("wis_st_prof");
                chaStProf = resultSet.getInt("cha_st_prof");
                acroProf = resultSet.getInt("acrobatics_prof");
                animProf = resultSet.getInt("animal_handling_prof");
                arcaProf = resultSet.getInt("arcana_prof");
                athlProf = resultSet.getInt("athletics_prof");
                deceProf = resultSet.getInt("deception_prof");
                histProf = resultSet.getInt("history_prof");
                insiProf = resultSet.getInt("insight_prof");
                intiProf = resultSet.getInt("intimidation_prof");
                inveProf = resultSet.getInt("investigation_prof");
                mediProf = resultSet.getInt("medicine_prof");
                natuProf = resultSet.getInt("nature_prof");
                percProf = resultSet.getInt("perception_prof");
                perfProf = resultSet.getInt("performance_prof");
                persProf = resultSet.getInt("persuasion_prof");
                reliProf = resultSet.getInt("religion_prof");
                sleiProf = resultSet.getInt("sleight_of_hand_prof");
                steaProf = resultSet.getInt("stealth_prof");
                survProf = resultSet.getInt("survival_prof");
                acroExpert = resultSet.getInt("acrobatics_expert");
                animExpert = resultSet.getInt("animal_handling_expert");
                arcaExpert = resultSet.getInt("arcana_expert");
                athlExpert = resultSet.getInt("athletics_expert");
                deceExpert = resultSet.getInt("deception_expert");
                histExpert = resultSet.getInt("history_expert");
                insiExpert = resultSet.getInt("insight_expert");
                intiExpert = resultSet.getInt("intimidation_expert");
                inveExpert = resultSet.getInt("investigation_expert");
                mediExpert = resultSet.getInt("medicine_expert");
                natuExpert = resultSet.getInt("nature_expert");
                percExpert = resultSet.getInt("perception_expert");
                perfExpert = resultSet.getInt("performance_expert");
                persExpert = resultSet.getInt("persuasion_expert");
                reliExpert = resultSet.getInt("religion_expert");
                sleiExpert = resultSet.getInt("sleight_of_hand_expert");
                steaExpert = resultSet.getInt("stealth_expert");
                survExpert = resultSet.getInt("survival_expert");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadSkills: " + ex.getMessage());
        }
        SkillsEntity skillsEntity = new SkillsEntity(inspiration, strStProf, dexStProf, conStProf, intStProf, wisStProf, chaStProf, acroProf, animProf,
                arcaProf, athlProf, deceProf, histProf, insiProf, intiProf, inveProf, mediProf, natuProf, percProf, perfProf, persProf, reliProf, sleiProf,
                steaProf, survProf, acroExpert, animExpert, arcaExpert, athlExpert, deceExpert, histExpert, insiExpert, intiExpert, inveExpert,
                mediExpert, natuExpert, percExpert, perfExpert, persExpert, reliExpert, sleiExpert, steaExpert, survExpert);
        System.out.println("Load Skills executed");
        return skillsEntity;
    }

    //Attacks And Spellcasting
    public AttacksAndSpellcastingEntity loadAttacks(int id) {
        String attackName = null;
        String attackModifier = null;
        String damageBase = null;
        String damageMod = null;
        String damageType = null;
        String damageRange = null;
        String attacksAndSpellcasting = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from attacks_and_spellcasting where attacks_and_spellcasting_id = " + id);
            if (resultSet.next()) {
                attackName = resultSet.getString("name");
                attackModifier = resultSet.getString("attack_modifier");
                damageBase = resultSet.getString("damage_base");
                damageMod = resultSet.getString("damage_mod");
                damageType = resultSet.getString("damage_type");
                damageRange = resultSet.getString("damage_range");
                attacksAndSpellcasting = resultSet.getString("attacks_and_spellcasting");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadAtacks: " + ex.getMessage());
        }
        AttacksAndSpellcastingEntity attacksAndSpellcastingEntity = new AttacksAndSpellcastingEntity(attackName, attackModifier, damageBase, damageMod,
                damageType, damageRange, attacksAndSpellcasting);
        System.out.println("loadAttacks Executed");
        return attacksAndSpellcastingEntity;
    }

    //Equipment
    public EquipmentEntity loadEquipment(int id) {
        String equipment = null;
        int copper = 0;
        int silver = 0;
        int electrum = 0;
        int gold = 0;
        int platinum = 0;
        int otherCurrency = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from equipment where equipment_id = " + id);
            if (resultSet.next()){
                equipment = resultSet.getString("equipment");
                copper = resultSet.getInt("copper");
                silver = resultSet.getInt("silver");
                electrum = resultSet.getInt("electrum");
                gold = resultSet.getInt("gold");
                platinum = resultSet.getInt("platinum");
                otherCurrency = resultSet.getInt("other_currency");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadEquipment: " + ex.getMessage());
        }
        EquipmentEntity equipmentEntity = new EquipmentEntity(equipment, copper, silver, electrum, gold, platinum, otherCurrency);
        System.out.println("loadEquipment executed");
        return equipmentEntity;
    }

    //Health Section
    public HealthSectionEntity loadHealth(int id) {
        int ac = 0;
        String initiative = null;
        int speed = 0;
        int HPMax = 0;
        int HPCurrent = 0;
        int HPTemp = 0;
        String hitDie = null;
        int deathSuccessOne = 0;
        int deathSuccessTwo = 0;
        int deathSuccessThree = 0;
        int deathFailOne = 0;
        int deathFailTwo = 0;
        int deathFailThree = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from health_section where health_section_id = " + id);
            if (resultSet.next()) {
                ac = resultSet.getInt("ac");
                initiative = resultSet.getString("initiative");
                speed = resultSet.getInt("speed");
                HPMax = resultSet.getInt("hp_max");
                HPCurrent = resultSet.getInt("hp_current");
                HPTemp = resultSet.getInt("hp_temp");
                hitDie = resultSet.getString("hit_dice_die");
                deathSuccessOne = resultSet.getInt("death_save_success_one");
                deathSuccessTwo = resultSet.getInt("death_save_success_two");
                deathSuccessThree = resultSet.getInt("death_save_success_three");
                deathFailOne = resultSet.getInt("death_save_fail_one");
                deathFailTwo = resultSet.getInt("death_save_fail_two");
                deathFailThree = resultSet.getInt("death_save_fail_three");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadHealth: " + ex.getMessage());
        }
        HealthSectionEntity healthSectionEntity = new HealthSectionEntity(ac,initiative, speed, HPMax, HPCurrent, HPTemp, hitDie, deathSuccessOne,
                deathSuccessTwo, deathSuccessThree, deathFailOne, deathFailTwo, deathFailThree);
        System.out.println("loadHealth executed");
        return healthSectionEntity;
    }

    //Personality
    public PersonalityEntity loadPersonality(int id) {
        String personalityTraits = null;
        String ideals = null;
        String bonds = null;
        String flaws = null;
        String featuresAndTraits = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from personality where personality_id = " + id);
            if (resultSet.next()) {
                personalityTraits = resultSet.getString("personality_traits");
                ideals = resultSet.getString("ideals");
                bonds = resultSet.getString("bonds");
                flaws = resultSet.getString("flaws");
                featuresAndTraits = resultSet.getString("features_and_traits");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadPersonality: " + ex.getMessage());
        }
        PersonalityEntity personalityEntity = new PersonalityEntity(personalityTraits, ideals, bonds, flaws, featuresAndTraits);
        System.out.println("loadPersonality executed");
        return personalityEntity;
    }

    //Proficiencies and Languages
    public ProficienciesAndLanguagesEntity loadProfAndLang(int id) {
        String profAndLang = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from prof_and_lang where prof_and_lang_id = " + id);
            if (resultSet.next()) {
                profAndLang = resultSet.getString("prof_and_lang");
            }
        } catch (SQLException ex) {
            System.out.println("Error in loadProfAndLang: " + ex.getMessage());
        }
        ProficienciesAndLanguagesEntity proficienciesAndLanguagesEntity = new ProficienciesAndLanguagesEntity(profAndLang);
        System.out.println("loadProfAndLang executed");
        return proficienciesAndLanguagesEntity;
    }

}

































