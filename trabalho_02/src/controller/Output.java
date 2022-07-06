package controller;

import model.Pergunta;
import view.Texto;

public final class Output
{
    private static final Output output = new Output();
    
    private Output() {}
    
    public static Output getOutput()
    {
        return output;
    }

    public void perguntaNomeJogador()
    {
        Texto.imprimePerguntaNomeJogador();
    }
    
    public void imprimePerguntaRodada(Pergunta p)
    {
        Texto.imprimePerguntaCompleta(p);
    }
    
    public void imprimeOpcoesJogador(int pulos)
    {
        Texto.imprimeOpcoesJogador(pulos);
    }
    
}