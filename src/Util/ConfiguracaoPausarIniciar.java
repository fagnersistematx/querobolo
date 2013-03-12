/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Fagner
 */
public class ConfiguracaoPausarIniciar {
    
    private static int iniciarPausarCozinheiro = 0;
    private static int iniciarPausarMae = 0;

    public static int getIniciarPausarCozinheiro() {
        return iniciarPausarCozinheiro;
    }

    public static void setIniciarPausarCozinheiro(int iniciarPausarCozinheiro) {
        ConfiguracaoPausarIniciar.iniciarPausarCozinheiro = iniciarPausarCozinheiro;
    }

    public static int getIniciarPausarMae() {
        return iniciarPausarMae;
    }

    public static void setIniciarPausarMae(int iniciarPausarMae) {
        ConfiguracaoPausarIniciar.iniciarPausarMae = iniciarPausarMae;
    }    
}
