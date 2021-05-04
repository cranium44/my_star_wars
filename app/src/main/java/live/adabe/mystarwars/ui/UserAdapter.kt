package live.adabe.mystarwars.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import live.adabe.mystarwars.databinding.UserItemBinding
import live.adabe.mystarwars.model.User
import live.adabe.mystarwars.navigation.NavigationService
import javax.inject.Inject

class UserAdapter(private val data: List<User>, private val navigationService: NavigationService): RecyclerView.Adapter<UserAdapter.Holder>() {

    class Holder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.apply {
                userName.text = user.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding).listen { position, _ ->
            val user = data[position]
            with(Bundle()){
                putString(Constants.NAME, user.name)
                putString(Constants.GENDER, user.gender)
                putString(Constants.HEIGHT, user.height)
                navigationService.openDetailsScreen(this)
            }

        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user = data[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}