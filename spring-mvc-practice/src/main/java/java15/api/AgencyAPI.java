package java15.api;

import java15.entity.Agency;
import java15.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyAPI {
    private final AgencyService agencyService;

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("agencies", agencyService.getAllAgencies());
        return "/agency-main-page";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newAgency", new Agency());
        return "/new-agency";
    }

    @PostMapping("/saveAgency")
    public String saveAgency(@ModelAttribute("newAgency") Agency agency) {
        agencyService.saveAgency(agency);
        return "redirect:/agencies/getAll";
    }

    @GetMapping("/update/{agencyId}")
    public String update(@PathVariable("agencyId") Long agencyId, Model model) {
        Agency agencyById = agencyService.getAgencyById(agencyId);
        model.addAttribute("agencies", agencyById);
        return "/agency-update";
    }

    @PostMapping("/editUpdate/{agencyId}")
    public String editUpdate(@PathVariable("agencyId") Long agencyId, @ModelAttribute("newAgency") Agency agency) {
        agencyService.updateAgency(agencyId, agency);
        return "redirect:/agencies/getAll";
    }

    @PostMapping("/delete/{agencyId}")
    public String delete(@PathVariable("agencyId") Long agencyId) {
        agencyService.deleteAgency(agencyId);
        return "redirect:/agencies/getAll";
    }
}
