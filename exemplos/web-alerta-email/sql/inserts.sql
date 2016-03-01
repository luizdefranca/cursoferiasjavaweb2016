/*
 COMANDOS BÁSICOS
 */

/* INSERT */
/*
insert [ESQUEMA_OU_NOMEBANCO].[TABELA]
(coluna01-INT, coluna02-VARCHAR, coluna03-VARCHAR)
VALUES(valor01, 'valor02', 'valor03');
*/

insert into buscadorpalavras.configuracao(chave, valor)
values ('arquivo.caminho','linksPositivos.txt');

insert into buscadorpalavras.configuracao(chave, valor)
values ('expressao.regular.filtro','(dilma)|(lula)');

insert into buscadorpalavras.configuracao(chave, valor)
values ('expressao.regular.url','(http)(s)?(://)([\\w\\-]+\\.?\\/?)+((\\?|&)[\\w;]*=?[\\w;]*)*');

insert into buscadorpalavras.configuracao(chave, valor)
values ('url.site','http://www.folha.com');
