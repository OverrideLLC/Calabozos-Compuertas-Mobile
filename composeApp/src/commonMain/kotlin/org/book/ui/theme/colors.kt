package org.book.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// --- Nuevos Colores Base ---
val NewPrimaryRed = Color(0xFFE7152D)      // Rojo como Primario
val NewSecondaryOrange = Color(0xFFE78515) // Naranja como Secundario

// --- Colores Existentes (Terciario, Fondo, Error) ---
// Manteniendo los colores de tu archivo original
val CustomBackground = Color(0xFFf3efd3)     // Beige Claro/Crema
val CustomTertiary = Color(0xFF265d8f)       // Azul Oscuro
val CustomError =
    Color(0xFFBA1A1A)          // Rojo estándar de Material para Error (ligeramente diferente al primario)

// --- Colores "On" (Texto/Iconos sobre los colores base) ---
val OnNewPrimaryRed = Color.White            // Texto blanco sobre rojo primario
val OnNewSecondaryOrange = Color.White       // Texto blanco sobre naranja secundario
val OnCustomTertiary = Color.White           // Texto blanco sobre azul oscuro (existente)
val OnCustomBackground = Color(0xff2f2e2f)   // Texto gris oscuro sobre beige claro (existente)
val OnCustomError = Color.White              // Texto blanco sobre rojo de error

// --- Colores Contenedores (Versiones claras/oscuras de los base) ---

// - Contenedores Claros (Light Theme) -
val PrimaryContainerLight = Color(0xFFFFDAD8) // Rojo/rosa muy claro
val OnPrimaryContainerLight =
    Color(0xFF410006) // Rojo muy oscuro (para texto sobre contenedor primario claro)

val SecondaryContainerLight = Color(0xFFFFDCC1) // Naranja claro
val OnSecondaryContainerLight =
    Color(0xFF2F1500) // Marrón oscuro (para texto sobre contenedor secundario claro)

val TertiaryContainerLight = Color(0xFFA8CCE8) // Azul medio-claro (existente)
val OnTertiaryContainerLight =
    Color(0xFF001D35) // Texto azul oscuro sobre contenedor azul claro (existente)

val ErrorContainerLight = Color(0xFFFFDAD6)    // Contenedor de error rojo claro estándar
val OnErrorContainerLight = Color(0xFF410002)  // Texto sobre contenedor de error claro

// - Colores de Superficie (Light Theme) -
val SurfaceLight = CustomBackground          // Superficie principal es tu fondo beige
val OnSurfaceLight = OnCustomBackground      // Texto sobre superficie
val SurfaceVariantLight = Color(0xFFE7E3C6)  // Variante beige ligeramente más oscura (existente)
val OnSurfaceVariantLight =
    Color(0xFF49454F) // Texto gris oscuro sobre variante de superficie (existente)
val OutlineLight = Color(0xFF7A796D)         // Contorno grisáceo (derivado del oliva original)
val OutlineVariantLight = Color(0xFFC8C7B7)  // Contorno más claro (ajustado desde oliva)

// - Colores Inversos (Light Theme) -
val InverseSurfaceLight = Color(0xFF313033)  // Superficie inversa oscura (existente)
val InverseOnSurfaceLight = Color(0xFFF4EFF4) // Texto claro sobre superficie inversa (existente)
val InversePrimaryLight = Color(0xFFFFB3AE)  // Rojo claro como primario inverso

// --- Colores Tema Oscuro (Dark Theme) ---

// - Bases Oscuros -
val PrimaryDark = Color(0xFFFFB3AE)          // Rojo claro como primario oscuro
val OnPrimaryDark = Color(0xFF68000F)        // Rojo muy oscuro para texto sobre primario oscuro

val SecondaryDark = Color(0xFFFFB77C)        // Naranja claro como secundario oscuro
val OnSecondaryDark =
    Color(0xFF4D2600)      // Marrón/naranja oscuro para texto sobre secundario oscuro

val TertiaryDark = Color(0xFF89B1D1)        // Azul ligeramente más claro (existente)
val OnTertiaryDark = Color(0xFF003355)      // Texto azul oscuro (existente)

val BackgroundDark = Color(0xFF1C1B1F)        // Fondo oscuro estándar (existente)
val OnBackgroundDark = Color(0xFFE6E1E5)      // Texto claro sobre fondo oscuro (existente)

val ErrorDark = Color(0xFFFFB4AB)            // Error rojo claro estándar para tema oscuro
val OnErrorDark = Color(0xFF690005)          // Texto sobre error oscuro

// - Contenedores Oscuros -
val PrimaryContainerDark = Color(0xFFAD332A)    // Rojo oscuro
val OnPrimaryContainerDark =
    Color(0xFFFFDAD8) // Rojo/rosa claro (para texto sobre contenedor primario oscuro)

