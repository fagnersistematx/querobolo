/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EventosMouse;

import GUI.Enuns.TipoControllerMouse;
import GUI.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Fagner
 */
public class EventosCaixaSelecaoMouse implements ActionListener {

    private Tela tela;
    private TipoControllerMouse tipoControleMouse;
    private boolean acaoCaixaSelecaoCozinheiro = true;
    private boolean acaoCaixaSelecaoMae = true;

    public EventosCaixaSelecaoMouse(Tela tela, TipoControllerMouse tipoControleMouse) {
        this.tela = tela;
        this.tipoControleMouse = tipoControleMouse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean condAcaoCozinheio = false;
        boolean condAcaoMae = false;
        
        if (tipoControleMouse == TipoControllerMouse.CAIXA_SELECAO_COZINHEIRO && acaoCaixaSelecaoCozinheiro == false) {
            tela.getSpCozinheiro().setVisible(acaoCaixaSelecaoCozinheiro);
            condAcaoCozinheio = true;
        }
        if (tipoControleMouse == TipoControllerMouse.CAIXA_SELECAO_COZINHEIRO && acaoCaixaSelecaoCozinheiro == true) {
            tela.getSpCozinheiro().setVisible(acaoCaixaSelecaoCozinheiro);
            condAcaoCozinheio = true;            
        }
        if (tipoControleMouse == TipoControllerMouse.CAIXA_SELECAO_MAE && acaoCaixaSelecaoMae == false) {
            tela.getSpMae().setVisible(acaoCaixaSelecaoMae);
            condAcaoMae = true;
        }
        if (tipoControleMouse == TipoControllerMouse.CAIXA_SELECAO_MAE && acaoCaixaSelecaoMae == true) {
            tela.getSpMae().setVisible(acaoCaixaSelecaoMae);
            condAcaoMae = true;            
        }
        this.acaoCaixaSelecaoCozinheiro(condAcaoCozinheio);
        this.acaoCaixaSelecaoMae(condAcaoMae);
    }

    private void acaoCaixaSelecaoCozinheiro(boolean cond2) {
        if (cond2) {
            if (acaoCaixaSelecaoCozinheiro) {
                this.acaoCaixaSelecaoCozinheiro = false;
            } else {
                this.acaoCaixaSelecaoCozinheiro = true;
            }
        }
    }
    private void acaoCaixaSelecaoMae(boolean cond2) {
        if (cond2) {
            if (acaoCaixaSelecaoMae) {
                this.acaoCaixaSelecaoMae = false;
            } else {
                this.acaoCaixaSelecaoMae = true;
            }
        }
    }
}
