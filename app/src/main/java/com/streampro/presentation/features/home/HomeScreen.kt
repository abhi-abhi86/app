package com.streampro.presentation.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.streampro.domain.model.Movie
import com.streampro.presentation.components.GlassCard
import com.streampro.presentation.components.ShimmerMovieList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onMovieClick: (String) -> Unit,
    onSettingsClick: () -> Unit
) {
    val movies = viewModel.moviesStream.collectAsLazyPagingItems()
    val searchQuery = viewModel.searchQuery.collectAsState(initial = "")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("StreamPro") },
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(
                            androidx.compose.material.icons.Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color.Transparent
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Search Bar
                OutlinedTextField(
                    value = searchQuery.value,
                    onValueChange = { viewModel.onSearchQueryChange(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("Search movies...", color = Color.White.copy(alpha = 0.7f)) },
                    leadingIcon = {
                        Icon(
                            androidx.compose.material.icons.Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        cursorColor = Color.White,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.White.copy(alpha = 0.1f),
                        unfocusedContainerColor = Color.White.copy(alpha = 0.1f)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    
                    // Trending Now Section
                    item {
                        SectionHeader(title = "Trending Now")
                        // In a real app, you might have different lists for different sections.
                        // For now we will reuse the paged list or simulate it.
                        // Since paging is tricky with multiple horizontal lists, we will just show the paged list in one of them or simulate.
                        // For demonstration, let's use the paged items in a single row for "Trending"
                        
                         if (movies.loadState.refresh is LoadState.Loading) {
                            ShimmerMovieList()
                        } else {
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(movies.itemCount) { index ->
                                    movies[index]?.let { movie ->
                                        MovieItem(movie = movie, onClick = { onMovieClick(movie.cloudKey) })
                                    }
                                }
                            }
                        }
                    }

                    // Latest Releases Section
                    item {
                        SectionHeader(title = "Latest Releases")
                        // Reusing the same list for demo purposes, but ideally this is a different data source
                         if (movies.loadState.refresh is LoadState.Loading) {
                             // Optional: Smaller shimmer or different loading state
                        } else {
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                // Just taking some items reversed or shifted for variety in demo
                                items(movies.itemCount) { index ->
                                    // In a real scenario, use a different list or range
                                    val reverseIndex = (movies.itemCount - 1 - index).coerceAtLeast(0)
                                    movies[reverseIndex]?.let { movie ->
                                        MovieItem(movie = movie, onClick = { onMovieClick(movie.cloudKey) })
                                    }
                                }
                            }
                        }
                    }
                    
                     // More content can be added here
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = Color.White,
        modifier = Modifier
            .padding(start = 16.dp, top = 24.dp, bottom = 12.dp)
    )
}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    GlassCard(
        modifier = Modifier
            .size(140.dp, 220.dp)
            .clickable { onClick() },
        cornerRadius = 16.dp
    ) {
        AsyncImage(
            model = movie.posterUrl,
            contentDescription = movie.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

