package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.*;
import com.goluchowski.jaroslaw.pracainzynierskabackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class HtmlController {

    @Autowired
    TrenerzyRepository trenerzyRepository;

    @Autowired
    MiastaRepository miastaRepository;

    @Autowired
    DruzynyRepository druzynyRepository;

    @Autowired
    SezonyRepository sezonyRepository;

    @Autowired
    SiatkarzeRepository siatkarzeRepository;

    @Autowired
    SedziowieRepository sedziowieRepository;

    @Autowired
    SpotkaniaRepository spotkaniaRepository;

    @Autowired
    PunktyNaSpotkanieRepository punktyNaSpotkanieRepository;

    @GetMapping("/admin/addTrainer")
    public String sendTrainerForm(@ModelAttribute("trener") Trenerzy trener) {
        return "/addTrainer";
    }

    @PostMapping("/admin/addTrainer")
    @Transactional
    public String processTrainerForm(@ModelAttribute("trener") Trenerzy trener, RedirectAttributes redirectAttributes ) {
        trenerzyRepository.save(trener);
        redirectAttributes.addFlashAttribute("trenerDodany", "true");
        return "redirect:/admin/addTrainer";
    }

    @GetMapping("/admin/addSedzia")
    public String sendSedziarForm(@ModelAttribute("sedzia") Sedziowie sedzia) {
        return "/addSedzia";
    }

    @PostMapping("/admin/addSedzia")
    @Transactional
    public String processSedziaForm(@ModelAttribute("trener") Sedziowie sedzia, RedirectAttributes redirectAttributes ) {
        sedziowieRepository.save(sedzia);
        redirectAttributes.addFlashAttribute("sedziaDodany", "true");
        return "redirect:/admin/addSedzia";
    }

    @GetMapping("/admin/addTeam")
    public String sendTeamForm(@ModelAttribute("druzyna") Druzyny druzyna,
                               @ModelAttribute("reszta") TrenerMiastoString reszta) {
        return "/addTeam";
    }

    @PostMapping("/admin/addTeam")
    @Transactional
    public String processTeamForm(@ModelAttribute("druzyna") Druzyny druzyna,
                                  @ModelAttribute("reszta") TrenerMiastoString reszta,
                                    @RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes) throws IOException {
        Trenerzy trenerzy = trenerzyRepository.findByNazwisko(reszta.getNazwiskoTrenera());
        Miasta miasta = miastaRepository.findByNazwa(reszta.getNazwaMiasta());
        druzyna.setTrener(trenerzy);
        druzyna.setMiasto(miasta);
        druzyna.setLogo(file.getBytes());
        druzynyRepository.save(druzyna);
        redirectAttributes.addFlashAttribute("druzynaDodana", "true");
        return "redirect:/admin/addTeam";
    }

    @GetMapping("/admin/addPunkty")
    public String sendPunktyForm() {
        return "/addPunkty";
    }

    @PostMapping("/admin/addPunkty")
    @Transactional
    public String processPunktyForm(@RequestParam("gospodarz") String gospodarz,@RequestParam("gosc") String gosc,
                                    @RequestParam("zawodnik") String zawodnik, @RequestParam("punkty") String punkty,
                                  RedirectAttributes redirectAttributes) {
        PunktyNaSpotkanie punktyNaSpotkanie = new PunktyNaSpotkanie();
        Druzyny gosp = druzynyRepository.findByNazwa(gospodarz);
        Druzyny gos = druzynyRepository.findByNazwa(gosc);
        punktyNaSpotkanie.setSiatkarz(siatkarzeRepository.findByNazwisko(zawodnik));
        punktyNaSpotkanie.setSpotkanie(spotkaniaRepository.findByGospodarzAndGosc(gosp, gos));
        punktyNaSpotkanie.setPunkty(Integer.valueOf(punkty));
        punktyNaSpotkanieRepository.save(punktyNaSpotkanie);
        redirectAttributes.addFlashAttribute("punktyDodane", "true");
        return "redirect:/admin/addPunkty";
    }

    @GetMapping("/admin/addSezon")
    public String getSezonForm() {
        return "/addSezon";
    }

    @PostMapping("/admin/addSezon")
    @Transactional
    public String processSezonForm(@RequestParam("nazwa") String nazwa, RedirectAttributes redirectAttributes)  {
        Sezony sezony = new Sezony();
        sezony.setNazwaSezonu(nazwa);
        sezonyRepository.save(sezony);
        redirectAttributes.addFlashAttribute("sezonDodany", "true");
        return "redirect:/admin/addSezon";
    }

    @GetMapping("/admin/addZawodnik")
    public String getZawodnikForm(@ModelAttribute("zawodnik") Siatkarze zawodnik) {
        return "/addSiatkarz";
    }

    @PostMapping("/admin/addZawodnik")
    @Transactional
    public String processZawodnikForm(@ModelAttribute("zawodnik") Siatkarze zawodnik,
                                      @RequestParam("nazwa_druzyny") String nazwa_druzyny, RedirectAttributes redirectAttributes)  {
        Druzyny byNazwa = druzynyRepository.findByNazwa(nazwa_druzyny);
        zawodnik.setDruzyna(byNazwa);
        siatkarzeRepository.save(zawodnik);
        redirectAttributes.addFlashAttribute("zawodnikDodany", "true");
        return "redirect:/admin/addZawodnik";
    }

    @GetMapping("/admin/addSpotkanie")
    public String getSpotkanieForm() {
        return "/addSpotkanie";
    }

    @PostMapping("/admin/addSpotkanie")
    @Transactional
    public String processSpotkanieForm(@RequestParam("gospodarz") String gospodarz,
                                       @RequestParam("gosc") String gosc,
                                       @RequestParam("data") String data,
                                       @RequestParam("sedzia") String sedzia,
                                       @RequestParam("miasto") String miasto,
                                       @RequestParam("sezon") String sezon,
                                       @RequestParam("gosp_sety") String gosp_sety,
                                       @RequestParam("gosc_sety") String gosc_sety,
                                       RedirectAttributes redirectAttributes)  {
        Spotkania spotkanie = new Spotkania();
        spotkanie.setGospodarz(druzynyRepository.findByNazwa(gospodarz));
        spotkanie.setGosc(druzynyRepository.findByNazwa(gosc));
        spotkanie.setData(Long.valueOf(data));
        spotkanie.setSedzia_spotkania(sedziowieRepository.findByNazwisko(sedzia));
        spotkanie.setMiasto_spotkania(miastaRepository.findByNazwa(miasto));
        spotkanie.setSezon(sezonyRepository.findByNazwaSezonu(sezon));
        spotkanie.setSety_gospodarze(Integer.valueOf(gosp_sety));
        spotkanie.setSety_goscie(Integer.valueOf(gosc_sety));
        spotkaniaRepository.save(spotkanie);
        redirectAttributes.addFlashAttribute("spotkanieDodane", "true");
        return "redirect:/admin/addSpotkanie";
    }

    @GetMapping("/admin/addCity")
    public String sendCityForm(@ModelAttribute("miasto") Miasta miasto) {
        return "/addCity";
    }

    @PostMapping("/admin/addCity")
    @Transactional
    public String processCityForm(@ModelAttribute("miasto") Miasta miasto, RedirectAttributes redirectAttributes) {
        miastaRepository.save(miasto);
        redirectAttributes.addFlashAttribute("miastoDodane", "true");
        return "redirect:/admin/addCity";
    }

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}