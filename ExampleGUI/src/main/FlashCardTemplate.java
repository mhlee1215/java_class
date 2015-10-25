package main;

import java.awt.BorderLayout;
//import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import net.miginfocom.swing.MigLayout;

public class FlashCardTemplate extends JFrame{

	JPanel mainPanel = new JPanel();
	JPanel northPanel = new JPanel();
	JPanel centerPanel = buildListPanel();
	JPanel southPanel = new JPanel();
	
	public FlashCardTemplate(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		add(buildMain());
		//pack();
		setSize(700, 400);
	}

	private JPanel buildMain() {
		mainPanel.setLayout(new BorderLayout());
		
		northPanel.setLayout(new FlowLayout());
		JButton showListButton = new JButton("Show List");
		showListButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(centerPanel);
				centerPanel = buildListPanel();
				mainPanel.add(centerPanel, BorderLayout.CENTER);
				mainPanel.validate();
				mainPanel.repaint();
				
			}
		});
		northPanel.add(showListButton);
		JButton showDetailButton = new JButton("Show Detail");
		showDetailButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(centerPanel);
				centerPanel = buildDetailPanel();
				mainPanel.add(centerPanel, BorderLayout.CENTER);
				mainPanel.validate();
				mainPanel.repaint();
			}
		});
		northPanel.add(showDetailButton);
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		southPanel.setLayout(new FlowLayout());
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		
		return mainPanel;
	}
	
	public JPanel buildListPanel(){
		JPanel centerPanel = new JPanel();
		FlowLayout fLayout = new FlowLayout();
		fLayout.setAlignment(FlowLayout.LEFT);
		centerPanel.setLayout(fLayout);
		
		int itemNum = 20;
		for(int i = 0 ; i < itemNum ; i++){
			JButton item = null;
			if(i == itemNum-1){
				//Last one
				item = new JButton("+");	
			}else{
				item = new JButton("word_"+i);
			}
			
			//item.setSize(50, 50);
			item.setPreferredSize(new Dimension(80, 80));
			centerPanel.add(item);	
		}
		return centerPanel;
	}
	
	public JPanel buildDetailPanel(){
		JPanel detailPanel = new JPanel();
		detailPanel.add(new JButton("detail!"));
		return detailPanel;
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FlashCardTemplate migFrame = new FlashCardTemplate("Flash card Template");
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
