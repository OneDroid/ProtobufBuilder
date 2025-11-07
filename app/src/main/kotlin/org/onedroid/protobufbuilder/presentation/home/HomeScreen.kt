package org.onedroid.protobufbuilder.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.onedroid.protobufbuilder.R
import org.onedroid.protobufbuilder.presentation.component.FilePreview
import org.onedroid.protobufbuilder.presentation.component.ProtobufCard

@Composable
fun HomeScreen() {
    HomeScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenContent(
    onBuildClick: () -> Unit = {},
    onOpenClick: () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_data),
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Protobuf Builder",
                        )
                        Text(
                            text = "Protobuf Builder",
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onOpenClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings),
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "setting"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Build Protobuf Card
                ProtobufCard(
                    modifier = Modifier.weight(1f),
                    title = "Build Protobuf",
                    slogan = "Quickly design and compile your schema with ease.",
                    buttonText = "Create",
                    icon = painterResource(R.drawable.ic_code),
                    onClick = onBuildClick,
                )

                // Open Protobuf Card
                ProtobufCard(
                    modifier = Modifier.weight(1f),
                    title = "Open Protobuf",
                    slogan = "Load, inspect, and edit existing protobuf files.",
                    buttonText = "Open File",
                    icon = painterResource(R.drawable.ic_folder),
                    onClick = onOpenClick
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Recently Open Files",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                IconButton(onClick = { /* Handle more button click */ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_right),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "more"
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            FilePreview(
                fileName = "example.proto",
                date = "2023-09-20",
                onDeleteClick = {},
                onClick = {}
            )
            Spacer(modifier = Modifier.height(10.dp))
            FilePreview(
                fileName = "example.proto",
                date = "2023-09-20",
                onDeleteClick = {},
                onClick = {}
            )
            Spacer(modifier = Modifier.height(10.dp))
            FilePreview(
                fileName = "example.proto",
                date = "2023-09-20",
                onDeleteClick = {},
                onClick = {}
            )
            Spacer(modifier = Modifier.height(10.dp))
            FilePreview(
                fileName = "example.proto",
                date = "2023-09-20",
                onDeleteClick = {},
                onClick = {}
            )
        }
    }
}