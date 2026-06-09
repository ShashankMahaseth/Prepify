# Coding Standards

## Naming Conventions

### Classes & Files
- **Screens**: `[Name]Screen.kt` (e.g., `LoginScreen.kt`)
- **ViewModels**: `[Name]ViewModel.kt` (e.g., `LoginViewModel.kt`)
- **UI State**: `[Name]UiState.kt` (e.g., `LoginUiState.kt`)
- **Navigation Routes**: `[Name]Destination` or simply `[Name]` (e.g., `Home`)

### Functions
- **Composables**: PascalCase (e.g., `PrimaryButton()`)
- **Events/Callbacks**: `on[Action]` (e.g., `onLoginClick()`)

## Jetpack Compose Standards
- **Statelessness**: Screens should be as stateless as possible. Hoist state to the ViewModel.
- **Modifiers**: The first parameter of a composable should be `modifier: Modifier = Modifier`.
- **Preview Parameters**: Use `PreviewParameterProvider` for complex states in previews.

## Architecture Rules
- No UI logic in ViewModels.
- No Android dependencies in Use Cases or Domain models.
- All network and database models (DTOs) must be mapped to Domain models.

## Kotlin Standards
- Prefer `val` over `var`.
- Use `Flow` for reactive data streams.
- Use `Result` or custom sealed classes for error handling.
