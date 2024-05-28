package admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import entities.Teacher;
import model.AccountModel;
import model.CourseModel;
import model.TeacherModel;

public class JFrameNewCourse extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldCourseName;
	private JTextField jtextFieldPrice;
	private JTextField jtextFieldDuration;
	private JTextField jtextFieldQuantity;
	private JComboBox jcomboBoxDay;
	private JComboBox jcomboBoxTime;
	private JComboBox jcomboBoxTeacher;
	private JDateChooser dateChooser;
	private JLabel jlabelImage;
	private JButton jbuttonBrowse;
	private File file;
	private JButton jbuttonCreate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameNewCourse frame = new JFrameNewCourse();
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
	public JFrameNewCourse() {
		setResizable(false);
		setBounds(100, 100, 854, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"New Course", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(153, 153, 255));
		panel_2.setBounds(0, 22, 840, 404);
		contentPane.add(panel_2);

		jlabelImage = new JLabel("");
		jlabelImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelImage.setBounds(10, 36, 168, 181);
		panel_2.add(jlabelImage);

		jbuttonBrowse = new JButton("Browse...");
		jbuttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowse_actionPerformed(e);
			}
		});
		jbuttonBrowse.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jbuttonBrowse.setBounds(10, 227, 168, 21);
		panel_2.add(jbuttonBrowse);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(153, 153, 255));
		panel_4.setBounds(238, 27, 600, 239);
		panel_2.add(panel_4);

		JLabel lblNewLabel_1 = new JLabel("Course Name: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 23, 103, 21);
		panel_4.add(lblNewLabel_1);

		jtextFieldCourseName = new JTextField();
		jtextFieldCourseName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldCourseName.setColumns(10);
		jtextFieldCourseName.setBounds(105, 23, 116, 30);
		panel_4.add(jtextFieldCourseName);

		JLabel lblNewLabel_1_1 = new JLabel("Price: ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(300, 26, 85, 21);
		panel_4.add(lblNewLabel_1_1);

		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldPrice.setColumns(10);
		jtextFieldPrice.setBounds(389, 23, 116, 30);
		panel_4.add(jtextFieldPrice);

		JLabel lblNewLabel_1_2 = new JLabel("Duration: ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 65, 85, 21);
		panel_4.add(lblNewLabel_1_2);

		jtextFieldDuration = new JTextField();
		jtextFieldDuration.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldDuration.setColumns(10);
		jtextFieldDuration.setBounds(105, 65, 116, 30);
		panel_4.add(jtextFieldDuration);

		JLabel lblNewLabel_1_2_1 = new JLabel("Time: ");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 109, 103, 21);
		panel_4.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity: ");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 156, 85, 21);
		panel_4.add(lblNewLabel_1_3);

		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldQuantity.setColumns(10);
		jtextFieldQuantity.setBounds(105, 156, 116, 30);
		panel_4.add(jtextFieldQuantity);

		JLabel lblNewLabel_1_3_1 = new JLabel("Day: ");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(300, 65, 62, 21);
		panel_4.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Teacher: ");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(300, 112, 85, 21);
		panel_4.add(lblNewLabel_1_1_1);

		jcomboBoxTeacher = new JComboBox();
		jcomboBoxTeacher.setBounds(389, 105, 116, 30);
		panel_4.add(jcomboBoxTeacher);

		JLabel lblNewLabel_1_1_2 = new JLabel("Date: ");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(300, 159, 85, 21);
		panel_4.add(lblNewLabel_1_1_2);

		jcomboBoxDay = new JComboBox();
		jcomboBoxDay.setBounds(389, 63, 116, 30);
		panel_4.add(jcomboBoxDay);

		jcomboBoxTime = new JComboBox();
		jcomboBoxTime.setBounds(105, 105, 116, 30);
		panel_4.add(jcomboBoxTime);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(389, 156, 116, 30);
		panel_4.add(dateChooser);

		jbuttonCreate = new JButton("Create");
		jbuttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreate_actionPerformed(e);
			}
		});
		jbuttonCreate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jbuttonCreate.setBounds(417, 334, 90, 27);
		panel_2.add(jbuttonCreate);
		initJFrame();
	}

	public void initJFrame() {
		TeacherModel teacherModel = new TeacherModel();
		DefaultComboBoxModel<String> day = new DefaultComboBoxModel<String>();
		day.addElement("2-4");
		day.addElement("3-5");
		day.addElement("6-7");
		jcomboBoxDay.setModel(day);
		DefaultComboBoxModel<String> time = new DefaultComboBoxModel<String>();
		time.addElement("17-19");
		time.addElement("19-21");
		jcomboBoxTime.setModel(time);
		DefaultComboBoxModel<Teacher> teacher = new DefaultComboBoxModel<Teacher>();
		for (Teacher teachers : teacherModel.findAll()) {
			teacher.addElement(teachers);
		}
		jcomboBoxTeacher.setModel(teacher);
		jcomboBoxTeacher.setRenderer(new cellRender());

	}

	public class cellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Teacher teacher = (Teacher) value;
			return super.getListCellRendererComponent(list, teacher.getName(), index, isSelected, cellHasFocus);
		}

	}

	public void jbuttonBrowse_actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select a photo");
		fileChooser.setMultiSelectionEnabled(false);
		int result = fileChooser.showOpenDialog(this);
		if (result == fileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage()
					.getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT));

			jlabelImage.setIcon(imageIcon);
		}

	}

	public void jbuttonCreate_actionPerformed(ActionEvent e) {
		String content = "";
		Teacher teacher = (Teacher) jcomboBoxTeacher.getSelectedItem();
		AccountModel accountModel = new AccountModel();
		CourseModel courseModel = new CourseModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//5,Cau truc du lieu,24/05/2023,3000000,9,7months,C:\Users\ACER\Desktop\image\ctdl.jpg,100,6-7,17-19
		content = String.valueOf(courseModel.findAll().get(courseModel.findAll().size() - 1).getCourseID() + 1) + ","
				+ jtextFieldCourseName.getText() + "," + dateFormat.format(dateChooser.getDate()) + ","
				+ jtextFieldPrice.getText() + "," + teacher.getAccountID() + "," + jtextFieldDuration.getText() + ","
				+ file.getAbsolutePath() + "," + jtextFieldQuantity.getText() + ","
				+ jcomboBoxDay.getSelectedItem().toString() + "," + jcomboBoxTime.getSelectedItem().toString();
		if (courseModel.createNewCourse(content)) {
			JOptionPane.showMessageDialog(this, "Tạo khóa học thành công!");
			this.setVisible(false);

		} else {
			JOptionPane.showMessageDialog(this, "Thất bại!");
		}
	}



}
