package combini.vo;

public class StoreOwner {
	
	private String owner_id;
	private String owner_pwd;
	private String owner_name;
	private String owner_phone;
	private String branch_name;

	// getter , setter
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner_pwd() {
		return owner_pwd;
	}
	public void setOwner_pwd(String owner_pwd) {
		this.owner_pwd = owner_pwd;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_phone() {
		return owner_phone;
	}
	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
}