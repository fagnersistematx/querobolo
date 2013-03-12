/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EventosMouse;

import GUI.Enuns.TipoControllerMouse;
import GUI.TelaAjuda;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner
 */
public class ClickAjuda implements MouseListener {

    private TipoControllerMouse tipoControllerMouse;

    public ClickAjuda(TipoControllerMouse tipoControllerMouse) {
        this.tipoControllerMouse = tipoControllerMouse;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (tipoControllerMouse == TipoControllerMouse.AJUDA) {
            TelaAjuda telaAjuda = new TelaAjuda();
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_DORMINDO_COZINHEIRO) {
            JOptionPane.showMessageDialog(null, ESTADO_DORMINDO,"Dormindo", 3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_ESPERANDO_COZINHEIRO) {
            JOptionPane.showMessageDialog(null, ESTADO_ESPERANDO, "Esperando",3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_EXECUCAO_COZINHEIRO) {
            JOptionPane.showMessageDialog(null, ESTADO_EXECUCAO, "Em execução", 3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_INICIADA_COZINHEIRO) {
            JOptionPane.showMessageDialog(null, ESTADO_INICIADA, "Iniciada", 3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_NOVA_COZINHEIRO) {
            JOptionPane.showMessageDialog(null, ESTADO_NOVA, "Nova",3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_TERMINADA_COZINHEIRO) {
            JOptionPane.showMessageDialog(null,ESTADO_TERMINADA, "Terminada",3);
        }

        //MÃE
        if (tipoControllerMouse == TipoControllerMouse.ESTADO_DORMINDO_MAE) {
            JOptionPane.showMessageDialog(null, ESTADO_DORMINDO,"Dormindo", 3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_ESPERANDO_MAE) {
            JOptionPane.showMessageDialog(null, ESTADO_ESPERANDO, "Esperando",3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_EXECUCAO_MAE) {
            JOptionPane.showMessageDialog(null, ESTADO_EXECUCAO, "Em execução", 3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_INICIADA_MAE) {
            JOptionPane.showMessageDialog(null, ESTADO_INICIADA, "Iniciada", 3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_NOVA_MAE) {
            JOptionPane.showMessageDialog(null, ESTADO_NOVA, "Nova",3);
        }

        if (tipoControllerMouse == TipoControllerMouse.ESTADO_TERMINADA_MAE) {
            JOptionPane.showMessageDialog(null,ESTADO_TERMINADA, "Terminada",3);
        }

    }
    private static final String ESTADO_NOVA = "Uma thread encontra-se nesse estado quando \num objeto para a thread é criado.";
    private static final String ESTADO_EXECUCAO = "Quando o método run() de uma thread é chamado, a mesma \npassa do estado iniciada para o estado executável.";
    private static final String ESTADO_ESPERANDO = "Uma thread entra no estado esperando, se realizar uma instrução de bloqueio seja ela \npor E/S ou se invocado certos métodos da classe Thread do Java, como wait().";
    private static final String ESTADO_TERMINADA = "Uma thread passa para o estado de terminada \nquando seu método run() é concluído.";        
    private static final String ESTADO_INICIADA = "Uma thread encontra-se nesse estado quando \num objeto para a thread é instanciado.";
    private static final String ESTADO_DORMINDO = "Uma thread está nesse estado quando \num o método sleep() é chamado.";
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
}
