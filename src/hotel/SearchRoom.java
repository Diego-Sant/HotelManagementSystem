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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private JPanel jp;
	private JTable tb;
	private JLabel l1, l2, l3, l4, l5;
	JCheckBox cb;
	JButton b1, b2;
	Choice ch;
	
	public SearchRoom() {
		super("Procurar quartos");
		jp = new JPanel();
		setSize(700, 500);
		jp.setLayout(null);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		jp.setBounds(0, 0, 683, 460);
		jp.setBackground(Color.WHITE);
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Procurar quartos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));
		add(jp);
		
		l1 = new JLabel("Tipo de quarto");
		l1.setBounds(50, 63, 96, 14);
		jp.add(l1);
		
		ch = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.st.executeQuery("SELECT * FROM room");
			
			while(rs.next()) {
				ch.add(rs.getString("room_type"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ch.setBounds(153, 60, 120, 20);
		jp.add(ch);
		
		//---------------------------------------------------------------------
		
		cb = new JCheckBox("Apenas quartos disponíveis");
		cb.setBounds(400, 60, 205, 23);
		cb.setBackground(Color.WHITE);
		jp.add(cb);
		
		//---------------------------------------------------------------------
		
		tb = new JTable();
		tb.setBounds(10, 150, 660, 240);
		jp.add(tb);
		
		l2 = new JLabel("N° do quarto");
		l2.setBounds(50, 130, 96, 14);
		jp.add(l2);
		
		l3 = new JLabel("Disponibilidade");
		l3.setBounds(210, 130, 96, 14);
		jp.add(l3);
		
		l5 = new JLabel("Status de limpeza");
		l5.setBounds(366, 130, 110, 14);
		jp.add(l5);
		
		l4 = new JLabel("Diária");
		l4.setBounds(560, 130, 96, 14);
		jp.add(l4);
		
		//---------------------------------------------------------------------
		
		b1 = new JButton("Checar");
		b1.addActionListener(this);
		b1.setBounds(380, 400, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(200, 400, 120, 30);
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
					
					String queryRoom = "SELECT room_number, availability, clean_status, price FROM room WHERE room_type = '" + ch.getSelectedItem() + "'";
					String queryCheck = "SELECT * FROM room WHERE availability = 'Disponível' AND room_type = '" + ch.getSelectedItem() + "'";
					
					rs = c.st.executeQuery(queryRoom);
					tb.setModel(DbUtils.resultSetToTableModel(rs));
					
					if (cb.isSelected()) {
						rs = c.st.executeQuery(queryCheck);
						tb.setModel(DbUtils.resultSetToTableModel(rs));
					}
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
					SearchRoom frame = new SearchRoom();
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
