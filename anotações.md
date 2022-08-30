iteração 

funções de arvore
    - imprimir arvore, ver num elementos, ver num folhas, ir para raiz, ir para nó x (navegar entre nós) e converter para binária. 

funções de nó
    - retornar valor, retornar pai, retornar filhos e pai (para navegação em arvore), adicionar filho, remover filho.

arvore generica: trabalhar com filhos armazenados em array.
arvore binaria: trabalhar com array de 2 valores (index 0 = esquerda, index 1 = direita), ou manter variáveis de esquerda e direita.
obs: - caso manter variáveis e arrays em um nó, definir qual  tipo de arvore está a trabalhar - caso binária: bloquear uso de arrays dos nós. Caso generica: bloquear acesso às variaveis (esquerda e direita de um vó).

impressão (percurso na arvore)
    -generica - se possui filho, declarar uma variavel count para saber quantos possui. fazer um for seguindo a mesma logica do percurso binario, porém ao inves de esquerda e direita, limitar o percurso pelo número de filhos, ou seja, contendo 5 filhos, se passo: count += 1, quando count == 5 ele pera e volta para o ultimo nó.

    - binaria - filho esquerdo, filho diteiro (na impressao basta chamar essas 2 funções em sequencia caso haja um filho).

    (elaborar função de encaminhamento e utilizar os prints da propira função de nó)
converter generica -> binária:
    - caso em uso total de array: a partir do nó raiz limitar o array de filhos em 2 index, em seguida realizar o encaminhamento para percorrer os array de filhos e reduzi-los em 2 index recursivamente.