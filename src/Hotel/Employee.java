package Hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class Employee extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	private JPanel jp;
	private JTable tb;
	private JLabel l1, l2, l3, l4, l5, l6, l7;
	JButton b1, b2;
	
	public Employee() {
		super("Funcionários");
		
		jp = new JPanel();
		setSize(1035, 600);
		this.setResizable(false);
		jp.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		jp.setBounds(0, 0, 1483, 560);
		jp.setBackground(Color.WHITE);
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Funcionários", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));																											
		add(jp);
		
		tb = new JTable();
		tb.setBounds(10, 34, 1000, 450);
		jp.add(tb);
		
		l1 = new JLabel("Nome");
		l1.setBounds(12, 20, 46, 14);
		jp.add(l1);
		
		l2 = new JLabel("Nascimento");
		l2.setBounds(135, 20, 80, 14);
		jp.add(l2);
		
		l3 = new JLabel("Sexo");
		l3.setBounds(260, 20, 46, 14);
		jp.add(l3);
		
		l4 = new JLabel("Área");
		l4.setBounds(383, 20, 46, 14);
		jp.add(l4);
		
		l5 = new JLabel("Salário");
		l5.setBounds(510, 20, 46, 14);
		jp.add(l5);
		
		l5 = new JLabel("Celular");
		l5.setBounds(638, 20, 46, 14);
		jp.add(l5);
		
		l6 = new JLabel("CPF");
		l6.setBounds(763, 20, 46, 14);
		jp.add(l6);
		
		l7 = new JLabel("Email");
		l7.setBounds(885, 20, 46, 14);
		jp.add(l7);
		
		b1 = new JButton("Carregar dados");
		b1.setBounds(460, 500, 150, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		jp.add(b1);
		
		b2 = new JButton("Voltar");
		b2.setBounds(300, 500, 150, 30);
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
					String query = "SELECT * FROM employee";
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
					Employee frame = new Employee();
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
