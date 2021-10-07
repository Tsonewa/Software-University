package com.example.cardealercheck.service;

import com.example.cardealercheck.model.dto.LocalSuppliersDto;
import com.example.cardealercheck.model.entity.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    void seedData() throws IOException;
    Supplier getRandomSupplier();

    List<LocalSuppliersDto> getLocalSuppliers();

}
