# 📦 Desafio Técnico – API com Integração Externa, Banco de Dados e Docker

## 🧠 Objetivo

Avaliar competências em:

- Extração de dados via API pública
- Armazenamento em banco de dados relacional
- Criação de API RESTful para consulta dos dados
- Conteinerização com Docker
- Organização e versionamento com Git

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Frameworks:** Spring Boot, OpenFeign
- **Banco de Dados:** PostgreSQL
- **IDE:** IntelliJ Community
- **Ferramentas:** Docker, Postman, Beekeeper Studio
- **Versionamento:** Git + GitHub

---

## 🗺️ Visão Geral da Solução

Utilizei a API pública **ViaCEP** para buscar dados de endereço a partir de um CEP informado. A partir disso, construí uma API RESTful que permite:

- Cadastrar endereços via API externa
- Cadastrar itens e pedidos vinculados a endereços
- Consultar endereços e visualizar os pedidos associados

---

## 🧩 Modelagem UML

A estrutura do sistema foi pensada de forma simplificada:

- **Um endereço pode ter vários pedidos**
- **Um pedido pode conter vários itens**
- **Um item pode estar em vários pedidos**
  
<img width="780" height="215" alt="image" src="https://github.com/user-attachments/assets/4c200597-7d2e-4e40-a667-68f2af7d22b1" />


Essa modelagem permite flexibilidade e reuso de dados.

---

## ⚙️ Configuração do Ambiente

### 🔧 Instalação do JDK 21

Caso esteja utilizando o IntelliJ:

1. Vá em `Arquivo > Estrutura do Projeto`
2. Selecione a versão do SDK e baixe diretamente pela IDE

Caso prefira instalar manualmente:

1. Baixe o JDK no site da [Oracle](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
2. Configure as variáveis de ambiente:

```bash
JAVA_HOME=C:\Caminho\Para\JDK
Path=%JAVA_HOME%\bin
```


**Manual (Windows):**
1. Pesquise: *Editar as variáveis de ambiente*  
2. Vá em:
   - Variáveis de usuário → Novo  
     - `JAVA_HOME` = Caminho da instalação  
   - Variáveis do sistema → Novo  
     - `%JAVA_HOME%\bin`

🎥 Vídeo recomendado: [Como instalar o JDK 21](https://www.youtube.com/watch?v=_RlftGYiAn8)

---

## 🐳 Configuração do Docker

Com o **Docker Desktop** aberto, execute no terminal da IDE:

```bash
cd docker
docker-compose up -d
```
Após o comando, o container deve estar em execução.

## 🧭 Acesso ao Banco de Dados
Utilizei o Beekeeper Studio para verificação da conexão:

| Parâmetro | Valor de Exemplo |
| --------- | ---------------- |
| User      | gntech           |
| Password  | gntech           |
| Database  | gntech           |

---

## 📁 Estrutura do Projeto
Organização padrão com pacotes:

```plaintext
com\devfabiosimones\gntech/
├── config/
├── controller/
├── dto/
├── entity/
│   └── dto/
├── repository/
├── service/
│   └── exception/
└── util/
```

---

## 🌐 Consumo de API Externa
- **Usei o OpenFeign, framework simples e direto para chamadas externas (originalmente desenvolvido pelo Spotify).**
- **Código de integração está localizado em:**

```bash
/config/FeignClientConfig.java
```
---

## 💻 Lógica e Boas Práticas

- **Código estruturado sem Lombok (para evitar dependências adicionais).**
- **Construtores e getters/setters escritos manualmente.**
- **Anotações e validações nos atributos (ex: @Size(max=9) para CEP).**

---

## 🧪 Testes de Endpoints

- **Utilizei o Postman para testes, deixei a coleção disponível para importação direta:**

👉 [Workspace no Postman](https://fabiosimones-e7c80af3-4491351.postman.co/workspace/Fábio-Simones's-Workspace~18a009ed-83dc-463b-8046-9afcbbf22a07/collection/48121275-f9fb71a7-e7ac-401f-a56f-55dcd0f3414d?action=share&creator=48121275&active-environment=48121275-86c9a208-5798-4ca8-94a6-c645158c4345)

### 🔹 Endpoints Principais

| Método | Endpoint          | Descrição                                    |
| ------ | ----------------- | -------------------------------------------- |
| `POST` | `/endereco/{cep}` | Cadastra novo endereço                       |
| `GET`  | `/endereco`       | Lista endereços cadastrados                  |
| `POST` | `/item`           | Cadastra novo item                           |
| `GET`  | `/item`           | Lista itens cadastrados                      |
| `POST` | `/pedido`         | Cadastra pedido associado a endereço e itens |


---

## ⚙️ Regras e Validações

- **CEP: apenas números, máximo de 9 caracteres.**
- **Itens:**
  - **quantidade > 0**
  - **precoUnitario > 0 (tipo Double)**
- **Pedidos:**
  - **Devem referenciar um CEP já cadastrado.**
  - **Retornam erro se CEP ou item não existirem.**

### 🧾 Exemplo de Resposta — Endereço

```bash
{
  "cep": "88161381",
        "logradouro": "Rua Nery Waldomiro da Costa",
        "bairro": "Fundos",
        "localidade": "Biguaçu",
        "uf": "SC",
        "ddd": 48,
        "pedidos": [
            {
                "nomeCliente": "Fábio Simones",
                "cep": "88161381",
                "itemIds": [
                    1
                ]
            }
        ]
}
```

- **Campo pedidos inicia como lista vazia e será preenchido conforme novos registros.**
  
---

## 🧩 Conclusão
````“Decidi apresentar uma API mais robusta do que o exigido, para demonstrar melhor meus conhecimentos.”````

<p>O desafio exigia apenas a extração e armazenamento de CEPs, mas ampliei o projeto incluindo pedidos, itens e relacionamento entre entidades, aplicando boas práticas de arquitetura.</p>

<p>Estou satisfeito com o resultado e aberto a feedbacks.</p>
<p>Agradeço pela oportunidade e experiência! 🙌</p>
