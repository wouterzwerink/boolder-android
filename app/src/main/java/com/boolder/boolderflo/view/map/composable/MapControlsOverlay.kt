package com.boolder.boolderflo.view.map.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.boolder.boolderflo.R
import com.boolder.boolderflo.domain.model.ALL_GRADES
import com.boolder.boolderflo.domain.model.CircuitColor
import com.boolder.boolderflo.utils.extension.composeColor
import com.boolder.boolderflo.utils.previewgenerator.dummyArea
import com.boolder.boolderflo.view.compose.BoolderTheme
import com.boolder.boolderflo.view.map.MapViewModel
import com.boolder.boolderflo.view.map.filter.DummyFiltersEventHandler
import com.boolder.boolderflo.view.map.filter.FiltersEventHandler
import com.boolder.boolderflo.view.offlinephotos.model.OfflineAreaItem
import com.boolder.boolderflo.view.offlinephotos.model.OfflineAreaItemStatus

@Composable
fun MapControlsOverlay(
    offlineAreaItem: OfflineAreaItem?,
    circuitState: MapViewModel.CircuitState?,
    gradeState: MapViewModel.GradeState,
    fState: MapViewModel.FFilterState,
    popularState: MapViewModel.PopularFilterState,
    projectsState: MapViewModel.ProjectsFilterState,
    tickedState: MapViewModel.TickedFilterState,
    shouldShowFiltersBar: Boolean,
    filtersEventHandler: FiltersEventHandler,
    onHideAreaName: () -> Unit,
    onAreaInfoClicked: () -> Unit,
    onSearchBarClicked: () -> Unit,
    onCircuitStartClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.systemBarsPadding()
    ) {
        MapHeaderLayout(
            offlineAreaItem = offlineAreaItem,
            circuitState = circuitState,
            gradeState = gradeState,
            fState = fState,
            popularState = popularState,
            projectsState = projectsState,
            tickedState = tickedState,
            shouldShowFiltersBar = shouldShowFiltersBar,
            filtersEventHandler = filtersEventHandler,
            onHideAreaName = onHideAreaName,
            onAreaInfoClicked = onAreaInfoClicked,
            onSearchBarClicked = onSearchBarClicked
        )

        Spacer(modifier = Modifier.weight(1f))

        if (circuitState?.showCircuitStartButton == true) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp),
                colors = ButtonDefaults.elevatedButtonColors(),
                onClick = onCircuitStartClicked
            ) {
                Text(
                    text = stringResource(id = R.string.circuit_start),
                    style = MaterialTheme.typography.labelLarge,
                    color = when (val circuitColor = circuitState.color) {
                        CircuitColor.WHITE,
                        CircuitColor.BLACK -> MaterialTheme.colorScheme.onSurface
                        else -> circuitColor.composeColor()
                    }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun MapControlsOverlayPreview() {
    BoolderTheme {
        MapControlsOverlay(
            offlineAreaItem = OfflineAreaItem(
                area = dummyArea(),
                status = OfflineAreaItemStatus.NotDownloaded
            ),
            circuitState = MapViewModel.CircuitState(
                circuitId = 0,
                color = CircuitColor.ORANGE,
                showCircuitStartButton = true
            ),
            gradeState = MapViewModel.GradeState(
                gradeRangeButtonTitle = stringResource(id = R.string.grade),
                grades = ALL_GRADES
            ),
            fState = MapViewModel.FFilterState(problemIds = emptyList()),
            popularState = MapViewModel.PopularFilterState(isEnabled = false),
            projectsState = MapViewModel.ProjectsFilterState(projectIds = emptyList()),
            tickedState = MapViewModel.TickedFilterState(tickedProblemIds = emptyList()),
            shouldShowFiltersBar = true,
            filtersEventHandler = DummyFiltersEventHandler,
            onHideAreaName = {},
            onAreaInfoClicked = {},
            onSearchBarClicked = {},
            onCircuitStartClicked = {}
        )
    }
}