val SecondaryContainerDark = Color(0xFF6E3900) // Naranja oscuro
val OnSecondaryContainerDark =
    Color(0xFFFFDCC1) // Naranja claro (para texto sobre contenedor secundario oscuro)

val TertiaryContainerDark = Color(0xFF004A78) // Contenedor azul oscuro (existente)
val OnTertiaryContainerDark =
    Color(0xFFA8CCE8) // Texto azul claro sobre contenedor oscuro (existente)

val ErrorContainerDark = Color(0xFF93000A)    // Contenedor de error rojo oscuro estándar
val OnErrorContainerDark = Color(0xFFFFDAD6) // Texto sobre contenedor de error oscuro

// - Superficies Oscuras -
val SurfaceDark = BackgroundDark             // Superficie oscura es el fondo oscuro (existente)
val OnSurfaceDark = OnBackgroundDark         // Texto claro sobre superficie oscura (existente)
val SurfaceVariantDark = Color(0xFF49454F)  // Variante de superficie gris oscuro (existente)
val OnSurfaceVariantDark = Color(0xFFCAC4D0) // Texto gris claro sobre variante oscura (existente)
val OutlineDark = Color(0xFF93909A)         // Contorno gris medio (existente)
val OutlineVariantDark = Color(0xFF49454F)  // Variante de contorno gris oscuro (existente)

// - Inversos Oscuros -
val InverseSurfaceDark = OnBackgroundDark    // Superficie inversa clara (existente)
val InverseOnSurfaceDark = BackgroundDark    // Texto oscuro sobre superficie inversa (existente)
val InversePrimaryDark = NewPrimaryRed       // Rojo original como primario inverso

// --- Esquemas de Color Material ---

val LightColorScheme = lightColorScheme(
    primary = NewPrimaryRed,
    onPrimary = OnNewPrimaryRed,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = NewSecondaryOrange,
    onSecondary = OnNewSecondaryOrange,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    tertiary = CustomTertiary, // Mantenido
    onTertiary = OnCustomTertiary, // Mantenido
    tertiaryContainer = TertiaryContainerLight, // Mantenido
    onTertiaryContainer = OnTertiaryContainerLight, // Mantenido
    error = CustomError, // Mantenido
    onError = OnCustomError, // Mantenido
    errorContainer = ErrorContainerLight, // Mantenido
    onErrorContainer = OnErrorContainerLight, // Mantenido
    background = CustomBackground, // Mantenido
    onBackground = OnCustomBackground, // Mantenido
    surface = SurfaceLight, // Mantenido
    onSurface = OnSurfaceLight, // Mantenido
    surfaceVariant = SurfaceVariantLight, // Mantenido
    onSurfaceVariant = OnSurfaceVariantLight, // Mantenido
    outline = OutlineLight, // Mantenido/Ajustado
    outlineVariant = OutlineVariantLight, // Ajustado
    scrim = Color(0x61000000), // Scrim oscuro semi-transparente
    inverseSurface = InverseSurfaceLight, // Mantenido
    inverseOnSurface = InverseOnSurfaceLight, // Mantenido
    inversePrimary = InversePrimaryLight,
    surfaceTint = NewPrimaryRed // Tinte de superficie usualmente es el primario
)

val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    tertiary = TertiaryDark, // Mantenido
    onTertiary = OnTertiaryDark, // Mantenido
    tertiaryContainer = TertiaryContainerDark, // Mantenido
    onTertiaryContainer = OnTertiaryContainerDark, // Mantenido
    error = ErrorDark, // Mantenido
    onError = OnErrorDark, // Mantenido
    errorContainer = ErrorContainerDark, // Mantenido
    onErrorContainer = OnErrorContainerDark, // Mantenido
    background = BackgroundDark, // Mantenido
    onBackground = OnBackgroundDark, // Mantenido
    surface = SurfaceDark, // Mantenido
    onSurface = OnSurfaceDark, // Mantenido
    surfaceVariant = SurfaceVariantDark, // Mantenido
    onSurfaceVariant = OnSurfaceVariantDark, // Mantenido
    outline = OutlineDark, // Mantenido
    outlineVariant = OutlineVariantDark, // Mantenido
    scrim = Color(0x61000000), // Scrim oscuro semi-transparente
    inverseSurface = InverseSurfaceDark, // Mantenido
    inverseOnSurface = InverseOnSurfaceDark, // Mantenido
    inversePrimary = InversePrimaryDark,
    surfaceTint = PrimaryDark // Tinte de superficie usualmente es el primario oscuro
)
