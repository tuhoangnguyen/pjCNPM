package student;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Account;
import entities.Manager;
import model.CourseModel;
import model.ManagerModel;
import model.ScoreModel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.swing.ListSelectionModel;

public class JPanelScore extends JPanel {
	private JTable jtableScore;
	private Map<String, Object> data;
	/**
	 * 4.2 Hiển thị giao diện xem điểm
	 */
	public JPanelScore() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		jtableScore = new JTable();
		jtableScore.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableScore);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Xem điểm");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNewLabel);
		
	}
	public JPanelScore(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	// 1.2 Hiển thị bảng điểm
	public void initJFrame() {
		Account account = (Account) data.get("user");
		ScoreModel scoreModel = new ScoreModel();
		ManagerModel managerModel = new ManagerModel();
		CourseModel courseModel = new CourseModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DefaultTableModel defaultTableModel = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("Tên khóa");
		defaultTableModel.addColumn("Điểm quá trình");
		defaultTableModel.addColumn("Điểm giữa kì");
		defaultTableModel.addColumn("Điểm cuối kì");
		defaultTableModel.addColumn("Xếp hạng");
		defaultTableModel.addColumn("Ngày có điểm");
		for (Manager managers : managerModel.findManagerByStudent(account.getUserID())) {
			// 4.4 Trả ra điểm số của các khóa học
			defaultTableModel.addRow(new Object[] {
					courseModel.findCourseByID(managers.getMakh()).getCourseName(), // Tên khóa
					scoreModel.findScoreST(account.getUserID(), 
							courseModel.findCourseByID(managers.getMakh()).getCourseID()) != null ?  scoreModel.findScoreST(account.getUserID(), 
									courseModel.findCourseByID(managers.getMakh()).getCourseID()).getDiemquatrinh() : "", // Điểm quá trình
									scoreModel.findScoreST(account.getUserID(),
											courseModel.findCourseByID(managers.getMakh()).getCourseID()) != null ?  scoreModel.findScoreST(account.getUserID(),
													courseModel.findCourseByID(managers.getMakh()).getCourseID()).getDiemgiuaki() : "", // Điểm giữa kì
													scoreModel.findScoreST(account.getUserID(),
															courseModel.findCourseByID(managers.getMakh()).getCourseID()) != null ?  scoreModel.findScoreST(account.getUserID(),
																	courseModel.findCourseByID(managers.getMakh()).getCourseID()).getDiemcuoiki() : "", // Điểm cuối kì
																	scoreModel.findScoreST(account.getUserID(),
																			courseModel.findCourseByID(managers.getMakh()).getCourseID()) != null ?  scoreModel.findScoreST(account.getUserID(),
																					courseModel.findCourseByID(managers.getMakh()).getCourseID()).getXeploai() : "", // Xếp loại
																					scoreModel.findScoreST(account.getUserID(),
																							courseModel.findCourseByID(managers.getMakh()).getCourseID()) != null ?  dateFormat.format(scoreModel.findScoreST(account.getUserID(),
																									courseModel.findCourseByID(managers.getMakh()).getCourseID()).getNgaynhap()) : "" // Ngày nhập điểm
					
			});
		}
		jtableScore.getTableHeader().setReorderingAllowed(false);
		jtableScore.setModel(defaultTableModel);
		jtableScore.setRowHeight(50);
	}

}
