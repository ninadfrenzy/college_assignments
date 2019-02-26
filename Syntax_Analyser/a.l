%{
	#include "y.tab.h"

%}
%%
^[A-Z][a-z]+ {printf("hyo subject ");return SUBJECT;}
^a-z+ing$ {printf("ha verb e");return VERB;}
[a-z]+ {return OBJECT;}
"\n" {return yytext[0];}
" " {printf("spc");}
%%
int main()
{
	yylex();
}
int yywrap()
{
	return 1;
}
