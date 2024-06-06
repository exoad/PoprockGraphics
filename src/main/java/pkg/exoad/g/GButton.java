package pkg.exoad.g;
import javax.swing.*;
public class GButton
	extends GInheritedElement<GButton,JButton>
	implements Constructive
{
	public static GButton make(String viewID)
	{
		return new GButton(viewID);
	}
	
	private final JButton jb;
	
	private GButton(String viewID)
	{
		super(viewID);
		jb=new JButton();
	}
	
	@Override public GButton withDim(final G.Dim dim)
	{
		return null;
	}
	
	@Override public JButton toCompatible()
	{
		return null;
	}
}
