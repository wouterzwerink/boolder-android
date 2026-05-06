package com.boolder.boolderflo.view.search.viewholder

import android.view.ViewGroup
import com.boolder.boolderflo.databinding.SearchResultItemBinding
import com.boolder.boolderflo.utils.extension.inflater
import com.boolder.boolderflo.view.search.BaseViewHolder
import com.boolder.boolderflo.view.search.CategoryHeader

class CategoryHeaderViewHolder private constructor(
    private val binding: SearchResultItemBinding
) : BaseViewHolder(binding.root) {

    fun bind(header: CategoryHeader) {
        binding.title.apply {
            text = context.getString(header.titleId)
        }
    }

    companion object {
        fun create(parent: ViewGroup) = CategoryHeaderViewHolder(
            binding = SearchResultItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}
