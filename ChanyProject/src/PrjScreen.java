import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class PrjScreen {
	private JFrame frame;
	private JTextField nameTxt;
	private JTextField room_numTxt;
	private JTextField productTxt;
	private JTextField deliv_dateTxt;
	private JTextField box_locTxt;
	private JTextField namesearchTxt;
	private JTextField txtID;
	private JTextField txtPass;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrjScreen window = new PrjScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public PrjScreen() {
		initialize();
	}
	
	private void initialize() {
		Customer customer = new Customer();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		ImagePanel firstscreenPanel = new ImagePanel(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/택배프로그램 배경화면.png").getImage());
		frame.getContentPane().add(firstscreenPanel);
		
		ImagePanel studPanel = new ImagePanel(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/학생 배경화면.png").getImage());
		frame.getContentPane().add(studPanel);
		studPanel.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("\uD559\uC0DD\uC6A9 \uD398\uC774\uC9C0\uC785\uB2C8\uB2E4");
		lblNewLabel.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 23));
		lblNewLabel.setBounds(83, 44, 226, 62);
		studPanel.add(lblNewLabel);
		
		namesearchTxt = new JTextField();
		namesearchTxt.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		namesearchTxt.setBounds(439, 282, 338, 70);
		studPanel.add(namesearchTxt);
		namesearchTxt.setColumns(10);
		
		JButton gofirstButton_stud = new JButton("초기화면으로 돌아가기");
		gofirstButton_stud.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 18));
		gofirstButton_stud.setBounds(800,700,300,40);
		studPanel.add(gofirstButton_stud);
		gofirstButton_stud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "초기화면으로 돌아갑니다.");
				studPanel.setVisible(false);
				namesearchTxt.setText("");
				firstscreenPanel.setVisible(true);
			}
		});
		
		JButton namesearchButton = new JButton("\uAC80\uC0C9");
		namesearchButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 28));
		namesearchButton.setBounds(822, 282, 102, 70);
		studPanel.add(namesearchButton);
		namesearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = namesearchTxt.getText();
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "학생의 이름을 입력해주세요.");
				}
				else{
					JOptionPane.showMessageDialog(null, "학생의 이름이 검색됩니다.");
					JOptionPane.showMessageDialog(null, customer.selectCustomers(name));
					namesearchTxt.setText("");
			        customer.deleteCustomer(name);
			        }
				}	
			});
		
		JPanel delPanel = new JPanel();
		delPanel.setBackground(Color.WHITE);
		delPanel.setBounds(0, 0, 1186, 763);
		frame.getContentPane().add(delPanel);
		delPanel.setLayout(null);
		delPanel.setVisible(false);
		
		
		JLabel label = new JLabel("택배 기사용 페이지입니다");
		label.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 23));
		label.setBounds(83, 44, 338, 62);
		delPanel.add(label);
		
		JLabel label_1 = new JLabel("\uD559\uC0DD \uC774\uB984");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 27));
		label_1.setBounds(176, 205, 200, 52);
		delPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\uD638\uC2E4");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 27));
		label_2.setBounds(176, 326, 200, 52);
		delPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\uD0DD\uBC30 \uBB3C\uD488");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 27));
		label_3.setBounds(176, 449, 200, 52);
		delPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\uBCF4\uAD00 \uB0A0\uC9DC");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 27));
		label_4.setBounds(610, 205, 200, 52);
		delPanel.add(label_4);
		
		JLabel label_5 = new JLabel("\uBCF4\uAD00 \uAD6C\uC5ED");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 27));
		label_5.setBounds(610, 326, 200, 52);
		delPanel.add(label_5);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		nameTxt.setBounds(388, 205, 212, 52);
		delPanel.add(nameTxt);
		nameTxt.setColumns(10);
		
		room_numTxt = new JTextField();
		room_numTxt.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		room_numTxt.setColumns(10);
		room_numTxt.setBounds(388, 326, 212, 52);
		delPanel.add(room_numTxt);
		
		productTxt = new JTextField();
		productTxt.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		productTxt.setColumns(10);
		productTxt.setBounds(388, 449, 212, 52);
		delPanel.add(productTxt);
		
		deliv_dateTxt = new JTextField();
		deliv_dateTxt.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		deliv_dateTxt.setColumns(10);
		deliv_dateTxt.setBounds(822, 205, 212, 52);
		delPanel.add(deliv_dateTxt);
		
		box_locTxt = new JTextField();
		box_locTxt.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		box_locTxt.setColumns(10);
		box_locTxt.setBounds(822, 326, 212, 52);
		delPanel.add(box_locTxt);
		
		JLabel label_6 = new JLabel("\uC608\uC2DC: \uD64D\uAE38\uB3D9 / M123\uD638 / \uC0DD\uC218 10\uBCD1 / 1\uC6D4 1\uC77C / A\uAD6C\uC5ED");
		label_6.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label_6.setBounds(176, 612, 491, 62);
		delPanel.add(label_6);
		
		JButton gofirstButton_del = new JButton("초기화면으로 돌아가기");
		gofirstButton_del.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 18));
		gofirstButton_del.setBounds(800, 700, 300, 40);
		delPanel.add(gofirstButton_del);
		gofirstButton_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "초기화면으로 돌아갑니다.");
				delPanel.setVisible(false);
				nameTxt.setText("");
				room_numTxt.setText("");
				productTxt.setText("");
				deliv_dateTxt.setText("");
				box_locTxt.setText("");
				firstscreenPanel.setVisible(true);
			}
		});
		
		JButton saveButton = new JButton("저장");
		saveButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 28));
		saveButton.setBounds(550, 553, 133, 49);
		delPanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTxt.getText();
				String room_num = room_numTxt.getText();
				String product = productTxt.getText();
				String deliv_date = deliv_dateTxt.getText();
				String box_loc = box_locTxt.getText();
				if(name.equals("")||room_num.equals("")||product.equals("")||deliv_date.equals("")||box_loc.equals("")) {
					JOptionPane.showMessageDialog(null, "빈 칸을 채워주세요.");
				}
				else {
				customer.createCustomer(name, room_num, product, deliv_date, box_loc);
				JOptionPane.showMessageDialog(null, "입력 사항이 저장되었습니다.");
				JOptionPane.showMessageDialog(null, "저장된 택배 정보: " + name + ", " + room_num + ", " + product + ", " + deliv_date + ", " + box_loc);
				nameTxt.setText("");
				room_numTxt.setText("");
				productTxt.setText("");
				deliv_dateTxt.setText("");
				box_locTxt.setText("");
				}
			}
		});
	
		
		JButton delButton = new JButton("");
		delButton.setBackground(Color.WHITE);
		delButton.setIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/택배기사버튼.png"));
		delButton.setPressedIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/택배기사버튼_pressed.png"));
		delButton.setBounds(710, 142, 300, 108);
		firstscreenPanel.add(delButton);
		delButton.setBorderPainted(false);
		delButton.setOpaque(false);
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstscreenPanel.setVisible(false);
				delPanel.setVisible(true);
			}
		});
		JButton studButton = new JButton("");
		studButton.setBackground(Color.WHITE);
		studButton.setIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/학생버튼.png"));
		studButton.setPressedIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/학생버튼_pressed.png"));
		studButton.setBounds(710, 289, 300, 108);
		firstscreenPanel.add(studButton);
		studButton.setBorderPainted(false);
		studButton.setOpaque(false);
		studButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstscreenPanel.setVisible(false);
				studPanel.setVisible(true);
			}
		});
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(0, 0, 1186, 763);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		infoPanel.setVisible(false);
		
		JLabel infoPanel_page = new JLabel("\uC804\uCCB4 \uC815\uBCF4 \uD654\uBA74\uC785\uB2C8\uB2E4 \uAD00\uB9AC\uC790\uC5D0\uAC8C\uB9CC \uAD8C\uD55C\uC774 \uC8FC\uC5B4\uC9D1\uB2C8\uB2E4");
		infoPanel_page.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 23));
		infoPanel_page.setBounds(83, 44, 594, 62);
		infoPanel.add(infoPanel_page);
		
		JLabel id = new JLabel("\uC544\uC774\uB514");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 28));
		id.setBounds(316, 224, 123, 73);
		infoPanel.add(id);
		
		JLabel pswrd = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pswrd.setHorizontalAlignment(SwingConstants.CENTER);
		pswrd.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 28));
		pswrd.setBounds(316, 320, 123, 73);
		infoPanel.add(pswrd);
		
		txtID = new JTextField();
		txtID.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		txtID.setBounds(480, 224, 296, 73);
		infoPanel.add(txtID);
		txtID.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		txtPass.setColumns(10);
		txtPass.setBounds(480, 320, 296, 73);
		infoPanel.add(txtPass);
		
		JButton gofirstButton_info = new JButton("초기화면으로 돌아가기");
		gofirstButton_info.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 18));
		gofirstButton_info.setBounds(800, 700, 300, 40);
		infoPanel.add(gofirstButton_info);
		gofirstButton_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "초기화면으로 돌아갑니다.");
				infoPanel.setVisible(false);
				firstscreenPanel.setVisible(true);
			}
		});
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 1186, 763);
		tablePanel.setVisible(false);
		String [] [] data = customer.getCustomers();
		String [] headers = new String [] {"학생 이름", "호실", "택배 물품", "보관 날짜", "보관 장소"};
		JTable resultTable = new JTable(data, headers);
		resultTable.setRowHeight(30);
		resultTable.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		resultTable.setAlignmentX(0);
		resultTable.setSize(800,600);
		resultTable.setPreferredScrollableViewportSize(new Dimension(1000,500));
		tablePanel.add(new JScrollPane(resultTable));
		frame.getContentPane().add(tablePanel);
		
		JButton gofirstButton_table = new JButton("초기화면으로 돌아가기");
		gofirstButton_table.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 18));
		gofirstButton_table.setBounds(800, 700, 300, 40);
		tablePanel.add(gofirstButton_table);
		gofirstButton_table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "초기화면으로 돌아갑니다.");
				tablePanel.setVisible(false);
				firstscreenPanel.setVisible(true);
			}
		});
		
		JButton logButton = new JButton("로그인");
		logButton.setBackground(Color.WHITE);
		logButton.setIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/로그인버튼.png"));
		logButton.setPressedIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/로그인버튼_pressed.png"));
		logButton.setBounds(816, 224, 172, 169);
		infoPanel.add(logButton);
		studButton.setBorderPainted(false);
		studButton.setOpaque(false);
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iD = "전홍찬";
				String pass = "2018320158";
				
				if(iD.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "로그인되었습니다. 저장된 정보가 보여집니다.");
					infoPanel.setVisible(false);
					tablePanel.setVisible(true);
					resultTable.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
				}
				txtID.setText("");
				txtPass.setText("");
			}
		});
		
		JButton infoButton = new JButton("");
		infoButton.setBackground(Color.WHITE);
		infoButton.setIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/전체정보버튼.png"));
		infoButton.setPressedIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/전체정보버튼_pressed.png"));
		infoButton.setBounds(710, 544, 172, 56);
		firstscreenPanel.add(infoButton);
		infoButton.setBorderPainted(false);
		infoButton.setOpaque(false);
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstscreenPanel.setVisible(false);
				infoPanel.setVisible(true);
			}
		});
		
		JButton closeButton = new JButton("");
		closeButton.setBackground(Color.WHITE);
		closeButton.setIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/종료버튼.png"));
		closeButton.setPressedIcon(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/종료버튼_pressed.png"));
		closeButton.setBounds(887, 544, 123, 56);
		firstscreenPanel.add(closeButton);
		closeButton.setBorderPainted(false);
		closeButton.setOpaque(false);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showOptionDialog(frame, "프로그램을 정말로 종료하겠습니까?", "종료",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(choice == 0) System.exit(0);
			}
		});
		frame.setSize(firstscreenPanel.getWidth(), firstscreenPanel.getHeight());
	}
}
	class ImagePanel extends JPanel{
		private Image img;
		
		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}
		
		public int getWidth() {
			return  img.getWidth(null);
		}
		
		public int getHeight() {
			return img.getHeight(null);
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}