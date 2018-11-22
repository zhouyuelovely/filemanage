package filemanage.systemmanage.pojo;

/**
 * 盒子属性表
 * @author 陈一达
 *
 */
public class AmCoBoxProperty {

	private String boxpropertyid;						//盒子主键
	private String boxpropertythickness;				//盒子厚度
	private String boxpropertypag;						//盒子页数
	
	
	@Override
	public String toString() {
		return "AmCoBoxProperty [boxpropertyid=" + boxpropertyid + ", boxpropertythickness=" + boxpropertythickness
				+ ", boxpropertypag=" + boxpropertypag + "]";
	}
	public AmCoBoxProperty() {
		super();
	}
	public AmCoBoxProperty(String boxpropertyid, String boxpropertythickness, String boxpropertypag) {
		super();
		this.boxpropertyid = boxpropertyid;
		this.boxpropertythickness = boxpropertythickness;
		this.boxpropertypag = boxpropertypag;
	}
	public String getBoxpropertyid() {
		return boxpropertyid;
	}
	public void setBoxpropertyid(String boxpropertyid) {
		this.boxpropertyid = boxpropertyid;
	}
	public String getBoxpropertythickness() {
		return boxpropertythickness;
	}
	public void setBoxpropertythickness(String boxpropertythickness) {
		this.boxpropertythickness = boxpropertythickness;
	}
	public String getBoxpropertypag() {
		return boxpropertypag;
	}
	public void setBoxpropertypag(String boxpropertypag) {
		this.boxpropertypag = boxpropertypag;
	}
	

}
