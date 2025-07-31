package com.example.waristmate.data

import com.example.waristmate.R

object BabRepository{
    val babList = listOf(
        Bab(
            id = 1,
            titleResId = R.string.bab_1_title,
            route = "bab_detail/1",
            imageResId = R.drawable.bab_1
        ),
        Bab(
            id = 2,
            titleResId = R.string.bab_2_title,
            route = "bab_detail/2",
            imageResId = R.drawable.bab_2
        ),
        Bab(
            id = 3,
            titleResId = R.string.bab_3_title,
            route = "bab_detail/3",
            imageResId = R.drawable.bab_3
        ),
        Bab(
            id = 4,
            titleResId = R.string.bab_4_title,
            route = "bab_detail/4",
            imageResId = R.drawable.bab_4
        ),
        Bab(
            id = 5,
            titleResId = R.string.bab_5_title,
            route = "bab_detail/5",
            imageResId = R.drawable.bab_5
        ),
        Bab(
            id = 6,
            titleResId = R.string.bab_6_title,
            route = "bab_detail/6",
            imageResId = R.drawable.bab_6
        ),
        Bab(
            id = 7,
            titleResId = R.string.bab_7_title,
            route = "bab_detail/7",
            imageResId = R.drawable.bab_7
        ),
        Bab(
            id = 8,
            titleResId = R.string.bab_8_title,
            route = "bab_detail/8",
            imageResId = R.drawable.bab_8
        ),
        Bab(
            id = 9,
            titleResId = R.string.bab_9_title,
            route = "bab_detail/9",
            imageResId = R.drawable.bab_9
        ),
        Bab(
            id = 10,
            titleResId = R.string.bab_10_title,
            route = "bab_detail/10",
            imageResId = R.drawable.bab_10
        ),
        Bab(
            id = 11,
            titleResId = R.string.bab_11_title,
            route = "bab_detail/11",
            imageResId = R.drawable.bab_11
        ),
        Bab(
            id = 12,
            titleResId = R.string.bab_12_title,
            route = "bab_detail/12",
            imageResId = R.drawable.bab_12
        ),
    )

    fun getBabById(babId: Int): Bab? {
        return babList.find {it.id == babId}
    }
}
