package hotel;

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

public class AddDrivers extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel jp;
	private JTextField t1, t2, t3, t4, t5;
	private JComboBox<String> cb;
	
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JButton b1, b2;
	Choice ch1, ch2;
	
	public AddDrivers() {
		super("Adicionar motoristas");
		jp = new JPanel();
		setSize(1000, 500);
		jp.setLayout(null);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		jp.setBounds(0, 0, 983, 460);
		jp.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Adicionar motoristas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));																											
		add(jp);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Driver.png"));
		Image img2 = img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l8 = new JLabel(img3);
		l8.setBounds(400, 30, 600, 370);
		jp.add(l8);
		
        //---------------------------------------------------------------------
		
		JLabel l1 = new JLabel("Nome");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("futura", Font.BOLD, 14));
		l1.setBounds(54, 70, 102, 22);
		jp.add(l1);
		
        t1 = new JTextField("Nome completo");
        t1.setForeground(Color.GRAY);
        t1.setBounds(174, 72, 156, 20);
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
		
		JLabel l2 = new JLabel("Nascimento");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("futura", Font.BOLD, 14));
		l2.setBounds(54, 110, 102, 22);
		jp.add(l2);
		
        try {
			t2 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t2.setBounds(174, 112, 156, 20);
		jp.add(t2);
        
        //---------------------------------------------------------------------
		
		JLabel l3 = new JLabel("Sexo");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("futura", Font.BOLD, 14));
		l3.setBounds(54, 150, 102, 22);
		jp.add(l3);
	        
	    cb = new JComboBox<String>(new String[] { "Homem", "Mulher", "Indefinido" });
		cb.setSelectedIndex(-1);
	    cb.setBounds(174, 152, 156, 20);
	    cb.setBackground(Color.WHITE);
		jp.add(cb);
		addWindowListener(new WindowAdapter(){ 
			  public void windowOpened(WindowEvent e){ 
			    cb.requestFocus();
			  } 
			});
		
        //---------------------------------------------------------------------
		
		JLabel l4 = new JLabel("Agência");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("futura", Font.BOLD, 14));
		l4.setBounds(54, 190, 102, 22);
		jp.add(l4);
		
        t3 = new JTextField("Agência do carro");
        t3.setForeground(Color.GRAY);
        t3.setBounds(174, 192, 156, 20);
		jp.add(t3);
		t3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t3.getText().equals("Agência do carro")) {
                    t3.setText("");
                    t3.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t3.getText().isEmpty()) {
                    t3.setForeground(Color.GRAY);
                    t3.setText("Agência do carro");
                }
            }
        });
		
        //---------------------------------------------------------------------
		
		JLabel l5 = new JLabel("Marca");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("futura", Font.BOLD, 14));
		l5.setBounds(54, 230, 102, 22);
		jp.add(l5);
		
        ch1 = new Choice();
        ch1.setBounds(174, 232, 156, 20);
		ch1.setForeground(Color.BLACK);
        ch1.add("Agrale");
        ch1.add("Aston Martin");
        ch1.add("Audi");
        ch1.add("BMW");
        ch1.add("BYD");
        ch1.add("CAOA Chery");
        ch1.add("Chevrolet");
        ch1.add("Citroën");
        ch1.add("Dodge");
        ch1.add("Effa");
        ch1.add("Exeed");
        ch1.add("Ferrari");
        ch1.add("Fiat");
        ch1.add("Ford");
        ch1.add("Foton");
        ch1.add("Honda");
        ch1.add("Hyundai");
        ch1.add("Iveco");
        ch1.add("JAC");
        ch1.add("Jaguar");
        ch1.add("Jeep");
        ch1.add("Kia");
        ch1.add("Lamborghini");
        ch1.add("Land Rover");
        ch1.add("Lexus");
        ch1.add("Lifan");
        ch1.add("Maserati");
        ch1.add("McLaren");
        ch1.add("Mercedes-AMG");
        ch1.add("Mercedes-Benz");
        ch1.add("Mini");
        ch1.add("Mitsubishi");
        ch1.add("Nissan");
        ch1.add("Peugeot");
        ch1.add("Porsche");
        ch1.add("RAM");
        ch1.add("Renault");
        ch1.add("Rolls-Royce");
        ch1.add("Subaru");
        ch1.add("Suzuki");
        ch1.add("Toyota");
        ch1.add("Volkswagen");
        ch1.add("Volvo");
		jp.add(ch1);
		
        //---------------------------------------------------------------------
		
		JLabel l6 = new JLabel("Celular");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("futura", Font.BOLD, 14));
		l6.setBounds(54, 270, 102, 22);
		jp.add(l6);
	        
        try {
			t5 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t5.setBounds(174, 272, 156, 20);
		jp.add(t5);
		
        //---------------------------------------------------------------------
		
		JLabel l7 = new JLabel("CEP");
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("futura", Font.BOLD, 14));
		l7.setBounds(54, 310, 102, 22);
		jp.add(l7);

        try {
			t4 = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t4.setBounds(174, 312, 156, 20);
		jp.add(t4);
		
        //---------------------------------------------------------------------
		
		b1 = new JButton("Adicionar");
		b1.addActionListener(this);
		b1.setBounds(194, 380, 111, 33);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(74, 380, 111, 33);
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
					String company = t3.getText();
					String brand = ch1.getSelectedItem();
					String phone = t5.getText();
					String cep = t4.getText();
					
					String query = "INSERT INTO driver VALUES('" 
							+ name + "', '" + birthDate + "', '" + gender 
							+ "', '" + company + "', '" + brand + "', '" 
							+ phone + "', '" + cep + "')";
					
					c.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Motorista adicionado com sucesso!");
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
		new AddDrivers().setVisible(true);
	}

}
