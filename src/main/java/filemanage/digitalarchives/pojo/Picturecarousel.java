package filemanage.digitalarchives.pojo;

import java.util.Date;

/**
 * @author tchuanwu
 * 档案信息发布图片轮播映射类
 */
public class Picturecarousel {
	private String pcId;//轮播主键
	private String pcPhotoAddress;//图片地址
	private String pcUrl;//链接地址
	private String pcPerson;//发布人
	private Date pcTime;//发布时间
	private String pcNumber;//发布序号
	@Override
	public String toString() {
		return "Picturecarousel [pcId=" + pcId + ", pcPhotoAddress=" + pcPhotoAddress + ", pcUrl=" + pcUrl
				+ ", pcPerson=" + pcPerson + ", pcTime=" + pcTime + ", pcNumber=" + pcNumber + "]";
	}
	
	
	public Picturecarousel(String pcId, String pcPhotoAddress, String pcUrl, String pcPerson, Date pcTime,
			String pcNumber) {
		super();
		this.pcId = pcId;
		this.pcPhotoAddress = pcPhotoAddress;
		this.pcUrl = pcUrl;
		this.pcPerson = pcPerson;
		this.pcTime = pcTime;
		this.pcNumber = pcNumber;
	}
	public Picturecarousel() {
		super();
	}
	
	public String getPcId() {
		return pcId;
	}
	public void setPcId(String pcId) {
		this.pcId = pcId;
	}
	public String getPcPhotoAddress() {
		return pcPhotoAddress;
	}
	public void setPcPhotoAddress(String pcPhotoAddress) {
		this.pcPhotoAddress = pcPhotoAddress;
	}
	public String getPcUrl() {
		return pcUrl;
	}
	public void setPcUrl(String pcUrl) {
		this.pcUrl = pcUrl;
	}
	public String getPcPerson() {
		return pcPerson;
	}
	public void setPcPerson(String pcPerson) {
		this.pcPerson = pcPerson;
	}
	public Date getPcTime() {
		return pcTime;
	}
	public void setPcTime(Date pcTime) {
		this.pcTime = pcTime;
	}
	public String getPcNumber() {
		return pcNumber;
	}
	public void setPcNumber(String pcNumber) {
		this.pcNumber = pcNumber;
	}
	
	
	
	

	

	
	

}
