package com.bsg.data.extractor.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bsg.data.extractor.domain.BsgDomain;
import com.bsg.data.extractor.domain.BankProduct;
import com.bsg.data.extractor.domain.BankProductCategory;
import com.bsg.data.extractor.services.BsgProductService;

@Service
public class BankProductServiceImpl implements BsgProductService {

    private Map<Integer, BankProduct> bankProductMap;

    public BankProductServiceImpl() {
        loadBankProducts();
    }

    @Override
    public BankProduct getBankProduct(Integer id) {
        return bankProductMap.get(id);
    }

    @Override
    public List<BankProduct> listBankProducts() {
        return new ArrayList<>(bankProductMap.values());
    }

    private void loadBankProducts() {
        BsgDomain bank01 = new BsgDomain();
        bank01.setBankName("bank01");
        bank01.setBankLocationName("location01");
        bank01.setId(1);
        bank01.setImage("01.jpg");

        BankProductCategory bankProductCategory01 = new BankProductCategory();
        bankProductCategory01.setId(1);
        bankProductCategory01.setBankProductCategory("01");

        BankProductCategory bankProductCategory02 = new BankProductCategory();
        bankProductCategory02.setId(2);
        bankProductCategory02.setBankProductCategory("02");

        bankProductMap = new HashMap<>();

        BankProduct bankProduct01 = new BankProduct();
        bankProduct01.setId(1);
        bankProduct01.setBankProductName("BankProductName01");
        bankProduct01.setBankProductValue("BankProductValue01");
        bankProduct01.setBank(bank01);
        bankProduct01.setBankProductDescription("");
        bankProduct01.setPrice(new BigDecimal("0"));
        bankProduct01.setImageUrl("07.jpg");
        bankProduct01.getBankProductCategories().add(bankProductCategory01);
        bankProduct01.getBankProductCategories().add(bankProductCategory02);
        bankProductMap.put(1, bankProduct01);
    }
}
