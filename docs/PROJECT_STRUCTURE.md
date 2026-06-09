# Project Structure

## Module: `:app`

The project is currently a single-module Android application. The source code is organized as follows:

### `com.example.prepify`

#### `data/`
- **Purpose**: Implementation of data fetching and persistence.
- **Responsibility**: Fetching data from APIs, databases, or preferences.
- **What belongs here**: Repositories implementations, API services, DAOs, DTOs, Mappers.
- **What never belongs here**: UI logic, ViewModels, Compose code.

#### `domain/`
- **Purpose**: Pure business logic (Platform independent).
- **Responsibility**: Defining "what" the app does.
- **What belongs here**: Domain models, Use Cases, Repository Interfaces.
- **What never belongs here**: Android Framework dependencies (Context, etc.), Data implementations.

#### `presentation/`
- **Purpose**: UI and User Interaction management.
- **Responsibility**: Displaying data and handling user input.
- **What belongs here**: Screens (Composables), ViewModels, UI State, Navigation logic.
- **What never belongs here**: Direct API calls, Database queries.

#### `presentation/navigation/`
- **Purpose**: Navigation architecture.
- **Responsibility**: Defining routes and managing screen transitions.
- **What belongs here**: `AppNavigation`, `AppDestination` (Routes), `NavigationManager`.

#### `ui/theme/`
- **Purpose**: Design System implementation.
- **Responsibility**: Centralized management of visual styles.
- **What belongs here**: Color definitions, Typography, Dimensions, Shapes, Motion, Adaptive UI logic.

#### `ui/components/`
- **Purpose**: Reusable UI components.
- **Responsibility**: Providing atomic and molecular UI elements used across screens.
