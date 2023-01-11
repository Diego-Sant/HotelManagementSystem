package Hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddRoom extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	private JTextField t1, t2;
	private JComboBox<String> cb1, cb2, cb3;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JButton b1, b2;
	
	public AddRoom() {
		super("Adicionar quartos");
		jp = new JPanel();
		setSize(1000, 450);
		setLocation(450, 200);
		jp.setLayout(null);
		this.setResizable(false);
		
		jp.setBounds(0, 0, 983, 410);
		jp.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Adicionar quartos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));																											
		add(jp);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Rooms.png"));
		Image img2 = img.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l7 = new JLabel(img3);
		l7.setBounds(450, 20, 500, 370);
		jp.add(l7);
		
		l1 = new JLabel("Número do quarto");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("futura", Font.BOLD, 14));
		l1.setBounds(50, 80, 152, 22);
		jp.add(l1);
		
		t1 = new JTextField("ex: 011");
		t1.setForeground(Color.GRAY);
		t1.setBounds(184, 82, 156, 20);
		jp.add(t1);
		t1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t1.getText().equals("ex: 011")) {
                    t1.setText("");
                    t1.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t1.getText().isEmpty()) {
                    t1.setForeground(Color.GRAY);
                    t1.setText("ex: 011");
                }
            }
        });
		
		//---------------------------------------------------------------------
		
		l2 = new JLabel("Disponibilidade");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("futura", Font.BOLD, 14));
		l2.setBounds(50, 120, 152, 22);
		jp.add(l2);
		
		cb1 = new JComboBox<String>(new String[] { "Disponível", "Ocupado" });
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(184, 122, 156, 20);
		jp.add(cb1);
		addWindowListener(new WindowAdapter(){ 
			  public void windowOpened(WindowEvent e){ 
			    cb1.requestFocus();
			  } 
			});
		
		//---------------------------------------------------------------------
		
		l3 = new JLabel("Status de limpeza");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("futura", Font.BOLD, 14));
		l3.setBounds(50, 160, 152, 22);
		jp.add(l3);
		
		cb2 = new JComboBox<String>(new String[] { "Limpo", "Sujo" });
		cb2.setBackground(Color.WHITE);
		cb2.setBounds(184, 162, 156, 20);
		jp.add(cb2);
		
		//---------------------------------------------------------------------
		
		l4 = new JLabel("Diária");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("futura", Font.BOLD, 14));
		l4.setBounds(50, 200, 152, 22);
		jp.add(l4);
		
		t2 = new JTextField("R$ ");
		t2.setBounds(184, 202, 156, 20);
		jp.add(t2);
		
		//---------------------------------------------------------------------
		
		l5 = new JLabel("Tipo de quarto");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("futura", Font.BOLD, 14));
		l5.setBounds(50, 240, 152, 22);
		jp.add(l5);
		
		cb3 = new JComboBox<String>(new String[] { "Solteiro", "Duplo solteiro", "Casal", "Dormitório", "Apartamento", "Master", "Deluxe"});
		cb3.setBackground(Color.WHITE);
		cb3.setBounds(184, 242, 156, 20);
		jp.add(cb3);
		
		//---------------------------------------------------------------------
		
		b1 = new JButton("Adicionar");
		b1.addActionListener(this);
		b1.setBounds(198, 331, 111, 33);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(64, 331, 111, 33);
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
					String room_number = t1.getText();
					String availability = (String) cb1.getSelectedItem();
					String clean_status = (String) cb2.getSelectedItem();
					String price = t2.getText();
					String room_type = (String) cb3.getSelectedItem();
					
					String query = "INSERT INTO room VALUES('" 
							+ room_number + "', '" + availability + "', '" 
							+ clean_status + "', '" + price + "', '" 
							+ room_type + "')";
					
					c.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso!");
					this.setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}else if (actionEvent.getSource() == b2) {
				this.setVisible(false);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AddRoom().setVisible(true);
	}

}
