# Explorando Padrões de Projetos na Prática com Java

Repositório com as implementações dos padrões de projeto explorados no Lab "Explorando Padrões de Projetos na Prática com Java". Especificamente, este projeto explorou alguns padrões usando o Spring Framework, são eles:
- Singleton
- Strategy/Repository
- Facade

---

### Outros Padrões e Melhoras Implementadas

Além dos padrões Gof clássicos, o projeto foi aprimorado com a implementação dos seguintes padrões e conceitos para criar uma API mais robusta e desacoplada:

#### Builder

- **O que é?** Um padrão de criação que permite a construção de objetos complexos passo a passo. Foi implementado na entidade `Cliente`.
- **Vantagens:**
    - **Legibilidade:** Torna a criação de novos objetos mais clara e fluida.
    - **Imutabilidade:** Facilita a criação de objetos imutáveis, tornando o código mais seguro.
    - **Flexibilidade:** Simplifica a criação de objetos com muitos atributos opcionais.

#### DTO (Data Transfer Object)

- **O que é?** Objetos que carregam dados entre os processos e camadas da aplicação. Foram implementados para desacoplar a camada da API (Controller) do modelo de dados (Entidades).
- **Vantagens:**
    - **Desacoplamento:** A API não expõe diretamente a estrutura do banco de dados, permitindo que ambos evoluam de forma independente.
    - **Segurança:** Evita o vazamento de campos internos da entidade.
    - **Otimização:** Permite criar "visões" diferentes dos mesmos dados, enviando apenas o que é necessário para o cliente em cada requisição.
