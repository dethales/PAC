package model;

public class Jogador 
{
    private long money;
    private final String nome;
    private char escolha;
    private int numPulos;
    private EstagioNoJogo estagio;
    
    public Jogador(String nome)
    {
	this.nome = nome;
	this.money = 0;
        this.escolha = '0';
        this.numPulos = 3;
        estagio = EstagioNoJogo.INICIO;
    }

    Jogador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getMoney()
    {
	    return money;
    }

    public void setMoney(int money)
    {
	    this.money = money;
    }
    
    public void atualizaStatusJogador(int numRodada)
    {
        if(numRodada <= 4)
            this.money += 5000;
        else if(numRodada == 5)
            this.money += 30000;
        else if(numRodada == 6)
        {
            this.money += 50000;
            estagio = EstagioNoJogo.MEIO;
        }
        else if(numRodada <= 9)
            this.money += 100000;
        else if(numRodada == 10)
        {
            this.money += 100000;
            estagio = EstagioNoJogo.FIM;
        }
        else if(numRodada == 11)
            this.money += 500000;
        else
            this.money += 1000000;  
    }
    
    public String getNome()
    {
	return nome;
    }
    
    public char getEscolha()
    {
        return escolha;
    }
    
    public void setEscolha(char novoEscolha)
    {
        this.escolha = novoEscolha;
    }
    
    public int getNumPulos()
    {
        return numPulos;
    }
    
    public void decrementaPulos()
    {
        if(numPulos > 0)
            numPulos--;
    }
    
    public EstagioNoJogo getEstagioJogo()
    {
        return estagio;
    }
}