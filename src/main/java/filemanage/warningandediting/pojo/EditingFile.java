package filemanage.warningandediting.pojo;

import java.util.Date;

/**
 * @author meng 编研文件
 */
public class EditingFile {

	private String editingId;// 编研主键
	private Integer editingType;// 编研类型
	private String editingTypeName;// 编研类型名称
	private Date editingDate;// 编研时间
	private String editingTitle;// 编研主题
	private String editingAuthor;// 编研作者
	private String editingController;// 编研内容

	public EditingFile() {
		super();
	}

	public EditingFile(Integer editingType, String editingTitle, String editingAuthor, String editingController) {
		super();
		this.editingType = editingType;
		this.editingTitle = editingTitle;
		this.editingAuthor = editingAuthor;
		this.editingController = editingController;
	}

	public EditingFile(Integer editingType, Date editingDate, String editingTitle, String editingAuthor,
			String editingController) {
		super();
		this.editingType = editingType;
		this.editingDate = editingDate;
		this.editingTitle = editingTitle;
		this.editingAuthor = editingAuthor;
		this.editingController = editingController;
	}

	public EditingFile(String editingId, Integer editingType, String editingTypeName, Date editingDate,
			String editingTitle, String editingAuthor, String editingController) {
		super();
		this.editingId = editingId;
		this.editingType = editingType;
		this.editingTypeName = editingTypeName;
		this.editingDate = editingDate;
		this.editingTitle = editingTitle;
		this.editingAuthor = editingAuthor;
		this.editingController = editingController;
	}

	public String getEditingTypeName() {
		return editingTypeName;
	}

	public void setEditingTypeName(String editingTypeName) {
		this.editingTypeName = editingTypeName;
	}

	public String getEditingId() {
		return editingId;
	}

	public void setEditingId(String editingId) {
		this.editingId = editingId;
	}

	public Integer getEditingType() {
		return editingType;
	}

	public void setEditingType(Integer editingType) {
		this.editingType = editingType;
	}

	public Date getEditingDate() {
		return editingDate;
	}

	public void setEditingDate(Date editingDate) {
		this.editingDate = editingDate;
	}

	public String getEditingTitle() {
		return editingTitle;
	}

	public void setEditingTitle(String editingTitle) {
		this.editingTitle = editingTitle;
	}

	public String getEditingAuthor() {
		return editingAuthor;
	}

	public void setEditingAuthor(String editingAuthor) {
		this.editingAuthor = editingAuthor;
	}

	public String getEditingController() {
		return editingController;
	}

	public void setEditingController(String editingController) {
		this.editingController = editingController;
	}

	@Override
	public String toString() {
		return "EditingFile [editingId=" + editingId + ", editingType=" + editingType + ", editingDate=" + editingDate
				+ ", editingTitle=" + editingTitle + ", editingAuthor=" + editingAuthor + ", editingController="
				+ editingController + "]";
	}

}
