/*
 COMANDOS BÁSICOS
 */

/* SELECT */
/* select * from [ESQUEMA_OU_NOMEBANCO].[TABELA] */
select * from buscadorpalavras.configuracao;

select chave, valor from buscadorpalavras.configuracao;

/*
   select [ALIAS].*
   from [ESQUEMA_OU_NOMEBANCO].[TABELA] [ALIAS]
 */

select config.* from buscadorpalavras.configuracao config;

select config.chave, config.valor
from buscadorpalavras.configuracao config;


/*
   select [ALIAS].*
   from [ESQUEMA_OU_NOMEBANCO].[TABELA] [ALIAS]
   WHERE [ALIAS].COLUNA = 'VALOR'
 */

select config.*
from buscadorpalavras.configuracao config
where config.chave like 'expressao.%';

select config.chave, config.valor
from buscadorpalavras.configuracao config
where config.chave like 'expressao.%';;
