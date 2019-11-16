package com.goluchowski.jaroslaw.pracainzynierskabackend.service;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Druzyny;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.PunktyNaSpotkanie;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Spotkania;
import com.goluchowski.jaroslaw.pracainzynierskabackend.repository.*;
import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.DruzynyInfo;
import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.SpotkaniaInfo;
import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.SpotkanieDetails;
import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.Tabela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultService {

    @Autowired
    private DruzynyRepository druzynyRepository;

    @Autowired
    private SiatkarzeRepository siatkarzeRepository;

    @Autowired
    private TrenerzyRepository trenerzyRepository;

    @Autowired
    private SpotkaniaRepository spotkaniaRepository;

    @Autowired
    private MiastaRepository miastaRepository;

    @Autowired
    private PunktyNaSpotkanieRepository punktyNaSpotkanieRepository;

    @Transactional
    public List<DruzynyInfo> wyswietlDruzyny() {
        List<Druzyny> wszystkieDruzyny = druzynyRepository.findAll();
        List<DruzynyInfo> respone = new ArrayList<>();

        wszystkieDruzyny.forEach(druzyna -> {
            DruzynyInfo info = new DruzynyInfo();
            info.setNazwa_druzyny(druzyna.getNazwa());
            info.setData_zalozenia(druzyna.getData_zalozenia());
            info.setLogo(druzyna.getLogo());
            info.setZdjecie_druzynowe(druzyna.getZdjecie_druzynowe());
            info.setNazwa_miasta(druzyna.getMiasto().getNazwa());
            info.setImie_trenera(druzyna.getTrener().getImie());
            info.setNazwisko_trenera(druzyna.getTrener().getNazwisko());
            info.setLista_siatkarzy(siatkarzeRepository.findAllByDruzyna(druzyna));
            respone.add(info);
        });
        return respone;
    }

    @Transactional
    public List<Tabela> wyswietlTabele() {
        List<Druzyny> wszystkieDruzyny = druzynyRepository.findAll();
        List<Tabela> response = new ArrayList<>();

        wszystkieDruzyny.forEach(druzyna -> {
            Tabela tabela = new Tabela();
            int wygrane_gospodarz = 0;
            int wygrane_gosc = 0;
            tabela.setNazwa_druzyny(druzyna.getNazwa());
            List<Spotkania> wszystkieSpotkaniaDruzyny = spotkaniaRepository.findAllByGoscOrGospodarz(druzyna, druzyna);
            tabela.setMecze_rozegrane(wszystkieSpotkaniaDruzyny.size());
            wygrane_gospodarz = (int) wszystkieSpotkaniaDruzyny.stream().filter(spotkanie -> spotkanie.getGospodarz() == druzyna && spotkanie.getSety_gospodarze() > spotkanie.getSety_goscie()).count();
            wygrane_gosc = (int) wszystkieSpotkaniaDruzyny.stream().filter(spotkanie -> spotkanie.getGosc() == druzyna && spotkanie.getSety_goscie() > spotkanie.getSety_gospodarze()).count();
            int mecze_wygrane = wygrane_gospodarz + wygrane_gosc;
            tabela.setPunkty(mecze_wygrane*3);
            tabela.setMecze_wygrane(mecze_wygrane);
            tabela.setMecze_przegrane(wszystkieSpotkaniaDruzyny.size() - mecze_wygrane);
            response.add(tabela);
        });
        return response;
    }

    @Transactional
    public List<SpotkaniaInfo> wyswietlSpotkania() {
        List<Spotkania> wszystkieSpotkania = spotkaniaRepository.findAll();
        List<SpotkaniaInfo> response = new ArrayList<>();
        List<SpotkanieDetails> spotkanieDetails = new ArrayList<>();
        wszystkieSpotkania.forEach(spotkanie -> {
            SpotkaniaInfo spotkaniaInfo = new SpotkaniaInfo();
            spotkaniaInfo.setData_spotkania(spotkanie.getData());
            spotkaniaInfo.setNazwa_miasta(spotkanie.getMiasto_spotkania().getNazwa());
            spotkaniaInfo.setImie_sedziego(spotkanie.getSedzia_spotkania().getImie());
            spotkaniaInfo.setNazwisko_sedziego(spotkanie.getSedzia_spotkania().getNazwisko());
            spotkaniaInfo.setNazwa_gosca(spotkanie.getGosc().getNazwa());
            spotkaniaInfo.setNazwa_gospodarza(spotkanie.getGospodarz().getNazwa());
            spotkaniaInfo.setSety_goscie(spotkanie.getSety_goscie());
            spotkaniaInfo.setSety_gospodarze(spotkanie.getSety_gospodarze());
            List<PunktyNaSpotkanie> allBySpotkanie = punktyNaSpotkanieRepository.findAllBySpotkanie(spotkanie);
            allBySpotkanie.forEach(p -> {
                SpotkanieDetails details = new SpotkanieDetails();
                details.setImie_siatkarza(p.getSiatkarz().getImie());
                details.setNazwisko_siatkarza(p.getSiatkarz().getNazwisko());
                details.setNazwa_druzyny(p.getSiatkarz().getDruzyna().getNazwa());
                details.setPunkty(p.getPunkty());
                spotkanieDetails.add(details);
            });
            spotkaniaInfo.setSzczegoly(spotkanieDetails);
            response.add(spotkaniaInfo);
        });
        return response;
    }

}
