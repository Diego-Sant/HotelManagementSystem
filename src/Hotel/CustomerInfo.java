package hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	private JButton b1, b2;
	private JTable tb;
	
	public CustomerInfo() {
		super("Clientes");
		
		jp = new JPanel();
		setSize(1120, 600);
		this.setResizable(false);
		jp.setLayout(null);
		
		jp.setBounds(0, 0, 1103, 560);
		jp.setBackground(Color.WHITE);
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));																											
		add(jp);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		tb = new JTable();
		tb.setBounds(10, 40, 1085, 450);
		jp.add(tb);
		
		l1 = new JLabel("Identificação");
		l1.setBounds(10, 20, 75, 14);
		jp.add(l1);
		
		l2 = new JLabel("CPF");
		l2.setBounds(113, 20, 45, 14);
		jp.add(l2);
		
		l3 = new JLabel("RG");
		l3.setBounds(192, 20, 45, 14);
		jp.add(l3);
		
		l4 = new JLabel("Passaporte");
		l4.setBounds(245, 20, 70, 14);
		jp.add(l4);
		
		l4 = new JLabel("CNH");
		l4.setBounds(345, 20, 45, 14);
		jp.add(l4);
		
		l6 = new JLabel("Nome");
		l6.setBounds(413, 20, 46, 14);
		jp.add(l6);
		
		l5 = new JLabel("Celular");
		l5.setBounds(486, 20, 46, 14);
		jp.add(l5);
		
		l7 = new JLabel("Sexo");
		l7.setBounds(570, 20, 46, 14);
		jp.add(l7);
		
		l8 = new JLabel("País");
		l8.setBounds(646, 20, 46, 14);
		jp.add(l8);
		
		l9 = new JLabel("Nº do quarto");
		l9.setBounds(709, 20, 80, 14);
		jp.add(l9);
		
		l10 = new JLabel("Status");
		l10.setBounds(800, 20, 46, 14);
		jp.add(l10);
		
		l12 = new JLabel("Check-In");
		l12.setBounds(872, 20, 60, 14);
		jp.add(l12);
		
		l13 = new JLabel("Check-Out");
		l13.setBounds(947, 20, 60, 14);
		jp.add(l13);
		
		l11 = new JLabel("Total");
		l11.setBounds(1035, 20, 46, 14);
		jp.add(l11);
		
		b1 = new JButton("Carregar dados");
		b1.setBounds(510, 500, 150, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		jp.add(b1);
		
		b2 = new JButton("Voltar");
		b2.setBounds(350, 500, 150, 30);
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
					String query = "SELECT * FROM customer";
					ResultSet rs = c.st.executeQuery(query);
					tb.setModel(DbUtils.resultSetToTableModel(rs));
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
					CustomerInfo frame = new CustomerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close() {
		this.dispose();
	}

}
