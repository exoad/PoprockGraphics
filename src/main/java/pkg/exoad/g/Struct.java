package pkg.exoad.g;
import pkg.exoad.g.debug.Diagnostics;
public final class Struct
{
	public static <C,D> Pair<C,D> pair(C first,D second)
	{
		return new Pair<>(first,second);
	}
	
	public static final class Pair<A,B>
	{
		public A first;
		public B second;
		
		private Pair(A first,B second)
		{
			this.first =first;
			this.second=second;
		}
		
		public void setFirst(A first)
		{
			this.first=first;
		}
		
		public A getFirst()
		{
			return first;
		}
		
		public void setSecond(B second)
		{
			this.second=second;
		}
		
		public B getSecond()
		{
			return second;
		}
		
		@Override
		public String toString()
		{
			return Diagnostics.toStringClassItems(
				Diagnostics.genericClassNameGenerator(
					"Pair",
					Diagnostics.classNameOf(
						first),
					Diagnostics.classNameOf(
						second)
				),
				new String[][]
					{
						{"first",first.toString()},
						{"second",second.toString()}
					}
			);
		}
	}
}
