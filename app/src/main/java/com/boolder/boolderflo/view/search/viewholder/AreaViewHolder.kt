package com.boolder.boolderflo.view.search.viewholder

import android.view.ViewGroup
import com.boolder.boolderflo.databinding.SearchResultAreaItemBinding
import com.boolder.boolderflo.domain.model.Area
import com.boolder.boolderflo.utils.extension.inflater
import com.boolder.boolderflo.view.search.BaseViewHolder

class AreaViewHolder private constructor(
    private val binding: SearchResultAreaItemBinding,
    private val onAreaClicked: (Area) -> Unit
) : BaseViewHolder(binding.root) {

    fun bind(area: Area) {
        binding.apply {
            root.setOnClickListener { onAreaClicked(area) }
            areaName.text = area.name
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onAreaClicked: (Area) -> Unit
        ) = AreaViewHolder(
            binding = SearchResultAreaItemBinding.inflate(parent.inflater, parent, false),
            onAreaClicked = onAreaClicked
        )
    }
}
