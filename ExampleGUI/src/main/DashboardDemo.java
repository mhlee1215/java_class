package main;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import javax.swing.*;

/**
 * This class builds the dashboard examples used in the May 2009 Java News Brief article
 * located at http://www.ociweb.com/jnb/jnbMay2009.html
 *
 * @author Chris Hardin
 */
public class DashboardDemo extends JFrame {
    /*
        All of the dashboard components are created here as instance fields
        to keep the buildDashboard() method streamlined for display in the article.
     */
    JLabel settingsLabel = new JLabel("Dashboard Settings");
    JLabel nameLabel = new JLabel("Name:");
    JLabel zipLabel = new JLabel("Zip Code:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel avatarLabel = new JLabel("Avatar Image:");

    JTextField fNameField = new JTextField(10);
    JTextField mNameField = new JTextField(1);
    JTextField lNameField = new JTextField(15);
    JTextField zipField = new JTextField(5);
    JTextField emailField = new JTextField(20);
    JTextField avatarField = new JTextField(30);

    JButton okBttn = new JButton("Ok");
    JButton cancelBttn = new JButton("Cancel");
    JButton helpBttn = new JButton("Help");

    JLabel headerLabel;
    JLabel footerLabel;
    JLabel widget1;
    JLabel widget2;
    JLabel widget3;

    JLabel avatarImage;

    /**
     * Construct the frame.
     * @param title
     */
    public DashboardDemo(String title) {
	super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initializeDockingComponents();
        if(title.startsWith("MiG")){
            add(buildMiGDashboard());
        } else if(title.startsWith("Flow")) {
            add(buildMiGFlowLayout());
        } else {
            add(buildStandardDashboard());
        }
        pack();
    }

    /**
     * Build the main panel of the dashboard using
     * the MiGLayout layout manager.
     */
    private JPanel buildMiGDashboard() {
        JPanel panel = new JPanel();
	panel.setLayout(new MigLayout());
        buildMiGForm(panel);

        //add docked components
        panel.add(widget3, "east, gapleft 5, w 100");
        panel.add(headerLabel, "north, gapbottom 15, h 40, id headerLabel");    //can specify height and not width
        panel.add(footerLabel, "south, gaptop 15, h 40");
        panel.add(widget1, "west, gapright 5, w 80");
        panel.add(widget2, "west, gapright 10, w 80");

        //add absolutely positioned component
        //panel.add(avatarImage, "pos (headerLabel.x2 - 28) (headerLabel.y2 + 5)");
//        avatarImage.setSize(10, 10);
//        panel.add(avatarImage, "pos 40 40");
        
        JButton testButton = new JButton("Hihi!!");
        panel.add(testButton, "pos 40 40 200 300");

        return panel;
    }
    private void buildMiGForm(JPanel panel) {
        panel.add(settingsLabel, "span, center, gapbottom 15");
        panel.add(nameLabel, "align label");
        panel.add(fNameField);
        panel.add(mNameField);
        panel.add(lNameField, "wrap");
        panel.add(zipLabel, "align label");
        panel.add(zipField, "wrap");
        panel.add(emailLabel,"align label");
        panel.add(emailField, "span");
        panel.add(avatarLabel, "align label");
        panel.add(avatarField, "span");
        panel.add(okBttn, "tag ok, span, split 3, sizegroup bttn");
        panel.add(cancelBttn, "tag cancel, sizegroup bttn");
        panel.add(helpBttn, "tag help, sizegroup bttn");
    }

    /**
     * Build the main panel of the dashboard using
     * the standard layout managers provided with the JDK.
     */
    private JPanel buildStandardDashboard() {
        JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());
        buildGridBagForm(panel);

        //add docked components
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());               //We have to use a different layout manager
        outerPanel.add(panel, BorderLayout.CENTER);             //We have to nest the form panel

        headerLabel.setPreferredSize(new Dimension(500,40));    //Need additional lines to size components
        widget1.setPreferredSize(new Dimension(80, 200));       //Have to set both width and height together
        widget2.setPreferredSize(new Dimension(80, 200));
        widget3.setPreferredSize(new Dimension(100,210));
        footerLabel.setPreferredSize(new Dimension(500,40));

