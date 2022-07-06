package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Input
{
    private static final Input input = new Input();
    
    private Input()
    {
        this.teclado = new Scanner(System.in);
    }
    
    public static Input getInput()
    {
        return input;
    }
    
    private final Scanner teclado;
    
    public String pegaNomeJogador()
    {
        return teclado.next();
    }
    
    public Scanner getTeclado()
    {
        return teclado;
    }
    
    public char pegaOpcaoJogador(Cronometro c)
    { 
        char opcao;
        opcao = teclado.next().toLowerCase().charAt(0);

        if(opcao != 'a' && opcao != 'b' && opcao != 'c' &&
           opcao != 'd' && opcao != 'p' && opcao != '0')
        {
            throw new InputMismatchException();
        }
        else if(c.getAcabou())
        {
            teclado.close();
        }
            return opcao;
    }
}