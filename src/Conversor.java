import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Passo 1: Impressão do menu.
        for( int i = 0; i < 40; i++){
            System.out.print("-");
        }
        System.out.println("Bem vindo ao Conversor de Moedas!");
        System.out.println("""
                1) Dolar Canadense para Real.
                2) Real para Dolar Canadense.
                3) Dolar Canadense para Euro.
                4) Euro para Peso Chileno.
                5) Real para Yen.
                6) Real para Pesos Argentinos.
                7) Sair.
                """);

        // Passo 2: entrada dos dados e selecao.
            CurrencyPair pair = new CurrencyPair();

            System.out.println("Digite o número da conversão desejada: ");
            Scanner entrada = new Scanner(System.in);
            int optionNumber = entrada.nextInt();

            switch (optionNumber) {
                case 1:
                    pair.setBase_code("CAD");
                    pair.setTarget_code("BRL");
                    break;
                case 2:
                    pair.setBase_code("BRL");
                    pair.setTarget_code("CAD");
                    break;
                case 3:
                    pair.setBase_code("CAD");
                    pair.setTarget_code("EUR");
                    break;
                case 4:
                    pair.setBase_code("CLP");
                    pair.setTarget_code("EUR");
                    break;
                case 5:
                    pair.setBase_code("BRL");
                    pair.setTarget_code("JPY");
                    break;
                case 6:
                    pair.setBase_code("BRL");
                    pair.setTarget_code("ARS");
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    break;
            }
        System.out.println("Digite o valor que deseja converter: ");
        double coinValue = entrada.nextDouble();

        // Passo 3: Consumo da API, Deserializacao.
        ApiGet getApi = new ApiGet(pair.getBase_code(), pair.getTarget_code());

        Gson gson = new Gson();
        pair = gson.fromJson(getApi.getJson(), CurrencyPair.class);

        // Passo 4 Impressão do resultado
        System.out.println("Codigo da Moeda Origem: "+ pair.getBase_code());
        System.out.println("Codigo da Moeda Destino: "+ pair.getTarget_code());
        System.out.println("Valor a ser convertido: "+ coinValue);
        System.out.println("Resultado: "+ coinValue*pair.getConversionRate());
    }
}
