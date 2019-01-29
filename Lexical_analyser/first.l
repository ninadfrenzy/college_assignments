%{
	#include <stdio.h>
	int word_count = 0;
	int line_count = 0; 

%}
%%
import {printf("%s is a keyword\n",yytext);}
[a-zA-Z"."]+"*" {printf("%s is a package name\n",yytext);}
; {printf("%s is a delimiter name\n",yytext);}
"=" {printf("%s is a assignment operator\n",yytext);}
"+"|"-"|"*"|"/" {printf("%s is a operator\n",yytext);}
"public"|"static"|"main"|"void"|"String"|"int"|"System"|"out"|"println" {printf("%s is a keyword name\n",yytext);}
"("|")"|"{"|"}"|"["|"]" {printf("%s is a bracket\n",yytext);}
" "|"\t" {printf("whitespace\n");word_count++;}
\"[a-zA-Z|" "]+\" {printf("%s is a string\n",yytext);}
[a-zA-Z]+ {printf("%s is a identifier\n",yytext);}
[0-9]+ {printf("%s is a constant number\n",yytext);}
\. {printf("%s dot\n",yytext);}
"\n" {line_count++;}
%%
int main()
{
	yyin = fopen("Sum.java","r");
	printf("\n\t\tLEXICAL ANALYSIS OF JAVA PROGRAM\n");
	yylex();
	printf("\nNUMBER OF WORDS : %d\n\n",word_count);
	printf("\NUMBER OF LINES : %d\n\n",line_count);
	return 1;
}
int yywrap()
{
	return 1;
}
