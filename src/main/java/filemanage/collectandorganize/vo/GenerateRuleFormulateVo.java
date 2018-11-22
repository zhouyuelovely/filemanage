package filemanage.collectandorganize.vo;
/**
 * 生成规则辅助类
 * @author 陈一达
 *
 */
public class GenerateRuleFormulateVo {

	private String quanzongnumber;				//全宗号
	private String pccode;						//一级分类代码
	private String archivefileanual;			//年度
	private String retentionperiodcode;			//保管期限代码
	private String sccode;						//机构问题代码
	private String index;						//件号
	private String boxnumber;					//盒号
	
	
	@Override
	public String toString() {
		return "GenerateRuleFormulateVo [quanzongnumber=" + quanzongnumber + ", pccode=" + pccode
				+ ", archivefileanual=" + archivefileanual + ", retentionperiodcode=" + retentionperiodcode
				+ ", sccode=" + sccode + ", index=" + index + ", boxnumber=" + boxnumber + "]";
	}
	public GenerateRuleFormulateVo() {
		super();
	}
	public GenerateRuleFormulateVo(String quanzongnumber, String pccode, String archivefileanual,
			String retentionperiodcode, String sccode, String index, String boxnumber) {
		super();
		this.quanzongnumber = quanzongnumber;
		this.pccode = pccode;
		this.archivefileanual = archivefileanual;
		this.retentionperiodcode = retentionperiodcode;
		this.sccode = sccode;
		this.index = index;
		this.boxnumber = boxnumber;
	}
	public String getQuanzongnumber() {
		return quanzongnumber;
	}
	public void setQuanzongnumber(String quanzongnumber) {
		this.quanzongnumber = quanzongnumber;
	}
	public String getPccode() {
		return pccode;
	}
	public void setPccode(String pccode) {
		this.pccode = pccode;
	}
	public String getArchivefileanual() {
		return archivefileanual;
	}
	public void setArchivefileanual(String archivefileanual) {
		this.archivefileanual = archivefileanual;
	}
	public String getRetentionperiodcode() {
		return retentionperiodcode;
	}
	public void setRetentionperiodcode(String retentionperiodcode) {
		this.retentionperiodcode = retentionperiodcode;
	}
	public String getSccode() {
		return sccode;
	}
	public void setSccode(String sccode) {
		this.sccode = sccode;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getBoxnumber() {
		return boxnumber;
	}
	public void setBoxnumber(String boxnumber) {
		this.boxnumber = boxnumber;
	}
	
		
}
