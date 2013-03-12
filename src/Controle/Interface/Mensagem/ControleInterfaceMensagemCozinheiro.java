/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Interface.Mensagem;

import Controle.ControleThreads;
import GUI.Enuns.TipoMensagem;
import GUI.Tela;

/**
 *
 * @author Fagner
 */
public class ControleInterfaceMensagemCozinheiro extends Thread {

    private int tempoEspera = 500;
    private Tela tela;
    private int quantEspera = 0;

    public ControleInterfaceMensagemCozinheiro(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void run() {       
            try {
                
                //Com a mãe.
                if (ControleThreads.getMae().getState() == State.WAITING && !ControleThreads.getMae().isPausa()) {
                    
                    new ControleMensagem(TipoMensagem.INICIAR_COZINHEIRO_COM_MAE, tela);                    
                    
                } else{
                     new ControleMensagem(TipoMensagem.INICIAR_COZINHEIRO_SEM_MAE, tela); 
                }               
            } catch (Exception erro) {
            }
        
    }
    
}
