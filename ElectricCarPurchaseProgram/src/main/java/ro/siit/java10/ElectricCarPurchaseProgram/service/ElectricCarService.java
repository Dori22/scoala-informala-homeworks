package ro.siit.java10.ElectricCarPurchaseProgram.service;

import ro.siit.java10.ElectricCarPurchaseProgram.domain.DatabaseElement;

import java.security.Identity;
import java.util.List;

public interface ElectricCarService {
    List<DatabaseElement> getAll(String sql);

    DatabaseElement getById(int identity);
}
