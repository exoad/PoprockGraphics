package pkg.exoad.g;
import javax.swing.*;
public abstract class GInheritedElement<A extends GElement<A>,B extends JComponent>
	extends GElement<A>
	implements Downgradeable<B>
{
	public GInheritedElement(final String viewID)
	{
		super(viewID);
	}
}
