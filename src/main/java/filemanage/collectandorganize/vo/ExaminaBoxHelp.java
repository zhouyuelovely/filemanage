package filemanage.collectandorganize.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExaminaBoxHelp {
	private String examinaPerson;// 检查人
	private Date examinaTime;// 检查时间

	public ExaminaBoxHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExaminaBoxHelp(String examinaPerson, Date examinaTime) {
		super();
		this.examinaPerson = examinaPerson;
		this.examinaTime = examinaTime;
	}

	@Override
	public String toString() {
		return "ExaminaBoxHelp [examinaPerson=" + examinaPerson + ", examinaTime=" + examinaTime + "]";
	}

	public String getExaminaPerson() {
		return examinaPerson;
	}

	public void setExaminaPerson(String examinaPerson) {
		this.examinaPerson = examinaPerson;
	}

	public Date getExaminaTime() {
		return examinaTime;
	}

	public void setExaminaTime(Date examinaTime) {
		this.examinaTime = examinaTime;
	}
	public String getTime() {
		Date time=getExaminaTime();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String timeStr=simpleDateFormat.format(time);
		String meng=timeStr.replaceAll("-", "     ");
		return meng;
	}

}
