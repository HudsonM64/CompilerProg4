package Semant;

import ErrorMsg.ErrorMsg;
import Symbol.Symbol;
import Symbol.Table;
import Types.NAME;
import Types.RECORD;
import Types.Type;
import Types.VOID;

class Env {
   Table venv;
   Table tenv;
   ErrorMsg errorMsg;
   private static final VOID VOID;

   static {
      VOID = Semant.VOID;
   }

   Env(ErrorMsg err) {
      this.errorMsg = err;
      this.venv = new Table();
      this.tenv = new Table();
      NAME INT = new NAME(sym("int"));
      INT.bind(Semant.INT);
      this.tenv.put(sym("int"), INT);
      NAME STRING = new NAME(sym("string"));
      STRING.bind(Semant.STRING);
      this.tenv.put(sym("string"), STRING);
      this.venv.put(sym("print"), FunEntry(RECORD(sym("s"), STRING), VOID));
      this.venv.put(sym("flush"), FunEntry((RECORD)null, VOID));
      this.venv.put(sym("getchar"), FunEntry((RECORD)null, STRING));
      this.venv.put(sym("ord"), FunEntry(RECORD(sym("s"), STRING), INT));
      this.venv.put(sym("chr"), FunEntry(RECORD(sym("i"), INT), STRING));
      this.venv.put(sym("size"), FunEntry(RECORD(sym("s"), STRING), INT));
      this.venv.put(sym("substring"), FunEntry(RECORD(sym("s"), STRING, RECORD(sym("first"), INT, RECORD(sym("n"), INT))), STRING));
      this.venv.put(sym("concat"), FunEntry(RECORD(sym("s1"), STRING, RECORD(sym("s2"), STRING)), STRING));
      this.venv.put(sym("not"), FunEntry(RECORD(sym("i"), INT), INT));
      this.venv.put(sym("exit"), FunEntry(RECORD(sym("i"), INT), VOID));
   }

   private static FunEntry FunEntry(RECORD f, Type r) {
      return new FunEntry(f, r);
   }

   private static RECORD RECORD(Symbol n, Type t) {
      return new RECORD(n, t, (RECORD)null);
   }

   private static RECORD RECORD(Symbol n, Type t, RECORD x) {
      return new RECORD(n, t, x);
   }

   private static Symbol sym(String s) {
      return Symbol.symbol(s);
   }
}