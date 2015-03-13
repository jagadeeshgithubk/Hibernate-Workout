package hbmpojos;

public class Employee {

	Integer ID;
	String NAME;
	String ADDRESS;
	Integer DEPT_ID;
	public Integer getDEPT_ID() {
		return DEPT_ID;
	}
	public void setDEPT_ID(Integer dEPT_ID) {
		DEPT_ID = dEPT_ID;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ADDRESS == null) ? 0 : ADDRESS.hashCode());
		result = prime * result + ((DEPT_ID == null) ? 0 : DEPT_ID.hashCode());
		result = prime * result + ((NAME == null) ? 0 : NAME.hashCode());
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
		Employee other = (Employee) obj;
		if (ADDRESS == null) {
			if (other.ADDRESS != null)
				return false;
		} else if (!ADDRESS.equalsIgnoreCase(other.ADDRESS))
			return false;
		if (DEPT_ID == null) {
			if (other.DEPT_ID != null)
				return false;
		} else if (!DEPT_ID.equals(other.DEPT_ID))
			return false;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}
	
}
