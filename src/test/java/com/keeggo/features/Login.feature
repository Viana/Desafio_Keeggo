# language: pt
@login
Funcionalidade: Realizar login

  Contexto:
    Dado que acessei a url "http://www.advantageonlineshopping.com/#/"

  @all
  Cenário: Validar login pelo Facebook
    Dado acessei a tela de login
    Quando tentar logar com login "rodrigo_keeggo" pelo usuário do facebook
    Então  o  login do usuário deve ser apresentado na tela

  @all
  Cenário:Validar mensagem de campo obrigatório na tela de login
    Dado acessei a tela de login
    Quando passar pelos campos obrigatórios sem preenchê-los
    Então os campos devem conter uma mensagem "field is required"
    E o botão SIGN IN deve ficar desabilitado

  @all
  Esquema do Cenário: Realizar login com usuario e/ou senha inválida
    Dado acessei a tela de login
    E preencher os campos de login:
      | Username   | Password   |
      | <Username> | <Password> |
    Quando clicar SIGN IN
    Então  a mensagem "Incorrect user name or password." deve ser informada na tela
    Exemplos:
      | Username       | Password |
      | testttte       | testttte |
      | rodrigo_keeggo | 1234     |

  @all
  Esquema do Cenário: Cenário: Realizar login com sucesso
    Dado acessei a tela de login
    E preencher os campos de login:
      | Username   | Password   |
      | <Username> | <Password> |
    Quando clicar SIGN IN
    Então o usuário "<Username>" deve ser apresentado na tela
    Exemplos:
      | Username       | Password |
      | rodrigo_keeggo | Aa12     |