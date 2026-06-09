# Theme Guide

## The `AppTheme` Object
The `AppTheme` object is the entry point for all design tokens.

```kotlin
MaterialTheme.colorScheme.primary // Material 3 Standard
AppTheme.colors.success           // Prepify Custom
AppTheme.dimensions.medium        // Prepify Custom
```

## Dark & Light Theme
The theme automatically switches based on system settings.

### Implementation Details
- `LightAppColors` and `DarkAppColors` define the custom semantic palette.
- `LightColorScheme` and `DarkColorScheme` define the standard Material 3 palette.

### Dynamic Color
On Android 12+ (API 31+), the app supports Dynamic Color (Material You). This can be toggled in `PrepifyTheme`.

## Best Practices

| Action | DO | DON'T |
| :--- | :--- | :--- |
| **Colors** | `AppTheme.colors.background` | `Color.White` |
| **Spacing** | `AppTheme.dimensions.medium` | `16.dp` |
| **Typography** | `AppTheme.typography.bodyLarge` | `fontSize = 18.sp` |

## Theme Switching
The `PrepifyTheme` composable handles the logic:
```kotlin
PrepifyTheme(darkTheme = true) {
    // Content
}
```
Use `isSystemInDarkTheme()` by default.
