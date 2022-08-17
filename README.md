# Desafio IBM - If black, then code
Esse repositório é referente ao desafio proposto durante o curso de desenvolvimento back-end em Java _If black, then code_ oferecido pela IBM. O projeto tem como objetivo gerenciar as transações da loja fictícia Tudo de Bom a partir da implementação de uma API. 

Assim, foi criada uma rotina CRUD que permite:
- Cadastro de novos clientes e de novos produtos
- Listagem dos clientes e dos produtos
- Atualização de dados dos clientes
- Exclusão de clientes

## Rotas da aplicação:
- **`GET clientes`**: rota que retorna listagem de todos os clientes, com os campos de ID, nome, CPF, telefone e email

- **`GET produtos`**: rota que retorna listagem de todos os produtos, com os campos de ID, nome do produto, valor unitário, categoria do produto, ID da marca e se é genérico ou não. Se o produto for genérico, é retornado o valor unitário original e o valor com um desconto de 20%

- **`POST clientes`**: rota que permite cadastrar um novo cliente, passando como parâmetro o nome do produto, valor unitário, categoria do produto, ID da marca e se é genérico ou não

- **`POST clientes`**: rota que permite cadastrar um novo cliente, passando como parâmetro o nome, CPF, telefone e email

- - **`POST produtos`**: rota que permite cadastrar um novo produto a partir dos parâmetros nome do produto, valor unitário, categoria do produto, ID da marca e se é genérico ou não

- **`UPDATE clientes`**: rota que permite atualizar os campos de cliente

- **`DELETE clientes`**: rota que permite deletar o cliente passando como parâmetro seu ID

## Tecnologias utilizadas:
- Java
- JFrame
- MySQL

## Utilizando a aplicação

Para utilizar a aplicação, é preciso fazer uma cópia para a sua máquina. No terminal, digite

> git clone https://github.com/liratisa/desafio-ibm.git

⚠️ Para evitar erros de compilação ao utilizar o Eclipse, criar um novo projeto Java e importar todos os arquivos **exceto** os arquivos _.project_ e _.classpath_. 

## Autores:
- Filipe Miranda
- Isabela Telles
- Leonardo Guimarães
- Priscila Souza
- Priscila Ribeiro
- Jeisiane França
