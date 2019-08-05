package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Customer;
import connection.ConnectionFactory;

public class Customer_dao {

	private Connection con = null;
	
	//Construtor da classe customer_dao já efetuando a conexao
	public Customer_dao() throws Exception{
		
		con = new ConnectionFactory().conectar();
		
	}
	
	//Método para efetuar o fechamento da conexão
	public void fechar() throws Exception{
		
		con.close();
		
	}
	
	//Método de cadastro do cliente no banco de dados
	public String cadastrar(Customer customer) throws Exception{
		
		//Efetuar o comando sql para cadastro na tabela
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO TB_CUSTOMER_ACCOUNT"
				+ "(ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
				+ "VALUES (?, ?, ?, ?, ?)");
		stmt.setInt(1, customer.getId()); //Metodo para substituir o ? pelo valor desejado (Para evitar SQL INJECTION)
		stmt.setString(2, customer.getCpf_cnpj());
		stmt.setString(3, customer.getNm_customer());
		String active = null;
		if (customer.getIs_active()) {active = "y";} else {active = "n";}
		stmt.setString(4, active);
		stmt.setDouble(5, customer.getVl_total());
	    
		int x = stmt.executeUpdate();
		
		//Fechando as conexões
		stmt.close();
		fechar();
		
		return x + " Cliente(s) cadastrado(s)";
		
	}

	//Método de consulta para efetuar o calculo da média
	public void getDados() throws Exception{
		
		Customer customer = new Customer();
		
		//Query que seleciona o id, nome e vl_total de todos os clientes dentro da regra, e retorna em ordem decrescente de valor.
		PreparedStatement stmt = con.prepareStatement("SELECT *"
				+ " FROM tb_customer_account "
				+ " WHERE id_customer > 1500 AND id_customer < 2700 "
				+ " AND vl_total > 560 ORDER BY vl_total DESC");
		
		ResultSet resultset = stmt.executeQuery();
		
		//Enquanto tiver resultados na consulta...
		while(resultset.next()) {
			
			System.out.println("\n");
			
			//Adicionando os valores dentro do objeto 
			customer.setId(resultset.getInt("ID_CUSTOMER"));
			customer.setCpf_cnpj(resultset.getString("CPF_CNPJ"));
			customer.setNm_customer(resultset.getString("NM_CUSTOMER"));
			if (resultset.getString("IS_ACTIVE").equals("y")) {customer.setIs_active(true);} else {customer.setIs_active(false);} 
			customer.setVl_total(resultset.getFloat("VL_TOTAL"));
			
			//Imprimindo os dados do objeto
			imprimir(customer);
			
		}//Fim while
		
		//Pegando a média de todos os vl_totais dentro da regra.
		stmt = con.prepareStatement("SELECT AVG(vl_total) FROM TB_CUSTOMER_ACCOUNT\r\n" + 
				"WHERE ID_CUSTOMER > 1500 AND ID_CUSTOMER < 2700 AND\r\n" + 
				"VL_TOTAL > 560");
		
		resultset = stmt.executeQuery();
		
		if (resultset.next()) {
			//Imprimindo a média calculada.
			System.out.println("\nMédia de todos os valores dentro da regra: " + resultset.getDouble("AVG(VL_TOTAL)"));
			
		}//Fim if
		
		//Fechando conexões
		resultset.close();
		stmt.close();
		fechar();

	}
	
	private void imprimir(Customer customer) {
		
		//Método para imprimir a lista de resultados
		System.out.println("Nome: " + customer.getNm_customer() + 
				"  ID: " + customer.getId() +
				"\nCPF/CNPJ: " + customer.getCpf_cnpj() + 
				"  Is Active: " + customer.getIs_active() +
				"\nValor Total: " + customer.getVl_total());		
		
	}
	
}
