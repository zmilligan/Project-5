import javax.swing.JPanel;

public abstract class ProjectPanel
{
	protected JPanel panel = new JPanel();
	protected HammingDist base = new HammingDist();
	
	public JPanel getPanel()
	{
		return panel;
	}
}
