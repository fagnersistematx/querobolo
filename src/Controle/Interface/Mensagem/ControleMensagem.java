/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Interface.Mensagem;

import GUI.Enuns.TipoMensagem;
import GUI.Tela;
import javax.swing.ImageIcon;

/**
 *
 * @author Fagner
 */
public class ControleMensagem extends Thread {

    private TipoMensagem tipoMensagem;
    private Tela tela;

    public ControleMensagem(TipoMensagem tipoMensagem, Tela tela) {
        this.tipoMensagem = tipoMensagem;
        this.tela = tela;
        start();
    }

    @Override
    public void run() {
        if (tipoMensagem == TipoMensagem.INICIAR_MAE) {
            this.msnInicialMae();
        } else if (tipoMensagem == TipoMensagem.ESPERA_MAE) {
            this.msnEsperaMae();
        }
        
        if (tipoMensagem == TipoMensagem.INICIAR_COZINHEIRO_COM_MAE) {
            this.msnInicialCozinheiroComMae();
        }
        
        if (tipoMensagem == TipoMensagem.INICIAR_COZINHEIRO_SEM_MAE) {
            this.msnInicialCozinheiroSemMae();
        }

    }

    private void msnInicialMae() {
        try {
            tela.getLbFalaMae().setVisible(true);
            tela.getLbFalaMae().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/msnInicialMae.gif")));
            sleep(5000);
            tela.getLbFalaMae().setVisible(false);
        } catch (Exception erro) {
        }
    }

    private void msnEsperaMae() {
        try {
            tela.getLbFalaMae().setVisible(true);
            tela.getLbFalaMae().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/esperarMae.gif")));
            sleep(5000);
            tela.getLbFalaMae().setVisible(false);
        } catch (Exception erro) {
        }
    }
    private void msnInicialCozinheiroComMae() {
        try {
            tela.getLbFalaCozinheiro().setVisible(true);
            tela.getLbFalaCozinheiro().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/esperarCozinheira.gif")));
            sleep(5000);
            tela.getLbFalaCozinheiro().setVisible(false);
        } catch (Exception erro) {
        }
    }
    
    private void msnInicialCozinheiroSemMae() {
        try {
            tela.getLbFalaCozinheiro().setVisible(true);
            tela.getLbFalaCozinheiro().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/msnInicialCozinheiro.gif")));
            sleep(5000);
            tela.getLbFalaCozinheiro().setVisible(false);
        } catch (Exception erro) {
        }
    }
}
