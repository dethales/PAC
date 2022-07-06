package model;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public final class Pergunta extends ItemDeCadastro
{
    private final ArrayList<Resposta> respostas;
    private final TipoDePergunta tipo;

    public Pergunta(int id, String texto, TipoDePergunta tipo)
    {
        super(id, texto);
        respostas = new ArrayList<>(4);
        this.tipo = tipo;
    }
    
    public void addResposta(Resposta resposta)
    {
        respostas.add(resposta);
    }
    
    public List<Resposta> getRespostas()
    {
	return Collections.unmodifiableList(new ArrayList<Resposta>(respostas));
    }
    
    public TipoDePergunta getTipo()
    {
        return this.tipo;
    }
    
    public char RespostaCerta()
    {
        for(Resposta r: respostas)
        {
            if(r.getTipo() == TipoDeResposta.CERTA)
                return r.getRotulo();
        }
        return '0';
    }
}