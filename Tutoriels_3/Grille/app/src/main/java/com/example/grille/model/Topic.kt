package com.example.grille.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val nom: Int,
    val nombreCours: Int,
    @DrawableRes val img: Int
){
}