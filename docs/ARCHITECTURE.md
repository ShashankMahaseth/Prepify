# Architecture Documentation

## Overview
Prepify follows a **Clean Architecture** approach combined with **MVI (Model-View-Intent)** or **MVVM (Model-View-ViewModel)** principles, optimized for **Jetpack Compose**.

## Layers

### 1. Presentation Layer (`presentation/`)
- **UI (Compose)**: Stateless composables that observe state and emit events.
- **ViewModels**: Manage UI state and handle user interactions.
- **State**: Immutable data classes representing the UI at any given time.
- **Navigation**: Managed via **Navigation 3**, providing type-safe routing.

### 2. Domain Layer (`domain/`)
- **Models**: Pure Kotlin data classes representing business entities.
- **Use Cases**: Encapsulate specific business logic and interact with repositories.
- **Repository Interfaces**: Define contracts for data access.

### 3. Data Layer (`data/`)
- **Repositories**: Implementations of domain repository interfaces.
- **Data Sources**: Remote (Retrofit/Ktor) and Local (Room/DataStore).
- **Mappers**: Convert data models (DTOs) to domain models.

## Data Flow
1. **User Interaction**: UI emits an event.
2. **ViewModel**: Receives the event, interacts with Use Case.
3. **Use Case**: Executes business logic, calls Repository.
4. **Repository**: Fetches data from Remote or Local sources.
5. **State Update**: Data flows back to ViewModel, which updates the UI State.
6. **UI Rendering**: Compose observes the state and re-composes the UI.

## Theme & Design System Flow
- **AppTheme**: A singleton object providing access to custom design tokens.
- **PrepifyTheme**: The main theme wrapper using `CompositionLocalProvider` to inject `AppColors`, `AppTypography`, `AppDimensions`, etc.
- **Material 3**: Integrated as the base system, augmented by custom tokens.

## Navigation Flow
- **Navigation 3**: Experimental type-safe navigation using `NavKey` and `rememberNavBackStack`.
- **Routes**: Defined as `@Serializable` objects.
- **Backstack**: Managed manually using `backStack.add()`, `backStack.clear()`, etc.
