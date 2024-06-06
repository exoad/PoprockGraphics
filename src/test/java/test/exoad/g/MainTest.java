package test.exoad.g;
import pkg.exoad.g.G;
import pkg.exoad.g.Struct;
import pkg.exoad.g.debug.Dbg;
final class MainTest
{
	public static void main(String... args)
	{
		G.ensureEngineInitialized();
		Dbg.push("Test",Struct.pair("Hello",13));
		Dbg.panic(new IllegalArgumentException("Amogus"),
				  "Yuh");
	}
}
