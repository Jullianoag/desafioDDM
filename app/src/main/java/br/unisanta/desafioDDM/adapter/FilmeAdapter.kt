package br.unisanta.desafioDDM.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.desafioDDM.R
import br.unisanta.desafioDDM.model.Filme
import com.bumptech.glide.Glide

class FilmeAdapter(private val filmes: MutableList<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloFilme = itemView.findViewById<TextView>(R.id.txv_titulo_card)
        val generoFilme = itemView.findViewById<TextView>(R.id.txv_genero_card)
        val btnEditar = itemView.findViewById<Button>(R.id.btn_editar)
        val btnExcluir = itemView.findViewById<Button>(R.id.btn_excluir)
        val imgBanner = itemView.findViewById<ImageView>(R.id.imv_banner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]

        holder.tituloFilme.text = filme.titulo
        holder.generoFilme.text = filme.genero
        Glide.with(holder.itemView).load(filme.url).into(holder.imgBanner)

        holder.btnExcluir.setOnClickListener {
            val pos = holder.adapterPosition
            if(pos != RecyclerView.NO_POSITION){
                filmes.removeAt(pos)
                notifyItemRemoved(pos)
                notifyItemRangeChanged(pos, filmes.size)
            }
        }
    }
}