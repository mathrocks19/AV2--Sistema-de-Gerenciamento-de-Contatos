Grupo: Matheus Viana, Milena Daflon, Yuri Rolliz

Abre o Xamp -> shell

cd mysql
cd bin
mysql -u root -p 
enter
show databases;
use test;
show tables;

CREATE TABLE contatos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255),
    sexo VARCHAR(1),
    celular VARCHAR(11)  
);

select * from contatos;


1° Adiciona o contato normal
2° Exibe os contatos adicionandos no banco e dentro da tabela contatos
3° Busca os contatos registrados no banco por Nome ou ID
4° Altera apenas o endereço do contato, inserindo o nome do contato e adicionando um novo endereço
5° Remove o contato apenas pelo ID




JdbcInsere: É uma classe que insere os dados mas não é adequado pra esse trabalho
TestaDaoInsere: É uma classe para testar se a inserção de dados está funcionando.
TesteContato: É a classe que você usa para criar o menu interativo do seu sistema.

[Pacote View]
     |   
     |---> TestaContato( Será a classe que é responsável por exibir as opções para o usuario se cadastrar no                                                   terminal )
      	



