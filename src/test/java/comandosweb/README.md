# Introdução
---
Framework java criado para facilitar o desenvolvimento de testes automatizados, bem como aumentar a produtividade e a padronização do desenvolvimento de rotinas de testes automatizados.

## Comandos Básicos (Web)
---
Classe responsável por por conter comandos que executam interações em páginas web. Os métodos contidos na classe são todos públicos e para utiliza-los, não é necessário passar o WebDriver como parametro.

Possui as seguintes propriedades:

<code>**protected WebDriver**</code> driver

<code>**protected Actions**</code> action

<code>**protected WebDriverWait**</code> wait

E comporta os métodos que serão apresentados a seguir:

### ComandosBasicos
---
Método construtor da classe que recebe o **WebDriver** como parâmetro.

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
```

### mudarAba
---
Método resposanvel por mudar a aba atual do navegador recebe um <code>**int**</code> como parâmetro, as abas são lidas em um array dessa forma, são zero indexadas, ou seja, os números passados vão de 0 à quantidade de abas abertas no momento menos 1.

> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> indiceAba

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.mudarAba(0);
```

No exemplo acima mudamos navegamos para a primeira aba do navegador.

Caso seja informado o indice uma aba inexistente como parâmetro será lançada a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este Indice de Aba não existe! Use um valor Valido!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### trocarJanela
---
Método responsável trocar a janela ativa do navegador que recebe um <code>**int**</code> como parâmetro, as janelas são lidas em um array dessa forma, são zero indexadas, ou seja, os números passados vão de 0 à quantidade de abas abertas no momento menos 1.

> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> indiceJanela

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.trocarJanela(0);
```

No exemplo acima mudamos navegamos para a primeira janela ativa.

Caso seja informado o indice uma janela inexistente como parâmetro será lançada a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este Indice de janela não existe! Use um valor Valido!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>

### borda
---
Método responsável por localizar um elemento no navegador e destacar o mesmo com um borda vermelha para exibir qual fluxo ou ação está sendo realizado, recebe um <code>**WebElement**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**WebElement**</code> elemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
WebElement menuLink = comBasico.findElement(By.id("menu-link"));
comBasico.borda(menuLink);
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>

### encontra
---
Método responsável por encontrar um elemento no navegador,
o método recebe uma <code>**String**</code> como parâmetro e busca o elementro através dos seguintes seletores <code>**id**</code>, <code>**name**</code>, <code>**tagName**</code>, <code>**cssSelector**</code>, <code>**linkText**</code>, <code>**partialLinkText**</code>, <code>**xpath**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
WebElement menuLink = comBasico.encontra("menu-link");
```

Caso nenhum elemento seja encontrado através da <code>**String**</code> passada como parâmetro o método retorna a seguinte <code>**Exception**</code>

> <span style="color: red;">**Exception**</span>: Nenhum elemento foi identificado!

Caso não ocorra nenhum erro retorna um <code>**WebElement**</code>

> <span style="color: green;">**Return**</span>: <code>**WebElement**</code>

### elementoExiste
---
Método responsável por validar se um elemento existe no *DOM* (Document Object Model), recebe uma <code>**String**</code> como parâmetro que é seletor do elemento.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.elementoExiste("menu-link");
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### elementoEstaVisivel
---
Método responsável por validar se um elemento está visível, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.elementoEstaVisivel("menu-link");
```
Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### elementoEstaHabilitado
---
Método responsável por validar se um elemento está habilitado, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.elementoEstaHabilitado("menu-link");
```
Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### esperarElemento
---
Método responsável por aguardar de forma explicita até que um elemento esteja visível, tem duas forma de implementação aceitando sobrecarga de método, a primeira assinatura recebe apenas uma <code>**String**</code> com o seletor do elemento, a segunda implementação recebe 2 parâmetros, uma <code>**String**</code> e um <code>**int**</code>.

Parametros da primeira implementação:
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex primeira implementação:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.esperarElemento("menu-link");
```

Parametros da segunda implementação:
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento
> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> tempo

Ex segunda implementação:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.esperarElemento("menu-link", 10);
```
Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### escrever
---
Método responsável por selecionar um elemento do tipo input e inserir um determinado texto nele, tem duas forma de implementação aceitando sobrecarga de método, a primeira assinatura recebe uma <code>**String**</code> com o seletor do elemento e uma <code>**String**</code> com o texto a ser inserido no input, a segunda implementação recebe 2 parâmetros, um um <code>**WebElement**</code> e uma <code>**String**</code> com o texto que será inserido no input.

Parametros da primeira implementação:
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto

Ex primeira implementação:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.escrever("input-exemplo", "texto de exemplo");
```

Parametros da segunda implementação:
> <span style="color: blue;">**Parâmetro**</span>: <code>**WebElement**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto

Ex segunda implementação:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
WebElement elementoExemplo = comBasico.encontra("input-exemplo");
comBasico.escrever(elementoExemplo, "texto de exemplo");
```

