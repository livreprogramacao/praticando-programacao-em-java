/**
 * Entrevista embaraçosa
 * <p>
 * A nutricionista Juliana Alcantra é uma excelente profissional de sua área.
 * Em determinado dia, ela foi entrevistada ao vivo para um jornal da cidade. No
 * entanto, ficou um pouco nervosa na hora, e diante da situação, sua fala ficou
 * um pouco distorcida, repetindo o final de cada palavra após dizer a mesma. Para
 * que isso não aconteça novamente, ela precisa da sua ajuda para escrever um
 * programa que omita a parte repetida, de modo que as palavras sejam pronunciadas
 * como deveriam ser.
 * <p>
 * Escreva um programa que, dada uma palavra errada, a mesma seja corrigida.
 * <p>
 * - Entrada
 * <p>
 * Haverá diversos casos de teste. Cada caso de teste é formado por uma palavra,
 * de, no máximo, 30 caracteres, dita da forma errada. A entrada termina com fim
 * de arquivo.
 * <p>
 * - Saída
 * <p>
 * Para cada caso de teste, escreva a palavra devidamente corrigida. Analise os
 * exemplos para verificar o padrão, de modo a consertar todos os casos.
 */

package one.digitalinnovation.web.desafio.praticandoprogramacaoemjava;

import java.util.Scanner;

public class EntrevistaEmbaracosa {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String entrada = scanner.nextLine();
            Integer limite = (int) Math.floor(entrada.length() / 2);
            Integer termino = entrada.length();
            Integer auxiliar = 0;

            if (entrada.length() == 1) {
                System.out.println(entrada);
            } else if (limite >= 1) {
                for (int i = limite; i >= 1; i--) {
                    if (entrada.substring(termino - i, termino).equals(entrada.substring(termino - (2 * i), termino - i))) {
                        auxiliar = i;
                        System.out.println(entrada.substring(0, (termino - auxiliar)));
                    } else if (limite == 1) {
                        System.out.println(entrada);
                    }
                }

                if (limite > 1 && auxiliar == 0) System.out.println(entrada);
            }
        }
        scanner.close();
    }
}
