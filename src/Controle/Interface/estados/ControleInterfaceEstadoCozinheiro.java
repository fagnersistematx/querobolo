/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Interface.estados;

import Controle.ControleThreads;
import Controle.Interface.ControleInterface;
import GUI.Tela;
import javax.swing.ImageIcon;

/**
 *
 * @author Fagner
 */
public class ControleInterfaceEstadoCozinheiro extends Thread {

    private boolean cond = true;
    private boolean cond2 = false;
    private Tela tela;

    public ControleInterfaceEstadoCozinheiro(Tela tela) {
        this.tela = tela;
        this.start();
    }

    @Override
    public void run() {
        
        while (cond) {
            try {
                sleep(500);
                if (ControleThreads.getCozinheiro().getState() == State.WAITING) {
                    this.linparEstados();
                    this.tela.getLbEstadoCozinheiroEsperando().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoBloqueada2.png")));
                }
                if (ControleThreads.getCozinheiro().getState() == State.TERMINATED) {
                    this.linparEstados();
                    this.tela.getLbEstadoCozinheiroTerminada().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoMorta2.png")));
                    this.tela.getBtIniciarCozinheiro().setVisible(false);
                    this.cond = false;
                }
                if (ControleThreads.getCozinheiro().getState() == State.NEW) {
                    this.linparEstados();
                    this.tela.getLbEstadoCozinheiroNova().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoNova2.png")));
                }
                if (ControleThreads.getCozinheiro().getState() == State.BLOCKED) {
                    this.linparEstados();
                    this.tela.getLbEstadoCozinheiroNova().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoDormindo2.PNG")));
                    sleep(5 * 10);
                }
                if (ControleThreads.getCozinheiro().getState() == State.TIMED_WAITING) {
                    if (cond2) {
                        ControleInterface.rePaintEstadoDormindoCozinheiro();
                        sleep(5 * 40);
                        ControleInterface.rePaintEstadoExecutandoCozinheiro();
                        sleep(5 * 40);
                    } else {
                        this.linparEstados();
                        this.tela.getLbEstadoCozinheiroIniciada().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoIniciada2.png")));
                        cond2 = true;
                        sleep(500);
                    }
                    this.linparEstados();
                }
                if (ControleThreads.getCozinheiro().getState() == State.RUNNABLE) {
                    this.linparEstados();
                    tela.getLbEstadoCozinheiroExecutando().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoExecutando2.PNG")));
                    sleep(5 * 10);
                }
            } catch (Exception erro) {
            }
        }
    }

    public void linparEstados() {
        tela.getLbEstadoCozinheiroDormindo().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoDormindo.PNG")));
        tela.getLbEstadoCozinheiroEsperando().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoBloqueada.png")));
        tela.getLbEstadoCozinheiroExecutando().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoExecutando.PNG")));
        tela.getLbEstadoCozinheiroNova().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoNova.png")));
        tela.getLbEstadoCozinheiroIniciada().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoIniciada.png")));
        tela.getLbEstadoCozinheiroTerminada().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoMorta.png")));
    }
}