Caso o elemento selecionado no método não exista ou não possa receber entrada de texto, ou seja, não seja do tipo input o método retornara a segunda <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este elemento não tem entrada para texto!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### limpar
---
Método responsável por limpar os dados presentes em um determinado input, recebe uma <code>**String**</code> como parâmetro com o seletor do elemento que será limpo.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento`

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.limpar("input-exemplo");
```

Caso o elemento selecionado no método não exista ou não possa receber entrada de texto, ou seja, não seja do tipo input o método retornara a segunda <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este elemento não tem entrada para texto!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### clicar
---
Método responsável por clicar em determinado elemento, localizando o mesmo através da <code>**String**</code> passada como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.clicar("elemento-exemplo");
```

Caso o elemento não seja localizado ou não seja clicável o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este elemento não é clicavel!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### clicarElementos
---
Método responsável por clicar em um ou mais elementos de acordo com o parâmetro passado, recebe uma <code>**List**`<String>`</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**List`<String>`**</code> seletorElementos

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
List<String> elementos = Arrays.asList("elemento1","elemento2");
comBasico.clicarElementos(elementos);
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### verificarSeRadioEstaMarcado
---
Método responsável por verificar se um input do tipo radio está marcado, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.verificarSeRadioEstaMarcado("input-radio-exemplo");
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### obterTexto
---
Método responsável por capturar o texto de um determinado elemento,recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterTexto("elemento-exemplo");
```

Caso o elememento não seja encontrado ou não tenha a propriedade texto o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este elemento não é clicavel!

Caso não ocorra nenhum erro o método retorna <code>**String**</code>.

> <span style="color: green;">**Return**</span>: <code>**String**</code>


### limparValorComBackspace
---
Método responsável por limpar uma determinado elemento do tipo input usando método de backspace do teclado, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.limparValorComBackspace("input-exemplo");
```

Caso o elemento não seja encontrado ou não seja do tipo que aceite entrada de de dados (input) o método retornará a seguinte 
<code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este elemento não tem entrada para texto!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### pegarValorCss
---
Método responsável por pegar o valor de uma propriedade CSS de um determinado elemento, recebe 2 parâmetros do tipo <code>**String**</code><code></code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> propriedadeCSS

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.pegarValorCss("elemento-exemplo", "color");
```

Caso o elemento não seja encontrado ou o mesmo não possua a propriedade procurada o metodo retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Este elemento não tem um valor de CSS para a propriedade informada!

Caso não ocorra nenhum erro o método retornará uma <code>**String**</code>.

> <span style="color: green;">**Return**</span>: <code>**String**</code>


### obterAtributoElemento
---
Método responsável por pegar o valor de um determinado atributo de um determiando elemento, recebe 2 parâmetros do tipo <code>**String**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> atriutoElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterAtributoElemento("elemento-exemplo", "value");
```

Caso não ocorra nenhum erro o método retornará uma <code>**String**</code>.

> <span style="color: green;">**Return**</span>: <code>**String**</code>


### verificarSeOcheckBoxEstaMarcado
---
Método resposável por verificar se um checkbock está marcado, recebe uma parâmetro do tipo <code>**String**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.verificarSeOcheckBoxEstaMarcado("checkbox-exemplo");
```

Retorna um <code>**boolean**</code>.

> <span style="color: green;">**Return**</span>: <code>**boolean**</code>


## Trabalhando com urls

### abrirUrl
---
Método responsável por abrir uma determinada url no navegador, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> url

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.abrirUrl("https://www.google.com.br");
```

Caso a url passada como parêmetro seja invalida ou ocorra algum durante a abertura da mesma o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Use uma Url Valida http://[seu destino] Exemplo: http://google.com.br


Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### validarTituloDoBrowser 
---
Método responsável por validar o titulo do da página, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> tituloPagina

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.validarTituloDoBrowser("Google");
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### validarUrlAtual
---
Método responsável por validar a url da página atual, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> pageURL

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.validarTituloDoBrowser("https://www.google.com.br");
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>



## Trabalhando com Combobox

### select
---
Método responsavel por gerar um Objeto do tipo <code>**Select**</code> para que possamos utilizar os metodos do mesmo, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.select("combo-exemplo");
```

O método retorna uma objeto do tipo <code>**Select**</code>

> <span style="color: green;">**Return**</span>: <code>**Select**</code>



### selecionarComboPorValor
---
Método responsável por selecionar uma opção no combobox através do valor, recebe dois parâmetros do tipo <code>**String**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> valorOpcao

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.selecionarComboPorValor("combo-exemplo", "exemplo de valor");
```

Caso ocorra algum erro ou o valor passado como parêmetro não seja encontrado o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não existe este valor dentro da desde select

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>



### selecionarComboPorIndice
---
Método responsável por selecionar uma opção no combobox através do indice, recebe dois parâmetros, um do tipo <code>**String**</code> e outro do tipo <code>int</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> indiceOpcao

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.selecionarComboPorIndice("combo-exemplo", 2);
```

Caso ocorra algum erro ou não exista uma opção com indice passado como parâmetro o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não existe este Index dentro da deste select

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


