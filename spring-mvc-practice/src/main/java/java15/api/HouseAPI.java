package java15.api;

import java15.entity.Agency;
import java15.entity.House;
import java15.service.AgencyService;
import java15.service.HouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
@Slf4j
public class HouseAPI {
    private final HouseService houseService;
    private final AgencyService agencyService;

    @GetMapping("/getAll")
    public String getAllHouses(Model model) {
        model.addAttribute("houses", houseService.getAllHouses());
        return "/house-main-page";
    }

    @GetMapping("/create/{agencyId}")
    public String createHouse(@PathVariable Long agencyId, Model model) {
        Agency agencyById = agencyService.getAgencyById(agencyId);
        model.addAttribute("newHouse", new House());
        model.addAttribute("agency", agencyById);
        return "new-house";
    }

    @PostMapping("/saveHouse/{agencyId}")
    public String saveHouse(@PathVariable("agencyId") Long agencyId, @ModelAttribute("newHouse") House newHouse) {
        Agency agency = agencyService.getAgencyById(agencyId);
        houseService.saveHouse(agency.getId(), newHouse);
        return "redirect:/houses/getAll";
    }

    @GetMapping("/findBYId/{agencyId}")
    public String findHouseById(@PathVariable("agencyId") Long agencyId, Model model) {
        Agency agency = agencyService.getAgencyById(agencyId);
        model.addAttribute("agency", agency);
        model.addAttribute("houses", agency.getHouse());
        log.info("Houses: {}", agency.getHouse());
        return "/findHouse";
    }
}
