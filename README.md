# Anagram Generator

Este projeto fornece uma solução para gerar todos os anagramas possíveis a partir de uma sequência de letras informada, utilizando recursão para permutar as letras de uma palavra e gerar todas as combinações possíveis.

## Requisitos

- Java 8 ou superior
- Maven

## Instalação

1. Clone o repositório:
```bash
git clone [URL_DO_REPOSITÓRIO]
```

2. Navegue até o diretório do projeto:
```bash
cd Anagramas
```

3. Compile o projeto usando Maven:
```bash
mvn clean install
```

## Funcionalidade

A classe `Anagram` permite gerar anagramas de uma palavra ou frase, dada uma sequência de letras separadas por um delimitador. A lógica utiliza árvores recursivas para gerar as permutações possíveis, retornando um conjunto único de anagramas.

### Como funciona?

1. O usuário fornece uma palavra, que pode ser separada por um delimitador (por exemplo, vírgula ou espaço)
2. A classe cria uma árvore de recursão onde cada nó é uma permutação das letras da palavra
3. Cada caminho da árvore é uma combinação de letras que forma um anagrama
4. O resultado é um conjunto único de anagramas possíveis

### Exemplo de Uso

```java
Anagram anagram = new Anagram.Builder()
        .word("a,b,c,d")
        .separator(",")
        .build();
anagram.make();
anagram.getAnagrams().forEach(System.out::println);
```

### Características

- Utiliza o padrão Builder para construção flexível
- Validação de entrada para garantir que apenas letras sejam aceitas
- Geração eficiente de anagramas usando recursão
- Eliminação de duplicatas automaticamente
- Contador de chamadas recursivas para análise de performance

## Estrutura do Projeto

```
src/
  main/
    java/
      org/
        example/
          Anagram.java    # Classe principal que gera os anagramas
          Main.java       # Classe de exemplo de uso
pom.xml                   # Configuração do Maven
```

## Autor

- Felipe Carlos Fraga

## Licença

Este projeto está sob a licença MIT.

