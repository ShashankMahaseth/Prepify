# Design System Guide

Prepify uses a custom Design System built on top of Material Design 3.

## Core Tokens

### Colors (`AppColors`)
We use semantic color naming to ensure consistency across Light and Dark themes.
- **Success/Warning/Info**: Standard feedback colors.
- **Divider/Skeleton/Shimmer**: UI utility colors.

**Usage:**
```kotlin
val backgroundColor = AppTheme.colors.success
```

### Typography (`AppTypography`)
Custom typography scales beyond standard Material 3.
- **Headings**: H1 through H6.
- **Body**: Small, Medium, Large.
- **Display/Label**: For specific UI elements.

**Usage:**
```kotlin
Text(text = "Hello", style = AppTheme.typography.h1)
```

### Dimensions (`AppDimensions`)
Centralized spacing and sizing tokens.
- **Spacing**: `extraSmall` (4dp), `small` (8dp), `medium` (16dp), `large` (24dp), `extraLarge` (32dp).
- **Component Specific**: `buttonHeight`, `appBarHeight`.

**Usage:**
```kotlin
Modifier.padding(AppTheme.dimensions.medium)
```

### Shapes (`AppShapes`)
Consistent corner rounding.
- `small`, `medium`, `large`, `extraLarge`.

### Elevation (`AppElevation`)
Shadow and Z-index management.
- `level0` to `level5`.

### Motion (`AppMotion`)
Standardized animation durations and easings.

## Components
(List of custom components will be added here as they are developed)
- `PrepifyButton`
- `PrepifyTextField`
- `PrepifyCard`

## Best Practices
1. **Never use hardcoded values** (e.g., `16.dp` or `Color.White`). Always use `AppTheme`.
2. **Use Semantic Colors**: Prefer `AppTheme.colors.onSurface` over a specific gray shade.
3. **Respect Adaptive UI**: Use `AppTheme.dimensions` which can adjust based on screen size.
