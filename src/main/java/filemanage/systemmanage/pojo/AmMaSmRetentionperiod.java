package filemanage.systemmanage.pojo;

import java.util.Date;

/**
 * 保管期限类
 * @author Administrator
 *
 */
public class AmMaSmRetentionperiod {

	private String retentionperiodid;							//保管期限主键
	private String retentionperiodcode;							//保管期限代码
	private String retentionperiodname;							//保管期限名（期限）
	private String retentionperiodstatus;						//保管期限状态（0：系统默认1：自定义）
	private String retentionperioddescription;					//保管期限描述
	private Date retentionperiodcreatetime;					    //保管期限创建时间
	private String retentionperiodcreator;						//保管期限创建人
	
	
	public AmMaSmRetentionperiod(String retentionperiodid, String retentionperiodcode, String retentionperiodname,
			String retentionperiodstatus, String retentionperioddescription, Date retentionperiodcreatetime,
			String retentionperiodcreator) {
		super();
		this.retentionperiodid = retentionperiodid;
		this.retentionperiodcode = retentionperiodcode;
		this.retentionperiodname = retentionperiodname;
		this.retentionperiodstatus = retentionperiodstatus;
		this.retentionperioddescription = retentionperioddescription;
		this.retentionperiodcreatetime = retentionperiodcreatetime;
		this.retentionperiodcreator = retentionperiodcreator;
	}
	public AmMaSmRetentionperiod() {
		super();
	}
	@Override
	public String toString() {
		return "AmMaSmRetentionperiod [retentionperiodid=" + retentionperiodid + ", retentionperiodcode="
				+ retentionperiodcode + ", retentionperiodname=" + retentionperiodname + ", retentionperiodstatus="
				+ retentionperiodstatus + ", retentionperioddescription=" + retentionperioddescription
				+ ", retentionperiodcreatetime=" + retentionperiodcreatetime + ", retentionperiodcreator="
				+ retentionperiodcreator + "]";
	}
	public String getRetentionperiodid() {
		return retentionperiodid;
	}
	public void setRetentionperiodid(String retentionperiodid) {
		this.retentionperiodid = retentionperiodid;
	}
	public String getRetentionperiodcode() {
		return retentionperiodcode;
	}
	public void setRetentionperiodcode(String retentionperiodcode) {
		this.retentionperiodcode = retentionperiodcode;
	}
	public String getRetentionperiodname() {
		return retentionperiodname;
	}
	public void setRetentionperiodname(String retentionperiodname) {
		this.retentionperiodname = retentionperiodname;
	}
	public String getRetentionperiodstatus() {
		return retentionperiodstatus;
	}
	public void setRetentionperiodstatus(String retentionperiodstatus) {
		this.retentionperiodstatus = retentionperiodstatus;
	}
	public String getRetentionperioddescription() {
		return retentionperioddescription;
	}
	public void setRetentionperioddescription(String retentionperioddescription) {
		this.retentionperioddescription = retentionperioddescription;
	}
	public Date getRetentionperiodcreatetime() {
		return retentionperiodcreatetime;
	}
	public void setRetentionperiodcreatetime(Date retentionperiodcreatetime) {
		this.retentionperiodcreatetime = retentionperiodcreatetime;
	}
	public String getRetentionperiodcreator() {
		return retentionperiodcreator;
	}
	public void setRetentionperiodcreator(String retentionperiodcreator) {
		this.retentionperiodcreator = retentionperiodcreator;
	}
	
	
	
	
	
	
}
