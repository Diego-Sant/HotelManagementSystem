package Hotel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class NewCustomer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel jp;
	private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
	JComboBox<String> cb, cb2, cb3;
	Choice ch, ch2, ch3;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JButton b1, b2;
	
	public NewCustomer() throws SQLException {
		super("Adicionar cliente(s)");
		jp = new JPanel();
		setSize(850, 550);
		setLocation(530, 200);
		jp.setLayout(null);
		this.setResizable(false);
		
		jp.setBounds(0, 0, 833, 510);
		jp.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Adicionar cliente(s)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));																											
		add(jp);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Clients.png"));
		Image img2 = img.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l10 = new JLabel(img3);
		l10.setBounds(480, 20, 300, 500);
		jp.add(l10);
		
        //---------------------------------------------------------------------
		
		l1 = new JLabel("Identificação");
		l1.setFont(new Font("futura", Font.BOLD, 14));
		l1.setBounds(35, 36, 200, 14);
		jp.add(l1);
		
		cb = new JComboBox<String>(new String[] {"CPF", "RG", "Passaporte", "Carteira de motorista" });
		cb.setBounds(140, 33, 150, 20);
		cb.setBackground(Color.WHITE);
		jp.add(cb);
		cb.addActionListener(this);
		
        try {
			t1 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t1.setBounds(310, 33, 150, 20);
		jp.add(t1);
		
        try {
			t2 = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t2.setBounds(310, 33, 150, 20);
		jp.add(t2);
		
        try {
			t3 = new JFormattedTextField(new MaskFormatter("############"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t3.setBounds(310, 33, 150, 20);
		jp.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(310, 33, 150, 20);
		jp.add(t4);
		
        //---------------------------------------------------------------------
		
		l2 = new JLabel("Celular");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("futura", Font.BOLD, 14));
		l2.setBounds(35, 111, 200, 14);
		jp.add(l2);
	        
        try {
			t5 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t5.setBounds(140, 111, 150, 20);
		jp.add(t5);
		
        //---------------------------------------------------------------------
		
		l3 = new JLabel("Nome");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("futura", Font.BOLD, 14));
		l3.setBounds(35, 71, 200, 14);
		jp.add(l3);
		
        t6 = new JTextField();
        t6.setBounds(140, 71, 150, 20);
		jp.add(t6);
		
        //---------------------------------------------------------------------
		
		l4 = new JLabel("Sexo");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("futura", Font.BOLD, 14));
		l4.setBounds(35, 151, 200, 14);
		jp.add(l4);
	        
	    cb2 = new JComboBox<String>(new String[] { "Homem", "Mulher", "Indefinido" });
		cb2.setSelectedIndex(-1);
	    cb2.setBounds(140, 151, 150, 20);
	    cb2.setBackground(Color.WHITE);
		jp.add(cb2);
		
        //---------------------------------------------------------------------
		
		l5 = new JLabel("País");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("futura", Font.BOLD, 14));
		l5.setBounds(35, 191, 100, 14);
		jp.add(l5);
		
        ch = new Choice();
        ch.setBounds(140, 191, 150, 20);
		ch.setForeground(Color.BLACK);
        ch.add("Brasil");
        ch.add("Afeganistão");
        ch.add("África do Sul");
        ch.add("Albânia");
        ch.add("Alemanha");
        ch.add("Andorra");
        ch.add("Angola");
        ch.add("Antiga e Barbuda");
        ch.add("Arábia Saudita");
        ch.add("Argélia");
        ch.add("Argentina");
        ch.add("Arménia");
        ch.add("Austrália");
        ch.add("Áustria");
        ch.add("Azerbaijão");
        ch.add("Bahamas");
        ch.add("Bangladexe");
        ch.add("Barbados");
        ch.add("Barém");
        ch.add("Bélgica");
        ch.add("Belize");
        ch.add("Benim");
        ch.add("Bielorrússia");
        ch.add("Bósnia e Herzegovina");
        ch.add("Botsuana");
        ch.add("Brunei");
        ch.add("Bulgária");
        ch.add("Burquina Faso");
        ch.add("Burúndi");
        ch.add("Butão");
        ch.add("Cabo Verde");
        ch.add("Camarões");
        ch.add("Camboja");
        ch.add("Canadá");
        ch.add("Catar");
        ch.add("Cazaquistão");
        ch.add("Chade");
        ch.add("Chile");
        ch.add("China");
        ch.add("Chipre");
        ch.add("Colômbia");
        ch.add("Comores");
        ch.add("Congo-Brazzaville");
        ch.add("Coreia do Norte");
        ch.add("Coreia do Sul");
        ch.add("Cosovo");
        ch.add("Costa do Marfim");
        ch.add("Costa Rica");
        ch.add("Croácia");
        ch.add("Cuaite");
        ch.add("Cuba");
        ch.add("Dinamarca");
        ch.add("Dominica");
        ch.add("Egito");
        ch.add("Emirados Árabes Unidos");
        ch.add("Equador");
        ch.add("Eritreia");
        ch.add("Eslováquia");
        ch.add("Eslovénia");
        ch.add("Espanha");
        ch.add("Essuatíni");
        ch.add("Estado da Palestina");
        ch.add("Estados Unidos");
        ch.add("Estónia");
        ch.add("Etiópia");
        ch.add("Fiji");
        ch.add("Filipinas");
        ch.add("Finlândia");
        ch.add("França");
        ch.add("Gabão");
        ch.add("Gâmbia");
        ch.add("Gana");
        ch.add("Geórgia");
        ch.add("Granada");
        ch.add("Grécia");
        ch.add("Guatemala");
        ch.add("Guiana");
        ch.add("Guiné");
        ch.add("Guiné Equatorial");
        ch.add("Guiné-Bissau");
        ch.add("Haiti");
        ch.add("Honduras");
        ch.add("Iémen");
        ch.add("Ilhas Marechal");
        ch.add("Índia");
        ch.add("Indonésia");
        ch.add("Irão");
        ch.add("Iraque");
        ch.add("Irlanda");
        ch.add("Islândia");
        ch.add("Israel");
        ch.add("Itália");
        ch.add("Jamaica");
        ch.add("Japão");
        ch.add("Jibuti");
        ch.add("Jordânia");
        ch.add("Laus");
        ch.add("Lesoto");
        ch.add("Letónia");
        ch.add("Líbano");
        ch.add("Libéria");
        ch.add("Líbia");
        ch.add("Listenstaine");
        ch.add("Lituânia");
        ch.add("Luxemburgo");
        ch.add("Macedónia do Norte");
        ch.add("Madagascar");
        ch.add("Malásia");
        ch.add("Maláui");
        ch.add("Maldivas");
        ch.add("Mali");
        ch.add("Malta");
        ch.add("Marrocos");
        ch.add("Maurícia");
        ch.add("Mauritânia");
        ch.add("México");
        ch.add("Mianmar");
        ch.add("Micronésia");
        ch.add("Moçambique");
        ch.add("Moldávia");
        ch.add("Mónaco");
        ch.add("Mongólia");
        ch.add("Montenegro");
        ch.add("Namíbia");
        ch.add("Nauru");
        ch.add("Nepal");
        ch.add("Nicarágua");
        ch.add("Níger");
        ch.add("Nigéria");
        ch.add("Noruega");
        ch.add("Nova Zelândia");
        ch.add("Omã");
        ch.add("Países Baixos");
        ch.add("Palau");
        ch.add("Panamá");
        ch.add("Papua Nova Guiné");
        ch.add("Paquistão");
        ch.add("Paraguai");
        ch.add("Peru");
        ch.add("Polônia");
        ch.add("Portugal");
        ch.add("Quénia");
        ch.add("Quirguistão");
        ch.add("Quiribáti");
        ch.add("Reino Unido");
        ch.add("República Centro-Africana");
        ch.add("República Checa");
        ch.add("República Democrática do Congo");
        ch.add("República Dominicana");
        ch.add("Roménia");
        ch.add("Ruanda");
        ch.add("Rússia");
        ch.add("Salomão");
        ch.add("Samoa");
        ch.add("Santa Lúcia");
        ch.add("São Cristóvão e Neves");
        ch.add("São Marinho");
        ch.add("São Tomé e Príncipe");
        ch.add("São Vicente e Granadinas");
        ch.add("Seicheles");
        ch.add("Senegal");
        ch.add("Serra Leoa");
        ch.add("Sérvia");
        ch.add("Singapura");
        ch.add("Síria");
        ch.add("Somália");
        ch.add("Sri Lanca");
        ch.add("Sudão");
        ch.add("Sudão do Sul");
        ch.add("Suécia");
        ch.add("Suíça");
        ch.add("Suriname");
        ch.add("Tailândia");
        ch.add("Taiuã");
        ch.add("Tajiquistão");
        ch.add("Tanzânia");
        ch.add("Timor-Leste");
        ch.add("Togo");
        ch.add("Tonga");
        ch.add("Trindade e Tobago");
        ch.add("Tunísia");
        ch.add("Turcomenistão");
        ch.add("Turquia");
        ch.add("Tuvalu");
        ch.add("Ucrânia");
        ch.add("Uganda");
        ch.add("Uruguai");
        ch.add("Usbequistão");
        ch.add("Vanuatu");
        ch.add("Vaticano");
        ch.add("Venezuela");
        ch.add("Vietname");
        ch.add("Zâmbia");
        ch.add("Zimbábue");
        jp.add(ch);
        
        //---------------------------------------------------------------------
        
		l6 = new JLabel("N° do quarto");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("futura", Font.BOLD, 14));
		l6.setBounds(35, 233, 100, 14);
		jp.add(l6);
		
        ch2 = new Choice();
        try {
        	Conn c = new Conn();
        	ResultSet rs = c.st.executeQuery("SELECT * FROM room");
        	
        	while (rs.next()) {
        		ch2.add(rs.getString("room_number"));
        	}
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        ch2.setBounds(140, 231, 150, 20);
        jp.add(ch2);
        
        //---------------------------------------------------------------------
        
		l11 = new JLabel("Diária");
		l11.setForeground(Color.BLACK);
		l11.setFont(new Font("futura", Font.BOLD, 14));
		l11.setBounds(310, 233, 50, 14);
		jp.add(l11);
		
        ch3 = new Choice();
        try {
        	Conn c = new Conn();
        	ResultSet rs = c.st.executeQuery("SELECT * FROM room");
        	
        	while (rs.next()) {
        		ch3.add(rs.getString("price"));
        	}
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        ch3.setBounds(370, 231, 100, 20);
        jp.add(ch3);
        
        //---------------------------------------------------------------------
        
		l7 = new JLabel("Status");
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("futura", Font.BOLD, 14));
		l7.setBounds(35, 271, 200, 14);
		jp.add(l7);
	        
	    cb3 = new JComboBox<String>(new String[] { "Pagou pela internet", "Pagou durante a hospedagem", "Não pagou" });
		cb3.setSelectedIndex(-1);
	    cb3.setBounds(140, 271, 150, 20);
	    cb3.setBackground(Color.WHITE);
		jp.add(cb3);
		
        //---------------------------------------------------------------------
		
		l8 = new JLabel("Check-in");
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("futura", Font.BOLD, 14));
		l8.setBounds(35, 311, 200, 14);
		jp.add(l8);
	        
        try {
			t7 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t7.setBounds(140, 311, 150, 20);
		jp.add(t7);
		
		l13 = new JLabel("Check-out");
		l13.setForeground(Color.BLACK);
		l13.setFont(new Font("futura", Font.BOLD, 14));
		l13.setBounds(35, 351, 200, 14);
		jp.add(l13);
	        
        try {
			t9 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        t9.setBounds(140, 351, 150, 20);
		jp.add(t9);
		
        //---------------------------------------------------------------------
		
		l9 = new JLabel("Total");
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("futura", Font.BOLD, 14));
		l9.setBounds(35, 391, 200, 14);
		jp.add(l9);

        t8 = new JTextField("R$ ");
        t8.setBounds(140, 391, 150, 20);
		jp.add(t8);
		
		l12 = new JLabel("(Diária x dias)");
		l12.setForeground(Color.BLACK);
		l12.setFont(new Font("futura", Font.BOLD, 14));
		l12.setBounds(310, 393, 200, 14);
		jp.add(l12);
		
        //---------------------------------------------------------------------
		
		b1 = new JButton("Adicionar");
		b1.addActionListener(this);
		b1.setBounds(170, 440, 111, 33);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(40, 440, 111, 33);
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
					String id = (String) cb.getSelectedItem();
					String cpf = t1.getText();
					String rg = t2.getText();
					String passport_number = t3.getText();
					String cnh_rg = t4.getText();
					String name = t6.getText();
					String phone = t5.getText();
					String gender = (String) cb2.getSelectedItem();
					String country = ch.getSelectedItem();
					String room_number = ch2.getSelectedItem();
					String status = (String) cb3.getSelectedItem();
					String checkin = t7.getText();
					String checkout = t9.getText();
					String deposit = t8.getText();
					
					String query = "INSERT INTO customer VALUES('" 
							+ id + "', '" + cpf + "', '" + rg + "', '" 
							+ passport_number + "', '" + cnh_rg + "', '" 
							+ name + "', '" + phone + "', '" + gender + "', '" 
							+ country + "', '" + room_number + "', '" 
							+ status + "', '" + checkin + "', '" + checkout + "', '" + deposit + "')";
					
					c.st.executeQuery(query);
					JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
					new Reception().setVisible(true);
					setVisible(false);
										
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getSource() == b2) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (cb.getSelectedItem().toString().equalsIgnoreCase("CPF")) {
			t1.setVisible(true);
		}
		else {
			t1.setVisible(false);
		}
		if (cb.getSelectedItem().toString().equalsIgnoreCase("RG")) {
			t2.setVisible(true);
		}
		else {
			t2.setVisible(false);
		}
		if (cb.getSelectedItem().toString().equalsIgnoreCase("Carteira de motorista")) {
			t3.setVisible(true);
		}
		else {
			t3.setVisible(false);
		}
		if (cb.getSelectedItem().toString().equalsIgnoreCase("Passaporte")) {
			t4.setVisible(true);
		}
		else {
			t4.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
