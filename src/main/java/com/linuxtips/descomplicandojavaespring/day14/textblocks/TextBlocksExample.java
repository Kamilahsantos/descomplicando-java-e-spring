package com.linuxtips.descomplicandojavaespring.day14.textblocks;

//veio no Java 15
// forma de declararmos Strings com várias linhas com mais eficiencia e de modo mais clean
public class TextBlocksExample {

    public static void main(String[] args) {

        String sqlAntesDoJava15 =
                "  SELECT id, nome, sobrenome\n"
                        + "    FROM estudante\n"
                        + "   WHERE linguagem = \"Java\"\n"
                        + "ORDER BY nome";


        System.out.println(sqlAntesDoJava15);


        String sqlDepoisDoJava15 = """
                  SELECT id, nome, sobrenome
                    FROM estudante
                   WHERE linguagem = "Java"
                ORDER BY nome""";


        System.out.println(sqlDepoisDoJava15);

    }
}
