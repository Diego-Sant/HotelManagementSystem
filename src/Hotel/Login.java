package hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JLabel l1, l2, l3;
	JTextField tf;
	JPasswordField pf;
	JButton b1, b2;
	JPanel jp;
	
	Login() {
		super("Login");
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
       
        setSize(600,300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		jp = new JPanel();
		jp.setBounds(0, 0, 583, 260);
		jp.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166))); // titleFont: null
		add(jp);
		
		l1 = new JLabel("Usuário");
		l1.setFont(new Font("futura", Font.BOLD, 12));
		l1.setBounds(40, 70, 100, 30);
		add(l1);
		
		l2 = new JLabel("Senha");
		l2.setFont(new Font("futura", Font.BOLD, 12));
		l2.setBounds(40, 120, 100, 30);
		add(l2);
		
		tf = new JTextField();
		tf.setBounds(150, 70, 150, 30);
		add(tf);
		
		pf = new JPasswordField();
		pf.setBounds(150, 120, 150, 30);
		add(pf);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/IconLogin.png"));
		Image img2 = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l3 = new JLabel(img3);
		l3.setBounds(350, 30, 200, 200);
		add(l3);
		
		b1 = new JButton("Logar");
		b1.setBounds(180, 200, 120, 30);
		b1.setFont(new Font("futura", Font.BOLD, 15));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2 = new JButton("Sair");
		b2.setBounds(40, 200, 120, 30);
		b2.setFont(new Font("futura", Font.BOLD, 15));
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == b1) {
			try {
				Conn c = new Conn();
				String str = tf.getText();
				String str2 = new String(pf.getPassword());
				
				String query = "SELECT * FROM login WHERE username='"
						+ str + "' AND password='" + str2 + "'";
				
				ResultSet rs = c.st.executeQuery(query);
				
				if(rs.next()) {
					new Dashboard().setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Login inválido!");
					setVisible(false);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} else if (actionEvent.getSource() == b2) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Login();
	}

}
