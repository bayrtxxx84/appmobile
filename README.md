# Documentación Técnica del Repositorio appmobile

Este documento constituye la guía técnica oficial y referencia de arquitectura para el repositorio **appmobile**, desarrollado por **bayrtxxx84**. Toda la información expuesta se deriva de forma estricta del código fuente y los archivos de configuración existentes en la raíz del repositorio.

---

## 1. Descripción General del Proyecto

El proyecto **appmobile** es una aplicación móvil nativa para la plataforma Android construida en su totalidad (**100%**) con el lenguaje de programación **Kotlin**. La infraestructura de automatización de compilación y gestión de dependencias está basada en **Gradle**, utilizando **Kotlin DSL** (`.gradle.kts`) para una configuración fuertemente tipada.

* **Propietario / Autor:** `bayrtxxx84`
* **Lenguaje Principal:** Kotlin (100% del codebase)
* **Rama Principal:** `main`
* **Tipo de Proyecto:** Aplicación móvil Android con estructura modular estándar.

---

## 2. Diagrama de la Estructura de Carpetas

A continuación se representa el esquema visual de árbol correspondiente a la raíz del repositorio y la distribución de sus directorios y archivos principales:

```
appmobile/
├── .idea/                  # Configuración del entorno de desarrollo (Android Studio / IntelliJ)
├── app/                    # Módulo principal con el código fuente y recursos de la aplicación
├── gradle/                 # Binarios y wrapper para la gestión homogénea de Gradle
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── .gitignore              # Reglas de exclusión para el control de versiones Git
├── build.gradle.kts        # Script de compilación principal a nivel de proyecto (Kotlin DSL)
├── gradle.properties       # Propiedades de configuración global y memoria para Gradle
├── gradlew                 # Script ejecutable de Gradle Wrapper para entornos UNIX/macOS
├── gradlew.bat             # Script ejecutable de Gradle Wrapper para entornos Windows
└── settings.gradle.kts     # Definición de repositorios y módulos incluidos en el proyecto
```

---

## 3. Desglose de Carpetas y Componentes Clave

La arquitectura física del repositorio organiza el código y las herramientas de construcción en carpetas claramente delimitadas:

* **Módulo de Aplicación (`app/`):** Contiene la lógica del negocio, controladores, interfaces de usuario, fuentes Kotlin, recursos de diseño (`res`) y el manifiesto (`AndroidManifest.xml`).
* **Configuración del IDE (`.idea/`):** Almacena las preferencias del espacio de trabajo y esquemas del proyecto adaptados para Android Studio / IntelliJ IDEA.
* **Componente de Wrapper (`gradle/`, `gradlew`, `gradlew.bat`):** Garantiza que cualquier desarrollador o servidor de integración continua (CI) ejecute la compilación utilizando exactamente la misma versión de Gradle prescrita.
* **Scripts de Construcción Kotlin DSL (`build.gradle.kts`, `settings.gradle.kts`):** Proveen verificación de tipos en tiempo de compilación y autocompletado para la declaración de dependencias y plugins.

---

## 4. Lenguajes, Bibliotecas y Sistema de Construcción

El entorno tecnológico del proyecto se consolida bajo los siguientes estándares:

* **Lenguaje de Programación:** Kotlin (100%).
* **Sistema de Construcción:** Gradle con sintaxis Kotlin DSL (`.gradle.kts`).
* **Entorno de Desarrollo Recomendado:** Android Studio o IntelliJ IDEA.
* **Administrador de Dependencias:** Declarado centralizadamente en los scripts de Gradle a nivel de módulo y proyecto.

---

## 5. Arquitectura del Proyecto

El repositorio adopta la estructura modular recomendada para el desarrollo moderno en Android:

1. **Aislamiento del Módulo Principal:** La lógica de negocio y presentación reside dentro de `app/`, separada de la configuración global de la herramienta de construcción.
2. **Gestión Declarativa de la Compilación:** Las propiedades globales del entorno se configuran centralizadamente en `gradle.properties` y `settings.gradle.kts`.

---

## 6. Guía de Compilación y Ejecución

Para compilar y verificar el proyecto desde una línea de comandos, utilice las tareas de Gradle Wrapper:

### En sistemas Linux / macOS:
```bash
./gradlew build
```

### En sistemas Microsoft Windows:
```cmd
gradlew.bat build
```

### Generación del paquete instalador de depuración (APK):
```bash
./gradlew assembleDebug
```
