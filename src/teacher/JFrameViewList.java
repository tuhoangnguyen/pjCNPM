package teacher;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Course;
import entities.Manager;
import entities.Score;
import model.CourseModel;
import model.ManagerModel;
import model.ScoreModel;
import model.StudentModel;

public class JFrameViewList extends JFrame {

	private JPanel contentPane;
	private JTable jtableListStudent;
	private JTextField jtextFieldName;
	private JTextField jtextFieldStudentID;
	private JPanel jpanelScore;
	private JTextField jtextFieldActiveProcess;
	private JTextField jtextFieldMidExam;
	private JTextField jtextFieldFinalExam;
	private Map<String, Object> data;
	private JButton jbuttonUpdateScore;
	private JButton jbuttonSave;
	private JButton jbuttonRefresh;
	private JComboBox jcomboBox_Caculation;
	private Score score;
//	private ControllerScoreInterface controller;
//	private ScoreModelInterface model;
	private String rank = "";// rank cua tung sinh vien cua mon hoc dua vao kq hoc tap
//
//	public JFrameViewList(ControllerScoreInterface controller, ScoreModelInterface model) {
//		super();
//		this.model = model;
//		this.controller = controller;
//
//	}

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
					JFrameViewList frame = new JFrameViewList();
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
	public JFrameViewList() {
		setTitle("List Student");
		setBounds(100, 100, 696, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 36, 333, 271);
		contentPane.add(scrollPane);

		jtableListStudent = new JTable();
		jtableListStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableListStudent_mouseClicked(e);
			}
		});
		jtableListStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableListStudent);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(364, 36, 304, 112);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Họ và tên: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 26, 61, 33);
		panel.add(lblNewLabel);

		jtextFieldName = new JTextField();
		jtextFieldName.setEditable(false);
		jtextFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldName.setBounds(132, 26, 115, 25);
		panel.add(jtextFieldName);
		jtextFieldName.setColumns(10);

		JLabel lblStudentId = new JLabel("Mã sinh viên: ");
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblStudentId.setBounds(30, 69, 72, 33);
		panel.add(lblStudentId);

		jtextFieldStudentID = new JTextField();
		jtextFieldStudentID.setEditable(false);
		jtextFieldStudentID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldStudentID.setColumns(10);
		jtextFieldStudentID.setBounds(132, 69, 115, 25);
		panel.add(jtextFieldStudentID);

		jpanelScore = new JPanel();
		jpanelScore.setBorder(new TitledBorder(null, "Điểm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpanelScore.setBounds(364, 158, 292, 191);
		contentPane.add(jpanelScore);
		jpanelScore.setLayout(null);

		JLabel lblActiveProcess = new JLabel("Điểm quá trình: ");
		lblActiveProcess.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblActiveProcess.setBounds(21, 22, 104, 33);
		jpanelScore.add(lblActiveProcess);

		jtextFieldActiveProcess = new JTextField();
		jtextFieldActiveProcess.setEditable(false);
		jtextFieldActiveProcess.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldActiveProcess.setColumns(10);
		jtextFieldActiveProcess.setBounds(137, 25, 115, 25);
		jpanelScore.add(jtextFieldActiveProcess);

		JLabel lblMidtermExam = new JLabel("Giữa kì: ");
		lblMidtermExam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMidtermExam.setBounds(21, 53, 104, 33);
		jpanelScore.add(lblMidtermExam);

		jtextFieldMidExam = new JTextField();
		jtextFieldMidExam.setEditable(false);
		jtextFieldMidExam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldMidExam.setColumns(10);
		jtextFieldMidExam.setBounds(137, 56, 115, 25);
		jpanelScore.add(jtextFieldMidExam);

		JLabel lblFinalExam = new JLabel("Cuối kì: ");
		lblFinalExam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFinalExam.setBounds(21, 85, 104, 33);
		jpanelScore.add(lblFinalExam);

		jtextFieldFinalExam = new JTextField();
		jtextFieldFinalExam.setEditable(false);
		jtextFieldFinalExam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldFinalExam.setColumns(10);
		jtextFieldFinalExam.setBounds(137, 88, 115, 25);
		jpanelScore.add(jtextFieldFinalExam);

		jbuttonSave = new JButton("Lưu");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setEnabled(false);
		jbuttonSave.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jbuttonSave.setBounds(99, 157, 90, 29);
		jpanelScore.add(jbuttonSave);

		JLabel lblCaculation = new JLabel("Cách tính: ");
		lblCaculation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCaculation.setBounds(21, 112, 104, 33);
		jpanelScore.add(lblCaculation);

		jcomboBox_Caculation = new JComboBox();
		jcomboBox_Caculation.setBounds(137, 115, 115, 26);
		jpanelScore.add(jcomboBox_Caculation);

		jbuttonUpdateScore = new JButton("Cập nhật");
		jbuttonUpdateScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonUpdateScore_actionPerformed(e);
			}
		});
		jbuttonUpdateScore.setEnabled(false);
		jbuttonUpdateScore.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jbuttonUpdateScore.setBounds(128, 317, 85, 30);
		contentPane.add(jbuttonUpdateScore);

		jbuttonRefresh = new JButton("");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setBounds(290, 317, 53, 30);
		contentPane.add(jbuttonRefresh);
		jbuttonRefresh.setIcon(new ImageIcon(JFrameViewList.class.getResource("/icon/352439_refresh_icon.png")));
	}

	public JFrameViewList(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

	public void initJFrame() {
		int courseID = (int) data.get("courseID");
		CourseModel courseModel = new CourseModel();
		Course course = courseModel.findCourseByID(courseID);
		StudentModel model = new StudentModel();
		ManagerModel managerModel = new ManagerModel();
		ScoreModel scoreModel = new ScoreModel();
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		boxModel.addElement("ASC");
		boxModel.addElement("CSBC");

		jcomboBox_Caculation.setModel(boxModel);
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		defaultTableModel.addColumn("Mã sinh viên");
		defaultTableModel.addColumn("Họ và tên");
		defaultTableModel.addColumn("Xếp loại");
		for (Manager managers : managerModel.findManagerByCourse(course.getCourseID())) {
			// scoreModel.findScoreST(model.checkStudent(managers.getMasv()).getStudentID(),
			// courseID).getXeploai()
			defaultTableModel.addRow(new Object[] { "st0" + model.checkStudent(managers.getMasv()).getStudentID(),
					model.checkStudent(managers.getMasv()).getFullName(),
					scoreModel.findScoreST(model.checkStudent(managers.getMasv()).getStudentID(), courseID) == null
							? "null"
							: scoreModel.findScoreST(model.checkStudent(managers.getMasv()).getStudentID(), courseID)
									.getXeploai() });
		}
		jtableListStudent.setModel(defaultTableModel);
		jtableListStudent.getTableHeader().setReorderingAllowed(false);
	}

	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		initJFrame();

	}

	public void jtableListStudent_mouseClicked(MouseEvent e) {
		int selectedRow = jtableListStudent.getSelectedRow();
		String valueName = jtableListStudent.getValueAt(selectedRow, 1).toString();
		String valueID = jtableListStudent.getValueAt(selectedRow, 0).toString();
		jtextFieldName.setText(valueName);

		jtextFieldStudentID.setText(valueID);
		ScoreModel scoreModel = new ScoreModel();
		StudentModel studentModel = new StudentModel();
		int courseID = (int) data.get("courseID");
		int studentID = studentModel.findStudentByName(valueName).getStudentID();
		if (scoreModel.findScoreST(studentID, courseID) == null) {
			jtextFieldActiveProcess.setText("null");
			jtextFieldMidExam.setText("null");
			jtextFieldFinalExam.setText("null");
		} else {
			jtextFieldActiveProcess
					.setText(String.valueOf(scoreModel.findScoreST(studentID, courseID).getDiemquatrinh()));
			jtextFieldMidExam.setText(String.valueOf(scoreModel.findScoreST(studentID, courseID).getDiemgiuaki()));
			jtextFieldFinalExam.setText(String.valueOf(scoreModel.findScoreST(studentID, courseID).getDiemcuoiki()));
		}

		jbuttonUpdateScore.setEnabled(true);
	}

	public void jbuttonUpdateScore_actionPerformed(ActionEvent e) {
		int value = JOptionPane.showConfirmDialog(contentPane, "Bạn chắc chưa?", "Chấm điểm",
				JOptionPane.YES_NO_OPTION);
		if (value == 0) {
			jtextFieldActiveProcess.setEditable(true);
			jtextFieldMidExam.setEditable(true);
			jtextFieldFinalExam.setEditable(true);
			jbuttonSave.setEnabled(true);
		}

	}

	public void jbuttonSave_actionPerformed(ActionEvent e) {
		int courseID = (int) data.get("courseID");
		ScoreModel scoreModel = new ScoreModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		StudentModel studentModel = new StudentModel();
		if (jcomboBox_Caculation.getSelectedItem().equals("ASC")) {
			score = new Score(Double.parseDouble(jtextFieldActiveProcess.getText()),
					Double.parseDouble(jtextFieldMidExam.getText()), Double.parseDouble(jtextFieldFinalExam.getText()));
			rank = scoreModel.rank(score);
		} else if (jcomboBox_Caculation.getSelectedItem().equals("CSBC")) {
			score = new Score(Double.parseDouble(jtextFieldActiveProcess.getText()),
					Double.parseDouble(jtextFieldMidExam.getText()), Double.parseDouble(jtextFieldFinalExam.getText()));
			rank = scoreModel.rank2(score);
		}
		String content = String.valueOf(studentModel.findStudentByName(jtextFieldName.getText()).getStudentID()) + ","
				+ String.valueOf(courseID) + "," + String.valueOf(jtextFieldActiveProcess.getText()) + ","
				+ String.valueOf(jtextFieldMidExam.getText()) + "," + String.valueOf(jtextFieldFinalExam.getText())
				+ "," + rank + "," + dateFormat.format(new Date());
		if (scoreModel.findScoreST(studentModel.findStudentByName(jtextFieldName.getText()).getStudentID(),
				courseID) != null) {
			if (scoreModel.updateScore(studentModel.findStudentByName(jtextFieldName.getText()).getStudentID(),
					courseID, content)) {
				JOptionPane.showMessageDialog(this, "Tạo điểm thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Thất bại!");
			}
		} else {
			if (scoreModel.createNewScore(content)) {
				JOptionPane.showMessageDialog(this, "Tạo điểm thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Thất bại!");
			}
		}

	

	}
}