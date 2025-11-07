package org.onedroid.protobufbuilder.core.utils

import android.content.Context
import android.os.Environment
import android.widget.Toast
import org.onedroid.protobufbuilder.DynamicProto
import java.io.File
import java.io.FileOutputStream


object FileUtils {
    fun saveProtoFile(context: Context, schema: String, data: Map<String, String>) {
        val exportDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val folder = File(exportDir, "ProtobufBuilder")
        if (!folder.exists()) folder.mkdirs()

        val schemaFile = File(folder, "schema.proto")
        val pbFile = File(folder, "data.pb")

        // Write schema
        FileOutputStream(schemaFile).use {
            it.write(schema.toByteArray())
        }

        // Write protobuf data
        val recordBuilder = DynamicProto.DynamicRecord.newBuilder()
        data.forEach { (key, value) ->
            recordBuilder.putFields(key, value)
        }

        FileOutputStream(pbFile).use {
            it.write(recordBuilder.build().toByteArray())
        }

        Toast.makeText(context, "Files exported to Downloads/ProtobufBuilder/", Toast.LENGTH_LONG).show()
    }
}