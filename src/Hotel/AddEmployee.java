package Hotel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class AddEmployee extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JTextField t1, t2, t3, t4, t5, t6;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JButton b1, b2;
	JPanel jp;
	JComboBox<String> cb;
	Choice ch1;
	
	public AddEmployee() {
		super("Adicionar funcionários");
		jp = new JPanel();
		setSize(900, 600);
		jp.setLayout(null);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		jp.setBounds(0, 0, 883, 560);
		jp.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Adicionar funcionários", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));
																													
		add(jp);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Employee.png"));
		Image img2 = img.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l8 = new JLabel(img3);
		l8.setBounds(350, 60, 600, 370);
		jp.add(l8);
		
        //---------------------------------------------------------------------
		
		l1 = new JLabel("Nome");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("futura", Font.BOLD, 14));
		l1.setBounds(60, 50, 80, 27);
		jp.add(l1);
		
        t1 = new JTextField("Nome completo");
        t1.setForeground(Color.GRAY);
        t1.setBounds(155, 50, 200, 27);
		jp.add(t1);
		t1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t1.getText().equals("Nome completo")) {
                    t1.setText("");
                    t1.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t1.getText().isEmpty()) {
                    t1.setForeground(Color.GRAY);
                    t1.setText("Nome completo");
                }
            }
        });
		
        //---------------------------------------------------------------------
		
		l2 = new JLabel("Nascimento");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("futura", Font.BOLD, 14));
		l2.setBounds(60, 100, 100, 27);
		jp.add(l2);
		
        try {
			t2 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t2.setBounds(155, 100, 200, 27);
		jp.add(t2);
        
        //---------------------------------------------------------------------
		
		l3 = new JLabel("Sexo");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("futura", Font.BOLD, 14));
		l3.setBounds(60, 150, 80, 27);
		jp.add(l3);
	        
	    cb = new JComboBox<String>(new String[] { "Homem", "Mulher", "Indefinido" });
		cb.setSelectedIndex(-1);
	    cb.setBounds(155, 150, 150, 27);
	    cb.setBackground(Color.WHITE);
		jp.add(cb);
		addWindowListener(new WindowAdapter(){ 
			  public void windowOpened(WindowEvent e){ 
			    cb.requestFocus();
			  } 
			});
		
        //---------------------------------------------------------------------
		
		l4 = new JLabel("Área");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("futura", Font.BOLD, 14));
		l4.setBounds(60, 200, 80, 27);
		jp.add(l4);
		
        ch1 = new Choice();
        ch1.setBounds(155, 202, 150, 27);
		ch1.setForeground(Color.BLACK);
        ch1.add("Recepcionista");
        ch1.add("Carregador(a)");
        ch1.add("Limpeza");
        ch1.add("Cozinheiro(a)");
        ch1.add("Chef");
        ch1.add("Serviço de quarto");
        ch1.add("Garçom/Garçonete");
        ch1.add("Gerente");
        ch1.add("Contabilidade");
        ch1.add("Segurança");
        ch1.add("Marketing");
        ch1.add("Concierge");
        ch1.add("Advogado");
		jp.add(ch1);
		
        //---------------------------------------------------------------------
		
		l5 = new JLabel("Salário");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("futura", Font.BOLD, 14));
		l5.setBounds(60, 300, 80, 27);
		jp.add(l5);

        t3 = new JTextField("R$ ");
        t3.setBounds(155, 300, 200, 27);
		jp.add(t3);
		
        //---------------------------------------------------------------------
		
		l6 = new JLabel("Celular");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("futura", Font.BOLD, 14));
		l6.setBounds(60, 350, 80, 27);
		jp.add(l6);
	        
        try {
			t4 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t4.setBounds(155, 350, 200, 27);
		jp.add(t4);
		
        //---------------------------------------------------------------------
		
		l7 = new JLabel("CPF");
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("futura", Font.BOLD, 14));
		l7.setBounds(60, 400, 80, 27);
		jp.add(l7);

        try {
			t5 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t5.setBounds(155, 400, 200, 27);
		jp.add(t5);
		
        //---------------------------------------------------------------------
		
		l9 = new JLabel("Email");
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("futura", Font.BOLD, 14));
		l9.setBounds(60, 250, 80, 27);
		jp.add(l9);
		
        t6 = new JTextField("ex: aquashotel@gmail.com");
        t6.setForeground(Color.GRAY);
        t6.setBounds(155, 250, 200, 27);
		jp.add(t6);
		t6.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t6.getText().equals("ex: aquashotel@gmail.com")) {
                    t6.setText("");
                    t6.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t6.getText().isEmpty()) {
                    t6.setForeground(Color.GRAY);
                    t6.setText("ex: aquashotel@gmail.com");
                }
            }
        });
		
        //---------------------------------------------------------------------
		
		b1 = new JButton("Adicionar");
		b1.addActionListener(this);
		b1.setBounds(204, 480, 111, 33);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(74, 480, 111, 33);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		jp.add(b2);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			
			if (actionEvent.getSource() == b1) {
				try {
					Conn c = new Conn();
					String name = t1.getText();
					String birthDate = t2.getText();
					String gender = (String) cb.getSelectedItem();
					String job = ch1.getSelectedItem();
					String salary = t3.getText();
					String phone = t4.getText();
					String cpf = t5.getText();
					String email = t6.getText();
					
					String query = "INSERT INTO employee VALUES('" 
							+ name + "', '" + birthDate + "', '" + gender 
							+ "', '" + job + "', '" + salary + "', '" 
							+ phone + "', '" + cpf + "', '" + email + "')";
					
					c.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
					this.setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getSource() == b2) {
				this.setVisible(false);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AddEmployee().setVisible(true);
	}

}
