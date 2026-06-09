# UI Development Guide

Follow this workflow when building a new screen in Prepify.

## Workflow

### 1. Define the Route
Add a new `NavKey` in `presentation/navigation/AppDestination.kt`.

### 2. Create the UI State
Define an immutable data class for the screen's state.
```kotlin
data class HomeUiState(
    val items: List<Item> = emptyList(),
    val isLoading: Boolean = false
)
```

### 3. Create the ViewModel
Implement a ViewModel that exposes the state.
```kotlin
class HomeViewModel(
    private val repository: MyRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()
    
    fun onEvent(event: HomeEvent) { ... }
}
```

### 4. Create the Screen Composable
Create a stateless composable in `presentation/screens/`.
```kotlin
@Composable
fun HomeScreen(
    state: HomeUiState,
    onEvent: (HomeEvent) -> Unit
) {
    Scaffold(...) {
        // Content
    }
}
```

### 5. Register in Navigation
Add the entry to `AppNavigation.kt`.

### 6. Add Previews
Provide previews for Light, Dark, and different screen sizes.

## Component Selection
- Use `Scaffold` for top-level screen structure.
- Use `AppTheme.dimensions` for all padding and spacing.
- Use `AppTheme.colors` for all colors.
- Use `AppTheme.typography` for all text styles.
