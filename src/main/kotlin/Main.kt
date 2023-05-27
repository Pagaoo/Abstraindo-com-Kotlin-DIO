enum class Nivel {BASICO, INTERMEDIARIO, DIFICIL}

data  class Aluno(var nome: String, var matricula: Int)

data class ConteudoEducacional(var nome: String, var desc: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        for(aluno in alunos) {
            if(!inscritos.contains(aluno)) {
                inscritos.add(aluno)
            } else println("Aluno: ${aluno.nome} de matricula: ${aluno.matricula} já está inscrito no curso")
        }
    }

    fun listarMatriculados(nome: String) {
        for (aluno in inscritos) {
            println("Aluno: ${aluno.nome}, matricula: ${aluno.matricula} inscrito no curso ${nome}.")
        }
    }
}

fun main() {
    val conteudoCurso1_1 = ConteudoEducacional("Lógica de Programação", "Neste curso você irá aprender lógica de programação", 210)
    val conteudoCurso1_2 = ConteudoEducacional("Análise de Algoritmo", "Aprenda a analisar e otimizar seus algoritmos", 100)
    val conteudoCurso1_3 = ConteudoEducacional("Engenharia de Software", "Conhecer os fundamentos de desenvolvimento de Software", 360)
    val conteudoCurso1_4 = ConteudoEducacional("Estrutura de Dados I", "Explanação de estruturas de dados mais básicas usadas", 260)
    val conteudoCurso1_5 = ConteudoEducacional("Estrutura de Dados II", "Uso de estruturas de dados mais avançadas na programação", 200)

    val curso1 = Formacao("Programação avançada de Software", Nivel.DIFICIL, listOf(conteudoCurso1_1,conteudoCurso1_2,conteudoCurso1_3,conteudoCurso1_4,conteudoCurso1_5))

    val aluno = Aluno("Gabriel", 123)
    val aluno2 = Aluno("Rogerio", 124)
    val aluno3 = Aluno("Sarah", 125)
    val aluno4 = Aluno("Monique", 126)
    val aluno5 = Aluno("Jorge", 1231)

    curso1.matricular(aluno,aluno2,aluno3,aluno4,aluno5)
    curso1.listarMatriculados(curso1.nome)
}