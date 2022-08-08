import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        //array bidimensional 3 x 3 para representar a tabela
        char[][] jogoVelha = new char[3][3];

        System.out.println("Jogador 1 = X");
        System.out.println("Jogador 2 = O");

        boolean ganhou = false;
        int jogada = 1;
        char sinal;
        int linha = 0;
        int coluna = 0;

        while (!ganhou){

            //se o numero da jogada for impar , entao a vez de joga sera o jogador !
            if(jogada % 2 == 1){
                System.out.println("Vez do Jogador 1 , Escolha Linha e coluna (1-3)");
                sinal = 'X';
            } else {
                System.out.println("Vez do Jogador @ , Escolha Linha e coluna (1-3)");
                sinal = 'O';
            }

            boolean linhaValida = false;

            //verificamos os valores que o usuario vai digitar nas linhas
            while (!linhaValida){
                System.out.println("Entre com a linha (1 -2 - 3)");
                linha = scaner.nextInt();

                if(linha >=1 && linha <=3){
                    linhaValida = true;
                }
                else {
                    System.out.println("Entrada Invalida , Tente novamente");
                }
            }

            boolean colunaValida = false;

            //verificamos os valores que o usuario vai digitar nas COLUNAS
            while (!colunaValida){
                System.out.println("Entre com a coluna (1 -2 - 3)");
                coluna = scaner.nextInt();

                if(coluna >=1 && coluna <=3){
                    colunaValida = true;
                }
                else {
                    System.out.println("Entrada Invalida , Tente novamente");
                }
            }
            //como nosso array tem 3 posiçoes mas começa do zero, decrementamos os valores para ser igual a logica
            // 3 é 2
            // 2 é 1
            // 1 é 0
            linha--;
            coluna--;

            //verifica se a posicao que o usuario inseriu esta em uso
            if (jogoVelha [linha][coluna] == 'X' || jogoVelha [linha][coluna] == 'O'){
                System.out.println("posicao ja usada ! tente novamente" );

                //caso esteja em branco o caractere referente ao usuario sera adcionado a tabela
            } else {
                jogoVelha[linha][coluna] = sinal;
                jogada++;
            }

            for(int i=0 ; i < jogoVelha.length;i++){
                for (int j =0 ;j<jogoVelha[i].length; j++){
                    System.out.print(jogoVelha[i][j] + " | ");
                }
                System.out.println();
            }

            if (    (jogoVelha[0][0] == 'X' && jogoVelha[0][1] == 'X' && jogoVelha[0][2] == 'X' ) || //linha 1
                    (jogoVelha[1][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[1][2] == 'X' ) || //linha 2
                    (jogoVelha[2][0] == 'X' && jogoVelha[2][1] == 'X' && jogoVelha[2][2] == 'X' ) || //linha 3

                    (jogoVelha[0][0] == 'X' && jogoVelha[1][0] == 'X' && jogoVelha[2][0] == 'X' ) || //coluna 1
                    (jogoVelha[0][1] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][1] == 'X' ) || //coluna 2
                    (jogoVelha[0][2] == 'X' && jogoVelha[1][2] == 'X' && jogoVelha[2][2] == 'X' )  ||//coluna 3

                    (jogoVelha[0][0] == 'X' && jogoVelha[1][1] == 'X' && jogoVelha[2][2] == 'X' ))  //diagonal
            {
                ganhou = true;
                System.out.println("Parabens Jogador 1 Ganhou !");

            }

            else if (    (jogoVelha[0][0] == 'O' && jogoVelha[0][1] == 'O' && jogoVelha[0][2] == 'O' ) || //linha 1
                    (jogoVelha[1][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[1][2] == 'O' ) || //linha 2
                    (jogoVelha[2][0] == 'O' && jogoVelha[2][1] == 'O' && jogoVelha[2][2] == 'O' ) || //linha 3

                    (jogoVelha[0][0] == 'O' && jogoVelha[1][0] == 'O' && jogoVelha[2][0] == 'O' ) || //coluna 1
                    (jogoVelha[0][1] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][1] == 'O' ) || //coluna 2
                    (jogoVelha[0][2] == 'O' && jogoVelha[1][2] == 'O' && jogoVelha[2][2] == 'O' )  ||//coluna 3

                    (jogoVelha[0][0] == 'O' && jogoVelha[1][1] == 'O' && jogoVelha[2][2] == 'O' ))  //diagonal

            {
                ganhou = true;
                System.out.println("Parabens Jogador 2 Ganhou !");
            }else if(jogada > 9){
                ganhou = true;
                System.out.println("ninguem ganhou :/ !");
            }
        }
    }
    }
