package com.bsg.data.extractor.services;

import java.util.List;

import com.bsg.data.extractor.domain.BankProduct;

public interface BsgProductService {

    BankProduct getBankProduct(Integer id);

    List<BankProduct> listBankProducts();
}
