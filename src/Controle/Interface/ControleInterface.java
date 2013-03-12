/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Interface;

import Controle.ControleThreads;
import GUI.Tela;
import javax.swing.ImageIcon;

/**
 *
 * @author Fagner
 */
public class ControleInterface {

    private static Tela tela;
    private static boolean boloEntregue;

    public ControleInterface(Tela tela, boolean boloEntregue) {
        ControleInterface.tela = tela;
        ControleInterface.boloEntregue = boloEntregue;
        tela.setVisible(true);
    }

    public static void rePaintCozinheiro(int posicao, boolean rePaintBolo) {

        tela.getLbCozinheiro().setLocation(posicao, tela.getLbCozinheiro().getY());

        if (rePaintBolo) {
            tela.getLbBolo().setLocation(posicao + 20, tela.getLbBolo().getY());
            tela.getLbBolo().setVisible(true);
            //Bolo acima da mesa.
            if (tela.getLbBolo().getX() >= 440) {
                boloAcimaDaMesaCozinheiro();
            }
        }
    }

    public static void rePaintMae(int posicao, boolean rePaintBolo) {

        tela.getLbMae().setLocation(posicao, tela.getLbMae().getY());

        if (rePaintBolo) {
            tela.getLbBolo().setLocation(posicao + 60, 300);
            //Bolo acima da mesa.
            if (tela.getLbBolo().getX() >= 1020) {
                boloAcimaDaMesaMae();
            }
        }
    }

    //Método para colocar o bolo acima da mesa do cozinheiro.
    private static void boloAcimaDaMesaCozinheiro() {
        tela.getLbBolo().setLocation((tela.getLbBolo().getX() + 120), (250));
        boloEntregue = true;
        synchronized (ControleThreads.getMae()) {
            ControleThreads.getMae().notify();
        }
    }

    //Método para colocar o bolo acima da mesa da Mãe.
    private static void boloAcimaDaMesaMae() {
        tela.getLbBolo().setLocation((tela.getLbBolo().getX() + 75), 260);
        boloEntregue = true;
    }

    public static boolean isBoloEntregue() {
        return boloEntregue;
    }

    public static void ModificarBotaoIniciarCozinheiro() {
        tela.getBtIniciarCozinheiro().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/pausa.png")));
        tela.getBtIniciarCozinheiro().setText("Pausar");
    }

    public static void ModificarBotaoPausarCozinheiro() {
        tela.getBtIniciarCozinheiro().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/iniciar.png")));
        tela.getBtIniciarCozinheiro().setText("Iniciar");
    }

    public static void ModificarBotaoIniciarMae() {
        tela.getBtIniciarMae().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/pausa.png")));
        tela.getBtIniciarMae().setText("Pausar");
    }

    public static void ModificarBotaoPausarMae() {
        tela.getBtIniciarMae().setIcon(new ImageIcon(tela.getClass().getResource("/Imagens/iniciar.png")));
        tela.getBtIniciarMae().setText("Iniciar");
    }

    public static void rePaintEstadoDormindoCozinheiro() {
        ControleThreads.getTela().getLbEstadoCozinheiroDormindo().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoDormindo2.PNG")));
    }

    public static void rePaintEstadoExecutandoCozinheiro() {
        ControleThreads.getTela().getLbEstadoCozinheiroExecutando().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoExecutando2.PNG")));
    }

    public static void rePaintEstadoDormindoMae() {
        ControleThreads.getTela().getLbEstadoMaeDormindo().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoDormindo2.PNG")));
    }

    public static void rePaintEstadoExecutandoMae() {
        ControleThreads.getTela().getLbEstadoMaeExecutando().setIcon(new ImageIcon(tela.getPainelEstadoCozinheira().getClass().getResource("/Imagens/estadoExecutando2.PNG")));
    }
}
