# Component Guide

This guide documents the reusable components available in the Prepify Design System.

## Atomic Components

### Buttons
- `PrepifyButton`: Main action button.
- `PrepifyOutlinedButton`: Secondary action button.
- `PrepifyTextButton`: Tertiary actions.

### Input Fields
- `PrepifyTextField`: Standard text input with validation support.
- `PrepifySearchField`: Optimized for search.

### Feedback
- `PrepifyLoadingSpinner`: Standard circular progress.
- `PrepifyErrorState`: Full-screen or component-level error display.

## Best Practices
- **Do not create one-off components** for margins or padding. Use `Spacer` with `AppTheme.dimensions`.
- **Component Hoisting**: Components should be stateless and take lambda callbacks for events.
