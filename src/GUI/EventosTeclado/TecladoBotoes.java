package GUI.EventosTeclado;

import Controle.Interface.ControleInterface;
import Controle.ControleThreads;
import GUI.Tela;
import GUI.TelaAjuda;
import Util.ConfiguracaoPausarIniciar;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Fagner
 */
public class TecladoBotoes implements KeyListener {

    private Tela tela;

    public TecladoBotoes(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int iniciarPausarMae = ConfiguracaoPausarIniciar.getIniciarPausarMae();

        //Iniciar ou pausar thread da mãe.
        if (e.getKeyCode() == KeyEvent.VK_F12) {

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
            tela.getBtReiniciarParar().setVisible(true);
        }

        //Iniciar ou pausar thread do cozinheiro.
        if (e.getKeyCode() == KeyEvent.VK_F2) {

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

            tela.getBtReiniciarParar().setVisible(true);
        }

        //Reiniciar threads da mãe e cozinheiro.
        if (e.getKeyCode() == KeyEvent.VK_F6) {

            tela.setVisible(false);
            ControleThreads controleThreads = new ControleThreads();
            controleThreads.pararThreadsMaeCozinheiro();
            tela.getBtReiniciarParar().setVisible(true);

        }
        
        //Tela de ajuda.
        if (e.getKeyCode() == KeyEvent.VK_H) {
            TelaAjuda telaAjuda = new TelaAjuda();
        }

        //Alterar velocidade das threads da mãe e cozinheiro.
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            tela.getVelocidadeMae().setValue((tela.getVelocidadeMae().getValue() + 10));
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            tela.getVelocidadeMae().setValue((tela.getVelocidadeMae().getValue() - 10));
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            tela.getVelocidadeCozinheiro().setValue((tela.getVelocidadeCozinheiro().getValue() + 10));
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            tela.getVelocidadeCozinheiro().setValue((tela.getVelocidadeCozinheiro().getValue() - 10));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
