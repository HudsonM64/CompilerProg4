package Absyn;

import Symbol.Symbol;

public class ArrayTy extends Ty {
   public Symbol typ;

   public ArrayTy(int p, Symbol t) {
      super.pos = p;
      this.typ = t;
   }
}