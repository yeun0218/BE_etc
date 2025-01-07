package pack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JikwonDto {
	private String jikwonno, jikwonname, busername, jikwonjik;

	public String getJikwonno() {
		return jikwonno;
	}

	public void setJikwonno(String jikwonno) {
		this.jikwonno = jikwonno;
	}

	public String getJikwonname() {
		return jikwonname;
	}

	public void setJikwonname(String jikwonname) {
		this.jikwonname = jikwonname;
	}

	public String getBusername() {
		return busername;
	}

	public void setBusername(String busername) {
		this.busername = busername;
	}

	public String getJikwonjik() {
		return jikwonjik;
	}

	public void setJikwonjik(String jikwonjik) {
		this.jikwonjik = jikwonjik;
	}
	
	
}
