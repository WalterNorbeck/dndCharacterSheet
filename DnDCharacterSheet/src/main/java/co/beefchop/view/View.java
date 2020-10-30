package co.beefchop.view;

import co.beefchop.controller.Controller;
import co.beefchop.repository.DTO.TopBannerDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private TopBannerDTO topBannerDTO = new TopBannerDTO();

    private Font font = new Font("Times New Roman", Font.PLAIN, 12);
    private Font fontMedium = new Font("Times New Roman", Font.PLAIN, 15);
    private Font fontLarge = new Font("Times New Roman", Font.PLAIN, 20);
    private JPanel topBannerPanel, abilitiesPanel, skillsPanel, profPanel, savingThrowsPanel, healthSectionPanel, deathSavePanel, profAndLangPanel,
            attacksAndSpellcastingPanel, equipmentPanel, personalityPanel;
    private JLabel
            //Top Banner
            characterNameLabel, playerNameLabel, classLabel, levelLabel, raceLabel, backgroundLabel, alignmentLabel, experienceLabel,
            //Abilities
            strLabel, dexLabel, conLabel, intLabel, wisLabel, chaLabel, strMod, dexMod, conMod, intMod, wisMod, chaMod,
            //Skills
            acrobaticsLabel, animalHandlingLabel, arcanaLabel, athleticsLabel, deceptionLabel, historyLabel, insightLabel, intimidationLabel, investigationLabel,
            medicineLabel, natureLabel, perceptionLabel, performanceLabel, persuasionLabel, religionLabel, sleightOfHandLabel, stealthLabel, survivalLabel,
            acrobaticsMod, animalHandlingMod, arcanaMod, athleticsMod, deceptionMod, historyMod, insightMod, intimidationMod, investigationMod,
            medicineMod, natureMod, perceptionMod, performanceMod, persuasionMod, religionMod, sleightOfHandMod, stealthMod, survivalMod,
            //Proficiency Panel
            inspirationLabel, profBonusLabel, profBonusValue, passiveDescription,
            //Saving Throws Panel
            strStLabel, dexStLabel, conStLabel, intStLabel, wisStLabel, chaStLabel, strStValue, dexStValue, conStValue, intStValue, wisStValue, chaStValue,
            //Health Section Panel
            ACLabel, initiativeLabel, speedLabel, HPMaxLabel, HPCurrentLabel, HPTempLabel, hitDiceLabel, deathSaveSuccessLabel, deathSaveFailLabel,
            //Proficiencies and Languages
            profAndLangLabel,
            //Attacks and Spellcasting
            attackNameLabel, attackModLabel, baseDamageLabel, modDamageLabel, typeDamageLabel, rangeDamageLabel,
            //Equipment
            copperLabel, silverLabel, electrumLabel, goldLabel, platinumLabel, otherLabel, equipmentLabel,
            //Personality
            personalityTraitsLabel, idealsLabel, bondsLabel, flawsLabel, featuresAndTraitsLabel
            ;
    private JTextField
            //Top Banner
            characterNameField, playerNameField, classField, levelField, raceField, backgroundField, alignmentField, experienceField,
            //Abilities
            strField, dexField, conField, intField, wisField, chaField,
            //Proficiency Panel
            inspirationField,
            //Health Section Panel
            ACField, initiativeField, speedField, HPMaxField, HPCurrentField, HPTempField, hitDiceField,
            //Attacks and Spellcasting
            attackNameField, attackModField, baseDamageField, modDamageField, typeDamageField, rangeDamageField,
            //Equipment
            copperField, silverField, electrumField, goldField, platinumField, otherField
            ;
    private JTextArea
            //Proficiencies and Languages
            profAndLangArea,
            //Attacks and Spellcasting
            attacksAndSpellcastingArea,
            //Equipment
            equipmentArea,
            //Personality
            personalityTraitsArea, idealsArea, bondsArea, flawsArea, featuresAndTraitsArea
            ;
    private JCheckBox
            //Skills
            acrobaticsProf, animalHandlingProf, arcanaProf, athleticsProf, deceptionProf, historyProf, insightProf, intimidationProf, investigationProf,
            medicineProf, natureProf, perceptionProf, performanceProf, persuasionProf, religionProf, sleightOfHandProf, stealthProf, survivalProf,
            acrobaticsExpert, animalHandlingExpert, arcanaExpert, athleticsExpert, deceptionExpert, historyExpert, insightExpert, intimidationExpert, investigationExpert,
            medicineExpert, natureExpert, perceptionExpert, performanceExpert, persuasionExpert, religionExpert, sleightOfHandExpert, stealthExpert, survivalExpert,
            //Saving Throws Panel
            strStProf, dexStProf, conStProf, intStProf, wisStProf, chaStProf,
            //Health Section Panel
            deathSaveSuccessOne, deathSaveSuccessTwo, deathSaveSuccessThree, deathSaveFailOne, deathSaveFailTwo, deathSaveFailThree
            ;
    private JButton
            //Personality
            saveButton, loadButton;

    //Skills Layout
    private GridBagLayout skillsGridBagLayout = new GridBagLayout();
    private GridBagConstraints skillsGridBagConstraints = new GridBagConstraints();

    //Saving Throws Layout
    private GridBagLayout savingThrowsLayout = new GridBagLayout();
    private GridBagConstraints savingThrowsConstraints = new GridBagConstraints();

    //Health Section Layout
    private GridBagLayout healthSectionLayout = new GridBagLayout();
    private GridBagConstraints healthSectionConstraints = new GridBagConstraints();

    //Death Save Layout
    private GridBagLayout deathSaveLayout = new GridBagLayout();
    private GridBagConstraints deathSaveConstraints = new GridBagConstraints();

    public View(Controller c) {
        super("DnD Character Sheet Tool");
        this.controller = c;

        //Frame
        this.setLayout(null);
        this.setSize(680, 880);
        this.setResizable(false);

        //Top Banner
        topBannerPanel = new JPanel();
        topBannerPanel.setLayout(null);
        topBannerPanel.setBounds(12, 5, 640, 100);
        topBannerPanel.setBackground(Color.black);
        topBannerPanel.setVisible(true);
        this.add(topBannerPanel);

        characterNameLabel = new JLabel("Character Name");
        characterNameLabel.setBounds(5, 2, 100, 13);
        characterNameLabel.setFont(font);
        characterNameLabel.setForeground(Color.white);
        topBannerPanel.add(characterNameLabel);

        characterNameField = new JTextField(controller.loadTopBanner(controller.getID()).getCharacterName());
        characterNameField.setBounds(5, 15, 200, 30);
        characterNameField.setColumns(10);
        characterNameField.setFont(fontLarge);
        characterNameField.setBackground(Color.darkGray);
        characterNameField.setForeground(Color.white);
        characterNameField.setBorder(null);
        topBannerPanel.add(characterNameField);

        playerNameLabel = new JLabel("Player Name");
        playerNameLabel.setBounds(5, 50, 100, 13);
        playerNameLabel.setFont(font);
        playerNameLabel.setForeground(Color.white);
        topBannerPanel.add(playerNameLabel);

        playerNameField = new JTextField(controller.loadTopBanner(controller.getID()).getPlayerName());
        playerNameField.setBounds(5, 64, 200, 30);
        playerNameField.setColumns(10);
        playerNameField.setFont(fontLarge);
        playerNameField.setBackground(Color.darkGray);
        playerNameField.setForeground(Color.white);
        playerNameField.setBorder(null);
        topBannerPanel.add(playerNameField);

        classLabel = new JLabel("Class");
        classLabel.setBounds(210, 2, 50, 13);
        classLabel.setFont(font);
        classLabel.setForeground(Color.white);
        topBannerPanel.add(classLabel);

        classField = new JTextField(controller.loadTopBanner(controller.getID()).getCharacterClass());
        classField.setBounds(210, 15, 200, 30);
        classField.setColumns(10);
        classField.setFont(fontLarge);
        classField.setBackground(Color.darkGray);
        classField.setForeground(Color.white);
        classField.setBorder(null);
        topBannerPanel.add(classField);

        raceLabel = new JLabel("Race");
        raceLabel.setBounds(210, 50, 50, 13);
        raceLabel.setFont(font);
        raceLabel.setForeground(Color.white);
        topBannerPanel.add(raceLabel);

        raceField = new JTextField(controller.loadTopBanner(controller.getID()).getRace());
        raceField.setBounds(210, 64, 200, 30);
        raceField.setColumns(10);
        raceField.setFont(fontLarge);
        raceField.setBackground(Color.darkGray);
        raceField.setForeground(Color.white);
        raceField.setBorder(null);
        topBannerPanel.add(raceField);

        levelLabel = new JLabel("Level");
        levelLabel.setBounds(415, 2, 30, 13);
        levelLabel.setFont(font);
        levelLabel.setForeground(Color.white);
        topBannerPanel.add(levelLabel);

        levelField = new JTextField(controller.loadTopBanner(controller.getID()).getLevel());
        levelField.setBounds(415, 15, 60, 30);
        levelField.setColumns(10);
        levelField.setFont(fontLarge);
        levelField.setBackground(Color.darkGray);
        levelField.setForeground(Color.white);
        levelField.setBorder(null);
        topBannerPanel.add(levelField);

        alignmentLabel = new JLabel("Alignment");
        alignmentLabel.setBounds(415, 50, 60, 13);
        alignmentLabel.setFont(font);
        alignmentLabel.setForeground(Color.white);
        topBannerPanel.add(alignmentLabel);

        alignmentField = new JTextField(controller.loadTopBanner(controller.getID()).getAlignment());
        alignmentField.setBounds(415, 64, 60, 30);
        alignmentField.setColumns(10);
        alignmentField.setFont(fontLarge);
        alignmentField.setBackground(Color.darkGray);
        alignmentField.setForeground(Color.white);
        alignmentField.setBorder(null);
        topBannerPanel.add(alignmentField);

        backgroundLabel = new JLabel("Background");
        backgroundLabel.setBounds(480, 2, 60, 13);
        backgroundLabel.setFont(font);
        backgroundLabel.setForeground(Color.white);
        topBannerPanel.add(backgroundLabel);

        backgroundField = new JTextField(controller.loadTopBanner(controller.getID()).getBackground());
        backgroundField.setBounds(480, 15, 150, 30);
        backgroundField.setColumns(10);
        backgroundField.setFont(fontLarge);
        backgroundField.setBackground(Color.darkGray);
        backgroundField.setForeground(Color.white);
        backgroundField.setBorder(null);
        topBannerPanel.add(backgroundField);

        experienceLabel = new JLabel("Experience Points");
        experienceLabel.setBounds(480, 50, 100, 13);
        experienceLabel.setFont(font);
        experienceLabel.setForeground(Color.white);
        topBannerPanel.add(experienceLabel);

        experienceField = new JTextField(controller.loadTopBanner(controller.getID()).getExpPoints());
        experienceField.setBounds(480, 64, 150, 30);
        experienceField.setColumns(10);
        experienceField.setFont(fontLarge);
        experienceField.setBackground(Color.darkGray);
        experienceField.setForeground(Color.white);
        experienceField.setBorder(null);
        topBannerPanel.add(experienceField);

        //Abilities
        abilitiesPanel = new JPanel();
        abilitiesPanel.setLayout(new FlowLayout());
        abilitiesPanel.setBounds(12, 110, 68, 420);
        abilitiesPanel.setBackground(Color.black);
        abilitiesPanel.setVisible(true);
        this.add(abilitiesPanel);

        strLabel = new JLabel("Strength");
        strLabel.setFont(font);
        strLabel.setForeground(Color.white);
        abilitiesPanel.add(strLabel);

        strField = new JTextField(controller.loadAbilities(controller.getID()).getStrength());
        strField.setColumns(3);
        strField.setFont(fontLarge);
        strField.setBackground(Color.darkGray);
        strField.setForeground(Color.white);
        strField.setBorder(null);
        abilitiesPanel.add(strField);

        strMod = new JLabel(controller.calcAbilityMod(strField.getText()));
        strMod.setFont(font);
        strMod.setForeground(Color.white);
        abilitiesPanel.add(strMod);

        dexLabel = new JLabel("Dexterity");
        dexLabel.setFont(font);
        dexLabel.setForeground(Color.white);
        abilitiesPanel.add(dexLabel);

        dexField = new JTextField(controller.loadAbilities(controller.getID()).getDexterity());
        dexField.setColumns(3);
        dexField.setFont(fontLarge);
        dexField.setBackground(Color.darkGray);
        dexField.setForeground(Color.white);
        dexField.setBorder(null);
        abilitiesPanel.add(dexField);

        dexMod = new JLabel(controller.calcAbilityMod(dexField.getText()));
        dexMod.setFont(font);
        dexMod.setForeground(Color.white);
        abilitiesPanel.add(dexMod);

        conLabel = new JLabel("Constitution");
        conLabel.setFont(font);
        conLabel.setForeground(Color.white);
        abilitiesPanel.add(conLabel);

        conField = new JTextField(controller.loadAbilities(controller.getID()).getConstitution());
        conField.setColumns(3);
        conField.setFont(fontLarge);
        conField.setBackground(Color.darkGray);
        conField.setForeground(Color.white);
        conField.setBorder(null);
        abilitiesPanel.add(conField);

        conMod = new JLabel(controller.calcAbilityMod(conField.getText()));
        conMod.setFont(font);
        conMod.setForeground(Color.white);
        abilitiesPanel.add(conMod);

        intLabel = new JLabel("Intelligence");
        intLabel.setFont(font);
        intLabel.setForeground(Color.white);
        abilitiesPanel.add(intLabel);

        intField = new JTextField(controller.loadAbilities(controller.getID()).getIntelligence());
        intField.setColumns(3);
        intField.setFont(fontLarge);
        intField.setBackground(Color.darkGray);
        intField.setForeground(Color.white);
        intField.setBorder(null);
        abilitiesPanel.add(intField);

        intMod = new JLabel(controller.calcAbilityMod(intField.getText()));
        intMod.setFont(font);
        intMod.setForeground(Color.white);
        abilitiesPanel.add(intMod);

        wisLabel = new JLabel("Wisdom");
        wisLabel.setFont(font);
        wisLabel.setForeground(Color.white);
        abilitiesPanel.add(wisLabel);

        wisField = new JTextField(controller.loadAbilities(controller.getID()).getWisdom());
        wisField.setColumns(3);
        wisField.setFont(fontLarge);
        wisField.setBackground(Color.darkGray);
        wisField.setForeground(Color.white);
        wisField.setBorder(null);
        abilitiesPanel.add(wisField);

        wisMod = new JLabel(controller.calcAbilityMod(wisField.getText()));
        wisMod.setFont(font);
        wisMod.setForeground(Color.white);
        abilitiesPanel.add(wisMod);

        chaLabel = new JLabel("Charisma");
        chaLabel.setFont(font);
        chaLabel.setForeground(Color.white);
        abilitiesPanel.add(chaLabel);

        chaField = new JTextField(controller.loadAbilities(controller.getID()).getCharisma());
        chaField.setColumns(3);
        chaField.setFont(fontLarge);
        chaField.setBackground(Color.darkGray);
        chaField.setForeground(Color.white);
        chaField.setBorder(null);
        abilitiesPanel.add(chaField);

        chaMod = new JLabel(controller.calcAbilityMod(chaField.getText()));
        chaMod.setFont(font);
        chaMod.setForeground(Color.white);
        abilitiesPanel.add(chaMod);

        //Proficiency Panel
        profPanel = new JPanel();
        profPanel.setLayout(new FlowLayout());
        profPanel.setBounds(85, 110,230, 55);
        profPanel.setBackground(Color.black);
        profPanel.setVisible(true);
        this.add(profPanel);

        profBonusLabel = new JLabel("Proficiency Bonus");
        profBonusLabel.setFont(font);
        profBonusLabel.setForeground(Color.white);
        profPanel.add(profBonusLabel);

        profBonusValue = new JLabel(controller.calcProfBonus(levelField.getText()));
        profBonusValue.setFont(fontLarge);
        profBonusValue.setForeground(Color.white);
        profPanel.add(profBonusValue);

        inspirationLabel = new JLabel("Inspiration");
        inspirationLabel.setFont(font);
        inspirationLabel.setForeground(Color.white);
        profPanel.add(inspirationLabel);

        inspirationField = new JTextField(controller.loadSkills(controller.getID()).getInspiration());
        inspirationField.setColumns(2);
        inspirationField.setFont(fontLarge);
        inspirationField.setBackground(Color.darkGray);
        inspirationField.setForeground(Color.white);
        inspirationField.setBorder(null);
        profPanel.add(inspirationField);

        passiveDescription = new JLabel("Passive skill = 10 + modifier + relevant ability" );
        passiveDescription.setFont(font);
        passiveDescription.setForeground(Color.white);
        profPanel.add(passiveDescription);

        //Skills
        skillsPanel = new JPanel();
        skillsPanel.setLayout(skillsGridBagLayout);
        skillsPanel.setBounds(85, 170, 230, 360);
        skillsPanel.setBackground(Color.black);
        skillsPanel.setVisible(true);
        this.add(skillsPanel);

        acrobaticsProf = new JCheckBox("Prof");
        acrobaticsProf.setSelected(controller.loadSkills(controller.getID()).isAcrobaticsProf());
        acrobaticsProf.setFont(font);
        acrobaticsProf.setBorder(null);
        acrobaticsProf.setBackground(Color.darkGray);
        acrobaticsProf.setForeground(Color.white);
        acrobaticsExpert = new JCheckBox("Exp");
        acrobaticsExpert.setSelected(controller.loadSkills(controller.getID()).isAcrobaticsExpert());
        acrobaticsExpert.setFont(font);
        acrobaticsExpert.setBorder(null);
        acrobaticsExpert.setBackground(Color.darkGray);
        acrobaticsExpert.setForeground(Color.white);
        acrobaticsMod = new JLabel(controller.calcSkills(acrobaticsProf.isSelected(),
                acrobaticsExpert.isSelected(), profBonusValue.getText(), dexMod.getText()));
        acrobaticsMod.setFont(font);
        acrobaticsMod.setForeground(Color.white);
        acrobaticsLabel = new JLabel("Acrobatics(Dex)");
        acrobaticsLabel.setFont(font);
        acrobaticsLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 0;
        skillsGridBagConstraints.ipadx = 5;
        skillsGridBagConstraints.ipady = 5;
        skillsPanel.add(acrobaticsProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 0;
        skillsPanel.add(acrobaticsExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 0;
        skillsPanel.add(acrobaticsMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 0;
        skillsPanel.add(acrobaticsLabel, skillsGridBagConstraints);

        animalHandlingProf = new JCheckBox("Prof");
        animalHandlingProf.setSelected(controller.loadSkills(controller.getID()).isAnimalHandlingProf());
        animalHandlingProf.setFont(font);
        animalHandlingProf.setBorder(null);
        animalHandlingProf.setBackground(Color.darkGray);
        animalHandlingProf.setForeground(Color.white);
        animalHandlingExpert = new JCheckBox("Exp");
        animalHandlingExpert.setSelected(controller.loadSkills(controller.getID()).isAnimalHandlingExpert());
        animalHandlingExpert.setFont(font);
        animalHandlingExpert.setBorder(null);
        animalHandlingExpert.setBackground(Color.darkGray);
        animalHandlingExpert.setForeground(Color.white);
        animalHandlingMod = new JLabel(controller.calcSkills(animalHandlingProf.isSelected(),
                animalHandlingExpert.isSelected(), profBonusValue.getText(), wisMod.getText()));
        animalHandlingMod.setFont(font);
        animalHandlingMod.setForeground(Color.white);
        animalHandlingLabel = new JLabel("Animal Handling (Wis)");
        animalHandlingLabel.setFont(font);
        animalHandlingLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 1;
        skillsPanel.add(animalHandlingProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 1;
        skillsPanel.add(animalHandlingExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 1;
        skillsPanel.add(animalHandlingMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 1;
        skillsPanel.add(animalHandlingLabel, skillsGridBagConstraints);

        arcanaProf = new JCheckBox("Prof");
        arcanaProf.setSelected(controller.loadSkills(controller.getID()).isArcanaProf());
        arcanaProf.setFont(font);
        arcanaProf.setBorder(null);
        arcanaProf.setBackground(Color.darkGray);
        arcanaProf.setForeground(Color.white);
        arcanaExpert = new JCheckBox("Exp");
        arcanaExpert.setSelected(controller.loadSkills(controller.getID()).isArcanaExpert());
        arcanaExpert.setFont(font);
        arcanaExpert.setBorder(null);
        arcanaExpert.setBackground(Color.darkGray);
        arcanaExpert.setForeground(Color.white);
        arcanaMod = new JLabel(controller.calcSkills(arcanaProf.isSelected(),
                arcanaExpert.isSelected(), profBonusValue.getText(), intMod.getText()));
        arcanaMod.setFont(font);
        arcanaMod.setForeground(Color.white);
        arcanaLabel = new JLabel("Arcana (Int)");
        arcanaLabel.setFont(font);
        arcanaLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 2;
        skillsPanel.add(arcanaProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 2;
        skillsPanel.add(arcanaExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 2;
        skillsPanel.add(arcanaMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 2;
        skillsPanel.add(arcanaLabel, skillsGridBagConstraints);

        athleticsProf = new JCheckBox("Prof");
        athleticsProf.setSelected(controller.loadSkills(controller.getID()).isAthleticsProf());
        athleticsProf.setFont(font);
        athleticsProf.setBorder(null);
        athleticsProf.setBackground(Color.darkGray);
        athleticsProf.setForeground(Color.white);
        athleticsExpert = new JCheckBox("Exp");
        athleticsExpert.setSelected(controller.loadSkills(controller.getID()).isAthleticsExpert());
        athleticsExpert.setFont(font);
        athleticsExpert.setBorder(null);
        athleticsExpert.setBackground(Color.darkGray);
        athleticsExpert.setForeground(Color.white);
        athleticsMod = new JLabel(controller.calcSkills(athleticsProf.isSelected(),
                athleticsExpert.isSelected(), profBonusValue.getText(), strMod.getText()));
        athleticsMod.setFont(font);
        athleticsMod.setForeground(Color.white);
        athleticsLabel = new JLabel("Athletics (Str)");
        athleticsLabel.setFont(font);
        athleticsLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 3;
        skillsPanel.add(athleticsProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 3;
        skillsPanel.add(athleticsExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 3;
        skillsPanel.add(athleticsMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 3;
        skillsPanel.add(athleticsLabel, skillsGridBagConstraints);

        deceptionProf = new JCheckBox("Prof");
        deceptionProf.setSelected(controller.loadSkills(controller.getID()).isDeceptionProf());
        deceptionProf.setFont(font);
        deceptionProf.setBorder(null);
        deceptionProf.setBackground(Color.darkGray);
        deceptionProf.setForeground(Color.white);
        deceptionExpert = new JCheckBox("Exp");
        deceptionExpert.setSelected(controller.loadSkills(controller.getID()).isDeceptionExpert());
        deceptionExpert.setFont(font);
        deceptionExpert.setBorder(null);
        deceptionExpert.setBackground(Color.darkGray);
        deceptionExpert.setForeground(Color.white);
        deceptionMod = new JLabel(controller.calcSkills(deceptionProf.isSelected(),
                deceptionExpert.isSelected(), profBonusValue.getText(), chaMod.getText()));
        deceptionMod.setFont(font);
        deceptionMod.setForeground(Color.white);
        deceptionLabel = new JLabel("Deception (Cha)");
        deceptionLabel.setFont(font);
        deceptionLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 4;
        skillsPanel.add(deceptionProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 4;
        skillsPanel.add(deceptionExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 4;
        skillsPanel.add(deceptionMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 4;
        skillsPanel.add(deceptionLabel, skillsGridBagConstraints);

        historyProf = new JCheckBox("Prof");
        historyProf.setSelected(controller.loadSkills(controller.getID()).isHistoryProf());
        historyProf.setFont(font);
        historyProf.setBorder(null);
        historyProf.setBackground(Color.darkGray);
        historyProf.setForeground(Color.white);
        historyExpert = new JCheckBox("Exp");
        historyExpert.setSelected(controller.loadSkills(controller.getID()).isHistoryExpert());
        historyExpert.setFont(font);
        historyExpert.setBorder(null);
        historyExpert.setBackground(Color.darkGray);
        historyExpert.setForeground(Color.white);
        historyMod = new JLabel(controller.calcSkills(historyProf.isSelected(),
                historyExpert.isSelected(), profBonusValue.getText(), intMod.getText()));
        historyMod.setFont(font);
        historyMod.setForeground(Color.white);
        historyLabel = new JLabel("History (Int)");
        historyLabel.setFont(font);
        historyLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 5;
        skillsPanel.add(historyProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 5;
        skillsPanel.add(historyExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 5;
        skillsPanel.add(historyMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 5;
        skillsPanel.add(historyLabel, skillsGridBagConstraints);

        insightProf = new JCheckBox("Prof");
        insightProf.setSelected(controller.loadSkills(controller.getID()).isInsightProf());
        insightProf.setFont(font);
        insightProf.setBorder(null);
        insightProf.setBackground(Color.darkGray);
        insightProf.setForeground(Color.white);
        insightExpert = new JCheckBox("Exp");
        insightExpert.setSelected(controller.loadSkills(controller.getID()).isInsightExpert());
        insightExpert.setFont(font);
        insightExpert.setBorder(null);
        insightExpert.setBackground(Color.darkGray);
        insightExpert.setForeground(Color.white);
        insightMod = new JLabel(controller.calcSkills(insightProf.isSelected(),
                insightExpert.isSelected(), profBonusValue.getText(), wisMod.getText()));
        insightMod.setFont(font);
        insightMod.setForeground(Color.white);
        insightLabel = new JLabel("Insight (Wis)");
        insightLabel.setFont(font);
        insightLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 6;
        skillsPanel.add(insightProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 6;
        skillsPanel.add(insightExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 6;
        skillsPanel.add(insightMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 6;
        skillsPanel.add(insightLabel, skillsGridBagConstraints);

        intimidationProf = new JCheckBox("Prof");
        intimidationProf.setSelected(controller.loadSkills(controller.getID()).isIntimidationProf());
        intimidationProf.setFont(font);
        intimidationProf.setBorder(null);
        intimidationProf.setBackground(Color.darkGray);
        intimidationProf.setForeground(Color.white);
        intimidationExpert = new JCheckBox("Exp");
        intimidationExpert.setSelected(controller.loadSkills(controller.getID()).isArcanaExpert());
        intimidationExpert.setFont(font);
        intimidationExpert.setBorder(null);
        intimidationExpert.setBackground(Color.darkGray);
        intimidationExpert.setForeground(Color.white);
        intimidationMod = new JLabel(controller.calcSkills(intimidationProf.isSelected(),
                intimidationExpert.isSelected(), profBonusValue.getText(), chaMod.getText()));
        intimidationMod.setFont(font);
        intimidationMod.setForeground(Color.white);
        intimidationLabel = new JLabel("Intimidation (Cha)");
        intimidationLabel.setFont(font);
        intimidationLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 7;
        skillsPanel.add(intimidationProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 7;
        skillsPanel.add(intimidationExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 7;
        skillsPanel.add(intimidationMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 7;
        skillsPanel.add(intimidationLabel, skillsGridBagConstraints);

        investigationProf = new JCheckBox("Prof");
        investigationProf.setSelected(controller.loadSkills(controller.getID()).isInvestigationProf());
        investigationProf.setFont(font);
        investigationProf.setBorder(null);
        investigationProf.setBackground(Color.darkGray);
        investigationProf.setForeground(Color.white);
        investigationExpert = new JCheckBox("Exp");
        investigationExpert.setSelected(controller.loadSkills(controller.getID()).isInvestigationExpert());
        investigationExpert.setFont(font);
        investigationExpert.setBorder(null);
        investigationExpert.setBackground(Color.darkGray);
        investigationExpert.setForeground(Color.white);
        investigationMod = new JLabel(controller.calcSkills(investigationProf.isSelected(),
                investigationExpert.isSelected(), profBonusValue.getText(), intMod.getText()));
        investigationMod.setFont(font);
        investigationMod.setForeground(Color.white);
        investigationLabel = new JLabel("Investigation (Int)");
        investigationLabel.setFont(font);
        investigationLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 8;
        skillsPanel.add(investigationProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 8;
        skillsPanel.add(investigationExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 8;
        skillsPanel.add(investigationMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 8;
        skillsPanel.add(investigationLabel, skillsGridBagConstraints);

        medicineProf = new JCheckBox("Prof");
        medicineProf.setSelected(controller.loadSkills(controller.getID()).isMedicineProf());
        medicineProf.setFont(font);
        medicineProf.setBorder(null);
        medicineProf.setBackground(Color.darkGray);
        medicineProf.setForeground(Color.white);
        medicineExpert = new JCheckBox("Exp");
        medicineExpert.setSelected(controller.loadSkills(controller.getID()).isMedicineExpert());
        medicineExpert.setFont(font);
        medicineExpert.setBorder(null);
        medicineExpert.setBackground(Color.darkGray);
        medicineExpert.setForeground(Color.white);
        medicineMod = new JLabel(controller.calcSkills(medicineProf.isSelected(),
                medicineExpert.isSelected(), profBonusValue.getText(), wisMod.getText()));
        medicineMod.setFont(font);
        medicineMod.setForeground(Color.white);
        medicineLabel = new JLabel("Medicine (Wis)");
        medicineLabel.setFont(font);
        medicineLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 9;
        skillsPanel.add(medicineProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 9;
        skillsPanel.add(medicineExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 9;
        skillsPanel.add(medicineMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 9;
        skillsPanel.add(medicineLabel, skillsGridBagConstraints);

        natureProf = new JCheckBox("Prof");
        natureProf.setSelected(controller.loadSkills(controller.getID()).isNatureProf());
        natureProf.setFont(font);
        natureProf.setBorder(null);
        natureProf.setBackground(Color.darkGray);
        natureProf.setForeground(Color.white);
        natureExpert = new JCheckBox("Exp");
        natureExpert.setSelected(controller.loadSkills(controller.getID()).isNatureExpert());
        natureExpert.setFont(font);
        natureExpert.setBorder(null);
        natureExpert.setBackground(Color.darkGray);
        natureExpert.setForeground(Color.white);
        natureMod = new JLabel(controller.calcSkills(natureProf.isSelected(),
                natureExpert.isSelected(), profBonusValue.getText(), intMod.getText()));
        natureMod.setFont(font);
        natureMod.setForeground(Color.white);
        natureLabel = new JLabel("Nature (Int)");
        natureLabel.setFont(font);
        natureLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 10;
        skillsPanel.add(natureProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 10;
        skillsPanel.add(natureExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 10;
        skillsPanel.add(natureMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 10;
        skillsPanel.add(natureLabel, skillsGridBagConstraints);

        perceptionProf = new JCheckBox("Prof");
        perceptionProf.setSelected(controller.loadSkills(controller.getID()).isPerceptionProf());
        perceptionProf.setFont(font);
        perceptionProf.setBorder(null);
        perceptionProf.setBackground(Color.darkGray);
        perceptionProf.setForeground(Color.white);
        perceptionExpert = new JCheckBox("Exp");
        perceptionExpert.setSelected(controller.loadSkills(controller.getID()).isPerceptionExpert());
        perceptionExpert.setFont(font);
        perceptionExpert.setBorder(null);
        perceptionExpert.setBackground(Color.darkGray);
        perceptionExpert.setForeground(Color.white);
        perceptionMod = new JLabel(controller.calcSkills(perceptionProf.isSelected(),
                perceptionExpert.isSelected(), profBonusValue.getText(), wisMod.getText()));
        perceptionMod.setFont(font);
        perceptionMod.setForeground(Color.white);
        perceptionLabel = new JLabel("Perception (Wis)");
        perceptionLabel.setFont(font);
        perceptionLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 11;
        skillsPanel.add(perceptionProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 11;
        skillsPanel.add(perceptionExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 11;
        skillsPanel.add(perceptionMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 11;
        skillsPanel.add(perceptionLabel, skillsGridBagConstraints);

        performanceProf = new JCheckBox("Prof");
        performanceProf.setSelected(controller.loadSkills(controller.getID()).isPerformanceProf());
        performanceProf.setFont(font);
        performanceProf.setBorder(null);
        performanceProf.setBackground(Color.darkGray);
        performanceProf.setForeground(Color.white);
        performanceExpert = new JCheckBox("Exp");
        performanceExpert.setSelected(controller.loadSkills(controller.getID()).isPerformanceExpert());
        performanceExpert.setFont(font);
        performanceExpert.setBorder(null);
        performanceExpert.setBackground(Color.darkGray);
        performanceExpert.setForeground(Color.white);
        performanceMod = new JLabel(controller.calcSkills(performanceProf.isSelected(),
                performanceExpert.isSelected(), profBonusValue.getText(), chaMod.getText()));
        performanceMod.setFont(font);
        performanceMod.setForeground(Color.white);
        performanceLabel = new JLabel("Performance (Cha)");
        performanceLabel.setFont(font);
        performanceLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 12;
        skillsPanel.add(performanceProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 12;
        skillsPanel.add(performanceExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 12;
        skillsPanel.add(performanceMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 12;
        skillsPanel.add(performanceLabel, skillsGridBagConstraints);

        persuasionProf = new JCheckBox("Prof");
        persuasionProf.setSelected(controller.loadSkills(controller.getID()).isPersuasionProf());
        persuasionProf.setFont(font);
        persuasionProf.setBorder(null);
        persuasionProf.setBackground(Color.darkGray);
        persuasionProf.setForeground(Color.white);
        persuasionExpert = new JCheckBox("Exp");
        persuasionExpert.setSelected(controller.loadSkills(controller.getID()).isPersuasionExpert());
        persuasionExpert.setFont(font);
        persuasionExpert.setBorder(null);
        persuasionExpert.setBackground(Color.darkGray);
        persuasionExpert.setForeground(Color.white);
        persuasionMod = new JLabel(controller.calcSkills(persuasionProf.isSelected(),
                persuasionExpert.isSelected(), profBonusValue.getText(), chaMod.getText()));
        persuasionMod.setFont(font);
        persuasionMod.setForeground(Color.white);
        persuasionLabel = new JLabel("Persuasion (Cha)");
        persuasionLabel.setFont(font);
        persuasionLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 13;
        skillsPanel.add(persuasionProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 13;
        skillsPanel.add(persuasionExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 13;
        skillsPanel.add(persuasionMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 13;
        skillsPanel.add(persuasionLabel, skillsGridBagConstraints);

        religionProf = new JCheckBox("Prof");
        religionProf.setSelected(controller.loadSkills(controller.getID()).isReligionProf());
        religionProf.setFont(font);
        religionProf.setBorder(null);
        religionProf.setBackground(Color.darkGray);
        religionProf.setForeground(Color.white);
        religionExpert = new JCheckBox("Exp");
        religionExpert.setSelected(controller.loadSkills(controller.getID()).isReligionExpert());
        religionExpert.setFont(font);
        religionExpert.setBorder(null);
        religionExpert.setBackground(Color.darkGray);
        religionExpert.setForeground(Color.white);
        religionMod = new JLabel(controller.calcSkills(religionProf.isSelected(),
                religionExpert.isSelected(), profBonusValue.getText(), intMod.getText()));
        religionMod.setFont(font);
        religionMod.setForeground(Color.white);
        religionLabel = new JLabel("Religion (Int)");
        religionLabel.setFont(font);
        religionLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 14;
        skillsPanel.add(religionProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 14;
        skillsPanel.add(religionExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 14;
        skillsPanel.add(religionMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 14;
        skillsPanel.add(religionLabel, skillsGridBagConstraints);

        sleightOfHandProf = new JCheckBox("Prof");
        sleightOfHandProf.setSelected(controller.loadSkills(controller.getID()).isSleightOfHandProf());
        sleightOfHandProf.setFont(font);
        sleightOfHandProf.setBorder(null);
        sleightOfHandProf.setBackground(Color.darkGray);
        sleightOfHandProf.setForeground(Color.white);
        sleightOfHandExpert = new JCheckBox("Exp");
        sleightOfHandExpert.setSelected(controller.loadSkills(controller.getID()).isSleightOfHandExpert());
        sleightOfHandExpert.setFont(font);
        sleightOfHandExpert.setBorder(null);
        sleightOfHandExpert.setBackground(Color.darkGray);
        sleightOfHandExpert.setForeground(Color.white);
        sleightOfHandMod = new JLabel(controller.calcSkills(sleightOfHandProf.isSelected(),
                sleightOfHandExpert.isSelected(), profBonusValue.getText(), dexMod.getText()));
        sleightOfHandMod.setFont(font);
        sleightOfHandMod.setForeground(Color.white);
        sleightOfHandLabel = new JLabel("Sleight of Hand (Dex)");
        sleightOfHandLabel.setFont(font);
        sleightOfHandLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 15;
        skillsPanel.add(sleightOfHandProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 15;
        skillsPanel.add(sleightOfHandExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 15;
        skillsPanel.add(sleightOfHandMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 15;
        skillsPanel.add(sleightOfHandLabel, skillsGridBagConstraints);

        stealthProf = new JCheckBox("Prof");
        stealthProf.setSelected(controller.loadSkills(controller.getID()).isStealthProf());
        stealthProf.setFont(font);
        stealthProf.setBorder(null);
        stealthProf.setBackground(Color.darkGray);
        stealthProf.setForeground(Color.white);
        stealthExpert = new JCheckBox("Exp");
        stealthExpert.setSelected(controller.loadSkills(controller.getID()).isStealthExpert());
        stealthExpert.setFont(font);
        stealthExpert.setBorder(null);
        stealthExpert.setBackground(Color.darkGray);
        stealthExpert.setForeground(Color.white);
        stealthMod = new JLabel(controller.calcSkills(stealthProf.isSelected(),
                stealthExpert.isSelected(), profBonusValue.getText(), dexMod.getText()));
        stealthMod.setFont(font);
        stealthMod.setForeground(Color.white);
        stealthLabel = new JLabel("Stealth (Dex");
        stealthLabel.setFont(font);
        stealthLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 16;
        skillsPanel.add(stealthProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 16;
        skillsPanel.add(stealthExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 16;
        skillsPanel.add(stealthMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 16;
        skillsPanel.add(stealthLabel, skillsGridBagConstraints);

        survivalProf = new JCheckBox("Prof");
        survivalProf.setSelected(controller.loadSkills(controller.getID()).isSurvivalProf());
        survivalProf.setFont(font);
        survivalProf.setBorder(null);
        survivalProf.setBackground(Color.darkGray);
        survivalProf.setForeground(Color.white);
        survivalExpert = new JCheckBox("Exp");
        survivalExpert.setSelected(controller.loadSkills(controller.getID()).isSurvivalExpert());
        survivalExpert.setFont(font);
        survivalExpert.setBorder(null);
        survivalExpert.setBackground(Color.darkGray);
        survivalExpert.setForeground(Color.white);
        survivalMod = new JLabel(controller.calcSkills(survivalProf.isSelected(),
                survivalExpert.isSelected(), profBonusValue.getText(), wisMod.getText()));
        survivalMod.setFont(font);
        survivalMod.setForeground(Color.white);
        survivalLabel = new JLabel("Survival (Wis)");
        survivalLabel.setFont(font);
        survivalLabel.setForeground(Color.white);
        skillsGridBagConstraints.gridx = 0;
        skillsGridBagConstraints.gridy = 17;
        skillsPanel.add(survivalProf, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 1;
        skillsGridBagConstraints.gridy = 17;
        skillsPanel.add(survivalExpert, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 2;
        skillsGridBagConstraints.gridy = 17;
        skillsPanel.add(survivalMod, skillsGridBagConstraints);
        skillsGridBagConstraints.gridx = 3;
        skillsGridBagConstraints.gridy = 17;
        skillsPanel.add(survivalLabel, skillsGridBagConstraints);

        //Saving Throws
        savingThrowsPanel = new JPanel();
        savingThrowsPanel.setLayout(savingThrowsLayout);
        savingThrowsPanel.setBounds(12, 535, 203, 115);
        savingThrowsPanel.setBackground(Color.black);
        savingThrowsPanel.setVisible(true);
        this.add(savingThrowsPanel);

        strStProf = new JCheckBox("Prof");
        strStProf.setSelected(controller.loadSkills(controller.getID()).isStrSTProf());
        strStProf.setFont(font);
        strStProf.setBorder(null);
        strStProf.setBackground(Color.darkGray);
        strStProf.setForeground(Color.white);
        strStValue = new JLabel(controller.calcSavingThrow(strStProf.isSelected(), profBonusValue.getText(), strMod.getText()));
        strStValue.setFont(font);
        strStValue.setForeground(Color.white);
        strStLabel = new JLabel("Strength Saving Throw");
        strStLabel.setFont(font);
        strStLabel.setForeground(Color.white);
        savingThrowsConstraints.gridx = 0;
        savingThrowsConstraints.gridy = 0;
        savingThrowsConstraints.ipadx = 5;
        savingThrowsConstraints.ipady = 5;
        savingThrowsPanel.add(strStProf, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 1;
        savingThrowsConstraints.gridy = 0;
        savingThrowsPanel.add(strStValue, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 2;
        savingThrowsConstraints.gridy = 0;
        savingThrowsPanel.add(strStLabel, savingThrowsConstraints);

        dexStProf = new JCheckBox("Prof");
        dexStProf.setSelected(controller.loadSkills(controller.getID()).isDexSTProf());
        dexStProf.setFont(font);
        dexStProf.setBorder(null);
        dexStProf.setBackground(Color.darkGray);
        dexStProf.setForeground(Color.white);
        dexStValue = new JLabel(controller.calcSavingThrow(dexStProf.isSelected(), profBonusValue.getText(), dexMod.getText()));
        dexStValue.setFont(font);
        dexStValue.setForeground(Color.white);
        dexStLabel = new JLabel("Dexterity Saving Throw");
        dexStLabel.setFont(font);
        dexStLabel.setForeground(Color.white);
        savingThrowsConstraints.gridx = 0;
        savingThrowsConstraints.gridy = 1;
        savingThrowsPanel.add(dexStProf, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 1;
        savingThrowsConstraints.gridy = 1;
        savingThrowsPanel.add(dexStValue, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 2;
        savingThrowsConstraints.gridy = 1;
        savingThrowsPanel.add(dexStLabel, savingThrowsConstraints);

        conStProf = new JCheckBox("Prof");
        conStProf.setSelected(controller.loadSkills(controller.getID()).isConSTProf());
        conStProf.setFont(font);
        conStProf.setBorder(null);
        conStProf.setBackground(Color.darkGray);
        conStProf.setForeground(Color.white);
        conStValue = new JLabel(controller.calcSavingThrow(conStProf.isSelected(), profBonusValue.getText(), conMod.getText()));
        conStValue.setFont(font);
        conStValue.setForeground(Color.white);
        conStLabel = new JLabel("Constitution Saving Throw");
        conStLabel.setFont(font);
        conStLabel.setForeground(Color.white);
        savingThrowsConstraints.gridx = 0;
        savingThrowsConstraints.gridy = 2;
        savingThrowsPanel.add(conStProf, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 1;
        savingThrowsConstraints.gridy = 2;
        savingThrowsPanel.add(conStValue, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 2;
        savingThrowsConstraints.gridy = 2;
        savingThrowsPanel.add(conStLabel, savingThrowsConstraints);

        intStProf = new JCheckBox("Prof");
        intStProf.setSelected(controller.loadSkills(controller.getID()).isIntSTProf());
        intStProf.setFont(font);
        intStProf.setBorder(null);
        intStProf.setBackground(Color.darkGray);
        intStProf.setForeground(Color.white);
        intStValue = new JLabel(controller.calcSavingThrow(intStProf.isSelected(), profBonusValue.getText(), intMod.getText()));
        intStValue.setFont(font);
        intStValue.setForeground(Color.white);
        intStLabel = new JLabel("Intelligence Saving Throw");
        intStLabel.setFont(font);
        intStLabel.setForeground(Color.white);
        savingThrowsConstraints.gridx = 0;
        savingThrowsConstraints.gridy = 3;
        savingThrowsPanel.add(intStProf, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 1;
        savingThrowsConstraints.gridy = 3;
        savingThrowsPanel.add(intStValue, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 2;
        savingThrowsConstraints.gridy = 3;
        savingThrowsPanel.add(intStLabel, savingThrowsConstraints);

        wisStProf = new JCheckBox("Prof");
        wisStProf.setSelected(controller.loadSkills(controller.getID()).isWisSTProf());
        wisStProf.setFont(font);
        wisStProf.setBorder(null);
        wisStProf.setBackground(Color.darkGray);
        wisStProf.setForeground(Color.white);
        wisStValue = new JLabel(controller.calcSavingThrow(wisStProf.isSelected(), profBonusValue.getText(), wisMod.getText()));
        wisStValue.setFont(font);
        wisStValue.setForeground(Color.white);
        wisStLabel = new JLabel("Wisdom Saving Throw");
        wisStLabel.setFont(font);
        wisStLabel.setForeground(Color.white);
        savingThrowsConstraints.gridx = 0;
        savingThrowsConstraints.gridy = 4;
        savingThrowsPanel.add(wisStProf, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 1;
        savingThrowsConstraints.gridy = 4;
        savingThrowsPanel.add(wisStValue, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 2;
        savingThrowsConstraints.gridy = 4;
        savingThrowsPanel.add(wisStLabel, savingThrowsConstraints);

        chaStProf = new JCheckBox("Prof");
        chaStProf.setSelected(controller.loadSkills(controller.getID()).isChaSTProf());
        chaStProf.setFont(font);
        chaStProf.setBorder(null);
        chaStProf.setBackground(Color.darkGray);
        chaStProf.setForeground(Color.white);
        chaStValue = new JLabel(controller.calcSavingThrow(chaStProf.isSelected(), profBonusValue.getText(), chaMod.getText()));
        chaStValue.setFont(font);
        chaStValue.setForeground(Color.white);
        chaStLabel = new JLabel("Charisma Saving Throw");
        chaStLabel.setFont(font);
        chaStLabel.setForeground(Color.white);
        savingThrowsConstraints.gridx = 0;
        savingThrowsConstraints.gridy = 5;
        savingThrowsPanel.add(chaStProf, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 1;
        savingThrowsConstraints.gridy = 5;
        savingThrowsPanel.add(chaStValue, savingThrowsConstraints);
        savingThrowsConstraints.gridx = 2;
        savingThrowsConstraints.gridy = 5;
        savingThrowsPanel.add(chaStLabel, savingThrowsConstraints);

        //Health Section Panel
        healthSectionPanel = new JPanel();
        healthSectionPanel.setLayout(healthSectionLayout);
        healthSectionPanel.setBounds(320, 110, 175, 125);
        healthSectionPanel.setBackground(Color.black);
        this.add(healthSectionPanel);

        ACLabel = new JLabel("Armor Class");
        ACLabel.setFont(font);
        ACLabel.setForeground(Color.white);
        ACField = new JTextField(controller.loadHealth(controller.getID()).getAc());
        ACField.setColumns(2);
        ACField.setBorder(null);
        ACField.setFont(fontLarge);
        ACField.setBackground(Color.darkGray);
        ACField.setForeground(Color.white);
        healthSectionConstraints.gridx = 0;
        healthSectionConstraints.gridy = 0;
        healthSectionConstraints.ipadx = 1;
        healthSectionConstraints.ipady = 1;
        healthSectionPanel.add(ACLabel, healthSectionConstraints);
        healthSectionConstraints.gridx = 0;
        healthSectionConstraints.gridy = 1;
        healthSectionPanel.add(ACField, healthSectionConstraints);

        initiativeLabel = new JLabel("Initiative");
        initiativeLabel.setFont(font);
        initiativeLabel.setForeground(Color.white);
        initiativeField = new JTextField(controller.loadHealth(controller.getID()).getInitiative());
        initiativeField.setColumns(2);
        initiativeField.setBorder(null);
        initiativeField.setFont(fontLarge);
        initiativeField.setBackground(Color.darkGray);
        initiativeField.setForeground(Color.white);
        healthSectionConstraints.gridx = 1;
        healthSectionConstraints.gridy = 0;
        healthSectionPanel.add(initiativeLabel, healthSectionConstraints);
        healthSectionConstraints.gridx = 1;
        healthSectionConstraints.gridy = 1;
        healthSectionPanel.add(initiativeField, healthSectionConstraints);

        speedLabel = new JLabel("Speed");
        speedLabel.setFont(font);
        speedLabel.setForeground(Color.white);
        speedField = new JTextField(controller.loadHealth(controller.getID()).getSpeed());
        speedField.setColumns(2);
        speedField.setBorder(null);
        speedField.setFont(fontLarge);
        speedField.setBackground(Color.darkGray);
        speedField.setForeground(Color.white);
        healthSectionConstraints.gridx = 2;
        healthSectionConstraints.gridy = 0;
        healthSectionPanel.add(speedLabel, healthSectionConstraints);
        healthSectionConstraints.gridx = 2;
        healthSectionConstraints.gridy = 1;
        healthSectionPanel.add(speedField, healthSectionConstraints);

        HPMaxLabel = new JLabel("HP Max");
        HPMaxLabel.setFont(font);
        HPMaxLabel.setForeground(Color.white);
        HPMaxField = new JTextField(controller.loadHealth(controller.getID()).getHPMax());
        HPMaxField.setColumns(2);
        HPMaxField.setBorder(null);
        HPMaxField.setFont(fontLarge);
        HPMaxField.setBackground(Color.darkGray);
        HPMaxField.setForeground(Color.white);
        healthSectionConstraints.gridx = 0;
        healthSectionConstraints.gridy = 2;
        healthSectionPanel.add(HPMaxLabel, healthSectionConstraints);
        healthSectionConstraints.gridx = 0;
        healthSectionConstraints.gridy = 3;
        healthSectionPanel.add(HPMaxField, healthSectionConstraints);

        HPCurrentLabel = new JLabel("Current HP");
        HPCurrentLabel.setFont(font);
        HPCurrentLabel.setForeground(Color.white);
        HPCurrentField = new JTextField(controller.loadHealth(controller.getID()).getHPCurrent());
        HPCurrentField.setColumns(2);
        HPCurrentField.setBorder(null);
        HPCurrentField.setFont(fontLarge);
        HPCurrentField.setBackground(Color.darkGray);
        HPCurrentField.setForeground(Color.white);
        healthSectionConstraints.gridx = 1;
        healthSectionConstraints.gridy = 2;
        healthSectionPanel.add(HPCurrentLabel, healthSectionConstraints);
        healthSectionConstraints.gridx = 1;
        healthSectionConstraints.gridy = 3;
        healthSectionPanel.add(HPCurrentField, healthSectionConstraints);

        HPTempLabel = new JLabel("Temp HP");
        HPTempLabel.setFont(font);
        HPTempLabel.setForeground(Color.white);
        HPTempField = new JTextField(controller.loadHealth(controller.getID()).getHPTemp());
        HPTempField.setColumns(2);
        HPTempField.setBorder(null);
        HPTempField.setFont(fontLarge);
        HPTempField.setBackground(Color.darkGray);
        HPTempField.setForeground(Color.white);
        healthSectionConstraints.gridx = 2;
        healthSectionConstraints.gridy = 2;
        healthSectionPanel.add(HPTempLabel, healthSectionConstraints);
        healthSectionConstraints.gridx = 2;
        healthSectionConstraints.gridy = 3;
        healthSectionPanel.add(HPTempField, healthSectionConstraints);

        hitDiceLabel = new JLabel("Hit Dice");
        hitDiceLabel.setFont(font);
        hitDiceLabel.setForeground(Color.white);
        hitDiceField = new JTextField(controller.loadHealth(controller.getID()).getHitDice());
        hitDiceField.setBorder(null);
        hitDiceField.setFont(fontLarge);
        hitDiceField.setBackground(Color.darkGray);
        hitDiceField.setForeground(Color.white);
        healthSectionConstraints.gridx = 1;
        healthSectionConstraints.gridy = 4;
        healthSectionPanel.add(hitDiceLabel, healthSectionConstraints);
        healthSectionConstraints.gridx = 1;
        healthSectionConstraints.gridy = 5;
        healthSectionConstraints.fill = GridBagConstraints.HORIZONTAL;
        healthSectionPanel.add(hitDiceField, healthSectionConstraints);

        //Death Save Panel
        deathSavePanel = new JPanel();
        deathSavePanel.setLayout(deathSaveLayout);
        deathSavePanel.setBounds(500, 110, 152, 60);
        deathSavePanel.setBackground(Color.black);
        this.add(deathSavePanel);

        deathSaveSuccessLabel = new JLabel("Death Save Success");
        deathSaveSuccessLabel.setFont(font);
        deathSaveSuccessLabel.setForeground(Color.white);
        deathSaveConstraints.gridx = 1;
        deathSaveConstraints.gridy = 0;
        deathSavePanel.add(deathSaveSuccessLabel, deathSaveConstraints);
        deathSaveFailLabel = new JLabel("Death Save Fail");
        deathSaveFailLabel.setFont(font);
        deathSaveFailLabel.setForeground(Color.white);
        deathSaveConstraints.gridx = 1;
        deathSaveConstraints.gridy = 2;
        deathSavePanel.add(deathSaveFailLabel, deathSaveConstraints);

        deathSaveSuccessOne = new JCheckBox();
        deathSaveSuccessOne.setSelected(controller.loadHealth(controller.getID()).isDeathSaveSuccessOne());
        deathSaveSuccessOne.setBorder(null);
        deathSaveSuccessOne.setBackground(Color.darkGray);
        deathSaveConstraints.gridx = 0;
        deathSaveConstraints.gridy = 1;
        deathSavePanel.add(deathSaveSuccessOne, deathSaveConstraints);
        deathSaveSuccessTwo = new JCheckBox();
        deathSaveSuccessTwo.setSelected(controller.loadHealth(controller.getID()).isDeathSaveSuccessTwo());
        deathSaveSuccessTwo.setBorder(null);
        deathSaveSuccessTwo.setBackground(Color.darkGray);
        deathSaveConstraints.gridx = 1;
        deathSaveConstraints.gridy = 1;
        deathSavePanel.add(deathSaveSuccessTwo, deathSaveConstraints);
        deathSaveSuccessThree = new JCheckBox();
        deathSaveSuccessThree.setSelected(controller.loadHealth(controller.getID()).isDeathSaveSuccessThree());
        deathSaveSuccessThree.setBorder(null);
        deathSaveSuccessThree.setBackground(Color.darkGray);
        deathSaveSuccessThree.setForeground(Color.white);
        deathSaveSuccessThree.setFont(font);
        deathSaveConstraints.gridx = 2;
        deathSaveConstraints.gridy = 1;
        deathSavePanel.add(deathSaveSuccessThree, deathSaveConstraints);

        deathSaveFailOne = new JCheckBox();
        deathSaveFailOne.setSelected(controller.loadHealth(controller.getID()).isDeathSaveFailOne());
        deathSaveFailOne.setBorder(null);
        deathSaveFailOne.setBackground(Color.darkGray);
        deathSaveConstraints.gridx = 0;
        deathSaveConstraints.gridy = 3;
        deathSavePanel.add(deathSaveFailOne, deathSaveConstraints);
        deathSaveFailTwo = new JCheckBox();
        deathSaveFailTwo.setSelected(controller.loadHealth(controller.getID()).isDeathSaveFailTwo());
        deathSaveFailTwo.setBorder(null);
        deathSaveFailTwo.setBackground(Color.darkGray);
        deathSaveConstraints.gridx = 1;
        deathSaveConstraints.gridy = 3;
        deathSavePanel.add(deathSaveFailTwo, deathSaveConstraints);
        deathSaveFailThree = new JCheckBox();
        deathSaveFailThree.setSelected(controller.loadHealth(controller.getID()).isDeathSaveFailThree());
        deathSaveFailThree.setBorder(null);
        deathSaveFailThree.setBackground(Color.darkGray);
        deathSaveFailThree.setForeground(Color.white);
        deathSaveFailThree.setFont(font);
        deathSaveConstraints.gridx = 2;
        deathSaveConstraints.gridy = 3;
        deathSavePanel.add(deathSaveFailThree, deathSaveConstraints);

        //Proficiencies and Languages
        profAndLangPanel = new JPanel();
        profAndLangPanel.setLayout(null);
        profAndLangPanel.setBounds(12, 655, 203, 175);
        profAndLangPanel.setBackground(Color.black);
        this.add(profAndLangPanel);

        profAndLangLabel = new JLabel("Other Proficiencies and Languages");
        profAndLangLabel.setBounds(25, 2, 200, 13);
        profAndLangLabel.setFont(font);
        profAndLangLabel.setForeground(Color.white);
        profAndLangPanel.add(profAndLangLabel);

        profAndLangArea = new JTextArea(controller.loadProfAndLang(controller.getID()).getProfAndLang());
        profAndLangArea.setBounds(4, 15, 195, 155);
        profAndLangArea.setBorder(null);
        profAndLangArea.setLineWrap(true);
        profAndLangArea.setWrapStyleWord(true);
        profAndLangArea.setFont(font);
        profAndLangArea.setForeground(Color.white);
        profAndLangArea.setBackground(Color.darkGray);
        profAndLangPanel.add(profAndLangArea);

        //Attacks and Spellcasting
        attacksAndSpellcastingPanel = new JPanel();
        attacksAndSpellcastingPanel.setLayout(null);
        attacksAndSpellcastingPanel.setBounds(320, 240, 175, 290);
        attacksAndSpellcastingPanel.setBackground(Color.black);
        this.add(attacksAndSpellcastingPanel);

        attackNameLabel = new JLabel("Attack Name");
        attackNameLabel.setFont(font);
        attackNameLabel.setBounds(2, 2, 80, 13);
        attackNameLabel.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(attackNameLabel);
        attackNameField = new JTextField(controller.loadAttacks(controller.getID()).getAttackName());
        attackNameField.setBounds(2, 15, 80, 25);
        attackNameField.setBorder(null);
        attackNameField.setFont(fontMedium);
        attackNameField.setBackground(Color.darkGray);
        attackNameField.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(attackNameField);

        attackModLabel = new JLabel("Mod");
        attackModLabel.setFont(font);
        attackModLabel.setBounds(84, 2, 40, 13);
        attackModLabel.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(attackModLabel);
        attackModField = new JTextField(controller.loadAttacks(controller.getID()).getAttackModifier());
        attackModField.setBounds(84, 15, 30, 25);
        attackModField.setBorder(null);
        attackModField.setFont(fontMedium);
        attackModField.setBackground(Color.darkGray);
        attackModField.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(attackModField);

        rangeDamageLabel = new JLabel("Range");
        rangeDamageLabel.setFont(font);
        rangeDamageLabel.setBounds(116, 2, 60, 13);
        rangeDamageLabel.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(rangeDamageLabel);
        rangeDamageField = new JTextField(controller.loadAttacks(controller.getID()).getDamageRange());
        rangeDamageField.setBounds(116, 15, 57, 25);
        rangeDamageField.setBorder(null);
        rangeDamageField.setFont(fontMedium);
        rangeDamageField.setBackground(Color.darkGray);
        rangeDamageField.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(rangeDamageField);

        baseDamageLabel = new JLabel("Damage");
        baseDamageLabel.setFont(font);
        baseDamageLabel.setBounds(2, 42, 80, 13);
        baseDamageLabel.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(baseDamageLabel);
        baseDamageField = new JTextField(controller.loadAttacks(controller.getID()).getDamageBase());
        baseDamageField.setBounds(2, 55, 80, 25);
        baseDamageField.setBorder(null);
        baseDamageField.setFont(fontMedium);
        baseDamageField.setBackground(Color.darkGray);
        baseDamageField.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(baseDamageField);

        modDamageLabel = new JLabel("Mod");
        modDamageLabel.setFont(font);
        modDamageLabel.setBounds(84, 42, 80, 13);
        modDamageLabel.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(modDamageLabel);
        modDamageField = new JTextField(controller.loadAttacks(controller.getID()).getDamageMod());
        modDamageField.setBounds(84, 55, 30, 25);
        modDamageField.setBorder(null);
        modDamageField.setFont(fontMedium);
        modDamageField.setBackground(Color.darkGray);
        modDamageField.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(modDamageField);

        typeDamageLabel = new JLabel("Type");
        typeDamageLabel.setFont(font);
        typeDamageLabel.setBounds(116, 42, 80, 13);
        typeDamageLabel.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(typeDamageLabel);
        typeDamageField = new JTextField(controller.loadAttacks(controller.getID()).getDamageType());
        typeDamageField.setBounds(116, 55, 57, 25);
        typeDamageField.setBorder(null);
        typeDamageField.setFont(fontMedium);
        typeDamageField.setBackground(Color.darkGray);
        typeDamageField.setForeground(Color.white);
        attacksAndSpellcastingPanel.add(typeDamageField);

        attacksAndSpellcastingArea = new JTextArea(controller.loadAttacks(controller.getID()).getAttacksAndSpellcasting());
        attacksAndSpellcastingArea.setBounds(2, 82, 171, 206);
        attacksAndSpellcastingArea.setBorder(null);
        attacksAndSpellcastingArea.setLineWrap(true);
        attacksAndSpellcastingArea.setWrapStyleWord(true);
        attacksAndSpellcastingArea.setFont(font);
        attacksAndSpellcastingArea.setForeground(Color.white);
        attacksAndSpellcastingArea.setBackground(Color.darkGray);
        attacksAndSpellcastingPanel.add(attacksAndSpellcastingArea);

        //Equipment
        equipmentPanel = new JPanel();
        equipmentPanel.setLayout(null);
        equipmentPanel.setBounds(220, 535, 275, 295);
        equipmentPanel.setBackground(Color.black);
        this.add(equipmentPanel);

        copperLabel = new JLabel("Copper Pieces");
        copperLabel.setFont(font);
        copperLabel.setBounds(2, 2, 80, 13);
        copperLabel.setForeground(Color.white);
        equipmentPanel.add(copperLabel);
        copperField = new JTextField(controller.loadEquipment(controller.getID()).getCopper());
        copperField.setBounds(2, 15, 80, 25);
        copperField.setBorder(null);
        copperField.setFont(fontMedium);
        copperField.setBackground(Color.darkGray);
        copperField.setForeground(Color.white);
        equipmentPanel.add(copperField);

        silverLabel = new JLabel("Silver Pieces");
        silverLabel.setFont(font);
        silverLabel.setBounds(90, 2, 80, 13);
        silverLabel.setForeground(Color.white);
        equipmentPanel.add(silverLabel);
        silverField = new JTextField(controller.loadEquipment(controller.getID()).getSilver());
        silverField.setBounds(90, 15, 80, 25);
        silverField.setBorder(null);
        silverField.setFont(fontMedium);
        silverField.setBackground(Color.darkGray);
        silverField.setForeground(Color.white);
        equipmentPanel.add(silverField);

        electrumLabel = new JLabel("Electrum Pieces");
        electrumLabel.setFont(font);
        electrumLabel.setBounds(178, 2, 80, 13);
        electrumLabel.setForeground(Color.white);
        equipmentPanel.add(electrumLabel);
        electrumField = new JTextField(controller.loadEquipment(controller.getID()).getElectrum());
        electrumField.setBounds(178, 15, 80, 25);
        electrumField.setBorder(null);
        electrumField.setFont(fontMedium);
        electrumField.setBackground(Color.darkGray);
        electrumField.setForeground(Color.white);
        equipmentPanel.add(electrumField);

        goldLabel = new JLabel("Gold Pieces");
        goldLabel.setFont(font);
        goldLabel.setBounds(2, 42, 80, 13);
        goldLabel.setForeground(Color.white);
        equipmentPanel.add(goldLabel);
        goldField = new JTextField(controller.loadEquipment(controller.getID()).getGold());
        goldField.setBounds(2, 55, 80, 25);
        goldField.setBorder(null);
        goldField.setFont(fontMedium);
        goldField.setBackground(Color.darkGray);
        goldField.setForeground(Color.white);
        equipmentPanel.add(goldField);

        platinumLabel = new JLabel("Platinum Pieces");
        platinumLabel.setFont(font);
        platinumLabel.setBounds(90, 42, 80, 13);
        platinumLabel.setForeground(Color.white);
        equipmentPanel.add(platinumLabel);
        platinumField = new JTextField(controller.loadEquipment(controller.getID()).getPlatinum());
        platinumField.setBounds(90, 55, 80, 25);
        platinumField.setBorder(null);
        platinumField.setFont(fontMedium);
        platinumField.setBackground(Color.darkGray);
        platinumField.setForeground(Color.white);
        equipmentPanel.add(platinumField);

        otherLabel = new JLabel("Other Currency");
        otherLabel.setFont(font);
        otherLabel.setBounds(178, 42, 80, 13);
        otherLabel.setForeground(Color.white);
        equipmentPanel.add(otherLabel);
        otherField = new JTextField(controller.loadEquipment(controller.getID()).getOtherCurrency());
        otherField.setBounds(178, 55, 80, 25);
        otherField.setBorder(null);
        otherField.setFont(fontMedium);
        otherField.setBackground(Color.darkGray);
        otherField.setForeground(Color.white);
        equipmentPanel.add(otherField);

        equipmentLabel = new JLabel("Equipment");
        equipmentLabel.setFont(font);
        equipmentLabel.setBounds(2, 82, 80, 13);
        equipmentLabel.setForeground(Color.white);
        equipmentPanel.add(equipmentLabel);
        equipmentArea = new JTextArea(controller.loadEquipment(controller.getID()).getEquipment());
        equipmentArea.setBounds(2, 98, 271, 192);
        equipmentArea.setBorder(null);
        equipmentArea.setLineWrap(true);
        equipmentArea.setWrapStyleWord(true);
        equipmentArea.setFont(font);
        equipmentArea.setForeground(Color.white);
        equipmentArea.setBackground(Color.darkGray);
        equipmentPanel.add(equipmentArea);

        //Personality
        personalityPanel = new JPanel();
        personalityPanel.setLayout(null);
        personalityPanel.setBounds(500, 175, 151, 655);
        personalityPanel.setBackground(Color.black);
        this.add(personalityPanel);

        personalityTraitsLabel = new JLabel("Personality Traits");
        personalityTraitsLabel.setFont(font);
        personalityTraitsLabel.setBounds(2, 2, 140, 13);
        personalityTraitsLabel.setForeground(Color.white);
        personalityPanel.add(personalityTraitsLabel);
        personalityTraitsArea = new JTextArea(controller.loadPersonality(controller.getID()).getPersonalityTraits());
        personalityTraitsArea.setBounds(2, 17, 147, 55);
        personalityTraitsArea.setBorder(null);
        personalityTraitsArea.setLineWrap(true);
        personalityTraitsArea.setWrapStyleWord(true);
        personalityTraitsArea.setFont(font);
        personalityTraitsArea.setForeground(Color.white);
        personalityTraitsArea.setBackground(Color.darkGray);
        personalityPanel.add(personalityTraitsArea);

        idealsLabel = new JLabel("Ideals");
        idealsLabel.setFont(font);
        idealsLabel.setBounds(2, 74, 140, 13);
        idealsLabel.setForeground(Color.white);
        personalityPanel.add(idealsLabel);
        idealsArea = new JTextArea(controller.loadPersonality(controller.getID()).getIdeals());
        idealsArea.setBounds(2, 89, 147, 50);
        idealsArea.setBorder(null);
        idealsArea.setLineWrap(true);
        idealsArea.setWrapStyleWord(true);
        idealsArea.setFont(font);
        idealsArea.setForeground(Color.white);
        idealsArea.setBackground(Color.darkGray);
        personalityPanel.add(idealsArea);

        bondsLabel = new JLabel("Bonds");
        bondsLabel.setFont(font);
        bondsLabel.setBounds(2, 141, 140, 13);
        bondsLabel.setForeground(Color.white);
        personalityPanel.add(bondsLabel);
        bondsArea = new JTextArea(controller.loadPersonality(controller.getID()).getBonds());
        bondsArea.setBounds(2, 156, 147, 50);
        bondsArea.setBorder(null);
        bondsArea.setLineWrap(true);
        bondsArea.setWrapStyleWord(true);
        bondsArea.setFont(font);
        bondsArea.setForeground(Color.white);
        bondsArea.setBackground(Color.darkGray);
        personalityPanel.add(bondsArea);

        flawsLabel = new JLabel("Flaws");
        flawsLabel.setFont(font);
        flawsLabel.setBounds(2, 208, 140, 13);
        flawsLabel.setForeground(Color.white);
        personalityPanel.add(flawsLabel);
        flawsArea = new JTextArea(controller.loadPersonality(controller.getID()).getFlaws());
        flawsArea.setBounds(2, 223, 147, 50);
        flawsArea.setBorder(null);
        flawsArea.setLineWrap(true);
        flawsArea.setWrapStyleWord(true);
        flawsArea.setFont(font);
        flawsArea.setForeground(Color.white);
        flawsArea.setBackground(Color.darkGray);
        personalityPanel.add(flawsArea);

        featuresAndTraitsLabel = new JLabel("Features And Traits");
        featuresAndTraitsLabel.setFont(font);
        featuresAndTraitsLabel.setBounds(2, 275, 140, 13);
        featuresAndTraitsLabel.setForeground(Color.white);
        personalityPanel.add(featuresAndTraitsLabel);
        featuresAndTraitsArea = new JTextArea(controller.loadPersonality(controller.getID()).getFeaturesAndTriats());
        featuresAndTraitsArea.setBounds(2, 290, 147, 335);
        featuresAndTraitsArea.setBorder(null);
        featuresAndTraitsArea.setLineWrap(true);
        featuresAndTraitsArea.setWrapStyleWord(true);
        featuresAndTraitsArea.setFont(font);
        featuresAndTraitsArea.setForeground(Color.white);
        featuresAndTraitsArea.setBackground(Color.darkGray);
        personalityPanel.add(featuresAndTraitsArea);

        saveButton = new JButton("Save");
        saveButton.setBounds(4, 630, 69, 20);
        saveButton.addActionListener(this);
        personalityPanel.add(saveButton);

        loadButton = new JButton("Load");
        loadButton.setBounds(75, 630, 69, 20);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            LoadView lv = new LoadView(controller);
            lv.setVisible(true);
            }
        });
        personalityPanel.add(loadButton);

        //Set Frame Visible
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        controller.saveTopBanner(
                characterNameField.getText(), classField.getText(), levelField.getText(), backgroundField.getText(), playerNameField.getText(),
                raceField.getText(), alignmentField.getText(), experienceField.getText()
        );
        controller.saveAbilities(
                characterNameField.getText(), strField.getText(), dexField.getText(), conField.getText(), intField.getText(), wisField.getText(),
                chaField.getText()
        );
        controller.saveSkills(
                characterNameField.getText(), inspirationField.getText(), strStProf.isSelected(), dexStProf.isSelected(), conStProf.isSelected(),
                intStProf.isSelected(), wisStProf.isSelected(), chaStProf.isSelected(), acrobaticsProf.isSelected(), animalHandlingProf.isSelected(),
                arcanaProf.isSelected(), athleticsProf.isSelected(), deceptionProf.isSelected(), historyProf.isSelected(), insightProf.isSelected(),
                intimidationProf.isSelected(), investigationProf.isSelected(), medicineProf.isSelected(), natureProf.isSelected(), perceptionProf.isSelected(),
                performanceProf.isSelected(), persuasionProf.isSelected(), religionProf.isSelected(), sleightOfHandProf.isSelected(), stealthProf.isSelected(),
                survivalProf.isSelected(), acrobaticsExpert.isSelected(), animalHandlingExpert.isSelected(),
                arcanaExpert.isSelected(), athleticsExpert.isSelected(), deceptionExpert.isSelected(), historyExpert.isSelected(), insightExpert.isSelected(),
                intimidationExpert.isSelected(), investigationExpert.isSelected(), medicineExpert.isSelected(), natureExpert.isSelected(), perceptionExpert.isSelected(),
                performanceExpert.isSelected(), persuasionExpert.isSelected(), religionExpert.isSelected(), sleightOfHandExpert.isSelected(), stealthExpert.isSelected(),
                survivalExpert.isSelected()
        );
        controller.saveHealthSection(
                characterNameField.getText(), ACField.getText(), initiativeField.getText(), speedField.getText(), HPMaxField.getText(),
                HPCurrentField.getText(), HPTempField.getText(), hitDiceField.getText(), deathSaveSuccessOne.isSelected(), deathSaveSuccessTwo.isSelected(),
                deathSaveSuccessThree.isSelected(), deathSaveFailOne.isSelected(), deathSaveFailTwo.isSelected(), deathSaveFailThree.isSelected()
        );
        controller.saveProfAndLang(
                characterNameField.getText(), profAndLangArea.getText()
        );
        controller.saveAttackAndSpell(
                characterNameField.getText(), attackNameField.getText(), attackModField.getText(), baseDamageField.getText(), modDamageField.getText(),
                typeDamageField.getText(), rangeDamageField.getText(), attacksAndSpellcastingArea.getText()
        );
        controller.saveEquipment(
                characterNameField.getText(), equipmentArea.getText(), copperField.getText(), silverField.getText(), electrumField.getText(),
                goldField.getText(), platinumField.getText(), otherField.getText()
        );
        controller.savePersonality(
                characterNameField.getText(), personalityTraitsArea.getText(), idealsArea.getText(), bondsArea.getText(), flawsArea.getText(),
                featuresAndTraitsArea.getText()
        );
    }
}