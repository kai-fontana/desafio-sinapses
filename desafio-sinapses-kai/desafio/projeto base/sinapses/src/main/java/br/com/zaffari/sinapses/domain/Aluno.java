// package br.com.zaffari.sinapses.domain;

// //import java.util.List;

// import jakarta.persistence.*;

// @Table(name = "alunos")
// @Entity(name = "alunos")
// public class Aluno {

//     /*@Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     protected Long matricula;*/
//     protected String nome;

//     /*@OneToMany
//     protected List<Sinapse> sinapses;*/
    
//     public Aluno() {}

//     public Aluno(String nome) {
//         this.nome = nome;
//     }

//     public Aluno(RequestAluno requestAluno) {
//         this.nome = requestAluno.nome();
//     }

//     /*public Aluno(Long matricula, String nome, List<Sinapse> sinapses) {
//         this.matricula = matricula;
//         this.nome = nome;
//         this.sinapses = sinapses;
//     }*/

//     /*public Aluno(RequestAluno requestAluno) {
//         this.matricula = requestAluno.matricula();
//         this.nome = requestAluno.nome();
//         this.sinapses = requestAluno.sinapses();
//     }*/


//     /*public Long getMatricula() {
//         return matricula;
//     }
//     public void setMatricula(Long matricula) {
//         this.matricula = matricula;
//     }*/
//     public String getNome() {
//         return nome;
//     }
//     public void setNome(String nome) {
//         this.nome = nome;
//     }


// }