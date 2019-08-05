package principal;

import javax.swing.JOptionPane;

import beans.Customer;
import bo.Customer_bo;
import dao.Customer_dao;

public class principal_main {

	public static void main(String[] args) {
		//Classe que será a base do funcionamento do programa.
		
		Boolean loop = true;
		
		while(loop) {
		
		//Menu
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Teste Back\n\n\n1- Cadastro novo customer"
				+ "\n\n2- Listar clientes e trazer média do vl_total\nObs.: Dentro da regra valor > 560 & 1500 < ID < 2700"
				+ "\n\n3- Cadastrar diversos clientes aleatórios para teste"
				+ "\n\n4- Encerrar"
				+ "\nQual opção?"));
		
		switch(opcao) 
		{
		
		case 1: //Efetuar o cadastro do cliente
			cadastrarCustomer();
			break;
		
		case 2: //Calcular e mostrar a média
			media();
			break;
			
		case 3: //Cadastrar diversos clientes aleatórios para teste
			cadastroTeste();
			break;
			
		case 4: //Encerrar o programa
			loop = false;
			break;
		
		}//Fim switch case
		
	}//Fim While true
		
}//Fim main
	
	
	private static void cadastrarCustomer(){
	//Método de cadastro padrão de um cliente novo	
		//Coleta das informações para cadastro.
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(JOptionPane.showInputDialog("Set customer id:")));
		customer.setNm_customer(JOptionPane.showInputDialog("Set customer name:"));
		customer.setCpf_cnpj(JOptionPane.showInputDialog("CPF/CNPJ:"));
		customer.setIs_active(Boolean.parseBoolean(JOptionPane.showInputDialog("Is active? True/False:").toLowerCase()));
		customer.setVl_total(Double.parseDouble(JOptionPane.showInputDialog("Valor total:")));
		
		//Envio do objeto para o Customer_bo
		try 
		{
			
		String x = Customer_bo.cadastro(customer);
		System.out.println(x);
		
		}//Fim Try
	
		catch (Exception e) 
		{
		
		e.printStackTrace();
			
		}//Fim catch
		
	}//Fim método cadastrarCustomer()

	private static void cadastroTeste() {
	//Método que irá cadastrar diversos clientes para teste.
		
		int id_atual = 0;
		int contador = 0;
		int cadastros = 0;
		
		System.out.println("Cadastrando...");
		
		while (id_atual < 2700) {
			//Loop de cadastros
			Customer customer = new Customer();
			customer.setId(id_atual);
			customer.setNm_customer("Cliente " + id_atual);
			customer.setCpf_cnpj("11122233344");
			if (contador % 2 == 0) { customer.setIs_active(true); } else { customer.setIs_active(false); }
			customer.setVl_total(id_atual * 2.2);
			
			contador ++;
			id_atual += 10;
			
			try 
			{
				
				System.out.println(Customer_bo.cadastro(customer));
				cadastros++;
				
			}//Fim try
			
			catch (Exception e)
			{
				
				e.printStackTrace();
				
			}//Fim catch		
		}//Fim while
		System.out.println(cadastros + " Cliente(s) cadastrado(s)");
		
		
	}//Fim método
	
	private static void media() {
		
		try {
		Customer_dao dao = new Customer_dao();
		dao.getDados();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}//Fim da class
