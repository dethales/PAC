package controller;

public final class Main
{
    public static void main(String[] args)
    {
        LauncherJogo launcher = new LauncherJogo();
        
        launcher.load();
        launcher.newGame();
        launcher.encerraJogo();
    }
}