/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.EventosMouse;

import GUI.Enuns.TipoControllerMouse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner
 */
public class MouseBotoesAjuda implements ActionListener {

    private TipoControllerMouse tipoControllerMouse;

    public MouseBotoesAjuda(TipoControllerMouse tipoControllerMouse) {

        this.tipoControllerMouse = tipoControllerMouse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Ao clicar no primeiro botão de tela de ajuda executara esta condição.
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_UM) {

            JOptionPane.showMessageDialog(null,
                      "Thread é uma forma de um processo dividir a si mesmo \n"
                    + "em  duas  ou  mais tarefas que podem ser  executadas \n"
                    + "concorrentemente.  O suporte  à  thread é  fornecido \n"
                    + "pelo próprio sistema operacional.", 
                    "O que é uma thread?", 3);

        }
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_DOIS) {
            JOptionPane.showMessageDialog(null,AJUDA_OBJETIVO, "Objetivo",3);
        }
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_TRES) {
            JOptionPane.showMessageDialog(null, AJUDA_FUNCIONALIDADE, "Como a ferramenta funciona?",3);
        }
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_QUATRO) {
            JOptionPane.showMessageDialog(null, ""
                    + "                                     UNIVERSIDADE FEDERAL DA PARAÍBA\n"
                    + "                                         CAMPUS IV – LITORAL NORTE\n"
                    + "                          CENTRO DE CIÊNCIAS APLICADAS E EDUCAÇÃO\n"
                    + "                             DEPARTAMENTO DE CIÊNCIAS EXATAS - DCE\n\n\n"
                    + "                             PROGRAMA DE LICENCIATURA – PROLICEN 2012\n\n"
                    + "Título do projeto:\n"
                    + "Ensinando programação de sistemas concorrentes e formas de testar tais sistemas\n\n"
                    + "Período de realização:\n"
                    + "Semestres letivos de 2011.2, 2012.1 e 2012.2\n\n"
                    + "Coordenadora do projeto:\n"
                    + "Profª. DSc. Ayla Débora Dantas de Souza Rebouças\n\n"
                    + "Aluno bolsista:\n"
                    + "Fagner Silva Martins","Descrição",1);
        }
        if (tipoControllerMouse == TipoControllerMouse.BOTAO_AJUDA_CINCO) {
            JOptionPane.showMessageDialog(null,
                      "ALUNO \n\n"
                    + "Nome:  Fagner Silva Martins\n"
                    + "E-mail: fagner.silva@dce.ufpb.br\n\n"
                    + "COORDENADOR\n\n"
                    + "Nome:  Profª. DSc. Ayla Débora Dantas de Souza Rebouças\n"
                    + "E-mail: ayla@dce.ufpb.br", "Contatos",1);
        }   
        
    }
    private static final String AJUDA_OBJETIVO2 = 
              "Esta ferramenta tem como objetivo ensinar o conceito de métodos, estados e \n"
            + "comportamentos, de um processamento paralelo, para alunos da disciplina de \n"
            + "Programação Orientada a Objetos, programadores iniciantes na área e afins.";
    
    private static final String AJUDA_OBJETIVO = 
              "Hugo esta aniversariando, sua mãe Sandra terá que buscar o bolo de aniversario \n"
            + "na confeitaria, caso o bolo não esteja pronto ela deverá aguardar o cozinheiro \n"
            + "até que ele coloque o mesmo acima do balcão para que ela possa leva-lo.";  
    private static final String AJUDA_FUNCIONALIDADE = 
              "Inicie o processo clicando em um dos botões para iniciar,  esquerda  (Cozinheiro)\n"
            + "ou  direita (Mãe), se  desejar  utilizar  o  teclado  F2  e  F12  respectivamente, caso \n"
            + "deseje pausar o processo clique ou pressione os mesmos. Para reiniciar durante a \n"
            + "execução clique no botão reiniciar ou pressione  F6. As teclas W e S  sevem para \n"
            + "alterar a velocidade  do  cozinheiro.  As teclas  UP  e  Down  sevem para  alterar a  \n"
            + "velocidade  da  mãe.  Escolha  um estado em um dos  painéis de estado da thread     \n"
            + "clique sobre ele, para obter mais informações dos estados da Thread.";
}
