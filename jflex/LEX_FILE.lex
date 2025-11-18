import java_cup.runtime.*;

%%

%class Lexer
%cup
%line
%column
%cupsym TokenNames
%state COMMENT_STATE

%{
  /*********************************************************************************/
  /* Create a new java_cup.runtime.Symbol with information about the current token */
  /*********************************************************************************/
  private Symbol symbol(int type)               { return new Symbol(type, yyline, yycolumn); }
  private Symbol symbol(int type, Object value) { return new Symbol(type, yyline, yycolumn, value); }

  /*******************************************/
  /* Enable line number extraction from main */
  /*******************************************/
  public int getLine() { return yyline + 1; } 

  /**********************************************/
  /* Enable token position extraction from main */
  /**********************************************/
  public int getTokenStartPosition() { return yycolumn + 1; } 

  /********************************/
  /* Lexical Error Helper Method */
  /*******************************/
  private void throwLexicalError() { throw new Error("ERROR"); }
%}

/***********************/
/* MACRO DECLARATIONS */
/***********************/
LineTerminator = \r|\n|\r\n
WhiteSpace     = [ \t\f]
Digit          = [0-9]
Letter         = [a-zA-Z]
ID             = {Letter}({Letter}|{Digit})*

INT            = [0-9]{Digit}*
STRING         = \"{Letter}*\"

// Updated: Added comma to allowed COMMENT characters
COMMENT_CHARS  = ({Letter}|{Digit}|{WhiteSpace}|[\(\)\[\]\{\}\?\!\+\-\*\/\.\;\<\>])

COMMENT1       = \/\/{COMMENT_CHARS}*{LineTerminator}

%%

<YYINITIAL> {
  /* KEYWORDS */
  "class"     { return symbol(TokenNames.CLASS); }
  "nil"       { return symbol(TokenNames.NIL); }
  "array"     { return symbol(TokenNames.ARRAY); }
  "while"     { return symbol(TokenNames.WHILE); }
  "int"       { return symbol(TokenNames.TYPE_INT); }
  "string"    { return symbol(TokenNames.TYPE_STRING); }
  "void"      { return symbol(TokenNames.TYPE_VOID); }
  "extends"   { return symbol(TokenNames.EXTENDS); }
  "return"    { return symbol(TokenNames.RETURN); }
  "new"       { return symbol(TokenNames.NEW); }
  "if"        { return symbol(TokenNames.IF); }
  "else"      { return symbol(TokenNames.ELSE); }

  /* SYMBOLS */
  "("         { return symbol(TokenNames.LPAREN); }
  ")"         { return symbol(TokenNames.RPAREN); }
  "["         { return symbol(TokenNames.LBRACK); }
  "]"         { return symbol(TokenNames.RBRACK); }
  "{"         { return symbol(TokenNames.LBRACE); }
  "}"         { return symbol(TokenNames.RBRACE); }
  "+"         { return symbol(TokenNames.PLUS); }
  "-"         { return symbol(TokenNames.MINUS); }
  "*"         { return symbol(TokenNames.TIMES); }
  "/"         { return symbol(TokenNames.DIVIDE); }
  ","         { return symbol(TokenNames.COMMA); }
  "."         { return symbol(TokenNames.DOT); }
  ";"         { return symbol(TokenNames.SEMICOLON); }
  ":="        { return symbol(TokenNames.ASSIGN); }
  "="         { return symbol(TokenNames.EQ); }
  "<"         { return symbol(TokenNames.LT); }
  ">"         { return symbol(TokenNames.GT); }

  /* VALUES */
{INT} {
    String text = yytext();
    try {
        int val = Integer.parseInt(text);
        if (val < 0 || val > 32767)
            throwLexicalError();
        return symbol(TokenNames.INT, val);
    } catch (NumberFormatException e) {
        throwLexicalError();
        return null; 
    }
}

  // Strings now strip quotes properly
  {STRING} {
            return symbol(TokenNames.STRING, yytext());
        }

  {ID} { return symbol(TokenNames.ID, yytext()); }

  /* COMMENTS */
  {COMMENT1}  {  }

  "/*"        { yybegin(COMMENT_STATE); }

  /* WHITESPACE */
  {WhiteSpace}        { }
  {LineTerminator}    { }



  /* ERROR: any other mismatch */
  .                 { throwLexicalError(); }
}

<COMMENT_STATE> {
  "*/"        { yybegin(YYINITIAL); }
  <<EOF>>     { throwLexicalError(); }   // Unclosed comment now handled correctly
  {COMMENT_CHARS} { }
  .           { throwLexicalError(); }
}

/* END OF FILE */
<<EOF>> { return symbol(TokenNames.EOF); }
