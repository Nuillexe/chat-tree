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

| Comando | Descrição                |
| ------- | ------------------------ |
| C       | Criar comentário         |
| D       | Deletar comentário       |
| E       | Editar comentário        |
| V       | Visitar comentário filho |
| B       | Voltar ao comentário pai |
| F       | Mostrar folhas           |
| A       | Mostrar árvore completa  |
| M       | Mostrar menu             |

## Equipe

* Integrador/Scrum Master: Nome
* Desenvolvedor 1
* Desenvolvedor 2
* Desenvolvedor 3
* Desenvolvedor 4
* Desenvolvedor 5
* Desenvolvedor 6


## Novas tarefas:
* Kaique: Atualizar menu, com base no swicth da main
* Charles: EditarComentario: Não permitir editar comentario raiz, em lerID(), colocar mengsaem: "Digitar Id"
* Duda: ObterCaminho()-> GOstaria que retornasse n só o id, mas tbm o autor, tipo: id(<nomeDoAutor>)


  
