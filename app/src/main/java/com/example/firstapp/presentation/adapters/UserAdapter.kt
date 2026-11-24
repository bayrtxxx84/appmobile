package com.example.firstapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.domain.entities.UserUIEntity
import com.example.firstapp.databinding.UserListLayoutBinding
import com.squareup.picasso.Picasso

class UserAdapter(
    private var listUsers: List<UserUIEntity>,
    private val onSelectedItem: (UserUIEntity) -> Unit,
    private val onDeleteItem : (Int) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserVH>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserVH {
        val inflater = LayoutInflater.from(parent.context)
        return UserVH(
            inflater.inflate(
                R.layout.user_list_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: UserVH,
        position: Int
    ) {
        holder.render(listUsers[position], onSelectedItem, onDeleteItem, position)
    }

    override fun getItemCount(): Int = listUsers.size


    class UserVH(view: View) : RecyclerView.ViewHolder(view) {

        private var binding: UserListLayoutBinding = UserListLayoutBinding.bind(view)

        fun render(item: UserUIEntity,
                   onSelectedItem: (UserUIEntity) -> Unit,
                   onDeleteItem: (Int) -> Unit,
                   position: Int
        ) {
            Picasso.get().load(item.picture).into(
                binding.imgUser
            )
            binding.UserUserName.text = "${item.first}  ${item.last}"
            binding.txtUserName.text = item.email

            itemView.setOnClickListener {
                onSelectedItem(item)
            }

        }
    }


}