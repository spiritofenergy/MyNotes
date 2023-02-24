package com.kodex.mynotes.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kodex.mynotes.domain.model.DataDummy

@Composable
fun InstagramHomeContent() {
    Column {
        InstagramStories()
        Divider()
        InstagramPostsList()
    }
}

@Composable
fun InstagramPostsList() {
    val posts = remember { DataDummy.storyList.filter { it.storyImageId != 0 } }
    Log.d("check", "nstagramPostsList: $posts")
    LazyColumn {
        items(
            items = posts,
            itemContent = {
                InstagramListItem(post = it)
            })
    }
}
