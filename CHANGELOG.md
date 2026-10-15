## [TP4: Comparación de Objetos y Herencia] 13/10/2026

### [Sección 1]: Comparación de Objetos

#### Cambios Implementados:
- `src/productos/modelos/Producto.java`:
  - Redefinición de `equals(Object o)` comparando por atributo primitivo `codigo` (int).
  - Redefinición de `hashCode()` consistente con el uso de `codigo` en `equals(Object o)`.
- `src/pedidos/modelos/Pedido.java`:
  - Redefinición de `equals(Object o)` comparando por atributo primitivo `numero` (int).
  - Redefinición de `hashCode()` consistente con el uso de `numero` en `equals(Object o)`.
- `src/pedidos/modelos/ProductoDelPedido.java`:
  - Redefinición de `equals(Object o)` comparando mediante `this.producto.equals(...)`.
  - Redefinición de `hashCode()`.
  - Sobrescritura de `toString()` retornando la descripción y cantidad solicitadas.
- `src/principal/controladores/ControladorPrincipalTP4Seccion1.java`:
  - Control de inserción en listas mediante `contains()` y visualización por consola.

---

### [Sección 2]: Implementación de Herencia

#### Cambios Implementados:
- `src/usuarios/modelos/Usuario.java`:
  - Creación de la clase abstracta `Usuario` con atributos encapsulados `correo`, `clave`, `apellido`, `nombre`.
  - Implementación del patrón *Template Method* en `mostrar()` apoyado en `verTipoUsuario()`.
    (https://www.geeksforgeeks.org/system-design/template-method-design-pattern/)
  - Redefinición centralizada de `equals(Object o)` y `hashCode()` sobre el atributo `correo`, garantizando simetría y unicidad entre todas las subclases.
- `src/usuarios/modelos/Cliente.java`:
  - Herencia de `Usuario`.
  - Conservación exclusiva de la relación con pedidos.
- `src/usuarios/modelos/Empleado.java` y `src/usuarios/modelos/Encargado.java`:
  - Herencia de `Usuario`.
  - Eliminación de atributos y métodos repetidos.
- `src/principal/controladores/ControladorPrincipalTP4Seccion2.java`:
  - Pruebas de unicidad de correos y filtrado por tipo de usuario (`instanceof Cliente` / `instanceof Empleado`).

---

### [Sección 3]: Pedidos de un Usuario

#### Cambios Implementados:
- `src/usuarios/modelos/Usuario.java`:
  - Declaración del método abstracto `verPedidos()`.
  - Limpieza de atributos para que la colección de pedidos resida únicamente en las clases que lo requieran.
- `src/usuarios/modelos/Cliente.java`:
  - Atributo privado `pedidos`.
  - Implementación de `verPedidos()`.
  - Implementación de `agregarPedido(Pedido)` utilizando búsqueda por posición (`indexOf` / iteración) para reemplazar instancias existentes coincidentes en número.
  - Implementación de `cancelarPedido(Pedido)` usando eliminación por equivalencia (`remove`).
- `src/usuarios/modelos/Empleado.java` y `src/usuarios/modelos/Encargado.java`:
  - Implementación concreta de `verPedidos()` retornando lista vacía.
- `src/pedidos/modelos/Pedido.java`:
  - Corrección de error en `equals()` que causaba no reflexibidad (`A.equals(A)` retornaba falso).
  - Ajuste de formato en `mostrar()` para alinear la salida segun lo pedido.
- `src/principal/controladores/ControladorPrincipalTP4Seccion3.java`:
  - Conversión de tipos al vincular usuarios con pedidos.
  - Verificación de duplicados cruzados (`cliente5`, `encargado5`, `unEmpleado5`).
  - Listado clasificado de usuarios.
  - Prueba de adición sin duplicación y cancelación de pedidos en cliente.

---
