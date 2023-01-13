package hotel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private JPanel jp;
	private JTable tb;
	private JLabel l1, l2, l3, l4, l5, l6;
	JButton b1, b2;
	Choice ch;
	
	public PickUp() {
		super("Serviço de Pick-up");
		jp = new JPanel();
		setSize(800, 600);
		jp.setLayout(null);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		jp.setBounds(0, 0, 783, 560);
		jp.setBackground(Color.WHITE);
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Serviço de Pick-up", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));
		add(jp);
		
		l1 = new JLabel("Marca do carro");
		l1.setBounds(32, 40, 89, 14);
		jp.add(l1);
		
		ch = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.st.executeQuery("SELECT * FROM driver");
			
			while(rs.next()) {
				ch.add(rs.getString("brand"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ch.setBounds(125, 38, 150, 25);
		jp.add(ch);
		
		//---------------------------------------------------------------------
		
		tb = new JTable();
		tb.setBounds(10, 130, 760, 380);
		jp.add(tb);
		
		l2 = new JLabel("Nome");
		l2.setBounds(60, 100, 46, 14);
		jp.add(l2);
		
		l3 = new JLabel("Nascimento");
		l3.setBounds(195, 100, 70, 14);
		jp.add(l3);
		
		l4 = new JLabel("Sexo");
		l4.setBounds(369, 100, 46, 14);
		jp.add(l4);
		
		l5 = new JLabel("Agência");
		l5.setBounds(508, 100, 46, 14);
		jp.add(l5);
		
		l6 = new JLabel("Celular");
		l6.setBounds(661, 100, 46, 14);
		jp.add(l6);
		
		//---------------------------------------------------------------------
		
		b1 = new JButton("Checar");
		b1.addActionListener(this);
		b1.setBounds(450, 510, 120, 40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(230, 510, 120, 40);
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
					
					String queryName = "SELECT name, birthDate, gender, company, phone FROM driver WHERE brand = '" + ch.getSelectedItem() + "'";
					
					rs = c.st.executeQuery(queryName);
					tb.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getSource() == b2) {
				new Reception().setVisible(true);
				this.setVisible(false);
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
					PickUp frame = new PickUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

}
