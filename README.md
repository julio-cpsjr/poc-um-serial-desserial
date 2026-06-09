### Desafio POC - Serialização e Desserialização.


#### Você vai fazer um projeto Spring Boot que tenha dois endpoints

 

#### POST /file/save
-> Recebe uma String ao invés de um OBJETO e essa string deve ser um JSON valido <br/>
-> Pega essa String e desserializa para Byte Array (byte[]) <br/>
-> Escreve um arquivo na raiz do projeto com o arquivo <br/>
-> O arquivo deve ter o nome "processed.json" <br/>

 

#### GET /file
-> Busca um arquivo de nome "processed.json" na raiz do diretório <br/>
-> Serializa o arquivo em uma Classe valida  <br/>
-> Entrega a classe valida como Response pro usuário <br/>

 

#### Objetivo : 
-> Operações básicas <br/>
-> Entendimento de Serialização e Desserialização <br/>
-> Entendimento de recursos básicos da lib jakarta.nio.files/ java.nio.files<br/>
-> Entendimento de como comunicações síncronas e assíncronas recebem seu dado e enviam seu dado para outro local<br/>

 

 

O que você deve pesquisar para esse desafio : <br/>
-> Spring Boot <br/>
-> Métodos Get e Post <br/>
-> lib fasterxml.jackson.databind <br/>
-> byte[] (Java Byte Array) <br/>
-> java.nio.files NATIVO <br/>

 

O que você NÃO pode usar para esse desafio <br/>
-> Libs como GSON ou qualquer outra que não te faça usar byte[]

 

 

"Achei fácil , quero um desafio maior": <br/>
-> Não use fasterxml.jackson.databind ou qualquer outra lib que facilite o entendimento de serialização manual <br/>
-> Use Map para serialização de campos. <br/>
