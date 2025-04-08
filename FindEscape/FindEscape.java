package FindEscape;

import Symbol.Table;

public class FindEscape {
  Symbol.Table escEnv = new Symbol.Table(); // escEnv maps Symbol to Escape

  private Absyn.FunctionDec currentFun = null;

  public FindEscape(Absyn.Exp e) { traverseExp(0, e);  }

  void traverseVar(int depth, Absyn.Var v) {
    
  }

  void traverseExp(int depth, Absyn.Exp e) {
    if (e == null) return;

  }

  void traverseDec(int depth, Absyn.Decl d) {
    if (d instanceof Absyn.VarDec) {
         this.traverseDec(depth, (Absyn.VarDec)d);
      } else if (d instanceof Absyn.FunctionDec) {
         this.traverseDec(depth, (Absyn.FunctionDec)d);
      }
  }
}
