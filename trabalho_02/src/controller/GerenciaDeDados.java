package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jogador;

import model.Jogo;
import model.Pergunta;
import model.Resposta;
import model.TipoDePergunta;
import model.TipoDeResposta;
import model.Recorde;

public final class GerenciaDeDados
{
    private static final GerenciaDeDados gerencia = new GerenciaDeDados();

    private GerenciaDeDados() {}

    public static GerenciaDeDados getInstancia()
    {
            return gerencia;
    }

    public void inserirDados(Jogo jogo)
    {
        String linha;
        String[] palavras;
        int id;
        String texto;
        boolean correta;
        Pergunta p;
        Resposta r;
        Recorde recorde;
        int j = 0;
        
        BufferedReader leitorP = null;
        BufferedReader leitorR = null;
        BufferedReader leitorRecordes = null;
        try {
            leitorP = new BufferedReader(new FileReader("perguntas.txt"));
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            leitorR = new BufferedReader(new FileReader("respostas.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            leitorRecordes = new BufferedReader(new FileReader("recordes.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while((linha = leitorP.readLine()) != null)
            {
                palavras = linha.split(" ", 2);
                
                id = Integer.parseInt(palavras[0]);
                texto = palavras[1];
                
                j++;
                if(j < 20)
                    p = new Pergunta(id, texto, TipoDePergunta.FACIL);
                else if(j < 40)
                    p = new Pergunta(id, texto, TipoDePergunta.MEDIA);
                else if(j < 60)
                    p = new Pergunta(id, texto, TipoDePergunta.DIFICIL);
                else
                    p = new Pergunta(id, texto, TipoDePergunta.INDEFINIDO);
                
                for(int i = 0; i < 4; i++)
                {
                    linha = leitorR.readLine();
                    palavras = linha.split(" ", 3);
                    
                    id = Integer.parseInt(palavras[0]);
                    correta = palavras[1].startsWith("1");
                    texto = palavras[2];
                    if(correta)
                        r = new Resposta(id, correta, texto, (char)(i + 'a'), TipoDeResposta.CERTA);
                    else
                        r = new Resposta(id, correta, texto, (char)(i + 'a'), TipoDeResposta.ERRADA);
                    
                    p.addResposta(r);
                }
                
                jogo.addPergunta(p.getID(), p);
            }
        } catch (IOException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while((linha = leitorRecordes.readLine()) != null)
            {
                palavras = linha.split(" ", 2);
                texto = palavras[0]; //nome recordista
                id = Integer.parseInt(palavras[1]); // pontuacao recordista
                
                recorde = new Recorde(texto, id);
                
                jogo.addRecorde(recorde);
            }
        } catch (IOException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    private void CarregaRecordes()
//    {
//        String linha;
//        String[] palavras;
//        BufferedReader leitorRecordes = null;
//        
//        
//        try {
//            while((linha = leitorRecordes.readLine()) != null)
//            {
//                palavras = linha.split(" ", 2);
//                texto = palavras[0]; //nome recordista
//                id = Integer.parseInt(palavras[1]); // pontuacao recordista
//                
//                recorde = new Recorde(texto, id);
//                
//                jogo.addRecorde(recorde);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void saveGame(Jogo j)
    {
        BufferedWriter writer = null;
        String linha;
        
        try {
            writer = new BufferedWriter(new FileWriter("recordes.txt", false));
        } catch (IOException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            writer.write("");
        } catch (IOException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            writer = new BufferedWriter(new FileWriter("recordes.txt", false));
        } catch (IOException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            for(Recorde r: j.getHighScores())
            {
                linha = r.toString() + "\n";
                
                writer.write(linha);
            }
        } catch(IOException ex) {
            Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(GerenciaDeDados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}