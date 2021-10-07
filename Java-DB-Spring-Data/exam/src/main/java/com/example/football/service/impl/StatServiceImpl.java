package com.example.football.service.impl;

import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Positive;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    public static final String STAT_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XMLParser xmlParser;
    private final StatRepository statRepository;

    public StatServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, XMLParser xmlParser, StatRepository statRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.statRepository = statRepository;
    }


    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {

        return Files.readString(Path.of(STAT_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        StatSeedRootDto statSeedRootDto = xmlParser.fromFIle
                (STAT_FILE_PATH, StatSeedRootDto.class);

       statSeedRootDto.
                getStat()
                .stream()
                .filter(statSeedDto -> {

                   boolean isValid = validationUtil.isValid(statSeedDto)
                           && !isStatExist(statSeedDto.getEndurance(), statSeedDto.getShooting(), statSeedDto.getPassing());
                    sb.append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                            statSeedDto.getPassing(),
                            statSeedDto.getShooting(),
                            statSeedDto.getEndurance()) :
                    "Invalid Stat").append(System.lineSeparator());

                    return isValid;
                })
                .map(o -> modelMapper.map(o, Stat.class))
                .forEach(statRepository::save);


        return sb.toString();
    }

    @Override
    public Stat getStatById(Long id) {

        return statRepository.findById(id).orElse(null);
    }

    private boolean isStatExist(double endurance, @Positive Double shooting, @Positive Double passing) {

       Stat stat = statRepository.findByEndurance(endurance);

       if (stat != null && stat.getShooting().equals(shooting) && stat.getPassing().equals(passing)){
           return true;
       }

       return false;
    }

}
