package Hotel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	private JPanel jp;
	private JTable table;
	private JLabel l1, l2, l3, l4, l5, l6;
	JButton b1, b2;
	
	public Room() {
		super("Quartos");
		
		jp = new JPanel();
		setSize(1100, 600);
		setLocation(450, 200);
		jp.setLayout(null);
		this.setResizable(false);
		
		jp.setBounds(0, 0, 1083, 560);
		jp.setBackground(Color.WHITE);
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Quartos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));																											
		add(jp);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Hotel.png"));
		Image img2 = img.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l6 = new JLabel(img3);
		l6.setBounds(500, -30, 600, 600);
		jp.add(l6);
		
		table = new JTable();
		table.setBounds(10, 40, 500, 400);
		jp.add(table);
		
		l5 = new JLabel("Nº do quarto");
		l5.setBounds(12, 20, 90, 14);
		jp.add(l5);
		
		l1 = new JLabel("Disponibilidade");
		l1.setBounds(106, 20, 90, 14);
		jp.add(l1);
		
		l2 = new JLabel("Status de limpeza");
		l2.setBounds(208, 20, 120, 14);
		jp.add(l2);
		
		l3 = new JLabel("Diária");
		l3.setBounds(330, 20, 46, 14);
		jp.add(l3);
		
		l4 = new JLabel("Tipo de quarto");
		l4.setBounds(405, 20, 90, 14);
		jp.add(l4);
		
		b1 = new JButton("Carregar dados");
		b1.setBounds(270, 470, 150, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		jp.add(b1);
		
		b2 = new JButton("Voltar");
		b2.setBounds(80, 470, 150, 30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.addActionListener(this);
		jp.add(b2);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			if (actionEvent.getSource() == b1) {
				try {
					Conn c = new Conn();
					String query = "SELECT * FROM room";
					ResultSet rs = c.st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e) {
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
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room room = new Room();
					room.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
