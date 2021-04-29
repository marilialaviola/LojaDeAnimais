Feature: Calcular

  Scenario: Somar Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "5" mais "3" e pressiono o botao Igual
    Then exibe o resultado como "8"

  Scenario Outline: Somar Dois Numeros Data Driven
    Given abro a calculadora do Google no meu smartphone
    When seleciono <num1> mais <num2> e pressiono o botao Igual
    Then exibe o resultado como <resultadoEsperado>
    Examples:
      | num1 | num2 | resultadoEsperado |
      | "8"  | "5"  | "13"              |
      | "7"  | "9"  | "16"              |
      | "3"  | "3"  | "6"               |

  Scenario: Diminuir Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "9" menos "3" e pressiono o botao Igual
    Then exibe o resultado como "6"

  Scenario: Dividir um Numero Inteiro Positivo
    Given abro a calculadora do Google no meu smartphone
    When seleciono "9" dividido "3" e pressiono o botao Igual
    Then exibe o resultado como "3"

  Scenario: Multiplicar Dois Numeros Inteiros Positivos
    Given abro a calculadora do Google no meu smartphone
    When seleciono "3" vezes "2" e pressiono o botao Igual
    Then exibe o resultado como "6"

  Scenario: Calcular Com Massa de Teste
    Given que utilizo a massa "db/massaCalc.csv" para testar a calculadora
    When realizo a operacao com dois numeros
    Then compara o resultado atual com o esperado
