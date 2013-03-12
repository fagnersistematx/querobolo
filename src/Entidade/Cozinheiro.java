package Entidade;

import Controle.Interface.ControleInterface;

/**
 *
 * @author Fagner Silva,fagner.silva@dce.ufpb.br
 * @version 1.0
 *
 */
public class Cozinheiro extends Thread {

    private int posicao;
    private static int velocidade;
    private boolean encontrouBolo;
    private boolean pausa;
    private static final int POSICAO_DO_BOLO = 99;
    private static final int POSICAO_DA_MESA = 420;
    
    public Cozinheiro(int posicao, int velocidade,boolean encontrouBolo, boolean pausa){
        Cozinheiro.velocidade = velocidade;
        this.posicao = posicao;
        this.encontrouBolo = encontrouBolo;
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
        if (!deixarBoloNaMesa()) {
            this.posicao += velocidade;
            ControleInterface.rePaintCozinheiro(posicao, encontrouBolo);
        }
    }
    
    // Método pata mãe andar para esquerda.
    private void andarEsquerda() {
        if (pausa) {
            pausarThreadCozinheiro();
        }
        if (peguarBolo()) {
            this.posicao -= velocidade;
            ControleInterface.rePaintCozinheiro(posicao, encontrouBolo);
        }
    }
    
    //Método para confirma a posição do bolo.
    private boolean peguarBolo() {
        if (this.posicao > POSICAO_DO_BOLO && !encontrouBolo) {
            return true;
        } else {
            this.encontrouBolo = true;
            this.andarDireita();
            return false;
        }
    }
    
    //Método para confirma a posição da mesa.
    private boolean deixarBoloNaMesa() {
        if (this.posicao > POSICAO_DA_MESA) {
            return true;
        } else {
            return false;
        }
    }
    
    //Método para adormece e atrasar o progresso da thread.
    private void dormi() {
        try {
            
            sleep(5 * 50);
           
        } catch (InterruptedException ex) {
            System.err.println("Erro ao dormi thread cozinheiro.");
        }
    }

    //Método para pausar Thread do cozinheiro. 
    private void pausarThreadCozinheiro() {
        try {
            synchronized (this) {
                System.err.println("Wait");
                super.wait();
            }
        } catch (InterruptedException ex) {
            System.err.println("Erro ao pausar thread do cozinheiro.");
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
}
