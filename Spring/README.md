# Spring Boot 

<details>
<summary><b>📒 Principais anotações:</b></summary>

   1. @Repository
      
      Anotação de nível de classe que gerencia a parte do código responsável pela interação com o banco de dados.
      
      **Normalmente os repository são interfaces e não classes.**

      é comum extender de JPARepository<Classe que vai controlar, tipo do ID da classe> ou CrudRepository<Classe que vai controlar, tipo do ID da classe>.

   #

   2. @Service

      Anotação de nível de classe que gerencia a parte do código responsável pela regra de negócio (lógica) do projeto.

   #

   3. @Controller / @RestController

      Anotação de nível de classe que gerencia a parte do código responsável pela chamada das telas integrando os seviços com o frontend.

      O @RestController retorna os dados para o frontend através de arquivos JSON.

      ### Sub anotações:

      Anotações de nível de método.

      1. @GetMapping("/something") - Faz com que as requisições HTTP do tipo GET em url/something acione o método.
      2. @PostMapping("/something") - Faz com que as requisições HTTP do tipo POST em url/something acione o método.
      3. @RequestMapping("/something") - Faz com que as requisições HTTP do tipo REQUEST em url/something acione o método.

   #

   4. @Configuration

      Anotação de nível de classe que gerencia a parte do código responsável por partes genericas do código que não se encaixam nas outras partes do código.

      Ex: operação com datas.
      
   #

   5. @Component

      Anotação de nível de classe que gerencia a parte do código responsável pela chamada das telas integrando os seviços com o frontend.

   #
      
   6. @Entity

      São as classes que constroem o banco de dados.
      
      ### Sub anotações:
      1. @Id - sinaliza qual será a chave primária (PK).
      
      2. @Column - indica que será uma coluna do BD. É possivel passar entre parêntesis o atributo Length (VarChar) que por default é 250;

               @Column(length=2000)
      
      3. @GeneratedValue - indica que é um campo sequencial.

      4. @ManyToOne - indica que possui uma relação de n para 1 com outra classe.
      5. @ManyToMany - indica que possui uma relação de n para n com outra classe.
      6. @OneToMany -  indica que possui uma relação de 1 para n com outra classe.
      7. @OneToOne -  indica que possui uma relação de 1 para 1 com outra classe.

</details>