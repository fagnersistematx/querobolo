/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EventosMouse;

import Controle.ControleThreads;
import GUI.Enuns.TipoControllerMouse;
import GUI.Tela;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Fagner
 */
public class VelocidadeControleDeslizante implements ChangeListener {

    private Tela tela;
    private TipoControllerMouse tipoControllerMouse;

    public VelocidadeControleDeslizante(Tela tela, TipoControllerMouse tipoControllerMouse) {
        this.tela = tela;
        this.tipoControllerMouse = tipoControllerMouse;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (tipoControllerMouse == TipoControllerMouse.VELOCIDADE_MAE) {
            ControleThreads.getMae().setVelocidade(tela.getVelocidadeMae().getValue());
        }
        if (tipoControllerMouse == TipoControllerMouse.VELOCIDADE_COZINHEIRO) {
            ControleThreads.getCozinheiro().setVelocidade(tela.getVelocidadeCozinheiro().getValue());
        }
    }
}
