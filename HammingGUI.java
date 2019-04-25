import java.awt.GridLayout;

import javax.swing.JFrame;

public class HammingGUI extends JFrame
{
	private RequiredPanel rPanel = new RequiredPanel();
	private CreativePanel cPanel = new CreativePanel();
	
	public HammingGUI()
	{
		this.setSize(600, 740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gl = new GridLayout(0, 2);
		this.setLayout(gl);
		this.add(rPanel.getPanel());
		this.add(cPanel.getPanel());
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new HammingGUI();

	}

}
