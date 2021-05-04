package live.adabe.mystarwars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import live.adabe.mystarwars.databinding.UserItemBinding
import live.adabe.mystarwars.model.User

class UserAdapter(private val data: List<User>): RecyclerView.Adapter<UserAdapter.Holder>() {

    class Holder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.apply {
                userName.text = user.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user = data[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}