## obterTextoVisivelDoCombo
---
Método responsãvel por pegar o texto vísivel (selecionado) no combobox, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterTextoVisivelDoCombo("combo-exemplo");
```

Método retorna uma <code>**String**</code> com o valor da combobox que estava selecionado.

> <span style="color: green;">**Return**</span>: <code>**String**</code>


## pegarOpcoesCombo
---
Método resposável por pegar todas as opções presentes em um combobox, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.pegarOpcoesCombo("combo-exemplo");
```

Método retorna uma <code>**List**`<WebElement>`</code> com os elementos presentes no combobox.

> <span style="color: green;">**Return**</span>: <code>**List**`<WebElement>`</code>



### obterQuantidadeOpcoesCombo
---
Método responsável por retornar a quantidade de elementos presentes em um combobox, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterQuantidadeOpcoesCombo("combo-exemplo");
```

Método retorna um <code>**int**</code> com a quantidade de  elementos presentes no combobox.

> <span style="color: green;">**Return**</span>: <code>**int**</code>

### verificarSeExisteOpcaoNoSelect
---
Método responsável por verificar se existe uma determinada opção em um determinado combobox, recebe dois parâmentros do tipo <code>**String**</code> e retorna um dado do tipo <code>**boolean**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> opcaoTexto

Ex:

```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.verificarSeExisteOpcaoNoSelect("combo-exemplo", "texto")
```

O método retorna um dado tipo <code>**boolean**</code> com o valor <code>**true**</code> caso exista a opção caso contrário retorna <code>**false**</code>.

> <span style="color: green;">**Return**</span>: <code>**boolean**</code>

### quebrarSeNaoExisteOpcaoNoSelect
---
Método responsável por invelidar o teste caso não seja encontrada uma determinada opção no select, recebe dois parâmetros do tipo <code>**String**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> opcaoTexto

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.quebrarSeNaoExisteOpcaoNoSelect("combo-exemplo","texto");
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### desmarcarComboPorTextoVisivel
---
Método responsável por desmarcar um combobox através da opção selecionada, recebe dois parâmetros do tipo <code>**String**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> opcaoTexto

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.desmarcarComboPorTextoVisivel("combo-exemplo", "texto");
```

Caso ocorra algum erro ou a opção não exista dentro do combobox o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não existe este valor dentro da desde select!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### obterTextosCombo
---
Médoto responsável por obter todos os textos presentes num determinado combobox, recebe um parâmetro do tipo <code>**String**</code>.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterTextosCombo("combo-exemplo");
```

Método retorna uma <code>**List**`<String>`</code> com os textos presentes no combobox.

> <span style="color: green;">**Return**</span>: <code>**List**`<String>`</code>


### obterTodasAsOpcoesSelecionadasNoCombo
---
Método responsável por retornar todos o valores selecionados em um determinado combobox, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterTodasAsOpcoesSelecionadasNoCombo("combo-exemplo");
```

Método retorna uma <code>**List**`<String>`</code> com os textos selecionados no combobox.

> <span style="color: green;">**Return**</span>: <code>**List**`<String>`</code>


## Trabalhando com Iframes

### entrarFrame
---
Método responsável por mudar o contexto para dentro de um determinado Iframe, recebe uma <code>**String**</code> como parâmetro.

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.entrarFrame("iframe-exemplo");
```

Caso ocorra algum erro o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não existe este  frame como padrão!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### sairFrame
---
Método responsável por mudar o contexto para o contexto default (navegador),  método não recebe nenhum parâmetro.

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.sairFrame();
```

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


## Trabalhando com alerts

### getAlert
---
Método responsável por mudar o contexto para o alerta do navegador, não recebe nenhum parâmetro e retorna uma objeto do tipo <code>**Alert**</code>.

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.getAlert();
```

Caso ocorro a algum erro o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não existe um alerta na tela

Método retorna uma objeto do tipo <code>**Alert**</code>

> <span style="color: green;">**Return**</span>: <code>**Alert**</code>

### aceitarAlerta
---
Método responsável por aceitar um <code>alert</code> do navegador, método não recebe nenhum parâmetro.

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.aceitarAlerta();
```

Caso ocorro a algum erro o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não é um alerta de aceitação!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>


### obterTextoDoAlerta
---
Método responsável por pegar o texto presente no <code>alert</code> do navegador, não recebe nenhum parâmetro.

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterTextoDoAlerta();
```

Caso ocorra algum erro o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não ha texto em alert para ser extraído!

Método retorna uma <code>**String**</code> contendo o texto do alerta.

> <span style="color: green;">**Return**</span>: <code>**String**</code>


### negarAlerta
---
Método responsável por negar uma <code>Alert</code> do navegador,não recebe nenhum parâmetro.

Ex:
```java
ComandosBasicos comBasico = new ComandosBasicos(driver);
comBasico.obterTextoDoAlerta();
```

Caso ocorra algum erro o método retornará a seguinte <code>**Exception**</code>:

> <span style="color: red;">**Exception**</span>: Não é um alerta de rejeição!

Método não tem retorno.

> <span style="color: green;">**Return**</span>: <code>**void**</code>

### escreverNoAlerta
---


