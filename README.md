### Desafio POC - Serialização e Desserialização.


#### Você vai fazer um projeto Spring Boot que tenha dois endpoints

 

#### POST /file/save
-> Recebe uma String ao invés de um OBJETO e essa string deve ser um JSON valido 
-> Pega essa String e desserializa para Byte Array (byte[])
-> Escreve um arquivo na raiz do projeto com o arquivo
-> O arquivo deve ter o nome "processed.json"

 

#### GET /file
-> Busca um arquivo de nome "processed.json" na raiz do diretório 
-> Serializa o arquivo em uma Classe valida 
-> Entrega a classe valida como Response pro usuário

 

#### Objetivo : 
-> Operações básicas 
-> Entendimento de Serialização e Desserialização 
-> Entendimento de recursos básicos da lib jakarta.nio.files/ java.nio.files
-> Entendimento de como comunicações síncronas e assíncronas recebem seu dado e enviam seu dado para outro local

 

 

O que você deve pesquisar para esse desafio : 
-> Spring Boot 
-> Métodos Get e Post 
-> lib fasterxml.jackson.databind
-> byte[] (Java Byte Array)
-> java.nio.files NATIVO

 

O que você NÃO pode usar para esse desafio 
-> Libs como GSON ou qualquer outra que não te faça usar byte[]

 

 

"Achei fácil , quero um desafio maior":
-> Não use fasterxml.jackson.databind ou qualquer outra lib que facilite o entendimento de serialização manual 
-> Use Map para serialização de campos.
