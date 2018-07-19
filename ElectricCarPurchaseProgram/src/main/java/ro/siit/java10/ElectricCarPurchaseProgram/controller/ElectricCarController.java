package ro.siit.java10.ElectricCarPurchaseProgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.CarDealership;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.DatabaseElement;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.customexeptions.ElectricCarNotNewExeption;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.customexeptions.GreenBonusException;
import ro.siit.java10.ElectricCarPurchaseProgram.domain.customexeptions.NotInStockException;
import ro.siit.java10.ElectricCarPurchaseProgram.service.ElectricCarService;

import java.util.List;

@Controller
public class ElectricCarController {
    @Autowired
    private ElectricCarService electricCarService;

    @Autowired
    private CarDealership carDealership;

    @RequestMapping(value = "/electriccars", method = RequestMethod.GET)
    public String listMainPage() {
        return "listElectricCars";
    }

    @RequestMapping(value = "/allCars", method = RequestMethod.GET)
    public String listResults(@RequestParam(value = "sort", required = false, defaultValue = "byManufacturer ")
                                      String sortCriteria,
                              Model model, @RequestParam(value = "filter", required = false, defaultValue = "(1=1) ")
                                      String... filterCriteria) {
        String sql = "SELECT * FROM electriccars WHERE (1 = 1)";
        for (String criteria : filterCriteria) {
            sql += selectFilteringField(criteria);
        }

        sql += "ORDER By " + selectSortingField(sortCriteria);

        List<DatabaseElement> electricCars = electricCarService.getAll(sql);
        model.addAttribute("electricCars", electricCars);
        model.addAttribute("sort", sortCriteria);

        return "listAllCars";
    }

    @RequestMapping(value = "/checkGB", method = RequestMethod.GET)
    public String checkGreenBonus(@RequestParam(value = "identity") int identity, Model model) {
        DatabaseElement element = electricCarService.getById(identity);
        String message;
        try {
            message = carDealership.checkIfGBAvailableForThisCar(element);
        } catch (NotInStockException | GreenBonusException | ElectricCarNotNewExeption e) {
            message = e.getMessage();
        }
        model.addAttribute("message", message);
        return "greenBonusStatus";
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
            case "model=i3":
                return "AND \"model\"='i3' ";
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

    @RequestMapping(value = "/carsIdentity/{identity}", method = RequestMethod.GET)
    public String getById(int identity, Model model) {
        DatabaseElement electricCar = electricCarService.getById(identity);
        model.addAttribute("selectedCar", electricCar);
        return "carsIdentity ";
    }
}


