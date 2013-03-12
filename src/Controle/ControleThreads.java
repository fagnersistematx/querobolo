/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Controle.Interface.ControleInterface;
import Controle.Interface.Mensagem.ControleInterfaceMensagemCozinheiro;
import Controle.Interface.Mensagem.ControleInterfaceMensagemMae;
import Controle.Interface.estados.ControleInterfaceEstadoCozinheiro;
import Controle.Interface.estados.ControleInterfaceEstadoMae;
import Entidade.Cozinheiro;
import Entidade.Mae;
import GUI.Tela;
import Util.ConfiguracaoPausarIniciar;

/**
 *
 * @author Fagner
 */
public class ControleThreads {

    private static Cozinheiro cozinheiro;
    private static Mae mae;
    private static Tela tela;
    private static ControleInterface controleInterface;
    private static ControleInterfaceMensagemMae controleInterfaceMensagem;
    private static ControleInterfaceMensagemCozinheiro controleInterfaceMensagemCozinheiro;
    private static ControleInterfaceEstadoMae controleInterfaceEstadoMae;
    private static ControleInterfaceEstadoCozinheiro controleInterfaceEstadoCozinheiro;

    public void inciarSistema() {
        
        tela = new Tela();
        controleInterfaceEstadoMae = new ControleInterfaceEstadoMae(tela);
        controleInterfaceEstadoCozinheiro = new ControleInterfaceEstadoCozinheiro(tela);
        cozinheiro = new Cozinheiro(415, 2, false, false);
        mae = new Mae(960, 2, false, false);
        controleInterface = new ControleInterface(tela, false);
        controleInterfaceMensagem = new ControleInterfaceMensagemMae(tela);
        controleInterfaceMensagemCozinheiro = new ControleInterfaceMensagemCozinheiro(tela);

    }

    public static void inciarThreadMae() {
        mae.start();
        controleInterfaceMensagem.start();
    }

    public static void inciarThreadCozinheiro() {
        cozinheiro.start();
        controleInterfaceMensagemCozinheiro.start();
    }

    public void pararThreadsMaeCozinheiro() {
        try {

            mae.stop();
            cozinheiro.stop();
            ConfiguracaoPausarIniciar.setIniciarPausarCozinheiro(0);
            ConfiguracaoPausarIniciar.setIniciarPausarMae(0);
            this.inciarSistema();

        } catch (Exception erro) {
            System.err.println("Falha ao reiniciar.");
        }
    }


    /*
     *
     * GETs
     *
     */
    public static Tela getTela() {
        return tela;
    }

    public static Cozinheiro getCozinheiro() {
        return cozinheiro;
    }

    public static Mae getMae() {
        return mae;
    }

    public static ControleInterfaceEstadoCozinheiro getControleInterfaceEstadoCozinheiro() {
        return controleInterfaceEstadoCozinheiro;
    }

    public static void setControleInterfaceEstadoCozinheiro(ControleInterfaceEstadoCozinheiro controleInterfaceEstadoCozinheiro) {
        ControleThreads.controleInterfaceEstadoCozinheiro = controleInterfaceEstadoCozinheiro;
    }

    public static ControleInterfaceEstadoMae getControleInterfaceEstadoMae() {
        return controleInterfaceEstadoMae;
    }

    public static void setControleInterfaceEstadoMae(ControleInterfaceEstadoMae controleInterfaceEstadoMae) {
        ControleThreads.controleInterfaceEstadoMae = controleInterfaceEstadoMae;
    }
    
}
