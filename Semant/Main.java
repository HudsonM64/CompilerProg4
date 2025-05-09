package Semant;
import java.io.PrintWriter;
import Parse.Parse;

public class Main {
  static Frame.Frame frame = new Mips.MipsFrame();

  public static void main(String argv[])  {
    for (int i = 0; i < argv.length; ++i) {
      String filename = argv[i];
      if (argv.length > 1)
	System.out.println("***Processing: " + filename);
      Parse parse = new Parse(filename);
      Semant semant = new Semant(parse.errorMsg);
      semant.transProg((Absyn.Exp)parse.absyn);
      PrintWriter writer = new PrintWriter(System.out);
      Absyn.Print printer = new Absyn.Print(writer);
      printer.prExp((Absyn.Exp)parse.absyn, 0);
      writer.println();
      writer.flush();
    }
  }
}
