# Navigation Guide (Navigation 3)

Prepify uses the experimental **Navigation 3** library for type-safe navigation.

## Navigation Architecture
Navigation is centralized in `AppNavigation.kt`. It uses a `backStack` based on a list of `NavKey` objects.

## Defining Routes
Routes are defined in `AppDestination.kt` as `@Serializable` objects or data classes.

```kotlin
@Serializable
object SplashScreen : NavKey

@Serializable
data class DetailsScreen(val id: String) : NavKey
```

## How To Create a New Screen
1. **Define the Route**: Add an `@Serializable` object to `AppDestination.kt`.
2. **Create the Composable**: Create your screen in `presentation/screens/`.
3. **Register in AppNavigation**:
   ```kotlin
   entry<MyNewScreen> {
       MyNewScreen()
   }
   ```

## How To Navigate
Navigation is handled by manipulating the `backStack`.

### Standard Navigation
```kotlin
backStack.add(MyNewScreen)
```

### Replace/Clear Stack
```kotlin
backStack.clear()
backStack.add(HomeScreen)
```

## Passing Data
Since routes are `@Serializable`, you can pass data classes directly.

```kotlin
// Definition
@Serializable
data class Profile(val userId: String) : NavKey

// Navigation
backStack.add(Profile(userId = "123"))

// Receiving
entry<Profile> { profile ->
    ProfileScreen(userId = profile.userId)
}
```

## Navigation Rules
- **DO** keep routes simple and serializable.
- **DO** handle navigation events in the `AppNavigation` layer to keep screens stateless.
- **DON'T** pass large objects between screens; pass IDs and fetch data in the ViewModel.
- **DON'T** use `NavController` (deprecated/old pattern for this project).
