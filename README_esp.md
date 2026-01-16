Actúa como un redactor técnico experto en documentación de software. Necesito que escribas un README completo para mi proyecto. Usa un tono claro y profesional.
📌 Descripción completa del proyecto ANDR-TECH-HOUSE
1) Resumen general del proyecto
ANDR-TECH-HOUSE es una aplicación web de e‑commerce que permite explorar un catálogo de productos, ver detalles, administrar un carrito de compras y completar pedidos con un flujo de pago y confirmación. Incluye autenticación de usuarios, historial de pedidos, y un módulo de administración para crear/editar productos y dar de alta nuevos administradores. El frontend es una SPA en React con rutas protegidas por rol, y el backend está preparado en Spring Boot con soporte para seguridad, JWT y persistencia en base de datos relacional. 

2) Arquitectura y módulos principales
🔹 Frontend (React + Vite)
SPA con React Router, usando BrowserRouter y rutas públicas/admin. 

Contextos globales para autenticación, productos y carrito. 

Conexión al backend mediante VITE_API_URL configurado en .env.

🔹 Backend (Spring Boot)
Proyecto Spring Boot 3.x con Java 17, preparado para web, JPA, seguridad, validación y JWT. 

Configuración de datasource y JWT por variables de entorno. 

Ajuste dinámico de puerto desde PORT (pensado para despliegue). 

3) Funcionalidades principales (Frontend)
🛍 Catálogo y productos
Listado de productos con imagen, nombre y precio; soporte para nombres alternativos (nombre o nombreProducto). 

Vista detalle con descripción, precios, control de cantidad y opción de agregar al carrito. 

🛒 Carrito de compras
Carrito persistido en localStorage, con agregar, remover y actualizar cantidades. 

Vista del carrito con tabla de productos, subtotales y botón para proceder al pago. 

Dropdown rápido del carrito desde la navbar. 

💳 Flujo de pago y confirmación
Construcción de pedido (/api/pedidos) y llamada a pasarela (/api/pagos/iniciar). 

Pantalla de confirmación con redirección automática y opciones a historial o continuar comprando. 

📦 Historial de pedidos
Página de historial consumiendo /api/pedidos, mostrando estado, fecha, productos y total. 

🔐 Autenticación y roles
Login con /auth/login que guarda tokens y rol en localStorage. 

Registro de clientes vía /api/clientes. 

Sidebar de login/registro embebida en el layout con validación de contraseña y feedback tipo snackbar. 

Rutas admin protegidas por rol ADMIN. 

🧑‍💼 Admin: productos y usuarios
Panel para editar y eliminar productos (con edición masiva). 

Formulario para crear productos incluyendo subida de imagen (/api/upload). 

Alta de administradores vía /api/usuarios/admin. 

4) Endpoints consumidos desde el frontend
Estos son los endpoints inferidos por el cliente:

POST /auth/login → autenticación y tokens. 

POST /api/clientes → registro de clientes. 

GET /api/productos → catálogo. 

GET /api/productos/:id → detalle de producto. 

POST /api/productos → crear producto. 

PUT /api/productos/:id → actualizar producto. 

DELETE /api/productos/:id → borrar producto. 

POST /api/upload → subir imagen. 

POST /api/pedidos → crear pedido. 

GET /api/pedidos → historial. 

POST /api/pagos/iniciar → iniciar pasarela de pago. 

POST /api/usuarios/admin → crear administrador. 

5) Estado y manejo de sesión
AuthContext mantiene el usuario y tokens en localStorage y expone login/logout/updateUser. 

CartContext persiste el carrito en localStorage. 

fetchAuth añade automáticamente el token al header Authorization. 

fetchWithAuth intenta refrescar tokens si hay 401. 

6) Configuración y variables de entorno
Backend (Spring Boot)
Variables esperadas:

SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD

SPRING_JPA_HIBERNATE_DDL_AUTO

JWT_SECRET

PORT (opcional)

Además, se declara configuración para CORS y un placeholder para pasarela. 

Frontend
VITE_API_URL usado como base del backend.

7) Tecnologías utilizadas
Frontend

React 19, React Router, Vite, React Icons, Axios. 

Backend

Spring Boot 3.4.5, Spring Web, JPA, Security, Validation.

JWT, MySQL Connector, MapStruct, Lombok, ModelMapper. 

8) Infraestructura y despliegue
Dockerfile para construir y ejecutar el JAR de Spring Boot. 

compose.yaml con servicios de MySQL y PostgreSQL (ambos definidos). 

9) Estructura funcional del frontend (rutas principales)
Ruta	Función
/	Catálogo
/producto/:id	Detalle
/cart	Carrito
/payment	Pago
/confirm	Confirmación
/orders	Historial
/login	Login
/register	Registro
/admin/productos	Admin (gestión)
/admin/productos/nuevo	Crear producto
/admin/admins/new	Alta admin
Todas estas rutas están definidas en el enrutador principal. 

10) Scripts del frontend
npm run dev → desarrollo con Vite

npm run build → build de producción

npm run start → servir build con serve
