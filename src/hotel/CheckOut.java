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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CheckOut extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement st = null;
	private JPanel jp;
	private JTextField tf;
	private JLabel l1, l2, l3;
	JButton bttn, bttn2, bttn3;
	Choice ch;
	
	public CheckOut() {
		super("Check-Out");
		jp = new JPanel();
		setSize(800, 294);
		jp.setLayout(null);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		jp.setBounds(0, 0, 783, 254);
		jp.setBackground(Color.WHITE);
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Check-Out", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166)));																											
		add(jp);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Check.png"));
		Image img2 = img.getImage().getScaledInstance(34, 34, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		bttn = new JButton(img3);
		bttn.setBounds(290, 75, 34, 34);
		bttn.setBackground(Color.WHITE);
		bttn.setBorderPainted(false);
		jp.add(bttn);
		
        bttn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    
                    Conn c = new Conn();
                    String name = ch.getSelectedItem();
                    ResultSet rs = c.st.executeQuery("SELECT * FROM customer HAVING room_number = " + name);
                    
                    if(rs.next()){
                        tf.setText(rs.getString("name"));    
                    }
                }catch(Exception e){
                	e.printStackTrace();
                }
            }
        });
		
		ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("Icons/CheckOut.png"));
		Image img5 = img4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon img6 = new ImageIcon(img5);
		l3 = new JLabel(img6);
		l3.setBounds(400, 15, 400, 225);
		jp.add(l3);
		
		//---------------------------------------------------------------------
		
		l1 = new JLabel("N° do quarto");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("futura", Font.BOLD, 14));
		l1.setBounds(20, 85, 100, 14);
		jp.add(l1);
		
		ch = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.st.executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				ch.add(rs.getString("room_number"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ch.setBounds(130, 82, 150, 20);
		jp.add(ch);
		
		//---------------------------------------------------------------------
		
		l2 = new JLabel("Nome");
		l2.setFont(new Font("futura", Font.BOLD, 14));
		l2.setBounds(20, 132, 100, 14);
		jp.add(l2);
		
		tf = new JTextField();
		tf.setBounds(130, 132, 150, 20);
		jp.add(tf);
		
		//---------------------------------------------------------------------
		
		bttn2 = new JButton("Check-Out");
		bttn2.addActionListener(this);
		bttn2.setBounds(158, 200, 100, 25);
		bttn2.setBackground(Color.BLACK);
		bttn2.setForeground(Color.WHITE);
		jp.add(bttn2);
		
		bttn3 = new JButton("Voltar");
		bttn3.addActionListener(this);
		bttn3.setBounds(48, 200, 100, 25);
		bttn3.setBackground(Color.BLACK);
		bttn3.setForeground(Color.WHITE);
		jp.add(bttn3);
		
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			
			if (actionEvent.getSource() == bttn2) {
				String id = ch.getSelectedItem();
					
				String deleteSQL = "DELETE FROM customer WHERE room_number = " + id;
				String updateSQL = "UPDATE room SET availability = 'Disponível' WHERE room_number = " + id;
				String cleanSQL = "UPDATE room SET clean_status = 'Sujo' WHERE room_number = " + id;	
				
				Conn c = new Conn();
				try {
					
					c.st.executeUpdate(deleteSQL);
					c.st.executeUpdate(updateSQL);
					c.st.executeUpdate(cleanSQL);
					JOptionPane.showMessageDialog(null, "Check-Out realizado com sucesso!");
					new Reception().setVisible(true);
					setVisible(false);
	
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getSource() == bttn3) {
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
					CheckOut frame = new CheckOut();
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
