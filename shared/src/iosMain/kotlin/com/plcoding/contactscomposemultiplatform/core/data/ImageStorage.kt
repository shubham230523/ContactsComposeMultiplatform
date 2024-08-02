package com.plcoding.contactscomposemultiplatform.core.data

actual class ImageStorage {

    actual suspend fun saveImage(byteArray: ByteArray): String {
        return ""
    }

    actual suspend fun getImage(fileName: String): ByteArray? {
        return null
    }

    actual suspend fun deleteImage(fileName: String) {

    }
}