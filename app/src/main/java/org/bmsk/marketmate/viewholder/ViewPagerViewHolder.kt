package org.bmsk.marketmate.viewholder

import org.bmsk.marketmate.ListAdapter
import org.bmsk.marketmate.databinding.ItemViewpagerBinding
import org.bmsk.marketmate.model.ListItem
import org.bmsk.marketmate.model.ViewPager

class ViewPagerViewHolder(
    binding: ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding) {
    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}