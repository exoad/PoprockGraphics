package pkg.exoad.g.debug;
public final class Diagnostics
{
	/**
	 * Converts to a localized debug diagnostics format
	 *
	 * @param className Class Name
	 * @param items Must be in a
	 * {{parameterName,parameterValue},{parameterName,
	 * parameterValue}} format
	 *
	 * @return Diagnostics Localized message
	 */
	public static String toStringClassItems(
		String className,String[][] items
	)
	{
		StringBuilder buffer=new StringBuilder(className);
		buffer.append(":[");
		for(int i=0;i<items.length;i++)
		{
			buffer
				.append(items[i][0])
				.append("=")
				.append(items[i][1]);
			if(i!=items.length-1)
				buffer.append(",");
		}
		return buffer
			.append("]")
			.toString();
	}
	
	public static String genericClassNameGenerator(
		String rawClassName,String... types
	)
	{
		StringBuilder sb=
			new StringBuilder(rawClassName).append(
				"(");
		for(int i=0;i<types.length;i++)
		{
			sb.append(types[i]);
			if(i!=types.length-1)
				sb.append("#");
		}
		return sb
			.append(")")
			.toString();
	}
	
	@NullSafe
	public static String classNameOf(Object r)
	{
		return r==null?PublicConstants.NULL_T:r
			.getClass()
			.getSimpleName();
	}
}
