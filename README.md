# ⚙️ Configuración para poder usar la AI
***Aclaración.*** *Actualmente el repositorio ya tiene todo configurado, excepto el token.*
### 🛠️Generar token de github
El token de GitHub es **personal** (¡no lo compartas ni lo subas a ningún lugar!). Puedes generarlo desde:
🔗[https://github.com/settings/tokens](https://github.com/settings/tokens)
Al momento de crearlo, debes configurarlo con el siguiente permiso:

`models -> read-only`

### 🔐Configuración del token
Para poder usar el token, debes agregarlo a tus variables de entorno. Puedes hacerlo desde la terminal según el entorno:

> **cmd.exe**
`set AZURE_KEY=pon-tu-token-aqui`

>**PowerShell**
`$env:AZURE_KEY=pon-tu-token-aqui`

>**bash (Linux/macOS)**
`export AZURE_KEY=pon-tu-token-aqui`


### 🧠 **Si estás trabajando desde IntelliJ:**

1.  Ve a **Run → Edit Configurations...**
2.  Haz clic en **Modify Options → Environment Variables**
3.  En el recuadro _Environment Variables_, agrega:  
    `AZURE_KEY=pon-tu-token-aqui`

### 📦 Configuración de las dependencias en `pom.xml`
Además de las dependencias comunes, agrega las siguientes:
```xml
<dependency>  
	<groupId>org.springframework.boot</groupId>  
	<artifactId>spring-boot-starter-web</artifactId>  
</dependency>  
  
<dependency>  
	<groupId>com.azure</groupId>  
	<artifactId>azure-ai-inference</artifactId>  
	<version>1.0.0-beta.4</version>  
</dependency>
```
Después, sincroniza el archivo `pom.xml` y realiza un **rebuild** del proyecto.

### 🚀Probar el código
Si configuraste correctamente la variable de entorno en IntelliJ, ya deberías poder correr el proyecto.  
Aquí tienes un ejemplo para probarlo desde **Postman**:
>Se usa el método `POST` con `body` tipo `JSON`, hacia la siguiente URL:  
`http://localhost:8080/api/chat`

```json
{
	 "model": "openai/gpt-4.1-nano",
	 "prompt": "¿Qué es una estrella?"
}
```
