import com.github.cliftonlabs.json_simple.JsonException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class main {
    private static int bigDate;
    private static ArrayList<String> stateArray;
    private static SelectRecords select;
    private static TreeMap<Integer, ArrayList<String>> map;
    private static int sum;

    public static void main(String[] args) throws SQLException, IOException, JsonException {
        bigDate = 20200201;
        stateArray = new ArrayList<String>();
        Collections.addAll(stateArray, "AK - Alaska",
                "AL - Alabama",
                "AR - Arkansas",
                "AZ - Arizona",
                "CA - California",
                "CO - Colorado",
                "CT - Connecticut",
                "DE - Delaware",
                "FL - Florida",
                "GA - Georgia",
                "HI - Hawaii",
                "IA - Iowa",
                "ID - Idaho",
                "IL - Illinois",
                "IN - Indiana",
                "KS - Kansas",
                "KY - Kentucky",
                "LA - Louisiana",
                "MA - Massachusetts",
                "MD - Maryland",
                "ME - Maine",
                "MI - Michigan",
                "MN - Minnesota",
                "MO - Missouri",
                "MS - Mississippi",
                "MT - Montana",
                "NC - North Carolina",
                "ND - North Dakota",
                "NE - Nebraska",
                "NH - New Hampshire",
                "NJ - New Jersey",
                "NM - New Mexico",
                "NV - Nevada",
                "NY - New York",
                "OH - Ohio",
                "OK - Oklahoma",
                "OR - Oregon",
                "PA - Pennsylvania",
                "RI - Rhode Island",
                "SC - South Carolina",
                "SD - South Dakota",
                "TN - Tennessee",
                "TX - Texas",
                "UT - Utah",
                "VA - Virginia",
                "VT - Vermont",
                "WA - Washington",
                "WI - Wisconsin",
                "WV - West Virginia",
                "WY - Wyoming");


        CreateDatabase create = new CreateDatabase();
        create.createNewDatabase();
        CreateTable table = new CreateTable();
        table.createNewTable();
        InsertRecords insert = new InsertRecords();
        insert.insertAllData();
        select = new SelectRecords();
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(1450, 813));
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(1050, 694));
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300, 694));
        JSlider slider = new JSlider(0, 115, 0);
        JLabel day = new JLabel("Feburary 1 2020");
      /*
      ImageIcon icon = new ImageIcon("USMap.jpg");
      try{
         resize("USMap.jpg", "resizedMap.jpg", 1050, 694);//orignally (1500, 991), scale factor .7
      }
      catch (IOException ex) {
         System.out.println("Error resizing the image.");
      }
      */
        ImageIcon resizedIcon = new ImageIcon("resizedMap.jpg");
        JLabel label = new JLabel(resizedIcon);
        frame.setLayout(new FlowLayout());
        label.setLayout(new GridBagLayout());
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel northEast = new JPanel();
        northEast.setPreferredSize(new Dimension(1050, 694));
        ImageIcon NEicon = new ImageIcon("resizedNorthEastern.png");//original size(224, 227), new size(672, 681), scale factor 3
        JLabel NElabel = new JLabel(NEicon);
        northEast.add(NElabel);
        NElabel.setLayout(new GridBagLayout());
        GridBagConstraints NEgbc = new GridBagConstraints();

        ResearchPanel research = new ResearchPanel();
        statePanel state = new statePanel();
        rankingsPanel rank = new rankingsPanel();
        GridBagConstraints gbcRank = new GridBagConstraints();
        int[] array = getCasesArray(20200201);
        sort(array, 0, array.length - 1);
        for (int i = 1; i < 51; i++) {
            if (i < 26) {
                gbcRank.gridy = i - 1;
                gbcRank.gridx = 0;
                rank.add(new JLabel(i + ": " + map.get(array[array.length - i]).remove(0) + "(" + array[array.length - i] + ")"), gbcRank);
            } else {
                gbcRank.gridy = i - 26;
                gbcRank.gridx = 2;
                gbcRank.insets = new Insets(0, 50, 0, 0);
                rank.add(new JLabel(i + ": " + map.get(array[array.length - i]).remove(0) + "(" + array[array.length - i] + ")"), gbcRank);
            }
        }
        gbcRank.gridy = 25;
        gbcRank.gridx = 1;
        rank.add(new JLabel("Total US States Positive Cases: " + sum), gbcRank);


        JButton BACK = new JButton("BACK");
        BACK.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 0;
        BACK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(true);
                northEast.setVisible(false);
            }
        });
        NElabel.add(BACK, NEgbc);


        JLabel null1 = new JLabel("");
        null1.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 1;
        NElabel.add(null1, NEgbc);

        JLabel null2 = new JLabel("");
        null2.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 2;
        NElabel.add(null2, NEgbc);

        JLabel null3 = new JLabel("");
        null3.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 3;
        NElabel.add(null3, NEgbc);

        JLabel null4 = new JLabel("");
        null4.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 4;
        NElabel.add(null4, NEgbc);

        JLabel null5 = new JLabel("");
        null5.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 5;
        NElabel.add(null5, NEgbc);

        JLabel null6 = new JLabel("");
        null6.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 6;
        NElabel.add(null6, NEgbc);

        JLabel null7 = new JLabel("");
        null7.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 7;
        NElabel.add(null7, NEgbc);

        JLabel null8 = new JLabel("");
        null8.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 8;
        NElabel.add(null8, NEgbc);

        JLabel null9 = new JLabel("");
        null9.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 9;
        NElabel.add(null9, NEgbc);

        JLabel null10 = new JLabel("");
        null10.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 10;
        NElabel.add(null10, NEgbc);

        JLabel null11 = new JLabel("");
        null11.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 11;
        NElabel.add(null11, NEgbc);

        JLabel null12 = new JLabel("");
        null12.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 0;
        NEgbc.gridy = 12;
        NElabel.add(null12, NEgbc);


        JLabel null13 = new JLabel("");
        null13.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 1;
        NEgbc.gridy = 0;
        NElabel.add(null13, NEgbc);


        JLabel null14 = new JLabel("");
        null14.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 2;
        NEgbc.gridy = 0;
        NElabel.add(null14, NEgbc);

        JLabel null15 = new JLabel("");
        null15.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 3;
        NEgbc.gridy = 0;
        NElabel.add(null15, NEgbc);

        JLabel null16 = new JLabel("");
        null16.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 4;
        NEgbc.gridy = 0;
        NElabel.add(null16, NEgbc);

        JLabel null17 = new JLabel("");
        null17.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 5;
        NEgbc.gridy = 0;
        NElabel.add(null17, NEgbc);


        JLabel null18 = new JLabel("");
        null18.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 6;
        NEgbc.gridy = 0;
        NElabel.add(null18, NEgbc);

        JLabel null19 = new JLabel("");
        null19.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 7;
        NEgbc.gridy = 0;
        NElabel.add(null19, NEgbc);

        JLabel null20 = new JLabel("");
        null20.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 8;
        NEgbc.gridy = 0;
        NElabel.add(null20, NEgbc);


        JButton PA = new JButton("PA");
        PA.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 1;
        NEgbc.gridy = 9;
        PA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Pennslyvania");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "PA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "PA"));
                state.setStateAb("PA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "PA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "PA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "PA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "PA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }


            }
        });
        NElabel.add(PA, NEgbc);


        NEgbc.anchor = GridBagConstraints.LINE_START;
        JButton MD = new JButton("MD");
        MD.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 2;
        NEgbc.gridy = 11;
        MD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Maryland");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "MD"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "MD"));
                state.setStateAb("MD");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "MD"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "MD"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "MD"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "MD"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(MD, NEgbc);

        NEgbc.anchor = GridBagConstraints.LINE_START;
        JButton DE = new JButton("DE");
        DE.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 3;
        NEgbc.gridy = 11;
        DE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Delaware");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "DE"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "DE"));
                state.setStateAb("DE");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "DE"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "DE"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "DE"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "DE"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(DE, NEgbc);


        JButton NY = new JButton("NY");
        NY.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 3;
        NEgbc.gridy = 6;
        NY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("New York");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "NY"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "NY"));
                state.setStateAb("NY");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "NY"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "NY"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "NY"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "NY"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(NY, NEgbc);


        JButton ME = new JButton("ME");
        ME.setPreferredSize(new Dimension(50, 50));
        NEgbc.gridx = 8;
        NEgbc.gridy = 2;
        ME.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Maine");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "ME"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "ME"));
                state.setStateAb("ME");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "ME"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "ME"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "ME"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "ME"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(ME, NEgbc);

        NEgbc.anchor = GridBagConstraints.FIRST_LINE_END;
        JButton VT = new JButton("VT");
        VT.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 5;
        NEgbc.gridy = 4;
        VT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Vermont");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "VT"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "VT"));
                state.setStateAb("VT");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "VT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "VT"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "VT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "VT"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(VT, NEgbc);


        JButton NH = new JButton("NH");
        NH.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 6;
        NEgbc.gridy = 5;
        NH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("New Hampshire");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "NH"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "NH"));
                state.setStateAb("NH");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "NH"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "NH"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "NH"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "NH"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(NH, NEgbc);

        NEgbc.anchor = GridBagConstraints.LAST_LINE_END;
        JButton MA = new JButton("MA");
        MA.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 6;
        NEgbc.gridy = 6;
        MA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Massachusetts");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "MA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "MA"));
                state.setStateAb("MA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "MA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "MA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "MA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "MA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(MA, NEgbc);

        NEgbc.anchor = GridBagConstraints.LAST_LINE_START;
        JButton CT = new JButton("CT");
        CT.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 6;
        NEgbc.gridy = 7;
        CT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Connecticut");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "CT"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "CT"));
                state.setStateAb("CT");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "CT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "CT"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "CT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "CT"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(CT, NEgbc);


        JButton RI = new JButton("RI");
        RI.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 7;
        NEgbc.gridy = 7;
        RI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Rhode Island");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "RI"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "RI"));
                state.setStateAb("RI");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "RI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "RI"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "RI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "RI"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(RI, NEgbc);


        JButton NJ = new JButton("NJ");
        NJ.setPreferredSize(new Dimension(30, 30));
        NEgbc.gridx = 4;
        NEgbc.gridy = 9;
        NJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                northEast.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("New Jersey");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "NJ"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "NJ"));
                state.setStateAb("NJ");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "NJ"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "NJ"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "NJ"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "NJ"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        NElabel.add(NJ, NEgbc);

        JLabel state1 = new JLabel("");
        state1.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        label.add(state1, gbc);
        JLabel state2 = new JLabel("");
        state2.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 1;
        label.add(state2, gbc);
        JLabel state3 = new JLabel("");
        state3.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        label.add(state3, gbc);
        JLabel state4 = new JLabel("");
        state4.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 3;
        label.add(state4, gbc);
        JLabel state5 = new JLabel("");
        state5.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 4;
        label.add(state5, gbc);
        JLabel state6 = new JLabel("");
        state6.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 5;
        label.add(state6, gbc);
        JLabel state7 = new JLabel("");
        state7.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 6;
        label.add(state7, gbc);
        JLabel state8 = new JLabel("");
        state8.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 7;
        label.add(state8, gbc);
        JLabel state9 = new JLabel("");
        state9.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 8;
        label.add(state9, gbc);
        JLabel state10 = new JLabel("");
        state10.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 9;
        label.add(state10, gbc);
        JLabel state11 = new JLabel("");
        state11.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 10;
        label.add(state11, gbc);
        JLabel state12 = new JLabel("");
        state12.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 11;
        label.add(state12, gbc);
        JLabel state13 = new JLabel("");
        state13.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 0;
        gbc.gridy = 12;
        label.add(state13, gbc);
        JLabel state14 = new JLabel("");
        state14.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 1;
        gbc.gridy = 0;
        label.add(state14, gbc);
        JLabel state15 = new JLabel("");
        state15.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 2;
        gbc.gridy = 0;
        label.add(state15, gbc);
        JLabel state16 = new JLabel("");
        state16.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 3;
        gbc.gridy = 0;
        label.add(state16, gbc);
        JLabel state17 = new JLabel("");
        state17.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 4;
        gbc.gridy = 0;
        label.add(state17, gbc);
        JLabel state18 = new JLabel("");
        state18.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 5;
        gbc.gridy = 0;
        label.add(state18, gbc);
        JLabel state19 = new JLabel("");
        state19.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 6;
        gbc.gridy = 0;
        label.add(state19, gbc);
        JLabel state20 = new JLabel("");
        state20.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 7;
        gbc.gridy = 0;
        label.add(state20, gbc);
        JLabel state21 = new JLabel("");
        state21.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 8;
        gbc.gridy = 0;
        label.add(state21, gbc);
        JLabel state22 = new JLabel("");
        state22.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 9;
        gbc.gridy = 0;
        label.add(state22, gbc);
        JLabel state23 = new JLabel("");
        state23.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 10;
        gbc.gridy = 0;
        label.add(state23, gbc);
        JLabel state24 = new JLabel("");
        state24.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 11;
        gbc.gridy = 0;
        label.add(state24, gbc);
        JLabel state25 = new JLabel("");
        state25.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 12;
        gbc.gridy = 0;
        label.add(state25, gbc);
        JLabel state26 = new JLabel("");
        state26.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 13;
        gbc.gridy = 0;
        label.add(state26, gbc);
        JLabel state27 = new JLabel("");
        state27.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 14;
        gbc.gridy = 0;
        label.add(state27, gbc);
        JLabel state28 = new JLabel("");
        state28.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 15;
        gbc.gridy = 0;
        label.add(state28, gbc);
        JLabel state29 = new JLabel("");
        state29.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 16;
        gbc.gridy = 0;
        label.add(state29, gbc);
        JLabel state30 = new JLabel("");
        state30.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 17;
        gbc.gridy = 0;
        label.add(state30, gbc);
        JLabel state31 = new JLabel("");
        state31.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 18;
        gbc.gridy = 0;
        label.add(state31, gbc);
        JLabel state32 = new JLabel("");
        state32.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 19;
        gbc.gridy = 0;
        label.add(state32, gbc);


        JButton ND = new JButton("ND");
        ND.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 8;
        gbc.gridy = 1;
        ND.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("North Dakota");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "ND"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "ND"));
                state.setStateAb("ND");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "ND"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "ND"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "ND"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "ND"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(ND, gbc);

        gbc.insets = new Insets(40, 0, 0, 0);

        JButton SD = new JButton("SD");
        SD.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 8;
        gbc.gridy = 2;
        SD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("South Dakota");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "SD"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "SD"));
                state.setStateAb("SD");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "SD"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "SD"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "SD"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "SD"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(SD, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;

        JButton NE = new JButton("NE");
        NE.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 8;
        gbc.gridy = 4;
        NE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Nebraska");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "NE"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "NE"));
                state.setStateAb("NE");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "NE"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "NE"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "NE"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "NE"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(NE, gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(30, 0, 0, 0);

        JButton KS = new JButton("KS");
        KS.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 9;
        gbc.gridy = 5;
        KS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Kansas");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "KS"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "KS"));
                state.setStateAb("KS");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "KS"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "KS"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "KS"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "KS"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(KS, gbc);


        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;

        JButton OK = new JButton("OK");
        OK.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 9;
        gbc.gridy = 7;
        OK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Oklahoma");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "OK"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "OK"));
                state.setStateAb("OK");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "OK"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "OK"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "OK"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "OK"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(OK, gbc);

        JButton TX = new JButton("TX");
        TX.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 9;
        gbc.gridy = 9;
        TX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Texas");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "TX"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "TX"));
                state.setStateAb("TX");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "TX"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "TX"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "TX"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "TX"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(TX, gbc);

        JButton MT = new JButton("MT");
        MT.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 5;
        gbc.gridy = 1;
        MT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Montana");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "MT"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "MT"));
                state.setStateAb("MT");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "MT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "MT"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "MT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "MT"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(MT, gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        JButton WY = new JButton("WY");
        WY.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 6;
        gbc.gridy = 3;
        WY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Wyoming");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "WY"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "WY"));
                state.setStateAb("WY");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "WY"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "WY"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "WY"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "WY"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(WY, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        JButton CO = new JButton("CO");
        CO.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 6;
        gbc.gridy = 5;
        CO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Colorado");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "CO"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "CO"));
                state.setStateAb("CO");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "CO"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "CO"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "CO"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "CO"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(CO, gbc);


        gbc.anchor = GridBagConstraints.LINE_START;
        JButton NM = new JButton("NM");
        NM.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 6;
        gbc.gridy = 7;
        NM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("New Mexico");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "NM"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "NM"));
                state.setStateAb("NM");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "NM"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "NM"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "NM"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "NM"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(NM, gbc);


        gbc.anchor = GridBagConstraints.LINE_END;
        JButton MN = new JButton("MN");
        MN.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 10;
        gbc.gridy = 2;
        MN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Minnesota");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "MN"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "MN"));
                state.setStateAb("MN");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "MN"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "MN"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "MN"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "MN"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(MN, gbc);


        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        JButton IA = new JButton("IA");
        IA.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 11;
        gbc.gridy = 4;
        IA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Iowa");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "IA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "IA"));
                state.setStateAb("IA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "IA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "IA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "IA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "IA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(IA, gbc);


        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        JButton MO = new JButton("MO");
        MO.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 11;
        gbc.gridy = 5;
        MO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Missouri");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "MO"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "MO"));
                state.setStateAb("MO");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "MO"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "MO"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "MO"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "MO"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(MO, gbc);


        JButton AR = new JButton("AR");
        AR.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 11;
        gbc.gridy = 7;
        AR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Arizona");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "AR"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "AR"));
                state.setStateAb("AR");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "AR"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "AR"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "AR"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "AR"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(AR, gbc);


        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        JButton LA = new JButton("LA");
        LA.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 11;
        gbc.gridy = 9;
        LA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Louisiana");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "LA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "LA"));
                state.setStateAb("LA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "LA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "LA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "LA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "LA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(LA, gbc);


        JButton AK = new JButton("AK");
        AK.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 2;
        gbc.gridy = 10;
        AK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Alaska");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "AK"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "AK"));
                state.setStateAb("AK");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "AK"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "AK"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "AK"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "AK"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(AK, gbc);


        JButton HI = new JButton("HI");
        HI.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 6;
        gbc.gridy = 11;
        HI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Hawaii");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "HI"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "HI"));
                state.setStateAb("HI");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "HI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "HI"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "HI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "HI"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(HI, gbc);


        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        JButton ID = new JButton("ID");
        ID.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 3;
        gbc.gridy = 2;
        ID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Idaho");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "ID"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "ID"));
                state.setStateAb("ID");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "ID"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "ID"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "ID"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "ID"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(ID, gbc);


        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        JButton NV = new JButton("NV");
        NV.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 2;
        gbc.gridy = 4;
        NV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Nevada");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "NV"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "NV"));
                state.setStateAb("NV");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "NV"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "NV"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "NV"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "NV"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(NV, gbc);

        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        JButton CA = new JButton("CA");
        CA.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        CA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("California");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "CA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "CA"));
                state.setStateAb("CA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "CA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "CA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "CA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "CA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(CA, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        JButton OR = new JButton("OR");
        OR.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        OR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Oregon");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "OR"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "OR"));
                state.setStateAb("OR");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "OR"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "OR"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "OR"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "OR"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(OR, gbc);


        gbc.anchor = GridBagConstraints.PAGE_END;
        JButton WA = new JButton("WA");
        WA.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 2;
        gbc.gridy = 0;
        WA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Washington");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "WA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "WA"));
                state.setStateAb("WA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "WA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "WA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "WA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "WA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(WA, gbc);


        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        JButton UT = new JButton("UT");
        UT.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 4;
        gbc.gridy = 5;
        UT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Utah");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "UT"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "UT"));
                state.setStateAb("UT");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "UT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "UT"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "UT"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "UT"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(UT, gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        JButton AZ = new JButton("AZ");
        AZ.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 3;
        gbc.gridy = 7;
        AZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Arizona");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "AZ"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "AZ"));
                state.setStateAb("AZ");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "AZ"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "AZ"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "AZ"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "AZ"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(AZ, gbc);


        gbc.anchor = GridBagConstraints.PAGE_END;
        JButton WI = new JButton("WI");
        WI.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 12;
        gbc.gridy = 2;
        WI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Wisconsin");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "WI"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "WI"));
                state.setStateAb("WI");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "WI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "WI"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "WI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "WI"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(WI, gbc);


        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        JButton IL = new JButton("IL");
        IL.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 13;
        gbc.gridy = 4;
        IL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Illinois");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "IL"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "IL"));
                state.setStateAb("IL");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "IL"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "IL"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "IL"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "IL"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(IL, gbc);


        gbc.insets = new Insets(0, 40, 0, 0);
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        JButton IN = new JButton("IN");
        IN.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 13;
        gbc.gridy = 4;
        IN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Indiana");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "IN"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "IN"));
                state.setStateAb("IN");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "IN"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "IN"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "IN"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "IN"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(IN, gbc);


        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        JButton OH = new JButton("OH");
        OH.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 15;
        gbc.gridy = 4;
        OH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Ohio");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "OH"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "OH"));
                state.setStateAb("OH");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "OH"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "OH"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "OH"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "OH"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(OH, gbc);


        JButton MI = new JButton("MI");
        MI.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 14;
        gbc.gridy = 3;
        MI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Michigan");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "MI"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "MI"));
                state.setStateAb("MI");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "MI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "MI"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "MI"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "MI"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(MI, gbc);


        gbc.anchor = GridBagConstraints.LINE_START;
        JButton MS = new JButton("MS");
        MS.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 13;
        gbc.gridy = 8;
        MS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Mississippi");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "MS"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "MS"));
                state.setStateAb("MS");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "MS"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "MS"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "MS"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "MS"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(MS, gbc);

        gbc.insets = new Insets(0, 50, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        JButton AL = new JButton("AL");
        AL.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 13;
        gbc.gridy = 8;
        AL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Alabama");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "AL"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "AL"));
                state.setStateAb("AL");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "AL"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "AL"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "AL"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "AL"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(AL, gbc);


        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.PAGE_END;
        JButton GA = new JButton("GA");
        GA.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 15;
        gbc.gridy = 8;
        GA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Georgia");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "GA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "GA"));
                state.setStateAb("GA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "GA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "GA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "GA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "GA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(GA, gbc);


        JButton FL = new JButton("FL");
        FL.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 16;
        gbc.gridy = 10;
        FL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Florida");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "FL"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "FL"));
                state.setStateAb("FL");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "FL"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "FL"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "FL"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "FL"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(FL, gbc);


        JButton SC = new JButton("SC");
        SC.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 16;
        gbc.gridy = 7;
        SC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("South Carolina");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "SC"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "SC"));
                state.setStateAb("SC");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "SC"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "SC"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "SC"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "SC"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(SC, gbc);


        gbc.anchor = GridBagConstraints.LINE_END;
        JButton NC = new JButton("NC");
        NC.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 16;
        gbc.gridy = 6;
        NC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("North Carolina");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "NC"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "NC"));
                state.setStateAb("NC");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "NC"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "NC"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "NC"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "NC"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(NC, gbc);


        JButton VA = new JButton("VA");
        VA.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 16;
        gbc.gridy = 5;
        VA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Virginia");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "VA"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "VA"));
                state.setStateAb("VA");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "VA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "VA"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "VA"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "VA"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(VA, gbc);


        JButton WV = new JButton("WV");
        WV.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 15;
        gbc.gridy = 5;
        WV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("West Virginia");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "WV"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "WV"));
                state.setStateAb("WV");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "WV"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "WV"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "WV"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "WV"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(WV, gbc);


        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        JButton KC = new JButton("KY");
        KC.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 14;
        gbc.gridy = 5;
        KC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Kentucky");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "KY"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "KY"));
                state.setStateAb("KY");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "KY"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "KY"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "KY"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "KY"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(KC, gbc);


        JButton TN = new JButton("TN");
        TN.setPreferredSize(new Dimension(30, 30));
        gbc.gridx = 14;
        gbc.gridy = 6;
        TN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                state.setVisible(true);
                state.changeStateLabel("Tennessee");
                state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, "TN"));
                state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, "TN"));
                state.setStateAb("TN");
                state.clearCaseSeries();
                state.clearDeathSeries();
                for (int i = 1; i <= 115; i++) {
                    if (i <= 28) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 200 + i + 1, "TN"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 200 + i + 1, "TN"));
                    } else if (i <= 59) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 300 + i - 28, "TN"));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 300 + i - 28, "TN"));
                    } else if (i <= 89) {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 400 + i - 59, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 400 + i - 59, state.getStateAb()));
                    } else {
                        state.addtoCaseSeries(i - 1, select.selectPositive(20200000 + 500 + i - 89, state.getStateAb()));
                        state.addtoDeathSeries(i - 1, select.selectDeath(20200000 + 500 + i - 89, state.getStateAb()));
                    }
                }
            }
        });
        label.add(TN, gbc);


        JButton ZOOM = new JButton("ZOOM");
        ZOOM.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 17;
        gbc.gridy = 3;
        ZOOM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                northEast.setVisible(true);
            }
        });
        label.add(ZOOM, gbc);

        JButton general = new JButton("Research");
        general.setPreferredSize(new Dimension(100, 100));
        general.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                northEast.setVisible(false);
                state.setVisible(false);
                rank.setVisible(false);
                research.setVisible(true);
            }
        });

        JButton mainMap = new JButton("Main Map");
        mainMap.setPreferredSize(new Dimension(100, 100));
        mainMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(true);
                northEast.setVisible(false);
                research.setVisible(false);
                state.setVisible(false);
                rank.setVisible(false);
            }
        });

        JButton rankings = new JButton("Rankings");
        rankings.setPreferredSize(new Dimension(100, 100));
        rankings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                northEast.setVisible(false);
                research.setVisible(false);
                state.setVisible(false);
                rank.setVisible(true);
            }
        });

        JLabel title = new JLabel("COVID Tracker");
        Font font = new Font("Courier", Font.BOLD, 18);
        title.setFont(font);
        JLabel text1 = new JLabel("To look at our research");
        JLabel text2 = new JLabel("To be redirected to the main map");
        JLabel text3 = new JLabel("To look at case rankings");
        JLabel description1 = new JLabel("Our Goal: To create an interactive");
        JLabel description2 = new JLabel("environment that increases awareness");
        JLabel description3 = new JLabel("about and helps slow the");
        JLabel description4 = new JLabel("spread of the COVID-19.");
        GridBagConstraints gbc2 = new GridBagConstraints();

        panel2.add(title, gbc2);
        gbc2.gridy = 1;
        panel2.add(description1, gbc2);
        gbc2.gridy = 2;
        panel2.add(description2, gbc2);
        gbc2.gridy = 3;
        panel2.add(description3, gbc2);
        gbc2.gridy = 4;
        gbc2.insets = new Insets(0, 0, 200, 0);
        panel2.add(description4, gbc2);
        gbc2.gridy = 5;
        gbc2.insets = new Insets(0, 0, 0, 0);
        panel2.add(day, gbc2);
        gbc2.gridy = 6;
        panel2.add(slider, gbc2);
        gbc2.gridy = 7;
        panel2.add(text1, gbc2);
        gbc2.gridy = 8;
        panel2.add(general, gbc2);
        gbc2.gridy = 9;
        panel2.add(text2, gbc2);
        gbc2.gridy = 10;
        panel2.add(mainMap, gbc2);
        gbc2.gridy = 11;
        panel2.add(text3, gbc2);
        gbc2.gridy = 12;
        panel2.add(rankings, gbc2);


        panel1.add(label);
        frame.add(northEast);
        northEast.setVisible(false);
        frame.add(research);
        research.setVisible(false);
        frame.add(state);
        state.setVisible(false);
        frame.add(rank);
        rank.setVisible(false);
        frame.add(panel1);
        panel1.setVisible(true);
        frame.add(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        slider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        if ((((JSlider) e.getSource()).getValue() >= 0) && (((JSlider) e.getSource()).getValue() <= 28)) {
                            bigDate = 20200000 + 200 + ((JSlider) e.getSource()).getValue() + 1;
                            day.setText("Feburary " + (((JSlider) e.getSource()).getValue() + 1) + " 2020");
                            state.changeDateLabel("Data for: Feburary " + (((JSlider) e.getSource()).getValue() + 1) + " 2020");
                        }
                        if ((((JSlider) e.getSource()).getValue() >= 29) && (((JSlider) e.getSource()).getValue() <= 59)) {
                            bigDate = 20200000 + 300 + ((JSlider) e.getSource()).getValue() - 28;
                            day.setText("March " + (((JSlider) e.getSource()).getValue() - 28) + " 2020");
                            state.changeDateLabel("Data for: March " + (((JSlider) e.getSource()).getValue() - 28) + " 2020");
                        }
                        if ((((JSlider) e.getSource()).getValue() >= 60) && (((JSlider) e.getSource()).getValue() <= 89)) {
                            bigDate = 20200000 + 400 + ((JSlider) e.getSource()).getValue() - 59;
                            day.setText("April " + (((JSlider) e.getSource()).getValue() - 59) + " 2020");
                            state.changeDateLabel("Data for: April " + (((JSlider) e.getSource()).getValue() - 59) + " 2020");
                        }

                        if ((((JSlider) e.getSource()).getValue() >= 90) && (((JSlider) e.getSource()).getValue() <= 115)) {
                            bigDate = 20200000 + 500 + ((JSlider) e.getSource()).getValue() - 89;
                            day.setText("May " + (((JSlider) e.getSource()).getValue() - 89) + " 2020");
                            state.changeDateLabel("Data for: May " + (((JSlider) e.getSource()).getValue() - 89) + " 2020");
                        }
                        state.changeDeathLabel("Deaths: " + select.selectDeath(bigDate, state.getStateAb()));
                        state.changeCasesLabel("Cases: " + select.selectPositive(bigDate, state.getStateAb()));
                        int[] array = getCasesArray(bigDate);
                        sort(array, 0, array.length - 1);
                        for (int i = 1; i < 51; i++) {
                            if (i < 26) {
                                gbcRank.gridy = i - 1;
                                gbcRank.gridx = 0;
                                JLabel l = (JLabel) (rank.getComponent(i-1));
                                l.setText(i + ": " + map.get(array[array.length - i]).remove(0) + "(" + array[array.length - i] + ")");
                            } else {
                                gbcRank.gridy = i - 26;
                                gbcRank.gridx = 2;
                                gbcRank.insets = new Insets(0, 50, 0, 0);
                                JLabel l = (JLabel) (rank.getComponent(i-1));
                                l.setText(i + ": " + map.get(array[array.length - i]).remove(0) + "(" + array[array.length - i] + ")");
                            }
                        }
                        JLabel l = (JLabel) (rank.getComponent(50));
                        l.setText("Total US States Positive Cases: " + sum);

                    }
                });

    }

    public static int[] getCasesArray(int a) {
        int[] array = new int[50];
        map = new TreeMap<Integer, ArrayList<String>>();
        sum = 0;
        for (int i = 0; i < stateArray.size(); i++) {
            array[i] = select.selectPositive(a, stateArray.get(i).substring(0, 2));
            sum += array[i];
            if (map.containsKey(array[i])) {
                map.get(array[i]).add(stateArray.get(i).substring(5));
            } else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(stateArray.get(i).substring(5));
                map.put(array[i], temp);
            }
        }
        return array;
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public static void sort(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

   /*
   public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {

      File inputFile = new File(inputImagePath);
      BufferedImage inputImage = ImageIO.read(inputFile);

      BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

      Graphics2D g2d = outputImage.createGraphics();
      g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
      g2d.dispose();

      String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

      ImageIO.write(outputImage, formatName, new File(outputImagePath));
   }
   */

}


