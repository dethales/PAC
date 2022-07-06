package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import model.EstagioNoJogo;
import model.Jogador;
import model.Jogo;
import model.Recorde;
import model.Rodada;
import view.Texto;

public class LauncherJogo
{
    Jogo jogo = new Jogo();
    GerenciaDeDados gerencia = GerenciaDeDados.getInstancia();
    Input in = Input.getInput();
    Output out = Output.getOutput();
    Jogador player1;
    
    public LauncherJogo() { }
    
    public void load()
    {
        gerencia.inserirDados(jogo);
        
        out.perguntaNomeJogador();
        //player1 = new Jogador(in.pegaNomeJogador());
        player1 = new Jogador("Thales");
        System.out.println("Entendido, o seu nome é " + player1.getNome());
        jogo.embaralhaQuestionario();
        
        Recorde r = new Recorde(player1);
        //Texto.imprimeRecordes(jogo.getHighScores());
    }
    
    public void newGame()
    {
        ArrayList<Integer> listaChaves = new ArrayList<>(jogo.getQuestionario().keySet());

        for(int chave: listaChaves.subList(0, 20))
        {
            EstagioNoJogo estagioAnteriorJogo = player1.getEstagioJogo();
            proxRodada(new Rodada(jogo.getQuestionario().get(chave)));
            if(estagioAnteriorJogo != player1.getEstagioJogo())
                break;
        }
        for(int chave: listaChaves.subList(21, 40))
        {
            EstagioNoJogo estagioAnteriorJogo = player1.getEstagioJogo();
            proxRodada(new Rodada(jogo.getQuestionario().get(chave)));
            if(estagioAnteriorJogo != player1.getEstagioJogo())
                break;
        }
        for(int chave: listaChaves.subList(41, 60))
        {
            EstagioNoJogo estagioAnteriorJogo = player1.getEstagioJogo();
            proxRodada(new Rodada(jogo.getQuestionario().get(chave)));
            if(estagioAnteriorJogo != player1.getEstagioJogo())
                break;
        }
    }
    
    public void proxRodada(Rodada rodadaAtual)
    {
        out.imprimePerguntaRodada(rodadaAtual.getPerguntaAtual());
        out.imprimeOpcoesJogador(player1.getNumPulos());
        
        System.out.println(rodadaAtual.getNumRodada());
        System.out.println("Resposta Certa: " + rodadaAtual.getPerguntaAtual().RespostaCerta());
        
        Cronometro cronometro = new Cronometro();
        Thread t1 = new Thread(cronometro);
        t1.start();
        while(!cronometro.getAcabou())
        {
            try {
                player1.setEscolha(in.pegaOpcaoJogador(cronometro));
                break;
            } catch(InputMismatchException e) {
                System.out.println("Opcao Invalida");
            }
        }
        if(cronometro.getAcabou())
        {
            System.out.println("Acabou o tempo, pressione qq tecla para sair");
            encerraJogo();
        }
        t1.interrupt();
        rodadaAtual.setEscolhaJogador(player1);        
        
        
        if(player1.getEscolha() == '0')
        {
            encerraJogo();
        }
        else if(player1.getEscolha() == 'p')
        {
            if(player1.getNumPulos() > 0)
                player1.decrementaPulos();
            else
            {
                System.out.println("Acabaram os seus pulos");
                proxRodada(rodadaAtual);
            }
        }
        else if(player1.getEscolha() == rodadaAtual.getPerguntaAtual().RespostaCerta())
        {
            System.out.println("Resposta Certa");
            player1.atualizaStatusJogador(rodadaAtual.getNumRodada());
            System.out.println(player1.getMoney());
        }
        else
        {
            System.out.println("Resposta Errada");
            encerraJogo();
        }
    }
    
    public void encerraJogo()
    {
        Recorde rec = new Recorde(player1);
        jogo.addRecorde(rec);
        System.out.println("O seu capital foi " + rec.getPontuacao());
        System.out.println(jogo.getHighScores());
        System.out.println(jogo.getHighScores().size());
        Texto.imprimeRecordes(jogo.getHighScores());
        System.out.println("Salvando Recordes...");
        gerencia.saveGame(jogo);
        System.out.println("Saindo do Jogo...");
        System.exit(0);
    }
}
