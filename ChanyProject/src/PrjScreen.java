import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PrjScreen {

	private JFrame frame;
	
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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
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
		
		ImagePanel firstscreenPanel = new ImagePanel(new ImageIcon("C:/Users/com/git/ChanyProject/ChanyProject/image/택배프로그램 배경화면.png").getImage());
		frame.getContentPane().add(firstscreenPanel);
		
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
				System.exit(0);
			}
		});
		frame.setSize(firstscreenPanel.getWidth(), firstscreenPanel.getHeight());
		
		JPanel studPanel = new JPanel();
		studPanel.setBackground(Color.WHITE);
		studPanel.setBounds(0, 0, 1186, 763);
		frame.getContentPane().add(studPanel);
		studPanel.setLayout(null);
		studPanel.setVisible(false);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(0, 0, 1186, 763);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		infoPanel.setVisible(false);
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
	
	