/* 1. Package e importaciones*/
package Language;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import Components.ErrorL;

%%
/* 2. Configuraciones para el analisis (Operaciones y Declaraciones) */
%{
    public ArrayList<ErrorL> errors = new ArrayList<ErrorL>();
    void addError(int line,int column,String character) {
        errors.add(new ErrorL(line,column,character));
    }
%}

// Directivas
%class Scanner
%public
%cupsym Terminal
%cup
%char
%column
%full
%line
%unicode

// Constructor
%init{
    yyline = 1;
    yychar = 1;
%init}

// Expresiones regulares
UNUSED = [ \r\t]+ // caracteres que se omiten
OPERACION = \" "Operacion" \"
NUMBER = [0-9]+(\.[0-9]+)?
/*
VALOR1 = \" "Valor1" \"
VALOR2 = \" "Valor2" \"
*/

%%

/* 3. Reglas Semanticas */
{UNUSED}                                        {}
\""Operacion"\"                                 {return new Symbol(Terminal.PR_Operacion,yyline,yychar,yytext());}
\""Valor1"\"                                    {return new Symbol(Terminal.PR_Valor1,yyline,yychar,yytext());}
\""Valor2"\"                                    {return new Symbol(Terminal.PR_Valor2,yyline,yychar,yytext());}
\""Suma"\"                                      {return new Symbol(Terminal.PR_Suma,yyline,yychar,yytext());}
\""Resta"\"                                     {return new Symbol(Terminal.PR_Resta,yyline,yychar,yytext());}
\""Multiplicacion"\"                            {return new Symbol(Terminal.PR_Multiplicacion,yyline,yychar,yytext());}
\""Division"\"                                  {return new Symbol(Terminal.PR_Division,yyline,yychar,yytext());}
\""Potencia"\"                                  {return new Symbol(Terminal.PR_Potencia,yyline,yychar,yytext());}
\""Raiz"\"                                      {return new Symbol(Terminal.PR_Raiz,yyline,yychar,yytext());}
\""Inverso"\"                                   {return new Symbol(Terminal.PR_Inverso,yyline,yychar,yytext());}
\""Seno"\"                                      {return new Symbol(Terminal.PR_Seno,yyline,yychar,yytext());}
\""Coseno"\"                                    {return new Symbol(Terminal.PR_Coseno,yyline,yychar,yytext());}
\""Tangente"\"                                  {return new Symbol(Terminal.PR_Tangente,yyline,yychar,yytext());}
\""Mod"\"                                       {return new Symbol(Terminal.PR_Mod,yyline,yychar,yytext());}
{NUMBER}                                        {return new Symbol(Terminal.TK_Num,yyline,yychar,yytext());}
"{"                                             {return new Symbol(Terminal.TK_KeyO,yyline,yychar,yytext());}
"}"                                             {return new Symbol(Terminal.TK_KeyC,yyline,yychar,yytext());}
"["                                             {return new Symbol(Terminal.TK_BrackO,yyline,yychar,yytext());}
"]"                                             {return new Symbol(Terminal.TK_BrackC,yyline,yychar,yytext());}
","                                             {return new Symbol(Terminal.TK_Comma,yyline,yychar,yytext());}
":"                                             {return new Symbol(Terminal.TK_Colon,yyline,yychar,yytext());}
\n                                              {yychar = 1;}
.                                               {addError(yyline,yychar,yytext());}