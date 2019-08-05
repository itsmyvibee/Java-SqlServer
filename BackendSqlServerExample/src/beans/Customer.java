package beans;

public class Customer {

	private int id;
	private String cpf_cnpj;
	private String nm_customer;
	private Boolean is_active;
	private double vl_total;
	
	//Construtor
	public Customer(int id, String cpf_cnpj, String nm_customer, Boolean is_active, double vl_total) {
		super();
		this.id = id;
		this.cpf_cnpj = cpf_cnpj;
		this.nm_customer = nm_customer;
		this.is_active = is_active;
		this.vl_total = vl_total;
	}

	//Construtor vazio
	public Customer() {
		super();
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNm_customer() {
		return nm_customer;
	}

	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public double getVl_total() {
		return vl_total;
	}

	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}
	
	
	
	
	
}
