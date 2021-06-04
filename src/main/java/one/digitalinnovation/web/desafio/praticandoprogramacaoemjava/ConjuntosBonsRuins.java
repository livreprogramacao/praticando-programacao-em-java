/**
 * Conjuntos bons ou ruins?
 * <p>
 * Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou
 * ruim. Por definição, um conjunto é bom quando nenhuma palavra desse conjunto é
 * um prefixo de outra palavra. Caso contrário, é considerado um conjunto ruim.
 * <p>
 * Por exemplo, {dbc, dae, dbcde} é um conjunto ruim, pois dbc é um prefixo de
 * dbcde. Quando duas palavras são idênticas, definimos como uma sendo prefixo
 * da outra.
 * <p>
 * - Entrada
 * <p>
 * A entrada contém vários casos de teste. A primeira linha de cada caso de teste
 * terá um inteiro N (1 ≤ N ≤ 10⁵), que representa a quantidade de palavras no
 * conjunto. Segue então N linhas, cada uma tendo uma palavra de no máximo 100
 * letras minúsculas. A entrada termina quando N = 0 e não deve ser processada.
 * <p>
 * - Saída
 * <p>
 * Para cada caso de teste, você deverá imprimir "Conjunto Bom", ou "Conjunto
 * Ruim", conforme explicado acima.
 */

package one.digitalinnovation.web.desafio.praticandoprogramacaoemjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConjuntosBonsRuins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int qualquerNumeroInteiroN = Integer.parseInt(br.readLine());

        while (qualquerNumeroInteiroN != 0) {

            List<String> conjunto = new ArrayList<>();

            for (int i = 0; i < qualquerNumeroInteiroN; i++) {
                conjunto.add(br.readLine());
            }

            conjunto = conjunto.stream().sorted().collect(Collectors.toList());
            String saida = "Conjunto Bom";

            for (int i = 0; i < qualquerNumeroInteiroN - 1; i++) {
                if (conjunto.get(i + 1).startsWith(conjunto.get(i))) {
                    saida = "Conjunto Ruim";
                }
            }

            System.out.printf("%s%n", saida);
            qualquerNumeroInteiroN = Integer.valueOf(br.readLine());
        }
    }
}
