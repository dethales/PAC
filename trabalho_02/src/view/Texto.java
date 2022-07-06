package view;

import java.util.ArrayList;
import java.util.HashMap;
import model.Pergunta;
import model.Recorde;
import model.Resposta;

public final class Texto
{
    public static final void imprimePergunta(Pergunta p)
    {
	System.out.println(p.getTexto());
    }
    
    public static final void imprimeRespostas(Pergunta p)
    {
	for(Resposta r: p.getRespostas())
	{
	    System.out.println("\t" + r.getRotulo() + ") " + r.getTexto());
	}
    }
    
    public static final void imprimePerguntaCompleta(Pergunta p)
    {
        imprimePergunta(p);
        imprimeRespostas(p);
    }
    
    public static final void imprimeTudo(HashMap<Integer, Pergunta> perguntas)
    {
	for(Pergunta p: perguntas.values())
	{
	    imprimePerguntaCompleta(p);
	}
    }
    /*
    public static final void imprimeMenu()
    {
        System.out.println("Bem vindo ao jogo!");
        System.out.println("Digite a opção desejada");
        System.out.println("1 - Novo Jogo");
        System.out.println("2 - Recordes");
        System.out.println("0 - Sair");
    }
    */
    
    public static void imprimePerguntaNomeJogador()
    {
        System.out.println("Qual é o seu nome?");
    }
    
    public static void imprimeOpcoesJogador(int pulos)
    {
        System.out.println("\n\tp - Pular (" + (pulos > 0 ? (pulos + " pulos") : ("nenhum pulo")) + ")");
        System.out.println("\t0 - Sair");
    }
    
    public static void imprimeRecordes(ArrayList<Recorde> recordes)
    {
        System.out.println("\tTop 5");
        System.out.println("Nome\t\tPontuacao\n");
        for(Recorde r: recordes)
        {
            System.out.println(r.getNome() + "\t\t" + r.getPontuacao());
        }
        System.out.println();
    }
}
