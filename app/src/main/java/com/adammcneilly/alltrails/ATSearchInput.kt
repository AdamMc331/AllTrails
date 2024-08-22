package com.adammcneilly.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.alltrails.theme.AllTrailsTheme

/**
 * This is implemented as a [SearchBar] for now to get
 * as close as possible to the existing UI. However,
 * if we decide to animate the text similar to AllTrails, we will probably
 * need to replace this with a custom component that gives us
 * control over the query content (as opposed to this which just consumes
 * a string).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ATSearchInput(modifier: Modifier = Modifier) {
    SearchBar(
        query = "Find trails",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = null,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = CircleShape,
                    ).padding(6.dp),
            )
        },
        modifier = modifier,
    ) {
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
private fun ATSearchInputPreview() {
    AllTrailsTheme {
        ATSearchInput(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )
    }
}
