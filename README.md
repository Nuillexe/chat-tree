# Fórum de Comentários em Árvore

Projeto desenvolvido para a disciplina de Estrutura de Dados.

## Descrição

O sistema simula um fórum de discussões utilizando uma estrutura de árvore. Cada comentário pode possuir respostas, formando uma hierarquia de comentários e subcomentários.

A raiz da árvore é um nó especial chamado **DISCUSSÃO**, responsável por agrupar todos os comentários principais.

Exemplo:

```text
DISCUSSÃO
├── Comentário 1
│   ├── Resposta 2
│   └── Resposta 3
└── Comentário 4
```

## Funcionalidades

* Criar comentários
* Responder comentários
* Editar comentários
* Remover comentários e suas subárvores
* Navegar entre comentários
* Exibir caminho até um comentário
* Exibir a árvore completa
* Listar comentários folha
* Contabilizar comentários

## Estrutura do Projeto

```text
Comentario.java
ComentarioTree.java
ForumService.java
UI.java
Main.java
```

### Comentario

Representa um nó da árvore.

### ComentarioTree

Responsável pelas operações sobre a árvore de comentários.

### ForumService

Contém a lógica de negócio e interação com o usuário.

### UI

Responsável pela exibição das informações.

### Main

Ponto de entrada da aplicação.

## Comandos

| Comando | Descrição |
|----------|------------|
| C | Criar um novo comentário ou resposta ao comentário atual |
| E | Editar o comentário atual |
| D | Excluir o comentário atual |
| V | Navegar para um comentário informando seu ID |
| B | Retornar ao comentário pai |
| B0 | Retornar à conversa principal |
| F | Listar todos os comentários folha da árvore |
| A | Exibir a estrutura completa da árvore de comentários |
| U | Exibir todos os comentários de um autor |
| M | Exibir o menu de comandos |
| S | Encerrar o sistema |


## Equipe e Divisão de Responsabilidades

| Integrante                                | GitHub                      | Responsabilidades                                                                                                                                                                              |
| ----------------------------------------- | --------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Ana Clara Marinho Viana                   | @anaclaramarinhoviana77-alt | Implementação da camada de serviços (`ForumService`) e das regras de negócio do sistema.                                                                                                       |
| Charles Brendon Silva Suzart              | @CharlesBrendonIF           | Desenvolvimento da classe `Comentario`, incluindo atributos, comportamentos e representação dos comentários.                                                                                   |
| Emanuel Fonseca Nogueira                  | @Nuillexe                   | Scrum Master e Gerente de Projeto, responsável pelo planejamento, organização das atividades, definição da arquitetura do sistema, integração dos módulos e acompanhamento do desenvolvimento. |
| Kaique Santos Moreira                     | @KaiqueFullDev              | Implementação da estrutura de árvore (`ComentarioTree`) e das operações de manipulação dos comentários.                                                                                        |
| Maria Eduarda De Oliveira Ferreira Santos | @eduardasxntos              | Desenvolvimento da interface textual (`UI`) e apresentação das informações ao usuário.                                                                                                         |

</table>


</table>






  
