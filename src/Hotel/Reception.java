package hotel;

import java.awt.Color;
import java.awt.Dimension;
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

public class Reception extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jp;
	
	public Reception() {
		super("Recepção");
        setSize(850, 570);
        this.setResizable(false);
        
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(0, 0, 833, 530);
		jp.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(50, 190, 166), 2), // ((r: g: b:), thickness)
		"Recepção", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(50, 190, 166))); // titleFont: null
		add(jp);
		
        ImageIcon img1  = new ImageIcon(ClassLoader.getSystemResource("Icons/Reception.jpg"));
        Image img2 = img1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel l1 = new JLabel(img3);
        l1.setBounds(250,30,550,470);
        jp.add(l1);
        
        //---------------------------------------------------------------------
        
        JButton bttnNewCustomer = new JButton("Formulário de novo cliente");
        bttnNewCustomer.setFocusable(false);
        bttnNewCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					NewCustomer custom = new NewCustomer();
					custom.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnNewCustomer.setBounds(10, 30, 220, 30);
        bttnNewCustomer.setBackground(Color.BLACK);
        bttnNewCustomer.setForeground(Color.WHITE);
        jp.add(bttnNewCustomer);
        
        //---------------------------------------------------------------------
        
        JButton bttnRoom = new JButton("Quartos");
        bttnRoom.setFocusable(false);
        bttnRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					Room room = new Room();
					room.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnRoom.setBounds(10, 70, 220, 30);
        bttnRoom.setBackground(Color.BLACK);
        bttnRoom.setForeground(Color.WHITE);
        jp.add(bttnRoom);
        
      //---------------------------------------------------------------------
        
        JButton bttnEmpInfo = new JButton("Informações dos funcionários");
        bttnEmpInfo.setFocusable(false);
        bttnEmpInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					Employee emp = new Employee();
					emp.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnEmpInfo.setBounds(10, 150, 220, 30);
        bttnEmpInfo.setBackground(Color.BLACK);
        bttnEmpInfo.setForeground(Color.WHITE);
        jp.add(bttnEmpInfo);
        
        //---------------------------------------------------------------------
        
        JButton bttnCustInfo = new JButton("Informações dos clientes");
        bttnCustInfo.setFocusable(false);
        bttnCustInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					CustomerInfo cust = new CustomerInfo();
					cust.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnCustInfo.setBounds(10, 190, 220, 30);
        bttnCustInfo.setBackground(Color.BLACK);
        bttnCustInfo.setForeground(Color.WHITE);
        jp.add(bttnCustInfo);
        
        //---------------------------------------------------------------------
        
        JButton bttnManagerInfo = new JButton("Informações do gerente");
        bttnManagerInfo.setFocusable(false);
        bttnManagerInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					//ManagerInfo manager = new ManagerInfo();
					//manager.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnManagerInfo.setBounds(10, 230, 220, 30);
        bttnManagerInfo.setBackground(Color.BLACK);
        bttnManagerInfo.setForeground(Color.WHITE);
        jp.add(bttnManagerInfo);
        
        //---------------------------------------------------------------------
        
        JButton bttnCheckOutInfo = new JButton("Check-out");
        bttnCheckOutInfo.setFocusable(false);
        bttnCheckOutInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					//CheckOut check = new CheckOut();
					//check.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnCheckOutInfo.setBounds(10, 270, 220, 30);
        bttnCheckOutInfo.setBackground(Color.BLACK);
        bttnCheckOutInfo.setForeground(Color.WHITE);
        jp.add(bttnCheckOutInfo);
        
        //---------------------------------------------------------------------
        
        JButton bttnCheckStatus = new JButton("Atualizar status de check");
        bttnCheckStatus.setFocusable(false);
        bttnCheckStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					//UpdateCheck updateCheck = new UpdateCheck();
					//updateCheck.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnCheckStatus.setBounds(10, 310, 220, 30);
        bttnCheckStatus.setBackground(Color.BLACK);
        bttnCheckStatus.setForeground(Color.WHITE);
        jp.add(bttnCheckStatus);
        
        //---------------------------------------------------------------------
	
        JButton bttnRoomStatus = new JButton("Atualizar status de quartos");
        bttnRoomStatus.setFocusable(false);
        bttnRoomStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					//UpdateRoom updateRoom = new UpdateRoom();
					//updateRoom.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnRoomStatus.setBounds(10, 350, 220, 30);
        bttnRoomStatus.setBackground(Color.BLACK);
        bttnRoomStatus.setForeground(Color.WHITE);
        jp.add(bttnRoomStatus);
        
        //---------------------------------------------------------------------
        
        JButton bttnPickUp = new JButton("Serviço de transporte");
        bttnPickUp.setFocusable(false);
        bttnPickUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					//PickUp pickUp = new PickUp();
					//pickUp.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnPickUp.setBounds(10, 390, 220, 30);
        bttnPickUp.setBackground(Color.BLACK);
        bttnPickUp.setForeground(Color.WHITE);
        jp.add(bttnPickUp);
        
        //---------------------------------------------------------------------
        
        JButton bttnSearchRoom = new JButton("Procurar quartos");
        bttnSearchRoom.setFocusable(false);
        bttnSearchRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					//SearchRoom search = new SearchRoom();
					//search.setVisible(true);
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnSearchRoom.setBounds(10, 430, 220, 30);
        bttnSearchRoom.setBackground(Color.BLACK);
        bttnSearchRoom.setForeground(Color.WHITE);
        jp.add(bttnSearchRoom);
        
        //---------------------------------------------------------------------
        
        JButton bttnBack = new JButton("Voltar ao menu");
        bttnBack.setFocusable(false);
        bttnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					setVisible(false);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        bttnBack.setBounds(10, 470, 220, 30);
        bttnBack.setBackground(Color.BLACK);
        bttnBack.setForeground(Color.WHITE);
        jp.add(bttnBack);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		new Reception().setVisible(true);;
	}

}
