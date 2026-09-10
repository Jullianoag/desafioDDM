package br.unisanta.desafioDDM.dao

import br.unisanta.desafioDDM.model.Filme

class FilmeDAO {
    companion object {
        private val filmes = mutableListOf<Filme>()

        fun salvar(titulo: String, genero: String, url: String): String {
            filmes.add(Filme(titulo, genero, url))
            return "Filme Salvo"
        }

        fun obter(): MutableList<Filme> {
            return filmes
        }
    }
}