package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Classe para gerar todos anagramas possíveis, dada uma sequência de letras informada.
 * A geração de anagramas dessa classe pode ser entendida:
 * - Dado o número n de letras informados;
 * - Serão criadas n árvores, onde o nó inicial é cada uma das posições do array;
 * - Dado a profundidade p dessa cada uma das árvores ser igual a n;
 * - Cada nó terá n - pAtual de nós filhos, onde pAtual é a profundidado do nó;
 * - Cada um dos caminhos do do nó raiz até os nós folhas de tamanho p é um anagrama.
 *
 * @author Felipe Carlos Fraga
 * @version 1.0
 * @since 08-03-2025
 */

public class Anagram {

    private final String word;
    private final String separator;
    private static Integer wordSize;
    private Set<String> anagrams;
    private static Integer countStack = 0;

    /**
     * Retorna o separador utilizado para dividir as letras da palavra.
     *
     * @return O separador utilizado na palavra.
     */
    public String getSeparator() {
        return separator;
    }

    /**
     * Retorna a palavra original utilizada para a geração de anagramas.
     *
     * @return A palavra original.
     */
    public String getWord() {
        return word;
    }

    /**
     * Retorna o conjunto de anagramas gerados.
     *
     * @return Um {@code Set} contendo todos os anagramas únicos gerados.
     */
    public Set<String> getAnagrams() {
        return anagrams;
    }

    /**
     * Construtor privado, utilizado pelo Builder.
     *
     * @param builder O {@link Builder} utilizado para instanciar a classe.
     */
    private Anagram(Builder builder) {
        this.word = builder.word;
        this.separator = builder.separator;
    }

    /**
     * Método público para iniciar a geração de anagramas da palavra definida.
     * <p>
     * Os anagramas são gerados e armazenados no atributo {@code anagrams}.
     * </p>
     */
    public void make() {
        anagrams = new HashSet<>();
        String[] letters = splitWordInLetters();
        wordSize = letters.length;
        findAnagrams(letters, 0, anagrams);
    }

    /**
     * Divide a palavra em um array de letras com base no separador informado.
     *
     * @return Um array de {@code String} contendo cada letra da palavra original.
     */
    private String[] splitWordInLetters() {
        return word.split(separator);
    }

    /**
     * Método recursivo que realiza a combinação das letras para formar todos os anagramas possíveis.
     *
     * @param letters O array de letras da palavra.
     * @param index   Índice atual que define qual parte do array será combinada.
     * @param result  Conjunto onde os anagramas gerados serão armazenados.
     */
    private void findAnagrams(String[] letters, int index, Set<String> result) {
        if (sameNumber(index, wordSize)) {
            result.add(Arrays.toString(letters));
            return;
        }
        for (int i = index; i < wordSize; i++) {
            if (!sameNumber(i, index)) {
                shiftLetters(letters, index, i);
            }
            if (!result.contains(Arrays.toString(letters))) {
                countStack++;
                findAnagrams(letters, index + 1, result);
            }
            if (!sameNumber(i, index)) {
                shiftLetters(letters, index, i);
            }
        }
    }

    /**
     * Retorna o número de vezes que o método {@code findAnagrams} foi empilhado na recursão.
     *
     * @return O número de chamadas recursivas realizadas.
     */
    public static Integer getCountStack() {
        return countStack;
    }

    /**
     * Verifica se dois números são iguais.
     *
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return {@code true} se os números forem iguais, {@code false} caso contrário.
     */
    private Boolean sameNumber(int a, int b) {
        return a == b;
    }

    /**
     * Troca duas letras de posição dentro do array.
     *
     * @param letters O array de letras.
     * @param i       Índice da primeira letra a ser trocada.
     * @param j       Índice da segunda letra a ser trocada.
     */
    private void shiftLetters(String[] letters, int i, int j) {
        String temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }

    /**
     * Classe Builder para criar instâncias de {@link Anagram} de forma flexível.
     */
    public static class Builder {
        private String word;
        private String separator;

        /**
         * Define a palavra a ser utilizada para gerar anagramas.
         *
         * @param word A palavra a ser processada.
         * @return A instância do Builder.
         */
        public Builder word(String word) {
            this.word = word;
            return this;
        }

        /**
         * Define o separador entre as letras da palavra.
         *
         * @param separator O separador de letras.
         * @return A instância do Builder.
         */
        public Builder separator(String separator) {
            this.separator = separator;
            return this;
        }

        /**
         * Constrói a instância de {@link Anagram}, validando os parâmetros antes da criação.
         *
         * @return Uma nova instância de {@code Anagram}.
         * @throws IllegalStateException Se a palavra for inválida.
         */
        public Anagram build() {
            wordIsNotNull();
            wordPatternIsTrue();
            return new Anagram(this);
        }

        private void wordPatternIsTrue() {
            Pattern LETTERS_PATTERN = Pattern.compile("^[a-zA-Z]+(" + Pattern.quote(separator) + "[a-zA-Z]+)*$");
            Matcher matcher = LETTERS_PATTERN.matcher(word);
            if (!matcher.matches()) {
                throw new IllegalStateException("Word deve conter apenas letras separadas por " + separator + "!");
            }
        }

        private void wordIsNotNull() {
            if (word == null) {
                throw new IllegalStateException("Word não pode ser nula!");
            }
        }
    }
}
