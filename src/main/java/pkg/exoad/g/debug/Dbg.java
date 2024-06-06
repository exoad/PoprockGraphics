package pkg.exoad.g.debug;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public final class Dbg
{
	public static String logMessageFormat="[ {0} | {1} ] "+
										  ">> {2}";
	public static SimpleDateFormat logMessageTimeStampFormat;
	private static PrintStream out;
	
	static
	{
		setOutStream(System.out);
		logMessageTimeStampFormat=new SimpleDateFormat(
			"mm/dd"+
			"/YYYY "+
			"HH:mm"+
			":ssss");
	}
	
	public static PrintStream getOut()
	{
		if(out==null)
			setOutStream(System.out);
		return out;
	}
	
	public static void push(String lead,Object msg)
	{
		getOut().println(MessageFormat.format(
			logMessageFormat,
			lead,
			logMessageTimeStampFormat.format(new Date(System.currentTimeMillis()))
			,msg
		));
	}
	
	public static void warn(Object msg)
	{
		push("1-WARN",msg);
	}
	
	public static void info(Object msg)
	{
		push("0-INFO",msg);
	}
	
	public static void error(Object msg)
	{
		push("2-ERRN",msg);
	}
	
	public static void panic(Throwable cause,Object msg)
	{
		push(
			"PANIC",
			"[!!!] PoprockGraphics' debugger panicked on "+
			"invokation via: "+cause.getMessage()
		);
		getOut().println(msg.toString());
		getOut().println("[!] == Stacktrace attached == " +
						 "[!]");
		throw modifyThrowable(new RuntimeException(
			Thread
				.currentThread()
				.getName()+" panicked on "+cause.getMessage(),
			cause
		))
			;
	}
	
	public static RuntimeException modifyThrowable(
		Throwable throwable
	) // copied directly from the raw poprock's lib LOL
	{
		throwable
			.setStackTrace(
				new StackTraceElement[]{
					// this part should really be
					// customized, but we can't cuz
					// StackTraceElement.class is an
					// immutable class!! D: big sad
					
					// we only supply the beginning stack
					// trace because this will be the most
					// useful call because it identifies
					// the invoking source
					new StackTraceElement(
						throwable
							.getStackTrace()[0]
							.getClassName()+" -> ",
						throwable
							.getStackTrace()[0]
							.getMethodName(),
						":",
						throwable
							.getStackTrace()[0]
							.getLineNumber()
					),
					new StackTraceElement(
						throwable
							.getStackTrace()[1]
							.getClassName()+" -> ",
						throwable
							.getStackTrace()[1]
							.getMethodName(),
						":",
						throwable
							.getStackTrace()[1]
							.getLineNumber()
					),
					// we only supply the ending stack
					// trace because that could be useful
					// to identify the root source
					new StackTraceElement(
						throwable
							.getStackTrace()[throwable
												 .getStackTrace().length-1]
							.getClassName()+" -> ",
						throwable
							.getStackTrace()[throwable
												 .getStackTrace().length-1]
							.getMethodName(),
						":",
						throwable
							.getStackTrace()[throwable
												 .getStackTrace().length-1]
							.getLineNumber()
					)
				}
			);
		return (RuntimeException)throwable;
	}
	
	public static synchronized void setOutStream(
		PrintStream ps
	)
	{
		out=ps;
	}
	
}
