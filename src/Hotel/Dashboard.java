package Hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel jp;
	
	public Dashboard() {
		super("Sistem de gestão do hotel");
		
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        setSize(1750, 1000);
        setLocation(100, 20);
        
		jp = new JPanel();
		jp.setBounds(0, 0, 1733, 938);
		jp.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 2), // ((r: g: b:), thickness)
		"Menu Principal", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.WHITE)); // titleFont: null
		add(jp);
		
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Icons/FundoHotel2.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1750, 1000, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2); 
        JLabel NewLabel = new JLabel(img3);
        NewLabel.setBounds(0, 0, 1750, 1000); 
        add(NewLabel);
        
        JLabel l1 = new JLabel("AGUAS HOTEL");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("futura", Font.BOLD, 45));
        l1.setBounds(700, 60, 1000, 85);
        NewLabel.add(l1);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        setJMenuBar(menuBar);
        
        JMenu HMMenu = new JMenu("Gerenciar hotel");
        HMMenu.setForeground(new Color(29, 113, 123));
        menuBar.add(HMMenu);
        
        JMenuItem HMMenuItem = new JMenuItem("Recepção");
        HMMenu.add(HMMenuItem);
        
        JMenu ADMMenu = new JMenu("Administração");
        ADMMenu.setForeground(new Color(253, 173, 62));
        menuBar.add(ADMMenu);
        
        JMenuItem ADMMenuItem1 = new JMenuItem("Adicionar funcionários");
        ADMMenu.add(ADMMenuItem1);
        
        JMenuItem ADMMenuItem2 = new JMenuItem("Adicionar quartos");
        ADMMenu.add(ADMMenuItem2);
        
        JMenuItem ADMMenuItem3 = new JMenuItem("Adicionar motoristas");
        ADMMenu.add(ADMMenuItem3);
        
        ADMMenuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					new AddEmployee().setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        ADMMenuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					//new AddRoom().setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        ADMMenuItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					new AddDrivers().setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    	HMMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
            	try {
            		new Reception().setVisible(true);
            	}
            	catch (Exception e) {
            		e.printStackTrace();
            	}
            }
    	});
    	
    	setVisible(true);
	}
	
	public static void main(String[] args) {
		new Dashboard().setVisible(true);
	}
}
