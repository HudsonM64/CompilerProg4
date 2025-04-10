package Absyn;

public class ForExp extends Exp {
   public VarDec var;
   public Exp hi;
   public Exp body;

   public ForExp(int p, VarDec v, Exp h, Exp b) {
      super.pos = p;
      this.var = v;
      this.hi = h;
      this.body = b;
   }
}