package model;

public abstract class ItemDeCadastro
{
    protected final int id;
    protected final String texto;
    
    protected ItemDeCadastro(int id, String texto)
    {
	this.id = id;
	this.texto = texto;
    }
    
    public final int getID()
    {
	return id;
    }

    public final String getTexto()
    {
	return texto;
    }
    
    public final void imprimeTexto()
    {
	System.out.println(texto);
    }
}
