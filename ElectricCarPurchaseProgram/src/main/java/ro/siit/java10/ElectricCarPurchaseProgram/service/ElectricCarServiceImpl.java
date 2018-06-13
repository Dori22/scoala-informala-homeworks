package ro.siit.java10.ElectricCarPurchaseProgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.java10.ElectricCarPurchaseProgram.dao.ElectricCarDAO;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.DatabaseElement;

import java.util.List;

@Service
public class ElectricCarServiceImpl implements ElectricCarService {
    @Autowired
    // se uita in ApplicationConfiguration si cauta(dupa tip) un bean corespunzator
    private ElectricCarDAO electricCarDAO;

    @Override
    public List<DatabaseElement> getAll(String sql) {
        return electricCarDAO.getAll(sql);
    }
}
