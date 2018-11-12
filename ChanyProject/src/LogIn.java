import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LogIn {

	private JFrame frame;
	private JTextField txtID;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(0, 0, 1186, 763);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
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
		
		JButton logButton = new JButton("\uB85C\uADF8\uC778");
		logButton.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 35));
		logButton.setBounds(816, 224, 172, 169);
		infoPanel.add(logButton);
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iD = "전홍찬";
				String pass = "2018320158";
				
				if(iD.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "로그인되었습니다. 저장된 정보가 보여집니다.");
				} else {
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
				}
			}
		});
	}

}
