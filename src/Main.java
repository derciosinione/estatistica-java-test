import java.util.Scanner;

public class Main {
    private static int[] dadosMes;
    private static int totalDadosRecolhidos;
    private static int totalSituacao1;
    private static int totalSituacao2;
    private static int totalSituacao3;
    private static int totalDiasSemRecolhas;
    private static int melhorDia;
    private static int piorDia;
    private static int indexPiorDia;
    private static int indexMelhorDia;


    public static void main(String[] args) {

//        dadosMes = new int[]{ 44, 188,  -1,  8, 41, 41, 3, 31,  4, 88, 8, 81, 84, 88, 38, 46, 66, -1, 66, 63, 44, 44, 68, 44, 14, 38, 61, 84, 41, 81, 46};

        dadosMes = new int[] { -1, 11, 46, 4, 88, 18, 84, 41, 66, 46, -1, 6, 11, 41, 6, 44, 48, 33, 64, -3, 13, 11, 64, 81, 84, 48, 81, 44, 14, 88, -3};

        Scanner scanner = new Scanner(System.in);
        String decisao;

        do {

            MostrarEstatistica();
            System.out.print("Ver estatísticas novamente? (S-Sim, ESC=fim)? ");
            decisao = scanner.next();

            if (decisao.equalsIgnoreCase("F") || decisao.equalsIgnoreCase("FIM")) {
                break;
            }

        } while (decisao.equalsIgnoreCase("sim") || decisao.equalsIgnoreCase("s"));

        System.out.println("FIM");
    }

    private static void ProcessarDados() {
        totalDadosRecolhidos = 0;
        totalSituacao1 = 0;
        totalSituacao2 = 0;
        totalSituacao3 = 0;
        melhorDia = 0;
        piorDia = Integer.MAX_VALUE;
        indexPiorDia = 0;
        indexMelhorDia = 0;
        totalDiasSemRecolhas = 0;
        int index = 0;

        for (int valorRecolhido : dadosMes) {
            index++;

            if (valorRecolhido < 0) {
                CalcularSituacaoSemRecolha(valorRecolhido);
                continue;
            }

            // 12 14
            // Achar o melhor dia e a sua posição
            if (valorRecolhido > melhorDia) {
                melhorDia = valorRecolhido;
                indexMelhorDia = index;
            }

            // Achar o pior dia e a sua posição
            if (valorRecolhido < piorDia) {
                piorDia = valorRecolhido;
                indexPiorDia = index;
            }

            totalDadosRecolhidos += valorRecolhido;
        }
    }

    private static void CalcularSituacaoSemRecolha(int valor) {
        totalDiasSemRecolhas++;

        switch (valor) {
            case -1:
                totalSituacao1++;
                break;
            case -2:
                totalSituacao2++;
                break;
            case -3:
                totalSituacao3++;
                break;
        }
    }

    private static void MostrarEstatistica() {

        ProcessarDados();

        int totalDiasComRecolha = dadosMes.length - totalDiasSemRecolhas;

        double mediaValoresComRecolha = (double) totalDadosRecolhidos / totalDiasComRecolha;

        System.out.println();
        System.out.println("total de dados recolhidos: " + totalDadosRecolhidos);
        System.out.println("total de dias em que ocorreu a situação #1: " + totalSituacao1);
        System.out.println("total de dias em que ocorreu a situação #2: " + totalSituacao2);
        System.out.println("total de dias em que ocorreu a situação #3: " + totalSituacao3);
        System.out.println("total de dias sem recolha de dados: " + totalDiasSemRecolhas);
        System.out.printf("Média de valores válidos recolhidos: %.1f \n", mediaValoresComRecolha);
        System.out.printf("Melhor dia: %d com %d \n", indexMelhorDia, melhorDia);
        System.out.printf("Pior dia: %d com %d \n\n", indexPiorDia, piorDia);
    }

}