%{
	#include <stdio.h>
%}
%token SUBJECT VERB OBJECT
%%
S : SUBJECT '\n' {printf("WORKS");}

%%
int main()
{
	yyparse();
	return 0;
}
yyerror (char const *s) {
   fprintf (stderr, "%s\n", s);
 }
