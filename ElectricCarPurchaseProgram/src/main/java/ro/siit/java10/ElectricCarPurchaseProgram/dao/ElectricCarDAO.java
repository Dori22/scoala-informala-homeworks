package ro.siit.java10.ElectricCarPurchaseProgram.dao;

import ro.siit.java10.ElectricCarPurchaseProgram.domain.DatabaseElement;

import java.util.List;

public interface ElectricCarDAO {
    List<DatabaseElement> getAll(String sql);
}
