package filemanage.collectandorganize.vo;

import java.util.Date;

import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.AmMaSmRetentionperiod;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.pojo.SecondryClassFication;

/**
 * 盒面盒脊类
 * @author 陈一达
 *
 */

public class BoxSideBoxRidge {

	private	String quanzongNumber;										//全宗号
	private	String quanzongName;										//全宗名称
	private String boxanual;											//年度
	private String ammasmretentionperiod;							    //保管期限对象 (保管期限)
	private String SecondryClassFication;				   				//二级分类
	private String boxstartnumber; 										//起件号
	private String boxendnumber; 										//止件号
	private String boxnumber; 											//盒号
	private String boxsituation;										//盒内情况说明
	private String collator;											//整理人
	private String finishingTime;										//整理时间 
	
	
	@Override
	public String toString() {
		return "BoxSideBoxRidge [quanzongNumber=" + quanzongNumber + ", quanzongName=" + quanzongName + ", boxanual="
				+ boxanual + ", ammasmretentionperiod=" + ammasmretentionperiod + ", SecondryClassFication="
				+ SecondryClassFication + ", boxstartnumber=" + boxstartnumber + ", boxendnumber=" + boxendnumber
				+ ", boxnumber=" + boxnumber + ", boxsituation=" + boxsituation + ", collator=" + collator
				+ ", finishingTime=" + finishingTime + "]";
	}
	public BoxSideBoxRidge() {
		super();
	}
	public BoxSideBoxRidge(String quanzongNumber, String quanzongName, String boxanual, String ammasmretentionperiod,
			String secondryClassFication, String boxstartnumber, String boxendnumber, String boxnumber,
			String boxsituation, String collator, String finishingTime) {
		super();
		this.quanzongNumber = quanzongNumber;
		this.quanzongName = quanzongName;
		this.boxanual = boxanual;
		this.ammasmretentionperiod = ammasmretentionperiod;
		SecondryClassFication = secondryClassFication;
		this.boxstartnumber = boxstartnumber;
		this.boxendnumber = boxendnumber;
		this.boxnumber = boxnumber;
		this.boxsituation = boxsituation;
		this.collator = collator;
		this.finishingTime = finishingTime;
	}
	public String getQuanzongNumber() {
		return quanzongNumber;
	}
	public void setQuanzongNumber(String quanzongNumber) {
		this.quanzongNumber = quanzongNumber;
	}
	public String getQuanzongName() {
		return quanzongName;
	}
	public void setQuanzongName(String quanzongName) {
		this.quanzongName = quanzongName;
	}
	public String getBoxanual() {
		return boxanual;
	}
	public void setBoxanual(String boxanual) {
		this.boxanual = boxanual;
	}
	public String getAmmasmretentionperiod() {
		return ammasmretentionperiod;
	}
	public void setAmmasmretentionperiod(String ammasmretentionperiod) {
		this.ammasmretentionperiod = ammasmretentionperiod;
	}
	public String getSecondryClassFication() {
		return SecondryClassFication;
	}
	public void setSecondryClassFication(String secondryClassFication) {
		SecondryClassFication = secondryClassFication;
	}
	public String getBoxstartnumber() {
		return boxstartnumber;
	}
	public void setBoxstartnumber(String boxstartnumber) {
		this.boxstartnumber = boxstartnumber;
	}
	public String getBoxendnumber() {
		return boxendnumber;
	}
	public void setBoxendnumber(String boxendnumber) {
		this.boxendnumber = boxendnumber;
	}
	public String getBoxnumber() {
		return boxnumber;
	}
	public void setBoxnumber(String boxnumber) {
		this.boxnumber = boxnumber;
	}
	public String getBoxsituation() {
		return boxsituation;
	}
	public void setBoxsituation(String boxsituation) {
		this.boxsituation = boxsituation;
	}
	public String getCollator() {
		return collator;
	}
	public void setCollator(String collator) {
		this.collator = collator;
	}
	public String getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(String finishingTime) {
		this.finishingTime = finishingTime;
	}
	
	
		

}
