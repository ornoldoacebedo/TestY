package com.example.testy.service;

import com.example.testy.dao.IProductoDao;
import com.example.testy.dao.IPuntoDeVentaProductoDAO;
import com.example.testy.entity.Producto;
import com.example.testy.entity.PuntoDeVenta;
import com.example.testy.entity.PuntoDeVentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoDao productDao;

    //Probando usar otra interface DAO en mi service

    @Autowired
    private IPuntoDeVentaProductoDAO pointSaleProduct;
    @Override
    public Producto createProduct(Producto product) {

        return productDao.save(product);
    }

    @Override
    public Producto updateProduct(Producto product) {
        return productDao.save(product);
    }

    @Override
    public List<Producto> lis() {
        return (List<Producto>) productDao.findAll();
    }

    @Override
    public List<Producto> findProductByPointID(List<PuntoDeVenta> puntosDeVenta) {
        //lista de todos los productos por el id de un punto de venta
        List<PuntoDeVentaProducto> puntoDeVentaProductos = new ArrayList<>();
        // pointSaleProduct.findPuntoDeVentaProductoByPuntoDeVentaId(id);
        List<Producto> productos = new ArrayList<>();
        //Aqui tengo una listo de todos los puntos de venta de una compañia
        for (PuntoDeVenta punto:puntosDeVenta) {
            puntoDeVentaProductos =  pointSaleProduct.findPuntoDeVentaProductoByPuntoDeVentaId(punto.getId());
            for (PuntoDeVentaProducto producto: puntoDeVentaProductos) {
                productos.addAll(productDao.findAllByPuntoDeVentaProducto(producto));
            }
        }
        return productos;
    }

    /*
        @Override
    public List<Producto> findProductByPointID(Long id) {
        List<PuntoDeVentaProducto> puntoDeVentaProductos =  pointSaleProduct.findPuntoDeVentaProductoByPuntoDeVentaId(id);
        System.out.println("Desde el service findPuntoDeVentaProductoByPuntoDeVentaId"+puntoDeVentaProductos);
        List<Producto> productos = new ArrayList<>();

        for (PuntoDeVentaProducto producto: puntoDeVentaProductos) {
            System.out.println("Desde el service el for"+productDao.findAllByPuntoDeVentaProducto(producto));
            productos.addAll(productDao.findAllByPuntoDeVentaProducto(producto));
        }
        return productos;
    }
     */


/*
    @Override
    public List<Producto> findProductoBy(Long id) {
        return productDao.findProductoBy(id);
    }

 */



    @Override
    public Producto findProductID(Long id) {
        return productDao.findById(id).orElse(null);
    }


}
