//Classe GuiLogin

package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiLogin extends JFrame {
    private JTextField tfLogin;
    private JLabel lbSenha, lbLogin;
    private JButton btLogar, btCancelar;
    private JPasswordField pfSenha;

    public GuiLogin() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Login no Sistema");
        setBounds(400, 200, 280, 200); // Ajustei para abrir mais centralizado
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha a aplicação ao sair

        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        lbLogin = new JLabel("Login:");
        lbSenha = new JLabel("Senha:");
        btLogar = new JButton("Logar");
        btCancelar = new JButton("Cancelar");

        lbLogin.setBounds(30, 30, 80, 25);
        tfLogin.setBounds(100, 30, 120, 25);
        lbSenha.setBounds(30, 75, 80, 25);
        pfSenha.setBounds(100, 75, 120, 25);
        btLogar.setBounds(30, 120, 100, 25);
        btCancelar.setBounds(135, 120, 100, 25);

        add(lbLogin);
        add(tfLogin);
        add(lbSenha);
        add(pfSenha);
        add(btLogar);
        add(btCancelar);
    }

    private void definirEventos() {
        btLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = tfLogin.getText().trim();
                String senha = String.valueOf(pfSenha.getPassword()).trim();

                if (login.equals("admin") && senha.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    dispose(); // Fecha a janela de login
                    principal.index.executarSistema(); // Chama o menu principal
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
                    tfLogin.setText("");
                    pfSenha.setText("");
                    tfLogin.requestFocus();
                }
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}