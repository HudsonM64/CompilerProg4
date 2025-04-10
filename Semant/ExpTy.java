package Semant;

import Translate.Exp;
import Types.Type;

class ExpTy {
   Exp exp;
   Type ty;

   ExpTy(Exp e, Type t) {
      this.exp = e;
      this.ty = t;
   }
}