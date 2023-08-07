// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.pra.daggermvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Products (
    val image: String,
    val price: Double,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val category: String
)


