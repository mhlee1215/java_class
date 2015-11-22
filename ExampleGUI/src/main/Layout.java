package main;

import net.miginfocom.swing.MigLayout;

import java.util.Calendar;
import java.util.Date;
import java.awt.*;

import javax.swing.*;

public class Layout extends JFrame {

	JLabel sundaywidget;
	JLabel mondaywidget;
	JLabel tuesdaywidget;
	JLabel wednesdaywidget;
	JLabel thursdaywidget;
	JLabel fridaywidget;
	JLabel saturdaywidget;


	public Layout(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initializeDockingComponents();

		setLayout(new BorderLayout());
		add(buildMiGDashboard(), BorderLayout.NORTH);
		add(buildDatePanel(), BorderLayout.CENTER);

		pack();

	}

	JLabel datewidget;

	private JPanel buildDatePanel(){

		Date nDate = new Date();

		Calendar cal = Calendar.getInstance() ;
		cal.setTime(nDate);

		int range = 100;

		int curDay = cal.get(Calendar.DATE);
		int curDate = cal.get(Calendar.DAY_OF_WEEK);
		int curMonth = cal.get(Calendar.MONTH)+1;
		int curYear = cal.get(Calendar.YEAR);

		int curDayNum = cal.get(Calendar.DAY_OF_WEEK) ;	


		JPanel panel = new JPanel();
		FlowLayout fLayout = new FlowLayout();
		fLayout.setAlignment(FlowLayout.LEFT);
		panel.setLayout(fLayout);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 11, 0, 0));
		panel.setPreferredSize(new Dimension(400, 600));

		int prevMonth = cal.get(Calendar.MONTH) ;
		cal.add ( Calendar.DATE, -1 );
		for (int b = 0; b<100; b++){
			cal.add ( Calendar.DATE, 1 );
			if(prevMonth != cal.get(Calendar.MONTH)) break;

			JPanel datepanel = new JPanel();
//			panel.add(datepanel);
//			datepanel.add(datewidget);
//			datewidget.setPreferredSize(new Dimension(75,100));
//			buildMigForm(datepanel);
//
//			for(int i = 0 ; i < curDayNum ; i++)
//				System.out.print("\t");
//
//			//			System.out.print(cal.get(Calendar.DATE));

			datepanel = new JPanel();

			int date = cal.get(Calendar.DATE);
			datepanel.add(new JLabel(Integer.toString(date)));

			datepanel.setBackground(Color.white);
			datepanel.add(datewidget);
			datepanel.setPreferredSize(new Dimension(91,100));
			panel.add(datepanel);

			for (int a = 0; a<50; a++){

			}

		}		
		return panel;

	}


	private JPanel buildMiGDashboard() {
		JPanel panel = new JPanel();
		JPanel sundaypanel = new JPanel();
		JPanel mondaypanel = new JPanel();
		JPanel tuesdaypanel = new JPanel();
		JPanel wednesdaypanel = new JPanel();
		JPanel thursdaypanel = new JPanel();
		JPanel fridaypanel = new JPanel();
		JPanel saturdaypanel = new JPanel();

		int dateWidgetWidth = 82;
		
		sundaywidget.setPreferredSize(new Dimension(dateWidgetWidth, 50));
		mondaywidget.setPreferredSize(new Dimension(dateWidgetWidth, 50)); 
		tuesdaywidget.setPreferredSize(new Dimension(dateWidgetWidth, 50));
		wednesdaywidget.setPreferredSize(new Dimension(dateWidgetWidth, 50));
		thursdaywidget.setPreferredSize(new Dimension(dateWidgetWidth, 50));
		fridaywidget.setPreferredSize(new Dimension(dateWidgetWidth, 50));
		saturdaywidget.setPreferredSize(new Dimension(dateWidgetWidth, 50));
		panel.setLayout(new MigLayout());

		sundaypanel.add(sundaywidget, "0,0,0");
		mondaypanel.add(mondaywidget, "0,0,0");
		tuesdaypanel.add(tuesdaywidget, "0,0,0");
		wednesdaypanel.add(wednesdaywidget, "0,0,0");
		thursdaypanel.add(thursdaywidget, "0,0,0");
		fridaypanel.add(fridaywidget, "0,0,0");
		saturdaypanel.add(fridaywidget, "0,0,0");

		buildMiGForm(panel);



		panel.setLayout(new MigLayout());
		buildMigForm(sundaypanel);
		panel.setLayout(new MigLayout());
		buildMigForm(mondaypanel);
		panel.setLayout(new MigLayout());
		buildMigForm(tuesdaypanel);
		panel.setLayout(new MigLayout());
		buildMigForm(wednesdaypanel);
		panel.setLayout(new MigLayout());
		buildMigForm(thursdaypanel);
		panel.setLayout(new MigLayout());
		buildMigForm(fridaypanel);
		panel.setLayout(new MigLayout());
		buildMigForm(saturdaypanel);


		sundaypanel = new JPanel();
		sundaypanel.setBackground(Color.white);
		sundaypanel.add(sundaywidget);
		sundaypanel.setBounds(0, 0, 0, 0);

		mondaypanel = new JPanel();
		mondaypanel.setBackground(Color.white);
		mondaypanel.add(mondaywidget);
		mondaypanel.setBounds(100, 100, 100, 100);

		tuesdaypanel = new JPanel();
		tuesdaypanel.setBackground(Color.white);
		tuesdaypanel.add(tuesdaywidget);
		tuesdaypanel.setBounds(200, 200, 200, 200);

		wednesdaypanel = new JPanel();
		wednesdaypanel.setBackground(Color.white);
		wednesdaypanel.add(wednesdaywidget);
		wednesdaypanel.setBounds(100, 100, 100, 100);

		thursdaypanel = new JPanel();
		thursdaypanel.setBackground(Color.white);
		thursdaypanel.add(thursdaywidget);
		thursdaypanel.setBounds(100, 100, 100, 100);

		fridaypanel = new JPanel();
		fridaypanel.setBackground(Color.white);
		fridaypanel.add(fridaywidget);
		fridaypanel.setBounds(100, 100, 100, 100);

		saturdaypanel = new JPanel();
		saturdaypanel.setBackground(Color.white);
		saturdaypanel.add(saturdaywidget);
		saturdaypanel.setBounds(100, 100, 100, 100);

		setSize(100, 100);
		setLocation(0, 0);
		setResizable(true);
		setVisible(true);

		panel.add(sundaypanel);
		panel.add(mondaypanel);
		panel.add(tuesdaypanel);
		panel.add(wednesdaypanel);
		panel.add(thursdaypanel);
		panel.add(fridaypanel);
		panel.add(saturdaypanel);

		return panel;

	}


	private void buildMigForm(JPanel panel) {
		// TODO Auto-generated method stub

	}
	private void buildMiGForm(JPanel panel) {

	}

	private JPanel buildStandardDashboard() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		buildGridBagForm(panel);

		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new BorderLayout());               //We have to use a different layout manager
		outerPanel.add(panel, BorderLayout.CENTER); 


		return outerPanel;                         


	}

	private void buildGridBagForm(JPanel panel) {
		// TODO Auto-generated method stub

	}
	private Component buildMiGFlowLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	private void initializeDockingComponents() {
		Font labelFont = new Font("Arial",Font.BOLD, 14);

		sundaywidget = new JLabel("Sunday", SwingConstants.CENTER);
		setUpLabel(sundaywidget, new Color(250,250,250), Color.RED, labelFont);

		mondaywidget = new JLabel("Monday", SwingConstants.CENTER);
		setUpLabel(mondaywidget, new Color(250,250,250), Color.BLACK, labelFont);

		tuesdaywidget = new JLabel("Tuesday", SwingConstants.CENTER);
		setUpLabel(tuesdaywidget, new Color(250,250,250), Color.BLACK, labelFont);

		wednesdaywidget = new JLabel("Wednesday", SwingConstants.CENTER);
		setUpLabel(wednesdaywidget, new Color(250,250,250), Color.BLACK, labelFont);

		thursdaywidget = new JLabel("Thursday", SwingConstants.CENTER);
		setUpLabel(thursdaywidget, new Color(250,250,250), Color.BLACK, labelFont);

		fridaywidget = new JLabel("Friday", SwingConstants.CENTER);
		setUpLabel(fridaywidget, new Color(250,250,250), Color.BLACK, labelFont);

		saturdaywidget = new JLabel("Saturday", SwingConstants.CENTER);
		setUpLabel(saturdaywidget, new Color(250,250,250), Color.GRAY, labelFont);

		datewidget = new JLabel("", SwingConstants.CENTER);
		setUpLabel(datewidget, new Color(250,250,250), Color.black, labelFont);

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
				Layout migFrame = new Layout("Calendar");
				migFrame.setVisible(true);
			}
		});
	}
}