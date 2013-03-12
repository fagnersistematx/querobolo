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
public class ControleInterfaceMensagemMae extends Thread {

    private boolean cond = true;
    private int tempoEspera = 500;
    private Tela tela;
    private int quantEspera = 0;

    public ControleInterfaceMensagemMae(Tela tela) {
        this.tela = tela;       
    }

    @Override
    public void run() {
        new ControleMensagem(TipoMensagem.INICIAR_MAE, tela);
        while (cond) {
            try {
                sleep(tempoEspera);
                
                if (ControleThreads.getMae().getState() == State.WAITING && !ControleThreads.getMae().isPausa() && quantEspera == 0 ) {
                    
                    tela.getLbFalaMae().setLocation((tela.getLbFalaMae().getX() - 300) , tela.getLbFalaMae().getY());
                    new ControleMensagem(TipoMensagem.ESPERA_MAE, tela);
                    ++this.quantEspera;
                    
                }                
            } catch (Exception erro) {
            }
        }
    }
    
}
