package org.bmsk.marketmate

import android.view.ViewGroup
import org.bmsk.marketmate.model.ListItem
import org.bmsk.marketmate.viewholder.BindingViewHolder
import org.bmsk.marketmate.viewholder.ViewHolderGenerator

class ListAdapter :
    androidx.recyclerview.widget.ListAdapter<ListItem, BindingViewHolder<*>>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.viewType?.ordinal ?: -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent, viewType)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }
}