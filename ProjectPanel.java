import javax.swing.JPanel;

public abstract class ProjectPanel
{
	protected JPanel panel1;
	protected JPanel panel2;
	protected HammingDist base = new HammingDist();
	
	public JPanel getPanel1()
	{
		return panel1;
	}
	
	public JPanel getPanel2()
	{
		return panel2;
	}
}
