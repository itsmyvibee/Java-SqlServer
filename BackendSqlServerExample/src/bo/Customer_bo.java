package bo;

import beans.Customer;
import dao.Customer_dao;

public class Customer_bo {
	
	public static String cadastro(Customer customer) throws Exception{
		
		//M�todo que ser� responsavel pela valida��o dos dados e formata��o dos mesmos antes de envia-los para o banco.
		if (customer.getNm_customer().length() > 254) {return "Nome excedeu o n�mero de caracteres.";}
		if (customer.getCpf_cnpj().length() > 20) {return "CPF ou CNPJ excedeu o n�mero de caracteres.";}	
		
		//Formata��o de texto
		customer.setNm_customer(customer.getNm_customer().toUpperCase());
		
		//Chamada do dao para fazer o cadastro no banco
		Customer_dao dao = new Customer_dao();
		String resultado = dao.cadastrar(customer);
		
		return resultado;
		
	}
	

}
