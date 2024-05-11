package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JFrameDetails extends JFrame {

	private JPanel contentPane;
	private JButton jbuttonGioiThieu;
	private JPanel panelMainGioiThieu;
	private Map<String, Object> data;
	private JButton jbuttonLotrinh;
	private JButton jbuttonGiangVien;
	private JButton jbuttonDangKy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameDetails frame = new JFrameDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameDetails() {


		setResizable(false);
		setBounds(100, 100, 795, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jbuttonGioiThieu = new JButton("GIỚI THIỆU");
		jbuttonGioiThieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonGioiThieu_actionPerformed(e);;
			}
		});
//		jbuttonGioiThieu.addActionListener(ac);

		jbuttonGioiThieu.setBackground(new Color(153, 153, 255));
		jbuttonGioiThieu.setFocusPainted(false);
		jbuttonGioiThieu.setBorderPainted(false);
		jbuttonGioiThieu.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(jbuttonGioiThieu);

		jbuttonLotrinh = new JButton("LỘ TRÌNH");
		jbuttonLotrinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLotrinh_actionPerformed(e);
			}
		});
//		jbuttonLotrinh.addActionListener(ac);

		jbuttonLotrinh.setBackground(new Color(153, 153, 255));
		jbuttonLotrinh.setFocusPainted(false);
		jbuttonLotrinh.setBorderPainted(false);
		jbuttonLotrinh.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(jbuttonLotrinh);

		jbuttonGiangVien = new JButton("GIẢNG VIÊN");
		jbuttonGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonGiangVien_actionPerformed(e);
			}
		});
//		jbuttonGiangVien.addActionListener(ac);
		jbuttonGiangVien.setBackground(new Color(153, 153, 255));
		jbuttonGiangVien.setFocusPainted(false);
		jbuttonGiangVien.setBorderPainted(false);
		jbuttonGiangVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(jbuttonGiangVien);

		jbuttonDangKy = new JButton("ĐĂNG KÝ");
		jbuttonDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDangKy_actionPerformed(e);
			}
		});
//		jbuttonDangKy.addActionListener(ac);
		jbuttonDangKy.setBackground(new Color(153, 153, 255));
		jbuttonDangKy.setFocusPainted(false);
		jbuttonDangKy.setBorderPainted(false);
		jbuttonDangKy.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(jbuttonDangKy);

		panelMainGioiThieu = new JPanel();
		contentPane.add(panelMainGioiThieu, BorderLayout.CENTER);
		panelMainGioiThieu.setLayout(new BorderLayout(0, 0));

	}

	public void clearScreen() {
		panelMainGioiThieu.removeAll();
		panelMainGioiThieu.revalidate();
	}

	public void jbuttonGioiThieu_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelGioiThieu panelGioiThieu = new JPanelGioiThieu(data);
		panelMainGioiThieu.add(panelGioiThieu);
		panelGioiThieu.setVisible(true);

	}

	public JFrameDetails(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

	public void initJFrame() {
		JPanelGioiThieu panelGioiThieu = new JPanelGioiThieu(data);
		panelMainGioiThieu.add(panelGioiThieu);
		panelGioiThieu.setVisible(true);
	}

	public void jbuttonLotrinh_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelLoTrinh jPanelLoTrinh = new JPanelLoTrinh();
		panelMainGioiThieu.add(jPanelLoTrinh);
		jPanelLoTrinh.setVisible(true);
	}
	public void jbuttonGiangVien_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelTeacher panelTeacher = new JPanelTeacher(data);
		panelMainGioiThieu.add(panelTeacher);
		panelTeacher.setVisible(true);
	}
	public void jbuttonDangKy_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelDangKy dangKy = new JPanelDangKy(data);
		panelMainGioiThieu.add(dangKy);
		dangKy.setVisible(true);
	}


//	public void viewDangKy() {
//		clearScreen();
//		JPanelDangKy dangKy = new JPanelDangKy(data);
//		panelMainGioiThieu.add(dangKy);
//		dangKy.setVisible(true);
//	}
}
