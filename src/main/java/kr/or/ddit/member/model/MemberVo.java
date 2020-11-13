package kr.or.ddit.member.model;

public class MemberVo {
	
	private int mem_no;        //회원시퀀스
	private String mem_id;     //회원ID
	private String mem_pass;   //회원 패스워드
	private String mem_name;   //회원명
	private String mem_bir;    //회원 생년월일
	private String mem_mail;   //회원 이메일
	private String mem_tel;    //회원 휴대폰번호   
	private String mem_sdate;  //회원가입일
	private String mem_edate;  //회원탈퇴일
	private String mem_chk;    //회원탈퇴여부
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_sdate() {
		return mem_sdate;
	}
	public void setMem_sdate(String mem_sdate) {
		this.mem_sdate = mem_sdate;
	}
	public String getMem_edate() {
		return mem_edate;
	}
	public void setMem_edate(String mem_edate) {
		this.mem_edate = mem_edate;
	}
	public String getMem_chk() {
		return mem_chk;
	}
	public void setMem_chk(String mem_chk) {
		this.mem_chk = mem_chk;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_bir == null) ? 0 : mem_bir.hashCode());
		result = prime * result + ((mem_chk == null) ? 0 : mem_chk.hashCode());
		result = prime * result + ((mem_edate == null) ? 0 : mem_edate.hashCode());
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + ((mem_mail == null) ? 0 : mem_mail.hashCode());
		result = prime * result + ((mem_name == null) ? 0 : mem_name.hashCode());
		result = prime * result + mem_no;
		result = prime * result + ((mem_pass == null) ? 0 : mem_pass.hashCode());
		result = prime * result + ((mem_sdate == null) ? 0 : mem_sdate.hashCode());
		result = prime * result + ((mem_tel == null) ? 0 : mem_tel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVo other = (MemberVo) obj;
		if (mem_bir == null) {
			if (other.mem_bir != null)
				return false;
		} else if (!mem_bir.equals(other.mem_bir))
			return false;
		if (mem_chk == null) {
			if (other.mem_chk != null)
				return false;
		} else if (!mem_chk.equals(other.mem_chk))
			return false;
		if (mem_edate == null) {
			if (other.mem_edate != null)
				return false;
		} else if (!mem_edate.equals(other.mem_edate))
			return false;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (mem_mail == null) {
			if (other.mem_mail != null)
				return false;
		} else if (!mem_mail.equals(other.mem_mail))
			return false;
		if (mem_name == null) {
			if (other.mem_name != null)
				return false;
		} else if (!mem_name.equals(other.mem_name))
			return false;
		if (mem_no != other.mem_no)
			return false;
		if (mem_pass == null) {
			if (other.mem_pass != null)
				return false;
		} else if (!mem_pass.equals(other.mem_pass))
			return false;
		if (mem_sdate == null) {
			if (other.mem_sdate != null)
				return false;
		} else if (!mem_sdate.equals(other.mem_sdate))
			return false;
		if (mem_tel == null) {
			if (other.mem_tel != null)
				return false;
		} else if (!mem_tel.equals(other.mem_tel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MemberVO [mem_no=" + mem_no + ", mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name
				+ ", mem_bir=" + mem_bir + ", mem_mail=" + mem_mail + ", mem_tel=" + mem_tel + ", mem_sdate="
				+ mem_sdate + ", mem_edate=" + mem_edate + ", mem_chk=" + mem_chk + "]";
	}



}
