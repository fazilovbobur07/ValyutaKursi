package com.example.valyutakursi.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(var list:List<Valyuta>, val rvClick: RvClick) : RecyclerView.Adapter<UserAdapter.Vh>() {

    inner class Vh(var itemRv: ItemRvBinding): RecyclerView.ViewHolder(itemRv.root){
        fun onBind(valyuta : Valyuta, position: Int){
            itemRv.tv1.text=valyuta.CcyNm_UZ
            if (valyuta.Diff.toFloat()<0){
                itemRv.itemRvImg.setImageResource(R.drawable.decrease)
            }else if(valyuta.Diff.toFloat()>0){
                itemRv.itemRvImg.setImageResource(R.drawable.increase)
            }else{
                itemRv.itemRvImg.setImageResource(R.drawable.minus)
            }
            itemRv.tv2.text=valyuta.Rate

            itemRv.mainCard.setOnClickListener {
                rvClick.onClick(valyuta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


    interface RvClick{
        fun onClick(valyuta: Valyuta)
    }
}