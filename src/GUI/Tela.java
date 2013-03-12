package GUI;

import GUI.Enuns.TipoControllerMouse;
import GUI.EventosMouse.ClickAjuda;
import GUI.EventosMouse.EventosCaixaSelecaoMouse;
import GUI.EventosMouse.MouseBotao;
import GUI.EventosMouse.VelocidadeControleDeslizante;
import GUI.EventosTeclado.TecladoBotoes;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Fagner Silva,fagner.silva@dce.ufpb.br
 * @version 1.0
 *
 */
public class Tela extends JFrame {

    private JLabel lbMae;
    private JLabel lbCozinheiro;
    private JLabel lbFilho;
    private JLabel lbEstadoCozinheiroIniciada;
    private JLabel lbEstadoCozinheiroExecutando;
    private JLabel lbEstadoCozinheiroTerminada;
    private JLabel lbEstadoCozinheiroNova;
    private JLabel lbEstadoCozinheiroEsperando;
    private JLabel lbEstadoCozinheiroDormindo;
    private JLabel lbEstadoMaeIniciada;
    private JLabel lbEstadoMaeExecutando;
    private JLabel lbEstadoMaeTerminada;
    private JLabel lbEstadoMaeNova;
    private JLabel lbEstadoMaeEsperando;
    private JLabel lbEstadoMaeDormindo;
    private JLabel lbBolo;
    private JLabel lbFogao;
    private JLabel lbMesa;
    private JLabel lbMesaMae;
    private JLabel lbFalaMae;
    private JLabel lbFalaCozinheiro;
    private JLabel lbAjuda;
    private JButton btIniciarMae;
    private JButton btIniciarCozinheiro;
    private JButton btReiniciarParar;
    private JPanel painelEstadoCozinheira;
    private JPanel painelEstadoMae;
    private JPanel painelVelocidadeMae;
    private JPanel painelVelocidadeCozinheiro;
    private JCheckBox jcCozinheiro;
    private JCheckBox jcMae;
    private JTextArea codigoCozinheiro;
    private JTextArea codigoMae;
    private JScrollPane spMae;
    private JScrollPane spCozinheiro;
    private JSlider velocidadeMae;
    private JSlider velocidadeCozinheiro;

