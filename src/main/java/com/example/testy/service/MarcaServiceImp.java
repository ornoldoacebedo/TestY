package com.example.testy.service;

import com.example.testy.entity.Marca;
import com.example.testy.dao.IMarcaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImp implements IMarcaService {
    @Autowired
    private IMarcaDao trademarkDao;


    @Override
    public Marca save(Marca trademark) {
        return (Marca) trademarkDao.save(trademark);
    }

    @Override
    public List<Marca> listar() {
        return (List<Marca>) trademarkDao.findAll();
    }

    @Override
    public Marca updateTrademark(Marca trademark) {
        return (Marca) trademarkDao.save(trademark);
    }

    @Override
    public void disableTrademark(Marca trademark) {
        trademarkDao.save(trademark);

    }
/*
    @Override
    public Marca findTradeMark(Marca trademark) {
        return null;
    }

 */

    @Override
    public Marca findTradeMarkById(Long id) {
        return trademarkDao.findById(id).orElse(null);
    }


}
