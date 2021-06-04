package one.digitalinnovation.web.desafio.aritimeticosemjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainDivisores {

    public static void main(String[] args) throws IOException {

        final String delimitador = " ";
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine(), delimitador);

        //declare suas variaveis
        final int divisor = Integer.parseInt(st.nextToken());
        final int naoEdivisor = Integer.parseInt(st.nextToken());
        final int multiplo = Integer.parseInt(st.nextToken());
        final int naoEmultiplo = Integer.parseInt(st.nextToken());
        br.close();

        /**
         *
         *
         * d,nd,m,nm = input().split()
         * d,nd,m,nm = int(d),int(nd),int(m),int(nm)
         * resultado = -1
         * if(d!=nd and m!=nm):
         *     fim = m
         *     inicio = d
         *     while(inicio<=fim):
         *         if(inicio%d==0 and inicio%nd!=0 and m%inicio==0 and nm%inicio!=0):
         *             resultado = inicio
         *             break
         *         inicio+=d
         * print(resultado)
         *
         */

        //declare suas variaveis com o valor correto
        int resultado = 0;

        //continue o codigo
        if ( divisor!=naoEdivisor && multiplo!=naoEmultiplo ){

            int fim = multiplo;
            int inicio = divisor;

            while (inicio <=fim) {
                boolean condicao =
                        inicio%divisor==0 && inicio%naoEdivisor!=0 &&
                        multiplo%inicio==0 && naoEdivisor%inicio!=0;
                break;
            }

        }

        System.out.println();

    }

}