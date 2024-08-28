package com.adammcneilly.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.alltrails.theme.AllTrailsTheme

@Composable
fun ATContent(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                ).fillMaxSize(),
        ) {
            ATSearchInput(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                    ).fillMaxWidth(),
            )

            FilterButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
            )

            TrailList(
                modifier = Modifier
                    .weight(1F),
            )

            ATBottomBar()
        }
    }
}

@Composable
private fun TrailList(modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 0.dp,
            end = 16.dp,
            bottom = 16.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth(),
    ) {
        items(4) { index ->
            if (index == 2) {
                TrailGroupListItem()
            } else {
                TrailListItem()
            }
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ATContentPreview() {
    AllTrailsTheme {
        ATContent()
    }
}
