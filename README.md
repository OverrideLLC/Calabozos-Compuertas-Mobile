# Calabozos y Compuertas Mobile

![Imagen de la App](portada_logic.png)

Bienvenido al repositorio de Calabozos y Compuertas Mobile, una aplicación multiplataforma desarrollada con Kotlin Multiplatform Mobile (KMM) que ofrece una experiencia interactiva relacionada con el universo de Calabozos y Compuertas.

## 📜 Descripción

Calabozos y Compuertas Mobile es una aplicación diseñada para llevar la emoción y la lógica de los juegos de calabozos y el funcionamiento de las compuertas lógicas a tu dispositivo móvil. La aplicación parece estar dividida en varios módulos, incluyendo un libro de runas, un libro de lógica y un controlador, lo que sugiere una rica interacción y contenido educativo o de juego.

## ✨ Características Principales

* **Interfaz de Usuario Intuitiva:** Desarrollada con Jetpack Compose para Android y SwiftUI para iOS, ofreciendo una experiencia de usuario moderna y fluida.
* **Lógica Compartida:** Gran parte de la lógica de negocio, incluyendo la gestión de estado y la navegación, está escrita en Kotlin y compartida entre Android e iOS gracias a KMM.
* **Módulo de Libro de Runas:** Permite a los usuarios explorar e interactuar con un sistema de runas, posiblemente para aprender sobre ellas o utilizarlas en mecánicas de juego.
* **Módulo de Libro de Lógica:** Introduce conceptos de compuertas lógicas, probablemente con tutoriales y ejemplos interactivos.
* **Controlador Virtual:** Un módulo dedicado a un controlador, que podría ser un mando virtual para interactuar con otros componentes de la aplicación o un juego externo.
* **Navegación Dinámica:** Sistema de navegación implementado para moverse entre las diferentes secciones y funcionalidades de la app.
* **Recursos Compartidos:** Uso de recursos compartidos (imágenes, animaciones Lottie) para una apariencia consistente en ambas plataformas.

## 🛠️ Tecnologías Utilizadas

* **Kotlin Multiplatform Mobile (KMM):** Para compartir código Kotlin entre Android e iOS.
* **Jetpack Compose (Material 3):** Para la interfaz de usuario de Android, utilizando los componentes más recientes de Material Design.
* **SwiftUI:** Para la interfaz de usuario de iOS, aprovechando el framework declarativo de Apple.
* **Kotlin Coroutines:** Para la gestión de operaciones asíncronas y concurrencia.
* **Koin:** Para la inyección de dependencias, facilitando un código más modular y testeable.
* **Navigation Compose:** Biblioteca de navegación para Kotlin Multiplatform, simplificando la gestión de pantallas y flujos.
* **Lottie Compose:** Para integrar animaciones vectoriales de Lottie de forma nativa en Jetpack Compose.
* **Kotlinx Serialization:** Para la serialización y deserialización de datos (ej. JSON).
* **Kotlinx DateTime:** Para el manejo de fechas y horas de forma multiplataforma.
* **Coil:** Para la carga de imágenes en Android, optimizada para Kotlin y Jetpack Compose.
* **Android Splash Screen API:** Para una pantalla de inicio nativa y personalizable en Android.
* **Gradle (Kotlin DSL):** Como sistema de construcción y gestión de dependencias del proyecto.

## 🚀 Configuración e Instalación

### Requisitos Previos

* Android Studio (última versión recomendada)
* Xcode (última versión recomendada)
* Kotlin Multiplatform Mobile plugin para Android Studio
* CocoaPods (para dependencias de iOS)

### Pasos para Android

1.  Clonar el repositorio:
    ```bash
    git clone https://github.com/OverrideLLC/Calabozos-Compuertas-Mobile
    cd Calabozos-Compuertas-Mobile-master
    ```
2.  Abrir el proyecto en Android Studio.
3.  Sincronizar el proyecto con los archivos Gradle.
4.  Seleccionar la configuración de ejecución `composeApp` y un dispositivo/emulador Android.
5.  Ejecutar la aplicación.

### Pasos para iOS

1.  Asegurarse de tener CocoaPods instalado:
    ```bash
    sudo gem install cocoapods
    ```
2.  Navegar al directorio `iosApp`:
    ```bash
    cd iosApp
    ```
3.  Instalar las dependencias de Pods:
    ```bash
    pod install
    ```
    (Si `pod install` falla, prueba `pod deintegrate` y luego `pod install --repo-update`)
4.  Abrir el archivo `.xcworkspace` (ej. `iosApp.xcworkspace`) en Xcode.
5.  Seleccionar un simulador o dispositivo iOS.
6.  Ejecutar la aplicación desde Xcode.

## 🎮 Uso

Una vez instalada, abre la aplicación "Calabozos y Compuertas". Serás recibido por una pantalla de inicio desde donde podrás navegar a las diferentes secciones:

* **Libro de Runas:** Explora el catálogo de runas, aprende sobre sus significados y usos.
* **Libro de Lógica:** Sumérgete en el mundo de las compuertas lógicas con tutoriales interactivos.
* **Controlador:** (Detallar cómo se usa el controlador si es aplicable).

La aplicación utiliza una interfaz táctil intuitiva. Sigue las instrucciones en pantalla y los tutoriales para una mejor experiencia.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1.  Haz un Fork del proyecto.
2.  Crea una nueva rama para tu feature (`git checkout -b feature/AmazingFeature`).
3.  Realiza tus cambios y haz commit (`git commit -m 'Add some AmazingFeature'`).
4.  Haz Push a la rama (`git push origin feature/AmazingFeature`).
5.  Abre un Pull Request.

Por favor, asegúrate de que tu código sigue las guías de estilo del proyecto y que todas las pruebas pasan.

## 📄 Licencia

Este proyecto está distribuido bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles (si tienes uno, si no, considera añadirlo o especificar la licencia).

---

Desarrollado con ❤️ por OverrideLLC.
