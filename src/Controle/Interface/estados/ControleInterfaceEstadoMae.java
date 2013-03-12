/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Interface.estados;

import Controle.ControleThreads;
import Controle.Interface.ControleInterface;
import GUI.Tela;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Fagner
 */
public class ControleInterfaceEstadoMae extends Thread {

    private boolean cond = true;
    private boolean cond2 = false;
    private Tela tela;

    public ControleInterfaceEstadoMae(Tela tela) {
        this.tela = tela;
        this.start();
    }

    @Override
    public void run() {
        
        while (cond) {
            try {
                sleep(500);
                if (ControleThreads.getMae().getState() == State.WAITING) {
                    this.linparEstados();
                    this.tela.getLbEstadoMaeEsperando().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoBloqueada2.png")));
                }
                if (ControleThreads.getMae().getState() == State.TERMINATED) {
                    this.linparEstados();
                    this.tela.getLbEstadoMaeTerminada().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoMorta2.png")));
                    this.tela.getBtIniciarMae().setVisible(false);
                    this.cond = false;
                }
                if (ControleThreads.getMae().getState() == State.NEW) {
                    this.linparEstados();
                    this.tela.getLbEstadoMaeNova().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoNova2.png")));
                }
                if (ControleThreads.getMae().getState() == State.BLOCKED) {
                    this.linparEstados();
                    this.tela.getLbEstadoMaeNova().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoDormindo2.PNG")));
                    sleep(5 * 10);
                }
                if (ControleThreads.getMae().getState() == State.TIMED_WAITING) {
                    if (cond2) {
                        ControleInterface.rePaintEstadoDormindoMae();
                        sleep(5 * 40);
                        ControleInterface.rePaintEstadoExecutandoMae();
                        sleep(5 * 40);
                    } else {
                        this.linparEstados();
                        this.tela.getLbEstadoMaeIniciada().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoIniciada2.png")));
                        cond2 = true;
                        sleep(500);
                    }
                    this.linparEstados();
                }
                if (ControleThreads.getMae().getState() == State.RUNNABLE) {
                    this.linparEstados();
                    tela.getLbEstadoMaeExecutando().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoExecutando2.PNG")));
                    sleep(5 * 10);
                }
            } catch (Exception erro) {
            }
        }
    }

    public void linparEstados() {

        tela.getLbEstadoMaeDormindo().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoDormindo.PNG")));
        tela.getLbEstadoMaeEsperando().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoBloqueada.png")));
        tela.getLbEstadoMaeExecutando().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoExecutando.PNG")));
        tela.getLbEstadoMaeNova().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoNova.png")));
        tela.getLbEstadoMaeIniciada().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoIniciada.png")));
        tela.getLbEstadoMaeTerminada().setIcon(new ImageIcon(tela.getPainelEstadoMae().getClass().getResource("/Imagens/estadoMorta.png")));

    }
}
