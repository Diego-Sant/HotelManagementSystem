package Hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class HotelManagementSystem extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JLabel lb;
	JButton bttn;
	JPanel jp;
	
	public HotelManagementSystem() {
		super("Menu inicial");
		setSize(710, 444);
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		jp = new JPanel();
		jp.setBounds(0, 0, 694, 404);
		jp.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 2), // ((r: g: b:), thickness)
		"Bem vindo!", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE)); // titleFont: null
		add(jp);
		
		lb = new JLabel("");
		bttn = new JButton("Próximo");
		
		bttn.setBackground(Color.BLACK);
		bttn.setForeground(Color.WHITE);
		bttn.setFocusable(false);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/FundoHotel.png"));
		Image img2 = img.getImage().getScaledInstance(710, 444, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		lb = new JLabel(img3);
		
		JLabel lb2 = new JLabel("Sistema de gestão do hotel");
		lb2.setBounds(30, 300, 710, 100);
		lb2.setFont(new Font("gotham", Font.PLAIN, 30));
		lb2.setForeground(Color.WHITE);
		lb.add(lb2);
		
		bttn.setBounds(480, 325, 150, 50);
		lb.setBounds(0, 0, 710, 444);
		
		lb.add(bttn);
		add(lb);
		
		bttn.addActionListener(this);
		setVisible(true);
		
		while(true) {
			lb2.setVisible(true);
			try {
				Thread.sleep(2000); //1000 = 1 segundo
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			lb2.setVisible(false);
			try {
				Thread.sleep(1200);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Login().setVisible(true);
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		HotelManagementSystem window = new HotelManagementSystem();
		window.setVisible(true);
	}
}
