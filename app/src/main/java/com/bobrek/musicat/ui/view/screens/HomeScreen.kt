package com.bobrek.musicat.ui.view.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bobrek.musicat.domain.SpotifyPlayer
import com.bobrek.musicat.domain.model.Playlist
import com.bobrek.musicat.ui.view.components.DisplayItem

@Composable
fun HomeScreen(
    list: List<Playlist>?
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        list?.forEach {
            item {
                DisplayItem(
                    image = it.images?.get(0)?.url.toString(),
                    title = it.name,
                    user = it.owner.display_name.toString(),
                    ) {
                    SpotifyPlayer.play(it.uri)
                }
            }
        }
    }
}
