Feature: Busca simples no google
	
	Background: 
		Given Acessar pagina do google
		When Fazer uma pesquisa
		
	Scenario: Fazer uma Busca simples

		Then Apresenta os resultados da pesquisa
		
	Scenario: Erro na Busca simples
		
		Then Apresenta os resultados errados
