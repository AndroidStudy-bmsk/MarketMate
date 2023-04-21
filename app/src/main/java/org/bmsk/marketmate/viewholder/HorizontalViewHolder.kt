package org.bmsk.marketmate.viewholder

import org.bmsk.marketmate.ListAdapter
import org.bmsk.marketmate.databinding.ItemHorizontalBinding
import org.bmsk.marketmate.model.Horizontal
import org.bmsk.marketmate.model.ListItem

class HorizontalViewHolder(
    private val binding: ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding) {
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }
}