# Best Practices

## Design System & UI

### 1. Avoid Hardcoded Values
**Bad:**
```kotlin
Modifier.padding(16.dp)
Color(0xFFFFFFFF)
```
**Good:**
```kotlin
Modifier.padding(AppTheme.dimensions.medium)
AppTheme.colors.background
```

### 2. State Management
- Use `StateFlow` in ViewModels.
- Collect state in UI using `collectAsStateWithLifecycle()`.

### 3. Performance
- Use `remember` and `derivedStateOf` to optimize recompositions.
- Keep composable functions small and focused.

## Navigation

### 1. Type-Safety
Always use `@Serializable` objects for Navigation 3 routes. Avoid passing raw strings for IDs if they can be typed.

### 2. Side Effects
Handle navigation as a side effect (callback) from your screens, never directly inside the ViewModel.

## Architecture

### 1. Dependency Inversion
Always depend on interfaces (Repositories), not implementations. Use a DI framework (to be implemented) to provide instances.

### 2. Single Source of Truth
The Data layer should be the single source of truth. ViewModels should not keep separate caches of data.
