/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Enuns.TipoControllerMouse;
import GUI.EventosMouse.MouseBotoesAjuda;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Fagner
 */
public class TelaAjuda extends JFrame{
    
    private JButton btAjuda1, btAjuda2, btAjuda3, btAjuda4, btAjuda5;

    public TelaAjuda() {
        
        this.setLayout(null);
        this.setTitle("Quero Bolo - BETA 2.1.2 - Ajuda");
        this.setIconImage(icone());
        this.setSize(300, 250);        
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        
        this.btAjuda1 = new JButton("O que é uma Thread?");
        this.btAjuda2 = new JButton("Objetivo");
        this.btAjuda3 = new JButton("Como a ferramenta funciona?");
        this.btAjuda4 = new JButton("Sobre a ferramenta");
        this.btAjuda5 = new JButton("Contatos");
        
        this.btAjuda1.setBounds(  25,  15, 240, 30);
        this.btAjuda2.setBounds(  25,  55, 240, 30);
        this.btAjuda3.setBounds(  25,  95, 240, 30);
        this.btAjuda4.setBounds(  25, 135, 240, 30);
        this.btAjuda5.setBounds(  25, 175, 240, 30);
        
        btAjuda1.addActionListener(new MouseBotoesAjuda(TipoControllerMouse.BOTAO_AJUDA_UM));
        btAjuda2.addActionListener(new MouseBotoesAjuda(TipoControllerMouse.BOTAO_AJUDA_DOIS));
        btAjuda3.addActionListener(new MouseBotoesAjuda(TipoControllerMouse.BOTAO_AJUDA_TRES));
        btAjuda4.addActionListener(new MouseBotoesAjuda(TipoControllerMouse.BOTAO_AJUDA_QUATRO));
        btAjuda5.addActionListener(new MouseBotoesAjuda(TipoControllerMouse.BOTAO_AJUDA_CINCO));
        
        getContentPane().add(btAjuda1);
        getContentPane().add(btAjuda2);
        getContentPane().add(btAjuda3);
        getContentPane().add(btAjuda4);   
        getContentPane().add(btAjuda5);
        
    }
    
    //Altera imagem do Toolkit.
    private Image icone() {
        
        getClass().getResource("");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image imagem = tk.getImage(getClass().getResource("/Imagens/ajuda.png"));
        return imagem;
        
    }
}
