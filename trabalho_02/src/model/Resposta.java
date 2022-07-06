package model;

public final class Resposta extends ItemDeCadastro
{
    public final TipoDeResposta tipo;
    private final char rotulo;
    
    public Resposta(int id, boolean correta, String texto, char rotulo, TipoDeResposta tipo)
    {
        super(id, texto);
	this.rotulo = rotulo;
        this.tipo = tipo;
    }
    
    public char getRotulo()
    {
	return rotulo;
    }
    
    public TipoDeResposta getTipo()
    {
        return tipo;
    }
}