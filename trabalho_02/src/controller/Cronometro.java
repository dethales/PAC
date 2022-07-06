package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cronometro extends LauncherJogo implements Runnable
{
    private int tempo;
    private boolean acabou;
    
    public Cronometro()
    {
        tempo = 5;
        acabou = false;
    }
    
    public int getTempo()
    {
        return tempo;
    }
    
    public boolean getAcabou()
    {
        return acabou;
    }
    
    @Override
    public void run()
    {
        while(tempo > 0)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                Thread.interrupted();
            }
            tempo--;
            
            System.out.print(tempo + " ");
        }
        acabou = true;
        Input.getInput().getTeclado().close();
        encerraJogo();
    }
}