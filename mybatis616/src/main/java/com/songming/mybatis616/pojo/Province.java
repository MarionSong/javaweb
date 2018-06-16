package com.songming.mybatis616.pojo;

public class Province {
	private Integer addr_id;
	private String _address;
	private Integer tel;
	
	
	
	public Integer getAddr_id() {
		return addr_id;
	}


	public void setAddr_id(Integer addr_id) {
		this.addr_id = addr_id;
	}


	public String getAddress() {
		return _address;
	}


	public void setAddress(String address) {
		this._address = address;
	}


	public Integer getTel() {
		return tel;
	}


	public void setTel(Integer tel) {
		this.tel = tel;
	}


	public String toString() {
		return "province[addr_id="+addr_id+",address="+_address+",tel="+tel+" ]";
	}
	
}
