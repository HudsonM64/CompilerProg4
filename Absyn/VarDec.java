package Absyn;
import Symbol.Symbol;
public class VarDec extends Decl {
   public Symbol name;
   public boolean escape = false;
   public NameTy typ; /* optional */
   public Exp init;
   public VarDec(int p, Symbol n, NameTy t, Exp i) {pos=p; name=n; typ=t; init=i;}
   public Semant.VarEntry entry;
}
