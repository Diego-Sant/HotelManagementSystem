package hotel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UpdateRoom extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Connection conn = null;
	PreparedStatement st = null;
	private JPanel jp;
	private JTextField t1, t2, t3;
	private JLabel l1, l2, l3, l4;
	JButton b1, b2, b3;
	Choice ch;
	
	public UpdateRoom() {
		super("Atualizar info dos quartos");
		jp = new JPanel();
		setSize(1000, 450);
		jp.setLayout(null);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		jp.setBounds(0, 0, 983, 410);
		jp.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Atualizar info dos quartos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));
		add(jp);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/UpdateRoom.png"));
		Image img2 = img.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l4 = new JLabel(img3);
		l4.setBounds(380, 30, 600, 370);
		jp.add(l4);
		
		l2 = new JLabel("N° do quarto");
		l2.setBounds(27, 100, 90, 14);
		jp.add(l2);
		
		ch = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.st.executeQuery("SELECT * FROM room");
			
			while (rs.next()) {
				ch.add(rs.getString("room_number"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ch.setBounds(160, 100, 140, 20);
		jp.add(ch);
		
		l3 = new JLabel("Disponibilidade");
		l3.setBounds(27, 140, 90, 14);
		jp.add(l3);
		
		t1 = new JTextField();
		t1.setBounds(160, 140, 140, 20);
		jp.add(t1);
		t1.setColumns(10);
		
		l1 = new JLabel("Nome do cliente");
		l1.setBounds(27, 180, 100, 14);
		jp.add(l1);
		
		t3 = new JTextField();
		t3.setBounds(160, 180, 140, 20);
		jp.add(t3);
		t3.setColumns(10);
		
		l4 = new JLabel("Status de limpeza");
		l4.setBounds(27, 220, 110, 14);
		jp.add(l4);
		
		t2 = new JTextField();
		t2.setBounds(160, 220, 140, 20);
		jp.add(t2);
		t2.setColumns(10);
		
		b1 = new JButton("Atualizar");
		b1.addActionListener(this);
		b1.setBounds(180, 355, 89, 23);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(60, 355, 89, 23);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		jp.add(b2);
		
		b3 = new JButton("Checar informações");
		b3.addActionListener(this);
		b3.setBounds(90, 315, 150, 23);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		jp.add(b3);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String rn = ch.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs = c.st.executeQuery("SELECT * FROM room HAVING room_number = " + rn);
                    
                    while (rs.next()) {
                    	t1.setText(rs.getString("availability"));
                    	t2.setText(rs.getString("clean_status"));
                    }
                }catch(Exception e){
                	e.printStackTrace();
                }
                try{
                    Conn c = new Conn();
                    ResultSet rs2 = c.st.executeQuery("SELECT * FROM customer WHERE room_number = " + ch.getSelectedItem());
                    
                    while (rs2.next()) {
                    	t3.setText(rs2.getString("name"));
                    }
                }catch(Exception e){
                	e.printStackTrace();
                }
            }
        });
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			
			if (actionEvent.getSource() == b1) {
				try {
					Conn c = new Conn();
					
					String queryClean = "UPDATE room SET clean_status = '" + t2.getText() + "'";
					String queryCust = "UPDATE customer SET name = '" + t3.getText() + "'";
					
					c.st.executeUpdate(queryClean);
					c.st.executeUpdate(queryCust);
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
					new Reception().setVisible(true);
					setVisible(false);
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
					UpdateRoom frame = new UpdateRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

}
