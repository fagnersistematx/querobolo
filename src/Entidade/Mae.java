package Entidade;

import Controle.Interface.ControleInterface;

/**
 *
 * @author Fagner Silva, fagner.silva@dce.ufpb.br
 * @version 1.0
 *
 */
public class Mae extends Thread {

    private static int posicao;
    private static int velocidade;
    private boolean pausa;
    private static boolean encontrouBolo;
    private static final int POSICAO_DO_BOLO = 620;
    private static final int POSICAO_DA_MESA = 960;

    public Mae(int posicao, int velocidade, boolean encontrouBolo, boolean pausa){
        Mae.posicao = posicao;
        Mae.velocidade = velocidade;
        Mae.encontrouBolo = encontrouBolo;
        this.pausa = pausa;
    }
    
    
    @Override
    public void run() {       
        while (!deixarBoloNaMesa()) {
            this.dormi();
            this.andarEsquerda();
        }
    }

    // Método pata mãe andar para direita. 
    private void andarDireita() {
        if (!ControleInterface.isBoloEntregue()) {
            pausarThreadMae();
        }
        if (!deixarBoloNaMesa()) {
            posicao += velocidade;
            ControleInterface.rePaintMae(posicao, encontrouBolo);
        }
    }

    // Método pata mãe andar para esquerda.
    private void andarEsquerda() {
        if(pausa){
            pausarThreadMae();
        }
        if (peguarBolo()) {
            posicao -= velocidade;
            ControleInterface.rePaintMae(posicao, encontrouBolo);
        }
    }

    //Método para confirma a posição do bolo.
    private boolean peguarBolo() {
        if (posicao > POSICAO_DO_BOLO && !encontrouBolo) {
            return true;
        } else {
            encontrouBolo = true;
            this.andarDireita();
            return false;
        }
    }

    //Método para confirma a posição da mesa.
    private boolean deixarBoloNaMesa() {
        if (posicao > POSICAO_DA_MESA) {
            return true;
        } else {
            return false;
        }
    }

    //Método para adormece/atrasar o progresso da thread.
    private void dormi() {
        try {
            sleep(5 * 50);
        } catch (InterruptedException ex) {
            System.err.println("Erro ao dormi thread mãe.");
        }
    }

    //Método para pausar o progresso da thread.
    private void pausarThreadMae() {
        try {
            synchronized (this) {
                super.wait();
            }
        } catch (InterruptedException ex) {
            System.err.println("Erro ao esperar thread mãe.");
        } catch (Exception ex) {
            System.err.println("Erro ao esperar thread mãe.");
        }
    }

    /*
     *
     * GETs AND SETs
     *
     */
    public static int getVelocidade() {
        return velocidade;
    }

    public static void setVelocidade(int veloc) {
        velocidade = veloc / 10;
    }
    
    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public void setEncontrouBolo(boolean encontrouBolo) {
        Mae.encontrouBolo = encontrouBolo;
    }
    
}
