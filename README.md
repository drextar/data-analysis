# Análise de Dados

A aplicação aqui disponibilizada é minha implementação de um desafio técnico para uma oportunidade de atuação como Java Software Developer.

### Descritivo
Você deve criar um sistema de análise de dados, onde o sistema deve importar lotes de arquivos, ler e analisar os dados e produzir um relatório.

Existem 3 tipos de dados dentro desses arquivos.

Para cada tipo de dados há um layout diferente.

**Dados do vendedor**

Os dados do vendedor têm o formato id 001 e a linha terá o seguinte formato.

`001çCPFçNameçSalary`

**Dados do cliente**

Os dados do cliente têm o formato id 002 e a linha terá o seguinte formato.

`002çCNPJçNameçBusiness Area`

**Dados de vendas**

Os dados de vendas têm o formato id 003. Dentro da linha de vendas, existe a lista de itens, que é envolto por colchetes []. A linha terá o seguinte formato.

`003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name`

**Dados de Exemplo**

O seguinte é um exemplo dos dados que o sistema deve ser capaz de ler.

```
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo

```

**Análise de dados**

Seu sistema deve ler dados do diretório padrão, localizado em% HOMEPATH% / data / in. O sistema deve ler somente arquivos .dat.

Depois de processar todos os arquivos dentro do diretório padrão de entrada, o sistema deve criar um arquivo dentro do diretório de saída padrão, localizado em % HOMEPATH% /data/out.

O nome do arquivo deve seguir o padrão, {flat_file_name} .done.dat.

O conteúdo do arquivo de saída deve resumir os seguintes dados:

-   Quantidade de clientes no arquivo de entrada
-   Quantidade de vendedor no arquivo de entrada
-   ID da venda mais cara
-   O pior vendedor

# Excutando aplicação

### [](https://github.com/drextar/data-analysis.git)Clone this repository

```
git clone https://github.com/drextar/data-analysis.git data-analysis

```
***Ferramentas***:
- IntelliJ IDEA
- Java 11

Tendo o projeto baixado em sua máquina, você precisará criar duas pastas:

- C:\Users\<SEU USUARIO>\data\in
- C:\Users\<SEU USUARIO>\data\out

Agora, vá até a pasta onde clonou o repositório e localize o arquivo "dados.dat" na raíz, copie e cole na pasta \data\in.

Importe o projeto na IDE e execute a classe Main, o projeto irá ler o arquivo e você colou em \data\in, processar os dados e salvar como um novo arquivo na pasta \data\out.

Abra o arquivo de saída e veja o resultado processado.

Exemplo entrada: 
```
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
```

**Saída**:

```
Quantidade de clientes: 2
Quantidade de vendedores: 2
ID da venda mais cara: 10
O pior vendedor: Paulo
```
