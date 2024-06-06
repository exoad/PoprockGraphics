package pkg.exoad.g;
import pkg.exoad.g.debug.Diagnostics;

import java.awt.*;
public final class G
{
	
	
	public static final int VERSION_NO=1;
	
	public static final class Dim
		implements Downgradeable<Dimension>
	{
		public final int width;
		public final int height;
		
		private Dim(int width,int height)
		{
			this.width =width;
			this.height=height;
		}
		
		@Override
		public Dimension toCompatible()
		{
			return new Dimension(width,height);
		}
		
		@Override
		public String toString()
		{
			return Diagnostics.toStringClassItems(
				"Dim",
				new String[][]{
					{"width",Integer.toString(width)},
					{"weight",Integer.toString(height)}}
			);
		}
	}
	
	public static final class Pt
	{
		public final float x;
		public final float y;
		
		private Pt(float x,float y)
		{
			this.x=x;
			this.y=y;
		}
		
		public int xInt()
		{
			return (int)x;
		}
		
		public int yInt()
		{
			return (int)y;
		}
		
		@Override
		public String toString()
		{
			return Diagnostics.toStringClassItems(
				"Pt",
				new String[][]{{"x",Float.toString(x)},
							   {"y",
								Float.toString(y)}}
			);
		}
	}
	
	public GWindow window(String viewID)
	{
		return GWindow.make(viewID);
	}
	
	public static G.Dim getScreenSize()
	{
		return G.dim(Toolkit.getDefaultToolkit()
						 .getScreenSize());
	}
	
	public enum Align
	{
		CENTER(0,0),
		TOP_LEFT(-1,1),
		TOP_RIGHT(1,1),
		BOTTOM_LEFT(-1,-1),
		BOTTOM_RIGHT(1,-1),
		CENTER_LEFT(-1,0),
		CENTER_RIGHT(1,0);
		
		final int x;
		final int y;
		
		Align(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	
	public static Dim dim(int width,int height)
	{
		return new Dim(width,height);
	}
	
	public static Dim dim(Dimension dim)
	{
		return new Dim(dim.width,dim.height);
	}
	
	public static Pt pt(float x,float y)
	{
		return new Pt(x,y);
	}
	
	public static synchronized void ensureEngineInitialized()
	{
		// empty for now
	}
	
	private G()
	{}
}
