package ro.siit.java10.ElectricCarPurchaseProgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.DatabaseElement;
import ro.siit.java10.ElectricCarPurchaseProgram.service.ElectricCarService;

import java.util.List;

@Controller
public class ElectricCarController {
    @Autowired
    private ElectricCarService electricCarService;

    @RequestMapping(value = "/electriccars", method = RequestMethod.GET)
    public String listElectricCars(@RequestParam(value = "sort", required = false, defaultValue = "byManufacturer ")
                                           String sortCriteria,
                                   Model model, @RequestParam(value = "filter", required = false, defaultValue = "(1=1) ")
                                           String... filterCriteria) {
        String sql = "SELECT * FROM electriccars ";
        sql += "WHERE (1=1) ";
        for (String criteria : filterCriteria) {
            sql += selectFilteringField(criteria);
        }

        sql += "ORDER By " + selectSortingField(sortCriteria);

        List<DatabaseElement> electricCars = electricCarService.getAll(sql);
        model.addAttribute("electricCars", electricCars);
        model.addAttribute("sort", sortCriteria);

        return "listElectricCars";
    }

    private String selectFilteringField(String filterCriteria) {

        switch (filterCriteria) {


            case "manufacturer=Honda":
                return "AND \"manufacturer\"='Honda' ";
            case "manufacturer=BMW":
                return "AND \"manufacturer\"='BMW' ";
            case "manufacturer=Hyundai":
                return "AND \"manufacturer\"='Hyundai' ";
            case "manufacturer=Kia":
                return "AND \"manufacturer\"='Kia' ";
            case "manufacturer=Renault":
                return "AND \"manufacturer\"='Renault' ";
            case "manufacturer=Smart":
                return "AND \"manufacturer\"='Smart' ";
            case "manufacturer=Volkswagen":
                return "AND \"manufacturer\"='Volkswagen' ";
            case "fastCharging=true":
                return "AND \"fastCharging\"=true ";
            case "fastCharging=false":
                return "AND \"fastCharging\"=false ";
            case "isNew=true":
                return "AND\"isNew\"=true ";
            case "isNew=false":
                return "AND\"isNew\"=false ";
            default:
                return "AND 1=1 ";

        }
    }

    private String selectSortingField(String sortCriteria) {
        switch (sortCriteria) {
            case "byManufacturer":
                return "manufacturer ";
            case "byPriceAsc":
                return "price ";
            case "byPriceDesc":
                return "price DESC ";
            case "byRangePerCharge":
                return "\"rangePerCharge\" Desc";
            case "byConsumptionDesc":
                return "consumption Desc";
            case "byConsumptionAsc":
                return "consumption Asc";
            default:
                return "manufacturer ";


        }
    }


}


