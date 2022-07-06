package model;

public class Rodada
{
    public char escolhaJogador;
    private final Pergunta perguntaAtual;
    private static int numRodada = 0;
    
    public Rodada(Pergunta p)
    {
        escolhaJogador = '0';
        perguntaAtual = p;
        numRodada++;
    }
    
    public boolean verificaAcertou(Jogador j)
    {
        return perguntaAtual.RespostaCerta() == j.getEscolha();
    }
    
    public void setEscolhaJogador(Jogador j)
    {
        escolhaJogador = j.getEscolha();
    }
    
    public char getEscolhaJogador()
    {
        return escolhaJogador;
    }
    
    public Pergunta getPerguntaAtual()
    {
        return perguntaAtual;
    }
    
    public int getNumRodada()
    {
        return numRodada;
    }
}
