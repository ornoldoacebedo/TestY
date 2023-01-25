package com.example.testy.service;


import com.example.testy.entity.Marca;

import java.util.List;
import java.util.Optional;

public interface IMarcaService {
    public Marca save(Marca trademark);

    public List<Marca> listar();

    public Marca updateTrademark(Marca trademark);

    public void disableTrademark(Marca trademark);

   // public Marca findTradeMark(Marca trademark);

    public Marca findTradeMarkById(Long id);


}
