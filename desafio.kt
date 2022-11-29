
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Aluno(val nome: String, val matricula: String) {
    override fun toString(): String {
        return "$nome - matricula: $matricula"
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "$nome: duracao $duracao horas"
    }
}

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        inscritos.addAll(alunos)
    }

    override fun toString(): String {
        return """
            Nome: $nome
            Nivel: $nivel
            Conteudo Educacional: $conteudos
            Alunos matriculados: $inscritos
            
        """.trimIndent()
    }
}

fun main() {
    val thox = Aluno("Thox", "101010")
    val dex = Aluno("Dex", "202020")
  
    val logicaDeProgrmacao = ConteudoEducacional("Logica de Programacao", 80)
    val poo = ConteudoEducacional("POO", 80)
    val java = ConteudoEducacional("Java")
    val kotlin = ConteudoEducacional("Kotlin", 120)

    val desenvolvedorMobile = Formacao(
        "Desenvolvedor Mobile",
        Nivel.BASICO,
        listOf(logicaDeProgrmacao, poo, kotlin)
    )

    val desenvolvedorBackEnd = Formacao(
        "Desenvolvedor BackEnd",
        Nivel.INTERMEDIARIO,
        listOf(logicaDeProgrmacao, poo, java)
    )

    desenvolvedorMobile.matricular(thox)
    desenvolvedorBackEnd.matricular(dex)

    println(desenvolvedorMobile)
    println(desenvolvedorBackEnd)
}