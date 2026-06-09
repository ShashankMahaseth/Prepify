# Adaptive UI Guide

Prepify is designed to be responsive across different form factors (Phone, Tablet, Foldable).

## Window Size Classes
We use a custom `AppWindowSizeClass` to track screen dimensions.

### Width Classes
- **Compact**: < 600dp (Standard Phones)
- **Medium**: 600dp - 840dp (Small Tablets, Unfolded Foldables)
- **Expanded**: > 840dp (Large Tablets, Desktop)

### Height Classes
- **Compact**: < 480dp
- **Medium**: 480dp - 900dp
- **Expanded**: > 900dp

## Usage
Access the current size class via `AppTheme`:

```kotlin
val sizeClass = AppTheme.windowSizeClass

if (sizeClass.widthSizeClass == WindowSize.Expanded) {
    // Show Side Navigation Rail
} else {
    // Show Bottom Navigation Bar
}
```

## Best Practices
1. **Adaptive Layouts**: Use `when(sizeClass.widthSizeClass)` to swap top-level layouts.
2. **Responsive Components**: Components should be flexible. Use `Modifier.fillMaxWidth()` and avoid fixed widths.
3. **Previews**: Always provide previews for different screen sizes.
   ```kotlin
   @Preview(device = Devices.PIXEL_4)
   @Preview(device = Devices.TABLET)
   annotation class AdaptivePreviews
   ```
