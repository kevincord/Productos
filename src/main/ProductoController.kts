import org.springframework.stereotype.Service

@Service
class ProductoService {

    private val productos = mutableListOf<Producto>()

    fun listarProductos(): List<Producto> {
        return productos.toList()
    }

    fun obtenerProducto(id: Int): Producto {
        return productos.firstOrNull { it.id == id }
                ?: throw NoSuchElementException("No se encontró ningún producto con el ID: $id")
    }

    fun crearProducto(producto: Producto): Producto {
        if (productos.any { it.id == producto.id }) {
            throw IllegalArgumentException("Ya existe un producto con el ID: ${producto.id}")
        }
        productos.add(producto)
        return producto
    }

    fun actualizarProducto(id: Int, productoActualizado: Producto): Producto {
        val productoExistente = obtenerProducto(id)
        productos.replaceAll {
            if (it.id == id) productoActualizado else it
        }
        return productoActualizado
    }

    fun borrarProducto(id: Int) {
        if (!productos.removeIf { it.id == id }) {
            throw NoSuchElementException("No se encontró ningún producto con el ID: $id")
        }
    }
}
