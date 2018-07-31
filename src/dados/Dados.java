package dados;

public class Dados {

	int id_customer;
	long cpf_cnpj;
	String nm_customer;
	String is_active;
	double vl_total;
	
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	
	public long getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(long cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getNm_customer() {
		return nm_customer;
	}
	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	public double getVl_total() {
		return vl_total;
	}
	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}

}
