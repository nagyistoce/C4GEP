package ui.conf;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ui.app.MainWnd;
import ui.app.TablePanel;
import ui.conf.view.TypeHelper.TableType;
import ui.images.ImageHelper;

public class WelcomeContent_HistoryProject extends JPanel {

	private MainWnd mainWnd;
	public TablePanel projectTable;
	
	/**
	 * Create the panel.
	 */
	public WelcomeContent_HistoryProject(MainWnd mainWnd) {
		this.mainWnd = mainWnd;
		setBorder(new EmptyBorder(5, 2, 5, 2));
		setSize(648,212);
		JList list = new JList();
		
		JLabel lblNewLabel = new JLabel("History Project");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel.setBackground(new Color(176, 196, 222));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("  You can start up your history project");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBackground(new Color(255, 255, 204));
		lblNewLabel_1.setOpaque(true);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		
		
		projectTable = new TablePanel(mainWnd,TableType.CreateNewProfileTable);
		projectTable.setBorder(new EmptyBorder(8, 8, 1, 8));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE))
						.addComponent(list)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(projectTable, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(list)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(projectTable, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addGap(0))
		);
		setLayout(groupLayout);
		
		ImageIcon ii = ImageHelper.loadImage("books");
		

	}
	
	
	
	
	
	
	
	
	
	
	
}
