package one.digitalinnovation.web.desafio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MainProcessadorBlog {

    public static void main(String[] args) throws IOException {

        System.out.println();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        StringTokenizer st = new StringTokenizer(br.readLine(), "\n");
        StringBuilder frase = new StringBuilder("");

        System.out.printf("[?] BufferedReader br: [%s].%n", br.readLine());

        while (st.hasMoreElements()) {

            String value = st.nextToken()
                    .trim()
                    .toLowerCase();

            if (value.equals(".\n")) {
                System.out.printf("%n[?] = = = FINAL DE PROCESSAMENTO DO BLOG.  = = = %n", br.readLine());
                break;
            }

            if (value.length() <= 0) continue;

            value
                    .replaceAll("\n", " ")
                    .replaceAll("\t", " ");

            System.out.printf("[?] Token: [%s].%n", value);
            frase.append(value).append(" ");
        }

        processador(frase.toString());

    }

    static private void processador(String frase) {
        System.out.printf("[?] Inicio do processamento: [%s].%n", frase);

        List<String> alfabeto = new ArrayList(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
        List<String> palavrasEncontradas = new ArrayList(Arrays.asList(frase.split(" ")));
        System.out.printf("[?] Quantidade de palavras na frase: %d%n", palavrasEncontradas.size());

        Map<String, String> dicionario = new HashMap<String, String>();
        alfabeto.stream().forEach(letra -> dicionario.put(letra, ""));
        System.out.printf("[?] Dicionario possui %d chaves.%n", dicionario.size());

        Map<String, Map<String, Integer>> repeticaoPalavra = new HashMap<String, Map<String, Integer>>();
        alfabeto.stream().forEach(letra -> repeticaoPalavra.put(letra, new HashMap<String, Integer>()));

        palavrasEncontradas
                .stream()
                .filter( palavra -> null != palavra && palavra.length() > 0)
                .forEach(palavra -> {
                    Map<String, Integer> dicionarioStringInteger = repeticaoPalavra.get(palavra.substring(0, 1));
                    if (null != dicionarioStringInteger) dicionarioStringInteger.put(palavra, 0);
        });

        palavrasEncontradas
                .stream()
                .filter( palavra -> null != palavra && palavra.length() > 0)
                .forEach(palavra -> {
            Map<String, Integer> palavraChaveComQuantidade = repeticaoPalavra.get(palavra.substring(0, 1));

            if (null != palavraChaveComQuantidade) {
                Integer value = palavraChaveComQuantidade.get(palavra);
                if (null != value) {
                    palavraChaveComQuantidade.put(palavra, 1 + Integer.valueOf(value).intValue());
                    System.out.printf("[?] Palavra chave e quantidade [%s]-[%d].%n", palavra, palavraChaveComQuantidade.get(palavra));
                }
            }
        });

        System.out.printf("[?] %n");
        alfabeto.stream().forEach(letra -> {
            Map<String, Integer> map = repeticaoPalavra.get(letra);
            List<String> chaves = new ArrayList<String>(map.keySet());

            int qtTotalCharPorLetra = 0;

            for (String chave : chaves) {
                qtTotalCharPorLetra += map.get(chave) * chave.length();
            }

            int qtTotalCharMelhorCenario;
            int qtTotalCharMelhorCenarioAux = 10000;

            for (String chave : chaves) {
                qtTotalCharMelhorCenario = (qtTotalCharPorLetra - (map.get(chave) * chave.length())) + (map.get(chave) * 2);

                if ((qtTotalCharMelhorCenarioAux > qtTotalCharMelhorCenario) && chave.length() > 2) {
                    qtTotalCharMelhorCenarioAux = qtTotalCharMelhorCenario;
                    dicionario.put(letra, chave);
                }
            }
        });

        String fraseAbreviada = palavrasEncontradas
                .stream()
                .filter( palavra -> null != palavra && palavra.length() > 0)
                .map(palavra -> {
                    String valor = "";
                    String primeiraLetra = palavra.substring(0, 1);
                    if (alfabeto.contains(primeiraLetra)) {
                        valor = dicionario.get(primeiraLetra).equals(palavra) ? primeiraLetra + "." : palavra;
                    }
                    return valor;
                })
                .collect(Collectors.joining(" "));

        resultado(alfabeto, dicionario, fraseAbreviada);

    }

    private static void resultado(List<String> alfabeto, Map<String, String> dicionario, String fraseAbreviada) {
        System.out.println("[?] Resultado do processamento:");
        System.out.println(fraseAbreviada);

        int quantidadeAbreviacoes = 0;
        for (String letra : alfabeto) {
            if (!dicionario.get(letra).equals("")) {
                quantidadeAbreviacoes++;
            }
        }

        System.out.println(quantidadeAbreviacoes);

        alfabeto.stream().forEach(letra -> {
            if (!dicionario.get(letra).equals("")) {
                System.out.println(letra + ". = " + dicionario.get(letra));
            }
        });
    }


}