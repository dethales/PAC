package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Jogo
{
    private final HashMap<Integer, Pergunta> questionario;
    private final ArrayList<Recorde> highScores;

    public Jogo()
    {
        highScores = new ArrayList<>(5);
        questionario = new HashMap<>();
    }
    
    public void addPergunta(int chave, Pergunta valor)
    {
        questionario.put(chave, valor);
    }

    public HashMap<Integer, Pergunta> getQuestionario()
    {
        return questionario;
    }
    
    public void addRecorde(Recorde r)
    {  
        highScores.add(r);
        Collections.sort(highScores, Collections.reverseOrder());
        if(highScores.size() > 5)
        {
            highScores.remove(5);
        }
    }
    
    public ArrayList<Recorde> getHighScores()
    {
        return highScores;
    }

    public void embaralhaQuestionario()
    {
        ArrayList<Pergunta> listaPerguntas = new ArrayList<>(questionario.values());
        Collections.shuffle(listaPerguntas.subList(0, 20));
        Collections.shuffle(listaPerguntas.subList(21, 40));
        Collections.shuffle(listaPerguntas.subList(41, 60));
        Iterator<Pergunta> iteradorPerguntas = listaPerguntas.iterator();
        
        for(Map.Entry<Integer, Pergunta> entrada: questionario.entrySet())
        {
            entrada.setValue(iteradorPerguntas.next());
        }
    }
}
