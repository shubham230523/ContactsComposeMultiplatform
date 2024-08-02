package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.compose.runtime.Composable

expect class ImagePicker {

    @Composable
    fun registerPicker(onImagePicker: (ByteArray) -> Unit)

    fun pickImage()
}