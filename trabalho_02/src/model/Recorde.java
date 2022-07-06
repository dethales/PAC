package model;

public final class Recorde implements Comparable<Recorde>
{
    private final String nome;
    private final long pontuacao;
    
    public Recorde(Jogador j)
    {
        nome = j.getNome();
        pontuacao = j.getMoney();
    }
    
    public Recorde(String nome, int money)
    {
        this.nome = nome;
        this.pontuacao = money;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public long getPontuacao()
    {
        return pontuacao;
    }
    
    @Override
    public String toString()
    {
        return nome + " " + pontuacao;
    }

    @Override
    public int compareTo(Recorde outroRecorde)
    {
        if(this.pontuacao < outroRecorde.getPontuacao())
        {
            return -1;
        }
        if(this.pontuacao > outroRecorde.getPontuacao())
        {
            return 1;
        }
        return 0;
    }
}