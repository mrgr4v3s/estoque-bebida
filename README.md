# Controle Estoque bebida

API para gerenciamento e controle de um estoque de bebidas utilizando Spring Boot e H2

# Endpoints
* **GET** - */estoque/volume* - Endpoint para consulta do volume atual do estoque
* **GET** - */estoque/tipo-bebida/{tipoBebidaId}/entrada* - Consulta das seções disponíveis para entrada do Tipo Bebida informado
* **GET** - */estoque/tipo-bebida/{tipoBebidaId}/venda* - Consulta das seções disponíveis para venda do Tipo Bebida informado
* **POST** - */historico/bebida* - Consulta de histórico de movimentações. Filtro: Tipo Bebida.
* **POST** - */historico/secao* - Consulta de histórico de movimentações. Filtro: Seção
* **POST** - */secao/bebida/entrada* - Cadastro de entrada de bebida em uma seção
* **POST** - */secao/bebida/venda* - Cadastro de venda de bebida em uma seção
* **POST** - */secao/bebida* - Consulta do volume de bebida na seção.
* **GET** - */tipo-bebida/{tipoBebidaId}* - Consulta de tipo bebida
* **POST** - */tipo-bebida* - Cadastro de tipo bebida
* **PUT** - */tipo-bebida/{tipoBebidaId}* - Alterar tipo bebida
* **DELETE** - */tipo-bebida/{tipoBebidaId}* - Remover tipo bebida

# Payloads
## Consulta de histórico
Campo *"tipoBebidaId"* é obrigatório na consulta por bebida

Campo *"secaoId"* é obrigatório na consulta por seção

```{ "tipoBebidaId": 1, "secaoId": 1}```

## Cadastros de entrada/saída de bebida da Seção
## Consulta de volume no estoque
Todos os campos são obrigatórios para cadastro

Para consulta somente os campos *"secaoId"* e *"tipoBebidaId"* são obrigatórios

```{ "secaoId": 1, "tipoBebidaId": 1, "volume": 10, "responsavelMovimento": "Jhonnatan Vieira"}```

## Cadastro/Alteração do Tipo Bebida
Todos os campos são obrigatórios no cadastro

Na alteração é necessário informar ao menos um campo

```{"nome": "Remédio", "volume": 1000}```

## Erro
Em caso de erro nas validações terá como resposta a mensagem do erro juntamente com uma instrução