        outerPanel.add(widget3, BorderLayout.EAST);             //This part is as easy as MiGLayout
        outerPanel.add(headerLabel, BorderLayout.NORTH);                
        outerPanel.add(footerLabel, BorderLayout.SOUTH);

        JPanel westPanel = new JPanel();                    //Nesting another JPanel, using default FlowLayout
        westPanel.add(widget1);                             //BorderLayout will not dock multiple components on one side
        westPanel.add(widget2);
        outerPanel.add(westPanel, BorderLayout.WEST);

        return outerPanel;                                  
    }
    private void buildGridBagForm(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder(17,17,17,17));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.insets = new Insets(0,0,15,0);
        panel.add(settingsLabel, constraints);
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridy++;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(nameLabel, constraints);
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(fNameField, constraints);
        panel.add(mNameField, constraints);
        panel.add(lNameField, constraints);
        constraints.gridy++;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(zipLabel, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(zipField, constraints);
        constraints.gridy++;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(emailLabel,constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = 3;
        panel.add(emailField, constraints);
        constraints.gridwidth = 1;
        constraints.gridy++;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(avatarLabel, constraints);
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(avatarField, constraints);
        constraints.gridy++;
        constraints.gridwidth = 3;
        panel.add(helpBttn, constraints);
        constraints.anchor = GridBagConstraints.EAST;
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(cancelBttn);
        buttonBox.add(Box.createHorizontalStrut(5));
        buttonBox.add(okBttn);
        panel.add(buttonBox, constraints);
    }

    /**
     * This example demonstrates using MiGLayout as a flow layout.
     */
    private JPanel buildMiGFlowLayout() {
        JPanel panel = new JPanel();
	panel.setLayout(new MigLayout("nogrid, flowy, debug"));    //make vertical flowing, also running in debug mode

        //add flowing components
        panel.add(widget3, "w 100");
        panel.add(headerLabel, "h 40");
        panel.add(footerLabel, "h 40");
        panel.add(widget1, "w 80, wrap");
        panel.add(widget2, "w 80");
        panel.add(avatarImage);

        return panel;
    }


    /**
     * Everything below here is just setup code that is the same for
     * all examples. It is not part of the comparison.
     */
    private void initializeDockingComponents() {
        Font labelFont = new Font("Arial",Font.BOLD, 14);

        headerLabel = new JLabel("Player Dashboard", SwingConstants.CENTER);
        setUpLabel(headerLabel, Color.BLUE, Color.YELLOW, labelFont.deriveFont((float)24));

        widget1 = new JLabel("Widget 1", SwingConstants.CENTER);
        setUpLabel(widget1, new Color(209,234,249), Color.BLACK, labelFont);

        widget2 = new JLabel("Widget 2", SwingConstants.CENTER);
        setUpLabel(widget2, new Color(209,234,249), Color.BLACK, labelFont);

        widget3 = new JLabel("Widget 3", SwingConstants.CENTER);
        setUpLabel(widget3, new Color(191,139,158), Color.BLACK, labelFont);

        footerLabel = new JLabel("Have Fun!", SwingConstants.CENTER);
        setUpLabel(footerLabel, Color.BLUE, Color.YELLOW, labelFont.deriveFont((float)18));

        ImageIcon avatarIcon =
                new ImageIcon(getClass().getClassLoader().getResource("main/images/tetris.png"));
        avatarImage = new JLabel(avatarIcon);
    }
    private void setUpLabel(JLabel label, Color bg, Color fg, Font f) {
        label.setOpaque(true);
        label.setBackground(bg);
        label.setForeground(fg);
        label.setFont(f);    
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	DashboardDemo migFrame = new DashboardDemo("MiGLayout Dashboard");
                migFrame.setVisible(true);

//                DashboardDemo stdFrame = new DashboardDemo("BorderLayout Dashboard");
//                stdFrame.setVisible(true);
//                stdFrame.setLocation(0, 380);
//
//                DashboardDemo migFlowFrame = new DashboardDemo("Flowing MiGLayout");
//                migFlowFrame.setVisible(true);
//                migFlowFrame.setLocation(0, 700);
            }
        });
    }
}