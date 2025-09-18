## 📚 Catálogo de Livros - Arquitetura Hexagonal com Java
Este projeto é um exercício prático de implementação de um microserviço de catálogo de livros utilizando Java puro, Maven e a Arquitetura Hexagonal (Ports & Adapters). O objetivo é demonstrar como aplicar os princípios de separação de responsabilidades e desacoplamento entre camadas, facilitando testes, manutenção e evolução do sistema.

## 🧱 Arquitetura Hexagonal
A arquitetura é dividida em três camadas principais:

Domínio (Core Business)
Contém as regras de negócio e entidades do sistema. Esta camada é totalmente independente de frameworks e tecnologias externas.

Portas (Interfaces)
Define os contratos de entrada e saída da aplicação. São interfaces que conectam o núcleo da aplicação com o mundo externo.

Adaptadores (Implementações)
Implementam as portas e fazem a ponte entre o domínio e os sistemas externos, como banco de dados, APIs, ou interfaces de usuário.

## ⚙️ Tecnologias Utilizadas

Java 17
Maven
H2 Database (via DBeaver)
Arquitetura Hexagonal
Sem uso de frameworks como Spring, para foco total na estrutura e princípios da arquitetura.

## 🚀 Como Executar

Clone o repositório:
Shellgit clone https://github.com/vit0ur/exercice-catalog-of-books.gitcd exercice-catalog-of-booksShow
Acesse o banco H2 via DBeaver para visualizar os dados persistidos.

🗄️ Configuração do Banco de Dados H2
Este projeto utiliza o banco de dados H2, configurado para rodar localmente. 
Certifique-se de que o arquivo application.properties contenha as seguintes configurações

💡 Você pode acessar o banco via DBeaver utilizando a URL acima.

✉️ Configuração de Envio de E-mails
Para que a funcionalidade de envio de e-mails funcione corretamente, é necessário configurar um e-mail válido no arquivo application.properties

## ⚠️ Importante: Certifique-se de que o e-mail utilizado permite acesso por aplicativos menos seguros ou utilize uma senha de aplicativo (App Password) caso esteja usando autenticação em dois fatores.

## 🧪 Testes
Os testes unitários estão focados na camada de domínio, garantindo que a lógica de negócio funcione independentemente dos adaptadores externos.

## 📌 Objetivos do Projeto

Aplicar os conceitos da Arquitetura Hexagonal em Java puro.
Demonstrar como estruturar um microserviço desacoplado e testável.
Servir como base para evoluções futuras com frameworks como Spring Boot ou Quarkus.
