package org.onedroid.protobufbuilder

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import org.onedroid.protobufbuilder.core.navigation.AppNavigation
import org.onedroid.protobufbuilder.core.navigation.Route
import org.onedroid.protobufbuilder.presentation.theme.ProtobufBuilderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            0
        )

        enableEdgeToEdge()
        setContent {
            ProtobufBuilderTheme(
                darkTheme = false
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val snackBarHostState = remember { SnackbarHostState() }
                    AppNavigation(
                        navController = navController,
                        initialScreen = Route.Home,
                        snackBarHostState = snackBarHostState,
                    )
                }
            }
        }
    }
}


/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            0
        )

        enableEdgeToEdge()
        setContent {
            ProtobufBuilderTheme {

                var screen by remember { mutableStateOf("schema") }
                var schema by remember { mutableStateOf("") }
                var data by remember { mutableStateOf(mapOf<String, String>()) }

                when (screen) {
                    "schema" -> SchemaScreen(
                        onNext = { schemaString ->
                            schema = schemaString
                            screen = "data"
                        }
                    )
                    "data" -> DataEntryScreen(
                        schema = schema,
                        onNext = { userData ->
                            data = userData
                            screen = "export"
                        }
                    )
                    "export" -> ExportScreen(schema, data)
                }
            }
        }
    }
}*/


/*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchemaScreen(onNext: (String) -> Unit) {
    var schemaText by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Define Schema") }) },
        floatingActionButton = {
            Button(onClick = { onNext(schemaText) }) {
                Text("Next")
            }
        }
    ) { padding ->
        TextField(
            value = schemaText,
            onValueChange = { schemaText = it },
            label = { Text("Enter your schema (.proto style)") },
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataEntryScreen(schema: String, onNext: (Map<String, String>) -> Unit) {
    val fieldList = remember {
        schema.lines()
            .filter { it.trim().startsWith("string") || it.trim().startsWith("int32") }
            .map { it.trim().split(" ")[1] }
    }
    val fieldValues = remember { mutableStateMapOf<String, String>() }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Enter Data") }) },
        floatingActionButton = {
            Button(onClick = { onNext(fieldValues) }) {
                Text("Next")
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding)) {
            fieldList.forEach { field ->
                TextField(
                    value = fieldValues[field] ?: "",
                    onValueChange = { fieldValues[field] = it },
                    label = { Text(field) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExportScreen(schema: String, data: Map<String, String>) {
    val context = LocalContext.current

    Scaffold(
        topBar = { TopAppBar(title = { Text("Export Files") }) }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Schema Preview:")
            Text(schema)
            Spacer(Modifier.height(16.dp))
            Text("Data Preview:")
            data.forEach { (key, value) ->
                Text("$key: $value")
            }
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                FileUtils.saveProtoFile(context, schema, data)
                Toast.makeText(context, "Files exported to Downloads/ProtobufBuilder/", Toast.LENGTH_LONG).show()
            }) {
                Text("Export .proto & .pb")
            }
        }
    }
}*/
