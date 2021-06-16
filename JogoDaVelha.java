import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha
{
    static ArrayList<Integer> posicoesDoJogador = new ArrayList<Integer>();
    static ArrayList<Integer> posicoesDoPc = new ArrayList<Integer>();
    
    
    public static void main(String[] args) 
    {
        char[][] tabela = {{' ', '|', ' ', '|', ' '}, //tabela
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '}};

        
        exemploTabela();
        while (true) 
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Coloque um numero entre (1-9)");
            int inputJogada = sc.nextInt();
            
            while (posicoesDoJogador.contains(inputJogada) || posicoesDoPc.contains(inputJogada)) 
            {
                System.out.println("Essa casa ja tem um simbolo, escolha outra");    
            }
            colocarSimbolo(tabela, inputJogada, "jogador");
            
            String resultado = VerificarCampeao();
            if(resultado.length() > 0)
            {
                System.out.println(resultado);
                break;
            }

            Random randomico = new Random();
            int cpuJogada = randomico.nextInt(9) + 1;
            while(posicoesDoJogador.contains(cpuJogada) || posicoesDoPc.contains(cpuJogada))
            {
                cpuJogada = randomico.nextInt(9) + 1;
            }
            colocarSimbolo(tabela, cpuJogada, "pc");
            
            desenhar(tabela);
            
            resultado = VerificarCampeao();
            if(resultado.length() > 0)
            {
                System.out.println(resultado);
                break;
            }
            System.out.println(resultado);
        }
        

    }
    public static void colocarSimbolo(char[][] tabela, int inputJogada, String jogadorOuPc)
    {
        char simbolo = ' ';
        if(jogadorOuPc.equals("jogador"))
        {
            simbolo = 'X';
            posicoesDoJogador.add(inputJogada);
        }else if(jogadorOuPc.equals("pc"))
        {
            simbolo = 'O';
            posicoesDoPc.add(inputJogada);
        }
        switch (inputJogada) {
            case 1:
                tabela [0] [0] = simbolo;
                break;
            case 2:
                tabela [0] [2] = simbolo;
                break;
            case 3:
                tabela [0] [4] = simbolo;
                break;
            case 4:
                tabela [2] [0] = simbolo;
                break;
            case 5:
                tabela [2] [2] = simbolo;
                break;
            case 6:
                tabela [2] [4] = simbolo;
                break;
            case 7:
                tabela [4] [0] = simbolo;
                break;
            case 8:
                tabela [4] [2] = simbolo;
                break;
            case 9:
                tabela [4] [4] = simbolo;
                break;
            default:
                System.out.println("Entre com numeros entre 1-9");
                break;
        }
    }
    public static String VerificarCampeao()
    {
        List horinzontal1 = Arrays.asList(1, 2, 3);
        List horinzontal2 = Arrays.asList(4, 5, 6);
        List horinzontal3 = Arrays.asList(7, 8, 9);
        List vertical1 = Arrays.asList(1, 4, 7);
        List vertical2 = Arrays.asList(2, 5, 8);
        List vertical3 = Arrays.asList(3, 6, 9);
        List cruz1 = Arrays.asList(1, 5, 9);
        List cruz2 = Arrays.asList(3, 5, 7);

        List<List> vencer = new ArrayList<List>();
        vencer.add(horinzontal1);
        vencer.add(horinzontal2);
        vencer.add(horinzontal3);
        vencer.add(vertical1);
        vencer.add(vertical2);
        vencer.add(vertical3);
        vencer.add(cruz1);
        vencer.add(cruz2);

        for(List l : vencer)
        {
            if(posicoesDoJogador.containsAll(l))
            {
                return "Parabens voce ganhou o jogo da velha";
            }else if(posicoesDoPc.containsAll(l))
            {
                return "Infelizmente voce perdeu pro PC";
            }else if(posicoesDoJogador.size() + posicoesDoPc.size() == 9)
            {
                return "jogo deu velha, empatou";
            }
        }
        
        return "";
    }
    public static void desenhar(char[][] tabela) //imprimir tabela
    {
        for(char[] fila : tabela)
        {
            for(char c : fila)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    static void exemploTabela()
    {
        System.out.println();
        System.out.println("1" +  "|"
                           + "2" + "|" + "3"
                           );
        System.out.println("-+-+-");
        System.out.println("4" +   "|"
                           +"5" + "|" + "6"
                           );
        System.out.println("-+-+-");
        System.out.println("7" + "|"
                           + "8" + "|" + "9"
                           );
        System.out.println();
    }
    /*private JogoDaVelha()
    {
        Mapa jogoMapa = new Mapa();
        //PC jogoPC = new PC(jogoMapa);
        //Jogador jogoJogador = new Jogador(jogoMapa);
    }

   /* private void jogar(Scanner sc)
    {
        
    }
    */
}