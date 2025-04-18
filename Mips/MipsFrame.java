package Mips;
import java.util.Hashtable;
import Symbol.Symbol;
import Temp.Temp;
import Temp.Label;
import Frame.Frame;
import Frame.Access;
import Frame.AccessList;

public class MipsFrame extends Frame {

  private int count = 0;
  private int offset = 0;
  public Frame newFrame(Symbol name, Util.BoolList formals) {
    Label label;
    if (name == null)
      label = new Label();
    else if (this.name != null)
      label = new Label(this.name + "." + name + "." + count++);
    else
      label = new Label(name);
    return new MipsFrame(label, formals);
  }

  public MipsFrame() {}
  private MipsFrame(Label n, Util.BoolList f) {
    name = n;
  }

  private static final int wordSize = 4;
  public int wordSize() { return wordSize; }

  public Access allocLocal(boolean escape) { 
    if (escape) {
      this.offset -= 4;
      return new InFrame(this.offset);
    }
    else {
      return new InReg(new Temp());
    }
  }

  private AccessList allocFormals(int offset, Util.BoolList formals) {
      if (formals == null) {
         return null;
      } else {
         Object a;
         if (formals.head) {
            a = new InFrame(offset);
         } else {
            a = new InReg(new Temp());
         }

         return new AccessList((Access)a, this.allocFormals(offset + 4, formals.tail));
      }
   }
   
}
