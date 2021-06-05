/**
 * Encontre a maior substring
 * <p>
 * Encontre a maior substring comum entre as duas strings informadas.
 * A substring pode ser qualquer parte da string, inclusive ela toda. Se não
 * houver subsequência comum, a saída deve ser “0”. A comparação é case sensitive
 * ('x' != 'X').
 * <p>
 * - Entrada
 * <p>
 * A entrada contém vários casos de teste. Cada caso de teste é composto por duas
 * linhas, cada uma contendo uma string. Ambas strings de entrada contém entre 1
 * e 50 caracteres ('A'-'Z','a'-'z' ou espaço ' '), inclusive, ou no mínimo uma
 * letra ('A'-'Z','a'-'z').
 * <p>
 * - Saída
 * <p>
 * O tamanho da maior subsequência comum entre as duas Strings.
 */

import java.util.Scanner;

public class EncontreAMaiorSubstring {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String primeira;
        String segunda;

        while (scr.hasNextLine()) {
            primeira = scr.nextLine();
            segunda = scr.nextLine();
            int tamanhoMax = 0;

            if (segunda.length() > primeira.length()) {
                String maiorPalavra = segunda;
                segunda = primeira;
                primeira = maiorPalavra;
            }

            for (int i = 0; i < segunda.length(); i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (primeira.contains(segunda.substring(j, segunda.length() - i + j))) {
                        tamanhoMax = Math.max(tamanhoMax, segunda.length() - i);
                    }
                }
            }

            System.out.println(tamanhoMax);
        }
    }
}
