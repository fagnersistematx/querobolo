
package GUI.EventosMouse;

import Controle.Interface.ControleInterface;
import Controle.ControleThreads;
import GUI.Enuns.TipoControllerMouse;
import GUI.Tela;
import Util.ConfiguracaoPausarIniciar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner
 */
public class MouseBotao implements ActionListener {

    private Tela tela;
    private TipoControllerMouse tipoControllerMouse;

    public MouseBotao(Tela tela, TipoControllerMouse tipoControllerMouse) {
        this.tela = tela;
        this.tipoControllerMouse = tipoControllerMouse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {      

        if (TipoControllerMouse.INICIAR_THREAD_MAE == tipoControllerMouse) {

            int iniciarPausarMae = ConfiguracaoPausarIniciar.getIniciarPausarMae();
            
            if (iniciarPausarMae == 0) {
                
                ControleInterface.ModificarBotaoIniciarMae();
                ControleThreads.inciarThreadMae();
                ConfiguracaoPausarIniciar.setIniciarPausarMae(++iniciarPausarMae);
                
            } else if (iniciarPausarMae == 1) {
                
                ControleInterface.ModificarBotaoPausarMae();
                ControleThreads.getMae().setPausa(true);
                
                ConfiguracaoPausarIniciar.setIniciarPausarMae(++iniciarPausarMae);
                
            } else if (iniciarPausarMae == 2) {
                
                ControleInterface.ModificarBotaoIniciarMae();
                ControleThreads.getMae().setPausa(false);
                synchronized (ControleThreads.getMae()) {
                    ControleThreads.getMae().notify();
                }
                ConfiguracaoPausarIniciar.setIniciarPausarMae(--iniciarPausarMae);
                
            }
        }
        if (TipoControllerMouse.INICIAR_THREAD_COZINHEIRO == tipoControllerMouse) {
            
            int iniciarPausarCozinheiro = ConfiguracaoPausarIniciar.getIniciarPausarCozinheiro();

            if (iniciarPausarCozinheiro == 0) {
                
                ControleInterface.ModificarBotaoIniciarCozinheiro();
                ControleThreads.inciarThreadCozinheiro();
                ConfiguracaoPausarIniciar.setIniciarPausarCozinheiro(++iniciarPausarCozinheiro);
                
            } else if (iniciarPausarCozinheiro == 1) {
                
                ControleInterface.ModificarBotaoPausarCozinheiro();
                ControleThreads.getCozinheiro().setPausa(true);
                ConfiguracaoPausarIniciar.setIniciarPausarCozinheiro(++iniciarPausarCozinheiro);
                
            } else if (iniciarPausarCozinheiro == 2) {
                
                ControleInterface.ModificarBotaoIniciarCozinheiro();
                ControleThreads.getCozinheiro().setPausa(false);
                synchronized (ControleThreads.getCozinheiro()) {
                    ControleThreads.getCozinheiro().notify();
                }
                ConfiguracaoPausarIniciar.setIniciarPausarCozinheiro(--iniciarPausarCozinheiro);
                
            }
        }
        if (TipoControllerMouse.REINICIAR == tipoControllerMouse) {
            tela.setVisible(false);
            ControleThreads controleThreads = new ControleThreads();
            controleThreads.pararThreadsMaeCozinheiro();
            tela.getBtReiniciarParar().setVisible(true);
        }

        tela.getBtReiniciarParar().setVisible(true);
        
        
        // Ao clicar no primeiro botão de tela de ajuda executara esta condição.
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_UM) {
            
            JOptionPane.showMessageDialog(null,msn, "O que é uma thread?",1);
            
        }
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_DOIS) {
            JOptionPane.showMessageDialog(null, "ESTADO_DORMINDO_COZINHEIRO");
        }
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_TRES) {
            JOptionPane.showMessageDialog(null, "ESTADO_DORMINDO_COZINHEIRO");
        }
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_QUATRO) {
            JOptionPane.showMessageDialog(null, "ESTADO_DORMINDO_COZINHEIRO");
        }  
    }
    
    private static final String msn = "  Thread é uma forma de um processo dividir a si mesmo \n"
                    + "em  duas  ou  mais tarefas que podem ser  executadas \n"
                    + "concorrentemente.  O suporte  à  thread é  fornecido \n"
                    + "pelo próprio sistema operasional.";
}
