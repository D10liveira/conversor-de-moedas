# Conversor de Moedas

Este projeto é uma aplicação Java simples que utiliza a API **ExchangeRate-API** para converter valores entre diferentes moedas. A aplicação permite ao usuário escolher moedas de origem e destino, inserir o valor desejado, e exibe o resultado da conversão com base na taxa de câmbio atual.

---

## Funcionalidades

- Escolha da moeda de origem e destino entre as opções disponíveis:
  - Dólar Americano (USD)
  - Euro (EUR)
  - Real Brasileiro (BRL)
  - Franco Suíço (CHF)
  - Peso Argentino (ARS)
  - Iene (JPY)
- Conversão de valores com base na taxa de câmbio mais recente.
- Exibição da taxa de câmbio e do valor convertido.

---

## Pré-requisitos

- **Java** (JDK 11 ou superior)
- Biblioteca **Gson** para manipulação de JSON
- Conexão com a internet (para consultar a API de câmbio)

---

## Como executar o projeto

1. Clone este repositório ou copie o código para sua máquina.
2. Certifique-se de ter a biblioteca **Gson** adicionada ao seu projeto:
   - Baixe o JAR [aqui](https://mvnrepository.com/artifact/com.google.code.gson/gson) ou adicione a dependência no Maven/Gradle.
3. Compile o código com o seguinte comando no terminal:
   ```bash
   javac -cp gson-2.10.1.jar Principal.java
   ```
4. Execute o programa:
   ```bash
   java -cp .;gson-2.10.1.jar Principal
   ```
5. Siga as instruções no terminal para escolher as moedas e o valor a ser convertido.

---

## Estrutura do Código

### Classe Principal

- **`main`**: Gerencia o fluxo principal do programa.
- **`getSigla`**: Converte a escolha do usuário (opções de 1 a 6) para o código da moeda correspondente (ex: `USD`).

### Integração com API

- Utiliza `HttpClient` para fazer requisições HTTP.
- Integração com a API **ExchangeRate-API** para obter as taxas de câmbio.
- Usa a biblioteca **Gson** para processar a resposta da API em JSON.


---

## Observação

O código utiliza uma chave de API (`39f4f9c5d98aafab8efe37f7`) que pode ser restrita ou expirada. Para executar corretamente:
- Crie uma conta na [ExchangeRate-API](https://www.exchangerate-api.com/).
- Substitua a chave de API no código por sua própria.

---

## Exemplo de Uso

### Entrada:
1. Escolha da moeda de origem: **USD**
2. Escolha da moeda de destino: **BRL**
3. Valor a ser convertido: **100**

### Saída:
```text
A taxa de câmbio de USD para BRL é: 5.25
E o valor total convertido é: 525.00
```

---

## Licença

Este projeto é de uso livre para estudos e práticas de programação.
