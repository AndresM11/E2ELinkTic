# OrangeHRM E2E — Automatización de flujo de empleado

Prueba automatizada E2E sobre [OrangeHRM demo](https://opensource-demo.orangehrmlive.com/)
usando Selenium WebDriver + TestNG + Allure Report con patrón Page Object y capa de Actions.

## Flujo cubierto

1. Autenticación con credenciales de administrador
2. Ingreso al módulo PIM
3. Creación de un nuevo empleado (nombre y apellido)
4. Carga de foto de perfil desde una URL pública
5. Navegación al módulo Directory
6. Búsqueda del empleado por nombre
7. Validación de que el empleado aparece en los resultados

## Prerrequisitos

- Java 17
- Maven 3.8+
- Google Chrome instalado
- Conexión a internet

## Instalación

    git clone <url-del-repositorio>
    cd orangehrm-e2e
    mvn dependency:resolve

## Ejecución

    mvn test

## Generación del reporte Allure

Abrir el reporte en el navegador:

    mvn allure:serve

Generar el reporte estático en `target/site/allure-maven-plugin/`:

    mvn allure:report

## Captura de pantalla en fallo

Cuando un test falla, `ScreenshotListener` adjunta automáticamente una captura de pantalla
al reporte Allure, visible en la sección "Attachments" de cada test fallido.

## Estructura del proyecto

    src/test/java/com/orangehrm/
    ├── config/       DriverManager, BaseTest
    ├── pages/        LoginPage, DashboardPage, PimPage, EmployeeDetailsPage, DirectoryPage
    ├── actions/      LoginActions, PimActions, DirectoryActions
    ├── listeners/    ScreenshotListener
    ├── utils/        ImageDownloader
    └── tests/        OrangeHrmE2ETest

## Tecnologías

| Herramienta        | Versión  | Rol                                       |
|--------------------|----------|-------------------------------------------|
| Selenium WebDriver | 4.18.1   | Automatización del navegador              |
| WebDriverManager   | 5.8.0    | Gestión automática de ChromeDriver        |
| TestNG             | 7.9.0    | Runner de pruebas y listeners             |
| Allure TestNG      | 2.25.0   | Reporte con pasos y capturas de pantalla  |
| AspectJ            | 1.9.21   | Procesamiento de anotaciones @Step        |
| Java               | 17       | Lenguaje de implementación                |
| Maven              | 3.8+     | Gestión del proyecto y dependencias       |