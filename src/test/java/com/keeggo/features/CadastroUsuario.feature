# language: pt
@cadastro
Funcionalidade: Cadastrar Usuário

  Contexto:
    Dado que acessei a url "http://www.advantageonlineshopping.com/#/"

  @all
  Cenário:Validar mensagem de campo obrigatório na tela de cadastro de usuário
    Dado acessei a tela de login
    E para criar uma nova conta
    Quando na tela da cadastro passar pelos campos obrigatórios sem preenchê-los
    Então os campos da tela devem conter uma mensagem "field is required"
    E o botão REGISTER deve ficar desabilitado

  @all
  Cenário:Validar mensagem de campo obrigatório na tela de cadastro de usuário com Condições de Uso habilitado
    Dado acessei a tela de login
    E para criar uma nova conta
    Quando na tela da cadastro passar pelos campos obrigatórios sem preenchê-los
    E aceito as condições de uso e aviso de privacidade
    Então os campos da tela devem conter uma mensagem "field is required"
    E o botão REGISTER deve ficar desabilitado

  @all
  Cenário:Cadastro de usuário => Sucesso
    Dado acessei a tela de login
    E para criar uma nova conta
    Quando na tela da cadastro eu preencher os campos:
      | Username  | Email           | Password | FirstName | LastName | Phone     | City | Address | State    | Postal Code |
      | loginUser | test@keeggo.org | Oo1234   | test      | test     | 999999999 | Jaú  | Rua x   | Amazonas | 123         |
    E aceito as condições de uso e aviso de privacidade
    E clicar REGISTER
    Então o username do usuário  deve ser apresentado na tela

  @all
  Cenário:Cadastro de usuário => Sucesso somente campos obrigatórios
    Dado acessei a tela de login
    E para criar uma nova conta
    Quando na tela da cadastro eu preencher os campos obrigatórios:
      | Username  | Email           | Password |
      | loginUser | test@keeggo.org | Oo1234   |
    E aceito as condições de uso e aviso de privacidade
    E clicar REGISTER
    Então o username do usuário  deve ser apresentado na tela