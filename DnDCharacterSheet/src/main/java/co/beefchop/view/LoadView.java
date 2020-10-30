package co.beefchop.view;

import co.beefchop.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadView extends JFrame implements ActionListener {
    private Controller controller;

    private JPanel loadCharacter;

    private JLabel slot1id, slot1name, slot2id, slot2name, slot3id, slot3name, slot4id, slot4name, slot5id, slot5name, slot6id, slot6name,
            slot7id, slot7name, slot8id, slot8name, slot9id, slot9name, slot10id, slot10name, slot11id, slot11name, slot12id, slot12name,
            slot13id, slot13name, slot14id, slot14name, slot15id, slot15name, slot16id, slot16name, slot17id, slot17name, slot18id, slot18name,
            slot19id, slot19name, selectIDLabel;

    private JTextField selectIDField;

    private JButton load;

    private Font fontMedium = new Font("Times New Roman", Font.PLAIN, 15);

    //Layout
    private GridBagLayout loadLayout = new GridBagLayout();
    private GridBagConstraints loadConstraints = new GridBagConstraints();

    public LoadView(Controller c) {
        super ("Load Character");
        this.controller = c;

        //Frame
        this.setLayout(null);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Load Panel
        loadCharacter = new JPanel();
        loadCharacter.setLayout(loadLayout);
        loadCharacter.setBounds(5, 5, 475, 445);
        loadCharacter.setBackground(Color.black);
        this.add(loadCharacter);

        //Slot labels
        slot1id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(1)))), slot1id.CENTER);
        slot1id.setSize(100, 13);
        slot1id.setFont(fontMedium);
        slot1id.setForeground(Color.green);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 0;
        loadConstraints.ipadx = 20;
        loadConstraints.ipady = 20;
        loadCharacter.add(slot1id, loadConstraints);

        slot1name = new JLabel(controller.loadCharacters(controller.idDecider(1)));
        slot1name.setSize(100, 13);
        slot1name.setFont(fontMedium);
        slot1name.setForeground(Color.green);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 0;
        loadCharacter.add(slot1name, loadConstraints);

        slot2id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(2)))), slot2id.CENTER);
        slot2id.setSize(100, 13);
        slot2id.setFont(fontMedium);
        slot2id.setForeground(Color.white);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 0;
        loadCharacter.add(slot2id, loadConstraints);

        slot2name = new JLabel(controller.loadCharacters(controller.idDecider(2)));
        slot2name.setSize(100, 13);
        slot2name.setFont(fontMedium);
        slot2name.setForeground(Color.white);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 0;
        loadCharacter.add(slot2name, loadConstraints);

        slot3id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(3)))), slot3id.CENTER);
        slot3id.setSize(100, 13);
        slot3id.setFont(fontMedium);
        slot3id.setForeground(Color.white);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 1;
        loadCharacter.add(slot3id, loadConstraints);

        slot3name = new JLabel(controller.loadCharacters(controller.idDecider(3)));
        slot3name.setSize(100, 13);
        slot3name.setFont(fontMedium);
        slot3name.setForeground(Color.white);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 1;
        loadCharacter.add(slot3name, loadConstraints);

        slot4id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(4)))), slot4id.CENTER);
        slot4id.setSize(100, 13);
        slot4id.setFont(fontMedium);
        slot4id.setForeground(Color.green);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 1;
        loadCharacter.add(slot4id, loadConstraints);

        slot4name = new JLabel(controller.loadCharacters(controller.idDecider(4)));
        slot4name.setSize(100, 13);
        slot4name.setFont(fontMedium);
        slot4name.setForeground(Color.green);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 1;
        loadCharacter.add(slot4name, loadConstraints);

        slot5id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(5)))), slot5id.CENTER);
        slot5id.setSize(100, 13);
        slot5id.setFont(fontMedium);
        slot5id.setForeground(Color.green);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 2;
        loadCharacter.add(slot5id, loadConstraints);

        slot5name = new JLabel(controller.loadCharacters(controller.idDecider(5)));
        slot5name.setSize(100, 13);
        slot5name.setFont(fontMedium);
        slot5name.setForeground(Color.green);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 2;
        loadCharacter.add(slot5name, loadConstraints);

        slot6id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(6)))), slot6id.CENTER);
        slot6id.setSize(100, 13);
        slot6id.setFont(fontMedium);
        slot6id.setForeground(Color.white);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 2;
        loadCharacter.add(slot6id, loadConstraints);

        slot6name = new JLabel(controller.loadCharacters(controller.idDecider(6)));
        slot6name.setSize(100, 13);
        slot6name.setFont(fontMedium);
        slot6name.setForeground(Color.white);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 2;
        loadCharacter.add(slot6name, loadConstraints);

        slot7id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(7)))), slot7id.CENTER);
        slot7id.setSize(100, 13);
        slot7id.setFont(fontMedium);
        slot7id.setForeground(Color.white);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 3;
        loadCharacter.add(slot7id, loadConstraints);

        slot7name = new JLabel(controller.loadCharacters(controller.idDecider(7)));
        slot7name.setSize(100, 13);
        slot7name.setFont(fontMedium);
        slot7name.setForeground(Color.white);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 3;
        loadCharacter.add(slot7name, loadConstraints);

        slot8id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(8)))), slot8id.CENTER);
        slot8id.setSize(100, 13);
        slot8id.setFont(fontMedium);
        slot8id.setForeground(Color.green);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 3;
        loadCharacter.add(slot8id, loadConstraints);

        slot8name = new JLabel(controller.loadCharacters(controller.idDecider(8)));
        slot8name.setSize(100, 13);
        slot8name.setFont(fontMedium);
        slot8name.setForeground(Color.green);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 3;
        loadCharacter.add(slot8name, loadConstraints);

        slot9id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(9)))), slot9id.CENTER);
        slot9id.setSize(100, 13);
        slot9id.setFont(fontMedium);
        slot9id.setForeground(Color.green);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 4;
        loadCharacter.add(slot9id, loadConstraints);

        slot9name = new JLabel(controller.loadCharacters(controller.idDecider(9)));
        slot9name.setSize(100, 13);
        slot9name.setFont(fontMedium);
        slot9name.setForeground(Color.green);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 4;
        loadCharacter.add(slot9name, loadConstraints);

        slot10id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(10)))), slot10id.CENTER);
        slot10id.setSize(100, 13);
        slot10id.setFont(fontMedium);
        slot10id.setForeground(Color.white);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 4;
        loadCharacter.add(slot10id, loadConstraints);

        slot10name = new JLabel(controller.loadCharacters(controller.idDecider(10)));
        slot10name.setSize(100, 13);
        slot10name.setFont(fontMedium);
        slot10name.setForeground(Color.white);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 4;
        loadCharacter.add(slot10name, loadConstraints);

        slot11id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(11)))), slot11id.CENTER);
        slot11id.setSize(100, 13);
        slot11id.setFont(fontMedium);
        slot11id.setForeground(Color.white);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 5;
        loadCharacter.add(slot11id, loadConstraints);

        slot11name = new JLabel(controller.loadCharacters(controller.idDecider(11)));
        slot11name.setSize(100, 13);
        slot11name.setFont(fontMedium);
        slot11name.setForeground(Color.white);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 5;
        loadCharacter.add(slot11name, loadConstraints);

        slot12id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(12)))), slot12id.CENTER);
        slot12id.setSize(100, 13);
        slot12id.setFont(fontMedium);
        slot12id.setForeground(Color.green);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 5;
        loadCharacter.add(slot12id, loadConstraints);

        slot12name = new JLabel(controller.loadCharacters(controller.idDecider(12)));
        slot12name.setSize(100, 13);
        slot12name.setFont(fontMedium);
        slot12name.setForeground(Color.green);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 5;
        loadCharacter.add(slot12name, loadConstraints);

        slot13id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(13)))), slot13id.CENTER);
        slot13id.setSize(100, 13);
        slot13id.setFont(fontMedium);
        slot13id.setForeground(Color.green);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 6;
        loadCharacter.add(slot13id, loadConstraints);

        slot13name = new JLabel(controller.loadCharacters(controller.idDecider(13)));
        slot13name.setSize(100, 13);
        slot13name.setFont(fontMedium);
        slot13name.setForeground(Color.green);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 6;
        loadCharacter.add(slot13name, loadConstraints);

        slot14id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(14)))), slot14id.CENTER);
        slot14id.setSize(100, 13);
        slot14id.setFont(fontMedium);
        slot14id.setForeground(Color.white);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 6;
        loadCharacter.add(slot14id, loadConstraints);

        slot14name = new JLabel(controller.loadCharacters(controller.idDecider(14)));
        slot14name.setSize(100, 13);
        slot14name.setFont(fontMedium);
        slot14name.setForeground(Color.white);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 6;
        loadCharacter.add(slot14name, loadConstraints);

        slot15id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(15)))), slot15id.CENTER);
        slot15id.setSize(100, 13);
        slot15id.setFont(fontMedium);
        slot15id.setForeground(Color.white);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 7;
        loadCharacter.add(slot15id, loadConstraints);

        slot15name = new JLabel(controller.loadCharacters(controller.idDecider(15)));
        slot15name.setSize(100, 13);
        slot15name.setFont(fontMedium);
        slot15name.setForeground(Color.white);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 7;
        loadCharacter.add(slot15name, loadConstraints);

        slot16id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(16)))), slot16id.CENTER);
        slot16id.setSize(100, 13);
        slot16id.setFont(fontMedium);
        slot16id.setForeground(Color.green);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 7;
        loadCharacter.add(slot16id, loadConstraints);

        slot16name = new JLabel(controller.loadCharacters(controller.idDecider(16)));
        slot16name.setSize(100, 13);
        slot16name.setFont(fontMedium);
        slot16name.setForeground(Color.green);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 7;
        loadCharacter.add(slot16name, loadConstraints);

        slot17id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(17)))), slot17id.CENTER);
        slot17id.setSize(100, 13);
        slot17id.setFont(fontMedium);
        slot17id.setForeground(Color.green);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 8;
        loadCharacter.add(slot17id, loadConstraints);

        slot17name = new JLabel(controller.loadCharacters(controller.idDecider(17)));
        slot17name.setSize(100, 13);
        slot17name.setFont(fontMedium);
        slot17name.setForeground(Color.green);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 8;
        loadCharacter.add(slot17name, loadConstraints);

        slot18id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(18)))), slot18id.CENTER);
        slot18id.setSize(100, 13);
        slot18id.setFont(fontMedium);
        slot18id.setForeground(Color.white);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 8;
        loadCharacter.add(slot18id, loadConstraints);

        slot18name = new JLabel(controller.loadCharacters(controller.idDecider(18)));
        slot18name.setSize(100, 13);
        slot18name.setFont(fontMedium);
        slot18name.setForeground(Color.white);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 8;
        loadCharacter.add(slot18name, loadConstraints);

        slot19id = new JLabel(Integer.toString(controller.getId(controller.loadCharacters(controller.idDecider(19)))), slot19id.CENTER);
        slot19id.setSize(100, 13);
        slot19id.setFont(fontMedium);
        slot19id.setForeground(Color.white);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 9;
        loadCharacter.add(slot19id, loadConstraints);

        slot19name = new JLabel(controller.loadCharacters(controller.idDecider(19)));
        slot19name.setSize(100, 13);
        slot19name.setFont(fontMedium);
        slot19name.setForeground(Color.white);
        loadConstraints.gridx = 1;
        loadConstraints.gridy = 9;
        loadCharacter.add(slot19name, loadConstraints);

        selectIDLabel = new JLabel("Type Character ID:");
        selectIDLabel.setSize(100, 13);
        selectIDLabel.setFont(fontMedium);
        selectIDLabel.setForeground(Color.white);
        loadConstraints.gridx = 2;
        loadConstraints.gridy = 9;
        loadCharacter.add(selectIDLabel, loadConstraints);

        selectIDField = new JTextField();
        selectIDField.setSize(100, 13);
        selectIDField.setFont(fontMedium);
        selectIDField.setBackground(Color.darkGray);
        selectIDField.setForeground(Color.white);
        selectIDField.setBorder(null);
        loadConstraints.gridx = 3;
        loadConstraints.gridy = 9;
        loadCharacter.add(selectIDField, loadConstraints);

        load = new JButton("Load");
        load.addActionListener(this);
        loadConstraints.gridx = 0;
        loadConstraints.gridy = 10;
        loadCharacter.add(load, loadConstraints);

        //set frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.setID(Integer.parseInt(selectIDField.getText()));
        View view = new View(controller);
        view.setVisible(true);
    }
}