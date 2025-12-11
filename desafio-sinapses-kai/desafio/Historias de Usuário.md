
---

# 🧠 **História de Usuário 1 — Criar uma Sinapse (Create)**

**Como** um **aluno**,
**eu quero** cadastrar uma nova *sinapse*,
**para** registrar um conteúdo que aprendi e manter meu histórico de aprendizado atualizado.

### ✔ Critérios de Aceite

* A sinapse deve conter:

  * título
  * descrição (opcional)
  * categoria
  * data em que aprendi
  * fonte do aprendizado
* A API deve validar campos obrigatórios.
* A API deve salvar a sinapse vinculada ao aluno autenticado.
* A API deve retornar a sinapse criada com ID único.

### 📌 Endpoint sugerido

`POST /sinapses`

---

# 🧠 **História de Usuário 2 — Consultar Sinapses (Read - Lista)**

**Como** um **aluno**,
**eu quero** consultar todas as minhas *sinapses*,
**para** visualizar tudo o que já aprendi e acompanhar minha evolução.

### ✔ Critérios de Aceite

* Deve retornar lista paginada de sinapses do aluno.
* Deve permitir filtro por:

  * categoria
  * data
  * palavra-chave
* Cada sinapse da lista deve mostrar:

  * título
  * categoria
  * data aprendida
  * fonte
  * ID

### 📌 Endpoint sugerido

`GET /sinapses`

---

# 🧠 **História de Usuário 3 — Consultar uma Sinapse Específica (Read - Detalhe)**

**Como** um **aluno**,
**eu quero** consultar uma *sinapse* específica,
**para** ver seus detalhes completos quando necessário.

### ✔ Critérios de Aceite

* Deve retornar todos os dados da sinapse, incluindo descrição.
* Se o ID não existir ou não pertencer ao aluno, deve retornar erro adequado.
* Deve mostrar data de criação e última atualização.

### 📌 Endpoint sugerido

`GET /sinapses/{id}`

---

# 🧠 **História de Usuário 4 — Atualizar uma Sinapse (Update)**

**Como** um **aluno**,
**eu quero** editar uma *sinapse* que cadastrei,
**para** corrigir informações ou complementar detalhes do meu aprendizado.

### ✔ Critérios de Aceite

* A API deve permitir atualizar:

  * título
  * descrição
  * categoria
  * data
  * fonte
* A API deve validar alterações.
* Deve impedir que o aluno edite sinapses de outros alunos.
* Deve registrar a data da última atualização.

### 📌 Endpoint sugerido

`PUT /sinapses/{id}`

---

# 🧠 **História de Usuário 5 — Remover uma Sinapse (Delete)**

**Como** um **aluno**,
**eu quero** excluir uma *sinapse*,
**para** remover conteúdos que cadastrei por engano ou que não fazem mais sentido no meu histórico.

### ✔ Critérios de Aceite

* Deve excluir somente sinapses pertencentes ao aluno.
* Se o ID não existir, retornar erro específico.
* Deve retornar confirmação da exclusão.

### 📌 Endpoint sugerido

`DELETE /sinapses/{id}`

---
