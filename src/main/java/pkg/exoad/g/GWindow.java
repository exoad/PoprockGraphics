package pkg.exoad.g;
import javax.swing.*;
public class GWindow
	extends GElement<GWindow>
	implements Constructive
{
	public enum CloseOperation
	{
		KILL(WindowConstants.EXIT_ON_CLOSE),
		HIDE(WindowConstants.HIDE_ON_CLOSE),
		DISPOSE(WindowConstants.DISPOSE_ON_CLOSE),
		DO_NOTHING(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		final int op;
		
		CloseOperation(int h)
		{
			this.op=h;
		}
	}
	
	public static GWindow make(String viewID)
	{
		return new GWindow(viewID);
	}
	
	private final JFrame jf;
	
	private GWindow(String viewID)
	{
		super(viewID);
		jf=new JFrame();
	}
	
	public GWindow withTitle(String title)
	{
		jf.setTitle(title);
		setBaked(true);
		return this;
	}
	
	@Override
	public GWindow withDim(G.Dim v)
	{
		jf.setSize(v.width,v.height);
		jf.setPreferredSize(v.toCompatible());
		setBaked(true);
		return this;
	}
	
	public GWindow withOnClose(CloseOperation op)
	{
		jf.setDefaultCloseOperation(op.op);
		return this;
	}
	
	public GWindow withLocation(G.Pt pt)
	{
		jf.setLocation(pt.xInt(),pt.yInt());
		return this;
	}
	
	public GWindow withCenteredLocation(boolean center)
	{
		if(!center)
			return withLocation(G.pt(0f,0f));
		jf.setLocationRelativeTo(null);
		return this;
	}
	
	public void operate()
	{
		if(isBaked())
		{
			jf.pack();
			jf.setVisible(true);
		}
	}
}