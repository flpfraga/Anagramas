# Anagram Generator

Este projeto fornece uma solução para gerar todos os anagramas possíveis a partir de uma sequência de letras informada, utilizando recursão para permutar as letras de uma palavra e gerar todas as combinações possíveis.

## Funcionalidade

A classe `Anagram` permite gerar anagramas de uma palavra ou frase, dada uma sequência de letras separadas por um delimitador. A lógica utiliza árvores recursivas para gerar as permutações possíveis, retornando um conjunto único de anagramas.

### Como funciona?

1. O usuário fornece uma palavra, que pode ser separada por um delimitador, por exemplo, uma vírgula ou espaço.
2. A classe cria uma árvore de recursão onde cada nó é uma permutação das letras da palavra.
3. Cada caminho da árvore é uma combinação de letras que forma um anagrama.

