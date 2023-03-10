package hotel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
	private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
	JComboBox<String> cb, cb2, cb3;
	Choice ch, ch2, ch3;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JButton b1, b2, b3;
	
	public NewCustomer() throws SQLException {
		super("Adicionar cliente(s)");
		jp = new JPanel();
		setSize(850, 550);
		jp.setLayout(null);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
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
		
		l1 = new JLabel("Identifica????o");
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
		
		l5 = new JLabel("Pa??s");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("futura", Font.BOLD, 14));
		l5.setBounds(35, 191, 100, 14);
		jp.add(l5);
		
        ch = new Choice();
        ch.setBounds(140, 191, 150, 20);
		ch.setForeground(Color.BLACK);
        ch.add("Brasil");
        ch.add("Afeganist??o");
        ch.add("??frica do Sul");
        ch.add("Alb??nia");
        ch.add("Alemanha");
        ch.add("Andorra");
        ch.add("Angola");
        ch.add("Antiga e Barbuda");
        ch.add("Ar??bia Saudita");
        ch.add("Arg??lia");
        ch.add("Argentina");
        ch.add("Arm??nia");
        ch.add("Austr??lia");
        ch.add("??ustria");
        ch.add("Azerbaij??o");
        ch.add("Bahamas");
        ch.add("Bangladexe");
        ch.add("Barbados");
        ch.add("Bar??m");
        ch.add("B??lgica");
        ch.add("Belize");
        ch.add("Benim");
        ch.add("Bielorr??ssia");
        ch.add("B??snia e Herzegovina");
        ch.add("Botsuana");
        ch.add("Brunei");
        ch.add("Bulg??ria");
        ch.add("Burquina Faso");
        ch.add("Bur??ndi");
        ch.add("But??o");
        ch.add("Cabo Verde");
        ch.add("Camar??es");
        ch.add("Camboja");
        ch.add("Canad??");
        ch.add("Catar");
        ch.add("Cazaquist??o");
        ch.add("Chade");
        ch.add("Chile");
        ch.add("China");
        ch.add("Chipre");
        ch.add("Col??mbia");
        ch.add("Comores");
        ch.add("Congo-Brazzaville");
        ch.add("Coreia do Norte");
        ch.add("Coreia do Sul");
        ch.add("Cosovo");
        ch.add("Costa do Marfim");
        ch.add("Costa Rica");
        ch.add("Cro??cia");
        ch.add("Cuaite");
        ch.add("Cuba");
        ch.add("Dinamarca");
        ch.add("Dominica");
        ch.add("Egito");
        ch.add("Emirados ??rabes Unidos");
        ch.add("Equador");
        ch.add("Eritreia");
        ch.add("Eslov??quia");
        ch.add("Eslov??nia");
        ch.add("Espanha");
        ch.add("Essuat??ni");
        ch.add("Estado da Palestina");
        ch.add("Estados Unidos");
        ch.add("Est??nia");
        ch.add("Eti??pia");
        ch.add("Fiji");
        ch.add("Filipinas");
        ch.add("Finl??ndia");
        ch.add("Fran??a");
        ch.add("Gab??o");
        ch.add("G??mbia");
        ch.add("Gana");
        ch.add("Ge??rgia");
        ch.add("Granada");
        ch.add("Gr??cia");
        ch.add("Guatemala");
        ch.add("Guiana");
        ch.add("Guin??");
        ch.add("Guin?? Equatorial");
        ch.add("Guin??-Bissau");
        ch.add("Haiti");
        ch.add("Honduras");
        ch.add("I??men");
        ch.add("Ilhas Marechal");
        ch.add("??ndia");
        ch.add("Indon??sia");
        ch.add("Ir??o");
        ch.add("Iraque");
        ch.add("Irlanda");
        ch.add("Isl??ndia");
        ch.add("Israel");
        ch.add("It??lia");
        ch.add("Jamaica");
        ch.add("Jap??o");
        ch.add("Jibuti");
        ch.add("Jord??nia");
        ch.add("Laus");
        ch.add("Lesoto");
        ch.add("Let??nia");
        ch.add("L??bano");
        ch.add("Lib??ria");
        ch.add("L??bia");
        ch.add("Listenstaine");
        ch.add("Litu??nia");
        ch.add("Luxemburgo");
        ch.add("Maced??nia do Norte");
        ch.add("Madagascar");
        ch.add("Mal??sia");
        ch.add("Mal??ui");
        ch.add("Maldivas");
        ch.add("Mali");
        ch.add("Malta");
        ch.add("Marrocos");
        ch.add("Maur??cia");
        ch.add("Maurit??nia");
        ch.add("M??xico");
        ch.add("Mianmar");
        ch.add("Micron??sia");
        ch.add("Mo??ambique");
        ch.add("Mold??via");
        ch.add("M??naco");
        ch.add("Mong??lia");
        ch.add("Montenegro");
        ch.add("Nam??bia");
        ch.add("Nauru");
        ch.add("Nepal");
        ch.add("Nicar??gua");
        ch.add("N??ger");
        ch.add("Nig??ria");
        ch.add("Noruega");
        ch.add("Nova Zel??ndia");
        ch.add("Om??");
        ch.add("Pa??ses Baixos");
        ch.add("Palau");
        ch.add("Panam??");
        ch.add("Papua Nova Guin??");
        ch.add("Paquist??o");
        ch.add("Paraguai");
        ch.add("Peru");
        ch.add("Pol??nia");
        ch.add("Portugal");
        ch.add("Qu??nia");
        ch.add("Quirguist??o");
        ch.add("Quirib??ti");
        ch.add("Reino Unido");
        ch.add("Rep??blica Centro-Africana");
        ch.add("Rep??blica Checa");
        ch.add("Rep??blica Democr??tica do Congo");
        ch.add("Rep??blica Dominicana");
        ch.add("Rom??nia");
        ch.add("Ruanda");
        ch.add("R??ssia");
        ch.add("Salom??o");
        ch.add("Samoa");
        ch.add("Santa L??cia");
        ch.add("S??o Crist??v??o e Neves");
        ch.add("S??o Marinho");
        ch.add("S??o Tom?? e Pr??ncipe");
        ch.add("S??o Vicente e Granadinas");
        ch.add("Seicheles");
        ch.add("Senegal");
        ch.add("Serra Leoa");
        ch.add("S??rvia");
        ch.add("Singapura");
        ch.add("S??ria");
        ch.add("Som??lia");
        ch.add("Sri Lanca");
        ch.add("Sud??o");
        ch.add("Sud??o do Sul");
        ch.add("Su??cia");
        ch.add("Su????a");
        ch.add("Suriname");
        ch.add("Tail??ndia");
        ch.add("Taiu??");
        ch.add("Tajiquist??o");
        ch.add("Tanz??nia");
        ch.add("Timor-Leste");
        ch.add("Togo");
        ch.add("Tonga");
        ch.add("Trindade e Tobago");
        ch.add("Tun??sia");
        ch.add("Turcomenist??o");
        ch.add("Turquia");
        ch.add("Tuvalu");
        ch.add("Ucr??nia");
        ch.add("Uganda");
        ch.add("Uruguai");
        ch.add("Usbequist??o");
        ch.add("Vanuatu");
        ch.add("Vaticano");
        ch.add("Venezuela");
        ch.add("Vietname");
        ch.add("Z??mbia");
        ch.add("Zimb??bue");
        jp.add(ch);
        
        //---------------------------------------------------------------------
        
		l6 = new JLabel("N?? do quarto");
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
        ch2.setBounds(140, 231, 80, 20);
        jp.add(ch2);
        
        //---------------------------------------------------------------------
        
		l11 = new JLabel("Di??ria");
		l11.setForeground(Color.BLACK);
		l11.setFont(new Font("futura", Font.BOLD, 14));
		l11.setBounds(310, 233, 50, 14);
		jp.add(l11);
		
		ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("Icons/Check.png"));
		Image img5 = img4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon img6 = new ImageIcon(img5);
		b3 = new JButton(img6);
		b3.setBounds(230, 231, 20, 20);
		b3.setBackground(new Color(238, 238, 238));
		b3.setBorderPainted(false);
		jp.add(b3);
		
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    
                    Conn c = new Conn();
                    String rn = ch2.getSelectedItem();
                    ResultSet rs = c.st.executeQuery("SELECT * FROM room HAVING room_number = " + rn);
                    
                    if(rs.next()){
                        t10.setText(rs.getString("price"));    
                    }
                }catch(Exception e){
                	e.printStackTrace();
                }
            }
        });
		
		t10 = new JTextField();
        t10.setBounds(370, 231, 100, 20);
        jp.add(t10);
        
        //---------------------------------------------------------------------
        
		l7 = new JLabel("Status");
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("futura", Font.BOLD, 14));
		l7.setBounds(35, 271, 200, 14);
		jp.add(l7);
	        
	    cb3 = new JComboBox<String>(new String[] { "Pagou pela internet", "Pagou durante a hospedagem", "N??o pagou" });
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
		
		l12 = new JLabel("(Di??ria x dias)");
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
							+ id + "', '" + phone + "', '" + name + "', '" 
							+ gender + "', '" + country + "', '" 
							+ room_number + "', '" + status + "', '" + deposit + "', '" 
							+ cpf + "', '" + rg + "', '" 
							+ passport_number + "', '" + cnh_rg + "', '" + checkin + "', '" + checkout + "')";
					
					String updateSQL = "UPDATE room SET availability = 'Indispon??vel' WHERE room_number = " + room_number;
					
					c.st.executeUpdate(query);
					c.st.executeUpdate(updateSQL);
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
