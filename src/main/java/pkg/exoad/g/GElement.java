package pkg.exoad.g;
public abstract class GElement<A extends GElement<A>>
{
	public final String viewID;
	private boolean isBaked;
	
	public GElement(String viewID)
	{
		this.viewID=viewID;
		isBaked=false;
	}
	
	public boolean isBaked()
	{
		return isBaked;
	}
	
	protected void setBaked(boolean r)
	{
		this.isBaked=r;
	}
	
	public abstract A withDim(G.Dim dim);
}
