package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

actual class ImagePicker(
    private val activity: ComponentActivity
) {
    private lateinit var getContent: ActivityResultLauncher<String>

    @Composable
    actual fun registerPicker(onImagePicker: (ByteArray) -> Unit) {
        getContent = rememberLauncherForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->
            uri?.let {
                activity.contentResolver.openInputStream(it)?.use {
                    onImagePicker(it.readBytes())
                }
            }
        }
    }

    actual fun pickImage() {
        getContent.launch("image/*")
    }
}