    public Tela() {

        this.setLayout(null);
        this.setTitle("Quero Bolo - BETA 2.1.2");
        this.setIconImage(icone());
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        
        this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("/Imagens/java.png")));  

        //Inicialização dos painéis de estado e velocidade do cozinheiro e mãe.
        painelEstadoCozinheira = new JPanel(null);
        painelEstadoMae = new JPanel(null);
        painelVelocidadeCozinheiro = new JPanel(new java.awt.BorderLayout());
        painelVelocidadeMae = new JPanel(new java.awt.BorderLayout());

        /*
         *
         * Inicialização dos componentes da Tela.
         *
         */

        //Inicialização dos desenhos dos componentes.
        lbCozinheiro = new JLabel(new ImageIcon(getClass().getResource("/Imagens/cozinheira.png")));
        lbMae = new JLabel(new ImageIcon(getClass().getResource("/Imagens/mae4.gif")));
        lbFilho = new JLabel(new ImageIcon(getClass().getResource("/Imagens/filho.gif")));
        lbEstadoCozinheiroIniciada = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoIniciada.png")));
        lbEstadoCozinheiroEsperando = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoBloqueada.png")));
        lbEstadoCozinheiroDormindo = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoDormindo.PNG")));
        lbEstadoCozinheiroExecutando = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoExecutando.PNG")));
        lbEstadoCozinheiroTerminada = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoMorta.png")));
        lbEstadoCozinheiroNova = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoNova.png")));
        lbEstadoMaeIniciada = new JLabel(new ImageIcon(painelEstadoMae.getClass().getResource("/Imagens/estadoIniciada.png")));
        lbEstadoMaeEsperando = new JLabel(new ImageIcon(painelEstadoMae.getClass().getResource("/Imagens/estadoBloqueada.png")));
        lbEstadoMaeDormindo = new JLabel(new ImageIcon(painelEstadoMae.getClass().getResource("/Imagens/estadoDormindo.PNG")));
        lbEstadoMaeExecutando = new JLabel(new ImageIcon(painelEstadoMae.getClass().getResource("/Imagens/estadoExecutando.PNG")));
        lbEstadoMaeTerminada = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoMorta.png")));
        lbEstadoMaeNova = new JLabel(new ImageIcon(painelEstadoCozinheira.getClass().getResource("/Imagens/estadoNova.png")));
        lbFogao = new JLabel(new ImageIcon(getClass().getResource("/Imagens/fogao.png")));
        lbMesaMae = new JLabel(new ImageIcon(getClass().getResource("/Imagens/mesa.jpg")));
        lbMesa = new JLabel(new ImageIcon(getClass().getResource("/Imagens/mesa.jpg")));
        lbBolo = new JLabel(new ImageIcon(getClass().getResource("/Imagens/bolo.gif")));
        lbFalaMae = new JLabel();
        lbFalaCozinheiro = new JLabel();
        lbAjuda = new JLabel(new ImageIcon(getClass().getResource("/Imagens/ajuda.png")));

        //Inicialização de todos os botões.
        btIniciarCozinheiro = new JButton("Iniciar", new ImageIcon(getClass().getResource("/Imagens/iniciar.png")));
        btIniciarMae = new JButton("Iniciar", new ImageIcon(getClass().getResource("/Imagens/iniciar.png")));
        btReiniciarParar = new JButton("Reiniciar", new ImageIcon(getClass().getResource("/Imagens/parar.png")));

        //Códigos da mãe e cozinheiro na ária de texto.
        codigoCozinheiro = new JTextArea(codigoParcialCozinheiro());
        codigoMae = new JTextArea(codigoParcialMae());

        //Inicialização dos controles de velocidade da cozinheiro e mãe.
        velocidadeMae = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);
        velocidadeCozinheiro = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);

        //Adiciona uma régua aos controles deslizantes de velocidade.
        velocidadeCozinheiro.setPaintTicks(true);
        velocidadeMae.setPaintTicks(true);

        //Adiciona os numeros da régua aos controles deslizantes de velocidade.
        velocidadeCozinheiro.setPaintLabels(true);
        velocidadeMae.setPaintLabels(true);

        //Escala máxima das régua dos controles deslizantes de velocidade.
        velocidadeMae.setMajorTickSpacing(10);
        velocidadeCozinheiro.setMajorTickSpacing(10);

        //Escala mínima das régua dos controles deslizantes de velocidade.
        velocidadeCozinheiro.setMinorTickSpacing(1);
        velocidadeMae.setMinorTickSpacing(1);



        //Inicialização das barras de rolagem das áreas do código parcial do cozinheiro e mãe.
        spMae = new JScrollPane(codigoMae);
        spCozinheiro = new JScrollPane(codigoCozinheiro);

        //Inicialização das caixas de visualização dos códigos parciais da mãe e cozinheiro.
        jcCozinheiro = new JCheckBox("Código parcial do cozinheiro");
        jcMae = new JCheckBox("Código parcial da mãe");

        /*
         *
         * Posicionado os componentes da Tela.
         *
         */

        lbCozinheiro.setBounds(415, 220, 150, 200);
        lbMae.setBounds(960, 220, 150, 200);
        lbFilho.setBounds(1070, 250, 150, 200);
        btIniciarCozinheiro.setBounds(210, 455, 130, 30);
        btIniciarMae.setBounds(845, 455, 130, 30);
        btReiniciarParar.setBounds(525, 455, 130, 30);
        lbEstadoCozinheiroIniciada.setBounds(108, 17, 80, 40);
        lbEstadoCozinheiroEsperando.setBounds(108, 67, 80, 40);
        lbEstadoCozinheiroDormindo.setBounds(5, 67, 80, 40);
        lbEstadoCozinheiroExecutando.setBounds(208, 17, 80, 40);
        lbEstadoCozinheiroTerminada.setBounds(208, 67, 80, 40);
        lbEstadoCozinheiroNova.setBounds(5, 17, 80, 40);
        lbEstadoMaeIniciada.setBounds(108, 17, 80, 40);
        lbEstadoMaeEsperando.setBounds(108, 67, 80, 40);
        lbEstadoMaeDormindo.setBounds(5, 67, 80, 40);
        lbEstadoMaeExecutando.setBounds(208, 17, 80, 40);
        lbEstadoMaeTerminada.setBounds(208, 67, 80, 40);
        lbEstadoMaeNova.setBounds(5, 17, 80, 40);
        lbFogao.setBounds(5, 295, 100, 90);
        lbMesaMae.setBounds(1090, 305, 100, 90);
        lbMesa.setBounds(552, 305, 100, 80);
        lbBolo.setBounds(502, 290, 80, 80);
        lbFalaCozinheiro.setBounds(470, 170, 150, 100);
        lbFalaMae.setBounds(1015, 170, 150, 100);
        jcCozinheiro.setBounds(40, 140, 270, 30);
        jcMae.setBounds(940, 140, 270, 30);
        spCozinheiro.setBounds(330, 5, 260, 160);
        spMae.setBounds(610, 5, 260, 160);
        painelEstadoCozinheira.setBounds(5, 5, 300, 120);
        painelEstadoMae.setBounds(890, 5, 300, 120);
        painelVelocidadeCozinheiro.setBounds(120, 500, 300, 70);
        painelVelocidadeMae.setBounds(760, 500, 300, 70);
        lbAjuda.setBounds(560, 560, 60, 60);

        //Modificando a cor dos componentes da cozinheiro e mãe.
        painelEstadoCozinheira.setBackground(Color.WHITE);
        painelEstadoMae.setBackground(Color.WHITE);
        painelVelocidadeCozinheiro.setBackground(Color.WHITE);
        painelVelocidadeMae.setBackground(Color.WHITE);
        velocidadeCozinheiro.setBackground(Color.WHITE);
        velocidadeMae.setBackground(Color.WHITE);
        jcCozinheiro.setBackground(Color.WHITE);
        jcMae.setBackground(Color.WHITE);
        spCozinheiro.setBackground(Color.WHITE);
        spMae.setBackground(Color.WHITE);

        //Adicionando bordas as áreas de texto dos códigos parciais do cozinheiro e mãe.
        spCozinheiro.setBorder(javax.swing.BorderFactory.createTitledBorder("Código parcial do cozinheiro"));
        spMae.setBorder(javax.swing.BorderFactory.createTitledBorder("Código parcial da mãe"));

        //Adicionando bordas aos painéis de estado evelocidade do cozinheiro e mãe.
        painelEstadoCozinheira.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado da thread do cozinheiro"));
        painelEstadoMae.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado da thread da mãe"));
        painelVelocidadeCozinheiro.setBorder(javax.swing.BorderFactory.createTitledBorder("Velocidade do cozinheiro"));
        painelVelocidadeMae.setBorder(javax.swing.BorderFactory.createTitledBorder("Velocidade da mãe"));

        //Adicionando os desenho de estados aos painéis de estado da cozinheira e mãe.
        painelEstadoCozinheira.add(lbEstadoCozinheiroEsperando);
        painelEstadoCozinheira.add(lbEstadoCozinheiroDormindo);
        painelEstadoCozinheira.add(lbEstadoCozinheiroExecutando);
        painelEstadoCozinheira.add(lbEstadoCozinheiroTerminada);
        painelEstadoCozinheira.add(lbEstadoCozinheiroNova);
        painelEstadoCozinheira.add(lbEstadoCozinheiroIniciada);
        painelEstadoMae.add(lbEstadoMaeEsperando);
        painelEstadoMae.add(lbEstadoMaeDormindo);
        painelEstadoMae.add(lbEstadoMaeExecutando);
        painelEstadoMae.add(lbEstadoMaeTerminada);
        painelEstadoMae.add(lbEstadoMaeNova);
        painelEstadoMae.add(lbEstadoMaeIniciada);

        //Adicionando controle deslizante aos painéis de velocidade da cozinheira e mãe.
        painelVelocidadeCozinheiro.add(velocidadeCozinheiro);
        painelVelocidadeMae.add(velocidadeMae);

        //Adicionando eventos do mouse.
        jcCozinheiro.addActionListener(new EventosCaixaSelecaoMouse(this, TipoControllerMouse.CAIXA_SELECAO_COZINHEIRO));
        jcMae.addActionListener(new EventosCaixaSelecaoMouse(this, TipoControllerMouse.CAIXA_SELECAO_MAE));
        btIniciarMae.addActionListener(new MouseBotao(this, TipoControllerMouse.INICIAR_THREAD_MAE));
        btReiniciarParar.addActionListener(new MouseBotao(this, TipoControllerMouse.REINICIAR));
        btIniciarCozinheiro.addActionListener(new MouseBotao(this, TipoControllerMouse.INICIAR_THREAD_COZINHEIRO));
        velocidadeCozinheiro.addChangeListener(new VelocidadeControleDeslizante(this, TipoControllerMouse.VELOCIDADE_COZINHEIRO));
        velocidadeMae.addChangeListener(new VelocidadeControleDeslizante(this, TipoControllerMouse.VELOCIDADE_MAE));
        lbAjuda.addMouseListener(new ClickAjuda(TipoControllerMouse.AJUDA));
        lbEstadoCozinheiroDormindo.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_DORMINDO_COZINHEIRO));
        lbEstadoCozinheiroEsperando.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_ESPERANDO_COZINHEIRO));
        lbEstadoCozinheiroExecutando.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_EXECUCAO_COZINHEIRO));
        lbEstadoCozinheiroNova.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_NOVA_COZINHEIRO));
        lbEstadoCozinheiroIniciada.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_INICIADA_COZINHEIRO));
        lbEstadoCozinheiroTerminada.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_TERMINADA_COZINHEIRO));
        lbEstadoMaeDormindo.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_DORMINDO_MAE));
        lbEstadoMaeEsperando.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_ESPERANDO_MAE));
        lbEstadoMaeExecutando.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_EXECUCAO_MAE));
        lbEstadoMaeNova.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_NOVA_MAE));
        lbEstadoMaeIniciada.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_INICIADA_MAE));
        lbEstadoMaeTerminada.addMouseListener(new ClickAjuda(TipoControllerMouse.ESTADO_TERMINADA_MAE));


        //Adicionando eventos do teclado.
        this.addKeyListener(new TecladoBotoes(this));

        //Adicionando ToolTipText aos componentes.
        btIniciarCozinheiro.setToolTipText("Para iniciar e pausar pressione F2.");
        btIniciarMae.setToolTipText("Para iniciar e pausar pressione F12.");
        btReiniciarParar.setToolTipText("Para parar ou reiniciar pressione F6.");
        lbAjuda.setToolTipText("Para obter ajuda pressione H.");
        painelVelocidadeCozinheiro.setToolTipText("Para almentar ou diminuir pressione W/S");
        painelVelocidadeMae.setToolTipText("Para almentar ou diminuir pressione UP/Down");
        painelEstadoCozinheira.setToolTipText("Clique em um estado para mais informações.");
        painelEstadoMae.setToolTipText("Clique em um estado para mais informações.");

        //Tornar componentes invisíveis.
        lbBolo.setVisible(false);
        spCozinheiro.setVisible(false);
        spMae.setVisible(false);
        btReiniciarParar.setVisible(false);
        lbFalaMae.setVisible(false);
        lbFalaCozinheiro.setVisible(false);

        //Tornar componentes desabilitados.
        codigoMae.setEditable(false);
        codigoCozinheiro.setEditable(false);

        //Desabilitando focos dos botões.
        jcMae.setFocusable(false);
        jcCozinheiro.setFocusable(false);
        btReiniciarParar.setFocusable(false);
        btIniciarMae.setFocusable(false);
        btIniciarCozinheiro.setFocusable(false);
        velocidadeCozinheiro.setFocusable(false);
        velocidadeMae.setFocusable(false);

        /*
         *
         * Adicionando os componentes a Tela.
         *
         */

        getContentPane().add(lbFilho);
        getContentPane().add(lbBolo);
        getContentPane().add(lbFalaMae);
        getContentPane().add(lbFalaCozinheiro);
        getContentPane().add(lbCozinheiro);
        getContentPane().add(lbMae);
        getContentPane().add(btIniciarCozinheiro);
        getContentPane().add(btIniciarMae);
        getContentPane().add(btReiniciarParar);
        getContentPane().add(lbFogao);
        getContentPane().add(lbMesaMae);
        getContentPane().add(lbMesa);
        getContentPane().add(painelEstadoCozinheira);
        getContentPane().add(painelEstadoMae);
        getContentPane().add(jcCozinheiro);
        getContentPane().add(jcMae);
        getContentPane().add(spCozinheiro);
        getContentPane().add(spMae);
        getContentPane().add(painelVelocidadeCozinheiro);
        getContentPane().add(painelVelocidadeMae);
        getContentPane().add(lbAjuda);

    }

    //Altera imagem do Toolkit.
    private Image icone() {
        getClass().getResource("");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image imagem = tk.getImage(getClass().getResource("/Imagens/java.png"));
        return imagem;
    }

    private static String codigoParcialMae() {
        return "class Mae extends Thread {\n"
                + "     int velocidade = 10;\n"
                + "     boolean sentido = ESQUERDA;\n"
                + "     Bolo bolo;\n"
                + "     public void run(){\n"
                + "         while(! encontrouBalcao){\n"
                + "             andar();\n"
                + "         }\n"
                + "         while(!encontrouBolo()){\n"
                + "             synchronized(bolo){\n"
                + "                 bolo.wait();\n"
                + "             }\n"
                + "         }\n"
                + "         pegarBolo();\n"
                + "         mudarSentido();\n"
                + "         while(!encontrouFilho()){\n"
                + "             andar();\n"
                + "         }\n"
                + "     }\n\n"
                + "     public void andar(){\n"
                + "           incrementarPosicao();\n"
                + "           try {\n"
                + "               Thread.sleep(VELOC_MAXIMA/velocidade);\n"
                + "            } catch (InterruptedException e){}\n"
                + "     }\n"
                + "} //...";
    }

    private static String codigoParcialCozinheiro() {
        return "class Cozinheiro extends Thread {\n"
                + "     int velocidade = 10;\n"
                + "     boolean sentido = ESQUERDA;\n"
                + "     Bolo bolo;\n"
                + "     public void run(){\n"
                + "         while(! levouBoloBalcao()){\n"
                + "             andar();\n"
                + "             if(encontrouFogao()){\n"
                + "                 pegarBolo();\n"
                + "                 mudarSentido();\n"
                + "             }\n"
                + "         }\n"
                + "         synchronized(bolo){\n"
                + "             bolo.notifyAll();\n"
                + "         }\n"
                + "     }\n"
                + "\n"
                + "     public void andar(){\n"
                + "           incrementarPosicao();\n"
                + "           try {\n"
                + "               Thread.sleep(VELOC_MAXIMA/velocidade);\n"
                + "            } catch (InterruptedException e){}\n"
                + "     }\n"
                + "} //...";
    }

    /*
     *
     * GETs AND SETs
     *
     */
    public JButton getBtIniciarCozinheiro() {
        return btIniciarCozinheiro;
    }

    public void setBtIniciarCozinheiro(JButton btIniciarCozinheiro) {
        this.btIniciarCozinheiro = btIniciarCozinheiro;
    }

    public JButton getBtIniciarMae() {
        return btIniciarMae;
    }

    public void setBtIniciarMae(JButton btIniciarMae) {
        this.btIniciarMae = btIniciarMae;
    }

    public JButton getBtReiniciarParar() {
        return btReiniciarParar;
    }

    public void setBtReiniciarParar(JButton btReiniciarParar) {
        this.btReiniciarParar = btReiniciarParar;
    }

    public JTextArea getCodigoCozinheiro() {
        return codigoCozinheiro;
    }

    public void setCodigoCozinheiro(JTextArea codigoCozinheiro) {
        this.codigoCozinheiro = codigoCozinheiro;
    }

    public JTextArea getCodigoMae() {
        return codigoMae;
    }

    public void setCodigoMae(JTextArea codigoMae) {
        this.codigoMae = codigoMae;
    }

    public JCheckBox getJcCozinheiro() {
        return jcCozinheiro;
    }

    public void setJcCozinheiro(JCheckBox jcCozinheiro) {
        this.jcCozinheiro = jcCozinheiro;
    }

    public JCheckBox getJcMae() {
        return jcMae;
    }

    public void setJcMae(JCheckBox jcMae) {
        this.jcMae = jcMae;
    }

    public JLabel getLbBolo() {
        return lbBolo;
    }

    public void setLbBolo(JLabel lbBolo) {
        this.lbBolo = lbBolo;
    }

    public JLabel getLbCozinheiro() {
        return lbCozinheiro;
    }

    public void setLbCozinheiro(JLabel lbCozinheiro) {
        this.lbCozinheiro = lbCozinheiro;
    }

    public JLabel getLbEstadoCozinheiroDormindo() {
        return lbEstadoCozinheiroDormindo;
    }

    public void setLbEstadoCozinheiroDormindo(JLabel lbEstadoCozinheiroDormindo) {
        this.lbEstadoCozinheiroDormindo = lbEstadoCozinheiroDormindo;
    }

    public JLabel getLbEstadoCozinheiroEsperando() {
        return lbEstadoCozinheiroEsperando;
    }

    public void setLbEstadoCozinheiroEsperando(JLabel lbEstadoCozinheiroEsperando) {
        this.lbEstadoCozinheiroEsperando = lbEstadoCozinheiroEsperando;
    }

    public JLabel getLbEstadoCozinheiroExecutando() {
        return lbEstadoCozinheiroExecutando;
    }

    public void setLbEstadoCozinheiroExecutando(JLabel lbEstadoCozinheiroExecutando) {
        this.lbEstadoCozinheiroExecutando = lbEstadoCozinheiroExecutando;
    }

    public JLabel getLbEstadoCozinheiroNova() {
        return lbEstadoCozinheiroNova;
    }

    public void setLbEstadoCozinheiroNova(JLabel lbEstadoCozinheiroIniciada) {
        this.lbEstadoCozinheiroNova = lbEstadoCozinheiroIniciada;
    }

    public JLabel getLbEstadoCozinheiroIniciada() {
        return lbEstadoCozinheiroIniciada;
    }

    public void setLbEstadoCozinheiroIniciada(JLabel lbEstadoCozinheiroIniciada) {
        this.lbEstadoCozinheiroIniciada = lbEstadoCozinheiroIniciada;
    }

    public JLabel getLbEstadoCozinheiroTerminada() {
        return lbEstadoCozinheiroTerminada;
    }

    public void setLbEstadoCozinheiroTerminada(JLabel lbEstadoCozinheiroTerminada) {
        this.lbEstadoCozinheiroTerminada = lbEstadoCozinheiroTerminada;
    }

    public JLabel getLbEstadoMaeDormindo() {
        return lbEstadoMaeDormindo;
    }

    public void setLbEstadoMaeDormindo(JLabel lbEstadoMaeDormindo) {
        this.lbEstadoMaeDormindo = lbEstadoMaeDormindo;
    }

    public JLabel getLbEstadoMaeEsperando() {
        return lbEstadoMaeEsperando;
    }

    public void setLbEstadoMaeEsperando(JLabel lbEstadoMaeEsperando) {
        this.lbEstadoMaeEsperando = lbEstadoMaeEsperando;
    }

    public JLabel getLbEstadoMaeExecutando() {
        return lbEstadoMaeExecutando;
    }

    public void setLbEstadoMaeExecutando(JLabel lbEstadoMaeExecutando) {
        this.lbEstadoMaeExecutando = lbEstadoMaeExecutando;
    }

    public JLabel getLbEstadoMaeNova() {
        return lbEstadoMaeNova;
    }

    public void setLbEstadoMaeNova(JLabel lbEstadoMaeIniciada) {
        this.lbEstadoMaeNova = lbEstadoMaeIniciada;
    }

    public JLabel getLbEstadoMaeIniciada() {
        return lbEstadoMaeIniciada;
    }

    public void setLbEstadoMaeIniciada(JLabel lbEstadoMaeIniciada) {
        this.lbEstadoMaeIniciada = lbEstadoMaeIniciada;
    }

    public JLabel getLbEstadoMaeTerminada() {
        return lbEstadoMaeTerminada;
    }

    public void setLbEstadoMaeTerminada(JLabel lbEstadoMaeTerminada) {
        this.lbEstadoMaeTerminada = lbEstadoMaeTerminada;
    }

    public JLabel getLbFalaCozinheiro() {
        return lbFalaCozinheiro;
    }

    public void setLbFalaCozinheiro(JLabel lbFalaCozinheiro) {
        this.lbFalaCozinheiro = lbFalaCozinheiro;
    }

    public JLabel getLbFalaMae() {
        return lbFalaMae;
    }

    public void setLbFalaMae(JLabel lbFalaMae) {
        this.lbFalaMae = lbFalaMae;
    }

    public JLabel getLbFilho() {
        return lbFilho;
    }

    public void setLbFilho(JLabel lbFilho) {
        this.lbFilho = lbFilho;
    }

    public JLabel getLbFogao() {
        return lbFogao;
    }

    public void setLbFogao(JLabel lbFogao) {
        this.lbFogao = lbFogao;
    }

    public JLabel getLbMae() {
        return lbMae;
    }

    public void setLbMae(JLabel lbMae) {
        this.lbMae = lbMae;
    }

    public JLabel getLbMesa() {
        return lbMesa;
    }

    public void setLbMesa(JLabel lbMesa) {
        this.lbMesa = lbMesa;
    }

    public JLabel getLbMesaMae() {
        return lbMesaMae;
    }

    public void setLbMesaMae(JLabel lbMesaMae) {
        this.lbMesaMae = lbMesaMae;
    }

    public JPanel getPainelEstadoCozinheira() {
        return painelEstadoCozinheira;
    }

    public void setPainelEstadoCozinheira(JPanel panelEstadoCozinheira) {
        this.painelEstadoCozinheira = panelEstadoCozinheira;
    }

    public JPanel getPainelEstadoMae() {
        return painelEstadoMae;
    }

    public void setPainelEstadoMae(JPanel panelEstadoMae) {
        this.painelEstadoMae = panelEstadoMae;
    }

    public JScrollPane getSpCozinheiro() {
        return spCozinheiro;
    }

    public void setSpCozinheiro(JScrollPane spCozinheiro) {
        this.spCozinheiro = spCozinheiro;
    }

    public JScrollPane getSpMae() {
        return spMae;
    }

    public void setSpMae(JScrollPane spMae) {
        this.spMae = spMae;
    }

    public JSlider getVelocidadeCozinheiro() {
        return velocidadeCozinheiro;
    }

    public void setVelocidadeCozinheiro(JSlider velocidadeCozinheiro) {
        this.velocidadeCozinheiro = velocidadeCozinheiro;
    }

    public JSlider getVelocidadeMae() {
        return velocidadeMae;
    }

    public void setVelocidadeMae(JSlider velocidadeMae) {
        this.velocidadeMae = velocidadeMae;
    }
}
